package boke.service.impl;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import boke.bean.DocConverter;
import boke.bean.Tools;
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
		String lunname=null;
		if(rt!=null){
			Resource resource=new Resource();
			resource.setRname(rname);
			boolean flag = Tools.isContainsChinese(rname);
			if(flag){
				lunname = Tools.getRandomString(25)+".";
				lunname += rname.split("\\.")[1];
			}else{
				lunname = rname;
			}
			resource.setLunname(lunname);
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

	@Override
	public List<Resource> getResourcesByPage(int page) {
		
		return (List<Resource>) resourceDao.findDataByPage((page - 1) * PAGE_SIZE, PAGE_SIZE);
	}
	
	@Override
	public int getResourcesCount() {
		return resourceDao.getDataCount();
	}

	@Override
	public int getPageCount() throws Exception{
		if(getResourcesCount()%PAGE_SIZE==0){
			return getResourcesCount()/PAGE_SIZE;
		}else{
			return getResourcesCount()/PAGE_SIZE+1;
		}
	}

	@Override
	public int getPageSize() {
		return PAGE_SIZE;
	}

	
	public String Preview(String rname,String lunname){
		String swfstr = "";
		String swfpath="";
		System.out.println(rname);
		 //调用转换类DocConverter,并将需要转换的文件传递给该类的构造方法  
		 DocConverter d = new DocConverter("F:/合并/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Blog/blogResources/"+rname);  
		 //调用conver方法开始转换，先执行doc2pdf()将office文件转换为pdf;再执行pdf2swf()将pdf转换为swf;
		 d.conver();
		 System.out.println(lunname+"fdgd");
		 System.out.println("##"+d.getswfPath());
		 System.out.println("###F:/合并/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Blog/blogResources/"+lunname.split("\\.")[0]+".swf");
		 boolean flag = Tools.isContainsChinese(d.getswfPath());
		 if(flag){
			Tools.renameFile(d.getswfPath(), "F:/合并/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Blog/blogResources/"+lunname.split("\\.")[0]+".swf");
			swfpath = "blogResources/"+lunname.split("\\.")[0]+".swf";
		 }
		  //生成swf相对路径，以便传递给flexpaper播放器  
		 else{
			  swfstr = d.getswfPath().substring(d.getswfPath().lastIndexOf("/"));
			  swfpath = "blogResources" + swfstr;  
		 }
		
		
       
		 System.out.println(d.getswfPath());
		 System.out.println(lunname);
       System.out.println(swfpath);
         return swfpath;
	}

	
	
}
