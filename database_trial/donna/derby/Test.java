package com.donna.derby;

import java.sql.SQLException;

import org.apache.log4j.BasicConfigurator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class Test {  
	
public static void main(String[] args) throws ClassNotFoundException, SQLException { 
	BasicConfigurator.configure();
	
	SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
	
	JdbcTemplate jdbcTemplate = CreateConnection.createConnection(dataSource);
	EmployeeDao employeeDao = new EmployeeDao(jdbcTemplate);
	Employee e1 = new Employee(1, "Mary", 100);
	
//	Employee e2 = new Employee(2, "Rose", 200);
//	
//	Employee e3 = new Employee(3, "Alice", 300);
	employeeDao.deleteEmployee(e1);
	employeeDao.saveEmployee(e1);
//	employeeDao.saveEmployee(e2);
//	employeeDao.saveEmployee(e3);
//	
	
//	employeeDao.deleteEmployee(e2);
//	employeeDao.deleteEmployee(e3);
	
	Employee e = employeeDao.getEmployee(1);
	System.out.println("Id: " + e.getId() + " Name: " + e.getName() + " Salary: " + e.getSalary());
	
	System.out.println("Successfully done");
	
	dataSource.destroy();
}  
  
}  
