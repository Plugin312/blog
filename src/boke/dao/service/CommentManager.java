package boke.dao.service;

import java.util.List;

import boke.po.Comments;

public interface CommentManager {
	public List<Comments> QueryAll();
	
	public List<Comments> getBybid(Integer bid);
	
	public void insertcom(Integer bid,Integer uid,String ptext);
	
	public void updatecomment(Integer pid,String preply);
	
	
}
