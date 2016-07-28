package com.gky.collections;

public class A {
	
	public int id = 0;
	private int id_ex = 0;
	
	public A(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.id_ex = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		A other = (A) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+id_ex+"]"+"-hash:"+hashCode();
	}
	
	
}
