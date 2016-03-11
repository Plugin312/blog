package boke.service.impl;

import java.util.List;

import boke.dao.service.ResourceTypeManager;
import boke.po.ResourceType;
import boke.service.util.ManagerTemplate;

public class ResourceTypeManagerImpl extends ManagerTemplate implements ResourceTypeManager {


	/**
	 * 插入资源类型
	 * @param rtname  类型名
	 * @return 
	 */
	@Override
	public boolean insertResourceType(String rtname) {
	
		try{
			ResourceType rt=new ResourceType();
			rt.setRtname(rtname);
			this.resourceTypeDao.save(rt);
			return true;
		}catch(Exception e){
			return false;
		}
		

	}

	/**
	 * 根据类型名获取资源类型
	 * @param rtname  类型名
	 */
	@Override
	public ResourceType getResourceType(String rname) {
		
		return this.resourceTypeDao.get(rname);
	}
	
	/**
	 * 更新资源类型
	 * @param old_rtname  旧类型名
	 * @param new_rtname  新类型名
	 */
	@Override
	public boolean updateResourceType(String old_rtname, String new_rtname) {
		if(deleteResourceType(old_rtname)&&insertResourceType(new_rtname))
			return true;
		return false;
		

	}

	/**
	 * 删除资源类型
	 * @param rtname  类型名
	 */
	@Override
	public boolean deleteResourceType(String rtname) {
		try{
			ResourceType rt=getResourceType(rtname);
			this.resourceTypeDao.delete(rt);
			return true;
		}catch(Exception e){
			return false;
		}
		

	}

	/**
	 * 获取资源类型列表
	 * 
	 */
	@Override
	public List<ResourceType> getAll() {
		
		return this.resourceTypeDao.getAll();
	}

	

}
