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

<title>微投票活动</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>

<link type="text/css" rel="stylesheet" href="res/wtp/style/vote.css" />
<script type="text/javascript" src="res/choujiang/js/WeixinApi.js"></script>

</head>

<body style="background:#ab7cb3">

<script type="text/javascript">
        var mysharelink = 'http://www.weixinrs.com/wx/wtp0-11585.html?&wid=11001';	
		// 所有功能必须包含在 WeixinApi.ready 中进行
        WeixinApi.ready(function (Api) {

            // 微信分享的数据
            var wxData = {
                "appId": "", // 服务号可以填写appId
                //"imgUrl": 'http://www.weixinrs.com/res/share/wtp.jpg',
				"imgUrl": "http://www.weixinrs.com/upload/auto/2014/06/04/60b2086e3a9b702c49761e1ba40b22be.jpg",
                "img_width": "271",
                "img_height": "271",
                "link": mysharelink,
                //"desc": '快来为你心中的那一份感觉投上一票吧！',
				"desc": "您觉得我们的公众平台最需要修改的板块是？",
                //"title": '微信投票，让 TA 更具竞争力！'
				"title": "微投票活动开始啦？【所有设置为演示版，请修改】"
            };

            // 分享的回调
            var wxCallbacks = {
                // 分享操作开始之前
                ready: function () {
                    // 你可以在这里对分享的数据进行重组
                    wxData.link = mysharelink;
                },
                // 分享被用户自动取消
                cancel: function (resp) {
                   // 你可以在你的页面上给用户一个小Tip，为什么要取消呢？
                },
                // 分享失败了
                fail: function (resp) {
                    // 分享失败了，是不是可以告诉用户：不要紧，可能是网络问题，一会儿再试试？
                },
                // 分享成功
                confirm: function (resp) {
                    // 分享成功了，我们是不是可以做一些分享统计呢？
                    $.ajax({
                        /*url: "http://weisft.com/youxi/lujinxgsg/myshare/todo.aspx?do=addsharetimes&id=" + myguid,*/
                        type: "POST",
                        dataType: "text",
                        data: null,
                        success: function (data) {
                        }
                    });
                },
                // 整个分享过程结束
                all: function (resp) {
                     // 如果你做的是一个鼓励用户进行分享的产品，在这里是不是可以给用户一些反馈了？
                }
            };

            // 用户点开右上角popup菜单后，点击分享给好友，会执行下面这个代码
            Api.shareToFriend(wxData, wxCallbacks);

            // 点击分享到朋友圈，会执行下面这个代码
            Api.shareToTimeline(wxData, wxCallbacks);
						
			// iOS上，可以直接调用这个API进行分享，一句话搞定
			Api.generalShare(wxData,wxCallbacks);

            // 点击分享到腾讯微博，会执行下面这个代码
            Api.shareToWeibo(wxData, wxCallbacks);
        });
    </script>

<div class="wrapper" style="margin-top:-8px;">

	

	<div class="top fn-clear">

		<div class="count-cont">

			<h3>参与人数</h3>

			<div class="count"><s:property value="wvote.number"/></div>

		</div>

		<div class="title-cont">

			<p class="title"><s:property value="wvote.name"/></p>

			<p class="timeout"><img class="clock" src="res/wtp/images/clock.png"><span class="text">距离投票结束还有<s:property value="wvoteVO.diffdays"/>天 </span></p>

		</div>

	</div>

	<div class="cover">

		<img class="line" src="res/wtp/images/ctline.jpg">

		<img class="cimg" src="ups/demopic.jpg">

		<img class="line" src="res/wtp/images/cbline.jpg">

	</div>

	<div class="summary"><s:property value="wvote.content"/></div>


	<div class="option-cont">

	

	
	   <s:iterator value="woptionfrontVOs" var="woptionVO" status="status">
		<div class="option fn-clear option-statis" data-value="0">

			<div>${name}</div>

			<div class="progress"><div data-per="56.52" class="bar bar0" style="width:${pecent}%;"></div></div><span class="per" style="left: 102.78px;">${number}(${pecent}%)</span>	

		</div>

		<img class="sep" src="res/wtp/images/option_sep.jpg">
		</s:iterator>
	
	
			<!--  
		<div class="option fn-clear option-statis" data-value="0">

			<div>大转盘</div>

			<div class="progress"><div data-per="56.52" class="bar bar0" style="width:10%;"></div></div><span class="per" style="left: 102.78px;">0(0%)</span>	

		</div>

		<img class="sep" src="res/wtp/images/option_sep.jpg">

	
	
			
		<div class="option fn-clear option-statis" data-value="0">

			<div>微官网</div>

			<div class="progress"><div data-per="56.52" class="bar bar0" style="width:0%;"></div></div><span class="per" style="left: 102.78px;">0(0%)</span>	

		</div>

		<img class="sep" src="res/wtp/images/option_sep.jpg">

	
	

	
			
		<div class="option fn-clear option-statis" data-value="0">

			<div>微团购</div>

			<div class="progress"><div data-per="56.52" class="bar bar0" style="width:0%;"></div></div><span class="per" style="left: 102.78px;">0(0%)</span>	

		</div>
-->
		<img class="sep" src="res/wtp/images/option_sep.jpg">

	
	












		<a class="next-btn" href="index.html" style="text-decoration:none;">谢谢参与</a>




	</div>

 	<p class="page-url">

		<a href="/" target="_blank" class="page-url-link"></a>

	</p>

</div>

<div class="mfooter" id="wxgjfooter" style="text-align: center;width: 100%;height: 20px;line-height: 20px;margin-top:10px;">
<span class="sp2"><a href="http://weixinrs.com" style="color: #5e5e5e;font-size: 12px;"><!--@39MI提供技术支持--></a></span>
</div>
<div style="width: 0px;height: 0px;overflow: hidden;">

</div>
<script>
/**
$(function(){
	if($('body').height()<$(window).height()){
		$('body').height($(window).height());
		$('#wxgjfooter').css('position','fixed').css('bottom','0px');
	}
});
**/
</script>

</body>

</html>