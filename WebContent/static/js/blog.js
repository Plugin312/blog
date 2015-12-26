$(document).ready(function(){
	
	UserManager.checkSession(function(username){
		//console.log(username);
		if(username!="wobushi-user"&&username!=null){
			var s = $("#manage-username-a").html();
			//console.log(s);
			var author = username.split("*")[1];
			var name = username.split("*")[0];
		//	console.log(author);
			$("#manage-username-a").html(author+s);
			$("#write-blog").click(function(){
				location.href="write.html";
			});
			
			//查看我的博客
			$("#my-blog").click(function(){
				//console.log(name);
			
				UserManager.findblog(name,function(userblog){
					//console.log(userblog);
					var blog = userblog.blog;
					blog_show(blog);
				});
			});
			
			//修改自己的信息
			manager_mess(name);
			
		}else{
			$("#manage-username-a").text("登 录");
			$("#manage-username-a").click(function(){
				$("#admin-login-modal").modal("show");	
			});
			$("#write-blog").click(function(){
				//location.href="#";
				$("#gridSystemModalLabel").text("请先登录");
				$("#admin-login-modal").modal("show");	
			});
		}
	});
	
	//显示所有的博客
	showblog();
	//显示分类博客
	type();
	//搜索
	search();
	
	
	
	
	$("#blog-home").click(function(){
		showblog();
	});
	
	$("#blog-tuijian").click(function(){
		tuijian();
	});
	
	
});

function showblog(){
	BlogManager.QueryAll(function(blog){
		console.log(blog);
		$("#blog-text").empty();
		for(var i=blog.length-1;i>=0;i--){
			var bid = blog[i].bid;
		//	console.log(blog.length);
			//设置日期显示格式
			var upload = blog[i].releasedate;
			var datetime = new Date();
		    datetime.setTime(upload);
		    var year = datetime.getFullYear();
		    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
		    var day = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
		    var date = year+"-"+month+"-"+day;
		    
		    var tr='<h1>'+
		    '<a href="#" id="blog-type1-'+bid+'" class="category" style="float:left;"></a>'+
		    '<a id="blog-title-'+bid+'" href="#" class="blog-title" style="float:left;"></a>'+
		    ' </h1>'+
		    ' <dl><dd id="maincontent-blog-'+bid+'"></dd></dl>'+
		    '<div class="about_info">'+
	        '<span class="fl">'+
	            '<a href="#" target="_blank" class="user_name"></a>'+
	            '<span id="blog-time-'+bid+'"  class="time"></span>'+
	           ' <a href="#"  class="view" id=read-'+bid+'></a>'+
	            '<a href="#" class="comment" id=comment-'+bid+'></a>'+
	        '</span></div><br>';
		    $("#blog-text").append(tr);
		    $('#blog-title-'+bid).text(blog[i].title);
			$('#maincontent-blog-'+bid).text(blog[i].maincontent);
			//console.log(blog[i].maincontent);
			$('#blog-time-'+bid).text(date);
			$('#blog-type1-'+bid).text("["+blog[i].btypes.name+"]");
			$('#read-'+bid).text("阅读("+blog[i].viewed+")");
			$('#comment-'+bid).text("评论("+blog[i].commentcounts+")");
		//	console.log(blog[i].viewed);
//				$(".blog-title").click(function(){
//					alert("d");
//					location.href="showBlog.html"
//					 BlogManager.registSession(bid,function(){
//						  console.log(bid);
//					  });
//				});
					 
				 
		}
		  
		//判断是哪一个超链接被按下
		$(".blog-title").click(function(){
			
			var examerId = $(this).attr("id").split("-")[2];
			//alert(examerId);
			location.href="showBlog.html"
			 BlogManager.registSession(examerId,function(){
				//  console.log(bid);
			  });
		});
		
		//判断是哪一个超链接被按下
		$(".view").click(function(){
			
			var examerId = $(this).attr("id").split("-")[1];
			//alert(examerId);
			location.href="showBlog.html"
			 BlogManager.registSession(examerId,function(){
				//  console.log(bid);
			  });
		});
		
		
		$(".comment").click(function(){
			
			var d = $(this).attr("id").split("-")[1];
			//alert(examerId);
			location.href="showBlog.html"
			 BlogManager.registSession(d,function(){
				//  console.log(bid);
			  });
		});
		
		
		
	});
	
	
}


function manager_mess(name){
	$("#blog-message").click(function(){
		UserManager.getUserByName(name,function(user){
			location.href="reset.html";
		});
	});
}
	

function type(){
	BtypesManager.QueryAll(function(btype){
		console.log(btype);
		$("#blog-type").empty();
		var h1 = '<li  class=""><a href="#"  class="mobile" >全部分类</a></li>';
		$("#blog-type").append(h1);
		for(var i=0;i<btype.length;i++){
			var h2 =  '<li class=""><a href="#" id="blog-type-'+btype[i].tid+'" class="blog-web"></a></li>';
			$("#blog-type").append(h2);
			$("#blog-type-"+btype[i].tid).text(btype[i].name);
		}
		
		$(".blog-web").click(function(){
			
			var tid = $(this).attr("id").split("-")[2];
			BtypesManager.getById(tid,function(btype){
				var blog = btype.myblog;
				blog_show(blog);
			});
			
		});
		
		
		
	});
	
} 


function blog_show(blog){
	$("#blog-text").empty();
	for(var i=blog.length-1;i>=0;i--){
		var bid = blog[i].bid;
	//	console.log(blog.length);
		//设置日期显示格式
		var upload = blog[i].releasedate;
		var datetime = new Date();
	    datetime.setTime(upload);
	    var year = datetime.getFullYear();
	    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
	    var day = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
	    var date = year+"-"+month+"-"+day;
	    
	    var tr='<h1>'+
	    '<a href="#" class="category" id="blog-type1-'+bid+'" style="float:left;"></a>'+
	    '<a id="blog-title-'+bid+'" href="#" class="blog-title" style="float:left;"></a>'+
	    ' </h1>'+
	    ' <dl><dd id="maincontent-blog-'+bid+'"></dd></dl>'+
	    '<div class="about_info">'+
        '<span class="fl">'+
            '<a href="#" target="_blank" class="user_name"></a>'+
            '<span id="blog-time-'+bid+'"  class="time"></span>'+
           ' <a href="#"  class="view" id=read-'+bid+'></a>'+
            '<a href="#" class="comment" id=comment-'+bid+'></a>'+
        '</span></div><br>';
	    $("#blog-text").append(tr);
	    $('#blog-title-'+bid).text(blog[i].title);
		$('#maincontent-blog-'+bid).text(blog[i].maincontent);
		//console.log(blog[i].maincontent);
		$('#blog-time-'+bid).text(date);
		$('#blog-type1-'+bid).text("["+blog[i].btypes.name+"]");
		$('#read-'+bid).text("阅读("+blog[i].viewed+")");
		$('#comment-'+bid).text("评论("+blog[i].commentcounts+")");
	//	console.log(blog[i].viewed);
		
	}
	
	
	//判断是哪一个超链接被按下
	$(".blog-title").click(function(){
		
		var examerId = $(this).attr("id").split("-")[2];
		//alert(examerId);
		location.href="showBlog.html"
		 BlogManager.registSession(examerId,function(){
			//  console.log(bid);
		  });
	});
	
	//判断是哪一个超链接被按下
	$(".view").click(function(){
		
		var examerId = $(this).attr("id").split("-")[1];
		//alert(examerId);
		location.href="showBlog.html"
		 BlogManager.registSession(examerId,function(){
			//  console.log(bid);
		  });
	});
	
}

//热门推荐
function tuijian(){
	BlogManager.paixu(function(blog){
		//console.log(blog);
		blog_show(blog);
	});
}



//搜索
function search(){
	$("#button-blog").click(function(){
		var sea = $("#Search-blog").val();
		if(sea!=""){
			UserManager.fbByname(sea,function(userblog){
				if(userblog!=null){
					var blog = userblog.blog;
					blog_show(blog);
				}
			});
			BtypesManager.findtype(sea,function(btype){
				if(btype!=null){
					var blog = btype.myblog;
					blog_show(blog);
				}
			});
			
			BlogManager.findTitle(sea,function(allBlog){
				blog_show(allBlog);
			});
		}
	});
	
}
