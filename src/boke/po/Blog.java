package boke.po;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class Blog implements Serializable{
	Integer bid;
	Integer use_uid;
	String title;
	String texts;
	String maincontent;
	Integer viewed;
	Integer commentcounts;
	Date releasedate;
	String author;
	Integer tid;
	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	User user;
	Btypes btypes;
	@SuppressWarnings("rawtypes")
	Set com = new HashSet(0);
	
	
	

	@SuppressWarnings("rawtypes")
	public Set getCom() {
		return com;
	}

	@SuppressWarnings("rawtypes")
	public void setCom(Set com) {
		this.com = com;
	}

	public Btypes getBtypes() {
		return btypes;
	}

	public void setBtypes(Btypes btypes) {
		this.btypes = btypes;
	}

	public Blog(Integer bid, Integer use_uid, String title, String texts, String maincontent, Integer viewed,
			Integer commentcounts, Date releasedate, String author, User user) {
		super();
		this.bid = bid;
		this.use_uid = use_uid;
		this.title = title;
		this.texts = texts;
		this.maincontent = maincontent;
		this.viewed = viewed;
		this.commentcounts = commentcounts;
		this.releasedate = releasedate;
		this.author = author;
		this.user = user;
	}

	

	public Blog(Integer use_uid, String title, String texts, String maincontent, Integer viewed, Integer commentcounts,
			Date releasedate, String author, Integer tid) {
		super();
		this.use_uid = use_uid;
		this.title = title;
		this.texts = texts;
		this.maincontent = maincontent;
		this.viewed = viewed;
		this.commentcounts = commentcounts;
		this.releasedate = releasedate;
		this.author = author;
		this.tid = tid;
	}

	public Blog() {
		super();
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getUse_uid() {
		return use_uid;
	}
	public void setUse_uid(Integer use_uid) {
		this.use_uid = use_uid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTexts() {
		return texts;
	}
	public void setTexts(String texts) {
		this.texts = texts;
	}
	public String getMaincontent() {
		return maincontent;
	}
	public void setMaincontent(String maincontent) {
		this.maincontent = maincontent;
	}
	public Integer getViewed() {
		return viewed;
	}
	public void setViewed(Integer viewed) {
		this.viewed = viewed;
	}
	public Integer getCommentcounts() {
		return commentcounts;
	}
	public void setCommentcounts(Integer commentcounts) {
		this.commentcounts = commentcounts;
	}
	public Date getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}

	@Override
	public String toString() {
		return "Blog [bid=" + bid + ", use_uid=" + use_uid + ", title=" + title + ", viewed=" + viewed
				+ ", commentcounts=" + commentcounts + ", releasedate=" + releasedate + ", author=" + author + "]";
	}

//	@Override
//	public String toString() {
//		return "Blog [bid=" + bid + ", use_uid=" + use_uid + ", title=" + title + ", texts=" + texts + ", maincontent="
//				+ maincontent + ", viewed=" + viewed + ", commentcounts=" + commentcounts + ", releasedate="
//				+ releasedate + ", author=" + author + ", user=" + user + "]";
//	}
	

	
	
}
