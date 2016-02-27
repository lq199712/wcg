<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>

<html lang="en" class="body-error">

	<head>

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<base href="<%=basePath%>admin/">
		<meta charset="utf-8">

		<meta name="keywords" content="宜兴市城管局">

		<meta name="description" content="宜兴市城管局">

		<title>宜兴市城管局-后台管理系统</title>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/yyucadapter.js"></script>

		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<meta name="description" content="">

		<meta name="author" content="">

		<link href="static/login.css" rel="stylesheet">

		<link rel="alternate stylesheet" type="text/css" media="screen"
			title="green-theme" href="static/green.css">

		<link rel="alternate stylesheet" type="text/css" media="screen"
			title="blue-theme" href="static/blue.css">

		<link rel="alternate stylesheet" type="text/css" media="screen"
			title="orange-theme" href="static/orange.css">

		<!--[if lt IE 9]>

<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>

<![endif]-->







		<style type="text/css">
html,body { /*此部分支持chrome，应该也支持firefox*/
	background: rgb(246, 248, 249);
	background: url('res/5180d22d1891b.jpg') no-repeat center fixed;
	background-attachment: fixed;
	background-size: 100% 100%;
}
</style>



	</head>



	<body screen_capture_injected="true">



		<div id="wrapper" style="margin-top: 130px;">

			<form action="adminAction!login" class="form-login" method="post">

				<div class="header">

					<a href="#" class="link-head-left" target="_blank"> <i
						class="icon-home"></i>
					</a>

					<span>登陆</span>

					<a href="javascript:void(0);" tabindex="1"
						class="link-head-right main-item"><i class="icon-config"></i>
					</a>

					<div class="config-box">

						<div class="colors">

							<a href="javascript:chooseStyle('blue-theme', 30)"><img
									src="static/blue.png" alt="">
							</a>

							<a href="javascript:chooseStyle('orange-theme', 30)"><img
									src="static/orange.png" alt="">
							</a>

							<a href="javascript:chooseStyle('green-theme', 30)"><img
									src="static/green.png" alt="">
							</a>

							<a href="javascript:chooseStyle('none', 30)"><img
									src="static/red.png" alt="">
							</a>

							<div class="clear">

							</div>

						</div>

						<div class="style-bg">

							<a href="login.html" class="active">黑色</a>



						</div>

					</div>

				</div>

				<!--
		<div class="avatar">

			<img src="static/avatar.png" alt="">

		</div>
		-->
				<div class="inputs">





					<input type="text" value="${loginFail }" name="username"
						id="username" tabindex="1" type="text"
						tipinput1" placeholder="用户名" autocomplete="off" />






					<input type="password" value="" name="password" id="password"
						tabindex="2" type="password" placeholder="请输入您的密码"
						autocomplete="off" />
					<div class="link-1">

						<label for="c2">
							<input id="hold" type="checkbox" checked="checked" value="1"
								name="remme" />
							<!--<span></span>-->
							记住我
						</label>

					</div>

					<div class="link-2">

						<a href="findpwd.html">忘记密码</a>

					</div>

					<div class="clear">

					</div>

					<div class="button-login">

						<input type="submit" id="btn-login" value="登 陆">

					</div>

				</div>

				<div class="footer-login" style="height: 10px;">

					<!--<ul class="social-links">

				<li class="twitter"><a href="#"><span>twitter</span></a></li>

				<li class="google-plus"><a href="#"><span>google</span></a></li>

				<li class="facebook"><a href="#"><span>facebook</span></a></li>

			</ul>-->

				</div>

			</form>

			<div class="clear">

			</div>

			<!--<div class="link-to-page">

		还没有账号? <a href="reg.html">立即注册!</a>

	</div>-->

		</div>

		<!-- Le javascript

    ================================================== -->

		<!-- Placed at the end of the document so the pages load faster -->

		<script src="static/jquery.min.js"></script>

		<script src="static/styleswitcher.js"></script>



	</body>

</html>