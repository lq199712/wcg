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
    <title>行政许可查询结果</title>
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
    </head>
        <body id="hotels" ondragstart="return false;" onselectstart="return false;" >
		


<section class="body">
	<div class="banner">
	<div id="imgs_box" class="box_swipe">
		<img alt="" src="res/huwai.jpg" style="width: 100%;">	
	</div>
	</div>
	<div class="cardexplain">


			<!--后台可控制是否显示-->
			<ul class="round">
				<li>
					<h2>行政许可查询结果</h2>
					<div class="text">
					<s:if test="infApplyVO!=null">
						办理类型：<s:property value="infApplyVO.transactAffairName"/><br/>
						办理事务：<s:property value="infApplyVO.content"/><br/>
						审批是否通过：
						<s:if test="infApplyVO.note=='同意'">已通过</s:if>
						<s:else>
							未通过
						</s:else>
						<br/>
					
					</s:if>
					<s:else>
						未查询到相关内容
						
					</s:else>
					</div>
					
				</li>
				<li class="tel"><a href="tel:12319"><span>12319</span></a></li>
				
			</ul>

<!--<ul class="round">
                <li>
                    <a href="myby-483.html" >
                        <span>我的在线预约</span>
                    </a>
                </li>
            </ul>-->
		  

			
			<div class="footReturn">
				<a id="showcard" class="submit" href="javascript:history.back();">返回</a>
				
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