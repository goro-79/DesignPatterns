package com.grsdev.design.patterns.chap05.singleton.pack02;
import static java.lang.System.out;

public class ChocolateBoiler {
	
	private volatile static ChocolateBoiler instance;
	
	private volatile boolean empty,boiled;
	
	
	private ChocolateBoiler() {
		empty=true;
		boiled=false;
	}
	
	public static  ChocolateBoiler getInstance(){
		if(instance==null) {
			synchronized(ChocolateBoiler.class) {
				if(instance==null)
					instance=new ChocolateBoiler();
			}
		}

		return instance;
	}
	
	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public boolean isBoiled() {
		return boiled;
	}

	public void setBoiled(boolean boiled) {
		this.boiled = boiled;
	}

	public synchronized void fill() throws InterruptedException {
		if(empty) {
		out.println(toString()+" >>>  filling boiler ...");
		empty=false;
		Thread.sleep(5000);
		out.println(toString()+" >>>  boiler is filled !");
		}else
			out.println(toString()+" >>> already filled");
	}

	public void boil() throws InterruptedException {
		
		out.println(toString()+" >>>  boiling started ...");
		Thread.sleep(8000);
		out.println(toString()+" >>>  boiling completed !");
	}

	public synchronized void drain() throws InterruptedException {
		if(!empty) {
			out.println(toString()+" >>>  draining started ... ");
			Thread.sleep(4000);
			empty=true;
			out.println(toString()+" >>>  draining completed !");
		}else
			out.println(">>> already drained !!!");
		
	}
	
	@Override
	public String toString() {
		return super.toString().split("\\.")[7];
	}
	
}


