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
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：微官网&gt;&gt;<a href='sontypeAction!newslist?publicaccount=${pubclient.publicaccount }&status=0' target='main'>新闻类别管理</a>&gt;&gt;查看新闻类别&nbsp;<a href="javascript:history.back();" style=" color:red;">[返回]</a></div>
  
<!--  内容列表   -->

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="33" colspan="2" align="center">
	<strong>新闻类别信息</strong></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">所属首页类别</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="sontype.bigtype.name" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">新闻类别名称</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="sontype.name" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">英文名</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="sontype.enname" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">图片</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
	  	<img src="<s:property value="sontype.image" />" width="80%"/>
		
	  </label></td>
</tr>


<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
  <td height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">是否显示</font></strong></td>
  <td align="left" style="padding-left: 50px;">
  	<s:if test="sontype.isshow==1">
  		显示
  	</s:if>
  	<s:else>
  		不显示
  	</s:else>
</td>
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