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
<title>账号注册</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="format-detection" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--  libs css -- start -->
<link href="libs/am.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/theme.css" rel="stylesheet" type="text/css" />
<!-- link href="/themes/wakeup_module6/theme.css" rel="stylesheet" type="text/css" />-->
<link rel="apple-touch-icon-precomposed" href="images/other/icon.png" />
<link rel="Shortcut Icon" type="image/x-icon" href="images/other/icon.png" />
<!--  libs css -- end -->
<script src="libs/jquery-2.1.0.min.js" type="text/javascript"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="format-detection" content="telephone=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />

<!--  business css -- start -->
<link href="css/page-barber.css" rel="stylesheet"
	type="text/css" />
<link href="css/page-member-register.css"
	rel="stylesheet" type="text/css" />
<!--  business css -- end -->
<script src="scripts/config.js" type="text/javascript"></script>
<script src="scripts/init.js" type="text/javascript"></script>
<script src="scripts/page.member-register.js"
	type="text/javascript"></script>
</head>

<body>
	<div class="am-app">
		<div class="am-page page-member-login" id="page_login">
			<div class="am-header">
				<p>账号注册</p>
				
				<div class="am-backbutton am-clickable" onvclick="history.go(-1)"></div>
				<div class="am-clickable home" onclick="location.href='front/index4.jsp?frontpa=<s:property value="frontpa"/>&openid=<s:property value="openid"/>'"></div>
				
			</div>
			<div class="am-body-wrap">
				<div class="am-body-inner">

					<form class="member-login-form" method="post"
						action="memberAction!frontmemberadd"
						id="member-login-form" >
						<div class="cpnt-input icon1">
							<s:textfield maxlength="20" type="text"  name="tel"
								id="phone" placeholder="手机号" ></s:textfield>
							<span class="clear"></span>
						</div>
						<div class="cpnt-input icon1">
							<s:textfield maxlength="20" type="text"  name="truename"
								id="name" placeholder="姓名" ></s:textfield>
								<span class="clear"></span>
						</div>
						<div class="cpnt-input code">
						<s:textfield maxlength="15" type="text"  name="pwd1"
								id="smscode" placeholder="输入密码"></s:textfield>
						</div>
						<div class="page-button red" id="register">
							<input class="page-button red" type="submit" value="注册并登陆"/>
						</div>
					</form>
				</div>
			</div>
		</div>


	</div>
</body>
<script src="libs/jquery-2.1.0.min.js" type="text/javascript"></script>
<script src="libs/am.js" type="text/javascript"></script>
<script src="libs/am.events.js" type="text/javascript"></script>
<script src="libs/am.Carrousel.js" type="text/javascript"></script>
<script src="libs/am.Tab.js" type="text/javascript"></script>
<script src="libs/am.debug.js" type="text/javascript"></script>
<script src="libs/dateFormat.js" type="text/javascript"></script>
<script src="scripts/config.js" type="text/javascript"></script>
<script src="scripts/init.js" type="text/javascript"></script>
<script src="scripts/nav.js" type="text/javascript"></script>
<script src="scripts/common.js" type="text/javascript"></script>
<script type="text/javascript">
	window.amGloble.RATINGURLS = {
		coupon: "/coupon/like",
		store: "/store/like",
		campaign: "/campaign/like",
		barber:"/barber/like",
		product:"/product/like"
	};
	config.homeUrl = "index4.jsp";
	
	var dataForWeixin={
		TLImg:"images/other/icon.png"
	};
</script>
</html>
