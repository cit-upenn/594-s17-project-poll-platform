package com.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.javatpoint.Poll;

public class PollDao {
	private JdbcTemplate jdbcTemplate;
	
	public PollDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int savePoll(Poll p) {
		return jdbcTemplate.update("insert into poll (title, content, poster) values(?, ?, ?)", 
				p.getPollTitle(), p.getPollContent(), p.getPoster());
	}
	
	public int deletePoll(int pollId) {
		return jdbcTemplate.update("delete from poll where id = ?", pollId);
	}
	
	
	public Poll getPoll(int pollId) {
		String query = "select id, title, content, poster, r1, r2, r3, r4, r5 from poll where id=?";
		Poll poll;
		try {
			poll = (Poll) this.jdbcTemplate.queryForObject(query,new Object[] {pollId}, new PollMapper());
		} catch(Exception e) {
			poll = null;
		}
		return poll; 
	}
	
	public List<Poll> findAllPollsForUser(String posterName) {		
		String query = "select id, title, content, poster, r1, r2, r3, r4, r5 from poll where poster = ?";	
		try {
			return this.jdbcTemplate.query(query, new Object[] {posterName}, new PollMapper());
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Poll> findAllPolls() {
		String query = "select id, title, content, poster, r1, r2, r3, r4, r5 from poll";
		try {
			return this.jdbcTemplate.query(query, new PollMapper());
		} catch (Exception e) {
			return null;
		}
	}
	
	//update poll after being rated
	public int wasRated(int pollId, int score) {
		String query = "";
		Poll ratedPoll = getPoll(pollId);
		int count = 0;
		
		switch(score) {
		case 1:
			query = "update poll set r1=? where id = ?";
			count = ratedPoll.getPollResults()[0] + 1;
			break;
		case 2:
			query = "update poll set r2=? where id = ?";
			count = ratedPoll.getPollResults()[1] + 1;
			break;
		case 3: 
			query = "update poll set r3=? where id = ?";
			count = ratedPoll.getPollResults()[2] + 1;
			break;
		case 4:
			query = "update poll set r4=? where id = ?";
			count = ratedPoll.getPollResults()[3] + 1;
			break;
		case 5:
			query = "update poll set r5=? where id = ?";
			count = ratedPoll.getPollResults()[4] + 1;
			break;
		}		
		return this.jdbcTemplate.update(query, new Object[]{count, pollId});
	}
	
	private static final class PollMapper implements RowMapper<Poll> {
		@Override
		public Poll mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Poll poll = new Poll();
			poll.setPollId(resultSet.getInt("id"));
			poll.setPollTitle(resultSet.getString("title"));
			poll.setPollContent(resultSet.getString("content"));
			poll.setPoster(resultSet.getString("poster"));
			int[] pollResults = new int[5];
			pollResults[0] = resultSet.getInt("r1");
			pollResults[1] = resultSet.getInt("r2");
			pollResults[2] = resultSet.getInt("r3");
			pollResults[3] = resultSet.getInt("r4");
			pollResults[4] = resultSet.getInt("r5");
			poll.setPollResults(pollResults);
			return poll;
		}			
	}	
}
