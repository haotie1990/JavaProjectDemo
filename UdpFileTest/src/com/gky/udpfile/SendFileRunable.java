package com.gky.udpfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class SendFileRunable implements Runnable{
	
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
	
	private String fileName = null;

    private DatagramSocket sendSocket;
    private DatagramSocket receiveSocket;

    public SendFileRunable(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            sendSocket = new DatagramSocket();
            receiveSocket = new DatagramSocket(null);
            receiveSocket.setReuseAddress(true);
            receiveSocket.bind(new InetSocketAddress(5558));
            receiveSocket.setSoTimeout(5000);

            File file = new File(fileName);
            long totalSize = file.length();
            long sendSize = 0;
            if (file.exists()) {

                FileInputStream fileInputStream = new FileInputStream(file);
                int sendSN = 0;
                int receiveSN = 0;
                byte[] data = null;
                int length = 0;
                while (true) {
                	try {
                        if (sendSN == receiveSN) {//初始均为0
                            sendSN++;
                            data = getByteBuffer(NetConst.STTP_LOAD_TYPE_CMD_FILE, sendSN, 1);
                            if ((length = fileInputStream.read(data, DATA_SEGMENT_START_INDEX, DATE_SEGMENT_LENGTH)) > 0) {
                                DatagramPacket sendPacket = new DatagramPacket(data, DATA_PACKET_TITLE_SIZE + length,
                                        InetAddress.getByName(LOCAL_IP), 5557);
                                sendSocket.send(sendPacket);
                                
                                byte[] rData = new byte[DATA_PACKET_SIZE];
                                DatagramPacket receivePacket = new DatagramPacket(rData, rData.length);
                                receiveSocket.receive(receivePacket);
                                receiveSN = (rData[2] & 0xFF) | ((rData[3] & 0xFF) << 8);
                                sendSize += length;
                                System.out.println("已发送： "+((float)((double)sendSize/totalSize))*100+"%");
                            }else {
                            	DatagramPacket sendPacket = new DatagramPacket(data, DATA_PACKET_TITLE_SIZE,
                                        InetAddress.getByName(LOCAL_IP), 5557);
                                sendSocket.send(sendPacket);//发送数据区为0的数据包
                            	System.out.println("发送完成！");
                                break;
                            }
                        }else {
                            DatagramPacket sendPacket = new DatagramPacket(data, DATA_PACKET_TITLE_SIZE + length,
                                    InetAddress.getByName(LOCAL_IP), 5557);
                            sendSocket.send(sendPacket);

                            byte[] rData = new byte[DATA_PACKET_SIZE];
                            DatagramPacket receivePacket = new DatagramPacket(rData, rData.length);
                            receiveSocket.receive(receivePacket);
                            receiveSN = (rData[2] & 0xFF) | ((rData[3] & 0xFF) << 8);
                        }
					}catch (SocketTimeoutException e) {
						e.printStackTrace();
						System.out.println("应答确认阻塞，数据包丢失，超时重传");
						DatagramPacket sendPacket = new DatagramPacket(data, DATA_PACKET_TITLE_SIZE + length,
                                InetAddress.getByName(LOCAL_IP), 5557);
                        sendSocket.send(sendPacket);

                        byte[] rData = new byte[DATA_PACKET_SIZE];
                        DatagramPacket receivePacket = new DatagramPacket(rData, rData.length);
                        receiveSocket.receive(receivePacket);
                        receiveSN = (rData[2] & 0xFF) | ((rData[3] & 0xFF) << 8);
                        
                        sendSize += length;
                        System.out.println("已发送： "+((float)((double)sendSize/totalSize))*100+"%");
					}catch (SocketException e) {
						e.printStackTrace();
					}catch (IOException e) {
						e.printStackTrace();
					}
                }
                fileInputStream.close();
                sendSocket.close();
                receiveSocket.close();
                System.out.println("退出发送,关闭文件流");
            }
        }catch (SocketTimeoutException e) {
        	e.printStackTrace();
        }catch (SocketException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			sendSocket.close();
            receiveSocket.close();
		}
    }
}
