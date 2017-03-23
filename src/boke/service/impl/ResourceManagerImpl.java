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
	 * ������Դ��Ϣ
	 * @param rname ��Դ��
	 * @param uploader �ϴ���
	 * @param uploaddate �ϴ�����
	 * @param rtname ��Դ��������
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
	 * ɾ��ָ����Դ������Դ
	 * @param rname ��Դ��
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
	 * ��ȡȫ����Դ
	 * @return ����ΪResource��Set����
	 */
	@Override
	public List<Resource> getAll() {
		
		return this.resourceDao.getAll();
	}

	/**
	 * ��ȡָ���ϴ��ߵ���Դ
	 * @return ����ΪResource��Set����
	 */
	@Override
	public List<Resource> getResourcesByUploader(String uploaderName) {
		
		return this.resourceDao.getResourcesByUploader(uploaderName);
	}

	/**
	 * ��ȡ�ӽ���Դ������Դ
	 * @return ����ΪResource��Set����
	 */
	@Override
	public List<Resource> getResourcesByName(String searchName) {
		
		return this.resourceDao.getResourcesByName(searchName);
	}
	
	
	/**
	 * ��ȡָ�����͵���Դ
	 * @return ����ΪResource��Set����
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
		 //����ת����DocConverter,������Ҫת�����ļ����ݸ�����Ĺ��췽��  
		 DocConverter d = new DocConverter("F:/�ϲ�/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Blog/blogResources/"+rname);  
		 //����conver������ʼת������ִ��doc2pdf()��office�ļ�ת��Ϊpdf;��ִ��pdf2swf()��pdfת��Ϊswf;
		 d.conver();
		 System.out.println(lunname+"fdgd");
		 System.out.println("##"+d.getswfPath());
		 System.out.println("###F:/�ϲ�/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Blog/blogResources/"+lunname.split("\\.")[0]+".swf");
		 boolean flag = Tools.isContainsChinese(d.getswfPath());
		 if(flag){
			Tools.renameFile(d.getswfPath(), "F:/�ϲ�/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Blog/blogResources/"+lunname.split("\\.")[0]+".swf");
			swfpath = "blogResources/"+lunname.split("\\.")[0]+".swf";
		 }
		  //����swf���·�����Ա㴫�ݸ�flexpaper������  
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
