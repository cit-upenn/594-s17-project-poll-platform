package com.database;

import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.javatpoint.User;

public class Test {  
	
public static void main(String[] args) throws ClassNotFoundException, SQLException { 
	
	JdbcTemplate jdbcTemplate = DatabaseConfigurer.getInstance();
	UserDao userDao = new UserDao(jdbcTemplate);
//	User e1 = new User("Mary", "100");
	
//	Employee e2 = new Employee(2, "Rose", 200);
//	
//	Employee e3 = new Employee(3, "Alice", 300);
//	userDao.deleteUser(e1);
//	userDao.saveUser(e1);
//	employeeDao.saveEmployee(e2);
//	employeeDao.saveEmployee(e3);
//	
	
//	employeeDao.deleteEmployee(e2);
//	employeeDao.deleteEmployee(e3);
	
	User e = userDao.getUser("jc");
	if(e == null) {
		System.out.println("No such user");
	} else {
		System.out.println("Name: " + e.getName() + " Password: " + e.getPassword() + " Points: " + e.getPoints());
	}
	
	System.out.println("Successfully done");
	

}  
  
}  
