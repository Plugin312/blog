package boke.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import boke.dao.BtypesDao;
import boke.po.Blog;
import boke.po.Btypes;

public class BtypesDaoHibernate extends HibernateDaoSupport implements BtypesDao{

	@Override
	public void save(Btypes btypes) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(btypes);
	}

	@Override
	public void update(Btypes btypes) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(btypes);
	}

	@Override
	public void delete(Btypes btypes) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(btypes);
	}

	@Override
	public void delete(Integer tid) {
		// TODO Auto-generated method stub
		Btypes btypes = getHibernateTemplate().get(Btypes.class, tid);
		getHibernateTemplate().delete(btypes);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Btypes> findAll() {
		
		return (List<Btypes>)getHibernateTemplate().find("from Btypes");
	}

	@Override
	public Btypes get(Integer tid) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Btypes.class, tid);
	}

	@Override
	public Btypes getByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Btypes where name = '"+name+"'";
		@SuppressWarnings("unchecked")
		List<Btypes> list = getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
