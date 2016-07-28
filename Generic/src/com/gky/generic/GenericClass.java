package com.gky.generic;

class Father<E> {

	E m_Info;
	
	public Father(E info) {
		super();
		// TODO Auto-generated constructor stub
		m_Info = info;
		System.out.println(m_Info.toString());
	}
	
	public E getInfo() {
		return this.m_Info;
	}
}

public class GenericClass extends Father<String>{

	public GenericClass(String info) {
		super(info);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		System.out.println("111111");
		/*String info = (String) new GenericClass("Generic").getInfo();
		System.out.println(info);*/
	}

}


