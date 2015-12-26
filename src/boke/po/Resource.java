package boke.po;

import java.util.Set;

public class Resource {
	
	String rid;
	String rname;
	String uploader;
	String uploaddate;
	ResourceType resourcetype;
	
	
	
	
	
	public ResourceType getResourcetype() {
		return resourcetype;
	}
	public void setResourcetype(ResourceType resourcetype) {
		this.resourcetype = resourcetype;
	}
	public Resource() {
		super();
	}
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public String getUploaddate() {
		return uploaddate;
	}
	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	@Override
	public String toString() {
		return "Resource [rid=" + rid + ", rname=" + rname + "]";
	}
	
	

}
