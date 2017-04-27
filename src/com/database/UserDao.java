package com.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.javatpoint.User;

public class UserDao {
private JdbcTemplate jdbcTemplate;
	
	public UserDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int saveUser(User newUser) {		
		return jdbcTemplate.update("insert into pollUser (name, password, points) values (?, ?, ?)", 
				newUser.getName(), newUser.getPassword(), 50);
	}
	
	public int deleteUser(String userName) {		
		return jdbcTemplate.update("delete from pollUser where name = ?", userName);
	}
	
	public User getUser(String name) {
		String query = "select name, password, points from pollUser where name=?";
		
		RowMapper<User> mapper = new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
					String name = resultSet.getString("name");
					String password = resultSet.getString("password");
					int points = resultSet.getInt("points");					
					User user = new User(name, password);
					user.setPoints(points);
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
	
	@SuppressWarnings("deprecation")
	public boolean hasUser(String userName) {
		String query = "select count(*) from pollUser where name = ?";
		int count = 0;
		try {
			count = jdbcTemplate.queryForInt(query, userName);
		} catch(Exception e) {			
		}
		
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	public int updatePoints(String userName, int changedPoints) {
		User curUser = getUser(userName);
		int newPoint = curUser.getPoints() + changedPoints;
		String updatePointQuery = "update pollUser set points = ? where name = ?";
		return this.jdbcTemplate.update(updatePointQuery, new Object[]{newPoint, userName});		
	}
}
