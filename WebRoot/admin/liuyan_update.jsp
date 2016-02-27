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
<title>留言设置(修改)</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>

<link rel="stylesheet" href="css/admin/bootstrap.min.css">
<link rel="stylesheet" href="css/admin/admin.css">
<style type="text/css">
	table td {
		min-width:50px;
		overflow:hidden;text-overflow:ellipsis;
	}
	#picsethere{
		width: 510px;
		display: block;
	}
	#picsethere img{
		max-width: 500px;
		display: block;
	}
</style>
</head>
<body>
	<h3>留言设置</h3>
	<div class="alert alert-info">
	  	<p><span class="bold">说明：</span>说明内容</p>
	</div>
	<form class="form-horizontal" id="lbsForm" action="messageAction!update" method="post"   onsubmit="return checkform();"><input type="hidden" value="54dac5d4eee48" name="YYUC_FORM_TOKEN"/><input type="hidden" value = "" name="C1lSS1ttEkIXQ1QYZA1S" id="micro_surveyid" />		
	  	<s:hidden name="message.id"></s:hidden>
	  	<s:hidden name="message.publicaccount"></s:hidden>
	  	<s:hidden name="message.messageip"></s:hidden>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">留言人姓名</label>
	    	<div class="controls">
	    			<s:textfield name="message.name" id="name" readonly="true" cssClass="span4"></s:textfield>
	    	</div>
	  	</div>
	  	
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">留言时间</label>
	    	<div class="controls">
	    			<s:textfield name="message.messagetime" id="messagetime" readonly="true" cssClass="span4"></s:textfield>
	    			
	    	</div>
	  	</div>

	  	<div class="control-group">
			<label class="control-label" for="detail">留言内容:</label>
			<div class="controls">
				<s:textarea name="message.messagecontent" id="messagecontent" readonly="true"  cssClass="span5" cssStyle="height:90px;width:520px;" ></s:textarea>
			</div>
		</div>
		
		
		
		<div class="control-group">
	    	<label class="control-label" for="keyword">回复人姓名</label>
	    	<div class="controls">
	    			<s:textfield name="message.replyname" id="replyname" cssClass="span4"  placeholder="请输入您的姓名"></s:textfield>
	    	</div>
	  	</div>
	  		
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">回复时间</label>
	    	<div class="controls">
	    			<input type="date"  name="message.replytime"   value="<s:property value="message.replytime"/>"  id="replytime" class="span4"   />	 
	    			
	    	</div>
	  	</div>

	  	<div class="control-group">
			<label class="control-label" for="detail">回复内容:</label>
			<div class="controls">
				<s:textarea name="message.replycontent" id="replycontent" placeholder="请输入您的回复"  cssClass="span5" cssStyle="height:90px;width:520px;" ></s:textarea>
			</div>
		</div>
		
		
		
		 <div class="control-group">
	    	<label class="control-label" for="keyword">是否审核</label>
	    	<div class="controls">
	    	<s:select name="message.messagestate" id="messagestate" cssClass="dropdown-select" list="#{'0':'未审核','1':'已审核'}" label="审核类型" headerKey="" ></s:select> 
						
	    	</div>
	    	
	    	
	    <div class="control-group">
	    	<label class="control-label" > </label>
	  	</div>
	  	
	  	
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">微信页面是否显示</label>
	    	<div class="controls">
	    			<s:select name="message.isshow" id="isshow" cssClass="dropdown-select" list="#{'0':'不显示','1':'显示'}" label="显示类型" headerKey="" ></s:select> 
			
	    	</div>
	  	</div>
				
		<!--  
		<div class="control-group">
			<label class="control-label" for="detail">领导批示:</label>
			<div class="controls">
			<textarea name="C1lSS1ttEkIXQ1QYZAlF"   id="micro_surveyms" class="span5" style="height:90px;width:520px;"></textarea>				<span class="maroon">*</span><br><span class="help-inline">最多为1000个字符。</span>
			</div>
		</div>

		<div class="control-group">
	    	<label class="control-label" for="keyword">处理部门</label>
	    	<div class="controls">
	    	<input type="text"   value="" name="C1lSS1ttEkIXQ1QYZANcHA==" id="micro_surveygjz" class="span4"/>	
	    	</div>
	  	</div>

	  	<div class="control-group">
	    	<label class="control-label" for="keyword">处置人</label>
	    	<div class="controls">
	    	<input type="text"   value="" name="C1lSS1ttEkIXQ1QYZANcHA==" id="micro_surveygjz" class="span4"/>	
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">联系电话</label>
	    	<div class="controls">
	    	<input type="text"   value="" name="C1lSS1ttEkIXQ1QYZANcHA==" id="micro_surveygjz" class="span4"/>	
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">答复日期</label>
	    	<div class="controls">
	    	<input type="text"   value="" name="C1lSS1ttEkIXQ1QYZANcHA==" id="micro_surveygjz" class="span4"/>	
	    	</div>
	  	</div>
	  	<div class="control-group">
			<label class="control-label" for="detail">处理结果:</label>
			<div class="controls">
			<textarea name="C1lSS1ttEkIXQ1QYZAlF"   id="micro_surveyms" class="span5" style="height:90px;width:520px;">
			</textarea>				<span class="maroon">*</span><br><span class="help-inline">最多为1000个字符。</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="detail">审核意见:</label>
			<div class="controls">
			<textarea name="C1lSS1ttEkIXQ1QYZAlF"   id="micro_surveyms" class="span5" style="height:90px;width:520px;">
			</textarea>				<span class="maroon">*</span><br><span class="help-inline">最多为1000个字符。</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="detail">案件历史:</label>
			<div class="controls">
			<textarea name="C1lSS1ttEkIXQ1QYZAlF"   id="micro_surveyms" class="span5" style="height:90px;width:520px;">
			</textarea>				<span class="maroon">*</span><br><span class="help-inline">最多为1000个字符。</span>
			</div>
		</div>

 		<div class="control-group">
		    <div class="controls">
		    
		      <button id="save-btn" type="submit" class="btn btn-primary btn-large">保存</button>&nbsp;&nbsp;&nbsp;&nbsp;
		     <button id="save-btn" type="submit" class="btn btn-primary btn-large">一键转入OA</button>
		    </div>
	    </div>
	</form>
<script type="text/javascript" src="js/comm.js"></script>
<script type="text/javascript">
$(function(){
	 $("#lbsForm").submit(function(){
		var cansv= true;
		$(this).find('input[type="text"],select,textarea').each(function(){
			if($.trim($(this).val())=='' && $(this).attr('noneed')!='1'){
				cansv = false;
				$(this).css('backgroundColor','yellow');
				$(this).one('focus',function(){
					$(this).css('backgroundColor','transparent');
				});
			}
		});
		if(!cansv){
			tusi('请将信息填写完整');
			return false;
		}
		$(this).find('input[type="text"],select,textarea').each(function(){
			if($(this).attr('isint')=='1' && $.trim($(this).val())!=''){
				var intthis = parseInt2($(this).val());
				if(intthis+''=='NaN'){
					cansv = false;
					$(this).css('backgroundColor','yellow');
					$(this).one('focus',function(){
						$(this).css('backgroundColor','transparent');
					});
				}else{
					$(this).val(parseInt($(this).val()));
				}
			}
		});
		if(!cansv){
			tusi('标注的项目必须为整数');
			return false;
		}
		
		$(this).find('input[type="text"],select,textarea').each(function(){
			if($(this).attr('isfloat')=='1' && $.trim($(this).val())!=''){
				var intthis = parseFloat($(this).val());
				if(intthis+''=='NaN'){
					$(this).val('0');
					cansv = false;
					$(this).css('backgroundColor','yellow');
					$(this).one('focus',function(){
						$(this).css('backgroundColor','transparent');
					});
				}else{
					$(this).val(parseFloat($(this).val()));
				}
			}
		});
		if(!cansv){
			tusi('标注的项目必须为数字');
			return false;
		}
		
		if($('#picsethere').find('img').size()<1){
   		cansv = false;
   		tusi('请上传活动图片');
   		return false;
   	}
   	return cansv;
   });
});
</script>
<br/><br/><br/></body>
-->
	<div class="control-group">
		    <div class="controls">
		    
		 <s:token></s:token>
<input type="submit" class="btn btn-primary btn-large"  value="保存" />
		    </div>
	    </div>


</form>
</html>