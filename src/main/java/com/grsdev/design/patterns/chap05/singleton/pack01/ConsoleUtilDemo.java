package com.grsdev.design.patterns.chap05.singleton.pack01;

import static java.lang.System.out;

public class ConsoleUtilDemo {

	public static void main(String[] args) {
		
		ConsoleUtil console1 = ConsoleUtil.getInstance();
		
		ConsoleUtil console2 = ConsoleUtil.getInstance();
		
		out.println("console1 id : "+console1.getId());
		
		console1.setId("abc");
		
		console2.setId("xyz");
		
		out.println("console1 id : "+console1.getId());
		
		out.println("console2 id : "+console2.getId());
		
	}

}
