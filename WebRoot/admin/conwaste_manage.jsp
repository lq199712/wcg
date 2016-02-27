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
<title>建筑垃圾准运管理</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>

</head>
<body>
	<div class="main-title">
		<h3>建筑垃圾准运管理</h3>
	</div>
	<div class="alert alert-info">
	  	<p><span class="bold">注意：</span>建筑垃圾准运管理</p>
		<p><span class="bold">提示：</span>信息设置好以后<strong><font color="#FF0000" size="+1">查看</font></strong>即可</p>
	</div>
	
	


<div class="pagination">
<!-- 
   <ul>

    <li class="disabled"><span>上一页</span></li>
  </ul>
  -->
</div>
	<div class="tb-toolbar">
		
		<a href="conwasteAction!goToAdd" class="btn btn-small btn-primary">新增</a>
		<!-- 
		<button class="btn btn-small" onClick="dellbs('a',this)" id="del">删除</button>
		 -->
	</div>
	<table class="table table-bordered">
			<thead>
				<tr>
					
					<th>编号</th>
					<th>准运单位</th>
					<th>负责人</th>
					<th>联系电话</th>
					<th>车辆数量</th>
					<th>车牌号码</th>
					<th>运输线路</th>
					<th>运输时限</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				  <s:iterator value="conwastes" var="conwaste" status="index">
			      <tr>
			      		
						<td>
							<s:property value="#index.count"/>
						</td>
						<td><s:property value="unit"/></td>
						<td><s:property value="person"/></td>
						<td><s:property value="phone"/></td>
						<td><s:property value="sum"/></td>
						<td><s:property value="carnumber"/></td>
						<td><s:property value="line"/></td>
						<td>
							<s:property value="timelimit"/>
						</td>
						<td><span>
						<s:if test="status==1">
							已审核
						</s:if>
						<s:else>
							<a href="conwasteAction!shenhe?id=<s:property value="id"/>"  onclick="return confirm('你确定审核通过吗？')">未审核</a>
						</s:else>
						</span></td>
						<td>
						<span>
						[
						<a href="conwasteAction!load?id=<s:property value="id"/>">修改</a>
						]
						</span>
						
						<span>
						[
						<a href="conwasteAction!delete?id=<s:property value="id"/>"  onclick="return confirm('你确定删除该信息吗？')">删除</a>
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
		  <a href="javascript:jumpConPage('conwasteAction!list',1);" target="main">首页</a>&nbsp;&nbsp; 
		  <a href="javascript:jumpConPage('conwasteAction!list',<s:property value="page-1"/>);" target="main">上一页</a>&nbsp;&nbsp;&nbsp; 
		  <a href="javascript:jumpConPage('conwasteAction!list',<s:property value="page+1"/>);" target="main">下一页</a>&nbsp;&nbsp;&nbsp; 
		  <a href="javascript:jumpConPage('conwasteAction!list',<s:property value="pageCount"/>);" target="main">尾页</a>&nbsp;&nbsp;&nbsp;
		  <input type='button' class="coolbg np" onClick="javascript:jumpConPage('conwasteAction!list',document.getElementById('page').value);" value='转到' />
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
function jumpConPage(url,page){
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