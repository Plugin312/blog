package boke.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import boke.dao.CommentDao;
import boke.po.Comments;

public class CommentDaoHibernate extends HibernateDaoSupport implements CommentDao{

	@Override
	public void save(Comments comment) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(comment);
	}

	@Override
	public void update(Comments comment) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(comment);
	}

	@Override
	public void delete(Comments comment) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(comment);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Comments comment = getHibernateTemplate().get(Comments.class, id);
		getHibernateTemplate().delete(comment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comments> findAll() {
		// TODO Auto-generated method stub
		System.out.println("fsfsdfs");
		List<Comments> list = (List<Comments>)getHibernateTemplate().find("from Comments");
		Comments com = list.get(0);
		System.out.println(com);
		return 	(List<Comments>)getHibernateTemplate().find("from Comments");
	}
	
	@Override
	public List<Comments> get(Integer bid) {
		// TODO Auto-generated method stub
		String hql = "from Comments where bid = '"+bid+"'";
		@SuppressWarnings("unchecked")
		List<Comments> list = getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public Comments getById(Integer pid) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Comments.class, pid);
	}

}
