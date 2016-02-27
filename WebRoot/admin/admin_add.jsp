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
<title>新增账号信息</title>
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
<script type="text/javascript">
	function checkform(){
		var username = document.getElementById("username");
		if(username.value.length==0||username.value==''){
			alert("用户名不能为空");
			username.value="";
			username.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<h3>新增账号信息</h3>
	<div class="alert alert-info">
	  	<p><span class="bold">说明：</span><br/>请输入完整的信息<br/>
	  		密码默认为1234
	  	</p>
        
	</div>
	<form class="form-horizontal" id="lbsForm" action="adminAction!add" method="post" onsubmit="return checkform();">
		<div class="control-group">
	    	<label class="control-label" for="keyword">用户名</label>
	    	<s:hidden name="admin.password" value="1234"></s:hidden>
	    	<div class="controls">
	    	<s:textfield name="admin.username" cssClass="span4" id="username"></s:textfield>&nbsp;*
	    	</div>
	  	</div>
		<div class="control-group">
	    	<label class="control-label" for="keyword">权限</label>
	    	
	    	<div class="controls">
	    	<s:select list="#{0:'超级管理员',1:'投诉管理员',2:'新闻管理员',3:'渣土信息管理员'}" name="admin.limits" listKey="key" listValue="value" id="limits"></s:select>
	    	</div>
	  	</div>
		<div class="control-group">
	    	<label class="control-label" for="keyword">联系电话</label>
	    	
	    	<div class="controls">
	    	<s:textfield name="admin.phone" cssClass="span4" id="phone"></s:textfield>
	    	</div>
	  	</div>
		<div class="control-group">
	    	<label class="control-label" for="keyword">qq</label>
	    	
	    	<div class="controls">
	    	<s:textfield name="admin.qq" cssClass="span4"  id="qq"></s:textfield>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">电子邮箱</label>
	    	
	    	<div class="controls">
	    	<s:textfield name="admin.email" cssClass="span4" id="email"></s:textfield>
	    	</div>
	  	</div>
		
		<div class="control-group">
	    	<label class="control-label" for="keyword">是否启用</label>
	    	
	    	<div class="controls">
	    	<input type="radio" name="admin.ison" value="1" checked="checked"/>启用&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="admin.ison" value="0"/>不启用
	    	</div>
	  	</div>
		
 		<div class="control-group">
		    <div class="controls">
		    	<s:token></s:token>
		      <button id="save-btn" type="submit" class="btn btn-primary btn-large">保存</button>
		     
		    </div>
	    </div>
	</form>
<script type="text/javascript" src="js/comm.js"></script>

<br/><br/><br/></body>

</html>