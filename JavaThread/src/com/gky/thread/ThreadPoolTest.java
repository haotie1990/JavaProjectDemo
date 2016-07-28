package com.gky.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
	
	static class WorkRunnable implements Runnable{
		
		int id = -1;
		
		public WorkRunnable(int id) {
			super();
			this.id = id;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("id:"+id);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		//当线程池有空闲线程时执行线程任务
		executor.submit(new WorkRunnable(1001));
		//立刻执行线程任务
		executor.execute(new WorkRunnable(1002));
	}
}
