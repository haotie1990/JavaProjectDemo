package com.gky.thread;

public class Customer extends Thread{

	ShareData data;
	
	public Customer(ShareData data) {
		this.data = data;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		char ch = 0;
		do{
			ch = data.getData();
			System.out.println("Custome:"+ch);
		}while(ch != 'Z');
	}
	
}
