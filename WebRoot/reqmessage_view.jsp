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
<title>管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">

</head>
<body leftmargin="8" topmargin="8" >
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：管理&gt;&gt;<a href='reqmessageAction!list?publicaccount=${pubclient.publicaccount }' target='main'>请求消息管理</a>&gt;&gt;查看用户请求消息&nbsp;<a href="javascript:history.back();" style=" color:red;">[返回]</a></div>
  
<!--  内容列表   -->

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="33" colspan="2" align="center">
	<strong>用户请求消息</strong></td>
</tr>


<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">用户ID</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="reqmessage.fromusername" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">消息ID</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="reqmessage.msgid" />
	  </label></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
  <td height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">消息类型</font></strong></td>
  <td align="left" style="padding-left: 50px;">
  			<s:if test="reqmessage.savetype==1">
				文本
			</s:if>
			<s:elseif test="reqmessage.savetype==2">
				图片
			</s:elseif>
			<s:elseif test="reqmessage.savetype==3">
				语音
			</s:elseif>
			<s:elseif test="reqmessage.savetype==4">
				视频
			</s:elseif>
			<s:elseif test="reqmessage.savetype==5">
				地理位置
			</s:elseif>
			<s:elseif test="reqmessage.savetype==6">
				链接
			</s:elseif>
  </td>
</tr>


<s:if test="reqmessage.savetype==1">
	<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
		<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">文本内容</font></strong></td>
		<td width="75%" align="left" style="padding-left: 50px;">
		  <label>
			<s:property value="reqmessage.content" />
		  </label></td>
	</tr>
</s:if>
			<s:elseif test="reqmessage.savetype==2">
				<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
					<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">图片链接</font></strong></td>
					<td width="75%" align="left" style="padding-left: 50px;">
					  <label>
						<s:property value="reqmessage.picurl" />
					  </label></td>
				</tr>
				<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
					<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">媒体ID</font></strong></td>
					<td width="75%" align="left" style="padding-left: 50px;">
					  <label>
						<s:property value="reqmessage.mediaid" />
					  </label></td>
				</tr>
			</s:elseif>
			<s:elseif test="reqmessage.savetype==3">
				<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
					<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">媒体ID</font></strong></td>
					<td width="75%" align="left" style="padding-left: 50px;">
					  <label>
						<s:property value="reqmessage.mediaid" />
					  </label></td>
				</tr>
				<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
					<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">语音格式</font></strong></td>
					<td width="75%" align="left" style="padding-left: 50px;">
					  <label>
						<s:property value="reqmessage.format" />
					  </label></td>
				</tr>
			</s:elseif>
			<s:elseif test="reqmessage.savetype==4">
				<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
					<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">媒体ID</font></strong></td>
					<td width="75%" align="left" style="padding-left: 50px;">
					  <label>
						<s:property value="reqmessage.mediaid" />
					  </label></td>
				</tr>
				<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
					<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">视频缩略图ID</font></strong></td>
					<td width="75%" align="left" style="padding-left: 50px;">
					  <label>
						<s:property value="reqmessage.thumbmediaid" />
					  </label></td>
				</tr>
			</s:elseif>
			<s:elseif test="reqmessage.savetype==5">
				<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
					<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">地理位置纬度</font></strong></td>
					<td width="75%" align="left" style="padding-left: 50px;">
					  <label>
						<s:property value="reqmessage.location_x" />
					  </label></td>
				</tr>
				<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
					<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">地理位置经度</font></strong></td>
					<td width="75%" align="left" style="padding-left: 50px;">
					  <label>
						<s:property value="reqmessage.location_y" />
					  </label></td>
				</tr>
				<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
					<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">地图缩放大小</font></strong></td>
					<td width="75%" align="left" style="padding-left: 50px;">
					  <label>
						<s:property value="reqmessage.scale" />
					  </label></td>
				</tr>
				<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
					<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">地理位置标题</font></strong></td>
					<td width="75%" align="left" style="padding-left: 50px;">
					  <label>
						<s:property value="reqmessage.linklabel" />
					  </label></td>
				</tr>
			</s:elseif>
			<s:elseif test="reqmessage.savetype==6">
				<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
					<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">消息标题</font></strong></td>
					<td width="75%" align="left" style="padding-left: 50px;">
					  <label>
						<s:property value="reqmessage.title" />
					  </label></td>
				</tr>
				<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
					<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">消息描述</font></strong></td>
					<td width="75%" align="left" style="padding-left: 50px;">
					  <label>
						<s:property value="reqmessage.description" />
					  </label></td>
				</tr>
				<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
					<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">消息链接</font></strong></td>
					<td width="75%" align="left" style="padding-left: 50px;">
					  <label>
						<s:property value="reqmessage.url" />
					  </label></td>
				</tr>
			</s:elseif>
<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td width="25%" height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">接收日期</font></strong></td>
	<td width="75%" align="left" style="padding-left: 50px;">
	  <label>
		<s:date name="reqmessage.reqtime" format="yyyy-MM-dd"/>
	  </label></td>
</tr>

</table>

<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td height="29" align="center" valign="bottom">
      <input type='button' class="coolbg np" onClick="javascript:history.back();" value='返回' style="width:80" />&nbsp;&nbsp;</td>
  </tr>
  <tr>
    <td height="18" align="center">&nbsp;</td>
  </tr>
</table>



</body>
</html>