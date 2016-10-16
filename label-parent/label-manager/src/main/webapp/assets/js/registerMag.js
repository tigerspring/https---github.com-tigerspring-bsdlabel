$(function(){
	$.ajax({
		  type: "POST",
		  url: "/registrationinfo/list?time="+new Date(),
		  dataType: "html",
		  async:false,
		  success:function(data){
			  $(".row.searchTb").html(data);
			  pageInition();
		  }
	});
});
function pageInition(){
	if(parseInt($("input[name='pageSize']").val()) >= parseInt($("input[name='totalElement']").val())){
		var pageHtml = "<div class=\"pagination\">"+
					"<span class=\"totalPage\">总记录"+$("input[name='totalElement']").val()+"条</span>"+
					"<span class=\"current prev\" rel=\"prev\">« 上一页</span>"+
					"<span class=\"current\">1</span>"+
					"<span class=\"current next\" rel=\"next\">下一页 »</a>"
					"</div>"
		$("#Pagination").empty();
		$("#Pagination").html(pageHtml);
	}else{
		$("#Pagination").pagination($("input[name='totalPage']").val(), {
			callback:pageInitionCallBack,
			current_page:$("input[name='currentPage']").val(),
			prev_text: "« 上一页",
			next_text: "下一页 »",
			num_edge_entries: 2,
			num_display_entries: 5,
			items_per_page:1
		});
	}
	
}

function pageInitionCallBack(index, jq){
	$.ajax({
		  type: "POST",
		  url: "/registrationinfo/list?currentPage="+index+"&time="+new Date(),
		  dataType: "html",
		  success:function(data){
			  $(".row.searchTb").empty().html(data);
			  $(".pagination").prepend("<span class='totalPage'>总记录"+$("input[name='totalElement']").val()+"条</span>")
		  }
	});
}
