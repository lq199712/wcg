<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>39MI-宜兴微定制</title>
<base target="_self">
<link rel="stylesheet" type="text/css" href="skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="skin/css/main.css" />
</head>
<body leftmargin="8" topmargin='8'>

<div class="main_box">
<div class="main_box_top">
  <div class="main_box_tleft"><img src="skin/images/frame/index_r3_c3.jpg" width="10" height="43"> </div>
  <div class="main_tpic"><img src="skin/images/frame/index_r3_logo.jpg" width="123" height="43"></div>
  <div class="main_box_tright"><img src="skin/images/frame/index_r3_c4.jpg" width="10" height="43"></div>
</div>
<div class="main_box_mid">
<!-- 
  <div class="main_line">
    <div class="main_line_tit">快捷方式</div></div>
  <div class="main_kj">
    <div class="main_banner"></div>
    <div class="main_kj_box">
      <div class="main_kj_pic"><a href="noticeAction!list?pid=${ps.id }" target="main"><img src="skin/images/frame/dot/1.jpg" width="38" height="46" border="0"></a></div>
      <div class="main_kj_txt"><a href="noticeAction!list?pid=${ps.id }" target="main">通知公告</a></div>
    </div>
    <div class="main_banner"></div>
    <div class="main_kj_box">
     <div class="main_kj_pic"><a href='email.jsp' target="main"><img src="skin/images/frame/dot/2.jpg" width="50" height="46" border="0"></a></div>
      <div class="main_kj_txt"><a href='email.jsp' target="main">内部邮件</a></div>
    </div>
    <div class="main_banner"></div>
    <div class="main_kj_box">
      <div class="main_kj_pic"><a href='depinfoAction!list?depid=${ps.dep.id}' target="main"><img src="skin/images/frame/dot/3.jpg" width="46" height="48" border="0"></a></div>
      <div class="main_kj_txt"><a href='depinfoAction!list?depid=${ps.dep.id}' target="main">部门信息</a></div>
    </div>
    <div class="main_banner"></div>
    <div class="main_kj_box">
      <div class="main_kj_pic"><a href='workreport.jsp' target="main"><img src="skin/images/frame/dot/4.jpg" width="46" height="43" border="0"></a></div>
      <div class="main_kj_txt"><a href='workreport.jsp' target="main">工作报告</a></div>
    </div> 
    <div class="main_banner"></div>
    <div class="main_kj_box">
      <div class="main_kj_pic"><a href='#' target="main"><img src="skin/images/frame/dot/5.jpg" width="44" height="44" border="0"></a></div>
      <div class="main_kj_txt"><a href='#' target="main">手机短信</a></div>
    </div>
    <div class="main_banner"></div>
    <div class="main_kj_box">
      <div class="main_kj_pic"><a href='workshoufaAction!list?sfkind=2&pid=${ps.id}' target="main"><img src="skin/images/frame/dot/6.jpg" width="48" height="47" border="0"></a></div>
      <div class="main_kj_txt"><a href='workshoufaAction!list?sfkind=2&pid=${ps.id}' target="main">收文管理</a></div>
    </div>       
    <div class="main_banner"></div>
    <div class="main_kj_box">
      <div class="main_kj_pic"><a href='affairsAction!list?pid=1' target="main"><img src="skin/images/frame/dot/7.jpg" width="46" height="42" border="0"></a></div>
      <div class="main_kj_txt"><a href='affairsAction!list?pid=1' target="main">审批流程</a></div>
    </div> 
    <div class="main_banner"></div>
    <div class="main_kj_box">
      <div class="main_kj_pic"><a href='wnl.html' target="main"><img src="skin/images/frame/dot/8.jpg" width="44" height="44" border="0"></a></div>
      <div class="main_kj_txt"><a href='wnl.html' target="main">万年历</a></div>
    </div>
    <div class="main_banner"></div>
    <div class="main_kj_box">
      <div class="main_kj_pic"><a href='personelAction!addresslist' target="main"><img src="skin/images/frame/dot/9.jpg" width="44" height="44" border="0"></a></div>
      <div class="main_kj_txt"><a href='personelAction!addresslist' target="main">通讯录</a></div>
    </div>    
  </div>
   -->
  <div class="main_line">
    <div class="main_line_tit">系统基本信息</div>
  </div>
  <div class="main_dotline">
    <div class="main_banner"></div>
    <div class="main_banner"></div>
    <div class="main_xtxx_pic"><img src="skin/images/frame/dot/index_r11_c6.jpg" width="47" height="44"></div>
    <div class="main_xtxx_txt">您的公众账号名称：管理员
		
	</div>
    <div class="main_xtxx_pic"><img src="skin/images/frame/dot/index_r11_c14.jpg" alt="" width="46" height="44"></div>
    <div class="main_xtxx_txt">系统版本信息：wcg_v1.0</div>
  </div>
  <!--  
  <div class="main_cont">
   <div class="main_box_s">
    <div class="main_box_stit">
      <div class="main_box_stit_txt">通知公告 </div>
      <div class="main_more"><a href='noticeAction!list?pid=${ps.id }' target="main">更多&gt;&gt;</a></div></div>
      <div class="main_box_scon">
      action放置于与此
      <s:iterator value="%{#request.noticerecs}" var="notice">
        <div class="news_line">
          <div class="news_line_tit">
          		<a href="noticeAction!view?id=<s:property value="#notice.noticeByNid.id" />&rnid=<s:property value="#notice.id" />">
					<s:property value="#notice.noticeByNid.title"/>
				</a>
			</div>
          <div class="news_line_date">
				<s:date name="#notice.noticeByNid.noticedate" format="yyyy-MM-dd"/>
			</div>
        </div>
        </s:iterator>
      </div>
   </div>
   <div class="main_banner"></div>
   <div class="main_box_s">
     <div class="main_box_stit">
       <div class="main_more"><a href="recemailAction!list?pid=${ps.id }">更多&gt;&gt;</a></div>
       <div class="main_box_stit_txt">内部邮件</div>
     </div>
     <div class="main_box_scon">
      action放置于与此
      <s:iterator value="%{#request.remails}" var="remail">
        <div class="news_line">
          <div class="news_line_tit">
          		<a href="recemailAction!view?id=<s:property value="#remail.id"/>">
					<s:property value="#remail.title"/>
				</a>
			</div>
          <div class="news_line_date">
				<s:date name="#remail.senddate" format="yyyy-MM-dd"/>
			</div>
        </div>
        </s:iterator>
       
     </div>
   </div>
  </div>
  <div class="main_cont">
   <div class="main_box_s">
    <div class="main_box_stit">
      <div class="main_box_stit_txt">个人申请记录</div>
      <div class="main_more"><a href="affairsAction!list?pid=${ps.id }">更多&gt;&gt;</a></div></div>
      <div class="main_box_scon">
	        action放置于与此
	      <s:iterator value="%{#request.affairss}" var="affairs">
	        <div class="news_line">
	          <div class="news_line_tit">
	          		<s:if test="#affairs.type==1">
	          			[
	          			<s:iterator value="#affairs.affairsassetses" var="asset">
				  			<s:property value="#asset.assets.code"/>,
				  		</s:iterator>
	          			]
				    	<s:if test="#affairs.status==1">
				            <a href="affairsAction!viewgoods?id=<s:property value="#affairs.id"/>&op=up">领物申请表</a>
				          </s:if>
						<s:else>
				        	<a href="affairsAction!viewgoods?id=<s:property value="#affairs.id"/>">领物申请表</a>
				        </s:else>
				        -
				        <s:if test="#affairs.status==1">
						  	未审核1
						  </s:if>
						  <s:elseif test="#affairs.status==2">
						  	未领取2
						  </s:elseif>
						  <s:elseif test="#affairs.status==3">
						  	未归还3
						  </s:elseif>
						  <s:elseif test="#affairs.status==4">
						  	已归还4
						  </s:elseif>
						  <s:elseif test="#affairs.status==5">
						  	已过期5
						  </s:elseif>
					</s:if>
					<s:if test="#affairs.type==2">
						[
						<s:property value="#affairs.applycode"/>
						]
				    	<s:if test="#affairs.status==1">
							<a href="affairsAction!viewmeetroom?id=<s:property value="#affairs.id"/>&op=up">会议室申请</a>
				    	</s:if>
				        <s:else>
				        	<a href="affairsAction!viewmeetroom?id=<s:property value="#affairs.id"/>">会议室申请</a>
				        </s:else>
				        
				        -
				        <s:if test="#affairs.status==1">
						  	未审核1
						  </s:if>
						  <s:elseif test="#affairs.status==2">
						  	未领取2
						  </s:elseif>
						  <s:elseif test="#affairs.status==3">
						  	未归还3
						  </s:elseif>
						  <s:elseif test="#affairs.status==4">
						  	已归还4
						  </s:elseif>
						  <s:elseif test="#affairs.status==5">
						  	已过期5
						  </s:elseif>
					</s:if>
				</div>
	          <div class="news_line_date">
					<s:date name="#affairs.applytime" format="yyyy-MM-dd "/>
				</div>
	        </div>
	        </s:iterator>
      </div>
   </div>
   <div class="main_banner"></div>
   <div class="main_box_s">
     <div class="main_box_stit">
       <div class="main_more"><a href="repairAction!list">更多&gt;&gt;</a></div>
       <div class="main_box_stit_txt">网络服务报修</div>
     </div>
     <div class="main_box_scon">
	       action放置于与此
	      <s:iterator value="%{#request.repairs}" var="repair">
	        <div class="news_line">
	          <div class="news_line_tit">
	          		<a href="repairAction!view?id=<s:property value="#repair.id"/>">
						<s:property value="#repair.rname"/>
					</a>
				</div>
	          <div class="news_line_date">
					<s:date name="#repair.rdate" format="yyyy-MM-dd"/>
				</div>
	        </div>
	        </s:iterator>

     </div>
   </div>
  </div>
  <div class="main_line">
    <div class="main_line_tit">友情链接</div>
  </div>
  <div class="main_link">
  <ul>
  <li><a href="http://www.tdcm.cn" target="_blank"><img src="skin/images/frame/dot/link1.jpg" width="100" height="35" border="0"></a></li>
  <li><a href="http://www.yixing.gov.cn" target="_blank"><img src="skin/images/frame/dot/link2.jpg" width="100" height="35" border="0"></a></li>
  <li><a href="http://www.thmz.com/" target="_blank"><img src="skin/images/frame/dot/link3.jpg" width="100" height="35" border="0"></a></li>
  <li><a href="http://www.vojs.cn/" target="_blank"><img src="skin/images/frame/dot/link4.jpg" width="100" height="35" border="0"></a></li>
  <li><a href="http://www.cctv.com/" target="_blank"><img src="skin/images/frame/dot/link5.jpg" width="100" height="35" border="0"></a></li>
  </ul>
  </div>
  -->
</div>

<div class="main_box_end">
  <div class="main_box_end_tleft"><img src="skin/images/frame/index_r7_c3.jpg" width="10" height="22"></div>
  <div class="main_box_end_tright"><img src="skin/images/frame/index_r7_c4.jpg" width="10" height="22"></div>
</div>
</div>

</body>
</html>