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
<link rel="stylesheet" type="text/css" href="css/mwm/msg/msg.css" media="all" />
<script type="text/javascript">

	$(function(){

		$('.option').click(function(){

			$('.option').each(function(){

				$(this).find('img').eq(0).show();

				$(this).find('img').eq(1).hide();

				$(this).attr('sel','0');

			});

			$(this).find('img').eq(0).hide();

			$(this).find('img').eq(1).show();

			$(this).attr('sel','sel');		

		});		

	});
	
	    
        $(document).ready(function(){
			$("#windowclosebutton").click(function () { 
				$("#windowcenter").slideUp(500);
			});
			//
			$("#alertclose").click(function () { 
				$("#windowcenter").slideUp(500);
			});
		});
	
		function alert(title){ 
			window.scrollTo(0, -1);
			$("#windowcenter").slideToggle("slow"); 
			$("#txt").html(title);
			setTimeout(function(){ $("#windowcenter").slideUp(500);},4000);
		}

</script>
<script type="text/javascript" src="/res/choujiang/js/WeixinApi.js"></script>

</head>

<body style="background:#ab7cb3">

<div class="cardexplain">
			<div class="window" id="windowcenter">
				<div id="title" class="wtitle">操作提示<span class="close" id="alertclose"></span></div>
				<div class="content">
					<div id="txt"></div>
				</div>
			</div>

<script type="text/javascript">
        var mysharelink = 'http://www.weixinrs.com/wx/wtp0-11585.html?&wid=11001';	
		// 所有功能必须包含在 WeixinApi.ready 中进行
        WeixinApi.ready(function (Api) {

            // 微信分享的数据
            var wxData = {
                "appId": "", // 服务号可以填写appId
                //"imgUrl": 'http://www.weixinrs.com/res/share/wtp.jpg',
				"imgUrl": "ups/demopic.jpg",
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

	<div class="tip-cont">

		<img class="icon" src="res/wtp/images/tip_icon.png">

		投票后才能看到结果 | 最多选1项

	</div>

	<div class="option-cont">

          <s:iterator value="woptions" var="woption" status="status">
	    <div class="option" data-value="${id}" >

			<img id="img${id}" class="oimg" src="res/wtp/images/checkimg.png">

			<img id="img${id}1" class="oimg-sel" src="res/wtp/images/checkimg_check.png">

			<img alt="暂无图片" src="<%=basePath%>wvoteimage${image}"  width="200px" height="160px"/>
			<div>${name} </div>	

		</div>

		<img class="sep" src="res/wtp/images/option_sep.jpg">

	</s:iterator>
	
	 <!--  
	    <div class="option" data-value="2" onClick="divClick('img2')">

			<img id="img2" class="oimg" src="res/wtp/images/checkimg.png">

			<img id="img21" class="oimg-sel" src="res/wtp/images/checkimg_check.png">

			<div>大转盘</div>	

		</div>

		<img class="sep" src="res/wtp/images/option_sep.jpg">

	
	
	 
	    <div class="option" data-value="3" onClick="divClick('img3')">

			<img id="img3" class="oimg" src="res/wtp/images/checkimg.png">

			<img id="img31" class="oimg-sel" src="res/wtp/images/checkimg_check.png">

			<div>微官网</div>	

		</div>

		<img class="sep" src="res/wtp/images/option_sep.jpg">

	
	
	 
	    <div class="option" data-value="4" onClick="divClick('img4')">

			<img id="img4" class="oimg" src="res/wtp/images/checkimg.png">

			<img id="img41" class="oimg-sel" src="res/wtp/images/checkimg_check.png">

			<div>微团购</div>	

		</div>
-->
		<img class="sep" src="res/wtp/images/option_sep.jpg">

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	</div>

	<div class="vote-cont" onClick="gotonext()">

		<div style="height: 10px;"></div>

		<img class="vote-btn" id="submit" src="res/wtp/images/vote.png">

		<div style="height: 10px;"></div>

	</div>

 	<p class="page-url">

		<a href="/" target="_blank" class="page-url-link"></a>

	</p>

</div>

<script type="text/javascript">

function gotonext(){

	var username = '<s:property value="username"/>';
	var telphone = '<s:property value="telphone"/>';
	var res = $('.option[sel="sel"]').attr('data-value');

	if($.trim(res)==''){

		alert('请选择答案');

	}else{
		var url = 'wvoteAction!selectOption?woptionid='+parseInt(res)+'&username='+username+'&telphone='+telphone;
		console.log(url);
		url=encodeURI(url);
		url=encodeURI(url);
		window.location=url;

	}

	

}

</script>

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