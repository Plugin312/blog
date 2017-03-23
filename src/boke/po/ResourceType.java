package boke.po;

import java.util.Set;

public class ResourceType {
	
	String rtid;
	String rtname;
	Set<Resource> resources;
	
	
	
	
	
	public ResourceType() {
		super();
	}
	
	
	
	
	public ResourceType(String rtname) {
		super();
		this.rtname = rtname;
	}




	public Set<Resource> getResources() {
		return resources;
	}


	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}


	public String getRtid() {
		return rtid;
	}
	public void setRtid(String rtid) {
		this.rtid = rtid;
	}
	public String getRtname() {
		return rtname;
	}
	public void setRtname(String rtname) {
		this.rtname = rtname;
	}
	@Override
	public String toString() {
		return "ResourceType [rtid=" + rtid + ", rtname=" + rtname + "]";
	}
	
	

}
