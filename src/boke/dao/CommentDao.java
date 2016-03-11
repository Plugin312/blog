package boke.dao;


import java.util.List;

import boke.po.Comments;

public interface CommentDao {
	

	void save(Comments comment);

	void update(Comments comment);

	void delete(Comments comment);

	void delete(Integer id);

	List<Comments> findAll();
	
	
	List<Comments> get(Integer bid);
	
	Comments getById(Integer pid);
}
