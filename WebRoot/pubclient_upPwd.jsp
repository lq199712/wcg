<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公众号管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">

<script type="text/javascript" src="js/pageKit.js"></script></head>
<body leftmargin="8" topmargin="8" >
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：管理>><a href='pubclientAction!clientview?id=${pubclient.id }' target='main'>公众号管理</a>>>修改密码</div>
  
<!--  内容列表   -->
<form name="form2" action="pubclientAction!upMyPwd" method="post">

<table width="50%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="33" colspan="2" align="center"><strong>修改密码</strong></td>
</tr>




<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="25%" height="25" align="center"><strong><font color="#333333">用户名</font></strong></td>
	<td width="75%" align="left"><label>
	  <s:textfield name="username" value="%{#session.pubclient.username}" cssStyle="width:60%" readonly="true" onkeydown="keyDown()"/>
	  </label></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
  <td height="25"><strong><font color="#333333">原密码</font></strong></td>
  <td align="left">
  <s:password name="oldpwd"  cssStyle="width:60%"></s:password>
  </td>
  
</tr>


<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
  <td height="25"><strong><font color="#333333">新密码</font></strong></td>
  <td align="left"><s:password name="newpwd"  cssStyle="width:60%"></s:password></td>
</tr>
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
  <td height="25"><strong><font color="#333333">确认密码</font></strong></td>
  <td align="left"><s:password name="againpwd"  cssStyle="width:60%"></s:password></td>
</tr>

</table>

<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td height="29" align="center" valign="bottom">
      <input type='submit' class="coolbg np" onClick="" value='修改' style="width:80" />&nbsp;&nbsp;
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