<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META name=viewport content="width=device-width, user-scalable=no, initial-scale=1">
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css" />
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>

<title>电信通讯录</title>
</head>
<body>
<div data-role="page" id="pageone" >
  <div data-role="content" >
  <ul data-role="listview"  data-inset="true" data-filter="true" data-filter-placeholder="搜索姓名">
  	<li data-role="list-divider" data-theme="b">局领导</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='局领导'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	<li data-role="list-divider">人事科</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='人事科'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    		<li data-role="list-divider">管理科</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='管理科'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	<li data-role="list-divider">法制科</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='法制科'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	  <li data-role="list-divider">财务科</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='财务科'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> ">    <s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	<li data-role="list-divider">局办</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='局办'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> ">    <s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	
    	<li data-role="list-divider">市容办</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='市容办'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> ">    <s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	
    	<li data-role="list-divider">广告办</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='广告办'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> ">    <s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
  
  	
    	<li data-role="list-divider">渣土办</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='渣土办'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> ">    <s:property value="lochus"/>-<s:property value="name"/><span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	<li data-role="list-divider">数字城管</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='数字城管'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> ">    <s:property value="lochus"/>-<s:property value="name"/><span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	<li data-role="list-divider">城东中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='城东中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	
    	<li data-role="list-divider">城南中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='城南中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	
    	<li data-role="list-divider">城中中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='城中中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
  
  		<li data-role="list-divider">城北中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='城北中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    		<li data-role="list-divider">丁蜀中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='丁蜀中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	<li data-role="list-divider">稽查中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='稽查中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    		<li data-role="list-divider">芳桥中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='芳桥中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	
    		<li data-role="list-divider">高塍中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='高塍中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	<li data-role="list-divider">官林中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='高塍中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	<li data-role="list-divider">和桥中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='高塍中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	
    	<li data-role="list-divider">湖父中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='湖父中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span>  </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    		<li data-role="list-divider">环科院</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='环科院'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	
    		<li data-role="list-divider">开发区中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='开发区中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	<li data-role="list-divider">社区中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='社区中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	<li data-role="list-divider">直属中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='直属中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	
    	<li data-role="list-divider">张渚中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='张渚中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	<li data-role="list-divider">太华中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='太华中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	<li data-role="list-divider">万石中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='万石中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	<li data-role="list-divider">西渚中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='西渚中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	<li data-role="list-divider">新建中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='新建中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>


    	<li data-role="list-divider">新庄中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='新庄中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	<li data-role="list-divider">徐舍中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='徐舍中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	<li data-role="list-divider">杨巷中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='杨巷中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	
    	<li data-role="list-divider">周铁中队</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='周铁中队'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	<li data-role="list-divider">高铁</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='高铁'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	 	<li data-role="list-divider">大队、汽修</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='大队、汽修'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    		<li data-role="list-divider">林场</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='林场'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	
    		<li data-role="list-divider">锦绣广告公司</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='锦绣广告公司'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    	<li data-role="list-divider">监察室</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='监察室'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
    		<li data-role="list-divider">其他</li>
  		<s:iterator value="addressbooks" var="addressbook" status="status">	 
  		  <s:if test="lochus=='其他'">
  		 	  <li><a href="tel:<s:property value="shortnumber"/> "><s:property value="lochus"/>-<s:property value="name"/> <span class="ui-li-aside"><s:property value="shortnumber"/></span> </a>  </li>
  		 	     </s:if>
    	</s:iterator>
    	
  </ul>
  </div>


</body>
</html>