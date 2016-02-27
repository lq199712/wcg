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
<link rel="stylesheet" href="css/admin/bootstrap.min.css">
<link rel="stylesheet" href="css/admin/admin.css">
<title>账号管理</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>

</head>
<body>
	<div class="main-title">
		<h3>账号管理</h3>
	</div>
	<!-- 
	<div class="alert alert-info">
	  	<p><span class="bold">注意：</span>建筑垃圾准运管理</p>
		<p><span class="bold">提示：</span>信息设置好以后<strong><font color="#FF0000" size="+1">查看</font></strong>即可</p>
	</div>
	 -->
	


<div class="pagination">
<!-- 
   <ul>

    <li class="disabled"><span>上一页</span></li>
  </ul>
  -->
</div>
	<div class="tb-toolbar">
		
		<a href="adminAction!goToAdd" class="btn btn-small btn-primary">新增</a>
		<!-- 
		<button class="btn btn-small" onClick="dellbs('a',this)" id="del">删除</button>
		 -->
	</div>
	<table class="table table-bordered">
			<thead>
				<tr>
					
					<th>编号</th>
					<th>用户名</th>
					<th>权限</th>
					<th>联系电话</th>
					<th>创建日期</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				  <s:iterator value="admins" var="admin" status="index">
			      <tr>
			      		
						<td>
							<s:property value="#index.count"/>
						</td>
						<td><s:property value="username"/></td>
						<td>
						<s:if test="limits==0">
							超级管理员
						</s:if>
						<s:elseif test="limits==1">
							投诉管理员
						</s:elseif>
						<s:elseif test="limits==2">
							新闻管理员
						</s:elseif>
						<s:elseif test="limits==3">
							渣土信息管理员
						</s:elseif>
						</td>
						<td><s:property value="phone"/></td>
						<td><s:date name="createdate" format="yyyy-MM-dd"/></td>
						<td><span>
						<s:if test="ison==1">
							启用
						</s:if>
						<s:else>
							未启用
						</s:else>
						</span></td>
						<td>
						<span>
						[
						<a href="adminAction!load?id=<s:property value="id"/>">修改</a>
						]
						</span>
						
						<span>
						[
						<a href="adminAction!delete?id=<s:property value="id"/>"  onclick="return confirm('你确定删除该信息吗？')">删除</a>
						]
						</span>
						
						</td>
				  </tr>
				  </s:iterator>
						</tbody>
		</table>

	


<div class="pagination" style="text-align: center;height: 25px;">
   <ul>

    <li class="disabled">
    
    <span>
			&nbsp;&nbsp;&nbsp; 
		  <a href="javascript:jumpPage('adminAction!list',1);" target="main">首页</a>&nbsp;&nbsp; 
		  <a href="javascript:jumpPage('adminAction!list',<s:property value="page-1"/>);" target="main">上一页</a>&nbsp;&nbsp;&nbsp; 
		  <a href="javascript:jumpPage('adminAction!list',<s:property value="page+1"/>);" target="main">下一页</a>&nbsp;&nbsp;&nbsp; 
		  <a href="javascript:jumpPage('adminAction!list',<s:property value="pageCount"/>);" target="main">尾页</a>&nbsp;&nbsp;&nbsp;
		  <input type='button' class="coolbg np" onClick="javascript:jumpPage('adminAction!list',document.getElementById('page').value);" value='转到' />
		&nbsp;
		当前页：
		<input onpaste="return false" onKeyPress="checkPage();" id="page" type="text" name="page" value="<s:property value="page"/>" size="2" style="ime-mode=disabled;width:25px; height:16px;line-height:14px; BORDER-RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; FONT-SIZE: 13px; BORDER-LEFT: #cccccc 1px solid; COLOR: #000000; BORDER-BOTTOM: #cccccc 1px solid; FONT-FAMILY: 宋体; BACKGROUND-COLOR: #ffffff;text-align: center;vertical-align:top;"/>
		/共<s:property value="pageCount"/>页
	</span>
    
    </li>
  </ul> 
  
</div>



<div id="gotonext"  >
	<img src="media/images/admin/v3/yuding.png" ></img>
</div>

<br/><br/><br/>
<SCRIPT type="text/javascript">
function jumpPage(url,page){
	var page=page;
	if(isNaN(page)){
		var page2=document.getElementById(page).value;
		page=parseInt(page2);
	}
	
	var url=url+'?page='+page;
	url=encodeURI(url);
	url=encodeURI(url);
	window.location=url;
}
</SCRIPT>

</body></html>