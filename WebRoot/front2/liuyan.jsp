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
	
	function checkform()
	{
			var name = document.getElementById('name').value;
			
			var messagecontent = document.getElementById('messagecontent').value;
			
			console.log(messagecontent);
			if(name=='')
			{
				alert("请输入您的姓名.");
				return false;
			}
			if(messagecontent=='')
			{
				alert("请输入留言内容.");
				return false;
			}
		return true;
	}
	
	
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
 
			<div class="history">
				<div class="history-date">
					<ul>
						<a><h2 class="first first1" style="position: relative;">请点击留言</h2></a>
						<!--<li class="nob  mb"><div class="beizhu">留言审核通过后才会显示在留言墙上！</div></li>-->
						<li class="green bounceInDown nob ly1" style="display:none">.
							<form action="messageAction!addMessageFront" method="post" id="theform"  onsubmit="return checkform();">
							<dl>
								<dt>
									<input name="name" type="text" class="px" id="name"  placeholder="请输入您的昵称" />
								</dt>
								<dt>
									<textarea name="messagecontent" class="pxtextarea" style=" height:60px;" id="messagecontent" placeholder="请输入留言"></textarea>
								</dt>
								<dt>
											  <s:token></s:token>
							<input type="submit" class="submit" style="width: 100%;font-weight: bold; " value="提交留言" />
								</dt>
							</dl>
							</form>
						</li>
							<s:if test="%{messages.size()==0}">
									 <li class="green bounceInDown">
										<h3>
											暂时没有留言.
										</li>
							</s:if>
						<s:iterator value="messages" var="message">
							 <li class="green bounceInDown">
								<h3>
									<s:property value="name" />的留言<span><s:property value="messagetime" /></span>
									<div class="clr"></div>
								</h3>
								<dl>
									<dt class="hfinfo"><s:property value="messagecontent" /></dt>
								</dl>
															<dl class="huifu">
									<dt>
										<span> <dt class="hfinfo"><s:property value="replyname" />的回复<span><s:property value="replytime" /></span></dt>
											<p  class="hhly11803">
												<textarea name="info" class="pxtextarea hly1007" readonly="readonly"><s:property value="replycontent" /></textarea> 
											</p>
										</span>
									</dt>
								</dl>
							</li>
							
							</s:iterator>
							
						<h2 class="first " style="position: relative;"></h2>
						</ul>
					</div>
				</div>
			</div>
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