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
<title>公众账号管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">

<script type="text/javascript" src="js/pageKit.js"></script></head>
<body leftmargin="8" topmargin="8" >
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：公众平台管理&gt;&gt;<a href='pubclientAction!list' target='main'>公众账号管理</a>&gt;&gt;新增公众账号&nbsp;<a href="javascript:history.back();" style=" color:red;">[返回]</a></div>
  
<!--  内容列表   -->
<form name="form2" action="pubclientAction!add" method="post">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="33" colspan="2" align="center"><strong>新增公众账号</strong></td>
</tr>


<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">客户姓名</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="pubclient.realname" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">登陆用户名</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="pubclient.username" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">手机号码</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="pubclient.phone" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">公众号名称</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="pubclient.publicname" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">公众号账号</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="pubclient.publicno" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">公众号原始ID</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="pubclient.publicaccount" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">邮箱号码</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="pubclient.email" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">URL</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="pubclient.url" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">Token</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="pubclient.token" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
  <td height="25" align="right"><strong><font color="#333333">账号类型</font></strong></td>
  <td align="left">
  	<s:select list="#{0:'未认证订阅号',1:'已认证订阅号',2:'未认证服务号',3:'已认证服务号'}" name="pubclient.accounttype" listKey="key" listValue="value"></s:select>
</td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">AppID</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="pubclient.appid" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">AppSecret</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="pubclient.appsecret" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">access_token</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="pubclient.accessToken" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">咨询电话</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="pubclient.comtel" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">导航地址</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="pubclient.navurl" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">官网首页</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="pubclient.enterurl" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="right"><strong><font color="#333333">开篇图片入口地址</font></strong></td>
	<td width="75%" align="left">
	  <label>
		<s:textfield name="pubclient.imgurl" cssStyle="width:80%"></s:textfield>
	  </label></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
  <td height="25" align="right"><strong><font color="#333333">模板</font></strong></td>
  <td align="left">
  	<s:select list="#{1:'模板1',2:'模板2',3:'模板3'}" name="pubclient.template" listKey="key" listValue="value" value="2"></s:select>
</td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
  <td height="25" align="right"><strong><font color="#333333">权限</font></strong></td>
  <td align="left">
  	<s:select list="#{0:'管理员',1:'公众号客户'}" name="pubclient.limits" listKey="key" listValue="value"></s:select>
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