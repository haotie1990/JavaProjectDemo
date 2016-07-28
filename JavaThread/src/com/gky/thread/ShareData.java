package com.gky.thread;

import java.util.ArrayList;

public class ShareData {
	
	ArrayList<String> list = new ArrayList<>();

	public synchronized char getData(){
		try {
			if(!flag){
				System.out.println("数据还未存入！");
				wait();
			}else{
				flag = false;
				notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public synchronized boolean setData(char data) {
		try {
			if(flag){
				System.out.println("数据还未取出！");
				wait();
				return false;
			}else{
				this.data = data;
				list.add(data+"");
				flag = true;
				notifyAll();
				return true;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public ShareData() {
		// TODO Auto-generated constructor stub
	}

	private  char data;
	
	private  boolean flag = false;
	
	
}
