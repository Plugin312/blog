package boke.po;

import java.util.HashSet;
import java.util.Set;

public class Btypes {
	Integer tid;
	String name;
	@SuppressWarnings("rawtypes")
	Set myblog = new HashSet(0);
	public Btypes() {
		super();
	}
	public Btypes(Integer tid, String name) {
		super();
		this.tid = tid;
		this.name = name;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set getMyblog() {
		return myblog;
	}
	public void setMyblog(Set myblog) {
		this.myblog = myblog;
	}
	@Override
	public String toString() {
		return "Btypes [tid=" + tid + ", name=" + name + ", myblog=" + myblog + "]";
	}
	
	
	
	
}
