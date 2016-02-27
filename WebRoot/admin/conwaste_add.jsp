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
<title>新增建筑垃圾准运信息</title>
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
		var unit = document.getElementById("unit");
		var person = document.getElementById("person");
		var phone = document.getElementById("phone");
		var sum = document.getElementById("sum");
		var carnumber = document.getElementById("carnumber");
		var line = document.getElementById("line");
		var timelimit = document.getElementById("timelimit");
		var note = document.getElementById("note");
		if(unit.value.length==0||unit.value==''){
			alert("准运单位不能为空");
			unit.value="";
			unit.focus();
			return false;
		}
		if(person.value.length==0||person.value==''){
			alert("负责人不能为空");
			person.value="";
			person.focus();
			return false;
		}
		if(phone.value.length==0||phone.value==''){
			alert("联系电话不能为空");
			phone.value="";
			phone.focus();
			return false;
		}
		if(sum.value.length==0||sum.value==''){
			alert("车辆数量不能为空");
			sum.value="";
			sum.focus();
			return false;
		}
		if(carnumber.value.length==0||carnumber.value==''){
			alert("车牌号不能为空");
			carnumber.value="";
			carnumber.focus();
			return false;
		}
		if(line.value.length==0||line.value==''){
			alert("运输路线不能为空");
			line.value="";
			line.focus();
			return false;
		}
		
		if(timelimit.value.length==0||timelimit.value==''){
			alert("运输时限不能为空");
			timelimit.value="";
			timelimit.focus();
			return false;
		}
		
		if(note.value.length==0||note.value==''){
			alert("备注不能为空");
			note.value="";
			note.focus();
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<h3>新增建筑垃圾准运信息</h3>
	<div class="alert alert-info">
	  	<p><span class="bold">说明：</span>请输入完整的信息</p>
        <s:hidden name="conwaste.status" value="0"></s:hidden>
	</div>
	<form class="form-horizontal" id="lbsForm" action="conwasteAction!add" method="post" onsubmit="return checkform();">
		<div class="control-group">
	    	<label class="control-label" for="keyword">准运单位</label>
	    	
	    	<div class="controls">
	    	<s:textfield name="conwaste.unit" cssClass="span4" id="unit"></s:textfield>
	    	</div>
	  	</div>
		<div class="control-group">
	    	<label class="control-label" for="keyword">负责人</label>
	    	
	    	<div class="controls">
	    	<s:textfield name="conwaste.person" cssClass="span4" id="person"></s:textfield>
	    	</div>
	  	</div>
		<div class="control-group">
	    	<label class="control-label" for="keyword">联系电话</label>
	    	
	    	<div class="controls">
	    	<s:textfield name="conwaste.phone" cssClass="span4" id="phone"></s:textfield>
	    	</div>
	  	</div>
		<div class="control-group">
	    	<label class="control-label" for="keyword">车辆数量</label>
	    	
	    	<div class="controls">
	    	<s:textfield name="conwaste.sum" cssClass="span4"  id="sum"></s:textfield>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">车牌号码</label>
	    	
	    	<div class="controls">
	    	<s:textfield name="conwaste.carnumber" cssClass="span4" id="carnumber"></s:textfield>
	    	</div>
	  	</div>
	  	<div class="control-group">
			<label class="control-label" for="detail">运输路线</label>
			<div class="controls">
			<s:textarea name="conwaste.line" cssClass="span5" cssStyle="height:100px;width:520px;" id="line"></s:textarea>
			</div>
		</div>
		<div class="control-group">
	    	<label class="control-label" for="keyword">运输时限</label>
	    	
	    	<div class="controls">
	    	<s:textfield name="conwaste.timelimit" cssClass="span4" id="timelimit"></s:textfield>
	    	</div>
	  	</div>
	  	<div class="control-group">
			<label class="control-label" for="detail">备注</label>
			<div class="controls">
			<s:textarea name="conwaste.note" cssClass="span5" cssStyle="height:100px;width:520px;" id="note"></s:textarea>
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