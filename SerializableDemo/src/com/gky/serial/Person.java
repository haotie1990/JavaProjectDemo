package com.gky.serial;

import java.io.Serializable;

public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2608353581863576951L;

	public String name;
	
	public int age;
	
	public boolean isMale;
	
	public int heigth;
	
	public int weight;

	public Person(String name, int age, boolean isMale) {
		this.name = name;
		this.age = age;
		this.isMale = isMale;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+"/"+age+"/"+(isMale?"man":"woman");
	}
}
