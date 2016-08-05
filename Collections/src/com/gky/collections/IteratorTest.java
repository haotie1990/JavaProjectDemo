package com.gky.collections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			int num = (int) iterator.next();
			if(num == 2){
				list.remove((Integer)num);
			}
		}
		
//		for (Integer num : list) {
//			System.out.println(num);
//		}
		
		//new IteratorTest().forSomething();
	}
	
	public void forSomething() throws NoSuchFieldException, SecurityException{
		ArrayList<String> list = new ArrayList<>();
		list.add("1");
		
		for (String string : list) {
			if(string.equals("1")){
				list.remove(string);
			}
		}
		System.out.println(list);
	}
}
