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
    <title>在线投诉</title>
    <script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/yyucadapter.js"></script>
    <meta charset="utf-8" />
        <link rel="stylesheet" type="text/css" href="css/mwm/hotel/hotels.css" media="all" />
        <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
		<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
        <meta name="Keywords" content="" />
        <meta name="Description" content="" />
        <!-- Mobile Devices Support @begin -->
            <meta content="application/xhtml+xml;charset=UTF-8" http-equiv="Content-Type">
            <meta content="no-cache,must-revalidate" http-equiv="Cache-Control">
            <meta content="no-cache" http-equiv="pragma">
            <meta content="0" http-equiv="expires">
            <meta content="telephone=no, address=no" name="format-detection">
            <meta name="apple-mobile-web-app-capable" content="yes" /> <!-- apple devices fullscreen -->
            <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
        <!-- Mobile Devices Support @end -->
        <script type="text/javascript" src="js/mwm/swipe.js"></script>
        <style>
            img{ width:100%!important;}
        </style>
		<script type="text/javascript" src="res/choujiang/js/weixin-api.js"></script>
    </head>
        <body id="hotels" ondragstart="return false;" onselectstart="return false;" >
		
<script type="text/javascript">
        var mysharelink = window.location.href;	
		// 所有功能必须包含在 WeixinApi.ready 中进行
        WeixinApi.ready(function (Api) {

            // 微信分享的数据
            var wxData = {
                "appId": "", // 服务号可以填写appId
                "imgUrl": 'http://www.weixinrs.com/res/share/wyy.jpg',
                "img_width": "265",
                "img_height": "265",
                "link": mysharelink,
                "desc": '欢迎大家在线预约，超便利，省去一大推繁琐流程，只要你有微信就统统搞定！',
                "title": '微信预约，让你先人一步！'
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

            // 点击分享到腾讯微博，会执行下面这个代码
            Api.shareToWeibo(wxData, wxCallbacks);
        });



    </script>

<section class="body">
	<div class="banner">
	<div id="imgs_box" class="box_swipe">
		<img alt="" src="res/yy_pic.jpg" style="width: 100%;">	
	</div>
	</div>
	<div class="cardexplain">


			<!--后台可控制是否显示-->
			<ul class="round">
				<li>
					<h2>投诉简介</h2>
					<div class="text">您的投诉已提交成功,我们会尽快为您处理.</div>
					
				</li>
				
			</ul>

<!--<ul class="round">
                <li>
                    <a href="myby-483.html" >
                        <span>我的在线预约</span>
                    </a>
                </li>
            </ul>-->
		  

			<div class="footReturn">
				<a id="showcard" class="submit" href="index.html">返回主界面</a>
				<div class="window" id="windowcenter">
					<div id="title" class="wtitle">提示<span class="close" id="alertclose"></span></div>
					<div class="content">
						<div id="txt"></div>
					</div>
				</div>
			</div>
		</div>
	<div class="plugback">
		<a href="javascript:history.back(-1)">
			<div class="plugbg themeStyle">
				<span class="plugback">
				</span>
			</div>
		</a>
	</div>
</section>
	<div class="mfooter" id="wxgjfooter" style="text-align: center;width: 100%;height: 20px;line-height: 20px;margin-top:10px;">
<span class="sp2"><a href="#" style="color: #5e5e5e;font-size: 12px;"><!--@39MI提供技术支持--></a></span>
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
     <script>
    	$(document).ready(function(){
    		$(function(){
				new Swipe(document.getElementById('imgs_box'), {
					speed:500,
					//auto:3000,
					callback: function(index, elem){
						var lis = $('#imgs_box').children("ol").children();
						lis.removeClass("on").eq(index).addClass("on");
					}
				}); 
			});
    		
    		$('#showcard').click(function(){

    			$.ajax({
    			url:'yybyok-483-1-.html',
    			data:$('#theform').serialize(),
    			type:'POST',
    			success:function(m){
    				if(m=='ok'){
    					$('#txt').text('提交成功');
    					$('#windowcenter').slideDown();
    				}if(m=='rep'){
    					$('#txt').text('请勿重复提交');
    					$('#windowcenter').slideDown();
    				}
    				setTimeout(function(){
    					$('#windowcenter').slideUp();
    				},1000);
    			}
    			});
    		});
    	});
   	</script>        		
</body>        		
</html>