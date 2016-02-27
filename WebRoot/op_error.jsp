<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>39MI-宜兴微定制</title>
<base target="_self">
<link rel="stylesheet" type="text/css" href="skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="skin/css/main.css" />

</head>
<body leftmargin="8" topmargin='8'>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><div style='float:left'> <img height="14" src="skin/images/frame/book1.gif" width="20" />&nbsp;微城管后台管理系统 </div>
      <div style='float:right;padding-right:8px;'>
        <!--  //保留接口  -->
      </div></td>
  </tr>
  <tr>
    <td height="1" background="skin/images/frame/sp_bg.gif" style='padding:0px'></td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px;margin-top:8px;">
  <tr>
    <td background="skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'><span>消息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td>${errorInfo }&nbsp;&nbsp;<a href="welcom.jsp" target="mainFrame">回到主页</a></td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr bgcolor="#EEF4EA">
    <td colspan="2" background="skin/images/frame/wbg.gif" class='title'><span>系统基本信息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="25%" bgcolor="#FFFFFF">感谢您的使用：</td>
    <td width="75%" bgcolor="#FFFFFF">
		管理员
	</td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td>系统版本信息：</td>
    <td>wcg_v1.0</td>
  </tr>
</table>
</body>
</html>