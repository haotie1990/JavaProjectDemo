package com.gky.strtest;

import java.nio.charset.Charset;

public class CharsetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sName="name";
		String newName = new String(sName.getBytes(), Charset.forName("IOS8859-1"));
	}

}
