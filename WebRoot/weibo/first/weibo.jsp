<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8">

		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">

		<title>宜兴微城管-数字城管</title>
		<meta id="viewport" name="viewport"
			content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
		<meta name="format-detection" content="telephone=no">
		<script>var _loadStart = new Date().getTime();</script>
		<link href="css/base-88548c4e212546d731b38965eb2c267f.css"
			type="text/css" rel="stylesheet">
		<link href="css/cards-f26c86dca1e7839fd704f8eb33507a12.css"
			type="text/css" rel="stylesheet">
		<link href="css/mods.all-43133a7c35c2b2ad4378e22717d0c2d6.css"
			type="text/css" rel="stylesheet">

	</head>
	<body>
		<div id="box" class="container stage-home">
			<div class="home" data-node="homewrap" id="boxId_1442299450648_1">
				<div class="topBarWrap" data-node="topBarWrap">

					<div class="home-sub-nav layout-box" data-node="homeSubNav">
						<a  onClick="location='renovationAction!frontList?ftype=1'"
							href="javascript:void(0)" data-action="home"
							data-act-type="hover" data-text="首页" class="item box-col">今日</a>
						<a onClick="location='renovationAction!frontList?ftype=0'"
							href="javascript:void(0)" data-action="msg" data-act-type="hover"
							data-text="消息" class="item box-col" isActive>全部</a>
						<a onClick="location='renovationAction!frontList?ftype=2'"
							href="javascript:void(0)" data-action="discover"
							data-act-type="hover" data-text="发现" class="item box-col">已解决</a>
					</div>
				</div>
				<div class="contWrap" data-node="contWrap"
					data-url="/index/feed?format=cards"
					style="margin-top: 0px; padding-top: 50px;">
					<div data-node="homeWrap" class="tabCont" style="display: block;">
						<div data-node="loading" class="feed-loading hid"
							style="display: none;">
							<span>加载中…</span>
						</div>
						<div class="dataCont">
							<div data-node="cardList" class="card-list">
								<s:iterator value="renovations" var="renovation" status="status">
									<div class="card card9 line-around" data-act-type="hover"
										data-jump="/1749127163/CADSZEthk" id="boxId_1442299450648_16">
										<header class="layout-box media-graphic">
										<div class="box-col item-list">
											<a  class="item-main txt-l mct-a txt-cut"><span><s:property value="name"/></span>
											</a>
											<div class="item-minor txt-xxs mct-d txt-cut">
												<span class="time"><s:property value="reporttime"/></span><span
													class="from">
													<s:if test="renotype==1">
													市容市貌
													</s:if>
													<s:elseif test="renotype==2">
													宣传广告
													</s:elseif>
													<s:elseif test="renotype==3">
													园林绿化
													</s:elseif>
													<s:elseif test="renotype==4">
													黑车 
													</s:elseif>
													<s:elseif test="renotype==5">
													城市湖道
													</s:elseif>
													<s:elseif test="renotype==6">
													街面秩序
													</s:elseif>
													<s:elseif test="renotype==7">
													施工管理
													</s:elseif>
													</span>
											</div>
										</div>
										<a class="operate-box" data-act-type="hover"><i
											class="icon-font icon-font-arrow-down txt-s"></i> </a>
										</header>
										<section class="weibo-detail">
										<p class="default-content txt-xl">
											<s:property value="content"/>
											<br />
											<img src="http://u1.sinaimg.cn/upload/2014/10/16/timeline_card_small_location_default.png"
												width="18" height="18">
											<s:property value="address"/>
											<br />
											<s:if test="image1!=null&&image1!=''">
											<img width="101" height="180" data-node="pic" src="<%=basePath%>${renovation.image1}"
												data-act-type="hover"
												class="loaded">
											</s:if>	
											<s:if test="image2!=null&&image2!=''">
											<img width="101" height="180" data-node="pic"
												data-act-type="hover" src="<%=basePath%>${renovation.image2}"
												class="loaded">
											</s:if>	
										</p>
									</div>
								</s:iterator>
							</div>
							<div class="loading" data-node="more"></div>
						</div>
					</div>
					<div data-node="discoverWrap" class="tabCont"
						style="display: none;">
						<div data-node="loading" class="feed-loading hid">
							<span>加载中…</span>
						</div>
						<div class="dataCont"></div>
					</div>
					<div data-node="msgWrap" class="tabCont" style="display: none;">
						<div data-node="loading" class="feed-loading hid">
							<span>加载中…</span>
						</div>
						<div class="dataCont"></div>
					</div>
					<div data-node="profileWrap" class="tabCont" style="display: none;">
						<div data-node="loading" class="feed-loading hid">
							<span>加载中…</span>
						</div>
						<div class="dataCont"></div>
					</div>
				</div>
				<footer
					style="text-align: center;margin: 10px;line-height: 1.5;color: #CCC;font-size: .75rem;">
				Copyright © 2015-2020
				<br>
				yxwcg
				</footer>
			</div>
			<div id="boxId_1442299450648_2"></div>
		</div>

	</body>
</html>