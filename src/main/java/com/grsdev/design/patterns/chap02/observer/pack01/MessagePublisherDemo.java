package com.grsdev.design.patterns.chap02.observer.pack01;

import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;

interface MessagePublisher{
	
	void publish(String message);
	
	void addListener(Listener listener);
}

interface Listener {
	void process(String message);
}


class MessagePublisherImpl implements MessagePublisher{
	
	private List<Listener> listeners=new ArrayList<>();
	
	public void publish(String message){
		
		out.println(">>> publisheing - "+message);
		
		for(Listener listener : listeners){
			listener.process(message);
		}
	}
	
	public void addListener(Listener listener){
		listeners.add(listener);
	}
	
}


class ConsoleListener implements Listener{

	@Override
	public void process(String message) {
		out.println(">>> Console Listener : "+message);
		
	}
	
}


class FileListener implements Listener{
	
	private File file=new File("file-listener.txt");
	
	@Override
	public void process(String message) {
		
		try(PrintWriter pw=new PrintWriter(file)){
			
			pw.println(message);
			out.println(">>> File Listener : message written to file");
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}



/**
 * @author gaurav salvi
 *
 */
public class MessagePublisherDemo {

	public static void main(String[] args) {
		
		Listener console=new ConsoleListener();
		
		Listener file=new FileListener();
		
		MessagePublisher publisher=new MessagePublisherImpl();
		
		publisher.addListener(console);
		publisher.addListener(file);
		
		publisher.publish("Hello Listeners !!!");
		
		
	}

}
