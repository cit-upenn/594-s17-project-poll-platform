package com.donna.derby;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class CreateConnection {
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:zadb;create=true";
	
	public static JdbcTemplate createConnection(SingleConnectionDataSource dataSource) throws ClassNotFoundException {

		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(JDBC_URL);
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

//		jdbcTemplate.execute("create table employee (id int, "
//				+ "name varchar(20), salary int)");
		
		
		return jdbcTemplate;
	}
}
