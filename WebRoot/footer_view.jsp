<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>微官网</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">

<script type="text/javascript" src="js/pageKit.js"></script></head>
<body leftmargin="8" topmargin="8" >
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：微官网&gt;&gt;<a href='footerAction!list?publicaccount=${pubclient.publicaccount }' target='main'>页脚管理</a>&gt;&gt;页脚信息&nbsp;<a href="javascript:history.back();" style=" color:red;">[返回]</a></div>
  
<!--  内容列表   -->

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="33" colspan="2" align="center"><strong>页脚信息</strong>
	</td>
</tr>


<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
	<td width="75%" height="50px" align="center" colspan="2">
	  <label>
		<s:property value="footer.foottitle"/>
	  </label></td>
</tr>




<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25" >
  <td width="75%" height="50px" align="center" colspan="2">
	  <label>
		<s:if test="footer.isshow==1">
	  		显示
	  	</s:if>
	  	<s:else>
	  		不显示
	  	</s:else>
	  </label>
  	
</td>
</tr>

</table>

<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td height="29" align="center" valign="bottom">
    	<input type='button' class="coolbg np" onClick="javascript:window.location.href='footerAction!load?id=<s:property value="footer.id"/>'" value='修改' style="width:80" />
    	&nbsp;&nbsp;
      	<input type='button' class="coolbg np" onClick="javascript:history.back();" value='返回' style="width:80" />
      	&nbsp;&nbsp;
    </td>
  </tr>
  <tr>
    <td height="18" align="center">&nbsp;</td>
  </tr>
</table>



</body>
</html>