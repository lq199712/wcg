<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>微官网</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">

<script type="text/javascript" src="js/pageKit.js"></script>
<link rel="stylesheet" href="kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="kindeditor/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="pagearticle.description"]', {
				cssPath : 'kindeditor/plugins/code/prettify.css',
				uploadJson : 'kindeditor/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>

</head>
<body leftmargin="8" topmargin="8" >
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：微官网&gt;&gt;<a href='pagearticleAction!list3?publicaccount=${pubclient.publicaccount }&status=3' target='main'>设计师团队管理</a>&gt;&gt;新增设计师团队&nbsp;<a href="javascript:history.back();" style=" color:red;">[返回]</a></div>
  
<!--  内容列表   -->
<form name="form2" action="pagearticleAction!add3" method="post"  enctype="multipart/form-data" >

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="33" colspan="2" align="center"><strong>新增设计师团队</strong>
		<s:hidden name="pagearticle.articletype" value="3"></s:hidden>
		<s:hidden name="pagearticle.publicaccount" value="%{#session.pubclient.publicaccount}"></s:hidden>
	</td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
  <td height="25" align="right"><strong><font color="#333333">子页类别</font></strong></td>
  <td align="left">
  	<s:select list="sontypes" name="pagearticle.sontype.id" listKey="id" listValue="name" value="3"></s:select>
</td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="10%" height="25" align="right"><strong><font color="#333333">设计师名称</font></strong></td>
	<td width="90%" align="left">
	  <label>
		<s:textfield name="pagearticle.name" cssStyle="width:95%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td height="25" align="right"><strong><font color="#333333">职务</font></strong></td>
	<td align="left">
	  <label>
		<s:textfield name="pagearticle.shortname" cssStyle="width:95%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td height="25" align="right"><strong><font color="#333333">预约号码</font></strong></td>
	<td align="left">
	  <label>
		<s:textfield name="pagearticle.pphone" cssStyle="width:95%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td height="25" align="right"><strong><font color="#333333">封面图片</font></strong></td>
	<td align="left">
	  <label>
		<s:file name="picture" cssStyle="width:400px" onchange="change();" id="myfile"></s:file><br/>
		<img alt="暂无图片" src="" id="myimage" width="400px">
		<SCRIPT type="text/javascript">
function change() {
    var pic = document.getElementById("myimage"),
        file = document.getElementById("myfile");
 
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
	  </label>
	</td>
</tr>



<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td height="25" align="right"><strong><font color="#333333">视频代码</font></strong></td>
	<td align="left">
	  <label>
		<s:textfield name="pagearticle.videourl" cssStyle="width:95%"></s:textfield><br/>
		提示：请先上传视频到优酷、土豆,再复制代码到这里;说明：高度height、宽度width
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td height="25" align="right"><strong><font color="#333333">设计师团队链接</font></strong></td>
	<td align="left">
	  <label>
		<s:textfield name="pagearticle.articlelink" cssStyle="width:95%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td height="25" align="right"><strong><font color="#333333">设计师介绍</font></strong></td>
	<td align="left">
	  <label>
		<s:textarea name="pagearticle.description" cssStyle="width:95%;height:800px;visibility:hidden;"></s:textarea>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td height="25" align="right"><strong><font color="#333333">包含项目</font></strong></td>
	<td align="left">
	  <label>
		<s:textarea name="pagearticle.project" cssStyle="width:95%;height:200px;"></s:textarea>
	  </label></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
  <td height="25" align="right"><strong><font color="#333333">是否显示</font></strong></td>
  <td align="left">
  	<s:select list="#{1:'启用',0:'不启用',2:'头版文章'}" name="pagearticle.isshow" listKey="key" listValue="value"></s:select>
</td>
</tr>



</table>

<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td height="29" align="center" valign="bottom">
    <s:token></s:token>
      <input type='submit' class="coolbg np" onClick="" value='保存' style="width:80" />&nbsp;&nbsp;
      <input type='reset' class="coolbg np" onClick="" value='重置' style="width:80" />&nbsp;&nbsp;
      <input type='button' class="coolbg np" onClick="javascript:history.back();" value='返回' style="width:80" />&nbsp;&nbsp;</td>
  </tr>
  <tr>
    <td height="18" align="center">&nbsp;</td>
  </tr>
</table>


</form>

</body>
</html>