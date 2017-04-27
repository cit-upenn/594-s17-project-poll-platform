package com.database;

import org.springframework.jdbc.core.JdbcTemplate;


public class FilledPollsDao {
	private JdbcTemplate jdbcTemplate;
//	private PollDao pollDao;
//	private UserDao userDao;
	
	public FilledPollsDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
//		this.pollDao = pollDao;
//		this.userDao = userDao;
	}
	
	//fill a poll, add an entry to the table;
	//update points for the user; update the r values for the poll
	public Integer fillAPoll(int pollId, String userName, int score) {	
//		pollDao.wasRated(pollId, score);
//		userDao.updatePoints(userName, 1);
		
		return this.jdbcTemplate.update("insert into filledPolls (pollId, raterName, score) values (?, ?, ?)", 
				pollId, userName, score);
	}
	
	@SuppressWarnings("deprecation")
	public boolean hasFilled(String userName, int pollId) {		
		String query = "select count(*) from filledPolls where pollId = ? and raterName = ?";
		int count = 0;
		try {
			count = this.jdbcTemplate.queryForInt(query, pollId, userName);
		} catch(Exception e) {
		}
		if(count > 0) {
			return true;
		} 
		return false;
	}
}
