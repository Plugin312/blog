package boke.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import boke.dao.UserDao;
import boke.po.User;



public class UserDaoHibernate extends HibernateDaoSupport implements UserDao{

	@Override
	public User get(String name) {
		// TODO Auto-generated method stub
		String hql = "from User where name = '"+name+"'";
		@SuppressWarnings("unchecked")
		List<User> list = getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(user);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		User user = getHibernateTemplate().get(User.class, id);
		getHibernateTemplate().delete(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>)getHibernateTemplate().find("from User");
	}

	@Override
	public User getauth(String author) {
		// TODO Auto-generated method stub
		String hql = "from User where author = '"+author+"'";
		@SuppressWarnings("unchecked")
		List<User> list = getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
		
	}
	
}
