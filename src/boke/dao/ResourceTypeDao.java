package boke.dao;

import java.util.List;

import boke.po.ResourceType;
public interface ResourceTypeDao {
	
	void save(ResourceType rtype);
	
	void update(ResourceType rtype);
	
	void delete(ResourceType rtype);
	
	ResourceType get(String rtname);
	
	List<ResourceType> getAll();

}
