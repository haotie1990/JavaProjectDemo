package com.gky.thread;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ShareData data = new ShareData();
		
		new Producter(data).start();
		new Customer(data).start();
		Thread.sleep(500);
		System.out.println(data.list);
	}

}
