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
<title>微调研新增</title>
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

<SCRIPT type="text/javascript">
function checkform(){
		var name = document.getElementById('name').value;
		var keywordname = document.getElementById('keywordname').value;
		var starttime = document.getElementById('starttime').value;
		var endtime = document.getElementById('endtime').value;
		var content = document.getElementById('content').value;
		var answer1 = document.getElementById('answer1').value;
		var answer2 = document.getElementById('answer2').value;
		
		if(name=='')
		{
			alert("请输入名称.");
			return false;
		}
		if(keywordname=='')
		{
			alert("请输入关键字.");
			return false;
		}
		if(starttime=='')
		{
			alert("请输入开始时间.");
			return false;
		}
		if(endtime=='')
		{
			alert("请输入结束时间.");
			return false;
		}
		
		if(content=='')
		{
			alert("请输入投诉内容.");
			return false;
		}
		
		if(answer1=='')
		{
			alert("请输入选项1.");
			return false;
		}
		if(answer2=='')
		{
			alert("请输入选项2.");
			return false;
		}
	return true;
}

</SCRIPT>
</head>
<body>
	<h3>微调研设置</h3>
	<div class="alert alert-info">
	  	<p><span class="bold">说明：</span>微调研的目的是获得系统客观的收集信息研究数据，为决策做准备。&nbsp;&nbsp;<font color="red">注:请依次填写</font></p>
	</div>
	<form class="form-horizontal" id="lbsForm" action="wdyAction!add"  enctype="multipart/form-data" onsubmit="return checkform();" method="post">	<div class="control-group">
	    	<label class="control-label" for="keyword">微调研名称</label>
	    	<div class="controls">
	    	<input type="text"    name="wdy.name" id="name" class="span4"/>		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入30个字符。</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">微调研键字</label>
	    	<div class="controls">
	    	<input type="text"    name="wdy.keywordname" id="keywordname" class="span4"/>		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入20个字符。</span>
	    	</div>
	  	</div>
		<div class="control-group">
	    	<label class="control-label" for="location_p">微调研开始时间</label>
	    	<div class="controls">
	  		
	  		<input type="date"  name="wdy.starttime"    id="starttime" class="span4"  />	 
	    	   	</div>
	  	</div>
	  
	  	<div class="control-group">
	    	<label class="control-label" for="category_f">微调研结束时间</label>
	    	<div class="controls">
	    	<input type="date"  name="wdy.endtime"    id="endtime" class="span4"   />	 
	    	   	</div>
	  	</div>
		<div class="control-group">
		    <label class="control-label" for="">微调研展示图片</label>
		    <div class="controls">
					<label>
		 <s:file name="picture"  cssStyle="width:80%" accept="image/jpeg,image/png,image/jpg"  onchange="change();" id="myfile"></s:file>
	  </label>
		<br/>
		<img alt="暂无图片"  id="myimage" width="300px" height="256px"/>
				<SCRIPT type="text/javascript">
							function change() {
							    var pic = document.getElementById("myimage"),
							        file = document.getElementById("myfile");
							     console.log(pic,file);
							    var ext=file.value.substring(file.value.lastIndexOf(".")+1).toLowerCase();
							     // gif在IE浏览器暂时无法显示
							     if(ext!='png'&&ext!='jpg'&&ext!='jpeg'){
							         alert("图片的格式必须为png或者jpg或者jpeg格式！"); 
							         return;
							     }
							     var isIE = navigator.userAgent.match(/MSIE/)!= null,
							         isIE6 = navigator.userAgent.match(/MSIE 6.0/)!= null;
							 
							     if(isIE) {
							        file.select();
							        var reallocalpath = document.selection.createRange().text;
							 
							        // IE6浏览器设置img的src为本地路径可以直接显示图片
							         if (isIE6) {
							            pic.src = reallocalpath;
							         }else {
							            // 非IE6版本的IE由于安全问题直接设置img的src无法显示本地图片，但是可以通过滤镜来实现
							             pic.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image',src=\"" + reallocalpath + "\")";
							             // 设置img的src为base64编码的透明图片 取消显示浏览器默认图片
							             pic.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
							         }
							     }else {
							        html5Reader(file);
							     }
							     pic.alt = '图片';
							}
							 
							 function html5Reader(file){
							     var file = file.files[0];
							     var reader = new FileReader();
							     reader.readAsDataURL(file);
							     reader.onload = function(e){
							         var pic = document.getElementById("myimage");
							         pic.src=this.result;
							     }
							 }
				</SCRIPT>
					<div  style="line-height: 30px;color:gray;">建议尺寸：700像素 * 380像素</div>
		    </div>
	  	</div>
	  	
	  	<div class="control-group">
			<label class="control-label" for="detail">微调研简述:</label>
			<div class="controls">
			<textarea name="wdy.content"   id="content" class="span5" style="height:90px;width:520px;"></textarea>				<span class="maroon">*</span><br><span class="help-inline">最多为1000个字符。</span>
			</div>
		</div>
		
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项1</label>
	    	<div class="controls">
	    	<input type="text"    name="wdy.answer1" id="answer1" class="span4"/>		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入30个字符。</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项2</label>
	    	<div class="controls">
	    	<input type="text"     name="wdy.answer2" id="answer2" class="span4"/>		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入30个字符。</span>
	    	</div>
	  	</div>
	  		<div class="control-group">
	    	<label class="control-label" for="keyword">选项3</label>
	    	<div class="controls">
	    	<input type="text"     name="wdy.answer3" id="answer3" class="span4"/>		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入30个字符。</span>
	    	</div>
	  	</div>
	  		<div class="control-group">
	    	<label class="control-label" for="keyword">选项4</label>
	    	<div class="controls">
	    	<input type="text"     name="wdy.answer4" id="answer4" class="span4"/>		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入30个字符。</span>
	    	</div>
	  	</div>
	  		<div class="control-group">
	    	<label class="control-label" for="keyword">选项5</label>
	    	<div class="controls">
	    	<input type="text"     name="wdy.answer5" id="answer5" class="span4"/>		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入30个字符。</span>
	    	</div>
	  	</div>
	  		<div class="control-group">
	    	<label class="control-label" for="keyword">选项6</label>
	    	<div class="controls">
	    	<input type="text"     name="wdy.answer6" id="answer6" class="span4"/>		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入30个字符。</span>
	    	</div>
	  	</div>
	    	
	    	<span class="help-inline"></span>
		
 		<div class="control-group">
		    <div class="controls">
		    
			 <s:token></s:token>
<input type="submit" class="btn btn-primary btn-large"  value="保存" />
		     
		    </div>
	    </div>
	</form>
<br/><br/><br/></body>

</html>