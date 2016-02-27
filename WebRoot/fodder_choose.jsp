<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>回复功能</title>
		<link rel="stylesheet" type="text/css" href="skin/css/base.css">

		<SCRIPT type="text/javascript">
			function selectTag(showContent,selfObj)
			{
				// 标签
				var tag = document.getElementById("tags").getElementsByTagName("li");
				var taglength = tag.length;
				for(i=0; i<taglength; i++){
				tag[i].className = "";
				}
				//selfObj.parentNode.className = "selectTag";
				// 标签内容
				for(i=0; j=document.getElementById("tagContent"+i); i++)
				{
				j.style.display = "none";
				}
				document.getElementById(showContent).style.display = "block";
			}
			
			
			function refreshSessionAs(currentpage){
			
			if(confirm("您确定选择该素材吗？")){
				var aa=document.getElementsByName("chek");
				var fodderid=0;
				if(aa.length){
					for(var i=0;i<aa.length;i++){
						if(aa[i].checked==true){
							fodderid=aa[i].value;
						}
					}
				}
				if(fodderid<=0){
					alert("请您选择一个素材");
					return;
				}
				var loc="fodderAction!refreshSessionAs?fodderid="+fodderid+"&currentpage="+currentpage;
				window.location=loc;
			}
				
				
		}
		</SCRIPT>

	<script type="text/javascript" src="js/pageKit.js"></script></head>
	<body leftmargin="8" topmargin="8" onLoad="selectTag('tagContent0',this)">
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：回复功能>>关注回复>>选择素材&nbsp;<a href="javascript:history.back();" style=" color:red;">[返回]</a></div>
<div id="tagContent">
			<div id="tagContent0" style="display: block;">
				<!--  快速转换位置按钮  -->
				<table width="98%" border="0" cellpadding="0" cellspacing="1"
					bgcolor="#D1DDAA" align="center">
					<tr>
						<td height="26">
							<table width="98%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td align="center">
										<ul id="tags" style="float: left;">

											<li style="float: left;">
													<input type='button' class="coolbg np"
														onClick="location='fodderAction!choosefodder?publicaccount=${pubclient.publicaccount }&status=1';"
														value='文本' />
											</li>
											<li style="float: left;">
													<input type='button' class="coolbg np"
														onClick="location='fodderAction!choosefodder?publicaccount=${pubclient.publicaccount }&status=5';"
														value='音乐' />
											</li>
											<li style="float: left;">
													<input type='button' class="coolbg np"
														onClick="location='fodderAction!choosefodder?publicaccount=${pubclient.publicaccount }&status=6';"
														value='图文' />
											</li>
											<li style="float: left;">
													<input type='button' class="coolbg np"
														onClick="location='fodderAction!choosefodder?publicaccount=${pubclient.publicaccount }';"
														value='全部' />
											</li>
											
									  </ul>


									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
			
		</div>
		<!--  内容列表   -->

			<table width="98%" border="0" cellpadding="2" cellspacing="1"
				bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
				<tr bgcolor="#E7E7E7">
					<td height="33" colspan="4" align="center">
						<strong>
								<s:if test="status==1">
									文本
								</s:if>
								<s:elseif test="status==5">
									音乐
								</s:elseif>
								<s:elseif test="status==6">
									图文
								</s:elseif>
								<s:else>
									全部
								</s:else>
						&nbsp;
						共<s:property value="totalCount"/>个素材 
						 </strong>
					</td>
				</tr>
				<tr bgcolor="#E7E7E7">
					<td height="33" bgcolor="#FFFFE5" align="center">
						<input type='button' class="coolbg np"
													onClick="refreshSessionAs('<s:property value="currentpage"/>')" value='选定素材' />
					</td>
					<td height="33" colspan="7" bgcolor="#FFFFE5">
					<form action="fodderAction!choosefodder" method="post" name="form2">
						<table width="65%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="18%">
								<s:hidden name="publicaccount" value="%{#session.pubclient.publicaccount}"></s:hidden>
								<s:hidden name="status"></s:hidden>
										<s:select list="#{1:'标题'}" name="con" listKey="key"
										listValue="value" cssStyle="width:100"></s:select>
									</td>
								<td width="31%" align="center">
									<label>
										<s:textfield name="convalue" id="convalue"
											cssStyle="width:130" />
									</label>
								</td>
								
								
								<td width="13%" align="center">
									<input type="submit" class="coolbg np" onClick="" value='查 询' />

								</td>
								<td width="13%" align="center">
									<input type="reset" class="coolbg np" onClick="" value='重 置' />
								</td>
							</tr>
						</table>
						</form>
					</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%" align="center">
						<strong> <font color="#333333"> 请选择 </font> </strong>
					</td>
					<td width="10%" align="center">
						<strong><font color="#333333">序号</font> </strong>
				  </td>
					<td width="30%" align="center">
						<strong><font color="#333333">标题</font> </strong>
					</td>
					<td width="20%" align="center"><strong><font color="#333333">创建日期</font></strong></td>
				</tr>
				
				<s:if test="%{fodders.size()==0}">
				<td colspan="4" align="center">
					暂无该信息
				</td>
			</s:if>
	
			<s:iterator value="fodders" var="fodder" status="index">
					<tr align='center' bgcolor="#FFFFFF"
						onMouseMove="javascript:this.bgColor='#FCFDEE';"
						onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

						<td>
							<input type="radio" name="chek" id="chek" class="ck" value="<s:property value="#fodder.id"/>">
						</td>
						<td>
							<s:property value="#index.count"/>
					    </td>
						<td>
							<s:property value="#fodder.title"/>
						</td>
						<td>
                        	<s:date name="#fodder.createdate" format="yyyy-MM-dd"/>
                        </td>
					</tr>
			</s:iterator>
					
				



			</table>


	</body>
</html>