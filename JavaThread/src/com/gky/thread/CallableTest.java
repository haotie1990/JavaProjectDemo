package com.gky.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

	static class WorkThread implements Callable<Integer>{

		@Override
		public Integer call() throws Exception {
			// TODO Auto-generated method stub
			// �߳�ִ����
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
		// ��futureTask��Ϊtarget����Thread���������߳�
		new Thread(futureTask).start();
		// ������ֱ���߳�ִ����ɲ����ؽ��
		System.out.println(futureTask.get());
	}
}
