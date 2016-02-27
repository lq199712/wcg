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
<title>公众账号信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">

<script type="text/javascript" src="js/pageKit.js"></script></head>
<body leftmargin="8" topmargin="8" >
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：公众账号信息&nbsp;<a href="javascript:history.back();" style=" color:red;">[返回]</a></div>
  
<!--  内容列表   -->

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="33" colspan="2" align="center">
	<strong>公众账号信息</strong></td>
</tr>


<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">客户姓名</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pubclient.realname" />
		<!-- 
		<font color="red">[*提示：请复制URL和Token，进入微信公众平台开发者中心并提交，才能开通本系统的"回复功能"、"管理"栏目的功能;您亦可不提交而直接使用微信公众平台自带的回复功能以及素材管理]</font>
	  	 -->
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">登陆用户名</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pubclient.username" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">手机号码</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pubclient.phone" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">公众号名称</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pubclient.publicname" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">公众号账号</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pubclient.publicno" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">公众号原始ID</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pubclient.publicaccount" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">邮箱号码</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pubclient.email" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">URL</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pubclient.url" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">Token</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pubclient.token" />
	  </label></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
  <td height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">账号类型</font></strong></td>
  <td align="left" style="padding-left: 50px;">
  	<s:if test="pubclient.accounttype==1">
  		已认证订阅号
  	</s:if>
  	<s:elseif test="pubclient.accounttype==2">
  		未认证服务号
  	</s:elseif>
  	<s:elseif test="pubclient.accounttype==3">
  		已认证服务号
  	</s:elseif>
  	<s:else>
  		未认证订阅号
  	</s:else>
  </td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">AppID</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pubclient.appid" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">AppSecret</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pubclient.appsecret" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">access_token</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pubclient.accessToken" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">公司座机</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pubclient.comtel" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">导航地址</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pubclient.navurl" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">微官网首页</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pubclient.enterurl" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">欢迎界面</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pubclient.imgurl" />
	  </label></td>
</tr>

</table>

<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td height="29" align="center" valign="bottom">
      <input type='submit' class="coolbg np" onClick="javascript:window.location.href='pubclient_upPwd.jsp';" value='修改密码' style="width:80" />&nbsp;&nbsp;
      <input type='button' class="coolbg np" onClick="javascript:history.back();" value='返回' style="width:80" />&nbsp;&nbsp;</td>
  </tr>
  <tr>
    <td height="18" align="center">&nbsp;</td>
  </tr>
</table>



</body>
</html>