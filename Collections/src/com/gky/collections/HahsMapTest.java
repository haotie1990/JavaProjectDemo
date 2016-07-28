package com.gky.collections;

import java.util.HashMap;
import java.util.Iterator;

public class HahsMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<A, String> map = new HashMap<>();
		map.put(new A(1), "first");
		map.put(new A(2), "second");
		map.put(new A(3), "third");
		System.out.println(map);
		Iterator it = map.keySet().iterator();
		A first = (A) it.next();
		System.out.println("first:"+first.id);
		first.id = 2;
		System.out.println(map);
		System.out.println(map.remove(new A(1)));
		System.out.println(map);
		System.out.println(map.remove(new A(2)));
		System.out.println(map);
		System.out.println(map.get(new A(1)));
		System.out.println(map.get(new A(3)));
		//HashMap一旦将数据放入，其存储位置由初始的hashCode计算得到，其位置都不会再改变，即便后续改变了其hashCode值
	}

}
