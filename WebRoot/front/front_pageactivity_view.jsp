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
    <title>活动详细信息</title>
    

<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="format-detection" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--  libs css -- start -->
<link href="front/libs/am.css" rel="stylesheet" type="text/css" />
<link href="front/css/common.css" rel="stylesheet" type="text/css" />
<link href="front/css/theme.css" rel="stylesheet" type="text/css" />

<link rel="apple-touch-icon-precomposed" href="http://resource.reeli.cn/weike/resources/images/theme/10387/icon.png" />
<link rel="Shortcut Icon" type="image/x-icon" href="http://resource.reeli.cn/weike/resources/images/theme/10387/icon.png" />
<!--  libs css -- end -->
<script src="front/libs/jquery-2.1.0.min.js" type="text/javascript"></script>

     <!--  business css -- start -->
        <link href="front/css/page-campaign.css" rel="stylesheet" type="text/css" />
        <link href="front/css/page-campaign-skin.css" rel="stylesheet" type="text/css" />
        <link href="front/css/page-stores.css" rel="stylesheet" type="text/css" />
        <link href="front/css/page-stores-skin.css" rel="stylesheet" type="text/css" />
	    <link href="front/css/page-barber.css" rel="stylesheet" type="text/css" />
        <!--  business css -- end -->
</head>

<body>
<div class="am-app">
    <!--  campaign.detail -- start -->
    <div class="am-page page-campaignDetail" id="page_campaignDetail">
        <div class="am-header tlogo">
            <p><s:property value="pagearticle.name"/></p>
            <div class="am-backbutton am-clickable"></div>
            <div class="am-clickable home" onvclick="location.href = 'front/index4.jsp?frontpa=<s:property value="frontpa"/>&openid=<s:property value="openid"/>'"></div>
            <input type="hidden" id="tenantIdVal" name="tenantIdVal" value="10387">
        </div>
        <div class="am-body-wrap">
            <div class="am-body-inner">
                <div class="campaignDetail-slider">
                    <div class="box">
                        <div class="img">
                            <div class="am-carrousel imgBg" id="campaignDetail_carrousel">
                                <div class="am-carrousel-inner">
                                    
                                        <div class="item"><img src="<%=basePath %>/<s:property value="pagearticle.image"/>" alt="" /></div>
                                    
                                    
                                </div>
                            </div>
                            <div class="count" id="campaignDetail_count">
                                <p class="selected"></p>
                            </div>
                        </div>
                        <div class="tag"></div>
                        <!-- 
                        <div class="finish">
                            还剩<span id="campaign_remaindays">-40</span>天结束
                        </div>
                         -->
                        <div class="operation">
                        <!-- 
                            <p class="favor am-clickable">
                                <span>(13)</span>
                            </p>
                          -->
                            <p class="share am-clickable" style="border-right:none">分享</p>
                            <!--<p class="save am-clickable">保存</p>-->
                        </div>
                    </div>
                </div>
                
	                <div class="campaignDetail-content">
	                    <div class="title">
	                        <s:property value="pagearticle.name"/>
	                    </div>
	                     
		                    <div class="barberDetail-desc" style="border:none;padding:5px 0;margin:0">
		                    <div class="content_box">
		                       
								<s:property value="pagearticle.description" escape="false"/>
								<br>
								<s:property value="pagearticle.project"/>
		                    </div>
		                   <div class="more am-clickable page-descAreaSize">展开</div>
		                    </div>
	                </div>
                
                
            </div>
        </div>
    </div>
    <!--  campaign.detail -- end -->
</div>

<div class="am-photoViewer" id="photoViewer">
    <!--<div class="am-photoViewer-wrap">
        <div class="am-photoViewer-inner">

        </div>
    </div>-->
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
<div class="microMessengerShareTips" id="microMessengerShareTips"></div>


 
     <script>
		window._bd_share_config =
		{
			"common":
				{ "bdSnsKey": {}, "bdDesc": "<p><em><span style="color: rgb(255, 0, 0);"><span style="font-size:24px">活动详情，请到店内咨询<span style="font-family:arial black, avant garde"><img width="530" height="340" src="http://api.map.baidu.com/staticimage?center=116.404,39.915&zoom=10&width=530&height=340&markers=undefined,undefined"/></span></span><strong><span><span style="background-color: rgb(250, 192, 143);"><span style="font-family: &#39;arial black&#39;, &#39;avant garde&#39;;"><span style="font-size: 32px;"></span></span></span></span></strong></span></em><br/></p>", "bdText": "“双节有礼  钜惠迎新“ " + location.href , "bdMini": "2", "bdPic": "", "bdStyle": "0", "bdSize": "32","bdUrl":location.href,"bdPic":"" }, "share": {}, "image": { "viewList": ["qzone", "tsina", "tqq", "renren", "weixin"], "viewText": "分享到：", "viewSize": "32" }, "selectShare": { "bdContainerClass": null, "bdSelectMiniList": ["qzone", "tsina", "tqq", "renren", "weixin"] }
		};
     </script>
     
	 
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
	config.homeUrl = "/index4.jsp";
	
	var dataForWeixin={
		TLImg:"http://resource.reeli.cn/weike/resources/images/theme/10387/icon.png"
	};
</script>
<script src="front/libs/am.photoViewer.js" type="text/javascript"></script>
<script src="front/scripts/page.campaignsInfo.js" type="text/javascript"></script>
<script type="text/javascript">
	dataForWeixin.desc = '<p><em><span style="color: rgb(255, 0, 0);"><span style="font-size:24px">活动详情，请到店内咨询<span style="font-family:arial black, avant garde"><img width="530" height="340" src="http://api.map.baidu.com/staticimage?center=116.404,39.915&zoom=10&width=530&height=340&markers=undefined,undefined"/></span></span><strong><span><span style="background-color: rgb(250, 192, 143);"><span style="font-family: &#39;arial black&#39;, &#39;avant garde&#39;;"><span style="font-size: 32px;"></span></span></span></span></strong></span></em><br/></p>';
</script>