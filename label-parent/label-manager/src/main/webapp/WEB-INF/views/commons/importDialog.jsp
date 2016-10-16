<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="/assets/js/jqueryform/jquery.form.js"/>
<form id="uploadForm" method="post" enctype="multipart/form-data">
<div class="modal fade" id="importDialog" tabindex="-1" role="dialog" aria-labelledby="myConfirmLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myConfirmModalLabel">上传文件</h4>
            </div>
            <div class="modal-body">
		            <input type="file" name="file"/>
			</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="doImport();">导入</button>
            </div>
        </div>
    </div>
</div>
<div id="upMessage"></div>
</form>
<script type="text/javascript">
var impUrl = "";
function importUrl(url){
	impUrl = url;
}
function doImport(){
	$("#uploadForm").ajaxSubmit({
		type : 'post',
		url : impUrl,
		//data:  //注意只要是写在表单里面的，都不需要加这个属性。在controller中可以根据@RequestParam String str获取到属性值。    
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		forceSync:false,
		clearForm:true,
		success: function(html) {
			$(".row.searchTb").empty().html(html);
			pageInition();
		}
	});
}
</script>