package com.grsdev.design.patterns.chap03.decorator.pack02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author gaurav salvi
 *
 */
public class MyInputStreamDemo {

	public static void main(String[] args) throws IOException {
		
		UpperCaseInputStream uis=new UpperCaseInputStream("file1.txt");
		
		int read=0;
		
		while((read = uis.read())!=-1){
			System.out.print((char)read);
		}
		
	}

}


class UpperCaseInputStream extends FileInputStream{

	public UpperCaseInputStream(String name) throws FileNotFoundException {
		super(name);
	}
	
	@Override
	public int read() throws IOException {
		
		int c=super.read();
		
		int cha=c==-1?-1:Character.toUpperCase(c);
		return cha;
	}
	
}