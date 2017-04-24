package com.donna.derby;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;
	
	public EmployeeDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int saveEmployee(Employee e) {
		String query = "insert into employee values("+e.getId()+",'"+e.getName()+"',"+e.getSalary()+")";
		
		return jdbcTemplate.update(query);
	}
	
	public int deleteEmployee(Employee e) {
		String query = "delete from employee where id="+e.getId();
		return jdbcTemplate.update(query);
	}
	
	public Employee getEmployee(int id) {
		String query = "select id, name, salary from employee where id=?";
		
		RowMapper<Employee> mapper = new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int salary = resultSet.getInt("salary");
				
				Employee employee = new Employee(id, name, salary);
				return employee;
			}			
		};
		return (Employee)jdbcTemplate.queryForObject(query,new Object[] {id}, mapper);
	}
}
