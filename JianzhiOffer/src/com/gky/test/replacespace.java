package com.gky.test;

public class replacespace {

	public static String replaceSpace(StringBuffer str) {
		final String flag = "%20";
		final String space = " ";
		StringBuffer newStr = new StringBuffer();
		int fist = 0, last = 0;
		
		while((fist = str.indexOf(space, fist)) != -1){
			newStr.append(str.substring(last, fist));
			newStr.append(flag);
			last = ++fist;
		}
		newStr.append(str.substring(last));
		return newStr.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "we are happy.";
		long t1 = System.nanoTime();
		System.out.println(replaceSpace(new StringBuffer(str)));
		long t2 = System.nanoTime();
		System.out.println(t2-t1);
	}

}
