<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!-- Apple devices fullscreen -->
<meta name="apple-mobile-web-app-capable" content="yes" />
<!-- Apple devices fullscreen -->
<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
<base target="mainFrame" />
<link rel="stylesheet" type="text/css" href="css/wm/index.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/bootstrap_min.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/bootstrap_responsive_min.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/style.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/themes.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/todc_bootstrap.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/wm/inside.css" media="all" />
<title>宜兴市城管局留言管理</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>

<script src="http://api.map.baidu.com/api?v=1.5&ak=1b0ace7dde0245f796844a06fb112734"></script>
<link rel="shortcut icon" href="favicon.ico" />
</head>
<body class="theme-blue">
<div id="main">
    <div class="container-fluid">

        <div class="row-fluid">
            <div class="span12">

                <div class="box">

                    <div class="box-title">
                        <div class="span10">
                            <h3><i class="icon-edit"></i>留言管理 </h3>
                        </div>
                        <div class="span2"><a class="btn" href="Javascript:window.history.go(-1)">返回</a></div>
                    </div>
                    <div class="box-content">

                        <div class="row-fluid">
                            <div class="span12 control-group">
                                <div class="span2">

                                    <a class="btn" href="javascript:location.reload()"><i class="icon-refresh"></i></a>
                                </div>
                                <div class="pull-left datatabletool">
                                  
                                </div>
                            </div>
                        </div>
                        <div class="row-fluid dataTables_wrapper">


                            <table id="listTable" class="table table-bordered   table-hover  dataTable" style="table-layout: fixed;">
                                <thead>
                                    <tr>
                                    	<th>流水号</th>
                                        <th>用户名</th>
                                        <th>留言内容</th>
                                        <th>留言时间</th>
                                        <th>状态</th>
                                        <th>微信页面是否显示<div style="color: red">(默认显示最新的6条)</div></th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                					<s:if test="%{messages.size()==0}">
											<td colspan="8" align="center">
												暂无该信息
											</td>
								</s:if>
                                 <s:iterator value="messages" var="message" status="index">
                                    <tr>
                                    	<td><s:property value="#index.count"/></td>
                                        <td><s:property value="name"/></td>
                                        <td title="留言内容" style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis;  "><s:property value="messagecontent"/></td>
                                        <td><s:property value="messagetime"/></td>
                                        <td>
                                        	<s:if test="messagestate==0">未审核</s:if>
                                        	<s:elseif test="messagestate==1">已审核</s:elseif>
                                        </td>
                                        <td>
                                        	<s:if test="isshow==0">不显示</s:if>
                                        	<s:elseif test="isshow==1">显示</s:elseif>
                                        </td>
                                        <td>
                                        <a class="btn" href="messageAction!load?id=<s:property value="id"/>" attr="BatchDel" title="设置" onclick="todel()"><i class="icon-pencil"></i></a>
                                        <a class="btn" title="删除" href="complaintAction!delete?id=<s:property value="id"/>" onclick="return confirm('你确定删除该信息吗？')"><i class="icon-remove"></i></a>
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
		  <a href="javascript:jumpPage('messageAction!list',1,<s:property value="con"/>,'<s:property value="convalue"/>');" target="main">首页</a>&nbsp;&nbsp; 
		  <a href="javascript:jumpPage('messageAction!list',<s:property value="page-1"/>,<s:property value="con"/>,'<s:property value="convalue"/>');" target="main">上一页</a>&nbsp;&nbsp;&nbsp; 
		  <a href="javascript:jumpPage('messageAction!list',<s:property value="page+1"/>,<s:property value="con"/>,'<s:property value="convalue"/>');" target="main">下一页</a>&nbsp;&nbsp;&nbsp; 
		  <a href="javascript:jumpPage('messageAction!list',<s:property value="pageCount"/>,<s:property value="con"/>,'<s:property value="convalue"/>');" target="main">尾页</a>&nbsp;&nbsp;&nbsp;
		  <input type='button' class="coolbg np" onClick="javascript:jumpPage('messageAction!list',document.getElementById('page').value,<s:property value="con"/>,'<s:property value="convalue"/>');" value='转到' />
		&nbsp;
		当前页：
		<input onpaste="return false" onKeyPress="checkPage();" id="page" type="text" name="page" value="<s:property value="page"/>" size="2" style="ime-mode=disabled;width:25px; height:16px;line-height:14px; BORDER-RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; FONT-SIZE: 13px; BORDER-LEFT: #cccccc 1px solid; COLOR: #000000; BORDER-BOTTOM: #cccccc 1px solid; FONT-FAMILY: 宋体; BACKGROUND-COLOR: #ffffff;text-align: center;vertical-align:top;"/>
		/共<s:property value="pageCount"/>页
	</span>
    
    </li>
  </ul> 
  
</div>
                            
                            
                            
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<script type="text/javascript">
	//图片设置
	function setpic(imgid){
		window.piccbk = function(m){
			$('#'+imgid).find('img').attr('src',m);
			$('#'+imgid).find('input[type="hidden"]').val(m);
			window.piccbk = null;
		}
		window.curpic = null;
		openpicset();	
	} 
	function openpicset(){
		pophtml('<iframe src="wspicif.html" style="width:630px;height:470px;border:none;background-color: #dfdfdf;" width="630px" height="475px"></iframe>',670,510,true);
	}
	$(function(){
		$('.check_all').click(function(){
			if($(this).prop('checked')){
				$('.check_one').prop('checked',true);
			}else{
				$('.check_one').prop('checked',false);
			}
		});
	});
	
	function setval(){
		var sel = [];
		$('.check_one').each(function(){
			if($(this).prop('checked')){
				sel[sel.length] = $(this).val();
			}
		});
		if(sel.length>0 && confirm('确定通过审核吗？')){
			ajax('mg-val.html',{ ids:sel.join(',')},function(m){
				tusi('操作完成');
				setTimeout('window.location.href=location.href',1000);
			});
		}
	}
	
	function todel(ids){		
		var sel = [];
		if(!ids){
			$('.check_one').each(function(){
				if($(this).prop('checked')){
					sel[sel.length] = $(this).val();
				}
			});
			ids = sel.join(',');
		}		
		if($.trim(ids)!='' && confirm('确定删除吗？')){
		
			console.log("ids:"+ids);
			ajax('mg-del.html',{ ids:ids},function(m){
				console.log('操作完成');
				setTimeout('window.location.href=location.href',1000);
			});
		}
	}
	
	function tohei(ids){		
		var sel = [];
		if(!ids){
			$('.check_one').each(function(){
				if($(this).prop('checked')){
					sel[sel.length] = $(this).val();
				}
			});
			ids = sel.join(',');
		}		
		if($.trim(ids)!='' && confirm('确定拉黑并删除此用户的留言吗？')){
			ajax('mg-hei.html',{ ids:ids},function(m){
				tusi('操作完成');
				setTimeout('window.location.href=location.href',1000);
			});
		}
	}
</script>
<script type="text/javascript">

</script>
<br/><br/><br/>
</body>
</html>