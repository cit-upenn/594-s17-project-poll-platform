package com.database;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.javatpoint.Poll;
import com.javatpoint.User;

public class DerbyDatabase implements PollPlatformDatabase {
	private JdbcTemplate jdbcTemplate;
	private UserDao userDao;
	private PollDao pollDao;
	private FilledPollsDao filledPollsDao;
	
	/**
	 * Constructor
	 * Configure the database
	 * create the dao objects for keeping the records
	 * @throws ClassNotFoundException
	 */
	public DerbyDatabase() throws ClassNotFoundException {
		this.jdbcTemplate = DatabaseConfigurer.getInstance();
		this.userDao = new UserDao(jdbcTemplate);
		this.pollDao = new PollDao(jdbcTemplate);
		this.filledPollsDao = new FilledPollsDao(jdbcTemplate);
	}
	

	@Override
	public int addUser(User u) {
		boolean hasUser = userDao.hasUser(u.getName());
		if(hasUser == true) {
			return -1;
		}
		return userDao.saveUser(u);
	}

	@Override
	public int postAPoll(String poster, Poll p) {
		if(userDao.hasUser(poster) == false) {
			return -1;
		}
		userDao.updatePoints(poster, -2);
		return pollDao.savePoll(p);
	}

	@Override
	public User getUser(String userName) {		
		return userDao.getUser(userName);
	}

	@Override
	public Poll getPoll(int pollId) {
		return pollDao.getPoll(pollId);
	}

	@Override
	public int deletePoll(int pollId) {
		return pollDao.deletePoll(pollId);
	}

	@Override
	public int deleteUser(String userName) {
		return userDao.deleteUser(userName);
	}

	@Override
	public int fillPoll(String raterName, int pollId, int rating) {
		if(filledPollsDao.hasFilled(raterName, pollId)) {
			return -1;
		}
		pollDao.wasRated(pollId, rating);
		userDao.updatePoints(raterName, 1);
		return filledPollsDao.fillAPoll(pollId, raterName, rating);
	}

	@Override
	public List<Poll> getPollsForUser(String userName) {
		return pollDao.findAllPollsForUser(userName);
	}

	@Override
	public List<Poll> getAllPolls() {
		return pollDao.findAllPolls();
	}


	@Override
	public List<Poll> getTaggedPolls(String tag) {
		return pollDao.findTaggedPolls(tag);
	}

}
