package com.grsdev.design.patterns.chap05.singleton.pack01;

public class ConsoleUtil {
	
	private String id;
	
	private static ConsoleUtil instance;
	
	private ConsoleUtil() {}
	
	public static ConsoleUtil getInstance() {
		
		if(instance!=null)
			return instance;
		else {
			instance=new ConsoleUtil();
			return instance;
		}
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void println(Object o) {
		System.out.println(o);
	}
}
