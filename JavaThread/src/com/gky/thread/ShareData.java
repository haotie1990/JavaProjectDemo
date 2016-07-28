package com.gky.thread;

import java.util.ArrayList;

public class ShareData {
	
	ArrayList<String> list = new ArrayList<>();

	public synchronized char getData(){
		try {
			if(!flag){
				System.out.println("���ݻ�δ���룡");
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
				System.out.println("���ݻ�δȡ����");
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
