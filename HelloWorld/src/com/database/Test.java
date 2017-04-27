package com.database;

import java.sql.SQLException;
import java.util.List;

import com.javatpoint.Poll;
import com.javatpoint.User;

public class Test {  
	
public static void main(String[] args) throws ClassNotFoundException, SQLException { 
	
//	JdbcTemplate jdbcTemplate = DatabaseConfigurer.getInstance();
//	UserDao userDao = new UserDao(jdbcTemplate);
//	PollDao pollDao = new PollDao(jdbcTemplate);
	PollPlatformDatabase db = new DerbyDatabase();
	
	User e1 = new User("Mike", "100");
	User e2 = new User("Mary", "100");
	User e3 = new User("Dave", "100");
	
//	Integer t1 = db.addUser(e1);
//	Integer t2 = db.addUser(e2);
//	Integer t3 = db.addUser(e3);
//	Integer t4 = db.addUser(e4);
//	
//	System.out.println("Added: " + t1);
//	System.out.println("Added: " + t2);
//	System.out.println("Added: " + t3);
//	System.out.println("Added: " + t4);
//	
//	//mike add 2 polls
//	Poll mikeP1 = new Poll();
//	mikeP1.setPoster(e1.getName());
//	mikeP1.setPollTitle("music");
//	db.postAPoll(e1.getName(), mikeP1);
//	System.out.println("Added: " + t1);
//	
//	Poll mikeP2 = new Poll();
//	mikeP2.setPoster(e1.getName());
//	mikeP2.setPollTitle("pizza");
//	db.postAPoll(e1.getName(), mikeP2);
//	System.out.println("Added: " + t2);
//	
	//mary add 1 poll
	Poll maryP1 = new Poll();
	maryP1.setPoster(e2.getName());
	maryP1.setPollTitle("makeup");
	int t2 = db.postAPoll(e2.getName(), maryP1);
	System.out.println("Added: " + t2);
//	
//	//dave rates 3 polls
	db.fillPoll(e1.getName(), 2, 4);
	db.fillPoll(e2.getName(), 1, 5);
//	db.fillPoll(e3.getName(), 3, 3);
//	
//	//delete the third poll;
//	t1 = db.deletePoll(3);
//	System.out.println("Deleted: " + t1);
	
	List<Poll> allPolls = db.getAllPolls();
	
	for(Poll p : allPolls) {
		System.out.println("Id: " + p.getPollId() + " title: " + p.getPollTitle() + " content: " + p.getPollContent() + " poster: " + p.getPoster());
		System.out.print("poll result: ");
		for(int i : p.getPollResults()) {
			System.out.print(i + ",");
		}
		System.out.println("\n");
	}
	
	
	User mike = db.getUser(e1.getName());
	System.out.println("Name: " + mike.getName() + " password: " + mike.getPassword() + " points: " + mike.getPoints());
	
	User mary = db.getUser(e2.getName());
	System.out.println("Name: " + mary.getName() + " password: " + mary.getPassword() + " points: " + mary.getPoints());
	
	User dave = db.getUser(e3.getName());
	System.out.println("Name: " + dave.getName() + " password: " + dave.getPassword() + " points: " + dave.getPoints());
	
	
	
	
//	userDao.deleteUser(e1);
//	userDao.saveUser(e1);
//	userDao.saveUser(e2);
//	userDao.saveUser(e3);
//
//	User e = userDao.getUser("Mike");
//	if(e == null) {
//		System.out.println("No such user");
//	} else {
//		System.out.println("Name: " + e.getName() + " Password: " + e.getPassword() + " Points: " + e.getPoints());
//	}
//	
//	Poll newP = new Poll();	
//	newP.setPoster("Mary");
//	newP.setPollTitle("Music");
//	
//	pollDao.savePoll(newP);
//	
//	newP.setPoster("Mike");
//	newP.setPollTitle("Pizza");
//	pollDao.savePoll(newP);
//	
//	newP.setPoster("Dave");
//	newP.setPollTitle("Dance");
//	pollDao.savePoll(newP);
//	
//	List<Poll> allPolls = pollDao.findAllPolls();
//	for(Poll p : allPolls) {
//		System.out.println("Id: " + p.getPollId() + " title: " + p.getPollTitle() + " content: " + p.getPollContent() + " poster: " + p.getPoster());
//		System.out.print("poll result: ");
//		for(int i : p.getPollResults()) {
//			System.out.print(i + ",");
//		}
//		System.out.println("\n");
//	}
//	
	List<Poll> mikePoll = db.getPollsForUser(e1.getName());
	System.out.println("Mike's poll: ");
	for(Poll p : mikePoll) {
		System.out.println("Id: " + p.getPollId() + " title: " + p.getPollTitle() + " content: " + p.getPollContent() + " poster: " + p.getPoster());
		System.out.print("poll result: ");
		for(int i : p.getPollResults()) {
			System.out.print(i + ",");
		}
		System.out.println("\n");
	}
//	
//	
//	Poll wantedPoll = pollDao.getPoll(1);
//	System.out.println("Id: " + wantedPoll.getPollId() + " title: " + wantedPoll.getPollTitle() + 
//			" content: " + wantedPoll.getPollContent() + " poster: " + wantedPoll.getPoster());
////	pollDao.deletePoll(newP);
//	
//	
//	FilledPollsDao filledPollsDao = new FilledPollsDao(jdbcTemplate, pollDao, userDao);
//	filledPollsDao.fillAPoll(2,"Mike", 1);
//	filledPollsDao.fillAPoll(2,"Dave", 2);
//	filledPollsDao.fillAPoll(2,"Mary", 3);
//	
////	userDao.updatePoints("Mike");
//	User newE = userDao.getUser("Mike");
//	if(e == null) {
//		System.out.println("No such user");
//	} else {
//		System.out.println("Name: " + newE.getName() + " Password: " + newE.getPassword() + " Points: " + newE.getPoints());
//	}
//	
////	pollDao.wasRated(2, 1);
//	Poll ratedPoll = pollDao.getPoll(2);
//	System.out.println("Rated poll: ");
//	System.out.println("Id: " + ratedPoll.getPollId() + " title: " + ratedPoll.getPollTitle()+ " poster: " + ratedPoll.getPoster());
//	System.out.print("poll result: ");
//	for(int i : ratedPoll.getPollResults()) {
//		System.out.print(i + ",");
//	}
//	System.out.println("\n");
//	
//	boolean filled = filledPollsDao.hasFilled("Mike", 2);
//	System.out.println("Has filled? " + filled);
//	
//	System.out.println("Successfully done");
}  
  
}  
