<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<title>调查说明</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>

<link type="text/css" rel="stylesheet" href="res/wdy/style/examine.css" />
</head>
<body>
<div class="wrapper">
	<img class="bg" src="res/wdy/images/bg.jpg">
	<div style="height: 25px;"></div>
	<div class="content-w1">
		<div class="content-w2">
			<div class="content">
				<div class="title">微调研活动进行中..</div>
				<img class="connect" src="res/wdy/images/connect.png">
				<div class="desc-cont">感谢您的选择！</div>
				<a class="next-btn" href="index.html" style="text-decoration:none;">谢谢参与</a>
			</div>
		</div>
	</div>
	
	<div class="footReturn">
			</div>
 	<p class="page-url">
		<a href="/" target="_blank" class="page-url-link"></a>
	</p>
</div>
</body>
</html>