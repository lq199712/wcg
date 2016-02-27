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
<title>功能管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">

</head>
<body leftmargin="8" topmargin="8" >
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：功能管理&gt;&gt;查看关键词&nbsp;</div>
  
<!--  内容列表   -->

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="33" colspan="2" align="center">
	<strong>关键词标题</strong></td>
</tr>


<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">回复内容</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
	  <a href="keyresAction!list?pkid=<s:property value="publickey.id" />">
		<s:property value="publickey.title" />
	  </a>
	  </label></td>
</tr>


</table>

<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td height="29" align="center" valign="bottom">
    	<input type='button' class="coolbg np" onClick="window.location.href='publickeyAction!load?id=<s:property value="publickey.id"/>'" value='修改' style="width:80" />&nbsp;&nbsp;
      </td>
  </tr>
  <tr>
    <td height="18" align="center">&nbsp;</td>
  </tr>
</table>



</body>
</html>