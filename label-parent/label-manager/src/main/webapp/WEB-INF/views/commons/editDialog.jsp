<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 新增模态框（Modal） -->
<div class="modal" id="editDialog" tabindex="-1" role="dialog" aria-labelledby="labelAddModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" id="modal-content">
				
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
<script type="text/javascript">
function edit(url) {
	$("#modal-content").empty();
	$.ajax({url:url,success:function(html) {
		if (html.indexOf("div")>0&&html.indexOf("modal-content")>0) {
			//成功
			$("#editDialog").find(".modal-content").eq(0).replaceWith($(html));
		} else {
			$("#editDialog").find(".modal-content").eq(0).html(html);
		}
		
	}});
}
function submit(url,formId){
	var url = url + "?currentPage="+$("#currentPage").val();
	$.ajax({
        url:url,
        type:"POST",
        async:false,
        data:$("#"+formId).serialize(),
        dataType: "html",
        async:false,
        success: function(data) {
        	$(".row.searchTb").empty();
        	$(".row.searchTb").html(data);
        	pageInition();
        }
    });
}
</script>