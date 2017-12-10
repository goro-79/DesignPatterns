package com.grsdev.design.patterns.chap01.strategey.pack03;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface EmployeeDao {
	
	void persist(Employee e) throws FileNotFoundException, IOException;
	
	Employee findEmployeeById(long id) throws FileNotFoundException, IOException, ClassNotFoundException;
	
	
	static EmployeeDao getSerializerDao() {
	
		return new SerializerDaoImpl();
	}

}
