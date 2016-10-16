<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="modal fade" id="confirmDialog" tabindex="-1" role="dialog" aria-labelledby="myConfirmLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myConfirmModalLabel">确认提示</h4>
            </div>
            <div class="modal-body">确定要删除吗!</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary del" data-dismiss="modal" onclick="doDel();">确认</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
var importUrl="";
function del(url) {
	delUrl = url; 
}
function doDel(){
	$.ajax({
		url:delUrl,
		async:false,
		success:function(html) {
		$(".row.searchTb").empty().html(html);
		pageInition();
	}});
}
</script>