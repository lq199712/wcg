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
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/pageKit.js"></script></head>
<body leftmargin="8" topmargin="8" >
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：管理>>请求消息管理</div>
  
<!--  内容列表   -->
<form name="form2" action="reqmessageAction!list" method="post">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#8BC7F1" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="33" colspan="6" align="center">&nbsp;<b>请求消息管理</b>&nbsp;
	<s:hidden name="publicaccount" value="%{#session.pubclient.publicaccount}"></s:hidden>
	</td>
</tr>
<tr bgcolor="#E7E7E7">
  <td height="33" colspan="6" bgcolor="#FFFFE5"><table width="600" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="15%" align="right" style="padding-right: 50px;">
        	<s:select list="#{1:'日期'}" name="con" listKey="key" listValue="value" cssStyle="width:120px"></s:select>
        </td>
        <td width="25%">
			<s:textfield name="convalue" id="start" class="Wdate" onfocus="new WdatePicker(this)"  cssStyle="width:80%"/>
		</td>
        <td width="5%">
             <input type="submit" class="coolbg np" onClick="" value='查 询' />
    
        </td>
        <td width="5%">
             <input type="reset" class="coolbg np" onClick="" value='重 置' />
        </td>
      </tr>
    </table></td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="5%" align="center">序号</td>
	<td width="20%" align="center">消息ID</td>
	<td width="40%" align="center">用户ID</td>
	<td width="10%" align="center">消息类型</td>
	<td width="15%" align="center">接收日期</td>
	<td width="10%" align="center">删除</td>
	</tr>
	<s:if test="%{reqmessages.size()==0}">
				<td colspan="6" align="center">
					暂无该信息
				</td>
			</s:if>
<s:iterator value="reqmessages" var="reqmessage" status="status">
	<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
		<td><s:property value="#status.count" /></td>
		<td><a href="reqmessageAction!view?id=<s:property value="id"/>"><s:property value="msgid" /></a></td>
	    <td><s:property value="fromusername" /></td>
		<td>
			<s:if test="savetype==1">
				文本
			</s:if>
			<s:elseif test="savetype==2">
				图片
			</s:elseif>
			<s:elseif test="savetype==3">
				语音
			</s:elseif>
			<s:elseif test="savetype==4">
				视频
			</s:elseif>
			<s:elseif test="savetype==5">
				地理位置
			</s:elseif>
			<s:elseif test="savetype==6">
				链接
			</s:elseif>
		</td>
		<td><s:date name="reqtime" format="yyyy-MM-dd" /></td>
		<td><a href="reqmessageAction!delete?id=<s:property value="id" />" onclick="return confirm('你确定删除该信息吗？')"><img src="skin/images/frame/huiwu_2.gif" width="20" height="20" border="0"></a></td>
	</tr>
</s:iterator>

<tr align="right" bgcolor="#EEF4EA">
  
  <td height="34" colspan="6" align="center">记录数：<s:property value="totalCount" />
  &nbsp;&nbsp;&nbsp; 
  <a href="javascript:jumpPublicPage('reqmessageAction!list',1,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');" target="main">首页</a>&nbsp;&nbsp; 
  <a href="javascript:jumpPublicPage('reqmessageAction!list',<s:property value="page-1"/>,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');" target="main">上一页</a>&nbsp;&nbsp;&nbsp; 
  <a href="javascript:jumpPublicPage('reqmessageAction!list',<s:property value="page+1"/>,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');" target="main">下一页</a>&nbsp;&nbsp;&nbsp; 
  <a href="javascript:jumpPublicPage('reqmessageAction!list',<s:property value="pageCount"/>,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');" target="main">尾页</a>&nbsp;&nbsp;&nbsp;
  <input type='button' class="coolbg np" onClick="javascript:jumpPublicPage('reqmessageAction!list',document.getElementById('page').value,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');" value='转到' />
&nbsp;
当前页：
<input onpaste="return false" onKeyPress="checkPage();" id="page" type="text" name="page" value="<s:property value="page"/>" size="2" style="ime-mode=disabled;width:25px; height:20px;line-height:18px; BORDER-RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; FONT-SIZE: 13px; BORDER-LEFT: #cccccc 1px solid; COLOR: #000000; BORDER-BOTTOM: #cccccc 1px solid; FONT-FAMILY: 宋体; BACKGROUND-COLOR: #ffffff;"/>
/共<s:property value="pageCount"/>页</td>
  
</tr>
</table>

</form>

</body>
</html>