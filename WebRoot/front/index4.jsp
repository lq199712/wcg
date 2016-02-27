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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!--<meta name="viewport" content="target-densitydpi=device-dpi, width=device-width, initial-scale=0.5, minimum-scale=0.5, maximum-scale=0.5" />-->
		<!--移动端版本兼容 -->
		<script type="text/javascript">
		var phoneWidth =  parseInt(window.screen.width);
		var phoneScale = phoneWidth/640;
		var ua = navigator.userAgent;
		if (/Android (\d+\.\d+)/.test(ua)){
			var version = parseFloat(RegExp.$1);			
			if(version>2.3){
				document.write('<meta name="viewport" content="width=640, minimum-scale = '+phoneScale+', maximum-scale = '+phoneScale+', target-densitydpi=device-dpi">');
			}else{
				document.write('<meta name="viewport" content="width=640, target-densitydpi=device-dpi">');
			}
		} else {
			document.write('<meta name="viewport" content="width=640, user-scalable=no, target-densitydpi=device-dpi">');
		}
	</script>
		<!--移动端版本兼容 end -->

		<meta name="apple-mobile-web-app-capable" content="yes" />
		<meta http-equiv="x-ua-compatible" content="IE=edge" />
		<meta http-equiv="widow-target" content="_blank">
		<title>金公子美发</title>
		<link rel="apple-touch-icon-precomposed" sizes="57x57"
			href="ico/TOP-57.png" />
		<link rel="apple-touch-icon-precomposed" sizes="72x72"
			href="ico/TOP-72.png" />
		<link rel="apple-touch-icon-precomposed" sizes="114x114"
			href="ico/TOP-114.png" />
		<link rel="apple-touch-icon-precomposed" sizes="144x144"
			href="ico/TOP-144.png" />
		<link rel="stylesheet" href="css/global.css">
		<link rel="stylesheet" href="css/animate.css">

		<link href="css/idangerous/idangerous.s6-1.4.css" rel="stylesheet"
			type="text/css">
		<link href="css/zns_style.css" rel="stylesheet" type="text/css">

		<script src="statistics.js"></script>

	</head>

	<body style='background-color: #000;'>
		<div style="position: absolute; z-index: -1000; opacity: 0;"></div>
		<div id="videoContainer"></div>
		<div class="loading">
			<div class="spinner"></div>
		</div>


		<section id="myContainer">
		<section id="myContent">
		<section id="myPage"></section>
		</section>
		</section>
		<!--end #myContainer-->


		<div id="main">
			<div class="enterSite">
				<div class="btnBorder"></div>
				<img src="images/public/enter.png">
			</div>



			<div class="info">
				<div class="stage1">
					<div class="stageTxt">
						<div class="t1">
							<img src="images/info/t1.png">
						</div>

						<div class="t2">
							<img src="images/info/t2.png">
						</div>

						<div class="t3">
							你的风采·我的光彩
						</div>
					</div>
					<!--end .stageTxt-->
					<div class="stageBg">
						<img src="images/info/bg1.jpg">
					</div>
				</div>
				<!--end .stage1-->
			</div>
			<!--end .info-->

			<div id="myHome">
				<div class="myScroll">
					<div class="logo" name='logo' data-slow="0">
						<audio autoplay="autoplay">
							<source src="music/zouxiu.mp3" type="audio/mpeg">
						</audio>
												
						<!--<img src="images/public/logo.png">-->
					</div>

					<div class="banner" name='banner' data-slow="0">
						<!--banner-->
						<div class="s6-container">
							<div class="s6-wrapper">
								<!--图片-->
								<div class="p0 s6-slide"></div>
								<div class="p1 s6-slide"></div>
								<div class="p2 s6-slide"></div>
								<div class="p1 s6-slide"></div>
								<!--阴影-->
								<!--<div class="s6-dynamic-shadow" style="-webkit-transform: scale3d(0.8, 1, 0.8) translate3d(0px, -20px, -400px) rotateX(-90deg); width: 622px; height: 622px; "></div>-->
							</div>
						</div>
						<!--end .s6-container-->
					</div>

					<div class="homeContent">
						<div class="subNav">
							<s:action name="bigtypeAction!frontBigtypes">
								<s:param name="frontpa" value="#parameters.frontpa"></s:param>
							</s:action>
							<div class="SN1 RO" name="saoyisao" data-slow="0"
								data-timeline='0'>
								<div class="rHit"></div>
								<div class="rotate">
									<a
										href="<%=basePath%>pagearticleAction!frontpagearticle?stid=2&producttype=2&frontpa=<s:property value="#parameters.frontpa"/>"><img
											src="images/nav/qr.jpg">
									</a>
								</div>
							</div>
							<div class="SN2 RO" name="bespeak" data-slow="0"
								data-timeline='1'>
								<div class="rHit"></div>
								<div class="rotate">
									<a
										href="<%=basePath%>pagearticleAction!frontpagearticle?stid=1&producttype=1&frontpa=<s:property value="#parameters.frontpa"/>"><img
											src="images/nav/bespeak.jpg">
									</a>
								</div>
							</div>
							<div class="SN3 RO" name="map" data-slow="0" data-timeline='2'>
								<div class="rHit"></div>
								<div class="rotate">
									<a href="<s:property value="#request.bigtypes[2].linkurl"/>"><img
											src="images/nav/route.jpg">
									</a>
								</div>
							</div>
							<div class="SN4 RO" name="hot_line" data-slow="0"
								data-timeline='3'>
								<div class="rHit"></div>
								<div class="rotate">
									<a
										href="http://api.map.baidu.com/marker?location=31.363996,119.826365&title=金公子美发沙龙&content=金公子美发沙龙&output=html"><img
											src="images/nav/hot_line.jpg">
									</a>
								</div>
							</div>
						</div>
						<!--end .subNav-->

						<div class="module1">
							<div
								style="top: 636px; width: 312px; height: 312px; position: absolute;"
								name="appreciation" data-slow="0" data-timeline='4'>
								<div class="rHit"></div>
								<!--九宫格-->
								<div class="rotate">
									<!--<img src="images/module/module1.jpg">-->
									<a
										href="<%=basePath%>pagearticleAction!frontpagearticle?stid=3&producttype=3&frontpa=<s:property value="#parameters.frontpa"/>">
										<div class="mask">
											<ul>
												<li>
													<div class="rimg">
														<img src="images/module/module1.jpg">
													</div>
													<div class="rpane"></div>
													<div class="rcolor"></div>
												</li>
												<li>
													<div class="rimg">
														<img src="images/module/module1.jpg">
													</div>
													<div class="rpane"></div>
													<div class="rcolor"></div>
												</li>
												<li>
													<div class="rimg">
														<img src="images/module/module1.jpg">
													</div>
													<div class="rpane"></div>
													<div class="rcolor"></div>
												</li>
												<li>
													<div class="rimg">
														<img src="images/module/module1.jpg">
													</div>
													<div class="rpane"></div>
													<div class="rcolor"></div>
												</li>
												<li>
													<div class="rimg">
														<img src="images/module/module1.jpg">
													</div>
													<div class="rpane"></div>
													<div class="rcolor"></div>
												</li>
												<li>
													<div class="rimg">
														<img src="images/module/module1.jpg">
													</div>
													<div class="rpane"></div>
													<div class="rcolor"></div>
												</li>
												<li>
													<div class="rimg">
														<img src="images/module/module1.jpg">
													</div>
													<div class="rpane"></div>
													<div class="rcolor"></div>
												</li>
												<li>
													<div class="rimg">
														<img src="images/module/module1.jpg">
													</div>
													<div class="rpane"></div>
													<div class="rcolor"></div>
												</li>
												<li>
													<div class="rimg">
														<img src="images/module/module1.jpg">
													</div>
													<div class="rpane"></div>
													<div class="rcolor"></div>
												</li>
											</ul>

											<div class="apTxt">
												<img src="images/module/aptxt1.png">
											</div>
										</div> </a>
								</div>
							</div>
							<s:action name="pagearticleAction!frontindexview">
				        		<s:param name="frontpa" value="#parameters.frontpa"></s:param>
				        	</s:action>
							<div class="MD2 RO" name="summary" data-slow="0"
								data-timeline='5'>
								<div class="rHit"></div>
								<div class="rotate">
									<a href="pagearticleAction!frontview4?id=${requestScope.pagearticles[0].id }&frontpa=<s:property value="#parameters.frontpa"/>">
										<div class="mask">
											<div class="SG">
												<div class="rStatic">
													<img data-gifurl='images/module/module2.gif'
														src="images/module/module2.jpg">
												</div>
												<div class="rGif">
													<img src="images/module/module2.png">
												</div>
											</div>
										</div> </a>
								</div>
							</div>
							<div class="MD3 RO" name='trade' data-slow="0" data-timeline='6'>
								<div class="rHit"></div>
								<div class="rotate">
									<a
										href="pagearticleAction!frontview4?id=${requestScope.pagearticles[1].id }&frontpa=<s:property value="#parameters.frontpa"/>">
										<div class="mask">
											<div class="SG">
												<div class="rStatic">
													<img data-gifurl='images/module/module3.gif'
														src="images/module/module3.jpg">
												</div>
												<div class="rGif">
													<img src="images/module/module3.gif">
												</div>
											</div>
										</div> </a>
								</div>
							</div>
						</div>
						<!--end .module-->

						<div class="module2">
							<div class="MD1 RO" name='type' data-slow="0" data-timeline='7'>
								<div class="rHit"></div>
								<div class="rotate">
									<a href="pagearticleAction!frontview4?id=${requestScope.pagearticles[2].id }&frontpa=<s:property value="#parameters.frontpa"/>"><img src="images/module/module4.png">
									</a>
								</div>
							</div>
							<div class="MD2 RO" name='video' data-slow="0" data-timeline='8'>
								<div class="rHit"></div>
								<div class="rotate">
									<a href="pagearticleAction!frontview4?id=${requestScope.pagearticles[3].id }&frontpa=<s:property value="#parameters.frontpa"/>"><img
											src="images/module/module5.png">
									</a>
								</div>
							</div>
							<div class="MD3 RO" name='panorama' data-slow="0"
								data-timeline='9'>
								<div class="rHit"></div>
								<div class="rotate">
									<a href="memberAction!frontToCenter?1=1&frontpa=<s:property value="#parameters.frontpa"/>&openid=<s:property value="#parameters.openid"/>">
										<div class="mask">
											<div class="apTxt"></div>
											<img src="images/module/module6.jpg">
										</div> </a>
								</div>
							</div>
						</div>
						<!--end .module-->

						<div class="module3" style="height: 120px;margin-top: 3px;">
							
							<div class="ad2" data-slow="0">
		                    	<a href="pagearticleAction!frontview4?id=${requestScope.pagearticles[4].id }&frontpa=<s:property value="#parameters.frontpa"/>" target="_blank">
		                    	<img src="images/module/add/m1.png"></a>
		                    </div>
		                    
		                    <div class="ad3" data-slow="0">
		                    	<a href="pagearticleAction!frontview4?id=${requestScope.pagearticles[5].id }&frontpa=<s:property value="#parameters.frontpa"/>" target="_blank"><img src="images/module/add/m2.jpg"></a>
		                    </div>
	
							
						</div>
						<!--end .module-->
						<div class="module3" style="height: 150px;margin-top:30px;">
							<div class="adList" name='footer' data-slow="0"
								data-timeline='10'>
								<a href="bigwheelActionfront!bigwheel?frontpa=<s:property value="#parameters.frontpa"/>&openid=<s:property value="#parameters.openid"/>" target="_blank"><img
										src="images/module/footer.jpg">
								</a>
							</div>
						</div>
					</div>
					<!--end .homeContent-->

					<div class="statisticsContainer" name='statisticsContainer'
						data-slow="0" style="display: none;">
						<div class="staCount" style="display: none">
						</div>

						<div class="staTxt" style="margin-left: -120px;">
							访问统计:
						</div>
						<div id="statistics" class="statistics"></div>
						<div class="staTxt">
							次浏览
						</div>
					</div>
					<div class="copyright" name='copyright' data-slow="0">
						<a href="http://www.39mnet.com:8080/39mi/index.html"
							target="_blank"><img src="images/public/copyright.png">
						</a>
					</div>
				</div>
				<!--end .myScroll-->
			</div>
			<!--end #myHome-->

			<!--<div id="myContainer"></div>-->
		</div>
		<!--end #main-->

		<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>

		<script>
		 var browser={
			versions:function(){ 
				   var u = navigator.userAgent, app = navigator.appVersion; 
				   return {//移动终端浏览器版本信息 
						trident: u.indexOf('Trident') > -1, //IE内核
						presto: u.indexOf('Presto') > -1, //opera内核
						webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
						gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核
						mobile: !!u.match(/AppleWebKit.*Mobile.*/)||!!u.match(/AppleWebKit/), //是否为移动终端
						ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
						android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或者uc浏览器
						iPhone: u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1, //是否为iPhone或者QQHD浏览器
						iPad: u.indexOf('iPad') > -1, //是否iPad
						webApp: u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部
					};
				 }(),
				 language:(navigator.browserLanguage || navigator.language).toLowerCase()
		}
		if(browser.versions.android){ 
			document.write('<script type="text/javascript" src="js/fullscript2.js"><'+'/script>')
		}else{ 
			document.write('<script type="text/javascript" src="js/fullscript.js"><'+'/script>') 
		} 
</script>
		<!--<script type="text/javascript" src="js/detection.js"></script>-->
		<script type="text/javascript"
			src="js/greensock/easing/EasePack.min.js"></script>
		<script type="text/javascript" src="js/thumbs/thumbs.0.6.0.js"></script>
		<script type="text/javascript"
			src="js/greensock/plugins/CSSPlugin.min.js"></script>
		<script type="text/javascript" src="js/greensock/TweenLite.min.js"></script>
		<script type="text/javascript" src="js/load/imagesloaded.js"></script>
		<script type="text/javascript" src="js/iscroll/4.0/iscroll_custom.js"></script>
		<script type="text/javascript" src="js/history/jquery.history.js"></script>
		<script type="text/javascript" src="js/isHorizontal.js"></script>
		<script type="text/javascript" src="js/siteData.js"></script>
		<script type="text/javascript" src="js/public.js"></script>
		<script type="text/javascript" src="js/main.js"></script>

	</body>
</html>
