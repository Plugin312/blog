package boke.dao.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import boke.po.Blog;

public interface BlogManager {
	
	/*
	 *ҳ���С 
	 */
	public static final int PAGE_SIZE = 8;
	
	/*
	 *��ҳ����
	 */
	public List<Blog> getADataByPage(int page);
	
	public List<Blog> QueryAll();
	
	public Blog getBlogText(Integer bid);
	
	//public Blog getSession(HttpSession session);
	
	public List<Blog> paixu(int page);
	
	public void zjcom(Integer bid);
	
	public void submit(Integer uid,Integer tid,String text,String title,String author);
	
	//�������
	public List<Blog> findTitle(String ti);
	
	public int getBlogLength();
}
