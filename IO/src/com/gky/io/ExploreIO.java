package com.gky.io;

import java.io.File;
import java.util.Scanner;

public class ExploreIO {
	public static void main(String[] args) {
		File root = new File("/");
		int index = 1;
		for (File childFile : root.listFiles()) {
			System.out.println("["+index+"]"+":"+childFile.getName());
			index++;
		}
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");
		System.out.print("Input:");
		while(scanner.hasNext()){
			String inStr = scanner.next();
			System.out.println(inStr);
			
			
			
		}
	}
}
