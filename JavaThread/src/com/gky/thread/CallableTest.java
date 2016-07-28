package com.gky.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

	static class WorkThread implements Callable<Integer>{

		@Override
		public Integer call() throws Exception {
			// TODO Auto-generated method stub
			// 线程执行体
			int sum = 0;
			for (int i = 1; i <= 100; i++) {
				sum += i;
			}
			return sum;
		}
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		WorkThread workThread = new WorkThread();
		FutureTask<Integer> futureTask = new FutureTask<>(workThread);
		// 将futureTask作为target创建Thread对象并启动线程
		new Thread(futureTask).start();
		// 将阻塞直到线程执行完成并返回结果
		System.out.println(futureTask.get());
	}
}
