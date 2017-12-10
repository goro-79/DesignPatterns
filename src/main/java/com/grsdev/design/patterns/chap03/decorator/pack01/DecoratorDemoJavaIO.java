package com.grsdev.design.patterns.chap03.decorator.pack01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.lang.System.out;

/**
 * @author gaurav salvi
 *
 */
public class DecoratorDemoJavaIO {

	public static void main(String[] args) throws IOException, URISyntaxException, Exception {

		new DecoratorDemoJavaIO().start();
	}

	private void start() throws URISyntaxException, IOException, ClassNotFoundException {
		
		User jimmy=new User("jimmy", 20);
		
		Path path = Paths.get(Paths.get("").toAbsolutePath().toString(),"jimmy.txt");
		
		out.println(">>> writing object to : "+path.toAbsolutePath());
		
		Files.delete(path);
		
		OutputStream os=new FileOutputStream(path.toFile());

		ObjectOutputStream ops=new ObjectOutputStream(os);
		
		ops.writeObject(jimmy);
		ops.close();
		
		
		// read file and de serialize user into another object
		
		ObjectInputStream ois=new ObjectInputStream(path.toFile().toURI().toURL().openStream());
		
		User jimmy2=(User)ois.readObject();
		
		out.println(jimmy2);
		
		
		
		
	}

	private static void demo1() throws IOException {
		InputStream is=DecoratorDemoJavaIO.class.getResourceAsStream("file1.txt");

		BufferedReader br=new BufferedReader(new InputStreamReader(is));

		br.lines().forEach(System.out::println);
		br.close();
	}

}

class User implements Serializable{

	private String name;

	private Integer age;

	/**
	 * @param name
	 * @param age
	 */
	public User(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

}


