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
        <title>刘昕林</title>
        
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
        <link href="front/css/page-barber.css" rel="stylesheet" type="text/css" />
        <!--  business css -- end -->
       
    </head>

    <body>
        <div class="am-app">
            <div class="am-page page-barberDetail" id="barberDetail">
                <div class="am-header tlogo">
                    <p><s:property value="pagearticle.name"/></p>
                    <div class="am-clickable am-backbutton"></div>
                    <div class="am-clickable home" onvclick="location.href = 'front/index4.jsp?frontpa=<s:property value="frontpa"/>&openid=<s:property value="openid"/>'"></div>
                    <input type="hidden" id="tenantIdVal" name="tenantIdVal" value="10387">
                </div>
                <div class="am-body-wrap">
                    <div class="am-body-inner">
                    
                        <div class="barberDetail-barber">
                            <div class="left">
                               
                                      <div class="img" id="barber_thumb">
                                      	
		                                    <img src="<%=basePath %>/<s:property value="pagearticle.image"/>"/>
		                                
		                                </div>
                                <div class="social">
                                    <p class="share am-clickable">分享</p>
                                    <!-- <p class="favor am-clickable"><span>(16)</span></p> -->
                                    
                                </div>
                            </div>
                            <div class="info">
                                <div class="name" id="barber_name"><s:property value="pagearticle.name"/></div>
                                <div class="level" id="barber_level"><s:property value="pagearticle.shortname"/></div>
                                <div class="desc"></div>                				
                                <div class="page-button red"  onvclick="location.href='tel:<s:property value="pagearticle.pphone"/>'"><span class="barberDetail-icon"></span>预约我</div>
                            </div>
                        </div>
                        <div class="barberDetail-desc">
                            <p class="title">个人简介</p>
                            <div class="content_box">
                                
                                   
                                   
                                <s:property value="pagearticle.description" escape="false"/>
								<br>
								<s:property value="pagearticle.project"/>
                                   
                                
                            </div>
                           <div class="more am-clickable page-descAreaSize">展开</div>
                        </div>
                        <!--  
                            <div class="barberDetail-pics">
                                <p class="title">我的作品</p>
                                <div class="arrow_left"></div>
                                <div class="arrow_right"></div>
                                <div class="content am-carrousel" id="barberDetail_pics">
                                    <ul class="am-carrousel-inner">
										
                                            <li class="am-clickable">
                                                <div class="img">
                                                    <img src="images/other/8d09efff-33f1-4cfe-ae03-33b74d44e74a_450x563_s.png" alt="" hr="images/other/8d09efff-33f1-4cfe-ae03-33b74d44e74a_450x563.png"/>
                                                </div>
                                            </li>
                                        
                                            <li class="am-clickable">
                                                <div class="img">
                                                    <img src="images/other/93458ea3-81db-43cb-a81b-497a7760617e_640x905_s.png" alt="" hr="images/other/93458ea3-81db-43cb-a81b-497a7760617e_640x905.png"/>
                                                </div>
                                            </li>
                                        
                                            <li class="am-clickable">
                                                <div class="img">
                                                    <img src="images/other/a0699420-5c8c-4aed-91ec-e5573fb73065_486x684_s.png" alt="" hr="images/other/a0699420-5c8c-4aed-91ec-e5573fb73065_486x684.png"/>
                                                </div>
                                            </li>
                                        
                                            <li class="am-clickable">
                                                <div class="img">
                                                    <img src="images/other/9e4193c1-dc94-48ec-add9-36de3784886b_636x912_s.png" alt="" hr="images/other/9e4193c1-dc94-48ec-add9-36de3784886b_636x912.png"/>
                                                </div>
                                            </li>
                                        
                                            <li class="am-clickable">
                                                <div class="img">
                                                    <img src="images/other/fd9a0e0f-2a82-40f7-b3cb-a9219eb2d0cd_446x570_s.png" alt="" hr="images/other/fd9a0e0f-2a82-40f7-b3cb-a9219eb2d0cd_446x570.png"/>
                                                </div>
                                            </li>
                                        
                                    </ul>
                                </div>
                            </div>
                        -->
                    </div>
                </div>
            </div>
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
<script src="front/scripts/page.barberDetail.js" type="text/javascript"></script>
<script>
window._bd_share_config =
{
	 "common":
		{ "bdSnsKey": {}, "bdDesc": "刘昕林", "bdText": "刘昕林  " + location.href, "bdMini": "2", "bdPic": "", "bdStyle": "0", "bdSize": "32","bdUrl":location.href,"bdPic":"" }, "share": {}, "image": { "viewList": ["qzone", "tsina", "tqq", "renren", "weixin"], "viewText": "分享到：", "viewSize": "32" }, "selectShare": { "bdContainerClass": null, "bdSelectMiniList": ["qzone", "tsina", "tqq", "renren", "weixin"] }
};

dataForWeixin.desc = '';
</script>
	 
