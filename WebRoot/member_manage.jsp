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
<title>微会员</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">

<script type="text/javascript" src="js/pageKit.js"></script></head>
<body leftmargin="8" topmargin="8" >
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：微会员>>会员信息</div>
  
<!--  内容列表   -->
<form name="form2" action="memberAction!list" method="post">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#8BC7F1" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="33" colspan="7" align="center">&nbsp;<b>微会员</b>&nbsp;
	<s:hidden name="publicaccount" value="%{#session.pubclient.publicaccount}"></s:hidden>
	</td>
</tr>
<tr bgcolor="#E7E7E7">
  <td height="33" colspan="7" bgcolor="#FFFFE5"><table width="600" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="30%">
        	<s:select list="#{0:'选择类型',1:'姓名',2:'手机号码'}" name="con" listKey="key" listValue="value" cssStyle="width:150px"></s:select>
        </td>
        <td width="44%">
			<s:textfield name="convalue" cssStyle="width:80%"></s:textfield>
		</td>
        <td width="13%">
             <input type="submit" class="coolbg np" onClick="" value='查 询' />
    
        </td>
        <td width="13%">
             <input type="reset" class="coolbg np" onClick="" value='重 置' />
        </td>
      </tr>
    </table></td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="5%" align="center">序号</td>
    <td width="20%" align="center">真实名称</td>
    <td width="30%" align="center">手机号码</td>
	<td width="10%" align="center">积分</td>
    <td width="15%" align="center">创建日期</td>
	<td width="10%" align="center">修改积分</td>
	<td width="10%" align="center">删除</td>
	</tr>
	<s:if test="%{members.size()==0}">
				<td colspan="7" align="center">
					暂无该信息
				</td>
			</s:if>
<s:iterator value="members" var="member" status="status">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><s:property value="#status.count" /></td>
    <td><s:property value="realname" /></td>
    <td><s:property value="phone" /></td>
	<td><s:property value="credit" /></td>
	<td><s:date name="createdate" format="yyyy-MM-dd"/></td>
	<td><a href="memberAction!load?id=<s:property value="id" />"><img src="skin/images/frame/huiwu_3.gif" width="20" height="20" border="0"></a></td>
	<td><a href="memberAction!delete?id=<s:property value="id" />" onclick="return confirm('你确定删除该会员吗？')"><img src="skin/images/frame/huiwu_2.gif" width="20" height="20" border="0"></a></td>
	</tr>
</s:iterator>

<tr align="right" bgcolor="#EEF4EA">
  
  <td height="34" colspan="7" align="center">记录数：<s:property value="totalCount" />
  &nbsp;&nbsp;&nbsp; 
  <a href="javascript:jumpPublicPage('memberAction!list',1,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');" target="main">首页</a>&nbsp;&nbsp; 
  <a href="javascript:jumpPublicPage('memberAction!list',<s:property value="page-1"/>,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');" target="main">上一页</a>&nbsp;&nbsp;&nbsp; 
  <a href="javascript:jumpPublicPage('memberAction!list',<s:property value="page+1"/>,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');" target="main">下一页</a>&nbsp;&nbsp;&nbsp; 
  <a href="javascript:jumpPublicPage('memberAction!list',<s:property value="pageCount"/>,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');" target="main">尾页</a>&nbsp;&nbsp;&nbsp;
  <input type='button' class="coolbg np" onClick="javascript:jumpPublicPage('memberAction!list',document.getElementById('page').value,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');" value='转到' />
&nbsp;
当前页：
<input onpaste="return false" onKeyPress="checkPage();" id="page" type="text" name="page" value="<s:property value="page"/>" size="2" style="ime-mode=disabled;width:25px; height:20px;line-height:18px; BORDER-RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; FONT-SIZE: 13px; BORDER-LEFT: #cccccc 1px solid; COLOR: #000000; BORDER-BOTTOM: #cccccc 1px solid; FONT-FAMILY: 宋体; BACKGROUND-COLOR: #ffffff;"/>
/共<s:property value="pageCount"/>页</td>
  
</tr>
</table>

</form>

</body>
</html>