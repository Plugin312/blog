package boke.service.util;

import boke.dao.BlogDao;
import boke.dao.BtypesDao;
import boke.dao.CommentDao;
import boke.dao.ResourceDao;
import boke.dao.ResourceTypeDao;
import boke.dao.UserDao;

public class ManagerTemplate implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected UserDao userDao;
	protected BlogDao blogDao;
	protected BtypesDao btypesDao;
	protected CommentDao commentDao;
	protected ResourceTypeDao resourceTypeDao;
	
	
	public ResourceTypeDao getResourceTypeDao() {
		return resourceTypeDao;
	}

	public void setResourceTypeDao(ResourceTypeDao resourceTypeDao) {
		this.resourceTypeDao = resourceTypeDao;
	}

	public ResourceDao getResourceDao() {
		return resourceDao;
	}

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	protected ResourceDao resourceDao;

	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	public BtypesDao getBtypesDao() {
		return btypesDao;
	}

	public void setBtypesDao(BtypesDao btypesDao) {
		this.btypesDao = btypesDao;
	}

	public BlogDao getBlogDao() {
		return blogDao;
	}

	public void setBlogDao(BlogDao blogDao) {
		this.blogDao = blogDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
