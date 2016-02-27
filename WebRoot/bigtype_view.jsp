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
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：微官网&gt;&gt;<a href='bigtypeAction!list?publicaccount=${pubclient.publicaccount }' target='main'>首页类别管理</a>&gt;&gt;查看首页类别&nbsp;<a href="javascript:history.back();" style=" color:red;">[返回]</a></div>
  
<!--  内容列表   -->

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="33" colspan="2" align="center">
	<strong>首页类别信息</strong></td>
</tr>


<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">首页类别名称</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="bigtype.name" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">英文名</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="bigtype.enname" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#79CBE5';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">图片</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
	  	<img src="<s:property value="bigtype.image" />" width="100" height="100"/>
		
	  </label></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
  <td height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">只作为链接</font></strong></td>
  <td align="left" style="padding-left: 50px;">
  	<s:if test="bigtype.islinkonly==0">
  		否
  	</s:if>
  	<s:else>
  		是
  	</s:else>
</td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">链接地址</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="bigtype.linkurl" />
	  </label></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
  <td height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">是否显示</font></strong></td>
  <td align="left" style="padding-left: 50px;">
  	<s:if test="bigtype.isshow==1">
  		显示
  	</s:if>
  	<s:else>
  		不显示
  	</s:else>
</td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">排序ID</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="bigtype.orderid" />
	  </label></td>
</tr>

</table>

<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td height="29" align="center" valign="bottom">
      <input type='button' class="coolbg np" onClick="javascript:history.back();" value='返回' style="width:80" />&nbsp;&nbsp;</td>
  </tr>
  <tr>
    <td height="18" align="center">&nbsp;</td>
  </tr>
</table>



</body>
</html>