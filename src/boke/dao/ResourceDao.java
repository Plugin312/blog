package boke.dao;

import java.util.List;

import boke.po.Resource;
import boke.po.ResourceType;

public interface ResourceDao {
	
	void save(Resource resource);
	
	void delete(Resource resource);
	
	Resource get(String rname);
	
	List<Resource> getAll();
	
	List<Resource> getResourcesByUploader(String uploaderName);
	
	List<Resource> getResourcesByName(String searchName);
	
	List<Resource> getResourcesByType(ResourceType resourceType);
	
	/**
	 * 分页查找数据
	 * 
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Resource> findDataByPage(int offset, int pageSize);
	
	/**
	 * 得到数据总数 
	 * @return 数据总数
	 */
	 int getDataCount();
	

}
