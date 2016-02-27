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

<script type="text/javascript" src="js/pageKit.js"></script></head>
<body leftmargin="8" topmargin="8" >
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：微官网&gt;&gt;<a href='sontypeAction!list?publicaccount=${pubclient.publicaccount }&status=1' target='main'>类别管理</a>&gt;&gt;修改类别&nbsp;<a href="javascript:history.back();" style=" color:red;">[返回]</a></div>
  
<!--  内容列表   -->
<form name="form2" action="sontypeAction!update" method="post"  enctype="multipart/form-data" >

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="33" colspan="2" align="center"><strong>修改类别</strong>
	<s:hidden name="sontype.id"></s:hidden>
	<s:hidden name="sontype.image"></s:hidden>
	<s:hidden name="sontype.producttype"></s:hidden>
	</td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
  <td height="25" align="right"><strong><font color="#333333">所属首页类别</font></strong></td>
  <td align="left">
  	<s:select list="bigtypes" name="sontype.bigtype.id" listKey="id" listValue="name"></s:select>
</td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">类别名称</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="sontype.name" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">英文名</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="sontype.enname" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">图片</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:file name="picture" cssStyle="width:80%" onchange="change();" id="myfile"></s:file><br/>
		<img alt="暂无图片" src="<s:property value="sontype.image"/>" id="myimage" width="80%">
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


<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
  <td height="25" align="right"><strong><font color="#333333">是否显示</font></strong></td>
  <td align="left">
  	<s:select list="#{1:'启用',0:'不启用'}" name="sontype.isshow" listKey="key" listValue="value"></s:select>
</td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">排序</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="sontype.orderid" cssStyle="width:80%"></s:textfield>
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