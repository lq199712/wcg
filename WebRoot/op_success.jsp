<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>39MI-宜兴微定制</title>
<base target="_self">
<link rel="stylesheet" type="text/css" href="skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="skin/css/main.css" />
<script type="text/javascript">     
function countDown(secs,surl){     
 //alert(surl);     
 surl = surl.replace("&amp;","&");
 var jumpTo = document.getElementById('jumpTo');
 jumpTo.innerHTML=secs;  
 if(--secs>0){
     setTimeout("countDown("+secs+",'"+surl+"')",1000);     
     }
 else{       
     location.href=surl;     
     }     
 }     
</script>
</head>
<body leftmargin="8" topmargin='8'>
<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><div style='float:left'> <img height="14" src="skin/images/frame/book1.gif" width="20" />&nbsp;微城管后台管理系统 </div>
      <div style='float:right;padding-right:8px;'>
        <!--  //保留接口  -->
      </div></td>
  </tr>
  <tr>
    <td height="1" background="skin/images/frame/sp_bg.gif" style='padding:0px'></td>
  </tr>
</table>
<table width="98%" align="center" border="0" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px;margin-top:8px;">
  <tr>
    <td background="skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'><span>消息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td>恭喜您，操作成功！&nbsp;<span id="jumpTo">5</span>秒后跳转到<a href="<s:property value="arg[0]"/>"><s:property value="arg[1]"/></a>页面&nbsp;</td>
  	<script type="text/javascript">countDown(5,'<s:property value="arg[0]"/>');</script>
  </tr>
</table>
<!-- 
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr>
    <td colspan="2" background="skin/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'>
    	<div style='float:left'><span>快捷操作</span></div>
    	<div style='float:right;padding-right:10px;'></div>
   </td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="30" colspan="2" align="center" valign="bottom"><table width="100%" border="0" align="center" cellpadding="1" cellspacing="1">
        <tr>
          <td width="15%" height="31" align="center"><img src="skin/images/frame/qc.gif" width="90" height="30" /></td>
          <td width="85%" valign="bottom">
            
            <div class='icoitem'>
              <div class='ico'><img src='skin/images/frame/manage1.gif' width='16' height='16' /></div>
              <div class='txt'><a href='noticeAction!list' target="main"><u>通知公告</u></a></div>
            </div>
            <div class='icoitem'>
              <div class='ico'><img src='skin/images/frame/menuarrow.gif' width='16' height='16' /></div>
              <div class='txt'><a href='email.jsp' target="main"><u>内部邮件</u></a></div>
            </div>
            
            <div class='icoitem'>
              <div class='ico'><img src='skin/images/frame/file_dir.gif' width='16' height='16' /></div>
              <div class='txt'><a href='depinfoAction!list?depid=${ps.dep.id}' target="main"><u>部门信息</u></a></div>
            </div>
            <div class='icoitem'>
              <div class='ico'><img src='skin/images/frame/addnews.gif' width='16' height='16' /></div>
              <div class='txt'><a href='workreport.jsp' target="main"><u>工作报告</u></a></div>
            </div>
            <div class='icoitem'>
              <div class='ico'><img src='skin/images/frame/part-index.gif' width='16' height='16' /></div>
              <div class='txt'><a href='workshoufaAction!list?sfkind=2&pid=${ps.id}' target="main"><u>收文管理</u></a></div>
            </div>
            <div class='icoitem'>
              <div class='ico'><img src='skin/images/frame/manage1.gif' width='16' height='16' /></div>
              <div class='txt'><a href='affairsAction!list?pid=1' target="main"><u>个人申请记录</u></a></div>
            </div></td>
        </tr>
    </table></td>
  </tr>
</table>
 -->
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr bgcolor="#EEF4EA">
    <td colspan="2" background="skin/images/frame/wbg.gif" class='title'><span>系统基本信息</span></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="25%" bgcolor="#FFFFFF">感谢您的使用：</td>
    <td width="75%" bgcolor="#FFFFFF">
		管理员
	</td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td>系统版本信息：</td>
    <td>wcg_v1.0</td>
  </tr>
</table>
</body>
</html>