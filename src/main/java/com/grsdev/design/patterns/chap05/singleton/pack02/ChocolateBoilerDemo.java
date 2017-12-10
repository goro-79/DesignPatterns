package com.grsdev.design.patterns.chap05.singleton.pack02;

import static java.lang.System.out;

public class ChocolateBoilerDemo {

	public static void main(String[] args) throws InterruptedException {
		
		Runnable demo1=()->startBoiler();
		Runnable demo2=()->startBoiler();
		
		Thread t1 = new Thread(demo1);
		Thread t2 = new Thread(demo2);
		Thread t3 = new Thread(demo2);
		Thread t4 = new Thread(demo2);
		Thread t5 = new Thread(demo2);
		
		t1.start(); 
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		
	}

	private static void startBoiler() {
		out.println(">>> running demo");
		
		ChocolateBoiler boiler1=ChocolateBoiler.getInstance();
		
		try {
			boiler1.fill();
			boiler1.boil();
			boiler1.drain();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		out.println(">>> demo completed");
	}

}
