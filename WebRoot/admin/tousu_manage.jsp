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
<title>微投诉</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>

</head>
<body>
	<div class="main-title">
		<h3>投诉管理</h3>
	</div>
	<div class="alert alert-info">
	  	<p><span class="bold">注意：</span>投诉管理注意事项</p>
	  	<!--  -->
		<p><span class="bold">提示：</span>定期删除<strong><font color="#FF0000" size="+1">过期</font></strong>投诉图片</p>
	</div>
	
	


<div class="pagination">
 <!--  <ul>

    <li class="disabled"><span>上一页</span></li>
  </ul>
 -->  
</div>
	<div class="tb-toolbar">
		
		<a href="complaintAction!list?con=2&convalue=0" class="btn btn-small btn-primary">未办理</a>
		<a href="complaintAction!list?con=2&convalue=1" class="btn btn-small btn-primary">办理中</a>
		<a href="complaintAction!list?con=2&convalue=2" class="btn btn-small btn-primary">已办理</a>
	</div>
	<table class="table table-bordered" style="table-layout: fixed;">
			<thead>
				<tr>
					
					<th>流水号</th>
					<th>流程类型</th>
					<th>投诉类型</th>
					<th>联系人</th>
					<th>投诉内容</th>
					<th>时间</th>
					<th>投诉状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			
					<s:if test="%{complaints.size()==0}">
						<td colspan="8" align="center">
							暂无该信息
						</td>
					</s:if>
						<s:iterator value="complaints" var="complaint" status="status">	 		 
			      <tr>
			      		
						<td>
							<s:property value="#status.count"/>
						</td>
						<td>投诉处理</td>
						
						<td>
							<s:if test="comptype==1">
							市容市貌
							</s:if>
							<s:elseif test="comptype==2">
							宣传广告
							</s:elseif>
							<s:elseif test="comptype==3">
							园林绿化
							</s:elseif>
							<s:elseif test="comptype==4">
							黑车 
							</s:elseif>
							<s:elseif test="comptype==5">
							城市湖道
							</s:elseif>
							<s:elseif test="comptype==6">
							街面秩序
							</s:elseif>
							<s:elseif test="comptype==7">
							施工管理
							</s:elseif>
						</td>
						
						<td><s:property value="name"/></td>
						<td style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis;  " title="投诉内容"><s:property value="content"/></td>
						<td>
							<s:property value="comptime"/>
						</td>
						<td >
							<s:if test="compstate==0">
									 <a class="btn btn-small"><span class="state" id="<s:property value="id"/>" >未办理  </span></a>
							</s:if>
							<s:elseif test="compstate==1">
									<a class="btn btn-small"><span class="state" id="<s:property value="id"/>">办理中</span></a>
							</s:elseif>
							<s:elseif test="compstate==2">
									<a class="btn btn-small "><span class="state"  id="<s:property value="id"/>">已办理</span></a>
							</s:elseif>
						</td>
						
						
						<td>
						<span>
						[
						<a href="tousu_do.html">主办</a>
						]
						</span>
						<span>
						[
						<a href="complaintAction!view?id=<s:property value="id"/>">详细</a>
						]
						</span>
						<span>
						[
						<a href="complaintAction!delete?id=<s:property value="id"/>" onclick="return confirm('你确定删除该信息吗？')">删除</a>
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
			  <a href="javascript:jumpPage('complaintAction!list',1,<s:property value="con"/>,'<s:property value="convalue"/>');" target="main">首页</a>&nbsp;&nbsp; 
			  <a href="javascript:jumpPage('complaintAction!list',<s:property value="page-1"/>,<s:property value="con"/>,'<s:property value="convalue"/>');" target="main">上一页</a>&nbsp;&nbsp;&nbsp; 
			  <a href="javascript:jumpPage('complaintAction!list',<s:property value="page+1"/>,<s:property value="con"/>,'<s:property value="convalue"/>');" target="main">下一页</a>&nbsp;&nbsp;&nbsp; 
			  <a href="javascript:jumpPage('complaintAction!list',<s:property value="pageCount"/>,<s:property value="con"/>,'<s:property value="convalue"/>');" target="main">尾页</a>&nbsp;&nbsp;&nbsp;
			  <input type='button'  class="coolbg np" onClick="javascript:jumpPage('complaintAction!list',document.getElementById('page').value,<s:property value="con"/>,'<s:property value="convalue"/>');" value='转到' />
			&nbsp;
			当前页：
			<input onpaste="return false"   id="page" type="text" name="page" value="<s:property value="page"/>" size="2" style="ime-mode=disabled;width:25px; height:16px;line-height:14px; BORDER-RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; FONT-SIZE: 13px; BORDER-LEFT: #cccccc 1px solid; COLOR: #000000; BORDER-BOTTOM: #cccccc 1px solid; FONT-FAMILY: 宋体; BACKGROUND-COLOR: #ffffff;text-align: center;vertical-align:top;"/>
			/共<s:property value="pageCount"/>页
		</span>
	    
	    </li>
	  </ul> 
	  
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