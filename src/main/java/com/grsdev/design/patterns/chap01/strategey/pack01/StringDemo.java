package com.grsdev.design.patterns.chap01.strategey.pack01;

public class StringDemo{
	
	public static void main(String[] args) {
		
		String a="red";
		
		method1(a);
		System.out.println(a + " hashcode : "+a.hashCode());
		
	}
	
	
	static void method1(String b){
		b+=" apple";
		System.out.println(b + " hascode : "+ b.hashCode());
	}
	
}
