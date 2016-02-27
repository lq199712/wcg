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
<title>投诉办理</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/yyucadapter.js"></script>
<SCRIPT type="text/javascript">
function checkform(){
		var name = document.getElementById('name').value;
		var telphone = document.getElementById('telphone').value;
		var comptype = document.getElementById('comptype').value;
		var content = document.getElementById('content').value;
		
		
		if(name=='')
		{
			alert("请输入您的姓名.");
			return false;
		}
		if(telphone=='')
		{
			alert("请输入您的电话.");
			return false;
		}
		if(!(/(^(\d{3,4}-)?\d{7,8})$|(^1[3|4|5|8][0-9]{9})/.test(telphone))||telphone.length>11){
	        alert("不是正确的11位手机号,请重新输入.");
			return false;
	    }
		if(comptype==0)
		{
			alert("请选择投诉类型.");
			return false;
		}
		if(content=='')
		{
			alert("请输入投诉内容.");
			return false;
		}
	return true;
}

</SCRIPT>

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
	<h3>投诉办理</h3>
	<div class="alert alert-info">
	  	<p><span class="bold">说明：</span>说明内容</p>
	</div>
	<form class="form-horizontal" id="lbsForm" action="complaintAction!add" method="post"  enctype="multipart/form-data" onsubmit="return checkform();"><input type="hidden" value="54dac5d4eee48" name="YYUC_FORM_TOKEN"/><input type="hidden" value = "" name="C1lSS1ttEkIXQ1QYZA1S" id="micro_surveyid" />		
		<div class="control-group">
	    	<label class="control-label" for="keyword">投诉类型</label>
	    	<div class="controls">
	    	<s:select name="complaint.comptype" id="comptype" cssClass="dropdown-select" list="#{'1':'市容面貌','2':'宣传广告','3':'园林绿化','4':'黑车','5':'城市湖道','6':'街面秩序','7':'施工管理'}" label="投诉类型" headerKey="" headerValue="请选择投诉类型"></s:select> 
						
	    	</div>
	  	</div>
	<!-- 
		<div class="control-group">
	    	<label class="control-label" for="keyword">发起单位</label>
	    	<div class="controls">
	    	<input type="text"   value="" name="C1lSS1ttEkIXQ1QYZApXC1I=" id="micro_surveyname" class="span4"/>		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入30个字符</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">发起人员</label>
	    	<div class="controls">
	    	<input type="text"   value="" name="C1lSS1ttEkIXQ1QYZANcHA==" id="micro_surveygjz" class="span4"/>		    	<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入20个字符</span>
	    	</div>
	  	</div>
		<div class="control-group">
	    	<label class="control-label" for="location_p">发起日期</label>
	    	<div class="controls">
	    	<input type="text"   value=""  id="micro_surveykssj" class="span4" name="C1lSS1ttEkIXQ1QYZA9FFV0=" onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd HH:mm:ss'})" relobj="yyuccalendar" rel="yyuc"/>	    	</div>
	  	</div>
	  
	  	<div class="control-group">
	    	<label class="control-label" for="category_f">受理日期</label>
	    	<div class="controls">
	    	<input type="text"   value=""  id="micro_surveyjssj" class="span4" name="C1lSS1ttEkIXQ1QYZA5FFV0=" onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd HH:mm:ss'})" relobj="yyuccalendar" rel="yyuc"/>	    	</div>
	  	</div>

	  	<div class="control-group">
	    	<label class="control-label" for="category_f">到期日期</label>
	    	<div class="controls">
	    	<input type="text"   value=""  id="micro_surveyjssj" class="span4" name="C1lSS1ttEkIXQ1QYZA5FFV0=" onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd HH:mm:ss'})" relobj="yyuccalendar" rel="yyuc"/>	    	</div>
	  	</div>

	  	<div class="control-group">
	    	<label class="control-label" for="keyword">处置天数</label>
	    	<div class="controls">
	    	<input type="text"   value="" name="C1lSS1ttEkIXQ1QYZANcHA==" id="micro_surveygjz" class="span4"/>		    	<span class="maroon">*</span>
		    	<span class="help-inline">只能输入数字</span>
	    	</div>
	  	</div>
		
	  	
	  	
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">案件性质</label>
	    	<div class="controls">
	    	<input type="text"   value="" name="C1lSS1ttEkIXQ1QYZANcHA==" id="micro_surveygjz" class="span4"/>	
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">案件来源</label>
	    	<div class="controls">
	    	<input type="text"   value="" name="C1lSS1ttEkIXQ1QYZANcHA==" id="micro_surveygjz" class="span4"/>	
	    	</div>
	  	</div>
	  	
	  	 -->
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">投诉人</label>
	    	<div class="controls">
	    			<s:textfield name="complaint.name" id="name" cssClass="span4" placeholder="请输入您的名字"></s:textfield>
							
	    	</div>
	  	</div>
	  	<!--  
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">投诉单位</label>
	    	<div class="controls">
	    	<input type="text"   value="" name="C1lSS1ttEkIXQ1QYZANcHA==" id="micro_surveygjz" class="span4"/>	
	    	</div>
	  	</div>
	  	
	  	-->
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">投诉电话</label>
	    	<div class="controls">
	    	<s:textfield name="complaint.telphone" id="telphone"  cssClass="span4"  placeholder="请输入您的电话"></s:textfield>
							
	    	</div>
	  	</div>
	  	
	  	<!-- 
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">投诉主题</label>
	    	<div class="controls">
	    	<input type="text"   value="" name="C1lSS1ttEkIXQ1QYZANcHA==" id="micro_surveygjz" class="span4" style="width:520px;"/>	
	    	</div>
	  	</div>
	  	 -->

	  	<div class="control-group">
			<label class="control-label" for="detail">投诉内容:</label>
			<div class="controls">
				<s:textarea name="complaint.content" id="content"   cssClass="span5" cssStyle="height:90px;width:520px;" placeholder="请投诉"></s:textarea>
				<span class="maroon">*</span><br><span class="help-inline">最多为1000个字符。</span>
			</div>
		</div>
		
		  <div class="control-group">
			<label class="control-label" for="detail">投诉照片:</label>
			<div class="controls">
			<label>
		 <s:file name="picture"  cssStyle="width:80%" accept="image/jpeg,image/png,image/jpg"  onchange="change();" id="myfile"></s:file>
	  </label>
		<br/>
		<img alt="暂无图片"  id="myimage" width="300px" height="256px"/>
				<SCRIPT type="text/javascript">
							function change() {
							    var pic = document.getElementById("myimage"),
							        file = document.getElementById("myfile");
							         console.log(pic,file);
							    var ext=file.value.substring(file.value.lastIndexOf(".")+1).toLowerCase();
							     // gif在IE浏览器暂时无法显示
							     if(ext!='png'&&ext!='jpg'&&ext!='jpeg'){
							         alert("图片的格式必须为png或者jpg或者jpeg格式！"); 
							         return;
							     }
							     var isIE = navigator.userAgent.match(/MSIE/)!= null,
							         isIE6 = navigator.userAgent.match(/MSIE 6.0/)!= null;
							 
							     if(isIE) {
							        file.select();
							        var reallocalpath = document.selection.createRange().text;
							 
							        // IE6浏览器设置img的src为本地路径可以直接显示图片
							         if (isIE6) {
							            pic.src = reallocalpath;
							         }else {
							            // 非IE6版本的IE由于安全问题直接设置img的src无法显示本地图片，但是可以通过滤镜来实现
							             pic.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image',src=\"" + reallocalpath + "\")";
							             // 设置img的src为base64编码的透明图片 取消显示浏览器默认图片
							             pic.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
							         }
							     }else {
							        html5Reader(file);
							     }
							     pic.alt = '图片';
							}
							 
							 function html5Reader(file){
							     var file = file.files[0];
							     var reader = new FileReader();
							     reader.readAsDataURL(file);
							     reader.onload = function(e){
							         var pic = document.getElementById("myimage");
							         pic.src=this.result;
							     }
							 }
				</SCRIPT>
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