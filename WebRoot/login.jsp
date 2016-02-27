<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>39MI</title>
		
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta name="renderer" content="webkit">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<LINK rel=stylesheet type=text/css href="login_files/skin.css">
		<LINK rel=stylesheet type=text/css href="login_files/base.css">
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	
}
-->
</style>
		
	<script type="text/javascript" src="js/pageKit.js"></script>
	<script type="text/javascript">
 
 function getCookie(c_name)      //根据分隔符每个变量的值
 {
     if (document.cookie.length > 0) {
         c_start = document.cookie.indexOf(c_name + "=")
         if (c_start != -1) { 
             c_start = c_start + c_name.length + 1;
             c_end = document.cookie.indexOf("^",c_start);
             if (c_end==-1)
                 c_end=document.cookie.length;
             return unescape(document.cookie.substring(c_start,c_end));
     } 
   }
     return "";
 }
 
 function setCookie(c_name, n_value, p_name, p_value, expiredays)        //设置cookie
 {
     var exdate = new Date();
     exdate.setDate(exdate.getDate() + expiredays);
     document.cookie = c_name + "=" + escape(n_value) + "^" + p_name + "=" + escape(p_value) + ((expiredays == null) ? "" : "^;expires=" + exdate.toGMTString());
     console.log(document.cookie)
 }
 
 function checkCookie()      //检测cookie是否存在，如果存在则直接读取，否则创建新的cookie
 {
     
     var username = getCookie('username');
     var password = getCookie('password');
     if (username != null && username != "" && password != null && password != "") {
         
         document.getElementById("username").value = username;
         document.getElementById("password").value = password;
     }
     else {
     	 //document.getElementById("username").value = "";
         document.getElementById("password").value = "";
         
     }
     
 }
 
 function cleanCookie (c_name, p_name) {     //使cookie过期
     document.cookie = c_name + "=" + ";" + p_name + "=" + ";expires=Thu, 01-Jan-70 00:00:01 GMT";
 }
 function checkIsUp(){
	 if(document.getElementById("checkup").checked==true){
		setCookie('username', document.getElementById("username").value, 'password', document.getElementById("password").value, 365);	 
	 }
	 return true;
 }
 </script>
	</head>

	<body class="oa_body" onLoad="checkCookie()">
		<TABLE border=0 cellSpacing=0 cellPadding=0 width=970 
              align=center>
  <TBODY>
    <TR>
      <TD width=208>&nbsp;</TD>
      <TD height=322 vAlign=top background=login_files/center.png 
                width=602><TABLE border=0 cellSpacing=0 cellPadding=0 width="100%">
        <TBODY>
          <TR>
            <TD height=66 width="34%">&nbsp;</TD>
            <TD width="60%">&nbsp;</TD>
            <TD width="6%">&nbsp;</TD>
          </TR>
          <TR>
            <TD height=155>&nbsp;</TD>
            <TD><form action="pubclientAction!login" method="post" onSubmit="return checkIsUp()">
              <TABLE border=0 cellSpacing=0 cellPadding=0 
width="100%">
                <TBODY>
                  <TR>
                    <TD width="18%" align=left><FONT 
                              style="COLOR: #FFF; FONT-SIZE: 15px">用户名：</FONT></TD>
                    <TD height=25 colSpan=3><input name="username" type="text" id="username" value="${loginFail }" style="width: 130" onFocus="this.value=''"></TD>
                  </TR>
                  <TR>
                    <TD align=left><FONT 
                              style="COLOR: #FFF; FONT-SIZE: 15px; ">密码：</FONT></TD>
                    <TD height=25 colSpan=3><input name="password" type="password" id="password" style="width: 130" onFocus="this.select()"></TD>
                  </TR>
                  <TR>
                    <TD align=left><FONT 
                              style="COLOR: #FFF; FONT-SIZE: 15px">验证码：</FONT></TD>
                    <TD height=25 width="34%"><input name="validate" type="text" id="validate" style="width: 70" onFocus="this.select()"></TD>
                    <TD width="29%"><span id="im"> <img src="toolkitAction!validateCode" width="80" height="32" /> </span></TD>
                    <TD width="19%"><font style="font-size: 12px"><a href="javascript:changeImage();" id="aim">看不清</a>
					</font></TD>
                  </TR>
                  <TR>
                    <TD>&nbsp;</TD>
                    <TD height=38 colSpan=3><INPUT class="coolbg np" onClick="" value="登 陆" type="submit">
                      &nbsp;&nbsp;
                      <INPUT class="coolbg np" onClick="" value="取 消" type="reset">&nbsp;&nbsp;
                      <input type="checkbox" name="checkup" id="checkup">
                      记住密码</TD>
                  </TR>
                </TBODY>
              </TABLE>
            </FORM></TD>
            <TD>&nbsp;</TD>
          </TR>
          <TR>
            <TD height=30 colSpan=3 >&nbsp;</TD>
          </TR>
        </TBODY>
      </TABLE></TD>
      <TD width=160>&nbsp;</TD>
    </TR>
  </TBODY>
</TABLE>

	</body>
</html>
