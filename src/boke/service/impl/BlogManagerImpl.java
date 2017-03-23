package boke.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import boke.bean.Search;
import boke.dao.service.BlogManager;
import boke.po.Blog;
import boke.service.util.ManagerTemplate;
import jsx3.app.Server;


public class BlogManagerImpl extends ManagerTemplate implements BlogManager{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public List<Blog> QueryAll() {
//		List<Blog> list = this.getBlogDao().findAll();
//		for(Blog b:list){
//			System.out.println(b);
//		}
		return this.getBlogDao().findAll();
	}
	
	
	@Override
	public Blog getBlogText(Integer bid) {
		// TODO Auto-generated method stub
		
				Blog blog = this.getBlogDao().getById(bid);
				Integer n = blog.getViewed();
				blog.setViewed(n+1);
				this.getBlogDao().update(blog);
			
			return blog;
	
		
	}


//	@Override
//	public Blog getSession(HttpSession session) {
//		// TODO Auto-generated method stub
//		return (Blog)session.getAttribute("blog");
//	}
//	
	
	public List<Blog> paixu(int page) {
		
		return (List<Blog>)this.getBlogDao().findDataByPage_tuijian((page - 1) * PAGE_SIZE, PAGE_SIZE);
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
	//	String maincontent = text.substring(0, 7000);
		String maincontent = "";
//		int count = maincontent.lastIndexOf(">");
//		maincontent = maincontent.substring(0, count);
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
		if(ti!=null){
		for(Blog b:list){
			if(Search.search_title(b.getTitle(),ti)){
				list1.add(b);
			}
//			if(b.getTitle().contains(ti)){
//				list1.add(b);
//			}
		}}
		return list1;
	}


	@Override
	public List<Blog> getADataByPage(int page) {
		// TODO Auto-generated method stub
		return (List<Blog>)this.getBlogDao().findDataByPage((page - 1) * PAGE_SIZE, PAGE_SIZE);
	}


	@Override
	public int getBlogLength() {
		return this.getBlogDao().getLength();
	}


	
	public static void main(String[] args) {
		BlogManagerImpl b = new BlogManagerImpl();
		System.out.println(b.getBlogLength());
	}
	
}
