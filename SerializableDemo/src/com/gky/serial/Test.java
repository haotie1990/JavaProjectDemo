package com.gky.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Person person = new Person("gky", 26, true);
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.txt"));
		out.writeObject(person);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.txt"));
		Person newPerson = (Person) in.readObject();
		in.close();
		System.out.println(newPerson);
	}
}
