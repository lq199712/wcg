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

</head>
<body leftmargin="8" topmargin="8" >
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：微官网&gt;&gt;<a href='bigtypeAction!list?publicaccount=${pubclient.publicaccount }' target='main'>首页类别管理</a>&gt;&gt;新增首页类别&nbsp;<a href="javascript:history.back();" style=" color:red;">[返回]</a></div>
  
<!--  内容列表   -->
<form name="form2" action="bigtypeAction!add" method="post"  enctype="multipart/form-data" >

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="33" colspan="2" align="center"><strong>新增首页类别</strong>
		<s:hidden name="bigtype.publicaccount" value="%{#session.pubclient.publicaccount}"></s:hidden>
	</td>
</tr>


<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">首页类别名称</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="bigtype.name" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">英文名</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="bigtype.enname" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#79CBE5';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">图片</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:file name="picture" cssStyle="width:80%" onchange="change();" id="myfile"></s:file><br/>
		<img alt="暂无图片" src="" id="myimage" width="100" height="100" />
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
			/*
			function preImg(sourceId, targetId) {  
			    if (typeof FileReader === 'undefined') {  
			        alert('您的浏览器不支持图片预览,请使用IE10+、360极速模式、chrome、Firefox、等流行浏览器'); 
			         document.getElementById(targetId).src =  document.getElementById(targetId).value;
			        return;  
			    }  
			    var reader = new FileReader();  
			  
			    reader.onload = function(e) {  
			        var img = document.getElementById(targetId);  
			        img.src = this.result;  
			    }  
			    reader.readAsDataURL(document.getElementById(sourceId).files[0]);  
			}  
			*/
		</SCRIPT>
	  </label>
	</td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
  <td height="25" align="right"><strong><font color="#333333">只作为链接</font></strong></td>
  <td align="left">
  	<s:select list="#{0:'否',1:'是'}" name="bigtype.islinkonly" listKey="key" listValue="value" value="0"></s:select>
</td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">链接地址</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="bigtype.linkurl" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
  <td height="25" align="right"><strong><font color="#333333">是否显示</font></strong></td>
  <td align="left">
  	<s:select list="#{1:'启用',0:'不启用'}" name="bigtype.isshow" listKey="key" listValue="value"></s:select>
</td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
  <td height="25" align="right"><strong><font color="#333333">列表页风格</font></strong></td>
  <td align="left">
  	<s:select list="#{0:'无',1:'门店活动',2:'服务指南',3:'设计师团队'}" name="bigtype.btype" listKey="key" listValue="value"></s:select>
</td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">排序ID</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="bigtype.orderid" cssStyle="width:80%"></s:textfield>
	  </label></td>
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