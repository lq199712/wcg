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
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：微官网>>全屏轮播</div>
<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#8BC7F1" align="center">
<tr>
 <td height="26">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td align="center">
  <input type='button' class='coolbg np' onClick="javascript:window.location='screenimgAction!goToAdd'" value='新增全屏轮播' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>
  
<!--  内容列表   -->

<table width="70%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="33" colspan="6" align="center">&nbsp;<b>全屏轮播</b>&nbsp;
	<s:hidden name="publicaccount" value="%{#session.pubclient.publicaccount}"></s:hidden>
	</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="5%" align="center">序号</td>
	<td width="45%" align="center">图片</td>
	<td width="10%" align="center">类型</td>
	<td width="5%" align="center">排序</td>
	<td width="5%" align="center">修改</td>
	<td width="5%" align="center">删除</td>
	</tr>
	<s:if test="%{screenimgs.size()==0}">
				<td colspan="6" align="center">
					暂无该信息
				</td>
			</s:if>
<s:iterator value="screenimgs" var="screenimg" status="status">
	<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
		<td><s:property value="#status.count" /></td>
	    <td>
		    	<img src="<s:property value="imageurl" />" width="60%">
	    </td>
	    <td>
			<s:if test="imgtype==1">开篇画面</s:if>
			<s:elseif test="imgtype==2">全屏轮播</s:elseif>	    
	    </td>
	    <td>
			<s:property value="imgorder" />    
	    </td>
		<td><a href="screenimgAction!load?id=<s:property value="id" />"><img src="skin/images/frame/huiwu_3.gif" width="20" height="20" border="0"></a></td>
		<td><a href="screenimgAction!delete?id=<s:property value="id" />" onclick="return confirm('你确定删除该信息吗？')"><img src="skin/images/frame/huiwu_2.gif" width="20" height="20" border="0"></a></td>
	</tr>
</s:iterator>


</table>


</body>
</html>