package boke.dao.service;

import java.util.List;

import boke.po.ResourceType;

public interface ResourceTypeManager {
	
	//插入一个资源类型
	boolean insertResourceType(String rtname);
	
	//更新资源类型
	boolean updateResourceType(String old_rtname,String new_rtname);
	
	//删除当前资源类型
	boolean deleteResourceType(String rtname);
	
	//获取资源类型列表
	List<ResourceType> getAll();
	
	//获取指定资源名的资源类型
	ResourceType getResourceType(String rname);
	
	

}
