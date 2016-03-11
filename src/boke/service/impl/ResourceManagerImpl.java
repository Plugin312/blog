package boke.service.impl;

import java.util.List;

import boke.dao.service.ResourceManager;
import boke.po.Resource;
import boke.po.ResourceType;
import boke.service.util.ManagerTemplate;

public class ResourceManagerImpl extends ManagerTemplate implements ResourceManager {

	/**
	 * 新增资源信息
	 * @param rname 资源名
	 * @param uploader 上传者
	 * @param uploaddate 上传日期
	 * @param rtname 资源类型名称
	 */
	@Override
	public boolean insertResource(String rname, String uploader, String uploaddate, String rtname) {
		ResourceType rt=this.resourceTypeDao.get(rtname);
		if(rt!=null){
			Resource resource=new Resource();
			resource.setRname(rname);
			resource.setUploader(uploader);
			resource.setUploaddate(uploaddate);
			resource.setResourcetype(rt);
			this.resourceDao.save(resource);
			return true;
		}
		return false;
	}

	/**
	 * 删除指定资源名的资源
	 * @param rname 资源名
	 */
	@Override
	public boolean deleteResource(String rname) {
		Resource r=this.resourceDao.get(rname);
		if(r!=null){
			this.resourceDao.delete(r);
			return true;
		}
		
		return false;
	}

	/**
	 * 获取全部资源
	 * @return 内容为Resource的Set集合
	 */
	@Override
	public List<Resource> getAll() {
		
		return this.resourceDao.getAll();
	}

	/**
	 * 获取指定上传者的资源
	 * @return 内容为Resource的Set集合
	 */
	@Override
	public List<Resource> getResourcesByUploader(String uploaderName) {
		
		return this.resourceDao.getResourcesByUploader(uploaderName);
	}

	/**
	 * 获取接近资源名的资源
	 * @return 内容为Resource的Set集合
	 */
	@Override
	public List<Resource> getResourcesByName(String searchName) {
		
		return this.resourceDao.getResourcesByName(searchName);
	}
	
	
	/**
	 * 获取指定类型的资源
	 * @return 内容为Resource的Set集合
	 */
	@Override
	public List<Resource> getResourcesByType(String typeName) {
		
		ResourceType rt=this.resourceTypeDao.get(typeName);
		if(rt!=null)
			return this.resourceDao.getResourcesByType(rt);
		return null;
	}

	

}
