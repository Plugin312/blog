package boke.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import boke.dao.ResourceTypeDao;
import boke.po.ResourceType;
import boke.po.User;

public class ResourceTypeDaoHibernate extends HibernateDaoSupport implements ResourceTypeDao {

	@Override
	public void save(ResourceType rtype) {
		getHibernateTemplate().save(rtype);

	}

	@Override
	public void update(ResourceType rtype) {
		getHibernateTemplate().update(rtype);

	}

	@Override
	public void delete(ResourceType rtype) {
		getHibernateTemplate().delete(rtype);

	}

	@Override
	public ResourceType get(String rtname) {
		
		String hql = "from ResourceType where rtname = '"+rtname+"'";
		@SuppressWarnings("unchecked")
		List<ResourceType> list = getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ResourceType> getAll() {
		return getHibernateTemplate().find("from ResourceType");
	}

}
