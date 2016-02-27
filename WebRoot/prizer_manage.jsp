<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" href="front/bigwheel/css/bootstrap.min.css">
<link rel="stylesheet" href="front/bigwheel/css/admin.css">
<title>微活动</title><script type="text/javascript">var yyuc_jspath = "/@system/";</script>
<script type="text/javascript" src="front/bigwheel/js/jquery.js"></script>
<script type="text/javascript" src="front/bigwheel/js/yyucadapter.js"></script>
<script type="text/javascript" src="js/pageKit.js"></script>
<link href="front/bigwheel/css/WdatePicker.css" rel="stylesheet" type="text/css"></head>
<body>
	<div class="main-title">
		<h3>幸运大转盘-中奖查询</h3>
	</div>
	<form name="form2" action="prizerAction!list" method="post">
		<table width="50%" border="0" align="center" cellpadding="0" cellspacing="0">
    	 <tr>
	        <td width="25%" align="right" style="padding-right: 50px;">
	        	<s:select list="#{0:'选择类型',1:'领奖状态',2:'获得奖项'}" name="con" listKey="key" listValue="value" style="margin-top: 10px;width:100px;"></s:select>领奖状态:0 未领取 1 已领取
	        </td>
	        <td width="20%">
				<s:textfield name="convalue" maxlength="25"></s:textfield>
			</td>
	        <td width="5%">
	             <input type="submit"  onClick="" value='查 询' />
	        </td>
	        <td width="5%">
	             <input type="reset"  onClick="" value='重 置' />
	        </td>
	      </tr>
	    </table>
	<div><s:hidden name="publicaccount" value="%{#session.pubclient.publicaccount}"/></div>
	<table class="table table-bordered">
			<thead>
				<tr>
					<th>编号</th>
					<th>用户名称</th>
					<th>微信用户名</th>
					<th>用户电话</th>
					<th>获得奖项</th>
					<th>参与时间</th>
					<th>备注</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			<s:if test="%{prizers.size()==0}">
				<td colspan="8" align="center">
					暂无该信息
				</td>
			</s:if>
			<s:iterator value="prizers" var="prizer" status="status">
				<tr>
					<td><s:property value="#status.count" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="wxname" /></td>
					<td><s:property value="tel" /></td>
					<td><s:property value="prize" /></td>
					<td><s:property value="time" /></td>
					<td>
						 <c:if test="${prizer.awardstate==0}">未领取</c:if>
						 <c:if test="${prizer.awardstate==1}">已领取</c:if>
					</td>
					<td>
					<span>
					[
					<a href="prizerAction!update?id=<s:property value="id" />&bid=<s:property value="bid" />" onclick="return confirm('你确定要修改领奖状态吗？')">修改领奖状态</a>
					]
					</span>
					<span>
					[
					<a href="prizerAction!delete?id=<s:property value="id" />&bid=<s:property value="bid" />" onclick="return confirm('你确定删除该信息吗？')">删除</a>
					]
					</span>
					</td>
				</tr>
			</s:iterator>
			</tbody>
			<thead>
				<tr>
					<td height="34" colspan="8" style="text-align: center;vertical-align: middle;">记录数：<s:property value="totalCount" />
					  &nbsp;&nbsp;&nbsp; 
					  <a href="javascript:jumpPublicPageBig('prizerAction!list',1,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>',<s:property value="bid"/>);" target="main">首页</a>&nbsp;&nbsp; 
					  <a href="javascript:jumpPublicPageBig('prizerAction!list',<s:property value="page-1"/>,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>',<s:property value="bid"/>);" target="main">上一页</a>&nbsp;&nbsp;&nbsp; 
					  <a href="javascript:jumpPublicPageBig('prizerAction!list',<s:property value="page+1"/>,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>',<s:property value="bid"/>);" target="main">下一页</a>&nbsp;&nbsp;&nbsp; 
					  <a href="javascript:jumpPublicPageBig('prizerAction!list',<s:property value="pageCount"/>,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>',<s:property value="bid"/>);" target="main">尾页</a>&nbsp;&nbsp;&nbsp;
					  <input type='button' class="coolbg np" onClick="javascript:jumpPublicPageBig('prizerAction!list',document.getElementById('page').value,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>',<s:property value="bid"/>);" value='转到' />
					&nbsp;
					当前页：<input onpaste="return false" onKeyPress="checkPage();" id="page" type="text" name="page" value="<s:property value="page"/>" size="2" style="ime-mode=disabled;width:25px; height:20px;line-height:18px; BORDER-RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; FONT-SIZE: 13px; BORDER-LEFT: #cccccc 1px solid; COLOR: #000000; BORDER-BOTTOM: #cccccc 1px solid; FONT-FAMILY: 宋体; BACKGROUND-COLOR: #ffffff;"/>
					/共<s:property value="pageCount"/>页
					</td>
				</tr>
			</thead>
		</table>
	
</form>
</body>
</html>