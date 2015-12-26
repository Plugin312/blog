package boke.dao.service;

import java.util.List;

import boke.po.Resource;
import boke.po.ResourceType;

public interface ResourceManager {
	
	boolean insertResource(String rname,String uploader,String uploaddate,String rtname);
	
	boolean deleteResource(String rname);
	
	List<Resource> getAll();
	
	List<Resource> getResourcesByUploader(String uploaderName);
	
	List<Resource> getResourcesByName(String searchName);
	
	List<Resource> getResourcesByType(String  typeName);

}
