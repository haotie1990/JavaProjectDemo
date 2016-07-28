package com.gky.thread;

public class RunnableTest {

	static class WorkThread implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WorkThread workThread = new WorkThread();
		new Thread(workThread).start();
		new Thread(workThread).start();
	}

}
