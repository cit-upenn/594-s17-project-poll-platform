package com.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.javatpoint.*;

public class UserDao {
	private JdbcTemplate jdbcTemplate;
	
	public UserDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int saveUser(User newUser) {
		
		return jdbcTemplate.update("insert into pollUser (name, password) values (?, ?)", 
				newUser.getName(), newUser.getPassword());
	}
	
	public int deleteUser(User e) {
		
		return jdbcTemplate.update("delete from pollUser where name = ?", e.getName());
	}
	
	public User getUser(String name) {
		String query = "select name, password from pollUser where name=?";
		
		RowMapper<User> mapper = new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
					String name = resultSet.getString("name");
					String password = resultSet.getString("password");
					
					User user = new User(name, password);
					return user;				
			}			
		};
		User res;
		try {
			res = (User)jdbcTemplate.queryForObject(query,new Object[] {name}, mapper); 
		} catch (Exception e) {
			res = null;
		}
		return res; 
	}
}
