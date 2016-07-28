package com.gky.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(2);
		arr.add(2);
		arr.add(3);
		arr.add(54);
		arr.add(2);
		arr.add(21);
		arr.add(7);
		arr.add(23);
		arr.add(9);
		System.out.println(arr);
		ArrayList<Integer> arrTmp = (ArrayList<Integer>) arr.clone();
		
	}
}
