<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta name="description" content="微信">
<title></title>
<link rel="stylesheet" type="text/css" href="bigwheel/css/page.css">
<link href="bigwheel/css/xym.css" rel="stylesheet" type="text/css">
<link href="bigwheel/css/zwj.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="bigwheel/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="bigwheel/js/jQueryRotate.2.2.js"></script>
<script type="text/javascript" src="bigwheel/js/jquery.easing.min.js"></script>
<script type="text/javascript" src="bigwheel/js/zp.js"></script>
<style type="text/css">
body {
	background: url(bigwheel/images/bg.png) 0 0 repeat;
}

.rotate-content {
	width: 270px;
	position: relative;
	height: 270px;
	background: url()
		no-repeat 0 0;
	background-size: 100% 100%;
	margin: 0 auto
}

.rotate-con-pan {
	background: url(bigwheel/images/disk.jpg)
		no-repeat 0 0;
	background-size: 100% 100%;
	position: relative;
	width: 255px;
	height: 255px;
	padding-top: 15px;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	margin: 0 auto
}

.rotate-con-zhen {
	width: 112px;
	height: 224px;
	background: url(bigwheel/images/start.png)
		no-repeat 0 0;
	background-size: 100% 100%;
	margin: 0 auto
}

</style>
</head>
<body>


<div class="m_ggl">

<div class="m_ylzjxx">
<table class="ggltb">
<tbody><tr>
<td class="ggltd"></td>
<td><h1>幸运大转盘活动开始啦</h1></td>
<td class="ggltd"></td>
</tr>
</tbody></table>
</div>
<br>
<div class="m_ylzjxx">
目前还没人中奖，快来试一试。
</div>
<div class="rotate-content">
						<div class="rotate-con-pan">
							<div id="showbimg" class="rotate-con-zhen"></div>
						</div>
					</div>
<script type="text/javascript">
var prizename = '';
var prizeid = '';
var message = '';
function addPrizer(pid)
{
	var name = document.getElementById('name').value;
	var tel = document.getElementById('tel').value;
	runUrl('bigwheelActionfront!updateRealPrizer?name='+name+'&tel='+tel+'&pid='+pid+'&prizename='+prizename+'&prizeid'+prizeid);
}

function showAndYc(a)
{
	alert(prizename+message);
	document.getElementById("zjtzdiv").style.display='block';
	document.getElementById("showbimg").style.display='none';
}

function ycPrizerAdd(pid)
{
	runUrl('bigwheelActionfront!isCanWheel?pid='+pid);
}

$(function(){
    $(".rotate-con-zhen").rotate({
        bind:{
            click:function(){
                var a = runzp('<s:property value="bigwheel.prizename1"/>','<s:property value="bigwheel.prizename2"/>','<s:property value="bigwheel.prizename3"/>','<s:property value="bigwheel.prizeprob1"/>','<s:property value="bigwheel.prizeprob2"/>','<s:property value="bigwheel.prizeprob3"/>');
                 $(this).rotate({
                        duration:3000,
                        angle: 0, 
                        animateTo:1440+a.angle,
                        easing: $.easing.easeOutSine,
                        callback: function(){
                        }
                 });
                 if(a.isbingo==1)
				 {
				    setTimeout("showAndYc()",3000);
				    prizename = a.prize;
				    prizeid = a.id;
				    message = a.message;
				 }
				 else
				 {
				 	setTimeout("ycPrizerAdd(<s:property value="pid"/>)",2500);
				 }
            }
        }
    });
});
</script>
<div class="m_yljpsm" style="margin-top: 0px;">
<div class="m_yljpsms">
<h2>奖项设置：</h2>

<div class="m_yljpsmnr"> 
	<c:if test="${bigwheel.prize1!=null&&bigwheel.prize1!=''}">
		<s:property value="bigwheel.prize1"/>： <s:property value="bigwheel.prizename1"/> 
			<c:if test="${bigwheel.isshownum==1}">
			数量：<s:property value="bigwheel.prizenumber1"/>
			</c:if>
	</c:if>
</div>
<div class="m_yljpsmnr"> 
	<c:if test="${bigwheel.prize2!=null&&bigwheel.prize2!=''}">
		<s:property value="bigwheel.prize2"/>： <s:property value="bigwheel.prizename2"/> 
			<c:if test="${bigwheel.isshownum==1}">
			数量：<s:property value="bigwheel.prizenumber2"/>
			</c:if>
	</c:if>
</div>
<div class="m_yljpsmnr"> 
	<c:if test="${bigwheel.prize3!=null&&bigwheel.prize3!=''}">
		<s:property value="bigwheel.prize3"/>： <s:property value="bigwheel.prizename3"/> 
			<c:if test="${bigwheel.isshownum==1}">
			数量：<s:property value="bigwheel.prizenumber3"/>
			</c:if>
	</c:if>
</div>
</div>
</div>
<div class="m_yljpsm">
<div class="m_yljpsms">
<h2">活动说明：</h2>
<div class="m_yljpsmnr">您今天还有 <span id="syjhspan"><s:property value="prizer.totimes"/></span> 次参与机会</div>
<div class="m_yljpsmnr">幸运大转盘活动开始啦</div>
</div>
</div>
<input type="hidden" id="hdid" value="2869">
<input type="hidden" id="hdjx" value="0">
<input type="hidden" id="hdjxmc" value="谢谢参与">
<script src="bigwheel/js/hammer.js"></script>
<script src="bigwheel/js/wx.js"></script>

<div id="zjtzdiv" style="display: none;position: fixed;width: 100%; bottom: 0px;z-index:9999;">
<div class="Pop-upbox" id="usermsg">
        <div class="upbox_top">
            <h1>恭喜中奖：</h1>
        </div>
        <div class="upbox_cens">
        <div>
			恭喜获得奖品: 谢谢参与。
			请留下你的手机号码作为领奖依据。<br>
			姓名： <input type="text" id="name"  name="name" class="sinput">
			     <div style="margin-top: 5px;">
			电话：<input type="text" id="tel" name="tel" class="sinput">
			     </div>
			        <div class="upbox_cen">
				            <div class="button_1">
				           	  <a href="javascript:addPrizer(<s:property value="pid"/>)"><div class="button_1"><span>确认信息</span></div></a>
				            </div>
				     </div>
        </div>
		</div>
</div>
<div class="mfooter" id="wxgjfooter" style="text-align: center;width: 100%;height: 20px;line-height: 20px;margin-top:10px;">
</div>
<div style="width: 0px;height: 0px;overflow: hidden;">
</div>

</body>
</html>