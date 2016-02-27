<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!-- Apple devices fullscreen -->
<meta name="apple-mobile-web-app-capable" content="yes" />
<!-- Apple devices fullscreen -->
<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
<base target="mainFrame" />
<link rel="stylesheet" type="text/css" href="css/wm/index.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/bootstrap_min.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/bootstrap_responsive_min.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/style.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/themes.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/todc_bootstrap.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/inside.css" media="all" />
<title>宜兴市城管局宜兴市城管局</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>
<link rel="shortcut icon" href="/favicon.ico" />
</head>
<body class="theme-blue">
<div id="main">
        <div class="row-fluid">
            <div class="span12">
                <div class="box ">
                    <div class="box-title">
                        <h3><i class="icon-user"></i>欢迎信息
						
						</h3>
                    </div>
                    <div class="box-content">

                        <dl class="dl-horizontal">
                            <dt>
                              <!--   <img src="http://img.weimob.com/static/2d/f4/76/image/20131125/20131125093622_45962.png" style="width: 88px; height: 88px" class="img-rounded"></dt> -->
                            <dd style="margin-left: 20px;">
                                <p><strong>${admin.username}</strong>：<b class="text-warning">欢迎您登陆宜兴市城市管理行政执法局公众平台后台管理系统</b>  
                                                                                            
                                                                                                
                                
                                </p>



                                
								
                            </dd>
                        </dl>
                    </div>
                </div>
            </div>
        </div>
<div class="row-fluid">
            <div class="box">

                <div class="box-title">
                    <h3>
                        <i class="icon-rocket"></i>
                        快捷操作
						
                    </h3>
                </div>
                <div class="box-content">
           <div class="block block-tiles block-tiles-animated clearfix">
                        <a href="webkeyword.html" target="mainFrame" class="tile tile-themed">
                            <i class="icon-globe "></i>
                            <div class="tile-info"><strong>微官网</strong></div>
                        </a>
                        
                    </div>
                       
                </div>
            </div>

        </div>
        </div>

<br/><br/><br/></body>
</html>