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
	<meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>微留言</title>
    <script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/yyucadapter.js"></script>

    <meta content="" name="Keywords">
	<meta content="" name="Description">
    <link rel="stylesheet" type="text/css" href="css/mwm/msg/msg.css" media="all" />	

	<meta content="" name="description">
	<meta content="" name="keywords">
	<meta content="eric.wu" name="author">
	<meta content="application/xhtml+xml;charset=UTF-8" http-equiv="Content-Type">
	<meta content="no-cache,must-revalidate" http-equiv="Cache-Control">
	<meta content="no-cache" http-equiv="pragma">
	<meta content="0" http-equiv="expires">
	<meta content="telephone=no, address=no" name="format-detection">
	<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
 
	<script type="text/javascript"> 
		$(document).ready(function () { 
			$("#showcard1").click(function () { 
				var btn = $(this);
				var wxname = $("#wxname1").val();
				if (wxname  == '') {
					alert("请输入昵称");
					return;
				}
				var info = $("#info1").val();
					if (info == '') {
					alert("请输入内容");
					return;
				}
				var submitData = {
					nc:wxname,
					msg: info,
					pid: "0"
				};
				$.post('lyadd.html', submitData,
					function(data) {
						if (data == 'ok') {
							alert('留言成功');
							setTimeout('window.location.href=location.href',1000);
						return;
					} else {}
				});
			}); 
			//
			$("#showcard2").click(function () { 
				var btn = $(this);
				var wxname = $("#wxname2").val();
					if (wxname  == '') {
					alert("请输入昵称");
					return;
				}
				var info = $("#info2").val();
					if (info == '') {
					alert("请输入内容");
					return;
				}
				var submitData = {
						nc:wxname,
						msg: info,
						pid: "0"
					};
				$.post('lyadd.html', submitData,
						function(data) {
							if (data == 'ok') {
								alert('留言成功');
								setTimeout('window.location.href=location.href',1000);
							return;
						} else {}
				});
			});  
			//
			$(".hhsubmit").click(function () { 
				var objid = $(this).attr("date");
				var info = $(".hly"+objid).val();
					if (info == '') {
					alert("请输入内容");
					return;
				}
				var submitData = {
					nc:'小龙',
					pid:objid,
					msg: info
				};
				$.post('lyadd.html', submitData,
						function(data) {
							if (data == 'ok') {
								alert('留言成功');
								setTimeout('window.location.href=location.href',1000);
							return;
						} else {}
				});
			});  
			//
			$(".hfinfo").click(function () { 
				var objid = $(this).attr("date");
				$(".hhly"+objid).slideToggle();
			}); 
			//
			$(".hhbt").click(function () { 
				var objid = $(this).attr("date");
				$(".hhly"+objid).slideToggle();
			});
			//
			$("#windowclosebutton").click(function () { 
				$("#windowcenter").slideUp(500);
			});
			//
			$("#alertclose").click(function () { 
				$("#windowcenter").slideUp(500);
			});
		}); 
		//
		function alert(title){ 
			window.scrollTo(0, -1);
			$("#windowcenter").slideToggle("slow"); 
			$("#txt").html(title);
			setTimeout(function(){ $("#windowcenter").slideUp(500);},4000);
		}
		//
		$(document).ready(function(){
			$(".first1").click(function(){
				$(".ly1").slideToggle();
			});
			$(".first2").click(function(){
				$(".ly2").slideToggle();
			});
		});
	</script> 
</head>
 
<body id="message" onselectstart="return true;" ondragstart="return false;">
	<div class="container">
	  	<div class="qiandaobanner">
		  	<a href="javascript:history.go(-1);">
		  		<img src="res/lyheadpic.jpg" style="width:100%;" />
		  	</a>
	  	</div>

		<div class="cardexplain">
			<div class="window" id="windowcenter">
				<div id="title" class="wtitle">操作提示<span class="close" id="alertclose"></span></div>
				<div class="content">
					<div id="txt"></div>
				</div>
			</div>
	<div class="banner">
	</div>
	<div class="cardexplain">


			<!--后台可控制是否显示-->
			<ul class="round">
				<li>
					<h2>留言简介</h2>
					<div class="text">您的留言已提交成功.</div>
					
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
	<div class="mfooter" id="wxgjfooter" style="text-align: center;width: 100%;height: 20px;line-height: 20px;margin-top:10px;">
<span class="sp2"><a href="#" style="color: #5e5e5e;font-size: 12px;"><!--@39MI提供技术支持--></a></span>
</div>
<div style="width: 0px;height: 0px;overflow: hidden;">

</div>
	<script type="text/javascript">
 	        
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