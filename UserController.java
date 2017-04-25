package com.javatpoint;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;   
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.servlet.ModelAndView;

import com.database.DatabaseConfigurer;
import com.database.UserDao;  

@Controller  
public class UserController {  

	HashMap<String, User> userList;
	
	UserDao userDao;

	public UserController() throws ClassNotFoundException{	
		userList=new HashMap<>();
		JdbcTemplate jdbcTemplate = DatabaseConfigurer.getInstance();
		this.userDao = new UserDao(jdbcTemplate);
	}

	@RequestMapping("/SignInForm")  
	public ModelAndView showform(HttpServletRequest request,HttpServletResponse res){
		String message = request.getParameter("message");
		return new ModelAndView("SignInForm","message",message);  
	}


	@RequestMapping("/SignUpForm")  
	public ModelAndView signupform(){  
		return new ModelAndView("SignUpForm"); 
	} 

	@RequestMapping("/signup")  
	public ModelAndView signup(HttpServletRequest request,HttpServletResponse res){

		String name=request.getParameter("name");  
		String password=request.getParameter("password"); 

		User user = new User(name, password);
//		userList.put(user.getName(), user);
//		user.setId(userList.size());
		user.setPoints(50);
		userDao.saveUser(user);
		return new ModelAndView("redirect:/UserHomePage", "name", name);


	}  

	@RequestMapping("/signin")  
	public ModelAndView viewemp(HttpServletRequest request,HttpServletResponse res){  

		String name=request.getParameter("name");  
		String password=request.getParameter("password"); 
		User u = userDao.getUser(name);

//		if(userList.containsKey(name)){
//			User u = userList.get(name);
		if (u != null) {
			if(u.getPassword().equals(password)){
				return new ModelAndView("redirect:/UserHomePage", "name", name);
			}else{
				String message = "Password is not correct. Please try again.";
				return new ModelAndView("redirect:/SignInForm", "message", message);
			}
		}else{
			String message = "Username is not correct. Please try again.";
			return new ModelAndView("redirect:/SignInForm", "message", message);
		}
	} 

	@RequestMapping("/UserHomePage")  
	public ModelAndView secondLink(HttpServletRequest request,HttpServletResponse res) {  
		String name = request.getParameter("name");
//		User u = userList.get(name);
		User u = userDao.getUser(name);
		return new ModelAndView("UserHomePage", "user", u);  
	} 
}  