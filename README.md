### 增加加预览之后的博客代码 ###
+ 系统根据用户发表的博文的类型将博客分成不同的类别，并提供智能检索的功能，其他用户访问该系统时可以根据自己的需求很快的找到满意的博客，并且还可以通过评论回复的功能与博主实时交流学习。此外系统还包括文件的上传和下载功能，程序员们可以将自己写好的代码和文档上传至本系统，实现资源共享和资源预览。
### 使用方法 ###
#### 用使用前的准备
+ 安装包下载
	1. openoffice是Apache下的一个开放免费的文字处理软件<br>
   		下载地址：Apache oppenoffice 官网下载 版本-3.4.1
	2. SWFTools是一组用来处理Flash的swf文件的工具包，我们使用它将pdf文件转成swf文件!<br>
   		下载地址：SWFTools官网下载 swftools-2013-04-09-1007.exe
	3. FlexPaper是一个开源轻量级的在浏览器上显示各种文档的组件<br>
   	下载地址：FlexPaper官网下载 版本1.5.1
	4. JODConverter一个Java的OpenDocument 文件转换器，在此我们只用到它的jar包<br>
   		下载地址：JODCConverter下载
+ 启动服务
	+ 打开dos窗口，进入openoffice安装盘符，输入以下代码来启动服务：
	
			soffice -headless -accept="socket,host=127.0.0.1,port=8100;urp;" -nofirststartwizard
+ web.xml:将下面的路径改成本地机器文件上传的路径。

		      <param-name>file-upload</param-name>
		    <param-value>
		         F:\合并\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Blog\blogResources\
		     </param-value>

+ DocConverter类：下面的路径改成本地pdf2swf.exe的路径。

 			Process p = r.exec("C:/Program Files/SWFTools/pdf2swf.exe " + pdfFile.getPath() + " -o " + swfFile.getPath() + " -T 9"); 

+ ResourceManagerImpl类：改Preview函数里面的我路径。

### 大功告成 
 