package boke.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import boke.dao.service.BlogManager;
import boke.po.Blog;
import boke.service.util.ManagerTemplate;


public class BlogManagerImpl extends ManagerTemplate implements BlogManager{

	@Override
	public List<Blog> QueryAll() {
//		List<Blog> list = this.getBlogDao().findAll();
//		for(Blog b:list){
//			System.out.println(b);
//		}
		return this.getBlogDao().findAll();
	}
	
	
	@Override
	public void registSession(Integer bid, HttpSession session) {
		// TODO Auto-generated method stub
		List<Blog> list = this.getBlogDao().findAll();
		
		for(Blog blog:list){
			if(blog.getBid()==bid){
				Integer n = blog.getViewed();
				blog.setViewed(n+1);
				this.getBlogDao().update(blog);
				session.setAttribute("blog", blog);
				break;
			}
		}
		
	}


	@Override
	public Blog getSession(HttpSession session) {
		// TODO Auto-generated method stub
		return (Blog)session.getAttribute("blog");
	}
	
	
	public List<Blog> paixu() {
		List<Blog> list = this.getBlogDao().findAll();
		 Collections.sort(list, new Comparator<Blog>(){   
	          
				public int compare(Blog b1, Blog b2) {   
	               
	                //按照学生的年龄进行升序排列   
	                if(b2.getViewed() < b1.getViewed()){   
	                    return 1;   
	                }   
	                if(b1.getViewed() == b2.getViewed()){   
	                    return 0;   
	               }   
	               return -1;   
	            }

				
	        });    
//		 for(Blog b:list){
//			 System.out.println(b);
//		 }
		return list;
	}


	@Override
	public void zjcom(Integer bid) {
		// TODO Auto-generated method stub
		Blog blog = this.getBlogDao().getById(bid);
		blog.setCommentcounts(blog.getCommentcounts()+1);
		this.getBlogDao().update(blog);
	}


	@Override
	public void submit(Integer uid,Integer tid,String text, String title, String author) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		int count = 0;
		String maincontent = "";
		  String regEx = "[\\u4e00-\\u9fa5]";
		  Pattern p = Pattern.compile(regEx);
		  Matcher m = p.matcher(text);
		  while (m.find()&&count<150) {
			  count++;
			  maincontent += m.group(0);
		  }
		
		Date date = new Date();
		Blog blog = new Blog(uid,title,text,maincontent,0,0,date,author,tid);
		this.getBlogDao().save(blog);
	}


	@Override
	public List<Blog> findTitle(String ti) {
		// TODO Auto-generated method stub
		List<Blog> list = this.getBlogDao().findAll();
		List<Blog> list1 = new ArrayList<Blog>();
		for(Blog b:list){
			if(b.getTitle().contains(ti)){
				list1.add(b);
			}
		}
		return list1;
	}
	
	
}
