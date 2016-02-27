<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<title>VIP会员卡</title>

		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
		<meta name="format-detection" />
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!--  libs css -- start -->
		<link href="libs/am.css" rel="stylesheet" type="text/css" />
		<link href="css/common.css" rel="stylesheet" type="text/css" />
		<link href="css/theme.css" rel="stylesheet" type="text/css" />
		<!-- link href="/themes/wakeup_module6/theme.css" rel="stylesheet" type="text/css" />-->
		<link rel="apple-touch-icon-precomposed" href="images/other/icon.png" />
		<link rel="Shortcut Icon" type="image/x-icon"
			href="images/other/icon.png" />
		<!--  libs css -- end -->
		<script src="libs/jquery-2.1.0.min.js" type="text/javascript"></script>


		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
		<meta name="format-detection" content="telephone=no" />
		<meta name="apple-mobile-web-app-capable" content="yes" />

		<!--  business css -- start -->
		<link href="css/page-member-info.css" rel="stylesheet" type="text/css" />
		<!--  business css -- end -->
		<script src="scripts/config.js" type="text/javascript"></script>
		<script src="scripts/init.js" type="text/javascript"></script>
		<script src="scripts/page.member-info.js" type="text/javascript"></script>
		<style>
.imgtest {
	margin: 0;
	padding: 0;
	overflow: hidden;
	display: inline;
}

.imgtest figure div {
	display: inline-block;
	margin: 0 auto;
	width: 66px;
	height: 66px;
	border-radius: 66px;
	border: 2px solid #fff;
	overflow: hidden;
	-webkit-box-shadow: 0 0 3px #ccc;
	box-shadow: 0 0 3px #ccc;
	border: 2px solid #fff;
}

.imgtest img {
	width: 100%;
	min-height: 100%;
	text-align: center;
}

.nickname {
	
}
</style>
	</head>

	<body>
		<div class="am-app">
			<div class="am-page page-member-info" id="page_login">
				<div class="am-header">
					<p>
						VIP会员卡中心
					</p>
					<div class="am-clickable menu"></div>
					<div class="am-clickable home"
						onvclick="location.href='index4.jsp?frontpa=<s:property value="frontpa"/>&openid=<s:property value="openid"/>'"></div>
				</div>
				<div class="am-body-wrap">
					<div class="am-body-inner">
						<ul class="steps">
							<li>
								小伙伴们
							</li>
							<li>
								二维码活动
							</li>
							<li>
								积分兑换记录
							</li>
							<li style="display: none">
								我的优惠券
							</li>
							<li>
								基本资料
							</li>
						</ul>
					</div>



					<div class="blocks">
						<div class="blockItem cards" style="display: none;">



							<s:if test='pwxuser == null && nwxusers == null '>
								<div class="tipMessage">
									您没有小伙伴
								</div>
							</s:if>
							<s:else>
								<s:if test='pwxuser == null'>
									<div class="tipMessage">
										您没有扫过小伙伴
									</div>
								</s:if>
								<s:else>
									<div class="tipMessage">
										您扫过的小伙伴
									</div>
									<div class="header male">
										<div class="imgtest">
											<figure>
											<div>
												<img src="<s:property value="pwxuser.headimgurl" />"
													onerror="imageOnError('images/head_male.png',this);" />
											</div>
											</figure>
										</div>
										<span style="margin-left: 55px; padding: 1px;"> <s:property
												value="pwxuser.nickname" /> </span>
									</div>
								</s:else>

								<s:if test=' nwxusers == null '>
									<div class="tipMessage">
										没有扫过您的小伙伴
									</div>
								</s:if>
								<s:else>
									<div class="tipMessage">
										扫过您的小伙伴
									</div>
									<s:iterator id="nwxuser" value="nwxusers">
										<div class="imgtest">
											<figure>
											<div>
												<img src="<s:property value="#nwxuser.headimgurl" />"
													onerror="imageOnError('images/head_male.png',this);" />
											</div>

											</figure>
										</div>
										<span style="margin-left: 55px; padding: 1px;"> <s:property
												value="#nwxuser.nickname" /> </span>
									</s:iterator>
								</s:else>
							</s:else>
						</div>




						<div class="blockItem package" style="display: none;">
							<div>
								<img src="<s:property value="qrcodeUrl" />" width="258px"
									height="258px" style="padding-left: 25px">

							</div>
							<h2 style="margin: 25px 10px; margin-left: 22px">
								活动说明：扫一扫
							</h2>
							<p style="margin: 5px 10px; margin-left: 22px">
								<s:action name="pagearticleAction!frontcenterview">
					        		<s:param name="id" value="23"></s:param>
					        	</s:action>
					        	<s:property value="#request.pagearticle.description" escape="false"/>
							</p>
						</div>

						<div class="blockItem record" style="display: none;">
							<div class="tipMessage">
								<s:if test='member.recordnote == null||member.recordnote == "" '>
								暂无消费记录
								</s:if>
								<s:else>
									<s:property value="member.recordnote" />
								</s:else>

							</div>
						</div>


						<div class="blockItem me" style="display: block">
							<div class="header male">
								<img src="<s:property value="wxuser.headimgurl" />"
									onerror="imageOnError('images/head_male.png',this);" />
							</div>
							<div class="name">
								<s:property value="wxuser.nickname" />
							</div>
							<ul class="fileds">
								<li>
									<span class="icon icon5"></span>
									<span class="left">我的积分</span>
									<span class="right"><s:property value="member.credit" />
									</span>
								</li>
								<li>
									<span class="icon icon6"></span>
									<span class="left">注册日期</span>
									<span class="right"><s:date name="member.createdate"
											format="yyyy-MM-dd" /> </span>
								</li>
								<s:action name="bigtypeAction!frontBigtypes">
										<s:param name="frontpa" value="#parameters.frontpa"></s:param>
								</s:action>
								<li class="reservation" onclick="window.location.href = 'tel:<s:property value="#request.bigtypes[8].linkurl"/>';">
									<span class="icon icon8"></span>
									<span class="left">马上预约</span>
									<span class="right"> ></span>
								</li>
							</ul>
						</div>

					</div>
				</div>
			</div>
		</div>
	</body>

	<div class="nav-container" id="nav" style="display: none;">
		<div class="nav">
			<ul class="nav-ul">
				<li class="logo"></li>
				
				<!--<li class="logo am-clickable"></li>  -->
				<li class="am-clickable home "
					href="index4.jsp?frontpa=<s:property value="frontpa"/>&openid=<s:property value="openid"/>">
					<div class="icon"></div>
					返回首页
				</li>
				<li class="am-clickable campaign "
					href="pagearticleAction!frontpagearticle?stid=1&producttype=1&frontpa=<s:property value="#parameters.frontpa"/>">
					<div class="icon"></div>
					最新活动
				</li>
				<li class="am-clickable service "
					href="pagearticleAction!frontpagearticle?stid=2&producttype=2&frontpa=<s:property value="#parameters.frontpa"/>">
					<div class="icon"></div>
					服务指南
				</li>
				<li class="am-clickable card "  href='<s:property value="#request.bigtypes[2].linkurl"/>'>
					<div class="icon"></div>
					消费记录查询
				</li>
				<!-- set class active to make it as the CURRENT module -->
				<li class="am-clickable barber active"
					href="pagearticleAction!frontpagearticle?stid=3&producttype=3&frontpa=<s:property value="#parameters.frontpa"/>">
					<div class="icon"></div>
					设计师团队
				</li>
				<li class="am-clickable user " href="tel:<s:property value="#request.bigtypes[8].linkurl"/>">
					<div class="icon"></div>
					在线预约
				</li>
				<li class="am-clickable complain " href="tel:<s:property value="#request.bigtypes[8].linkurl"/>">
					<div class="icon"></div>
					我要投诉
				</li>

			</ul>
			<div class="nav-bg am-clickable"></div>
		</div>
	</div>
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
