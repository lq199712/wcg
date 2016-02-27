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
		<meta charset="utf-8">
		<title>提示</title>
		<meta name="viewport"
			content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="format-detection" content="telephone=no">
		<meta charset="utf-8">
		<link href="css/good.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="css/mmenu.css">
		<link rel="stylesheet" href="css/plugmenu.css">
		<script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
		<script src="js/jquery.mmenu.min.js" type="text/javascript"></script>
	</head>
	<script type="text/javascript">
$(function() {
    $('nav#menu').mmenu({
        slidingSubmenus: false
    });
});
</script>

	<body id="ginfo">
		<div id="mcover"
			onclick="document.getElementById('mcover').style.display='';">
			<img src="images/guide.png">
		</div>
		<div id="page">
			<div id="header">

				<a href="javascript:history.back()" class="right home"></a>
			</div>
			<div id="content">
				<div class="Listpage">
					<div class="top46"></div>
					<div class="page-bizinfo">

						<div class="text">
							<h1 id="activity-name">
								由于您长时间未操作,会话失效啦,请重新进入微官网哦!
							</h1>
							
						</div>

					</div>

				</div>
			</div>
		</div>

	</body>

</html>
