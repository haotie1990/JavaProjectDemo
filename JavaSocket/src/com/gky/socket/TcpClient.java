package com.gky.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

	private Socket mSocket;
	
	private int mId;
	
	public TcpClient(int id){
		this.mId = id;
	}
	
	public void start(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					System.out.println("客户端："+mId+"已经启动连接服务器");
					mSocket = new Socket("127.0.0.1", 30000);
					
					new HandleThread(mSocket).start();
					
					OutputStream out = mSocket.getOutputStream();
					out.write(new String("我是客户端"+mId+"请求服务器").getBytes());
								
					//mSocket.close();
					//System.out.println("客户端关闭连接");
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	class HandleThread extends Thread{

		private Socket mSocket;
		
		public HandleThread(Socket socket) {
			// TODO Auto-generated constructor stub
			mSocket = socket;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			BufferedReader reader;
			try {
				reader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
				String buffer = null;
				while((buffer = reader.readLine()) != null){
					System.out.println(buffer);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		TcpClient client1 = new TcpClient(1001);
		client1.start();
		
		TcpClient client2 = new TcpClient(1002);
		client2.start();
	}
}
