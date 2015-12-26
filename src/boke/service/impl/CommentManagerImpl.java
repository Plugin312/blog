package boke.service.impl;

import java.util.Date;
import java.util.List;


import boke.dao.service.CommentManager;
import boke.po.Comments;
import boke.service.util.ManagerTemplate;

public class CommentManagerImpl extends ManagerTemplate implements CommentManager{

	@Override
	public List<Comments> QueryAll() {
		// TODO Auto-generated method stub
		return this.getCommentDao().findAll();
	}

	@Override
	public List<Comments> getBybid(Integer bid) {
		// TODO Auto-generated method stub
		return this.getCommentDao().get(bid);
	}

	@Override
	public void insertcom(Integer bid, Integer uid, String ptext) {
		System.out.println(bid);
		Date pdate = new Date();
		Comments com = new Comments(bid,uid,ptext,pdate,"",pdate);
		this.getCommentDao().save(com);
	}

	@Override
	public void updatecomment(Integer pid, String preply) {
		// TODO Auto-generated method stub
		Comments com = this.getCommentDao().getById(pid);
		com.setReply(preply);
		this.getCommentDao().update(com);
	}

}
