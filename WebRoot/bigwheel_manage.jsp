<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="front/bigwheel/css/bootstrap.min.css">
<link rel="stylesheet" href="front/bigwheel/css/admin.css">
<title>微活动</title><script type="text/javascript">var yyuc_jspath = "/@system/";</script>
<script type="text/javascript" src="front/bigwheel/js/jquery(1).js"></script>
<script type="text/javascript" src="front/bigwheel/js/yyucadapter(1).js"></script>

</head>
<body>
	<div class="main-title">
		<h3>幸运大转盘活动</h3>
	</div>
	<div class="alert alert-info">
	  	<p><span class="bold">注意：</span>如活动已结束，可以考虑删除活动</p>
	</div>
	
	<div class="tb-toolbar">
		
		<a href="bigwheelAction!goToAdd" class="btn btn-small btn-primary">新增</a>
	</div>
	<table class="table table-bordered">
			<thead>
				<tr>
					<th>活动名称</th>
					<th>关键字</th>
					<th>活动时间</th>
					<th>活动状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="bigwheels" var="bigwheel" status="status">	 
			      <tr>
						<td><s:property value="name"/></td>
						<td><s:property value="ikey"/></td>
						<td>
						<s:property value="timestart"/>至<s:property value="timeend"/>						</td>
						<td>
						<span>
							  <c:if test="${bigwheel.currentstate==0}">准备中</c:if>
							  <c:if test="${bigwheel.currentstate==1}">进行中</c:if>
   							  <c:if test="${bigwheel.currentstate==2}">活动已结束</c:if>
						</span>
						</td>
						<td>
						<span>
						[
						<a href="bigwheelAction!load?id=<s:property value="id" />">修改</a>
						]
						</span>
						<span>
						[
						<a href="bigwheelAction!delete?id=<s:property value="id" />" onclick="return confirm('你确定删除该信息吗？')">删除</a>
						]
						</span>
						<span>
						[
						<a href='prizerAction!list?bid=<s:property value="id" />&publicaccount=${pubclient.publicaccount}' target='main'>中奖记录</a>
						]
						</span>
						</td>
				  </tr>
				  </s:iterator>
						</tbody>
		</table>




<div id="gotonext">
	<img src="yizhandaodi.png">
</div>

<br><br><br></body></html>