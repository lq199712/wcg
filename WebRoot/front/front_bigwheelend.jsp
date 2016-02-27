<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta name="description" content="微信">
<title>活动已结束</title>
<script type="text/javascript">var yyuc_jspath = "/@system/";</script>
<script type="text/javascript" src="bigwheel/js/jquery.js">
</script><script type="text/javascript" src="bigwheel/js/yyucadapter.js"></script>
<link type="text/css" rel="stylesheet" href="bigwheel/css/activity.css">
</head>

<body class="activity-scratch-end">
    <div class="main">
	    <div class="banner">
            <img src="bigwheel/images/chance-end.jpg">
        </div>
        <div class="content" style=" margin-top:10px">
            <div class="boxcontent">
                <div class="box">
                    <div class="title-red">机会已用完说明：</div>
                    <div class="Detail">
                        <p> 亲，您今日的机会用完了。</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body></html>