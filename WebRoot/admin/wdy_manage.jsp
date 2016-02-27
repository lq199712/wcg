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
<title>微调研管理</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>

</head>
<body>
	<div class="main-title">
		<h3>我的微调研</h3>
	</div>
	<div class="alert alert-info">
	  	<p><span class="bold">注意：</span>微调研的目的是获得系统客观的收集信息研究数据，为决策做准备。。</p>
	  	<p><span class="bold">注意：</span>系统默认向用户显示,当前最新且有效的调研.</p>
	</div>
	
	


<div class="pagination">
 <!--  <ul>

    <li class="disabled"><span>上一页</span></li>
  </ul>
 -->  
</div>
	<table class="table table-bordered">
			<thead>
				<tr>
					<th>流水单</th>
					<th>微调研名称</th>
					<th>关键字</th>
					<th>时间</th>
					<th>微调研状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
					<s:if test="%{wdyVOs.size()==0}">
											<td colspan="8" align="center">
												暂无该信息
											</td>
								</s:if>
                                 <s:iterator value="wdyVOs" var="wdy" status="index">
                                  <tr>
						<td>
						<s:property value="#index.count"/>
						</td>
						<td><s:property value="name"/></td>
						<td><s:property value="keywordname"/></td>
						<td>
						<s:property value="time"/></td>
						<td>
						<s:if test="isuseful==0"><span>无效</span></s:if>
						<s:elseif test="isuseful==1"><span>有效</span></s:elseif>
						</td>
						<td>
						<span>
						[
						<a href="wdyAction!load?id=<s:property value="id"/>"> 修改/查看</a>
						]
						</span>
						<span>
						[
						<a href="wdyAction!delete?id=<s:property value="id"/>" onclick="return confirm('你确定删除该信息吗？')"">删除</a>
						]
						</span>
						</td>
				  </tr>
                                     </s:iterator>	 
			     
						</tbody>
		</table>

	


<div class="pagination">
  <!-- <ul>

    <li class="disabled"><span>上一页</span></li>
  </ul> -->
  
</div>

<script type="text/javascript">
$(function() {
	$("#gotonext").click(function(){
		window.parent.$('.menu-yuding').trigger('click');
	});
});

function dellbs(id,o){
	if(id=='a'){
		if(confirm('确定删除这些信息吗？')){
			var ids = [];
			$('td').find('input[type="checkbox"]:checked').each(function(){
				ids[ids.length] = $(this).val();
			});
			ajax('microVote-del.html',{ id:ids.join(',')},function(){
				$('td').find('input[type="checkbox"]:checked').each(function(){
					$(this).parent().parent().remove();
				});
			});	
		}
	}else{
		if(confirm('确定删除此条信息吗？')){
			ajax('microVote-del.html',{ id:id},function(){
				$(o).parent().parent().parent().remove();
			});	
		}
	}	
}

function selallck(o){
	if($(o).prop('checked')){
		$('td').find('input[type="checkbox"]').prop('checked',true);
	}else{
		$('td').find('input[type="checkbox"]').prop('checked',false);
	}
}
</script>

<div id="gotonext"  >
	<img src="media/images/admin/v3/yuding.png" ></img>
</div>

<br/><br/><br/></body></html>