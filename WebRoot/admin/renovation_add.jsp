<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>整改办理</title>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/yyucadapter.js"></script>
		<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
		<SCRIPT type="text/javascript">
function checkform(){
		var name = document.getElementById('name').value;
		var renotype = document.getElementById('renotype').value;
		var content = document.getElementById('content').value;
		
		
		if(name=='')
		{
			alert("请输入举报人的姓名.");
			return false;
		}
		if(renotype==0)
		{
			alert("请选择整改主题.");
			return false;
		}
		if(content=='')
		{
			alert("请输入整改内容.");
			return false;
		}
	return true;
}

</SCRIPT>

		<link rel="stylesheet" href="css/admin/bootstrap.min.css">
		<link rel="stylesheet" href="css/admin/admin.css">
		<style type="text/css">
table td {
	min-width: 50px;
	overflow: hidden;
	text-overflow: ellipsis;
}

#picsethere {
	width: 510px;
	display: block;
}

#picsethere img {
	max-width: 500px;
	display: block;
}
</style>
	</head>
	<body style="height: 120%">
		<h3>
			数字城管-整改办理
		</h3>
		<div class="alert alert-info">
			<p>
				<span class="bold">说明：</span>说明内容
			</p>
		</div>
		<form class="form-horizontal" id="lbsForm" action="renovationAction!add" method="post" enctype="multipart/form-data" onsubmit="return checkform();">
			<div class="control-group">
				<label class="control-label" for="keyword">
					举报人
				</label>
				<div class="controls">
					<s:textfield name="renovation.name" id="name" cssClass="span4"
						placeholder="请输入举报人的姓名"></s:textfield>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="keyword">
					整改主题
				</label>
				<div class="controls">
					<s:select name="renovation.renotype" id="renotype" cssClass="dropdown-select" list="#{'1':'市容面貌','2':'宣传广告','3':'园林绿化','4':'黑车','5':'城市湖道','6':'街面秩序','7':'施工管理'}" label="整改主题" headerKey="" headerValue="请选择整改主题"></s:select> 
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="keyword">
					发布时间
				</label>
				<div class="controls">
					<input type="text" name="renovation.reporttime"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',readOnly:true})"
						id="logmin" class="input-text Wdate" style="width: 200px;">
				</div>
			</div>

			<div class="control-group">
				<label class="control-label" for="keyword">
					位置
				</label>
				<div class="controls">
					<s:textfield name="renovation.address" id="address"
						cssClass="span4" placeholder="请输入位置"></s:textfield>
				</div>
			</div>


			<div class="control-group">
				<label class="control-label" for="detail">
					整改内容:
				</label>
				<div class="controls">
					<s:textarea name="renovation.content" id="content" cssClass="span5"
						cssStyle="height:90px;width:520px;" placeholder="请输入整改原因内容"></s:textarea>
					<span class="maroon">*最多为1000个字符。</span>
					<br>
				</div>
			</div>

			<div class="control-group">
				<label class="control-label" for="detail">
					整改前照片:
				</label>
				<div class="controls">
					<label>
						<s:file name="picture1" accept="image/jpeg,image/png,image/jpg"
							onchange="change1();" id="myfile1"></s:file>
					</label>
					<img alt="暂无图片" id="myimage1" width="150px" height="80px" />
					<script type="text/javascript">
															function change1() {
															    var pic1 = document.getElementById("myimage1"),
															        file1 = document.getElementById("myfile1");
															    var ext1=file1.value.substring(file1.value.lastIndexOf(".")+1).toLowerCase();
															     // gif在IE浏览器暂时无法显示
															     if(ext1!='png'&&ext1!='jpg'&&ext1!='jpeg'){
															         alert("图片的格式必须为png或者jpg或者jpeg格式！"); 
															         return;
															     }
															     var isIE = navigator.userAgent.match(/MSIE/)!= null,
															         isIE6 = navigator.userAgent.match(/MSIE 6.0/)!= null;
															     if(isIE) {
															        file1.select();
															        var reallocalpath = document.selection.createRange().text;
															 
															        // IE6浏览器设置img的src为本地路径可以直接显示图片
															         if (isIE6) {
															            pic1.src = reallocalpath;
															         }else {
															            // 非IE6版本的IE由于安全问题直接设置img的src无法显示本地图片，但是可以通过滤镜来实现
															             pic1.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image',src=\"" + reallocalpath + "\")";
															             // 设置img的src为base64编码的透明图片 取消显示浏览器默认图片
															             pic1.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
															         }
															     }else {
															        html5Reader1(file1);
															     }
															     pic1.alt = '图片';
															}
															 function html5Reader1(file1){
															     var file1 = file1.files[0];
															     var reader1 = new FileReader();
															     reader1.readAsDataURL(file1);
															     reader1.onload = function(e){
															         var pic1 = document.getElementById("myimage1");
															         pic1.src=this.result;
															     }
															 }
												</script>
				</div>
			</div>


			<div class="control-group">
				<label class="control-label" for="detail">
					整改后照片:
				</label>
				<div class="controls">
					<label>
						<s:file name="picture2" accept="image/jpeg,image/png,image/jpg"
							onchange="change2();" id="myfile2"></s:file>
					</label>
					<img alt="暂无图片" id="myimage2" width="150px" height="80px" />
					<script type="text/javascript">
															function change2() {
															    var pic2 = document.getElementById("myimage2"),
															        file2 = document.getElementById("myfile2");
															    var ext2=file2.value.substring(file2.value.lastIndexOf(".")+1).toLowerCase();
															     // gif在IE浏览器暂时无法显示
															     if(ext2!='png'&&ext2!='jpg'&&ext2!='jpeg'){
															         alert("图片的格式必须为png或者jpg或者jpeg格式！"); 
															         return;
															     }
															     var isIE = navigator.userAgent.match(/MSIE/)!= null,
															         isIE6 = navigator.userAgent.match(/MSIE 6.0/)!= null;
															     if(isIE) {
															        file2.select();
															        var reallocalpath = document.selection.createRange().text;
															 
															        // IE6浏览器设置img的src为本地路径可以直接显示图片
															         if (isIE6) {
															            pic2.src = reallocalpath;
															         }else {
															            // 非IE6版本的IE由于安全问题直接设置img的src无法显示本地图片，但是可以通过滤镜来实现
															             pic2.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image',src=\"" + reallocalpath + "\")";
															             // 设置img的src为base64编码的透明图片 取消显示浏览器默认图片
															             pic2.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
															         }
															     }else {
															        html5Reader2(file2);
															     }
															     pic2.alt = '图片';
															}
															 function html5Reader2(file2){
															     var file2 = file2.files[0];
															     var reader2 = new FileReader();
															     reader2.readAsDataURL(file2);
															     reader2.onload = function(e){
															         var pic2 = document.getElementById("myimage2");
															         pic2.src=this.result;
															     }
															 }
												</script>
				</div>
			</div>


			<div>
				<div class="controls">
					<s:token></s:token>
					<input type="submit" class="btn btn-primary btn-large" value="保存" />
				</div>
			</div>
		</form>
</html>