package com.donna.derby;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {  
	
public static void main(String[] args) throws ClassNotFoundException, SQLException { 
	PollPlatformDatabase db = new DerbyDatabase();
	User e1 = new User("Mike", "100");
	User e2 = new User("Mary", "100");
	User e3 = new User("Dave", "100");
	
	db.addUser(e1);
	db.addUser(e2);
	db.addUser(e3);
	
	//mary add 1 poll
	Poll maryP1 = new Poll();
	maryP1.setPoster(e2.getName());
	maryP1.setPollTitle("makeup");
	maryP1.setTag("Life");
	int t2 = db.postAPoll(e2.getName(), maryP1);
	System.out.println("Added: " + t2);
	
	Poll daveP1 = new Poll();
	daveP1.setPoster(e3.getName());
	daveP1.setPollTitle("swimming");
	daveP1.setTag("health");
	t2 = db.postAPoll(e3.getName(), daveP1);
	System.out.println("Added: " + t2);
	
	Poll retrieved = db.getPoll(1);
	System.out.println("Id: "+ retrieved.getPollId() + " Poster: " 
	+ retrieved.getPoster() + " Timestamp: " + retrieved.getCreatedDate());
	
	Poll retrieved2 = db.getPoll(2);
	System.out.println("Id: "+ retrieved2.getPollId() + " Poster: " 
			+ retrieved2.getPoster() + " Timestamp: " + retrieved2.getCreatedDate());
	
	if(retrieved2.getCreatedDate().compareTo(retrieved.getCreatedDate()) > 0) {
		System.out.println(retrieved2.getPoster() + " poll is after " + retrieved.getPoster()+ "'s poll" );
	} else {
		System.out.println("failure");
	}

	db.fillPoll(e1.getName(), 1, 4);
	db.fillPoll(e2.getName(), 1, 5);
	
	db.fillPoll(e2.getName(), 2, 3);
	db.fillPoll(e3.getName(), 2, 2);

	List<Poll> allPolls = db.getAllPolls();
	for(Poll p : allPolls) {
		System.out.println("Id: " + p.getPollId() + " title: " + p.getPollTitle() + " content: " + p.getPollContent() + " poster: " + p.getPoster());
		System.out.print("poll result: ");
		for(int i : p.getPollResults()) {
			System.out.print(i + ",");
		}
		System.out.println("\n");
	}
	
	List<Poll> lifePolls = db.getTaggedPolls("life");
	System.out.println("Life polls: ");
	for(Poll p : lifePolls) {
		System.out.println("Id: " + p.getPollId() + " title: " + p.getPollTitle() + " Created date: " + p.getCreatedDate() + " poster: " + p.getPoster());
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
	
	ArrayList<Poll> recentPoll = db.getRecentPolls(2);
	System.out.println("Recent polls: ");
	for(Poll p : recentPoll) {
		System.out.println("Id: " + p.getPollId() + " title: " + p.getPollTitle() + " Created date: " + p.getCreatedDate() + " poster: " + p.getPoster());
		System.out.print("poll result: ");
		for(int i : p.getPollResults()) {
			System.out.print(i + ",");
		}
		System.out.println("\n");
	}

}

}  
