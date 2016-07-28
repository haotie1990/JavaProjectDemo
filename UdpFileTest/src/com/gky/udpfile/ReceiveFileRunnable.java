package com.gky.udpfile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class ReceiveFileRunnable implements Runnable{

	private static final int DATA_PACKET_TITLE_SIZE = 8;
    private static final int DATA_PACKET_SIZE = 1400;
    private static final int DATA_SEGMENT_START_INDEX = 8;
    private static final int DATE_SEGMENT_LENGTH = 1392;
	
	private static final int DEVICE_TYPE_PHONE = 55;
    private static final int DEVICE_TYPE_TV = 56;
    
    private static final String LOCAL_IP = "127.0.0.1";
    
	private int UUIDCounter = 0;
	
	public byte[] getByteBuffer(int load_type, int sn, int receive_flag) {
        byte[] buffer = new byte[1400];

        /*初始化版本*/
        int version = 1 << 6;

        /*初始化设备ID*/
        int deviceId = DEVICE_TYPE_PHONE;
        buffer[0] = Integer.valueOf((version | deviceId)).byteValue();
        buffer[1] = (byte) (Integer.valueOf(load_type & 0x7F).byteValue()
                            | (receive_flag != 0 ? 0x80:0x00));

        /*SN:传输序列*/
        buffer[2] = Integer.valueOf(sn & 0xFF).byteValue();
        buffer[3] = Integer.valueOf((sn >> 8) & 0xFF).byteValue();

        buffer[4] = Integer.valueOf(UUIDCounter != 255?++UUIDCounter:(UUIDCounter-=255)).byteValue();

        return buffer;
    }
	
	private DatagramSocket mSSocket;
    private DatagramSocket mRSocket;

    private String fileName;

    public ReceiveFileRunnable(String fileName) {
    	this.fileName = fileName;
    }

    @Override
    public void run() {

    	File file = new File(fileName);
        FileOutputStream fileOutputStream = null;
        try {
            mSSocket = new DatagramSocket();

            mRSocket = new DatagramSocket(null);
            mRSocket.setReuseAddress(true);
            mRSocket.bind(new InetSocketAddress(5557));
            //mRSocket.setSoTimeout(3000);//接收端不能超时，需要一直阻塞等待数据到来

            byte[] data = new byte[DATA_PACKET_SIZE];
            int length;
            long receiveSize = 0;
            int receiveSn;
            int SN = 1;
            fileOutputStream = new FileOutputStream(file);
            while (true) {
            	
                DatagramPacket receivePacket = new DatagramPacket(data, data.length);
                mRSocket.receive(receivePacket);
                length = receivePacket.getLength() - DATA_PACKET_TITLE_SIZE;
                receiveSize += length;
                if (length > 0) {
                	System.out.println("已经接收的数据大小 : "+receiveSize+"byte");
                    receiveSn = (data[2] & 0xFF) | ((data[3] & 0xFF) << 8);
                    if (receiveSn == SN) {
                        fileOutputStream.write(data, DATA_SEGMENT_START_INDEX, length);
                        SN++;
                        DatagramPacket sendPacket = new DatagramPacket(data,receivePacket.getLength(),
                                InetAddress.getByName(LOCAL_IP),5558);
                        mSSocket.send(sendPacket);
                    }else if (receiveSn < SN) {
                        DatagramPacket sendPacket = new DatagramPacket(data,receivePacket.getLength(),
                                InetAddress.getByName(LOCAL_IP),5558);
                        mSSocket.send(sendPacket);
                    }
                }else {
                	System.out.println("接收完成！");
                    break;
                }
            }
            fileOutputStream.close();
            mSSocket.close();
            mRSocket.close();
            System.out.println("退出接收,关闭文件流");
        } catch (SocketTimeoutException e) {
        	e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        	mSSocket.close();
            mRSocket.close();
        }
    }
}
