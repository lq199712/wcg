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
<title>宜兴市城管局</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>
<link rel="shortcut icon" href="favicon.ico" />
</head>
<body class="theme-blue">
	<div id="main">
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <div class="box">
                        <div class="box-title">
                            <div class="span10">
                                <h3><i class="icon-edit"></i>修改密码</h3>
                            </div>
                            <div class="span2">
                                <a class="btn" href="javascript:window.history.go(-1);">返回</a>
                            </div>
                        </div>
                        <div class="box-content">
                                                    <form action="adminAction!upMyPwd" method="post" class="form-horizontal form-validate" id="pwdform" >
                                <div class="control-group">
                                    <label class="control-label" for="old_password">原始密码</label>
                                    <div class="controls">
                                    	<input type="hidden" name="username" value="${admin.username}"/>
                                        <input type="password" name="oldpwd" id="oldpwd" data-rule-required="true" data-rule-rangelength="[1,16]" />
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="new_password">设置密码</label>
                                    <div class="controls">
                                        <input type="password" name="newpwd" id="newpwd" data-rule-required="true" data-rule-rangelength="[6,16]" />
                                        <span class="maroon">*</span><span class="help-inline">长度为6~16位字符</span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="repassword">确认密码</label>
                                    <div class="controls">
                                        <input type="password" name="againpwd" id="againpwd" data-rule-required="true" data-rule-equalto="#new_password">
                                    </div>
                                </div>
                                <div class="form-actions" id="btn_box">
                                	<s:token></s:token>
                                    <button id="submit-btn" type="button" data-loading-text="提交中..." class="btn btn-primary" onclick="checkform();">保存</button>
                                    <button class="btn" type="button" onclick="javascript:window.history.go(-1);">取消</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<script type="text/javascript">
	function checkform(){
		var oldpwd = document.getElementById("oldpwd");
		var newpwd = document.getElementById("newpwd");
		var againpwd = document.getElementById("againpwd");
		if(oldpwd.value.length==0||oldpwd.value==''){
			alert("原始密码不能为空");
			oldpwd.value="";
			oldpwd.focus();
			return false;
		}
		if(newpwd.value.length==0||newpwd.value==''){
			alert("新密码不能为空");
			newpwd.value="";
			newpwd.focus();
			return false;
		}
		if(againpwd.value.length==0||againpwd.value==''){
			alert("确认密码不能为空");
			againpwd.value="";
			againpwd.focus();
			return false;
		}
		if(newpwd.value!=againpwd.value){
			alert("两次密码输入不一致");
			newpwd.value="";
			againpwd.value="";
			newpwd.focus();
			return false;
		}
		document.getElementById('pwdform').submit();
	}

	</script>
<br/><br/><br/></body>
</html>