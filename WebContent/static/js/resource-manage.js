$(document).ready(function(){
	
	showResourceTypes();
	
	//不同用户资源管理模块显示不同
	UserManager.checkSession(function(username){
		var user=username.split("*")[0];
		if(user=="admin"){
			$("#resource-manage").append("<li id='add-resourcetype' class='list-group-item'><a href='javascritp:void(0);'>目录新增</a></li>" +
			"<li id='delete-resourcetype' class='list-group-item'><a href='javascritp:void(0);'>目录删除</a></li>" +
			"<li id='delete-resources' class='list-group-item'><a href='javascritp:void(0);'>资源删除</a></li>");
			//目录新增
			$("#add-resourcetype").click(function(){
				var addText="<legend>目录新增</legend>" +
						"<div class='control-group'>" +
								"<label class='control-label' for='input01'>请输入你想添加的资源类型名：</label>" +
										"<div class='controls'>" +
												"<input type='text' class='input-xlarge' id='addrtname'>" +
														"<p class='help-block'>请输入简介明白的词语，方便其他人理解" +
										"</div>" +
						" </div>" +
						"<div class='form-actions'>" +
							"<button type='submit' class='btn btn-primary' id='do-add-resourcetype'>确认增加</button>" +
							"<button class='btn' id='cancel'>取消</button>" +
							"<label class='control-label' for='input01' id='addrtmsg'></label>" +
							"<button class='btn' id='return'>返回</button>" +
						" </div>";
				$("#show").html(addText);
				
				$("#cancel").click(function(){
					$("#addrtname").val("");
				});
				
				$("#return").click(function(){
					$("#addrtmsg").text("5秒后返回主页");	
					setTimeout(5000);
					window.parent.location.reload();
				});
				
				$("#do-add-resourcetype").click(function(){
					addResourceType();
				});
				
				
			});
			
			
			//目录删除
			$("#delete-resourcetype").click(function(){
				var deleteText="<legend>目录删除</legend>" +
						"<div class='control-group'>" +
								"<label class='control-label' for='input01'>请输入你想删除的资源类型名：</label>" +
										"<div class='controls'>" +
												"<input type='text' class='input-xlarge' id='deletertname'>" +
														"<p class='help-block'>该目录删除后会连带目录里边的资源一并删除，请谨慎选择！！！" +
										"</div>" +
						" </div>" +
						"<div class='form-actions'>" +
							"<button type='submit' class='btn btn-primary' id='do-delete-resourcetype'>确认删除</button>" +
							"<button class='btn' id='cancel'>取消</button>" +
							"<label class='control-label' for='input01' id='delrtmsg'></label>" +
							"<button class='btn' id='return'>返回</button>" +
						" </div>";
				
				$("#show").html(deleteText);
				
				$("#cancel").click(function(){
					$("#deletertname").val("");
				});
				
				$("#return").click(function(){
					$("#delrtmsg").text("5秒后返回主页");	
					setTimeout(5000);
					location.reload();
				});
				
				$("#do-delete-resourcetype").click(function(){
					deleteResourceType();
				});
				
			});
			
			//资源删除
			$("#delete-resources").click(function(){
				console.log("资源删除");
				$("#show").html(resourceText);
				ResourceManager.getAll(function(resources){
					for(var i=0;i<resources.length;i++){
						$("#resources").append("<tr><td>"
													+(i+1)+"</td><td>"
													+resources[i].rname+"</td><td>"
													+resources[i].uploader+"</td><td>"
													+resources[i].uploaddate+"</td><td>"+resources[i].resourcetype.rtname+"</td><td>" 
													+"<label class='demo--label'>" +
													"	<input class='demo--radio' type='checkbox' name='checkbox' value='"+resources[i].rname+"'>" +
													"	<span class='demo--checkbox demo--radioInput'></span>" +
													"</label></td></tr>");
					}
					});
				
				
				$("#show").append(buttonText);
				
				//全选
				$("#get-all-chooses").click(function(){
					$("input[name='checkbox']").prop('checked',true);
				});
				//取消
				$("#undo-all-chooses").click(function(){
					$("input[name='checkbox']").prop('checked',false);
				});
				
				//反选   
				$("#get-opposite-chooses").click(function(){   
					$("input[name='checkbox']").each(function(){
						$(this).prop("checked",!$(this).prop("checked"));
					})   
				});
				
				//删除选中的内容
				$("#get-selected-chooses").click(function(){//输出选中的值   
					$("input[name='checkbox']").each(function(){   
						if($(this).prop("checked")){
							console.log($(this).val());
							ResourceManager.deleteResource($(this).val(),function(flag){
								if(flag){
									$("#delete-msg").text("删除成功");
								}
								else{
									$("#delete-msg").text("删除失败");
								}
							});
						}else{
							console.log("不是我");
						}
					}) 
				}) ;
				
				
			});
			
		}
	
	});
	
	

	
	//上传资源
	$("#upload-resource").click(function(){
		var uploadText="<form id='upload' method='post' enctype='multipart/form-data'>" +
				"	<legend>上传文件</legend>" +
				"		<div class='control-group' id='upload-box'>" +
					"		<div class='uploader blue'>" +
					"			<input type='text' class='filename' readonly='readonly'/>" +
					"			<input type='button'  class='button' value='浏览'/>" +
					"			<input type='file' name='file' size='50' id='upload-input' multipart/>" +
					"		</div>" +
				"		</div><br/>" +
				"请选择分类：" +
				"		<select id='choose-resourcetype'>" +
				"			<option value='0'>---请选择---</option>" +
				"		</select>" +
				"		<label class='control-label' for='input01' id='upload-msg' style='color:red'></label><br/><br/><br/>" +
				"		<div>" +
				"			<label id='upload-tip'>*上传文件大小不能超过300M</label>"+
				"			</br></br><button type='button' class='btn btn-warning' id='confirmUpload'>确认上传</button>" +
				"		</div>" +
				"<label class='control-label' for='input01' id='succ-or-failure'></label>"+
				"</form>";
		
		$("#show").html(uploadText);
		ResourceTypeManager.getAll(function(resourceTypes){
			for(var i=0;i<resourceTypes.length;i++){
				$("#choose-resourcetype").append("<option value="+resourceTypes[i].rtname+">"+resourceTypes[i].rtname+"</option>");
			}
		});
		
		$(function(){
			$("input[type=file]").change(function(){$(this).parents(".uploader").find(".filename").val($(this).val());});
			$("input[type=file]").each(function(){
			if($(this).val()==""){$(this).parents(".uploader").find(".filename").val("请添加文件");}
			});
		});
		
		$('#confirmUpload').click(function(){
			//改上传者
			UserManager.checkSession(function(username){
				if(username=="wobushi-user"){
					alert("您还没有登录，请先登录！");
				}else{
			var uploader=username.split("*")[1];
			var rname=$("#upload-input").val();
			console.log(rname);
			var rname=new String(rname);
			console.log(rname);
			rname=rname.substring(rname.lastIndexOf("\\")+1);
			console.log(rname);
			rtname=$("#choose-resourcetype").val();
			
			if(rname==""){
				$("#upload-msg").text("请选择文件！！！");
				return;
			}else if(rtname=="0"){
				$("#upload-msg").text("请选择分类");
				return;
			}else{
				$("#succ-or-failure").html("正在上传...");
				var urlString='UploadServlet?rname='+rname+'&uploader='+uploader+'&rtname='+rtname;
				var formData = new FormData($('#upload')[0]);
		        $.ajax({

		            url : urlString,

		            type : 'POST',

		            data : formData,
		            
		            async: true, 
		            
		            cache: false,

		            contentType : false, 

		            processData : false,

		            success : function(data) {
		            	$("#succ-or-failure").text(data);
		            },

		            error : function(data) {
		            	$("#succ-or-failure").text(data);
		            }

		        });
				console.log(rname+",类型为："+rtname);
				
				
			}
				}
			});

		});
		
	});
	

	
	//搜索框
	var searchText="<div class='well form-search'>" +
						"请输入关键字：<br/>"+
						"<input type='text' class='input-medium search-query' id='keywords'>" +
						"<button type='button' class='btn' id='search-resource'>搜索</button>" +
					"</div>" +
					"<div id='search-results'></div>"
	$("#show").append(searchText);
	$("#search-resource").click(function(){
		showResourcesByName($("#keywords").val());
	});

		
	//全部资源
	$("#all-resource").click(function(){
		$("#show").html(resourceText);
		showResources();
	});
	
	
	//我上传的资源
	$("#my-resource").click(function(){
		UserManager.checkSession(function(username){
			if(username=="wobushi-user"){
				alert("您还没有登录，请先登录！");
			}else{
		var user=username.split("*")[1];
		$("#show").html(resourceText);
			ResourceManager.getResourcesByUploader(user,function(resources){
				for(var i=0;i<resources.length;i++){
					$("#resources").append("<tr><td>"+(i+1)+"</td><td><a href='#' class='download'>"
												+resources[i].rname+"</td><td>"
												+resources[i].uploader+"</td><td>"
												+resources[i].uploaddate+"</td><td>"+resources[i].resourcetype.rtname+"</td></tr>");
				}
				
				$(".download").click(function(){
					//location.href="DownloadServlet?filename=test.txt";
					console.log($(this).html());
					var filename=$(this).html();
					url="DownloadServlet?filename="+filename;
					location.href=url;
				});
			});
		}
		});
	});
	
	
	
	
});


var resourceText=
	"<table class='table'>" +
	"	<thead>" +
	"		<tr>" +
	"			<th>序号</th>" +
	"			<th>资源名</th>" +
	"			<th>上传者</th>" +
	"			<th>上传日期</th>" +
	"			<th>分类</th>" +
	"		</tr>" +
	"	</thead>" +
	"	<tbody id='resources'>" +
	"	</tbody>" +
	"</table>";

var buttonText="<button class='btn btn-primary' id='get-all-chooses'>全选</button>&nbsp&nbsp&nbsp&nbsp"+
"<button class='btn btn-primary' id='undo-all-chooses'>取消</button>&nbsp&nbsp&nbsp&nbsp"+
"<button class='btn btn-primary' id='get-opposite-chooses'>反选</button>&nbsp&nbsp&nbsp&nbsp"+
"<button class='btn btn-primary' id='get-selected-chooses'>确认删除</button>" +
"<label class='control-label' for='input01' id='delete-msg'></label>";

//显示资源类型列表
function showResourceTypes(){
		ResourceTypeManager.getAll(function(resourceTypes){
		for(var i=0;i<resourceTypes.length;i++){
			$("#resource-types").append("<li class='list-group-item' onclick='showResourcesByType(this.innerText);'><a href='javascritp:void(0);'>"
					+resourceTypes[i].rtname+"</a></li>");
			
		}
		
		
	});
	
}

//按类型划分资源函数
function showResourcesByType(rtname){
	
		$("#show").html(resourceText);
		ResourceManager.getResourcesByType(rtname,function(resources){
			for(var i=0;i<resources.length;i++){
				$("#resources").append("<tr><td>"+(i+1)+"</td><td><a href='#' class='download'>"
											+resources[i].rname+"</a></td><td>"
											+resources[i].uploader+"</td><td>"
											+resources[i].uploaddate+"</td><td>"
											+resources[i].resourcetype.rtname+"</td></tr>");
				
			}
			
			$(".download").click(function(){
				//location.href="DownloadServlet?filename=test.txt";
				console.log($(this).html());
				var filename=$(this).html();
				url="DownloadServlet?filename="+filename;
				location.href=url;
			});
			
		});
		
		
}


//按资源名获取资源函数
function showResourcesByName(rname){
	$("#search-results").html("");
		$("#search-results").append(resourceText);
		ResourceManager.getResourcesByName(rname,function(resources){
			for(var i=0;i<resources.length;i++){
				$("#resources").append("<tr><td>"+(i+1)+"</td><td><a href='#' class='download'>"
											+resources[i].rname+"</td><td>"
											+resources[i].uploader+"</td><td>"
											+resources[i].uploaddate+"</td><td>"+resources[i].resourcetype.rtname+"</td></tr>");
			}
			
			$(".download").click(function(){
				//location.href="DownloadServlet?filename=test.txt";
				console.log($(this).html());
				var filename=$(this).html();
				url="DownloadServlet?filename="+filename;
				location.href=url;
			});
		});
}



//按上传者获取资源函数
//function showResourcesByUploader(uploader){
//		$("#show").html(resourceText);
//		ResourceManager.getResourcesByUploader(uploader,function(resources){
//			for(var i=0;i<resources.length;i++){
//				$("#resources").append("<tr><td>"+(i+1)+"</td><td>"
//											+resources[i].rname+"</td><td>"
//											+resources[i].uploader+"</td><td>"
//											+resources[i].uploaddate+"</td><td>"+resources[i].resourcetype.rtname+"</td></tr>");
//			}
//			
//		});
//}

//新增资源类型
function addResourceType(){
	var rtname=$("#addrtname").val();
	console.log("添加类型名："+rtname);
	ResourceTypeManager.insertResourceType(rtname,function(flag){
		console.log("添加："+rtname);
		if(flag){
			$("#addrtmsg").text("插入成功");
		}
		else{
			$("#addrtmsg").text("插入失败");
		}
	});
	
}

//删除资源类型
function deleteResourceType(){
	var rtname=$("#deletertname").val();
	console.log("删除类型名："+rtname);
	ResourceTypeManager.deleteResourceType(rtname,function(flag){
		console.log("删除："+rtname);
		if(flag){
			$("#delrtmsg").text("删除成功");
		}
		else{
			$("#delrtmsg").text("您输入的目录名不存在");
		}
	});
	
}



//显示资源列表resources
function showResources(){
	
	ResourceManager.getAll(function(resources){
	for(var i=0;i<resources.length;i++){
		$("#resources").append("<tr><td>"+(i+1)+"</td><td><a href='#' class='download'>"
									+resources[i].rname+"</td><td>"
									+resources[i].uploader+"</td><td>"
									+resources[i].uploaddate+"</td><td>"+resources[i].resourcetype.rtname+"</td></tr>");
	}
	$(".download").click(function(){
		//location.href="DownloadServlet?filename=test.txt";
		console.log($(this).html());
		var filename=$(this).html();
		url="DownloadServlet?filename="+filename;
		location.href=url;
	});
});
	




}