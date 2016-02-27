<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>管理</title>
		<link rel="stylesheet" type="text/css" href="skin/css/base.css">

	</head>
	<body leftmargin="8" topmargin="8">
		<div class="linedwon">
			<img src="skin/images/frame/jiantou.gif" width="20" height="20"
				border="0">
			当前位置：管理&gt;&gt;
			<a
				href='fodderAction!list?publicaccount=${pubclient.publicaccount }&status=1'
				target='main'>素材管理</a>&gt;&gt;新增多图文&nbsp;
			<a href="javascript:history.back();" style="color: red;">[返回]</a>
		</div>

		<!--  内容列表   -->
		<form name="form2" action="fodderAction!muladd" method="post">

			<table width="98%" border="0" cellpadding="2" cellspacing="1"
				bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
				<tr bgcolor="#E7E7E7">
					<td height="33" colspan="2" align="center">
						<strong>新增多图文</strong>
						<s:hidden name="fodder.publicaccount"
							value="%{#session.pubclient.publicaccount}"></s:hidden>
						<s:hidden name="fodder.funcflag"
							value="1"></s:hidden>
						<s:hidden name="fodder.savetype"
							value="6"></s:hidden>
					</td>
				</tr>


				<tr align="center" bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25">
					<td width="25%" height="25" align="right">
						<strong><font color="#333333">标题</font>
						</strong>
					</td>
					<td width="75%" align="left">
						<label>
							<s:textfield name="fodder.title" cssStyle="width:80%"></s:textfield>
						</label>
					</td>
				</tr>

				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="25">
					<td height="25" align="right">
						<strong><font color="#333333">类型</font>
						</strong>
					</td>
					<td align="left">
						<s:select list="#{7:'多图文',1:'其他'}" name="fdtype"
							listKey="key" listValue="value" id="savetype"
							onchange="changeType(this.value)"></s:select>
						<script type="text/javascript">
					  		function changeType(index){
					  			if(index==7){
					  				
					  			}else{
						  			window.location.href = "fodder_add.jsp";
					  			}
					  		}
					  	</script>
					</td>
				</tr>
			</table>
			<table width="98%" border="0" cellspacing="0" cellpadding="0"
				align="center">
				<tr>
					<td height="29" align="center" valign="bottom">
						<s:token></s:token>
						<input type='submit' class="coolbg np" onClick="" value='下一步'
							style="width: 80" />
						&nbsp;&nbsp;
						<input type='button' class="coolbg np"
							onClick="javascript:history.back();" value='返回' style="width: 80" />
						&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td height="18" align="center">
						&nbsp;
					</td>
				</tr>
			</table>


		</form>

	</body>
</html>