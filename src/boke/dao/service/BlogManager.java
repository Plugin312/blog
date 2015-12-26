package boke.dao.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import boke.po.Blog;

public interface BlogManager {
	public List<Blog> QueryAll();
	
	public void registSession(Integer bid,HttpSession session);
	
	public Blog getSession(HttpSession session);
	
	public List<Blog> paixu();
	
	public void zjcom(Integer bid);
	
	public void submit(Integer uid,Integer tid,String text,String title,String author);
	
	//±ÍÃ‚≤È’“
	public List<Blog> findTitle(String ti);
}
