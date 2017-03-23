package boke.dao.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import boke.po.User;

public interface UserManager {

	/**
	 * 绠＄悊鍛樼櫥褰?	 * @param username 绠＄悊鍛樼敤鎴峰悕
	 * @param password 绠＄悊鍛樺瘑鐮?	 * @return
	 */
	//用户登录
	boolean login(String username,String password,HttpSession session);
	
	//閫氳繃ID鍘绘壘user
	public User getUserByName(String name,HttpSession session);
	
	//用户注册
	void insert(String username,String author,String password);
	//用户修改
	void update(String username,String author,String password);
	
	//判断用户是否存在
	boolean existUser(String username);
	
	//找到自己的信息
	public User findblog(String username);
		
	//getuser
	public User getUser(HttpSession session);
	
	public Integer getAuthor(String author);
	
	public void setSession(String username,HttpSession session);
	
	public List<User> alluser();
	
	public User fbByname(String author);
	
}
