$(function(){
	loadFirstMianHtml();
});
function loadFirstMianHtml(){
	$.ajax({        //这是$.ajax()方法  
        type:"POST",  
        url:"/registrationinfo/registrationInfoList", 
        dataType:"html",//接受响应的数据类型，我的响应是一个页面，所以这里用“html”
        async : false,
        success:function(data){    
        	$("#tabOption").empty();
        	$("#tabOption").html(data);//我把响应的页面被放到一个div中显示
		}
	});
}
function clickTab(myThis,activeUrl){
	$(myThis).parent().addClass("active").siblings().removeClass("active");
	loadMainHtml(activeUrl)
}
function loadMainHtml(activeUrl){
	$.ajax({        //这是$.ajax()方法  
        type:"POST",  
        url:activeUrl, 
        dataType:"html",//接受响应的数据类型，我的响应是一个页面，所以这里用“html”
        async : false,
        success:function(data){   
        	$("#tabOption").empty();
        	$("#tabOption").html(data);//我把响应的页面被放到一个div中显示
		}
	});
}
