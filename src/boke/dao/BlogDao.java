package boke.dao;

import java.util.List;

import boke.po.Blog;


public interface BlogDao {
	
	Blog get(String title); //¹Ø¼ü×Ö¼ìË÷

	Blog getById(Integer bid);
	
	void save(Blog blog);

	void update(Blog blog);

	void delete(Blog blog);

	void delete(Integer id);

	List<Blog> findAll();
	
	int getLength();
	
	public List<Blog> findDataByPage(final int offset, final int pageSize);
	
	public List<Blog> findDataByPage_tuijian(final int offset, final int pageSize);
}
