package com.javatpoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;   
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.servlet.ModelAndView;

import com.database.*; 

@Controller  
public class UserController{  
//	UserDao userDao;
//	PollDao pollDao;
	PollPlatformDatabase db;


	public UserController() throws ClassNotFoundException{	
		db = new DerbyDatabase();
//		pollDao = new PollDao();

//		JdbcTemplate jdbcTemplate = DatabaseConfigurer.getInstance();
//		this.userDao = new UserDao(jdbcTemplate);
//		Poll p = new Poll();
//		p.setPollTitle("Pizza");
//		p.setPollContent("How do you like pizza?");
//		db.postAPoll("luyiyang",p);
	}

	@RequestMapping("/SignInForm")  
	public ModelAndView signInForm(HttpServletRequest request,HttpServletResponse res){
		String message = request.getParameter("message");
		return new ModelAndView("SignInForm","message",message);  
	}


	@RequestMapping("/SignUpForm")  
	public ModelAndView signUpForm(){  
		return new ModelAndView("SignUpForm"); 
	} 

	@RequestMapping("/signup")  
	public ModelAndView signUp(HttpServletRequest request,HttpServletResponse res){

		String name=request.getParameter("name");  
		String password=request.getParameter("password"); 

		User user = new User(name, password);
//		user.setPoints(50);
		
		db.addUser(user);
		return new ModelAndView("redirect:/UserHomePage", "name", name);


	}  

	@RequestMapping("/signin")  
	public ModelAndView signIn(HttpServletRequest request,HttpServletResponse res){  

		String name=request.getParameter("name");  
		String password=request.getParameter("password"); 
		User u = db.getUser(name);
		if (u != null) {
			if(u.getPassword().equals(password)){
//				Cookie ck = new Cookie("user",name);
//				res.addCookie(ck);
				return new ModelAndView("redirect:/UserHomePage","name",name);
//				return new ModelAndView("redirect:/UserHomePage");

			}else{
				String message = "Password is not correct. Please try again.";
				return new ModelAndView("redirect:/SignInForm", "message", message);
			}
		}else{
			String message = "Username is not correct. Please try again.";
			return new ModelAndView("redirect:/SignInForm", "message", message);
		}
	} 

	@RequestMapping("/SeeMyPolls")  
	public ModelAndView seeMyPollsPage(HttpServletRequest request,HttpServletResponse res){ 
		String name = request.getParameter("name");
		User u = db.getUser(name);
//		String userId = request.getParameter("user");
//		Object u = request.getSession().getAttribute(userId);
//		User u = (User) request.getAttribute("user");
//		System.out.println(((User) u).getName());
		return new ModelAndView("SeeMyPolls", "user", u); 
	}
	
	@RequestMapping("/hiddenTest")
	public ModelAndView hiddenTest(HttpServletRequest request,HttpServletResponse res) {
		
		String name = request.getParameter("user");
		System.out.println(name);
		System.out.println(request.getParameter("password"));
		return new ModelAndView("SeeMyPolls", "user", db.getUser(name));
		
	}
	

	@RequestMapping("/SeeAvailablePolls")  
	public ModelAndView seeAvailablePollsPage(HttpServletRequest request,HttpServletResponse res){
		String name = request.getParameter("name");
//		Cookie ck = request.getCookies()[0];
//		String name = ck.getValue();
//		res.addCookie(ck);
		
//		System.out.println(pollDao.findAllPolls().size());
		return new ModelAndView("SeeAvailablePolls", "pollList", db.getAllPolls()).addObject("name", name); 
	}

	@RequestMapping("/CreateANewPoll")  
	public ModelAndView createANewPollPage(HttpServletRequest request,HttpServletResponse res){ 
		String name = request.getParameter("name");
		User u = db.getUser(name);
		return new ModelAndView("CreateANewPoll", "user", u); 
	}

	@RequestMapping("/createpoll")  
	public ModelAndView createANewPoll(HttpServletRequest request,HttpServletResponse res){ 
		String poster = request.getParameter("name");
		String pollTitle = request.getParameter("pollTitle");
		String pollContent = request.getParameter("content");
		Poll p = new Poll();
		p.setPoster(poster);
		p.setPollTitle(pollTitle);
		p.setPollContent(pollContent);
		db.postAPoll(poster,  p);
		System.out.println("new poll created!");
		User u = db.getUser(poster);
		return new ModelAndView("UserHomePage", "user", u); 
	}

	@RequestMapping("/UserHomePage")  
	public ModelAndView userHomePage(HttpServletRequest request,HttpServletResponse res) {  
		String message = request.getParameter("message");
		String name = request.getParameter("name");
//		Cookie ck[] = request.getCookies();
//		String name = ck[0].getValue();
//		System.out.print(ck.length);
		User u = db.getUser(name);
//		res.addCookie(ck[0]);
		return new ModelAndView("UserHomePage", "user", u).addObject("message", message);  
	} 
	
	@RequestMapping("/poll")  
	public ModelAndView pollPage(HttpServletRequest request,HttpServletResponse res) {  
//		Cookie uck = request.getCookies()[0];
		int pid = Integer.parseInt(request.getParameter("pollId"));
		String name = request.getParameter("name");
		System.out.println(name);
		Poll p = db.getPoll(pid);
//		Cookie pck = new Cookie("poll",Integer.toString(pid));
//		String name = uck.getValue();
//		res.addCookie(uck);
//		res.addCookie(pck);	
		return new ModelAndView("poll", "poll", p).addObject("name", name);  
	} 
	
	@RequestMapping("/submitRating")  
	public ModelAndView submitRating(HttpServletRequest request,HttpServletResponse res) {  
		String message = "You have successfully submitted a poll.";
		int rating = Integer.parseInt(request.getParameter("rating"));
		System.out.println(rating);
		String name = request.getParameter("user");
		System.out.println(name);
		int pid = Integer.parseInt(request.getParameter("pollId"));
		System.out.println(pid);
		db.fillPoll(name, pid, rating);
		return new ModelAndView("redirect:/UserHomePage","message", message).addObject("name", name);  
	}
}  