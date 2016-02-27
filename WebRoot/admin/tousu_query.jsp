<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投诉查询</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>

<link rel="stylesheet" href="css/admin/bootstrap.min.css">
<link rel="stylesheet" href="css/admin/admin.css">
<style type="text/css">
	table td {
		min-width:50px;
		overflow:hidden;text-overflow:ellipsis;
	}
	#picsethere{
		width: 510px;
		display: block;
	}
	#picsethere img{
		max-width: 500px;
		display: block;
	}
</style>
</head>
<body>
	<h3>投诉查询</h3>
	<div class="alert alert-info">
	  	<p><span class="bold">说明：</span>说明内容</p>
	</div>
	<form class="form-horizontal" id="lbsForm" action="complaintAction!query" method="post"><input type="hidden" value="54dac5d4eee48" name="YYUC_FORM_TOKEN"/><input type="hidden" value = "" name="C1lSS1ttEkIXQ1QYZA1S" id="micro_surveyid" />		
		<div class="control-group">
	    	<label class="control-label" for="keyword">投诉类型</label>
	    	<div class="controls">
	    	<s:select name="comptype" id="comptype" cssClass="dropdown-select" list="#{'1':'市容面貌','2':'宣传广告','3':'园林绿化','4':'黑车','5':'城市湖道','6':'街面秩序','7':'施工管理'}" label="投诉类型" headerKey="" headerValue="请选择投诉类型"></s:select> 
	    	</div>
	  	</div>

		
		<div class="control-group">
	    	<label class="control-label" for="location_p">发起日期</label>
	    	<div class="controls">
	    	<input type="date"  name="comptime"    id="micro_surveykssj" class="span4"   />	 
	    	
	    	   	</div>
	  	</div>
	  
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">投诉人</label>
	    	<div class="controls">
	    	<input type="text"    name="name" id="micro_surveygjz" class="span4"/>	
	    	</div>
	  	</div>
	  	

 		<div class="control-group">
		    <div class="controls">
		    
		      <button id="save-btn" type="submit" class="btn btn-primary btn-large">查询</button>
		    </div>
	    </div>
	</form>
<script type="text/javascript" src="js/comm.js"></script>
<script type="text/javascript">
$(function(){
	 $("#lbsForm").submit(function(){
		var cansv= true;
		$(this).find('input[type="text"],select,textarea').each(function(){
			if($.trim($(this).val())=='' && $(this).attr('noneed')!='1'){
				cansv = false;
				$(this).css('backgroundColor','yellow');
				$(this).one('focus',function(){
					$(this).css('backgroundColor','transparent');
				});
			}
		});
		if(!cansv){
			tusi('请将信息填写完整');
			return false;
		}
		$(this).find('input[type="text"],select,textarea').each(function(){
			if($(this).attr('isint')=='1' && $.trim($(this).val())!=''){
				var intthis = parseInt2($(this).val());
				if(intthis+''=='NaN'){
					cansv = false;
					$(this).css('backgroundColor','yellow');
					$(this).one('focus',function(){
						$(this).css('backgroundColor','transparent');
					});
				}else{
					$(this).val(parseInt($(this).val()));
				}
			}
		});
		if(!cansv){
			tusi('标注的项目必须为整数');
			return false;
		}
		
		$(this).find('input[type="text"],select,textarea').each(function(){
			if($(this).attr('isfloat')=='1' && $.trim($(this).val())!=''){
				var intthis = parseFloat($(this).val());
				if(intthis+''=='NaN'){
					$(this).val('0');
					cansv = false;
					$(this).css('backgroundColor','yellow');
					$(this).one('focus',function(){
						$(this).css('backgroundColor','transparent');
					});
				}else{
					$(this).val(parseFloat($(this).val()));
				}
			}
		});
		if(!cansv){
			tusi('标注的项目必须为数字');
			return false;
		}
		
		if($('#picsethere').find('img').size()<1){
   		cansv = false;
   		tusi('请上传活动图片');
   		return false;
   	}
   	return cansv;
   });
});
</script>
<br/><br/><br/></body>

</html>