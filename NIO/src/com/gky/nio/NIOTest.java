package com.gky.nio;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;
import java.util.TimeZone;

public class NIOTest {

	/*interface A{
		int x = 0;
		C c = new C();
	}
	class B{
		int x = 1;
	}
	class C extends B implements A{
		public void pX(){
		}
	}*/
	public static void printAllFiles(File file){
		if(file != null){
			if(file.isDirectory()){
				System.out.println(file.getAbsolutePath());
				for(File childFile : file.listFiles()){
					printAllFiles(childFile);
				}
			}else{
				System.out.println(file.getAbsolutePath());
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<A, Integer> map = new HashMap<>();
		map.put(new A(12345), 67890);
		map.put(new A(67890), 12345);
		System.out.println(map.toString());
		Iterator itr = map.keySet().iterator();
		A first = (A) itr.next();
		System.out.println(first.count);
		first.count = 12345;
		System.out.println(map.toString());
		System.out.println(map.get(new A(67890)));
		map.remove(new A(67890));
		System.out.println(map.toString());
		/*ArrayList<String> arr = new ArrayList<String>();
		arr.add("A");
		arr.add("B");
		arr.add("C");
		arr.add("D");
		ListIterator<String> itr = arr.listIterator();
		System.out.println("-------------------");
		while (itr.hasPrevious()) {
			System.out.println(itr.previous());
		}*/
		/*System.out.println(TimeZone.getDefault().getID());*/
		/*for (String string : TimeZone.getAvailableIDs()) {
			System.out.println(string);
		}*/
		/*Calendar cd = Calendar.getInstance();
		System.out.println(cd.getTimeInMillis());
		System.out.println(cd.get(Calendar.YEAR)+"-"+(cd.get(Calendar.MONTH)+1)+"-"+cd.get(Calendar.DAY_OF_MONTH));*/
		/*Random rd = new Random();*/
		/*System.out.println(rd.nextInt());
		System.out.println(rd.nextBoolean());
		System.out.println(rd.nextDouble());
		System.out.println(rd.nextFloat());
		System.out.println(rd.nextInt(100));*/
		/*for (int i = 0; i < 20; i++) {
			System.out.println(rd.nextInt(100));
		}*/
		
		/*
		Runtime rt = Runtime.getRuntime();
		System.out.println(rt.availableProcessors());
		System.out.println(rt.freeMemory());
		System.out.println(rt.totalMemory());
		System.out.println(rt.maxMemory());*/
		/*System.out.println(args.length);
		for (String string : args) {
			System.out.println(string);
		}*/
		/*File file = new File("E:\\WorkProject\\Oceanus\\Project\\doc");
		printAllFiles(file);*/
		
		/*Path path = Paths.get(".");
		System.out.println(path);
		System.out.println(path.toAbsolutePath());
		for (int i = 0; i < path.toAbsolutePath().getNameCount(); i++) {
			System.out.println(path.toAbsolutePath().getName(i));
		}*/
		/*SortedMap<String, Charset> map = Charset.availableCharsets();
		for (String alias : map.keySet())
		{
			System.out.println(alias+"--"+map.get(alias));
		}*/
	}

}
