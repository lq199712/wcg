<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>39MI-宜兴微定制</title>
<link href="skin/css/base.css" rel="stylesheet" type="text/css">
<link href="skin/css/top.css"  rel="stylesheet" type="text/css">
<script language=JavaScript>
function logout(){
	if(confirm("你确定退出管理系统吗？")){
		parent.location.href = "login.jsp";
	}
	
	
}

</script>
<script language='javascript'>
var preFrameW = '206,*';
var FrameHide = 0;
var curStyle = 1;
var totalItem = 9;
function ChangeMenu(way){
	var addwidth = 10;
	var fcol = top.document.all.btFrame.cols;
	if(way==1) addwidth = 10;
	else if(way==-1) addwidth = -10;
	else if(way==0){
		if(FrameHide == 0){
			preFrameW = top.document.all.btFrame.cols;
			top.document.all.btFrame.cols = '0,*';
			FrameHide = 1;
			return;
		}else{
			top.document.all.btFrame.cols = preFrameW;
			FrameHide = 0;
			return;
		}
	}
	fcols = fcol.split(',');
	fcols[0] = parseInt(fcols[0]) + addwidth;
	top.document.all.btFrame.cols = fcols[0]+',*';
}


function mv(selobj,moveout,itemnum)
{
   if(itemnum==curStyle) return false;
   if(moveout=='m') selobj.className = 'itemsel';
   if(moveout=='o') selobj.className = 'item';
   return true;
}

function changeSel(itemnum)
{
  curStyle = itemnum;
  for(i=1;i<=totalItem;i++)
  {
     if(document.getElementById('item'+i)) document.getElementById('item'+i).className='item';
  }
  document.getElementById('item'+itemnum).className='itemsel';
}

</script>
<style>
body { padding:0px; margin:0px; }
#tpa {
	color: #009933;
	margin:0px;
	padding:0px;
	float:right;
	padding-right:10px;
}

#tpa dd {
	margin:0px;
	padding:0px;
	float:left;
	margin-right:2px;
}

#tpa dd.ditem {
	margin-right:8px;
}

#tpa dd.img {
  padding-top:6px;
}

div.item
{
  text-align:center;
	background:url(skin/images/frame/topitembg.gif) 0px 3px no-repeat;
	width:82px;
	height:26px;
	line-height:28px;
}

.itemsel {
  width:80px;
  text-align:center;
  background:#226411;
	border-left:1px solid #c5f097;
	border-right:1px solid #c5f097;
	border-top:1px solid #c5f097;
	height:26px;
	line-height:28px;
}

*html .itemsel {
	height:26px;
	line-height:26px;
}

a:link,a:visited {
 text-decoration: underline;
}

.item a:link, .item a:visited {
	font-size: 12px;
	color: #ffffff;
	text-decoration: none;
	font-weight: bold;
}

.itemsel a:hover {
	color: #ffffff;
	font-weight: bold;
	border-bottom:2px solid #E9FC65;
}

.itemsel a:link, .itemsel a:visited {
	font-size: 12px;
	color: #ffffff;
	text-decoration: none;
	font-weight: bold;
}

.itemsel a:hover {
	color: #ffffff;
	border-bottom:2px solid #E9FC65;
}

.rmain {
  padding-left:10px;
  /* background:url(skin/images/frame/toprightbg.gif) no-repeat; */
}
</style>
</head>
<body bgColor='#ffffff'>
<div class="top_all">
 <div class="top_tq"><div class="top_tq_txt"><iframe src="http://m.weather.com.cn/m/pn6/weather.htm?id=101190203T " width="180" height="25" marginwidth="0" marginheight="0&quot;" hspace="0" vspace="0" frameborder="0" scrolling="no" allowtransparency="true"></iframe></div></div>
 <div class="top_rig">
   <div class="top_tz_wel"><span style="padding-right:10px;line-height:26px; color:#FFF; font-size:14px">您好,欢迎使用39MI-微信公众平台后台管理系统!
          [<a href="main.jsp" target="main">平台主页</a>]
          
    [<a href="javascript:void(0)" onClick="logout()">注销退出</a>]&nbsp;</span></div>
   <div class="top_tz">
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
       <tr>
         <td width="5%"><img src="skin/images/frame/dot/9.gif" width="24" height="24" /></td>
         <td width="12%" ><font color="#356DA6">系统通知：</font></td>
         <td width="83%">${pubclient.username },欢迎您进入39MI-微信公众平台后台管理系统!</td>
       </tr>
     </table>
   </div>
 </div>
</div>
</body>
</html>