package com.gky.nio;

public class A {
	int count;
	public A(int count) {
		// TODO Auto-generated constructor stub
		this.count = count;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		return count;
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
		if (count != other.count)
			return false;
		return true;
	}
}
