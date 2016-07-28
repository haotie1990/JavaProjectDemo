package com.gky.thread;

public class ThreadTest {

	static class WorkThread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 100; i++) {
				System.out.println(i);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WorkThread workThread = new WorkThread();
		workThread.start();
	}

}
