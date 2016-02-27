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
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：功能管理&gt;&gt;<a href='keyresAction!list?pkid=<s:property value="pkid"/>' target='main'>关键词管理</a>&gt;&gt;修改关键词&nbsp;<a href="javascript:history.back();" style=" color:red;">[返回]</a></div>
  
<!--  内容列表   -->
<form name="form2" action="keyresAction!update" method="post" >

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="33" colspan="2" align="center"><strong>修改关键词</strong>
		<s:hidden name="keyres.publickey.id" value="%{pkid}"></s:hidden>
		<s:hidden name="keyres.id"></s:hidden>
		<s:hidden name="pkid"/>
	</td>
</tr>


<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">关键词</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="keyres.keytitle" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">素材</font></strong></td>
	<td width="75%" align="left">
	  <label>
	  	<s:radio list="fodders"  listKey="id" listValue="title" name="keyres.fodderid"></s:radio>
	  	
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