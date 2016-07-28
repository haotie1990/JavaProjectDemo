package com.gky.udpfile;

public class UDPFileTest {
	
	public static void main(String[] args) {
		SendFileRunable sendFileRunnale = new SendFileRunable("E:\\WeChat1.2.exe");
		new Thread(sendFileRunnale).start();
		ReceiveFileRunnable receiveFileRunnable = new ReceiveFileRunnable("E:\\WeChat1.2_backup.exe");
		new Thread(receiveFileRunnable).start();
	}
}
