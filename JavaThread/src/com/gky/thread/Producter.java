package com.gky.thread;

public class Producter extends Thread{

	private ShareData data;
	
	public Producter(ShareData data) {
		this.data = data;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 65;
		while(i <= 90){
			if(data.setData((char)i)){
				i++;
				System.out.println("Product:"+(char)i);
			}
		}
	}

}
