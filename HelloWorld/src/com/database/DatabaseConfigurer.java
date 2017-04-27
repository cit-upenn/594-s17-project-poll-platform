package com.database;

import org.apache.log4j.BasicConfigurator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class DatabaseConfigurer {
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String JDBC_URL = "jdbc:derby:/Users/LuyiYang/Documents/HelloWorld/zadb;create=true";
	private static JdbcTemplate jdbcTemplate;
	
	public static JdbcTemplate getInstance() throws ClassNotFoundException {
		if(jdbcTemplate == null) {
			createConnection();
		} 
		return jdbcTemplate;
	}
	
	private static void createConnection() throws ClassNotFoundException {
		BasicConfigurator.configure();
		SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(JDBC_URL);
		dataSource.setUsername("za");
		dataSource.setPassword("");
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
//		jdbcTemplate.execute("DROP TABLE poll");
//		jdbcTemplate.execute("DROP TABLE pollUser");
//		jdbcTemplate.execute("DROP TABLE filledPolls");
//
//		jdbcTemplate.execute("create table pollUser (name varchar(20), password varchar(20), points integer)");	
//		
		jdbcTemplate.execute("create table poll (id integer primary key generated always as identity, "
				+ "title varchar(20), content varchar(500), poster varchar(20), "
				+ "r1 integer, r2 integer, r3 integer, r4 integer, r5 integer)");
		
		jdbcTemplate.execute("create table filledPolls (pollId integer, raterName varchar(20), score int)");
				
	}
}
