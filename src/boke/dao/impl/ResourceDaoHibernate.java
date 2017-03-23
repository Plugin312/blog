package boke.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import boke.dao.ResourceDao;
import boke.po.Resource;
import boke.po.ResourceType;

public class ResourceDaoHibernate extends HibernateDaoSupport implements ResourceDao {

	@Override
	public void save(Resource resource) {
		getHibernateTemplate().save(resource);

	}

	@Override
	public void delete(Resource resource) {
		getHibernateTemplate().delete(resource);
		
	}

	@Override
	public Resource get(String rname) {
		String hql = "from Resource where rname = '"+rname+"'";
		@SuppressWarnings("unchecked")
		List<Resource> list = getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getAll() {
		return getHibernateTemplate().find("from Resource");
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getResourcesByName(String searchName) {
		return getHibernateTemplate().find("from Resource where rname like '%"+searchName+"%'");
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getResourcesByUploader(String uploaderName) {
		return getHibernateTemplate().find("from Resource where uploader='"+uploaderName+"'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getResourcesByType(ResourceType resourceType) {
		
		return getHibernateTemplate().find("from Resource where rtid='"+resourceType.getRtid()+"'");
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> findDataByPage(final int offset, final int pageSize) {
		final String hql = "from Resource order by rid";
		List list=getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException 
			{
				List result=session.createQuery(hql)
						.setFirstResult(offset)
						.setMaxResults(pageSize)
						.list();
				return result;
			}
			
		});
		return list;
	}

	@Override
	public int getDataCount() {
		final String hql = "select count(*) from Resource";
		int count = getHibernateTemplate().execute(
				new HibernateCallback<Long>() {
					@Override
					public Long doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						return (long) query.uniqueResult();
					}
				}).intValue();
		return count;
	}

	

}
