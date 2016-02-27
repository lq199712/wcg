<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>素材管理</title>
		<link rel="stylesheet" type="text/css" href="skin/css/base.css">
		<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="js/pageKit.js"></script>
	</head>
	<body leftmargin="8" topmargin="8" >
		<div class="linedwon">
			<img src="skin/images/frame/jiantou.gif" width="20" height="20"
				border="0">
			当前位置：管理>>素材管理
		</div>
		<!--  快速转换位置按钮  -->
		<table width="98%" border="0" cellpadding="0" cellspacing="1"
			bgcolor="#8BC7F1" align="center">
			<tr>
				<td height="26">
					<table width="98%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="21" align="center">
								<input type='button' class="coolbg np"
									onClick="location='fodderAction!goToAdd?status=1&publicaccount=${pubclient.publicaccount }';" value='新增素材' />
							
								<input type='button' class="coolbg np"
									onClick="location='fodderAction!list?status=1&publicaccount=${pubclient.publicaccount }';" value='文字' />
								<input type='button' class="coolbg np"
									onClick="location='fodderAction!list?status=5&publicaccount=${pubclient.publicaccount }';" value='音乐' />
								<input type='button' class="coolbg np"
									onClick="location='fodderAction!list?status=6&publicaccount=${pubclient.publicaccount }';" value='图文' />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!--  文字管理列表   -->
		<s:if test="status==1">
		<form name="form1" action="fodderAction!list" method="post">

			<table width="98%" border="0" cellpadding="2" cellspacing="1"
				bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
				<tr bgcolor="#E7E7E7">
					<td height="33" colspan="5" align="center">
						<b>文字管理</b>
						<s:hidden name="status" value="1"></s:hidden>
						<s:hidden name="publicaccount" value="%{#session.pubclient.publicaccount}"></s:hidden>
					</td>
				</tr>
				<tr bgcolor="#E7E7E7">
					<td height="33" colspan="5" bgcolor="#FFFFE5">
						<table width="50%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="15%">
									<s:select list="#{0:'选择类型',1:'标题'}" cssStyle="width:100px"
										name="con" listKey="key" listValue="value"></s:select>
								</td>
								<td width="25%" align="center">
									<label>
										<s:textfield name="convalue" cssStyle="width:200" />
									</label>
								</td>


								<td width="5%" align="center">
									<input type="submit" class="coolbg np" onClick="" value='查 询' />

								</td>
								<td width="5%" align="center">
									<input type="reset" class="coolbg np" onClick="" value='重 置' />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="5%" align="center">
						序号
					</td>
					<td width="25%" align="center">
						文字标题
					</td>
					<td width="10%" align="center">
						创建日期
					</td>
					<td width="5%" align="center">
						修改
					</td>
					<td width="5%" align="center">
						删除
					</td>
				</tr>


				<s:if test="%{fodders.size()==0}">
					<tr align='center' bgcolor="#FFFFFF"
						onMouseMove="javascript:this.bgColor='#FCFDEE';"
						onMouseOut="javascript:this.bgColor='#FFFFFF';">

						<td align="center" colspan="5">
							暂无信息
						</td>

					</tr>
				</s:if>
				<s:iterator value="fodders" var="fodder" status="status">
					<tr align='center' bgcolor="#FFFFFF"
						onMouseMove="javascript:this.bgColor='#FCFDEE';"
						onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<td>
							<s:property value="#status.count" />
						</td>
						<td>
							<s:property value="title" />
						</td>
						<td>
							<s:date name="createdate" format="yyyy-MM-dd" />
						</td>
						<td>
						
							<a href="fodderAction!load?id=<s:property value="id" />"> <img
									src="skin/images/frame/huiwu_3.gif" width="20" height="20"
									border="0"> </a>
						</td>
						<td>
							<a href="fodderAction!delete?id=<s:property value="id"/>"
								onClick="return confirm('您确定删除该条信息吗？')"><img
									src="skin/images/frame/huiwu_2.gif" width="20" height="20"
									border="0">
							</a>
						</td>
					</tr>
				</s:iterator>



				<tr align="right" bgcolor="#EEF4EA">

					<td height="34" colspan="5" align="center">
						记录数：
						<s:property value="totalCount" />
						&nbsp;&nbsp;&nbsp;
						<a
							href="javascript:jumpPublicPage('fodderAction!list',1,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');"
							target="main">首页</a>&nbsp;&nbsp;
						<a
							href="javascript:jumpPublicPage('fodderAction!list',<s:property value="page-1"/>,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');"
							target="main">上一页</a>&nbsp;&nbsp;&nbsp;
						<a
							href="javascript:jumpPublicPage('fodderAction!list',<s:property value="page+1"/>,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');"
							target="main">下一页</a>&nbsp;&nbsp;&nbsp;
						<a
							href="javascript:jumpPublicPage('fodderAction!list',<s:property value="pageCount"/>,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');"
							target="main">尾页</a>&nbsp;&nbsp;&nbsp;
						<input type='button' class="coolbg np"
							onClick="javascript:jumpPublicPage('fodderAction!list',document.getElementById('page').value,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');"
							value='转到' />
						&nbsp; 当前页：
						<input onpaste="return false" onKeyPress="checkPage();" id="page"
							type="text" name="page" value="<s:property value="page"/>"
							size="2"
							style="width: 25px; height: 20px; line-height: 18px; BORDER-RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; FONT-SIZE: 13px; BORDER-LEFT: #cccccc 1px solid; COLOR: #000000; BORDER-BOTTOM: #cccccc 1px solid; FONT-FAMILY: 宋体; BACKGROUND-COLOR: #ffffff;" />
						/共
						<s:property value="pageCount" />
						页
					</td>

				</tr>
			</table>

		</form>
		</s:if>
		<!--  音乐管理列表   -->
		<s:if test="status==5">
		<form name="form2" action="fodderAction!list" method="post">

			<table width="98%" border="0" cellpadding="2" cellspacing="1"
				bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
				<tr bgcolor="#E7E7E7">
					<td height="33" colspan="6" align="center">
						<b>音乐管理</b>
						<s:hidden name="status" value="5"></s:hidden>
						<s:hidden name="publicaccount" value="%{#session.pubclient.publicaccount}"></s:hidden>
					</td>
				</tr>
				<tr bgcolor="#E7E7E7">
					<td height="33" colspan="6" bgcolor="#FFFFE5">
						<table width="50%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="15%">
									<s:select list="#{0:'选择类型',1:'标题'}" cssStyle="width:100px"
										name="con" listKey="key" listValue="value"></s:select>
								</td>
								<td width="25%" align="center">
									<label>
										<s:textfield name="convalue" cssStyle="width:200" />
									</label>
								</td>


								<td width="5%" align="center">
									<input type="submit" class="coolbg np" onClick="" value='查 询' />

								</td>
								<td width="5%" align="center">
									<input type="reset" class="coolbg np" onClick="" value='重 置' />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="5%" align="center">
						序号
					</td>
					<td width="15%" align="center">
						音乐标题
					</td>
					<td width="35%" align="center">
						音乐链接
					</td>
					<td width="10%" align="center">
						创建日期
					</td>
					<td width="5%" align="center">
						修改
					</td>
					<td width="5%" align="center">
						删除
					</td>
				</tr>


				<s:if test="%{fodders.size()==0}">
					<tr align='center' bgcolor="#FFFFFF"
						onMouseMove="javascript:this.bgColor='#FCFDEE';"
						onMouseOut="javascript:this.bgColor='#FFFFFF';">

						<td align="center" colspan="6">
							暂无信息
						</td>

					</tr>
				</s:if>
				<s:iterator value="fodders" var="fodder" status="status">
					<tr align='center' bgcolor="#FFFFFF"
						onMouseMove="javascript:this.bgColor='#FCFDEE';"
						onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<td>
							<s:property value="#status.count" />
						</td>
						<td height="50px">
							<a href="#" onclick="player('play');"><s:property value="title" /></a>
							
<audio id="bgaudio" src="<s:property value="musicurl" />"></audio>
<span id="myimg" style="vertical-align:middle;">
	<a href="#" onclick="player('play');"><img id="conimage" src="skin/images/play.jpg" width="20px" height="20px"/></a>
</span>

<script type="text/javascript">
	function player(isplay){
		if(isplay=="play"){
			document.getElementById('bgaudio').play();
			document.getElementById('myimg').innerHTML='<a href=# onclick=player("stop");><img id=conimage src=skin/images/stop.jpg width=20px height=20px/></a>';
			//conimage.src="stop.jpg";
		}else{
			document.getElementById('bgaudio').pause();
			document.getElementById('myimg').innerHTML='<a href=# onclick=player("play");><img id=conimage src=skin/images/play.jpg width=20px height=20px/></a>';
		}
		
	}
		
</script>
							
						</td>
						<td>
							<s:property value="musicurl" />
						</td>
						<td>
							<s:date name="createdate" format="yyyy-MM-dd" />
						</td>
						<td>
							<a href="fodderAction!load?id=<s:property value="id" />"> <img
									src="skin/images/frame/huiwu_3.gif" width="20" height="20"
									border="0"> </a>
						</td>
						<td>
							<a href="fodderAction!delete?id=<s:property value="id"/>"
								onClick="return confirm('您确定删除该条信息吗？')"><img
									src="skin/images/frame/huiwu_2.gif" width="20" height="20"
									border="0">
							</a>
						</td>
					</tr>
				</s:iterator>



				<tr align="right" bgcolor="#EEF4EA">

					<td height="34" colspan="6" align="center">
						记录数：
						<s:property value="totalCount" />
						&nbsp;&nbsp;&nbsp;
						<a
							href="javascript:jumpPublicPage('fodderAction!list',1,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');"
							target="main">首页</a>&nbsp;&nbsp;
						<a
							href="javascript:jumpPublicPage('fodderAction!list',<s:property value="page-1"/>,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');"
							target="main">上一页</a>&nbsp;&nbsp;&nbsp;
						<a
							href="javascript:jumpPublicPage('fodderAction!list',<s:property value="page+1"/>,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');"
							target="main">下一页</a>&nbsp;&nbsp;&nbsp;
						<a
							href="javascript:jumpPublicPage('fodderAction!list',<s:property value="pageCount"/>,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');"
							target="main">尾页</a>&nbsp;&nbsp;&nbsp;
						<input type='button' class="coolbg np"
							onClick="javascript:jumpPublicPage('fodderAction!list',document.getElementById('page').value,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');"
							value='转到' />
						&nbsp; 当前页：
						<input onpaste="return false" onKeyPress="checkPage();" id="page"
							type="text" name="page" value="<s:property value="page"/>"
							size="2"
							style="width: 25px; height: 20px; line-height: 18px; BORDER-RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; FONT-SIZE: 13px; BORDER-LEFT: #cccccc 1px solid; COLOR: #000000; BORDER-BOTTOM: #cccccc 1px solid; FONT-FAMILY: 宋体; BACKGROUND-COLOR: #ffffff;" />
						/共
						<s:property value="pageCount" />
						页
					</td>

				</tr>
			</table>

		</form>
		</s:if>
		<!--  图文管理列表   -->
		<s:if test="status==6">
		<form name="form3" action="fodderAction!list" method="post">

			<table width="98%" border="0" cellpadding="2" cellspacing="1"
				bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
				<tr bgcolor="#E7E7E7">
					<td height="33" colspan="6" align="center">
						<b>图文管理</b>
						<s:hidden name="status" value="6"></s:hidden>
						<s:hidden name="publicaccount" value="%{#session.pubclient.publicaccount}"></s:hidden>
					</td>
				</tr>
				<tr bgcolor="#E7E7E7">
					<td height="33" colspan="6" bgcolor="#FFFFE5">
						<table width="50%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="15%">
									<s:select list="#{0:'选择类型',1:'标题'}" cssStyle="width:100px"
										name="con" listKey="key" listValue="value"></s:select>
								</td>
								<td width="25%" align="center">
									<label>
										<s:textfield name="convalue" cssStyle="width:200" />
									</label>
								</td>


								<td width="5%" align="center">
									<input type="submit" class="coolbg np" onClick="" value='查 询' />

								</td>
								<td width="5%" align="center">
									<input type="reset" class="coolbg np" onClick="" value='重 置' />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="5%" align="center">
						序号
					</td>
					<td width="20%" align="center">
						图文标题
					</td>
					<td width="5%" align="center">
						图文个数
					</td>
					<td width="10%" align="center">
						创建日期
					</td>
					<td width="5%" align="center">
						修改
					</td>
					<td width="5%" align="center">
						删除
					</td>
				</tr>


				<s:if test="%{fodders.size()==0}">
					<tr align='center' bgcolor="#FFFFFF"
						onMouseMove="javascript:this.bgColor='#FCFDEE';"
						onMouseOut="javascript:this.bgColor='#FFFFFF';">

						<td align="center" colspan="6">
							暂无信息
						</td>

					</tr>
				</s:if>
				<s:iterator value="fodders" var="fodder" status="status">
					<tr align='center' bgcolor="#FFFFFF"
						onMouseMove="javascript:this.bgColor='#FCFDEE';"
						onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						<td>
							<s:property value="#status.count" />
						</td>
						<td>
							<s:if test="funcflag==1">
								<a href="fodderarticleAction!list?fodderid=<s:property value="id" />">
									<s:property value="title" />
								</a>
							</s:if>
							<s:else>
								<s:property value="title" />
							</s:else>
							
							<br/>
							<s:if test="picurl!=null&&picurl!=''">
								<img src="<s:property value="picurl" />" width="100%" height="240px"/>
							</s:if>
							
						</td>
						<td>
							<s:property value="articlecount" />
						</td>
						<td>
							<s:date name="createdate" format="yyyy-MM-dd" />
						</td>
						<td>
						<s:if test="funcflag==1">
							<a href="fodderarticleAction!list?fodderid=<s:property value="id" />" onclick="alert('这是一条多图文信息，请您进入修改');"> <img
									src="skin/images/frame/huiwu_3.gif" width="20" height="20"
									border="0"> </a>
						</s:if>
						<s:else>
							<a href="fodderAction!load?id=<s:property value="id" />"> <img
									src="skin/images/frame/huiwu_3.gif" width="20" height="20"
									border="0"> </a>
						</s:else>
							
						</td>
						<td>
							<a href="fodderAction!delete?id=<s:property value="id"/>"
								onClick="return confirm('您确定删除该条信息吗？')"><img
									src="skin/images/frame/huiwu_2.gif" width="20" height="20"
									border="0">
							</a>
						</td>
					</tr>
				</s:iterator>



				<tr align="right" bgcolor="#EEF4EA">

					<td height="34" colspan="6" align="center">
						记录数：
						<s:property value="totalCount" />
						&nbsp;&nbsp;&nbsp;
						<a
							href="javascript:jumpPublicPage('fodderAction!list',1,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');"
							target="main">首页</a>&nbsp;&nbsp;
						<a
							href="javascript:jumpPublicPage('fodderAction!list',<s:property value="page-1"/>,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');"
							target="main">上一页</a>&nbsp;&nbsp;&nbsp;
						<a
							href="javascript:jumpPublicPage('fodderAction!list',<s:property value="page+1"/>,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');"
							target="main">下一页</a>&nbsp;&nbsp;&nbsp;
						<a
							href="javascript:jumpPublicPage('fodderAction!list',<s:property value="pageCount"/>,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');"
							target="main">尾页</a>&nbsp;&nbsp;&nbsp;
						<input type='button' class="coolbg np"
							onClick="javascript:jumpPublicPage('fodderAction!list',document.getElementById('page').value,<s:property value="con"/>,'<s:property value="convalue"/>',<s:property value="status"/>,'<s:property value="publicaccount"/>');"
							value='转到' />
						&nbsp; 当前页：
						<input onpaste="return false" onKeyPress="checkPage();" id="page"
							type="text" name="page" value="<s:property value="page"/>"
							size="2"
							style="width: 25px; height: 20px; line-height: 18px; BORDER-RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; FONT-SIZE: 13px; BORDER-LEFT: #cccccc 1px solid; COLOR: #000000; BORDER-BOTTOM: #cccccc 1px solid; FONT-FAMILY: 宋体; BACKGROUND-COLOR: #ffffff;" />
						/共
						<s:property value="pageCount" />
						页
					</td>

				</tr>
			</table>

		</form>
		</s:if>
	</body>
</html>