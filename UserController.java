package com.javatpoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  
@Controller  
public class UserController {  
//	List<User> userList;
	HashMap<String, User> userList;
	User currentUser;

	public UserController(){	
		userList=new HashMap<>(); 
		currentUser = null;
	}

	@RequestMapping("/SignInForm")  
	public ModelAndView showform(){  
		//command is a reserved request attribute name, now use <form> tag to show object data  
		return new ModelAndView("SignInForm","command",new User());  
	}
	

	@RequestMapping("/SignUpForm")  
	public ModelAndView signupform(){  
		//		 String message = "Hello 594";  
		//	        return new ModelAndView("hellopage", "message", message);   
		return new ModelAndView("SignUpForm","command",new User()); 
	} 

	@RequestMapping(value="/save",method = RequestMethod.POST)  
	public ModelAndView save(User user){
		//		@ModelAttribute("user") 
		//write code to save emp object  
		//here, we are displaying emp object to prove emp has data  
		user.setPoints(50);
		String name = user.getName();
		if(userList.containsKey(name)){
			User u = userList.get(name);
			if(u.getPassword().equals(user.getPassword())){
				currentUser = u;
//				System.out.println("enter correctly");
				return new ModelAndView("redirect:/UserHomePage");
			}else{
//				System.out.println("enter not correctly");
				String message = "Try again. Password not correct.";
				return new ModelAndView("redirect:/SignInForm", "message", message);
			}
		}
		
//		System.out.println("new user created");
		currentUser = user;
		userList.put(user.getName(), user);
		user.setId(userList.size());

		//		System.out.println(user.getName()+" "+user.getPoints());  
		return new ModelAndView("redirect:/UserHomePage");//will redirect to viewemp request mapping  
	}  

	@RequestMapping("/viewemp")  
	public ModelAndView viewemp(){  
		//write the code to get all employees from DAO  
		//here, we are writing manual code of list for easy understanding  
		return new ModelAndView("viewemp","list",userList);  
	} 

	@RequestMapping("/UserHomePage")  
	public ModelAndView secondLink() {  
//		String userName = currentUser.getName();
//		String passWord = currentUser.getPassword();
//		int points = currentUser.getPoints();
//		String message = "Welcome to home " + userName + "!" + " Your password is: " + passWord + ".";
		//String info = "Your current points are: " + currentUser.getPoints();
		//System.out.println(currentUser.getPoints());
		return new ModelAndView("UserHomePage", "user", currentUser);  
	} 
}  