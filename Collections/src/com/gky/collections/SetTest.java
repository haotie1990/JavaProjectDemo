package com.gky.collections;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	public static void main(String[] args) {
		HashSet hs = new HashSet<>();
		hs.add(new A(1));
		hs.add(new A(2));
		hs.add(new A(3));
		hs.add(new A(4));
		hs.add(new A(5));
		System.out.println(hs);//[[1]-hash:32, [2]-hash:33, [3]-hash:34, [4]-hash:35, [5]-hash:36]
		Iterator it = hs.iterator();
		A first = (A) it.next();
		System.out.println(first.id);//取第一个元素，并且改变其ID，将导致其HashCode也改变，但其存储位置不变
		first.id = 2;//改变其ID，使其HashCode与第二位元素相等
		System.out.println(hs);//[[1]-hash:33, [2]-hash:33, [3]-hash:34, [4]-hash:35, [5]-hash:36]
//		System.out.println(hs.contains(new A(2)));
		hs.remove(new A(2));//通过hashCode计算其存储位置并通过equals方法比较相等，删除第二个元素
		//此时由于第一个元素的位置由ID=1计算得到，但其现在hashCode由ID=2计算得到
		//将导致无论通过new A(1)还是new A(2)都无法定位到第一个元素
		//new A(1)可定位到存储位置但equals方法返回false
		//new A(2)无法定位到存储位置
		System.out.println(hs);//[[1]-hash:33, [3]-hash:34, [4]-hash:35, [5]-hash:36]
		System.out.println(new A(1));
		System.out.println(hs);
		System.out.println(hs.contains(new A(2)));
		System.out.println(hs.contains(new A(5)));
	}
}
