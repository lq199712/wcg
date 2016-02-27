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
        <title>最新活动</title>
        
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="format-detection" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--  libs css -- start -->
<link href="front/libs/am.css" rel="stylesheet" type="text/css" />
<link href="front/css/common.css" rel="stylesheet" type="text/css" />
<link href="front/css/theme.css" rel="stylesheet" type="text/css" />
<!-- link href="/themes/wakeup_module6/theme.css" rel="stylesheet" type="text/css" />-->
<link rel="apple-touch-icon-precomposed" href="front/images/other/icon.png" />
<link rel="Shortcut Icon" type="image/x-icon" href="front/images/other/icon.png" />
<!--  libs css -- end -->
<script src="front/libs/jquery-2.1.0.min.js" type="text/javascript"></script>

        <!--  business css -- start -->
        <link href="front/css/page-campaign.css" rel="stylesheet" type="text/css" />
        <link href="front/css/page-campaign-skin.css" rel="stylesheet" type="text/css" />
        <link href="front/css/page-stores.css" rel="stylesheet" type="text/css" />
        <link href="front/css/page-stores-skin.css" rel="stylesheet" type="text/css" />
        <!--  business css -- end -->
    </head>

    <body>
        <div class="am-app">
            <!--  stores.storeCampaign -- start -->
            <div class="am-page page-storeCampaign" id="storeCampaign">
                <div class="am-header tlogo">
                    <p>金公子美发最新活动</p>
                    <div class="am-clickable menu"></div>
                    <div class="am-clickable home" onvclick="location.href = 'front/index4.jsp?frontpa=<s:property value="frontpa"/>&openid=<s:property value="openid"/>'"></div>
                    <input type="hidden" id="tenantIdVal" name="tenantIdVal" value="10387">
                </div>
                <div class="am-body-wrap">
                    <div class="am-body-inner">
                        <ul class="campaign-list">
	                        
	                    		<!--
								<li class="empty">现在没有活动信息!</li>
								-->
								<s:if test="%{pagearticles.size()==0}">
									<li class="empty">现在没有活动信息!</li>
								</s:if>
								<s:iterator value="pagearticles" var="pagearticle">
	                                <li class="am-clickable operation" >							
	                                    <div class="img" onvclick="location.href = 'pagearticleAction!frontview1?id=<s:property value="id"/>&frontpa=<s:property value="frontpa"/>'">
	                                        
	                                        	<img src="<s:property value="image"/>" />
	                                        
	                                    </div>
	                                    <div class="title" onvclick="location.href = 'pagearticleAction!frontview1?id=<s:property value="id"/>&frontpa=<s:property value="frontpa"/>'"><s:property value="name"/></div>
	                                    <!-- 
	                                    <div class="time" onvclick="location.href = 'pagearticleAction!frontview1?id=<s:property value="id"/>&frontpa=<s:property value="frontpa"/>'">2015-01-10 至 2015-02-11</div>
	                                    <div class="favour am-clickable" data-id="170"><span>(8)</span> </div>
	                                     -->
	                                </li>
                            	</s:iterator>
                            
		                    
	                        
                        </ul>
                        <div class="load-more am-clickable">更多</div>
                        <div class="loading-bar">
                            <div class="box">
                                <p class="icon"></p>
                                <p class="text">正在加载..</p>
                            </div>
                        </div>
                        <div class="empty-msg"></div>
                    </div>
                </div>
            </div>
            <!--  stores.storeCampaign -- end -->
        </div>

	
<div class="nav-container" id="nav" style="display: none;">
	<div class="nav">
		<ul class="nav-ul">
			<li class="logo"></li>
			<s:action name="bigtypeAction!frontBigtypes">
								<s:param name="frontpa" value="#parameters.frontpa"></s:param>
							</s:action>
			<!--<li class="logo am-clickable"></li>  -->
			<li class="am-clickable home " href="front/index4.jsp?frontpa=<s:property value="#parameters.frontpa"/>&openid=<s:property value="#parameters.openid"/>">
				<div class="icon"></div>
				返回首页
			</li>
			<li class="am-clickable campaign "  href="pagearticleAction!frontpagearticle?stid=1&producttype=1&frontpa=<s:property value="#parameters.frontpa"/>">
				<div class="icon"></div>
				最新活动
			</li>
			<li class="am-clickable service "  href="pagearticleAction!frontpagearticle?stid=2&producttype=2&frontpa=<s:property value="#parameters.frontpa"/>">
				<div class="icon"></div>
				服务指南
			</li>
			<li class="am-clickable card "  href='<s:property value="#request.bigtypes[2].linkurl"/>'>
				<div class="icon"></div>
				消费记录查询
			</li>
			<!-- set class active to make it as the CURRENT module -->
			<li class="am-clickable barber active"  href="pagearticleAction!frontpagearticle?stid=3&producttype=3&frontpa=<s:property value="#parameters.frontpa"/>">
				<div class="icon"></div>
				设计师团队
			</li>
			<li class="am-clickable user "  href="tel:<s:property value="#request.bigtypes[8].linkurl"/>">
				<div class="icon"></div>
				在线预约</li>
			<li class="am-clickable complain "  href="tel:<s:property value="#request.bigtypes[8].linkurl"/>">
				<div class="icon"></div>
				我要投诉</li>
			
		</ul>
		<div class="nav-bg am-clickable"></div>
	</div>
</div>
</body>
</html>
<script src="front/libs/jquery-2.1.0.min.js" type="text/javascript"></script>
<script src="front/libs/am.js" type="text/javascript"></script>
<script src="front/libs/am.events.js" type="text/javascript"></script>
<script src="front/libs/am.Carrousel.js" type="text/javascript"></script>
<script src="front/libs/am.Tab.js" type="text/javascript"></script>
<script src="front/libs/am.debug.js" type="text/javascript"></script>
<script src="front/libs/dateFormat.js" type="text/javascript"></script>
<script src="front/scripts/config.js" type="text/javascript"></script>
<script src="front/scripts/init.js" type="text/javascript"></script>
<script src="front/scripts/nav.js" type="text/javascript"></script>
<script src="front/scripts/common.js" type="text/javascript"></script>
<script type="text/javascript">
	window.amGloble.RATINGURLS = {
		coupon: "/coupon/like",
		store: "/store/like",
		campaign: "/campaign/like",
		barber:"/barber/like",
		product:"/product/like"
	};
	config.homeUrl = "index4.jsp?frontpa=<s:property value="frontpa"/>";
	
	var dataForWeixin={
		TLImg:"images/other/icon.png"
	};
</script>
<script src="front/scripts/page.campaigns.js" type="text/javascript"></script>
