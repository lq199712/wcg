<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>微官网</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">

<script type="text/javascript" src="js/pageKit.js"></script>
<link rel="stylesheet" href="kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor/kindeditor-none.js"></script>
	<script charset="utf-8" src="kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="kindeditor/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="pagearticle.description"]', {
				cssPath : 'kindeditor/plugins/code/prettify.css',
				uploadJson : 'kindeditor/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
</head>
<body leftmargin="8" topmargin="8" >
<div class="linedwon"><img src="skin/images/frame/jiantou.gif" width="20" height="20" border="0">当前位置：微官网&gt;&gt;<a href='pagearticleAction!list4?publicaccount=${pubclient.publicaccount }&status=4' target='main'>头版文章管理</a>&gt;&gt;查看头版文章&nbsp;<a href="javascript:history.back();" style=" color:red;">[返回]</a></div>
  
<!--  内容列表   -->

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px;">
<tr bgcolor="#E7E7E7">
	<td height="33" colspan="2" align="center">
	<strong>头版文章信息</strong></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">子页类别</font></strong></td>
	<td align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pagearticle.sontype.bigtype.name" />-<s:property value="pagearticle.sontype.name" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">文章标题</font></strong></td>
	<td align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pagearticle.name" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">标题缩写</font></strong></td>
	<td align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pagearticle.shortname" />
	  </label></td>
</tr>



<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">最后修改时间</font></strong></td>
	<td align="left" style="padding-left: 50px;">
	  <label>
		<s:date name="pagearticle.createtime" format="yyyy-MM-dd HH:mm:ss" />
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">封面图片</font></strong></td>
	<td align="left" style="padding-left: 50px;">
	  <label>
	  	<img src="<s:property value="pagearticle.image" />" width="400"/>
		
	  </label></td>
</tr>



<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">视频</font></strong></td>
	<td align="left" style="padding-left: 50px;">
	  <label>
	  <s:property value="pagearticle.videourl" escape="false"/>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">头版文章链接</font></strong></td>
	<td align="left" style="padding-left: 50px;">
	  <label>
	  -<a href="<s:property value="pagearticle.articlelink" />">点击跳转</a>-
	  
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">正文描述</font></strong></td>
	<td align="left" style="padding-left: 50px;">
	  <label>
	  <s:textarea name="pagearticle.description" cssStyle="width:95%;height:800px;visibility:hidden;" readonly="readonly"></s:textarea>
	  </label></td>
</tr>

<tr align="center" bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
	<td height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">包含项目</font></strong></td>
	<td align="left" style="padding-left: 50px;">
	  <label>
		<s:property value="pagearticle.project" />
	  </label></td>
</tr>

<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="60" >
  <td height="25" align="right" style="padding-right: 50px;"><strong><font color="#333333">是否显示</font></strong></td>
  <td align="left" style="padding-left: 50px;">
  	<s:if test="pagearticle.isshow==1">
  		显示
  	</s:if>
  	<s:elseif test="pagearticle.isshow==2">
  		头版文章
  	</s:elseif>
  	<s:else>
  		不显示
  	</s:else>
</td>
</tr>

</table>

<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td height="29" align="center" valign="bottom">
      <input type='button' class="coolbg np" onClick="javascript:history.back();" value='返回' style="width:80" />&nbsp;&nbsp;</td>
  </tr>
  <tr>
    <td height="18" align="center">&nbsp;</td>
  </tr>
</table>

</body>
</html>
