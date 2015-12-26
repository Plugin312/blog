package boke.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import boke.dao.BlogDao;
import boke.po.Blog;



public class BlogDaoHibernate extends HibernateDaoSupport implements BlogDao {

	@Override
	public Blog get(String title) {
		// TODO Auto-generated method stub
		String hql = "from Blog where title = '"+title+"'";
		@SuppressWarnings("unchecked")
		List<Blog> list = getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void save(Blog blog) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(blog);
	}

	@Override
	public void update(Blog blog) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(blog);
	}

	@Override
	public void delete(Blog blog) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(blog);
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Blog blog = getHibernateTemplate().get(Blog.class, id);
		getHibernateTemplate().delete(blog);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> findAll() {
		// TODO Auto-generated method stub
		return (List<Blog>)getHibernateTemplate().find("from Blog");
	
	}

	@Override
	public Blog getById(Integer bid) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Blog.class, bid);
	}

}
