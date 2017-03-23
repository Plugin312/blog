package boke.po;

import java.util.Date;

public class Comments {
	Integer pid;
	Integer bid;
	Integer uid;
	String ptext;
	Date pdate;
	String reply;
	Date replydate;
	Blog b;
	
	public Comments() {
		super();
	}
	public Comments(Integer bid, Integer uid, String ptext, Date pdate) {
		super();
		this.bid = bid;
		this.uid = uid;
		this.ptext = ptext;
		this.pdate = pdate;
	}
	public Comments(Integer bid, Integer uid, String ptext, Date pdate, String reply, Date replydate) {
		super();
		this.bid = bid;
		this.uid = uid;
		this.ptext = ptext;
		this.pdate = pdate;
		this.reply = reply;
		this.replydate = replydate;
	}
	@Override
	public String toString() {
		return "Comment [pid=" + pid + ", bid=" + bid + ", uid=" + uid + ", ptext=" + ptext + ", pdate=" + pdate
				+ ", reply=" + reply + ", replydate=" + replydate + ", getB()=" + getB() + ", getPid()=" + getPid()
				+ ", getBid()=" + getBid() + ", getUid()=" + getUid() + ", getPtext()=" + getPtext() + ", getPdate()="
				+ getPdate() + ", getReply()=" + getReply() + ", getReplydate()=" + getReplydate() + ", getUser()="
				+ getUser() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public Blog getB() {
		return b;
	}
	public void setB(Blog b) {
		this.b = b;
	}
	User user;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getPtext() {
		return ptext;
	}
	public void setPtext(String ptext) {
		this.ptext = ptext;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Date getReplydate() {
		return replydate;
	}
	public void setReplydate(Date replydate) {
		this.replydate = replydate;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
