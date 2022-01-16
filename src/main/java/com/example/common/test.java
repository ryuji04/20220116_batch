package com.example.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("what'syouraname");
		InputStreamReader in=new InputStreamReader(System.in);
		BufferedReader reader=new BufferedReader(in);
		try {
		String line=reader.readLine();
		System.out.println("hello"+line+"!");
		System.out.println("by the way what your favorite food");
		in=new InputStreamReader(System.in);
		reader=new BufferedReader(in);
		line=reader.readLine();
		System.out.println("oh really I like that");
		
		reader.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
		

}
