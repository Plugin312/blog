package boke.dao;

import java.util.List;

import boke.po.User;


  
public interface UserDao {
	User get(String username);
	
	User getauth(String author);

	void save(User User);

	void update(User User);

	void delete(User User);

	void delete(String id);

	List<User> findAll();
	
}
