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
<title>回复功能</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">

</head>
<body leftmargin="8" topmargin="8" >
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：回复功能&gt;&gt;修改菜单&nbsp;<a href="javascript:history.back();" style=" color:red;">[返回]</a></div>
  
<!--  内容列表   -->
<form name="form2" action="custommenuAction!update" method="post" >

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#DD605E">
	<td height="33" colspan="4" align="center"><strong>修改菜单</strong>
		<s:hidden name="custommenu.id"></s:hidden>
		<s:hidden name="custommenu.createdate"></s:hidden>
		<s:hidden name="custommenu.publicaccount" value="%{#session.pubclient.publicaccount}"></s:hidden>
	</td>
</tr>

<tr bgcolor="#E7E7E7">
	<td height="33" colspan="4" align="center"><strong>二级菜单</strong>
	</td>
</tr>
<!-- 菜单倒数第五行 -->
<tr align="center" bgcolor="#5DA290" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#5DA290';" height="25" >
	<td width="10%" height="25" align="center">
		5-菜单名：
	</td>
	<td width="30%" align="center">
		<s:textfield name="custommenu.menu1son5" cssStyle="width:60%"></s:textfield>
	</td>
	<td width="30%" align="center">
		<s:textfield name="custommenu.menu2son5" cssStyle="width:60%"></s:textfield>
	</td>
	<td width="30%" align="center">
		<s:textfield name="custommenu.menu3son5" cssStyle="width:60%"></s:textfield>
	</td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="10%" height="25" align="center">
		菜单别名：<br>
		菜单类型：<br>
		素材：<br>
		URL：
	</td>
	<td width="30%" align="left">
		<s:textfield name="custommenu.menu1son5key" cssStyle="width:98%"></s:textfield><br>
		<s:radio list="#{'click':'回复信息','view':'网页跳转'}" name="custommenu.menu1son5type" listKey="key" listValue="value"></s:radio><br>
		<s:select list="fodders" listKey="id" listValue="title" name="custommenu.menu1son5resid"></s:select><br>
		<s:textfield name="custommenu.menu1son5url" cssStyle="width:98%"></s:textfield>
	</td>
	<td width="30%" align="left">
		<s:textfield name="custommenu.menu2son5key" cssStyle="width:98%"></s:textfield><br>
		<s:radio list="#{'click':'回复信息','view':'网页跳转'}" name="custommenu.menu2son5type" listKey="key" listValue="value"></s:radio><br>
		<s:select list="fodders" listKey="id" listValue="title" name="custommenu.menu2son5resid"></s:select><br>
		<s:textfield name="custommenu.menu2son5url" cssStyle="width:98%"></s:textfield>
	</td>
	<td width="30%" align="left">
		<s:textfield name="custommenu.menu3son5key" cssStyle="width:98%"></s:textfield><br>
		<s:radio list="#{'click':'回复信息','view':'网页跳转'}" name="custommenu.menu3son5type" listKey="key" listValue="value"></s:radio><br>
		<s:select list="fodders" listKey="id" listValue="title" name="custommenu.menu3son5resid"></s:select><br>
		<s:textfield name="custommenu.menu3son5url" cssStyle="width:98%"></s:textfield>
	</td>
</tr>

<!-- 菜单倒数第四行 -->
<tr align="center" bgcolor="#5DA290" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#5DA290';" height="25" >
	<td width="10%" height="25" align="center">
		4-菜单名：
	</td>
	<td width="30%" align="center">
		<s:textfield name="custommenu.menu1son4" cssStyle="width:60%"></s:textfield>
	</td>
	<td width="30%" align="center">
		<s:textfield name="custommenu.menu2son4" cssStyle="width:60%"></s:textfield>
	</td>
	<td width="30%" align="center">
		<s:textfield name="custommenu.menu3son4" cssStyle="width:60%"></s:textfield>
	</td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="10%" height="25" align="center">
		菜单别名：<br>
		菜单类型：<br>
		素材：<br>
		URL：
	</td>
	<td width="30%" align="left">
		<s:textfield name="custommenu.menu1son4key" cssStyle="width:98%"></s:textfield><br>
		<s:radio list="#{'click':'回复信息','view':'网页跳转'}" name="custommenu.menu1son4type" listKey="key" listValue="value"></s:radio><br>
		<s:select list="fodders" listKey="id" listValue="title" name="custommenu.menu1son4resid"></s:select><br>
		<s:textfield name="custommenu.menu1son4url" cssStyle="width:98%"></s:textfield>
	</td>
	<td width="30%" align="left">
		<s:textfield name="custommenu.menu2son4key" cssStyle="width:98%"></s:textfield><br>
		<s:radio list="#{'click':'回复信息','view':'网页跳转'}" name="custommenu.menu2son4type" listKey="key" listValue="value"></s:radio><br>
		<s:select list="fodders" listKey="id" listValue="title" name="custommenu.menu2son4resid"></s:select><br>
		<s:textfield name="custommenu.menu2son4url" cssStyle="width:98%"></s:textfield>
	</td>
	<td width="30%" align="left">
		<s:textfield name="custommenu.menu3son4key" cssStyle="width:98%"></s:textfield><br>
		<s:radio list="#{'click':'回复信息','view':'网页跳转'}" name="custommenu.menu3son4type" listKey="key" listValue="value"></s:radio><br>
		<s:select list="fodders" listKey="id" listValue="title" name="custommenu.menu3son4resid"></s:select><br>
		<s:textfield name="custommenu.menu3son4url" cssStyle="width:98%"></s:textfield>
	</td>
</tr>

<!-- 菜单倒数第三行 -->
<tr align="center" bgcolor="#5DA290" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#5DA290';" height="25" >
	<td width="10%" height="25" align="center">
		3-菜单名：
	</td>
	<td width="30%" align="center">
		<s:textfield name="custommenu.menu1son3" cssStyle="width:60%"></s:textfield>
	</td>
	<td width="30%" align="center">
		<s:textfield name="custommenu.menu2son3" cssStyle="width:60%"></s:textfield>
	</td>
	<td width="30%" align="center">
		<s:textfield name="custommenu.menu3son3" cssStyle="width:60%"></s:textfield>
	</td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="10%" height="25" align="center">
		菜单别名：<br>
		菜单类型：<br>
		素材：<br>
		URL：
	</td>
	<td width="30%" align="left">
		<s:textfield name="custommenu.menu1son3key" cssStyle="width:98%"></s:textfield><br>
		<s:radio list="#{'click':'回复信息','view':'网页跳转'}" name="custommenu.menu1son3type" listKey="key" listValue="value"></s:radio><br>
		<s:select list="fodders" listKey="id" listValue="title" name="custommenu.menu1son3resid"></s:select><br>
		<s:textfield name="custommenu.menu1son3url" cssStyle="width:98%"></s:textfield>
	</td>
	<td width="30%" align="left">
		<s:textfield name="custommenu.menu2son3key" cssStyle="width:98%"></s:textfield><br>
		<s:radio list="#{'click':'回复信息','view':'网页跳转'}" name="custommenu.menu2son3type" listKey="key" listValue="value"></s:radio><br>
		<s:select list="fodders" listKey="id" listValue="title" name="custommenu.menu2son3resid"></s:select><br>
		<s:textfield name="custommenu.menu2son3url" cssStyle="width:98%"></s:textfield>
	</td>
	<td width="30%" align="left">
		<s:textfield name="custommenu.menu3son3key" cssStyle="width:98%"></s:textfield><br>
		<s:radio list="#{'click':'回复信息','view':'网页跳转'}" name="custommenu.menu3son3type" listKey="key" listValue="value"></s:radio><br>
		<s:select list="fodders" listKey="id" listValue="title" name="custommenu.menu3son3resid"></s:select><br>
		<s:textfield name="custommenu.menu3son3url" cssStyle="width:98%"></s:textfield>
	</td>
</tr>

<!-- 菜单倒数第二行 -->
<tr align="center" bgcolor="#5DA290" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#5DA290';" height="25" >
	<td width="10%" height="25" align="center">
		2-菜单名：
	</td>
	<td width="30%" align="center">
		<s:textfield name="custommenu.menu1son2" cssStyle="width:60%"></s:textfield>
	</td>
	<td width="30%" align="center">
		<s:textfield name="custommenu.menu2son2" cssStyle="width:60%"></s:textfield>
	</td>
	<td width="30%" align="center">
		<s:textfield name="custommenu.menu3son2" cssStyle="width:60%"></s:textfield>
	</td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="10%" height="25" align="center">
		菜单别名：<br>
		菜单类型：<br>
		素材：<br>
		URL：
	</td>
	<td width="30%" align="left">
		<s:textfield name="custommenu.menu1son2key" cssStyle="width:98%"></s:textfield><br>
		<s:radio list="#{'click':'回复信息','view':'网页跳转'}" name="custommenu.menu1son2type" listKey="key" listValue="value"></s:radio><br>
		<s:select list="fodders" listKey="id" listValue="title" name="custommenu.menu1son2resid"></s:select><br>
		<s:textfield name="custommenu.menu1son2url" cssStyle="width:98%"></s:textfield>
	</td>
	<td width="30%" align="left">
		<s:textfield name="custommenu.menu2son2key" cssStyle="width:98%"></s:textfield><br>
		<s:radio list="#{'click':'回复信息','view':'网页跳转'}" name="custommenu.menu2son2type" listKey="key" listValue="value"></s:radio><br>
		<s:select list="fodders" listKey="id" listValue="title" name="custommenu.menu2son2resid"></s:select><br>
		<s:textfield name="custommenu.menu2son2url" cssStyle="width:98%"></s:textfield>
	</td>
	<td width="30%" align="left">
		<s:textfield name="custommenu.menu3son2key" cssStyle="width:98%"></s:textfield><br>
		<s:radio list="#{'click':'回复信息','view':'网页跳转'}" name="custommenu.menu3son2type" listKey="key" listValue="value"></s:radio><br>
		<s:select list="fodders" listKey="id" listValue="title" name="custommenu.menu3son2resid"></s:select><br>
		<s:textfield name="custommenu.menu3son2url" cssStyle="width:98%"></s:textfield>
	</td>
</tr>

<!-- 菜单倒数第一行 -->
<tr align="center" bgcolor="#5DA290" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#5DA290';" height="25" >
	<td width="10%" height="25" align="center">
		1-菜单名：
	</td>
	<td width="30%" align="center">
		<s:textfield name="custommenu.menu1son1" cssStyle="width:60%"></s:textfield>
	</td>
	<td width="30%" align="center">
		<s:textfield name="custommenu.menu2son1" cssStyle="width:60%"></s:textfield>
	</td>
	<td width="30%" align="center">
		<s:textfield name="custommenu.menu3son1" cssStyle="width:60%"></s:textfield>
	</td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="10%" height="25" align="center">
		菜单别名：<br>
		菜单类型：<br>
		素材：<br>
		URL：
	</td>
	<td width="30%" align="left">
		<s:textfield name="custommenu.menu1son1key" cssStyle="width:98%"></s:textfield><br>
		<s:radio list="#{'click':'回复信息','view':'网页跳转'}" name="custommenu.menu1son1type" listKey="key" listValue="value"></s:radio><br>
		<s:select list="fodders" listKey="id" listValue="title" name="custommenu.menu1son1resid"></s:select><br>
		<s:textfield name="custommenu.menu1son1url" cssStyle="width:98%"></s:textfield>
	</td>
	<td width="30%" align="left">
		<s:textfield name="custommenu.menu2son1key" cssStyle="width:98%"></s:textfield><br>
		<s:radio list="#{'click':'回复信息','view':'网页跳转'}" name="custommenu.menu2son1type" listKey="key" listValue="value"></s:radio><br>
		<s:select list="fodders" listKey="id" listValue="title" name="custommenu.menu2son1resid"></s:select><br>
		<s:textfield name="custommenu.menu2son1url" cssStyle="width:98%"></s:textfield>
	</td>
	<td width="30%" align="left">
		<s:textfield name="custommenu.menu3son1key" cssStyle="width:98%"></s:textfield><br>
		<s:radio list="#{'click':'回复信息','view':'网页跳转'}" name="custommenu.menu3son1type" listKey="key" listValue="value"></s:radio><br>
		<s:select list="fodders" listKey="id" listValue="title" name="custommenu.menu3son1resid"></s:select><br>
		<s:textfield name="custommenu.menu3son1url" cssStyle="width:98%"></s:textfield>
	</td>
</tr>


<!-- 菜单一级菜单 -->
<tr bgcolor="#E7E7E7">
	<td height="33" colspan="4" align="center"><strong>一级菜单</strong>
	</td>
</tr>

<tr align="center" bgcolor="#5DA290" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#5DA290';" height="25" >
	<td width="10%" height="25" align="center">
		大菜单名：
	</td>
	<td width="30%" align="center">
		<s:textfield name="custommenu.menu1" cssStyle="width:60%"></s:textfield>
	</td>
	<td width="30%" align="center">
		<s:textfield name="custommenu.menu2" cssStyle="width:60%"></s:textfield>
	</td>
	<td width="30%" align="center">
		<s:textfield name="custommenu.menu3" cssStyle="width:60%"></s:textfield>
	</td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="10%" height="25" align="center">
		子节点：<br>
		菜单别名：<br>
		菜单类型：<br>
		素材：<br>
		URL：
	</td>
	<td width="30%" align="left">
		<s:radio list="#{'1':'是','0':'否'}" name="custommenu.isend1" listKey="key" listValue="value"></s:radio><br>
		<s:textfield name="custommenu.menu1key" cssStyle="width:98%"></s:textfield><br>
		<s:radio list="#{'click':'回复信息','view':'网页跳转'}" name="custommenu.menu1type" listKey="key" listValue="value"></s:radio><br>
		<s:select list="fodders" listKey="id" listValue="title" name="custommenu.menu1resid"></s:select><br>
		<s:textfield name="custommenu.menu1url" cssStyle="width:98%"></s:textfield>
	</td>
	<td width="30%" align="left">
		<s:radio list="#{'1':'是','0':'否'}" name="custommenu.isend2" listKey="key" listValue="value"></s:radio><br>
		<s:textfield name="custommenu.menu2key" cssStyle="width:98%"></s:textfield><br>
		<s:radio list="#{'click':'回复信息','view':'网页跳转'}" name="custommenu.menu2type" listKey="key" listValue="value"></s:radio><br>
		<s:select list="fodders" listKey="id" listValue="title" name="custommenu.menu2resid"></s:select><br>
		<s:textfield name="custommenu.menu2url" cssStyle="width:98%"></s:textfield>
	</td>
	<td width="30%" align="left">
		<s:radio list="#{'1':'是','0':'否'}" name="custommenu.isend3" listKey="key" listValue="value"></s:radio><br>
		<s:textfield name="custommenu.menu3key" cssStyle="width:98%"></s:textfield><br>
		<s:radio list="#{'click':'回复信息','view':'网页跳转'}" name="custommenu.menu3type" listKey="key" listValue="value"></s:radio><br>
		<s:select list="fodders" listKey="id" listValue="title" name="custommenu.menu3resid"></s:select><br>
		<s:textfield name="custommenu.menu3url" cssStyle="width:98%"></s:textfield>
	</td>
</tr>


</table>

<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td height="29" align="center" valign="bottom">
    <s:token></s:token>
      <input type='submit' class="coolbg np" onClick="" value='保存' style="width:80" />&nbsp;&nbsp;
      <input type='reset' class="coolbg np" onClick="" value='重置' style="width:80" />&nbsp;&nbsp;
      <input type='button' class="coolbg np" onClick="javascript:history.back();" value='返回' style="width:80" />&nbsp;&nbsp;
      <input type='button' class="coolbg np" onClick="javascript:alert('发布之后重新关注或12小时之后生效！');window.location.href='custommenuAction!deploy?publicaccount=${pubclient.publicaccount }';" value='发布' style="width:80" />&nbsp;&nbsp;  
    </td>
  </tr>
  <tr>
    <td height="18" align="center">&nbsp;</td>
  </tr>
</table>


</form>

</body>
</html>