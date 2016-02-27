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
<title>管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">

<script type="text/javascript" src="js/pageKit.js"></script></head>
<body leftmargin="8" topmargin="8" >
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：管理>>
<s:if test="fodder!=null">
		[<s:property value="fodder.title" />]
</s:if>>>多图文管理&nbsp;<a href="javascript:history.back();" style=" color:red;">[返回]</a></div>
<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#8BC7F1" align="center">
<tr>
 <td height="26">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td align="center">
  <input type='button' class='coolbg np' onClick="javascript:window.location='fodderarticleAction!goToAdd?fodderid=<s:property value="fodderid"/>'" value='新增多图文' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>
  
<!--  内容列表   -->

<table width="50%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="33" colspan="4" align="center">&nbsp;
	<b>
	<s:if test="fodder!=null">
		[<s:property value="fodder.title" />]-
	</s:if>
	多图文管理
	
	</b>&nbsp;
	</td>
</tr>

<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="5%" align="center">序号</td>
	<td width="35%" align="center">标题</td>
	<td width="5%" align="center">修改</td>
	<td width="5%" align="center">删除</td>
	</tr>
	<s:if test="%{fodderarticles.size()==0}">
				<td colspan="4" align="center">
					暂无该信息
				</td>
			</s:if>
<s:iterator value="fodderarticles" var="fodderarticle" status="status">
	<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
		<td><s:property value="#status.count" /></td>
	    <td><a href="fodderarticleAction!view?id=<s:property value="id"/>&fodderid=<s:property value="fodder.id" />"><s:property value="title" /></a></td>
		<td><a href="fodderarticleAction!load?id=<s:property value="id" />&fodderid=<s:property value="fodder.id" />"><img src="skin/images/frame/huiwu_3.gif" width="20" height="20" border="0"></a></td>
		<td><a href="fodderarticleAction!delete?id=<s:property value="id" />&fodderid=<s:property value="fodder.id" />" onclick="return confirm('你确定删除该信息吗？')"><img src="skin/images/frame/huiwu_2.gif" width="20" height="20" border="0"></a></td>
	</tr>
</s:iterator>

</table>

</body>
</html>