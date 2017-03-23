package boke.dao.service;

import java.util.List;

import boke.po.Resource;

public interface ResourceManager {
	
	public static final int PAGE_SIZE = 5;
	
	boolean insertResource(String rname,String uploader,String uploaddate,String rtname);
	
	boolean deleteResource(String rname);
	
	List<Resource> getAll();
	
	List<Resource> getResourcesByUploader(String uploaderName);
	
	List<Resource> getResourcesByName(String searchName);
	
	List<Resource> getResourcesByType(String  typeName);
	
	

	/**
	 * 分页得到数据
	 * 
	 * @param page
	 * @param session
	 * @return
	 */
	public List<Resource> getResourcesByPage(int page);
	
	public int getResourcesCount() ;
	
	public int getPageCount() throws Exception;
	
	public int getPageSize();


}
