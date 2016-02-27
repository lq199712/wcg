<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<!-- Apple devices fullscreen -->
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<!-- Apple devices fullscreen -->
		<meta name="apple-mobile-web-app-status-bar-style"
			content="black-translucent" />
		<base target="mainFrame" />
		<link rel="stylesheet" type="text/css" href="css/wm/index.css"
			media="all" />
		<link rel="stylesheet" type="text/css" href="css/wm/bootstrap_min.css"
			media="all" />
		<link rel="stylesheet" type="text/css"
			href="css/wm/bootstrap_responsive_min.css" media="all" />
		<link rel="stylesheet" type="text/css" href="css/wm/style.css"
			media="all" />
		<link rel="stylesheet" type="text/css" href="css/wm/themes.css"
			media="all" />
		<style type="text/css">
.main-nav,.icon-nav {
	height: 56px;
}

.main-nav li,.icon-nav li,.dropdown {
	height: 56px;
}

.icon-nav li.subtitle {
	height: 16px;
}

.main-nav li a,#navigation .user .dropdown a,.icon-nav li a,.toggle-nav
	{
	line-height: 36px;
	padding: 10px;
}

#navigation .main-nav li a .caret,#navigation .icon-nav li a .caret,#navigation .user .dropdown a .caret
	{
	margin-top: 14px;
}
</style>
		<title>宜兴市城管局</title>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/yyucadapter.js"></script>
		<link rel="shortcut icon" href="faviconmy.ico" />
		<script type="text/javascript">
$(function(){
	if(window.parent && window.parent != window){
		window.parent.location.href = location.href;
	}
	$('#maincolor').find('span').click(function(){
		var col = 'theme-'+$(this).attr('class');
		$('body').removeAttr('class').addClass(col);
		$('#maincolor').hide();
		ajax('ind-setcolor.html',{ col:col},function(){
			$('#mainFrame').contents().find("body").removeAttr('class').addClass(col);
		});
	});
	
	//setInterval(function(){
		//if($('#mainFrame').contents().find("#mainformsundivt").size()==0){
		//	$('#mainFrame').contents().find("body").append('<div id="mainformsundivt" style="height:30px;"></div>');
		//}
	//},500);
});


function notifyMe() {
		return;
        if (!("Notification" in window)) {
            //alert("该浏览器不支持");
            return;
        }
        else if (Notification.permission === "granted") {
            var notification = new Notification("标题",{body: "这个是主体"});
			notification.addEventListener("click",function(){
                window.mainFrame.location.href="tousu_manage.html";
				        //window.target = "mainFrame";
            });
        }
        else if (Notification.permission !== 'denied') {
            Notification.requestPermission(function (permission) {
                // If the user is okay, let's create a notification
                if (permission === "granted") {
                    var notification = new Notification("Hi there!");
                }
            });
        }
    }
</script>
	</head>
	<body class="theme-blue" onload="notifyMe();">
		<div id="navigation">
			<div class="container-fluid" style="position: relative;">
				<div>
					<a href="javascript:;" target="_self" id="brand"><img
							src="media/images/reg/logo2.png" style="margin-top: 6px;" />
					</a>
					<a href="javascript:;" target="_self" class="toggle-nav"
						rel="tooltip" data-placement="bottom" title="Toggle navigation"><i
						class="icon-reorder"></i>
					</a>
				</div>
				<ul class='main-nav'>
					<li class='active'>
						<a href="main.html" target="_self"> <span>欢迎界面</span> </a>
					</li>

				</ul>
				<div class="user">
					<ul class="icon-nav">
						<li class='dropdown'>
							<a href="javascript:;" class='dropdown-toggle'
								data-toggle="dropdown" title="消息" style="display: none;"><i
								class="icon-envelope"></i><span class="label label-lightred">4</span>
							</a>
						</li>
						<li class="dropdown sett" style="display: none;">
							<a href="javascript:;" class='dropdown-toggle'
								data-toggle="dropdown" title="系统设置"><i class="icon-cog"></i>
							</a>
						</li>
						<li class='dropdown colo'>
							<a href="javascript:;" class='dropdown-toggle'
								data-toggle="dropdown" title="选择颜色"><i class="icon-tint"></i>
							</a>
							<ul class="dropdown-menu pull-right theme-colors" id="maincolor">
								<li class="subtitle">
									请选择系统颜色
								</li>
								<li>
									<span class='red'></span>
									<span class='orange'></span>
									<span class='green'></span>
									<span class="brown"></span>
									<span class="blue"></span>
									<span class='lime'></span>
									<span class="teal"></span>
									<span class="purple"></span>
									<span class="pink"></span>
									<span class="magenta"></span>
									<span class="grey"></span>
									<span class="darkblue"></span>
									<span class="lightred"></span>
									<span class="lightgrey"></span>
									<span class="satblue"></span>
									<span class="satgreen"></span>
								</li>
							</ul>
						</li>
					</ul>
					<div class="dropdown">
						<a href="javascript:;" class='dropdown-toggle' target="_self"
							data-toggle="dropdown" style="width: 127px;"><nobr>
								${admin.username}
								<span class="caret"></span>
							</nobr>
						</a>
						<ul class="dropdown-menu pull-right">
							<li>
								<a href="login.jsp" target="_self">退出</a>
							</li>
						</ul>
					</div>

				</div>
			</div>
		</div>

		<div class="container-fluid" id="content">

			<div id="left">
				<div class="subnav">
					<div class="subnav-title">
						<a href="javascript:void(0);" class='toggle-subnav'
							style="font-size: 16px;">-办公管理</a>
					</div>
				</div>
				<s:if test="%{#session.admin.limits==1||#session.admin.limits==0}">
					<div class="subnav">
						<div class="subnav-title">
							<a href="javascript:void(0);" class='toggle-subnav'><i
								class="icon-angle-right"></i><span>投诉管理</span>
							</a>
						</div>
						<ul class="subnav-menu" style="display: none">
							<li>
								<a href="complaintAction!goToAdd">新建投诉</a>
							</li>
							<li>
								<a href="complaintAction!list">代办工作</a>
							</li>
							<li>
								<a href="complaintAction!toQuery">工作查询</a>
							</li>
						</ul>
					</div>
				</s:if>
				<s:if test="%{#session.admin.limits==2||#session.admin.limits==0}">
					<div class="subnav">
						<div class="subnav-title">
							<a href="javascript:void(0);" class='toggle-subnav'><i
								class="icon-angle-right"></i><span>新闻管理</span>
							</a>
						</div>
						<ul class="subnav-menu" style="display: none">
							<li>
								<a href="news_cgdt_manage.html">城管动态</a>
							</li>
							<li>
								<a href="news_ztbd_manage.html">专题报道</a>
							</li>
							<li>
								<a href="news_cgqk_manage.html">城管期刊</a>
							</li>
						</ul>
					</div>
				</s:if>
				<s:if test="%{#session.admin.limits==3||#session.admin.limits==0}">
					<div class="subnav">
						<div class="subnav-title">
							<a href="javascript:void(0);" class='toggle-subnav'><i
								class="icon-angle-right"></i><span>建筑垃圾准运管理</span>
							</a>
						</div>
						<ul class="subnav-menu" style="display: none">
							<li>
								<a href="conwasteAction!list">建筑垃圾准运管理</a>
							</li>

						</ul>
					</div>
				</s:if>
				<s:if test="%{#session.admin.limits==4||#session.admin.limits==0}">
					<div class="subnav">
						<div class="subnav-title">
							<a href="javascript:void(0);" class='toggle-subnav'><i
								class="icon-angle-right"></i><span>数字城管</span>
							</a>
						</div>
						<ul class="subnav-menu" style="display: none">
							<li>
								<a href="renovationAction!goToAdd">新建整改内容</a>
							</li>
							<li>
								<a href="renovationAction!list">整改管理</a>
							</li>

						</ul>
					</div>
				</s:if>
				<s:if test="%{#session.admin.limits==0}">
					<div class="subnav">
						<div class="subnav-title">
							<a href="javascript:void(0);" class='toggle-subnav'
								style="font-size: 16px;">-微信公众平台管理</a>
						</div>
					</div>


					<div class="subnav">
						<div class="subnav-title">
							<a href="javascript:void(0);" class='toggle-subnav'><i
								class="icon-angle-right"></i><span>微官网</span>&nbsp;&nbsp;
							</a>
						</div>
						<ul class="subnav-menu" style="display: none">
							<li>
								<a href="webkeyword.html">关键字设置</a>
							</li>
							<li>
								<a href="catemanage.html">分类管理</a>
							</li>
							<li>
								<a href="article_manage.html">文章管理</a>
							</li>
							<li>
								<a href="depjianjie.html">政务部门简介</a>
							</li>
							<li>
								<a href="navigationset.html">菜单导航设置</a>
							</li>
							<li>
								<a href="weiqiwebbg.html">背景轮播设置</a>
							</li>
							<li>
								<a href="weiqiver.html">底部版权设置</a>
							</li>
						</ul>
					</div>

					<div class="subnav">
						<div class="subnav-title">
							<a href="javascript:void(0);" class='toggle-subnav'><i
								class="icon-angle-right"></i><span>微相册</span>
							</a>
						</div>
						<ul class="subnav-menu" style="display: none">
							<li>
								<a href="xiangceset.html">相册设置</a>
							</li>
							<li>
								<a href="xiangcelist.html">相册管理</a>
							</li>
						</ul>
					</div>

					<div class="subnav">
						<div class="subnav-title">
							<a href="javascript:void(0);" class='toggle-subnav'><i
								class="icon-angle-right"></i><span>微留言</span>
							</a>
						</div>
						<ul class="subnav-menu" style="display: none">
						
						<!-- 
							<li>
								<a href="liuyanset.html">留言板设置</a>
							</li>
						 -->	
							<li>
								<a href="messageAction!list">留言管理</a>
							</li>
							<!-- 
							<li>
								<a href="liuyanhei.html">黑名单管理</a>
							</li>
							 -->
							
						</ul>
					</div>
					<div class="subnav">
						<div class="subnav-title">
							<a href="javascript:void(0);" class='toggle-subnav'><i
								class="icon-angle-right"></i><span>微调研</span>
							</a>
						</div>
						<ul class="subnav-menu" style="display: none">
							<li>
								<a href="wdyAction!list">调研管理</a>
							</li>
							<li>
								<a href="wdyAction!goToAdd">调研新增</a>
							</li>
						</ul>
					</div>

					<div class="subnav">
						<div class="subnav-title">
							<a href="javascript:void(0);" class='toggle-subnav'><i
								class="icon-angle-right"></i><span>微投票</span>
							</a>
						</div>
						<ul class="subnav-menu" style="display: none">
							<li>
								<a href="wvoteAction!list">微投票管理</a>
							</li>
							<li>
								<a href="wvoteAction!goToAdd">微投票新增</a>
							</li>
						</ul>
					</div>
				</s:if>
				<div class="subnav">
					<div class="subnav-title">
						<a href="javascript:void(0);" class='toggle-subnav'><i
							class="icon-angle-right"></i><span>管理员信息</span>
						</a>
					</div>
					<ul class="subnav-menu" style="display: none">
						<s:if test="%{#session.admin.limits==0}">
							<li>
								<a href="adminAction!list">账号管理</a>
							</li>
						</s:if>
						<li>
							<a href="adminAction!loadself?id=${admin.id }">我的账号</a>
						</li>
						<li>
							<a href="admin_update_pwd.jsp">修改密码</a>
						</li>
					</ul>
				</div>
				<div class="subnav bottom">
					<div class="subnav-title">
						<a href="javascript:alert('没有权限');" class='toggle-subnav'><i
							class="icon-angle-right"></i><span></span>
						</a>
					</div>
					<ul class="subnav-menu">
					</ul>
				</div>
			</div>

			<div class="right">
				<div class="main">
					<iframe frameborder="0" id="mainFrame" name="mainFrame"
						src="welcom.jsp"
						style="background: url('http://stc.weimob.com/img/loading.gif') center no-repeat"></iframe>
				</div>
			</div>

		</div>


		<script type="text/javascript">
    $('[data-toggle="dropdown"]').each(function(){
    	$(this).parent().hover(function(){
    		$(this).find('ul').show();
    	},function(){
    		$(this).find('ul').hide();
    	});
    });
    $('div.subnav > .subnav-title').click(function(){
    	var pul = $(this).parent().find('ul');
    	if(pul.is(':hidden')){
    		var vone = $('div.subnav').find('ul:visible');
    		pul.slideDown(200,function(){
    			vone.slideUp();
    		});
    	}else{
    		pul.slideUp();
    	}
    });
    $('div.subnav').find('ul').children('li').click(function(){
    	$('div.subnav').find('ul').children('li').removeClass('active');
    	$(this).addClass('active');
    });
    $('.toggle-nav').click(function(){
    	if($('.right').is('.reight_p')){
    		$('.right').removeClass('reight_p');	
    		$('#left').show();
    	}else{
    		$('.right').addClass('reight_p');
    		$('#left').hide();
    	}    	
    });
    $('.main-nav').children('li').click(function(){
    	$('.main-nav').find('li').removeClass('active');
    	$(this).addClass('active');
    });
    function fresh_sys(){
    	mainFrame.location.reload();
    	
    }
    </script>
	</body>

</html>