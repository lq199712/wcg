<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>39MI-微信公众平台后台管理</title>
<style>
body
{
  scrollbar-base-color:#C0D586;
  scrollbar-arrow-color:#FFFFFF;
  scrollbar-shadow-color:DEEFC6;
}
</style>
</head>
<frameset rows="140,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="top.jsp" name="topFrame" scrolling="no">
  <frameset cols="267,*" name="btFrame" frameborder="NO" border="0" framespacing="0">
    <frame src="menu.jsp" noresize name="menu" scrolling="yes">
    <frame src="main.jsp" noresize name="main" scrolling="yes">
  </frameset>
</frameset>
<noframes>
  <body></body>
</noframes>
</html>
