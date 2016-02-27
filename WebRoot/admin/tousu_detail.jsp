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
<title>投诉管理-详细</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>

<link rel="stylesheet" href="css/admin/bootstrap.min.css">
<link rel="stylesheet" href="css/admin/admin.css">
<style type="text/css">
	table td {
		min-width:50px;
		overflow:hidden;text-overflow:ellipsis;
	}
	#picsethere{
		width: 510px;
		display: block;
	}
	#picsethere img{
		max-width: 500px;
		display: block;
	}
</style>
</head>
<body>

<div align="center" style="margin-top:50px;"><strong><span style="FONT-SIZE: 30px">投诉受理单<br></span><span style="FONT-SIZE: 32px"><br></span></strong>
<table style="WIDTH: 687px; HEIGHT: 1159px" border="1" cellspacing="0" bordercolor="#000000" width="687" align="center" height="1159">
<tbody>
<tr>
<td height="31" width="65" nowrap="">
<div style="TEXT-ALIGN: left" class="STYLE1"><span style="FONT-SIZE: 13px">发起单位</span></div></td>
<td width="215" colspan="3"><span style="FONT-SIZE: 13px"><span class="STYLE1">数字化城管监督指挥中心<input type="hidden" name="DATA_4" value="数字化城管监督指挥中心" title="发起单位">
</span></span></td>
</tr>
<tr>
<td height="33" width="65">
<div style="TEXT-ALIGN: left" class="STYLE1"><span style="FONT-SIZE: 13px">投诉类型</span></div></td>
<td width="215">
<div style="TEXT-ALIGN: left"><span style="FONT-SIZE: 13px"><span class="STYLE1">
	<s:if test="complaint.comptype==1">市容面貌</s:if>
	<s:elseif test="complaint.comptype==2">宣传广告</s:elseif>
	<s:elseif test="complaint.comptype==3">园林绿化</s:elseif>
	<s:elseif test="complaint.comptype==4">黑车</s:elseif>
	<s:elseif test="complaint.comptype==5">城市湖道</s:elseif>
	<s:elseif test="complaint.comptype==6">街面秩序</s:elseif>
	<s:elseif test="complaint.comptype==7">施工管理</s:elseif>
	

<input type="hidden" name="DATA_11"  title="案件类型">
</span></span></div></td>
<td width="62">
<div style="TEXT-ALIGN: left" class="STYLE1"><span style="FONT-SIZE: 13px">投诉日期</span></div></td>
<td width="159"><span style="FONT-SIZE: 13px"><s:property value="complaint.comptime"/><input type="hidden" name="DATA_6"  title="发起日期">
</span></td>
</tr>
<tr>
<td height="34" width="65">
<div style="TEXT-ALIGN: left" class="STYLE1"><span style="FONT-SIZE: 13px">投诉人</span></div></td>
<td width="215">
<div style="TEXT-ALIGN: left"><span style="FONT-SIZE: 13px"><span class="STYLE1"><s:property value="complaint.name"/><input type="hidden" name="DATA_14" value="" title="投诉人">
</span></span></div></td>
<td width="62">
<div style="TEXT-ALIGN: left" class="STYLE1"><span style="FONT-SIZE: 13px">投诉联系电话</span></div></td>
<td width="159"><span style="FONT-SIZE: 13px"><s:property value="complaint.telphone"/> <input type="hidden" name="DATA_16" value="15852744260 " title="投诉联系电话">
</span></td></tr>
<tr>
<td height="70" width="65">
<div style="TEXT-ALIGN: left" class="STYLE1"><span style="FONT-SIZE: 13px">投诉内容</span></div></td>
<td width="720" colspan="3">
<div style="TEXT-ALIGN: left"><span style="FONT-SIZE: 13px"><span class="STYLE1"><s:property value="complaint.content"/> <input type="hidden" name="DATA_18"  title="投诉内容">
</span>&nbsp;</span></div></td></tr>
<tr>
<td height="70" width="65">
<div style="TEXT-ALIGN: left" class="STYLE1"><span style="FONT-SIZE: 13px">投诉照片</span></div></td>
<td colspan="3">
<div style="TEXT-ALIGN: left">
	<img alt="暂无图片" src="<%=basePath%>complaintimage${complaint.image}" id="myimage" width="256px" height="256px" />
</div></td></tr>
</body>
</html>