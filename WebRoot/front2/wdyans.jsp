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
<title>具体内容</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>

<link type="text/css" rel="stylesheet" href="res/wdy/style/examine.css" />
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
</script>
</head>
<body style="background-color: #ffb100;">
<div class="wrapper">
	<img class="bg" src="res/wdy/images/bg.jpg">
	<div class="question" style="overflow:hidden;">
		<div class="title"><s:property value="wdy.name"/></div>
				<div class="tip1">注：本题最多能选择1个答案！</div>
			
		<s:if test="wdy.answer1!=null&&wdy.answer1!=''">
		<div class="options">
				<div class="option" data-value="1">
				<img id="img1" class="oimg" src="res/wdy/images/option_bg.png">
				<img id="img11" class="oimg-sel" src="res/wdy/images/option_sel_bg.png">
				<div class="text">
					<div class="otext"><s:property value="wdy.answer1"/></div>
				</div>
			</div>
		</s:if>	
		
		<s:if test="wdy.answer2!=null&&wdy.answer2!=''">
		<div class="option" data-value="2">
				<img id="img2" class="oimg" src="res/wdy/images/option_bg.png">
				<img id="img21" class="oimg-sel" src="res/wdy/images/option_sel_bg.png">
				<div class="text">
					<div class="otext"><s:property value="wdy.answer2"/></div>
				</div>
			</div>
		</s:if>
			
			<s:if test="wdy.answer3!=null&&wdy.answer3!=''">
		<div class="option" data-value="3">
				<img id="img3" class="oimg" src="res/wdy/images/option_bg.png">
				<img id="img31" class="oimg-sel" src="res/wdy/images/option_sel_bg.png">
				<div class="text">
					<div class="otext"><s:property value="wdy.answer3"/></div>
				</div>
			</div>
			</s:if>
			
			<s:if test="wdy.answer4!=null&&wdy.answer4!=''">
		<div class="option" data-value="4">
				<img id="img4" class="oimg" src="res/wdy/images/option_bg.png">
				<img id="img41" class="oimg-sel" src="res/wdy/images/option_sel_bg.png">
				<div class="text">
					<div class="otext"><s:property value="wdy.answer4"/></div>
				</div>
			</div>
			</s:if>
			
			<s:if test="wdy.answer5!=null&&wdy.answer5!=''">
		<div class="option" data-value="5">
				<img id="img5" class="oimg" src="res/wdy/images/option_bg.png">
				<img id="img51" class="oimg-sel" src="res/wdy/images/option_sel_bg.png">
				<div class="text">
					<div class="otext"><s:property value="wdy.answer5"/></div>
				</div>
			</div>
			</s:if>
			
			<s:if test="wdy.answer6!=null&&wdy.answer6!=''">
		<div class="option" data-value="6">
				<img id="img6" class="oimg" src="res/wdy/images/option_bg.png">
				<img id="img61" class="oimg-sel" src="res/wdy/images/option_sel_bg.png">
				<div class="text">
					<div class="otext"><s:property value="wdy.answer6"/></div>
				</div>
			</div>
			</s:if>
							
							
									

		</div>
		<div id="submit" onclick="gotonext()">
			<img src="res/wdy/images/next_btn.png">
			<span>下一步</span>
		</div>
	</div>
 	<p class="page-url">
		<a href="/" target="_blank" class="page-url-link"></a>
	</p>
<script type="text/javascript">
function gotonext(){

	var username = '<s:property value="username"/>';
	var telphone = '<s:property value="telphone"/>';
	var wdyid = '<s:property value="wdy.id"/>';
	var res = $('.option[sel="sel"]').attr('data-value');

	if($.trim(res)==''){

		alert('请选择答案');

	}else{
		var url = 'wdyAction!selectAnswer?wdyid='+wdyid+'&answerNumber='+parseInt(res)+'&username='+username+'&telphone='+telphone;
		console.log(url);
		url=encodeURI(url);
		url=encodeURI(url);
		location.href= url;
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