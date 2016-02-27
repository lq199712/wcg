<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>39MI-宜兴微定制</title>
<link rel="stylesheet" href="skin/css/base.css" type="text/css" />
<link rel="stylesheet" href="skin/css/menu.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language='javascript'>var curopenItem = '1';</script>
<script language="javascript" type="text/javascript" src="skin/js/frame/menu.js"></script>
<base target="main" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style></head>
<body target="main">
<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
  <tr>
    <td style='padding-left:3px;padding-top:8px' valign="top">
	<!-- Item 1 Strat -->
	
      <dl class='bitem'>
        <dt onClick='showHide("items1_1")'><b>回复功能</b></dt>
        <dd style='display:block' class='sitem' id='items1_1'>
          <ul class='sitemu'>
            <li><a href='guanzhuresAction!view?publicaccount=${pubclient.publicaccount }' target='main'>关注回复</a></li>
            <li><a href='autoresAction!view?publicaccount=${pubclient.publicaccount }' target='main'>自动回复</a></li>
            <li><a href='publickeyAction!view?publicaccount=${pubclient.publicaccount }' target='main'>关键词回复</a></li>
            <li><a href='custommenuAction!view?publicaccount=${pubclient.publicaccount }' target='main'>自定义菜单</a></li>
            
          </ul>
        </dd>
      </dl>
     
      <!-- Item 1 End -->
	  
	  
      <!-- Item 2 Strat -->
      
      <dl class='bitem'>
        <dt onClick='showHide("items2_1")'><b>管理</b></dt>
        <dd style='display:block' class='sitem' id='items2_1'>
          <ul class='sitemu'>
            <li><a href='pubclientAction!clientview?id=${pubclient.id }' target='main'>公众号管理</a></li>
          
            <li><a href='reqmessageAction!list?publicaccount=${pubclient.publicaccount }' target='main'>用户消息管理</a></li>
            <!-- 
            <li><a href='main.jsp' target='main'>消息回复管理</a></li>
              -->
            <li><a href='fodderAction!list?publicaccount=${pubclient.publicaccount }&status=1' target='main'>素材管理</a></li>
           
          </ul>
        </dd>
      </dl>
       
      <!-- Item 2 End -->
	  
	  
	  
	  <!-- Item 3 Strat -->
      <dl class='bitem'>
        <dt onClick='showHide("items3_1")'><b>微官网</b></dt>
        <dd style='display:block' class='sitem' id='items3_1'>
          <ul class='sitemu'>
          <!-- 
            <li><a href='screenimgAction!imglist?publicaccount=${pubclient.publicaccount }' target='main'>全屏轮播</a></li>
            <li><a href='footerAction!view?publicaccount=${pubclient.publicaccount }' target='main'>版权信息</a></li>
            -->
            <li><a href='bigtypeAction!list?publicaccount=${pubclient.publicaccount }' target='main'>首页类别</a></li>
            <li><a href='sontypeAction!list?status=1&publicaccount=${pubclient.publicaccount }' target='main'>子页类别</a></li>
            <li><a href='pagearticleAction!list1?status=1&publicaccount=${pubclient.publicaccount }' target='main'>活动管理</a></li>
            <li><a href='pagearticleAction!list2?status=2&publicaccount=${pubclient.publicaccount }' target='main'>服务管理</a></li>
            <li><a href='pagearticleAction!list3?status=3&publicaccount=${pubclient.publicaccount }' target='main'>设计师管理</a></li>
            <li><a href='pagearticleAction!list4?status=4&publicaccount=${pubclient.publicaccount }' target='main'>头版文章管理</a></li>
          </ul>
        </dd>
      </dl>
      <!-- Item 3 End -->
	  
	  
	  <!-- Item 4 Strat -->
	  
      <dl class='bitem'>
        <dt onClick='showHide("items4_1")'><b>微会员</b></dt>
        <dd style='display:block' class='sitem' id='items4_1'>
          <ul class='sitemu'>
          	<li><a href='memberAction!list?publicaccount=${pubclient.publicaccount }' target='main'>会员信息</a></li>
          </ul>
        </dd>
      </dl>
       
      <!-- Item 4 End -->
	  
	  
	  
	  
	  <!-- Item 6 Strat -->
	  <!-- 
      <dl class='bitem'>
        <dt onClick='showHide("items6_1")'><b>微相册</b></dt>
        <dd style='display:block' class='sitem' id='items6_1'>
          <ul class='sitemu'>
            <li><a href='phototypeAction!list?publicaccount=${pubclient.publicaccount }' target='main'>相册类别</a></li>
			<li><a href='photoAction!imglist?publicaccount=${pubclient.publicaccount }' target='main'>照片管理</a></li>
          </ul>
        </dd>
      </dl>
       -->
      <!-- Item 6 End -->
	  
      <!-- Item 7 Strat -->
      <s:if test="%{#session.pubclient.limits==0}">
      <dl class='bitem'>
        <dt onClick='showHide("items7_1")'><b>公众平台管理</b></dt>
        <dd style='display:block' class='sitem' id='items7_1'>
          <ul class='sitemu'>
            <li><a href='pubclientAction!list' target='main'>公众账号管理</a></li>
          </ul>
        </dd>
      </dl>
      </s:if>
      <!-- Item 8 End -->
      <dl class='bitem'>
        <dt onClick='showHide("items8_1")'><b>微信活动</b></dt>
        <dd style='display:block' class='sitem' id='items8_1'>
          <ul class='sitemu'>
            <li><a href='bigwheelAction!list?publicaccount=${pubclient.publicaccount }' target='main'>大转盘</a></li>
          </ul>
        </dd>
      </dl>
      
	  
	  </td>
  </tr>
</table>
</body>
</html>