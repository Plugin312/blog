package boke.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;


import boke.dao.service.UserManager;
import boke.po.User;
import boke.service.util.ManagerTemplate;


public class UserManagerImpl extends ManagerTemplate implements UserManager {
	
	@Override
	public boolean login(String username,String password,HttpSession session) {
		if(!username.equals("wobushi-user")){
			//session.setAttribute("username", username);
			User user = null;
			user =  this.getUserDao().get(username);
			if(user==null){
				return false;
			}
			
			username = username +"*"+ user.getAuthor();
			session.setAttribute("username", username);
			if(user.getPassword().equals(password))
			return true;
		}else{
			session.setAttribute("username", username);
		}
		return false;
	}

	

	@Override
	public void insert(String username,  String author,String password) {
		User user = new User();
		user.setName(username);
		user.setPassword(password);
		user.setAuthor(author);
		this.getUserDao().save(user);
	
	}

	@Override
	public boolean existUser(String username) {
		User user = null;
		user =  this.getUserDao().get(username);
		if(user==null){
			return true;
		}
		return false;

	}
	
	
	public String checkSession(HttpSession session) {
		if (session.getAttribute("username") == null)
			return null;
		else
			return (String)session.getAttribute("username");
	}

	
	//找到自己的博客
	@Override
	public User findblog(String name) {
		User user =  this.getUserDao().get(name);
		return user;
	}



	@Override
	public User getUserByName(String name,HttpSession session) {
		User user = this.getUserDao().get(name);
		session.setAttribute("user", user);
		return user;
	}



	@Override
	public User getUser(HttpSession session) {
		// TODO Auto-generated method stub
		
		return (User)session.getAttribute("user");
	}



	@Override
	public void update(String username, String author, String password) {
		User user1 = this.getUserDao().get(username); 
		User user = new User(user1.getId(),username,password,author);
		System.out.println(user);
		this.getUserDao().update(user);
	}



	@Override
	public Integer getAuthor(String author) {
		// TODO Auto-generated method stub
		User user = this.getUserDao().getauth(author);
		return user.getId();
	}



	@Override
	public void setSession(String username,HttpSession session) {
		// TODO Auto-generated method stub
		session.setAttribute("username", username);
	}



	@Override
	public List<User> alluser() {
		// TODO Auto-generated method stub
		return this.getUserDao().findAll();
	}



	@Override
	public User fbByname(String author) {
		// TODO Auto-generated method stub
		return this.getUserDao().getauth(author);
	}



	
}
