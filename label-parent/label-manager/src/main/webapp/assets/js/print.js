$(function(){
	sta = 0;
	if(sta==0){
	$("#selAll").click(function(){     
		$("[name='checkbox']").attr("checked",'true');//全选    
		sta=1;
    });	
   }
	if(sta==1){
		$("#selAll").click(function(){
		$("[name='checkbox']").removeAttr("checked");//取消全选  
		sta=0;
	});
	}
})
