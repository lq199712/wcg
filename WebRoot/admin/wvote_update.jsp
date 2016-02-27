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
<title>微投票修改</title>
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
		var option1 = document.getElementById('option1').value;
		var option2 = document.getElementById('option2').value;
		
		if(name=='')
		{
			alert("请输入微投票名称.");
			return false;
		}
		if(keywordname=='')
		{
			alert("请输入微投票关键字.");
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
		
		if(option1=='')
		{
			alert("请输入选项1.");
			return false;
		}
		if(option2=='')
		{
			alert("请输入选项2.");
			return false;
		}
	return true;
}

</SCRIPT>
</head>
<body>
	<h3>微投票设置</h3>
	<div class="alert alert-info">
	  	<p><span class="bold">说明：</span>微投票的目的是获得系统客观的收集信息研究数据，为决策做准备。&nbsp;&nbsp;<font color="red">注:请依次填写</font></p>
	</div>
	<form class="form-horizontal" id="lbsForm" action="wvoteAction!update"  enctype="multipart/form-data" onsubmit="return checkform" method="post">	<div class="control-group">
	<s:hidden name="wvote.id"></s:hidden>
	<s:hidden name="wvote.image"></s:hidden>
	    	<label class="control-label" for="keyword">微投票名称</label>
	    	<div class="controls">
	    	<s:textfield name="wvote.name" id="name" cssClass="span4"></s:textfield> <span class="maroon">*</span>
		    	
		    	<span class="help-inline">最多只能输入30个字符。</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">微投票键字</label>
	    	<div class="controls">
	    	<s:textfield name="wvote.keywordname" id="keywordname" cssClass="span4"></s:textfield>
	    		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入20个字符。</span>
	    	</div>
	  	</div>
	  	
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">微投票总票数</label>
	    	<div class="controls">
	    	<s:textfield name="wvote.number" id="number" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">*</span>
		    	<span class="help-inline">仅供查看</span>
	    	</div>
	  	</div>
	  	
		<div class="control-group">
	    	<label class="control-label" for="location_p">微投票开始时间</label>
	    	<div class="controls">
	  		
	  		<input type="date"  name="wvote.starttime" value="<s:property value="wvote.starttime"/>"   id="starttime" class="span4"  />	 
	    	   	</div>
	  	</div>
	  
	  	<div class="control-group">
	    	<label class="control-label" for="category_f">微投票结束时间</label>
	    	<div class="controls">
	    	<input type="date"  name="wvote.endtime"  value="<s:property value="wvote.endtime"/>"  id="endtime" class="span4"   />	 
	    	   	</div>
	  	</div>
		<div class="control-group">
		    <label class="control-label" for="">微投票展示图片</label>
		    <div class="controls">
					<label>
		 <s:file name="picture"  cssStyle="width:80%" accept="image/jpeg,image/png,image/jpg"  onchange="change();" id="myfile"></s:file>
	  </label>
		<br/>
		<img alt="暂无图片" src="<%=basePath%>wvoteimage${wvote.image}" id="myimage" width="300px" height="256px"/>
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
			<label class="control-label" for="detail">微投票简述:</label>
			<div class="controls">
			<s:textarea name="wvote.content"   id="content" cssClass="span5" cssStyle="height:90px;width:520px;"></s:textarea>				<span class="maroon">*</span><br><span class="help-inline">最多为1000个字符。</span>
			</div>
		</div>
		
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项1</label>
	    	<div class="controls">
	    	<s:textfield name="option1" id="option1" cssClass="span4"></s:textfield>
	    		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入30个字符。</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项1票数</label>
	    	<div class="controls">
	    	<s:textfield name="number1" id="number1" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">*</span>
		    	<span class="help-inline">仅供查看</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项1票数所占比例</label>
	    	<div class="controls">
	    	<s:textfield name="percent1" id="percent1" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">%</span>
	    	</div>
	  	</div>
	  	
	  	<div class="control-group">
		    <label class="control-label" for="">展示图片1</label>
		    <div class="controls">
			    <div class="cover-area">
					<table style="height: 30px;overflow: hidden;">
					<tr>
					<label>
						 <s:file name="picture1"  cssStyle="width:80%" accept="image/jpeg,image/png,image/jpg"  onchange="change1();" id="myfile1"></s:file>
					  </label>
					<br/>
					<img alt="暂无图片" src="<%=basePath%>wvoteimage${image1}" id="myimage1" width="200px" height="160px"/>
				<script type="text/javascript">
							function change1() {
							    var pic = document.getElementById("myimage1"),
							        file = document.getElementById("myfile1");
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
							        html5Reader1(file);
							     }
							     pic.alt = '图片';
							}
							 
							 function html5Reader1(file){
							     var file = file.files[0];
							     var reader = new FileReader();
							     reader.readAsDataURL(file);
							     reader.onload = function(e){
							         var pic = document.getElementById("myimage1");
							         pic.src=this.result;
							     }
							 }
				</script>
					<td valign="top" style="line-height: 30px;color:gray;">建议尺寸：200像素 * 160像素</td>
					</tr>
					</table>
					<p class="img-area cover-bd" id="headpic1">
					</p>
				</div>
		    </div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项2</label>
	    	<div class="controls">
	    	<s:textfield name="option2" id="option2" cssClass="span4"></s:textfield>		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入30个字符。</span>
	    	</div>
	  	</div>
	  	
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项2票数</label>
	    	<div class="controls">
	    	<s:textfield name="number2" id="number2" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">*</span>
		    	<span class="help-inline">仅供查看</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项2票数所占比例</label>
	    	<div class="controls">
	    	<s:textfield name="percent2" id="percent2" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">%</span>
	    	</div>
	  	</div>
		<div class="control-group">
		    <label class="control-label" for="">展示图片2</label>
		    <div class="controls">
			    <div class="cover-area">
					<table style="height: 30px;overflow: hidden;">
					<tr>
					<label>
						 <s:file name="picture2"  cssStyle="width:80%" accept="image/jpeg,image/png,image/jpg"  onchange="change2();" id="myfile2"></s:file>
					  </label>
					<br/>
					<img alt="暂无图片" src="<%=basePath%>wvoteimage${image2}" id="myimage2" width="200px" height="160px"/>
				<script type="text/javascript">
							function change2() {
							    var pic = document.getElementById("myimage2"),
							        file = document.getElementById("myfile2");
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
							        html5Reader2(file);
							     }
							     pic.alt = '图片';
							}
							 
							 function html5Reader2(file){
							     var file = file.files[0];
							     var reader = new FileReader();
							     reader.readAsDataURL(file);
							     reader.onload = function(e){
							         var pic = document.getElementById("myimage2");
							         pic.src=this.result;
							     }
							 }
				</script>
					<td valign="top" style="line-height: 30px;color:gray;">建议尺寸：200像素 * 160像素</td>
					</tr>
					</table>
					<p class="img-area cover-bd" id="headpic2">
					</p>
				</div>
		    </div>
	  	</div>
	  		<div class="control-group">
	    	<label class="control-label" for="keyword">选项3</label>
	    	<div class="controls">
	    	<s:textfield name="option3" id="option3" cssClass="span4"></s:textfield>		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入30个字符。</span>
	    	</div>
	  	</div>
	  	
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项3票数</label>
	    	<div class="controls">
	    	<s:textfield name="number3" id="number3" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">*</span>
		    	<span class="help-inline">仅供查看</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项3票数所占比例</label>
	    	<div class="controls">
	    	<s:textfield name="percent3" id="percent3" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">%</span>
	    	</div>
	  	</div>
		<div class="control-group">
		    <label class="control-label" for="">展示图片3</label>
		    <div class="controls">
			    <div class="cover-area">
					<table style="height: 30px;overflow: hidden;">
					<tr>
					<label>
						 <s:file name="picture3"  cssStyle="width:80%" accept="image/jpeg,image/png,image/jpg"  onchange="change3();" id="myfile3"></s:file>
					  </label>
					<br/>
					<img alt="暂无图片" src="<%=basePath%>wvoteimage${image3}" id="myimage3" width="200px" height="160px"/>
				<script type="text/javascript">
							function change3() {
							    var pic = document.getElementById("myimage3"),
							        file = document.getElementById("myfile3");
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
							        html5Reader3(file);
							     }
							     pic.alt = '图片';
							}
							 
							 function html5Reader3(file){
							     var file = file.files[0];
							     var reader = new FileReader();
							     reader.readAsDataURL(file);
							     reader.onload = function(e){
							         var pic = document.getElementById("myimage3");
							         pic.src=this.result;
							     }
							 }
				</script>
					<td valign="top" style="line-height: 30px;color:gray;">建议尺寸：200像素 * 160像素</td>
					</tr>
					</table>
					<p class="img-area cover-bd" id="headpic2">
					</p>
				</div>
		    </div>
	  	</div>
	  		<div class="control-group">
	    	<label class="control-label" for="keyword">选项4</label>
	    	<div class="controls">
	    	<s:textfield name="option4" id="option4" cssClass="span4"></s:textfield>		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入30个字符。</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项4票数</label>
	    	<div class="controls">
	    	<s:textfield name="number4" id="number4" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">*</span>
		    	<span class="help-inline">仅供查看</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项4票数所占比例</label>
	    	<div class="controls">
	    	<s:textfield name="percent4" id="percent4" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">%</span>
	    	</div>
	  	</div>
		<div class="control-group">
		    <label class="control-label" for="">展示图片4</label>
		    <div class="controls">
			    <div class="cover-area">
					<table style="height: 30px;overflow: hidden;">
					<tr>
					<label>
						 <s:file name="picture4"  cssStyle="width:80%" accept="image/jpeg,image/png,image/jpg"  onchange="change4();" id="myfile4"></s:file>
					  </label>
					<br/>
					<img alt="暂无图片" src="<%=basePath%>wvoteimage${image4}"  id="myimage4" width="200px" height="160px"/>
				<script type="text/javascript">
							function change4() {
							    var pic = document.getElementById("myimage4"),
							        file = document.getElementById("myfile4");
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
							        html5Reader4(file);
							     }
							     pic.alt = '图片';
							}
							 
							 function html5Reader4(file){
							     var file = file.files[0];
							     var reader = new FileReader();
							     reader.readAsDataURL(file);
							     reader.onload = function(e){
							         var pic = document.getElementById("myimage4");
							         pic.src=this.result;
							     }
							 }
				</script>
					<td valign="top" style="line-height: 30px;color:gray;">建议尺寸：200像素 * 160像素</td>
					</tr>
					</table>
					<p class="img-area cover-bd" id="headpic2">
					</p>
				</div>
		    </div>
	  	</div>
	  		<div class="control-group">
	    	<label class="control-label" for="keyword">选项5</label>
	    	<div class="controls">
	    	<s:textfield name="option5" id="option5" cssClass="span4"></s:textfield>    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入30个字符。</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项5票数</label>
	    	<div class="controls">
	    	<s:textfield name="number5" id="number5" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">*</span>
		    	<span class="help-inline">仅供查看</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项5票数所占比例</label>
	    	<div class="controls">
	    	<s:textfield name="percent5" id="percent5" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">%</span>
	    	</div>
	  	</div>
		<div class="control-group">
		    <label class="control-label" for="">展示图片5</label>
		    <div class="controls">
			    <div class="cover-area">
					<table style="height: 30px;overflow: hidden;">
					<tr>
					<label>
						 <s:file name="picture5"  cssStyle="width:80%" accept="image/jpeg,image/png,image/jpg"  onchange="change5();" id="myfile5"></s:file>
					  </label>
					<br/>
					<img alt="暂无图片" src="<%=basePath%>wvoteimage${image5}" id="myimage5" width="200px" height="160px"/>
				<script type="text/javascript">
							function change5() {
							    var pic = document.getElementById("myimage5"),
							        file = document.getElementById("myfile5");
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
							        html5Reader5(file);
							     }
							     pic.alt = '图片';
							}
							 
							 function html5Reader5(file){
							     var file = file.files[0];
							     var reader = new FileReader();
							     reader.readAsDataURL(file);
							     reader.onload = function(e){
							         var pic = document.getElementById("myimage5");
							         pic.src=this.result;
							     }
							 }
				</script>
					<td valign="top" style="line-height: 30px;color:gray;">建议尺寸：200像素 * 160像素</td>
					</tr>
					</table>
					<p class="img-area cover-bd" id="headpic2">
					</p>
				</div>
		    </div>
	  	</div>
	  		<div class="control-group">
	    	<label class="control-label" for="keyword">选项6</label>
	    	<div class="controls">
	    	<s:textfield name="option6" id="option6" cssClass="span4"></s:textfield>		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入30个字符。</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项6票数</label>
	    	<div class="controls">
	    	<s:textfield name="number6" id="number6" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">*</span>
		    	<span class="help-inline">仅供查看</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项6票数所占比例</label>
	    	<div class="controls">
	    	<s:textfield name="percent6" id="percent6" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">%</span>
	    	</div>
	  	</div>
		<div class="control-group">
		    <label class="control-label" for="">展示图片6</label>
		    <div class="controls">
			    <div class="cover-area">
					<table style="height: 30px;overflow: hidden;">
					<tr>
					<label>
						 <s:file name="picture6"  cssStyle="width:80%" accept="image/jpeg,image/png,image/jpg"  onchange="change6();" id="myfile6"></s:file>
					  </label>
					<br/>
					<img alt="暂无图片" src="<%=basePath%>wvoteimage${image6}"  id="myimage6" width="200px" height="160px"/>
				<script type="text/javascript">
							function change6() {
							    var pic = document.getElementById("myimage6"),
							        file = document.getElementById("myfile6");
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
							        html5Reader6(file);
							     }
							     pic.alt = '图片';
							}
							 
							 function html5Reader6(file){
							     var file = file.files[0];
							     var reader = new FileReader();
							     reader.readAsDataURL(file);
							     reader.onload = function(e){
							         var pic = document.getElementById("myimage6");
							         pic.src=this.result;
							     }
							 }
				</script>
					<td valign="top" style="line-height: 30px;color:gray;">建议尺寸：200像素 * 160像素</td>
					</tr>
					</table>
					<p class="img-area cover-bd" id="headpic2">
					</p>
				</div>
		    </div>
	  	</div>
	  		<div class="control-group">
	    	<label class="control-label" for="keyword">选项7</label>
	    	<div class="controls">
	    <s:textfield name="option7" id="option7" cssClass="span4"></s:textfield>		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入30个字符。</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项7票数</label>
	    	<div class="controls">
	    	<s:textfield name="number7" id="number7" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">*</span>
		    	<span class="help-inline">仅供查看</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项7票数所占比例</label>
	    	<div class="controls">
	    	<s:textfield name="percent7" id="percent7" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">%</span>
	    	</div>
	  	</div>
		<div class="control-group">
		    <label class="control-label" for="">展示图片7</label>
		    <div class="controls">
			    <div class="cover-area">
					<table style="height: 30px;overflow: hidden;">
					<tr>
					<label>
						 <s:file name="picture7"  cssStyle="width:80%" accept="image/jpeg,image/png,image/jpg"  onchange="change7();" id="myfile7"></s:file>
					  </label>
					<br/>
					<img alt="暂无图片" src="<%=basePath%>wvoteimage${image7}"  id="myimage7" width="200px" height="160px"/>
				<script type="text/javascript">
							function change7() {
							    var pic = document.getElementById("myimage7"),
							        file = document.getElementById("myfile7");
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
							        html5Reader7(file);
							     }
							     pic.alt = '图片';
							}
							 
							 function html5Reader7(file){
							     var file = file.files[0];
							     var reader = new FileReader();
							     reader.readAsDataURL(file);
							     reader.onload = function(e){
							         var pic = document.getElementById("myimage7");
							         pic.src=this.result;
							     }
							 }
				</script>
					<td valign="top" style="line-height: 30px;color:gray;">建议尺寸：200像素 * 160像素</td>
					</tr>
					</table>
					<p class="img-area cover-bd" id="headpic2">
					</p>
				</div>
		    </div>
	  	</div>
	  		<div class="control-group">
	    	<label class="control-label" for="keyword">选项8</label>
	    	<div class="controls">
	    <s:textfield name="option8" id="option8" cssClass="span4"></s:textfield>		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入30个字符。</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项8票数</label>
	    	<div class="controls">
	    	<s:textfield name="number8" id="number8" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">*</span>
		    	<span class="help-inline">仅供查看</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项8票数所占比例</label>
	    	<div class="controls">
	    	<s:textfield name="percent8" id="percent8" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">%</span>
	    	</div>
	  	</div>
		<div class="control-group">
		    <label class="control-label" for="">展示图片8</label>
		    <div class="controls">
			    <div class="cover-area">
					<table style="height: 30px;overflow: hidden;">
					<tr>
					<label>
						 <s:file name="picture8"  cssStyle="width:80%" accept="image/jpeg,image/png,image/jpg"  onchange="change8();" id="myfile8"></s:file>
					  </label>
					<br/>
					<img alt="暂无图片" src="<%=basePath%>wvoteimage${image8}"  id="myimage8" width="200px" height="160px"/>
				<script type="text/javascript">
							function change8() {
							    var pic = document.getElementById("myimage8"),
							        file = document.getElementById("myfile8");
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
							        html5Reader8(file);
							     }
							     pic.alt = '图片';
							}
							 
							 function html5Reader8(file){
							     var file = file.files[0];
							     var reader = new FileReader();
							     reader.readAsDataURL(file);
							     reader.onload = function(e){
							         var pic = document.getElementById("myimage8");
							         pic.src=this.result;
							     }
							 }
				</script>
					<td valign="top" style="line-height: 30px;color:gray;">建议尺寸：200像素 * 160像素</td>
					</tr>
					</table>
					<p class="img-area cover-bd" id="headpic2">
					</p>
				</div>
		    </div>
	  	</div>
	  		<div class="control-group">
	    	<label class="control-label" for="keyword">选项9</label>
	    	<div class="controls">
	    	<s:textfield name="option9" id="option9" cssClass="span4"></s:textfield>		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入30个字符。</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项9票数</label>
	    	<div class="controls">
	    	<s:textfield name="number9" id="number9" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">*</span>
		    	<span class="help-inline">仅供查看</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项9票数所占比例</label>
	    	<div class="controls">
	    	<s:textfield name="percent9" id="percent9" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">%</span>
	    	</div>
	  	</div>
		<div class="control-group">
		    <label class="control-label" for="">展示图片9</label>
		    <div class="controls">
			    <div class="cover-area">
					<table style="height: 30px;overflow: hidden;">
					<tr>
					<label>
						 <s:file name="picture9"  cssStyle="width:80%" accept="image/jpeg,image/png,image/jpg"  onchange="change9();" id="myfile9"></s:file>
					  </label>
					<br/>
					<img alt="暂无图片" src="<%=basePath%>wvoteimage${image9}" id="myimage9" width="200px" height="160px"/>
				<script type="text/javascript">
							function change9() {
							    var pic = document.getElementById("myimage9"),
							        file = document.getElementById("myfile9");
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
							        html5Reader9(file);
							     }
							     pic.alt = '图片';
							}
							 
							 function html5Reader9(file){
							     var file = file.files[0];
							     var reader = new FileReader();
							     reader.readAsDataURL(file);
							     reader.onload = function(e){
							         var pic = document.getElementById("myimage9");
							         pic.src=this.result;
							     }
							 }
				</script>
					<td valign="top" style="line-height: 30px;color:gray;">建议尺寸：200像素 * 160像素</td>
					</tr>
					</table>
					<p class="img-area cover-bd" id="headpic2">
					</p>
				</div>
		    </div>
	  	</div>
	  		<div class="control-group">
	    	<label class="control-label" for="keyword">选项10</label>
	    	<div class="controls">
	    	<s:textfield name="option10" id="option10" cssClass="span4"></s:textfield>	    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入30个字符。</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项10票数</label>
	    	<div class="controls">
	    	<s:textfield name="number10" id="number10" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">*</span>
		    	<span class="help-inline">仅供查看</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">选项10票数所占比例</label>
	    	<div class="controls">
	    	<s:textfield name="percent10" id="percent10" cssClass="span4" readonly="true"></s:textfield>
	    		    	<span class="maroon">%</span>
	    	</div>
	  	</div>
		<div class="control-group">
		    <label class="control-label" for="">展示图片10</label>
		    <div class="controls">
			    <div class="cover-area">
					<table style="height: 30px;overflow: hidden;">
					<tr>
					<label>
						 <s:file name="picture10"  cssStyle="width:80%" accept="image/jpeg,image/png,image/jpg"  onchange="change10();" id="myfile10"></s:file>
					  </label>
					<br/>
					<img alt="暂无图片" src="<%=basePath%>wvoteimage${image10}"  id="myimage10" width="200px" height="160px"/>
				<script type="text/javascript">
							function change10() {
							    var pic = document.getElementById("myimage10"),
							        file = document.getElementById("myfile10");
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
							        html5Reader10(file);
							     }
							     pic.alt = '图片';
							}
							 
							 function html5Reader10(file){
							     var file = file.files[0];
							     var reader = new FileReader();
							     reader.readAsDataURL(file);
							     reader.onload = function(e){
							         var pic = document.getElementById("myimage10");
							         pic.src=this.result;
							     }
							 }
				</script>
					<td valign="top" style="line-height: 30px;color:gray;">建议尺寸：200像素 * 160像素</td>
					</tr>
					</table>
					<p class="img-area cover-bd" id="headpic2">
					</p>
				</div>
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