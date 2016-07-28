package com.gky.single;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7443813530027324910L;

	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	private static class SingletonHolder {
		public static Singleton INSTANCE = new Singleton();
	}
	
	public Singleton getInstance() {
		return SingletonHolder.INSTANCE;
	}

	private Object readResolve() throws ObjectStreamException {
		return SingletonHolder.INSTANCE;
	}
}
