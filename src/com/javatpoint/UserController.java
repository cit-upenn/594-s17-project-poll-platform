package com.javatpoint;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;   
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.servlet.ModelAndView;

import com.database.*; 

@Controller  
public class UserController{  
	PollPlatformDatabase db;


	public UserController() throws ClassNotFoundException{	
		db = new DerbyDatabase();
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
				return new ModelAndView("redirect:/UserHomePage","name",name);
			}else{
				String message = "Password is not correct. Please try again.";
				return new ModelAndView("redirect:/SignInForm", "message", message);
			}
		}else{
			String message = "Username is not correct. Please try again.";
			return new ModelAndView("SignInForm", "message", message);
		}
	} 

	@RequestMapping("/SeeMyPolls")  
	public ModelAndView seeMyPollsPage(HttpServletRequest request,HttpServletResponse res){ 
		String name = request.getParameter("name");
//		User u = db.getUser(name);
//		return new ModelAndView("SeeMyPolls", "user", u);
		return new ModelAndView("SeeMyPolls", "pollList", db.getPollsForUser(name)).addObject("name", name);
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
		String tag = request.getParameter("tag");
		List<Poll> list = null;
		if(tag == null){
			list = db.getAllPolls();
		}else{
			list = db.getTaggedPolls(tag);
		}
		return new ModelAndView("SeeAvailablePolls", "pollList", list).addObject("name", name); 
	}

	@RequestMapping("/CreateANewPoll")  
	public ModelAndView createANewPollPage(HttpServletRequest request,HttpServletResponse res){ 
		String name = request.getParameter("name");
//		User u = db.getUser(name);
//		return new ModelAndView("CreateANewPoll", "user", u); 
		return new ModelAndView("CreateANewPoll", "name", name); 
	}

	@RequestMapping("/createpoll")  
	public ModelAndView createANewPoll(HttpServletRequest request,HttpServletResponse res){ 
		String poster = request.getParameter("name");
		String pollTitle = request.getParameter("pollTitle");
		String pollContent = request.getParameter("content");
		String polltag = request.getParameter("tag");
		System.out.println(polltag);
		Poll p = new Poll();
		p.setPoster(poster);
		p.setPollTitle(pollTitle);
		p.setPollContent(pollContent);
		p.setTag(polltag);
		db.postAPoll(poster,  p);
		System.out.println("new poll created!");
		User u = db.getUser(poster);
		return new ModelAndView("UserHomePage", "user", u); 
	}

	@RequestMapping("/UserHomePage")  
	public ModelAndView userHomePage(HttpServletRequest request,HttpServletResponse res) {  
		String message = request.getParameter("message");
		String name = request.getParameter("name");
		User u = db.getUser(name);
		return new ModelAndView("UserHomePage", "user", u).addObject("message", message);  
	} 

	@RequestMapping("/poll")  
	public ModelAndView pollPage(HttpServletRequest request,HttpServletResponse res) {  
		int pid = Integer.parseInt(request.getParameter("pollId"));
		String name = request.getParameter("name");
		Poll p = db.getPoll(pid);
		return new ModelAndView("poll", "poll", p).addObject("name", name);  
	} 
	
	@RequestMapping("/pollResults")  
	public ModelAndView pollResults(HttpServletRequest request,HttpServletResponse res) {  
		int pid = Integer.parseInt(request.getParameter("pollId"));
		String name = request.getParameter("name");
		Poll p = db.getPoll(pid);
		int numberOfPeopleVoted = 0;
		Double total = 0.0;
		for(int i = 0; i<p.getPollResults().length; i++){
			total += p.getPollResults()[i]*(i+1);
			numberOfPeopleVoted += p.getPollResults()[i];
		}
		Double average = total/numberOfPeopleVoted;
		return new ModelAndView("pollResults", "poll", p).addObject("name", name).addObject("average", average).addObject("numberOfPeopleVoted", numberOfPeopleVoted);  
	} 

	@RequestMapping("/submitRating")  
	public ModelAndView submitRating(HttpServletRequest request,HttpServletResponse res) {  
		String message = "You have successfully submitted a poll.";
		int rating = Integer.parseInt(request.getParameter("rating"));
//		System.out.println(rating);
		String name = request.getParameter("user");
//		System.out.println(name);
		int pid = Integer.parseInt(request.getParameter("pollId"));
//		System.out.println(pid);
		User u = db.getUser(name);
		int result = db.fillPoll(name, pid, rating);
		if(result == -1){
			message = "You have voted this poll. Try others!";
		}
		return new ModelAndView("UserHomePage","message", message).addObject("user", u);  
	}
	
	@RequestMapping("/category")  
	public ModelAndView seeCategory(HttpServletRequest request,HttpServletResponse res) {  
		String name = request.getParameter("name");
		String tag = request.getParameter("tag");
		List<Poll> list = null;
		if(tag == null){
			list = db.getAllPolls();
		}else{
			list = db.getTaggedPolls(tag);
		}
		return new ModelAndView("SeeAvailablePolls", "pollList", list).addObject("name", name);  
	}
	
}  