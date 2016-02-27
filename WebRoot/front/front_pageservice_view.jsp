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
    <title>服务详细信息</title>
    
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
    <link href="front/css/page-barber.css" rel="stylesheet" type="text/css" />
  
</head>

<body>
<div class="am-app">
   
    <!--  stores.detail -- start -->
    <div class="am-page page-storeDetail" id="storeDetail">
        <div class="am-header tlogo">
            <p>服务详细信息</p>
            <div class="am-clickable menu"></div>
            <div class="am-clickable home" onvclick="location.href='front/index4.jsp?frontpa=<s:property value="frontpa"/>&openid=<s:property value="openid"/>'"></div>
            <input type="hidden" id="tenantIdVal" name="tenantIdVal" value="10387">
        </div>
        <div class="am-body-wrap">
            <div class="am-body-inner">
            	
            	
				
                <div class="campaignDetail-slider">
                    <div class="box">
                        <div class="img">
                            <div class="am-carrousel imgBg" id="storeDetail_carrousel">
                                <div class="am-carrousel-inner">
                                    
                                        <div class="item"><img src="<%=basePath %>/<s:property value="pagearticle.image"/>" alt="" hr="<s:property value="pagearticle.image"/>"/></div>
                                    
                                        
                                    
                                </div>
                            </div>
                            <div class="count">
                                <!--<p class="selected"></p>
                                <p></p>
                                <p></p>-->
                            </div>
                        </div>
                        <div class="finish"></div>
                        <div class="operation">
                        	<!-- <p class="favor am-clickable"><span>(34)</span></p> -->
                            
                            <p class="share am-clickable">分享</p>
                        </div>
                    </div>
                </div>
                
                
                   <div class="barberDetail-desc" style="margin:10px 7px;background-color:#f9f9f9;">
                   <div class="content_box">
			                      <s:property value="pagearticle.description" escape="false"/>
											<br>
								<s:property value="pagearticle.project"/>
                   </div>
                   <div class="more am-clickable page-descAreaSize">展开</div>
             		</div>
              	
            </div>
        </div>
        
		
        <div class="am-tab-placeHolder"></div>
    </div>
    <!--  stores.detail -- end -->
</div>


<div class="nav-container" id="nav" style="display: none;">
	<div class="nav">
		<ul class="nav-ul">
			<li class="logo"></li>
			<s:action name="bigtypeAction!frontBigtypes">
								<s:param name="frontpa" value="#parameters.frontpa"></s:param>
							</s:action>
			<!--<li class="logo am-clickable"></li>  -->
			<li class="am-clickable home " href="front/index4.jsp?frontpa=<s:property value="frontpa"/>">
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

<div class="storeNavCover" id="storeNavCover"></div>

<div class="am-photoViewer" id="photoViewer">
    <div class="am-carrousel" id="photoViewer_carrousel">
        <ul class="am-carrousel-inner">
            <li></li>
            <li></li>
        </ul>
        <ul class="dots">
            <li class="selected"></li>
            <li></li>
            <li></li>
        </ul>
    </div>
    <ul class="am-photoViewer-ctrls">
        <li>
            <div class="close am-clickable"></div>
        </li>       
    </ul>
</div>

     <script>
	 window._bd_share_config =
		{
		"common":
			{ "bdSnsKey": {}, "bdDesc": "地址", "bdText": "宜兴金公子美发店 " + location.href, "bdMini": "2", "bdPic": "", "bdStyle": "0", "bdSize": "32","bdUrl":location.href,"bdPic":"" }, "share": {}, "image": { "viewList": ["qzone", "tsina", "tqq", "renren", "weixin"], "viewText": "分享到：", "viewSize": "32" }, "selectShare": { "bdContainerClass": null, "bdSelectMiniList": ["qzone", "tsina", "tqq", "renren", "weixin"] }
		};

     </script>
     <div class="microMessengerShareTips" id="microMessengerShareTips"></div>
	 
<!-- share -->
<div class="bdsharebuttonbox-mask am-clickable"
	id="app_share_mask">
</div>
<div class="bdsharebuttonbox" id="app_share">
	<ul class="bdsbox">
		<li>
			<div>
				<a href="#" class="bds_qzone" data-cmd="qzone"></a>
				<p>QQ空间</p>
			</div>
		</li>
		<li>
			<div>
				<a href="#" class="bds_tsina" data-cmd="tsina"></a>
				<p>新浪微博</p>
			</div>
		</li>
		<li>
			<div>
				<a href="#" class="bds_tqq" data-cmd="tqq"></a>
				<p>腾讯微博</p>
			</div>
		</li>
		<li>
			<div>
				<a href="#" class="bds_renren" data-cmd="renren"></a>
				<p>人人网</p>
			</div>
		</li>
		<li>
			<div>
				<a href="#" class="bds_kaixin001" data-cmd="kaixin001"></a>
				<p>开心网</p>
			</div>
		</li>

		<!--
            <li><div><a href="#" class="bds_weixin" data-cmd="weixin"></a></div></li>
            <li><div><a href="#" class="bds_tqf" data-cmd="tqf"></a></div></li>
            <li><div><a href="#" class="bds_tieba" data-cmd="tieba"></a></div></li>
            <li><div><a href="#" class="bds_douban" data-cmd="douban"></a></div></li>
            <li><div><a href="#" class="bds_tsohu" data-cmd="tsohu"></a></div></li>
       
            <li><div><a href="#" class="bds_bdhome" data-cmd="bdhome"></a></div></li>
            <li><div><a href="#" class="bds_sqq" data-cmd="sqq"></a></div></li>
            <li><div><a href="#" class="bds_thx" data-cmd="thx"></a></div></li>
            <li><div><a href="#" class="bds_qq" data-cmd="qq"></a></div></li>
            <li><div><a href="#" class="bds_taobao" data-cmd="taobao"></a></div></li>

            <li><div><a href="#" class="bds_hi" data-cmd="hi"></a></div></li>
            <li><div><a href="#" class="bds_bdysc" data-cmd="bdysc"></a></div></li>
            <li><div><a href="#" class="bds_sohu" data-cmd="sohu"></a></div></li>
            <li><div><a href="#" class="bds_t163" data-cmd="t163"></a></div></li>
            <li><div><a href="#" class="bds_qy" data-cmd="qy"></a></div></li>

            <li><div><a href="#" class="bds_meilishuo" data-cmd="meilishuo"></a></div></li>
            <li><div><a href="#" class="bds_mogujie" data-cmd="mogujie"></a></div></li>
            <li><div><a href="#" class="bds_diandian" data-cmd="diandian"></a></div></li>
            <li><div><a href="#" class="bds_huaban" data-cmd="huaban"></a></div></li>
            <li><div><a href="#" class="bds_leho" data-cmd="leho"></a></div></li>
			-->
	</ul>
</div>
<!-- share end -->
<script>
	with (document) 0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];
</script>
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
	config.homeUrl = "front/index4.jsp?frontpa=<s:property value="frontpa"/>";
	
	var dataForWeixin={
		TLImg:"images/other/icon.png"
	};
</script>
<script src="front/libs/am.photoViewer.js" type="text/javascript"></script>
<script src="front/scripts/page.storeInfo.js" type="text/javascript"></script>
<script src="front/libs/jquery.easing.1.3.js" type="text/javascript"></script>
<script src="front/libs/am.Scrollview.js" type="text/javascript"></script>
<script src="front/scripts/storeNav.js" type="text/javascript"></script>
