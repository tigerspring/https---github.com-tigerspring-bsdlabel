<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="/assets/css/jqueryui/jquery-ui-1.10.4.custom.css" />
<script src="/assets/js/jqueryui/jquery-ui-1.10.4.custom.js"></script>
<%@include file="../commons/taglib.jsp" %>
<form id="skuInfoAddForm" class="form-horizontal" action="">
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
		&times;
	</button>
	<h4 class="modal-title">
		新增
	</h4>
</div>
<div class="modal-body"> 
	<div class="form-group">
		<label for="lastname" class="col-sm-4 control-label">注册证：</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="registrationNo"  name="registrationNo"
								   placeholder="请输入注册证" required="required">
			<input type="hidden" id="registrationId"  name="registrationId" />
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-4 control-label">产品编号(SKU)：</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="skuNo"  name="skuNo" value=""
								   placeholder="请输入产品编号(SKU)" required="required">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-4 control-label">产品名称：</label>
			<div class="col-sm-7">
				<input type="text" class="form-control" id="proName"  name="proName" value="${registrationInfo.registrationNo }"
									   placeholder="请输入产品名称" required="required">
			</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-4 control-label">规格型号：</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="specifications"  name="specifications" value="${registrationInfo.registrationNo }"
								   placeholder="请输入规格型号" required="required">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-4 control-label">生产商信息：</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="manufacturer"  name="manufacturer" value="${registrationInfo.registrationNo }"
								   placeholder="请输入生产商信息" required="required">
		</div>
	</div>
	<div class="form-group">
		<label for="lastname" class="col-sm-4 control-label">代理人信息：</label>
		<div class="col-sm-7">
			<input type="text" class="form-control" id="agent"  name="agent" value="${registrationInfo.registrationNo }"
								   placeholder="请输入代理人信息" required="required">
		</div>
	</div>
	<div class="form-group">
		<label for="startTime" class="col-sm-4 control-label">生产日期：</label>
		<div class="col-sm-7">
			<input type="text" class="form-control dateclass" id="productDate"  name="productDate" 
			value="<fmt:formatDate value="${registrationInfo.effectiveDate }" pattern="yyyy-MM-dd"/>" placeholder="生产日期" required="required">
		</div>
	</div>
</div>
</form>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">
		取消
	</button>
	<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="submit('/skuinfo/save','skuInfoAddForm');">
		提交
	</button>
</div>
<script type="text/javascript" src="/assets/js/common/common.js"/>
<script type="text/javascript">
$(function(){
	$( "#registrationNo" ).autocomplete({
	      source: function( request, response ) {
	        $.ajax( {
	          url: "/skuinfo/loadRegistrationInfo?time="+new Date(),
	          data: {
	        	  registrationNo: request.term
	          },
	          success: function( data ) {
	        	  response($.map(data, function(item) {
                      return { label: item.registrationNo, value: item.id }
                  }));
	          }
      		} );
	       },
	       minLength: 2,
	       focus: function(event, ui) {
	    	   $( "#registrationNo" ).val(ui.label);
	    	   $( "#registrationId" ).val(ui.value);
				return true;
			},
	       select: function( event, ui ) {
	         console.log( "Selected: " + ui.item.registrationNo + " aka  value:"+ ui.item.id );
	       }
	});
	/* $("#registrationNo").autocomplete({
			valueKey:'title',
			source:[{
				url:"/skuinfo/loadRegistrationInfo?time="+new Date()+"&registrationNo="+$("#registrationNo").val(),
				type:'remote',
				getValue:function(item){
					console.log(item);
					
					return item.title
				},
				ajax:{
					dataType : 'jsonp'
				}
			}]
	}); */
	/* $('#registrationNo').autocomplete({  
		   source:function(query,process){  
		       var matchCount =this.options.items;//允许返回结果集最大数量  
		      $.post("/skuinfo/loadRegistrationInfo",{"registrationNo":query},function(respData){  
		           respData =$.parseJSON("[{\"id\":\"1\",\"registrationNo\":\"注册1\"},{\"id\":\"2\",\"registrationNo\":\"注册2\"}]");//解析返回的数据  
		          if(!respData) {  
		              alert('输入的卡号不正确');  
		           }  
		           return process(respData);  
		       });  
		    },  
		   formatItem:function(item){  
		       return item["registrationNo"];  
		    },  
		   setValue:function(item){  
		       return {'data-value':item["id"],'real-value':item["registrationNo"]};  
		    },  
		    delay:500
	}); */
});
</script>
