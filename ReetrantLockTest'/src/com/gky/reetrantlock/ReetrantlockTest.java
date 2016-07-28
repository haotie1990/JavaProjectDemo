package com.gky.reetrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class ReetrantlockTest {
	
	private ReentrantLock lock = new ReentrantLock();
	
	public void send() {
		lock.tryLock();
	}
	
	public void receive() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
