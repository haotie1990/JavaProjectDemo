package com.gky.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpServer {
	
	private ExecutorService mExecutorService;
	
	private volatile boolean isLoop = true;
	
	private ServerSocket mServerSocket;
	
	public TcpServer(){
		mExecutorService = Executors.newCachedThreadPool();
	}
	
	public void start(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					System.out.println("服务端已经启动，等待连接");
					mServerSocket = new ServerSocket(30000);
					while (isLoop) {
						Socket sClient = mServerSocket.accept();
						mExecutorService.submit(new HandleThread(sClient));
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	class HandleThread implements Runnable{
		
		private Socket mSocket;
		
		public HandleThread(Socket socket) {
			// TODO Auto-generated constructor stub
			mSocket = socket;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
				String buffer = null;
				while((buffer = reader.readLine()) != null){
					System.out.println(buffer);
				}

//				OutputStream out = mSocket.getOutputStream();
//				out.write(new String("名称：TcpServer").getBytes());
//				out.write(new String("状态：正在运行").getBytes());
				
				//mSocket.close();
				//System.out.println("客户端连接被关闭");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		TcpServer server = new TcpServer();
		server.start();
	}
}
