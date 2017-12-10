package com.grsdev.design.patterns.chap01.strategey.pack03;

import static java.lang.System.out;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EmployeeDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Employee ravi=new Employee(1001L,"ravi","kumar","pune");

		out.println("writing object to file");
		
		EmployeeDao dao = EmployeeDao.getSerializerDao();
		
		dao.persist(ravi);
		
	}

}
