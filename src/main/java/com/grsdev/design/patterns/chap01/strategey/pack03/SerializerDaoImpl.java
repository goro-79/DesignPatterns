package com.grsdev.design.patterns.chap01.strategey.pack03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.*;

public class SerializerDaoImpl implements EmployeeDao {
	
	final String dir=getClass().getPackage().toString().replaceAll("\\.", "/").replaceAll("package", "").trim();
	
	final String EMPLOYEE="employee";
	
	@Override
	public void persist(Employee e) throws IOException {
		
		String file="src/main/java/"+dir+"/"+EMPLOYEE+"-"+e.getId()+".ser";
		
		Path path=Paths.get(file);
		
		Files.createDirectories(path.getParent());
		
		out.println(">>> writing to file : "+path.toAbsolutePath());
		
		FileOutputStream fos=new FileOutputStream(path.toAbsolutePath().toString());
		
		ObjectOutputStream os=new ObjectOutputStream(fos);
		
		os.writeObject(e);
		os.close();
	}

	@Override
	public Employee findEmployeeById(long id) throws IOException, ClassNotFoundException {
		
		
		FileInputStream fis=new FileInputStream(EMPLOYEE+"-" + id+ ".ser");
		
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		Employee emp=(Employee)ois.readObject();
		ois.close();
		return emp;
	}

}
