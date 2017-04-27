package com.javatpoint;
/**
 * This is a user class
 * @author LuyiYang
 *
 */
public class User {  
	private int id;  
	private String name;  
	private int points;  
	private String password;  


	public User(String name, String password) {   
		this.name = name; 
		this.password = password;  
//		points = 50;
	}  

	public String getPassword() {
		return password;
	}

//	public void setPassword(String password) {
//		this.password = password;
//	}

	public int getId() {  
		return id;  
	}  
	public void setId(int id) {  
		this.id = id;  
	}  
	public String getName() {  
		return name;  
	}  
//	public void setName(String name) {  
//		this.name = name;  
//	}  
	public int getPoints() {  
		return  points;  
	}  
	public void setPoints(int points) {  
		this.points = points;  
	}  
}  