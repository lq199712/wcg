<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>幸运大转盘</title>
<script type="text/javascript">var yyuc_jspath = "/@system/";</script>
<script type="text/javascript" src="front/bigwheel/js/jquery.js"></script>
<script type="text/javascript" src="front/bigwheel/js/yyucadapter.js"></script>
<link rel="stylesheet" href="front/bigwheel/css/bootstrap.min.css">
<link rel="stylesheet" href="front/bigwheel/css/admin.css">
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
<link href="front/bigwheel/css/WdatePicker.css" rel="stylesheet" type="text/css"></head>
<body>
	<h3>幸运大转盘设置</h3>
	<div class="alert alert-info">
	  	<p><span class="bold">说明：</span>幸运大转盘是一种游戏促销模式。</p>
	</div>
	<form name="bigwheelform" class="form-horizontal" id="lbsForm" action="bigwheelAction!add" method="post" enctype="multipart/form-data">
	<s:hidden name="bigwheel.publicaccount" value="%{#session.pubclient.publicaccount}" />
	<div class="control-group">
	    	<label class="control-label" for="keyword">幸运大转盘名称
	    	
	    	</label>
	    	<div class="controls">
		    	<s:textfield name="bigwheel.name" id="xydzpname" class="span4"/>
				<span class="maroon">*</span>
			    	<span class="help-inline">最多只能输入30个字符。
				</span>
	    	</div>
	  	</div>
	  	<div class="control-group">
	    	<label class="control-label" for="keyword">活动关键字</label>
	    	<div class="controls">
	    		<s:textfield name="bigwheel.ikey" id="xydzpname" class="span4"/>		    	
	    		<span class="maroon">*</span>
		    	<span class="help-inline">最多只能输入20个字符。</span>
	    	</div>
	  	</div>
		<div class="control-group">
	    	<label class="control-label" for="location_p">活动开始时间</label>
	    	<div class="controls">
	    		<s:textfield name="bigwheel.timestart" class="span4">
				    <s:param name="value" ><s:date name="bigwheel.timestart" format="yyyy-MM-dd"/></s:param>
				</s:textfield>
				<span class="maroon">*</span>
				<span class="help-inline">例：2014-11-11（温馨提示请根据示例正确填写时间）</span>
			</div>
	  	</div>
	  
	  	<div class="control-group">
	    	<label class="control-label" for="category_f">活动结束时间</label>
	    	<div class="controls">
	    		<s:textfield name="bigwheel.timeend" class="span4">
				    <s:param name="value" ><s:date name="bigwheel.timeend" format="yyyy-MM-dd"/></s:param>
				</s:textfield>
				<span class="maroon">*</span>
				<span class="help-inline">例：2014-11-11（温馨提示请根据示例正确填写时间）</span>
			</div>
	  	</div>
		<div class="control-group">
		<label class="control-label" for="">活动展示图片</label>
			<div class="controls">
		<s:file name="picture" cssStyle="width:80%" onchange="change();" id="myfile"></s:file>
		<br/>
		<img alt="暂无图片" src="" id="myimage" width="62%" />
				<SCRIPT type="text/javascript">
							function change() {
							    var pic = document.getElementById("myimage"),
							        file = document.getElementById("myfile");
							 
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
	  	<div class="control-group">
			<label class="control-label" for="detail">活动简述:</label>
			<div class="controls">
			<s:textarea name="bigwheel.resume" id="xydzpms" class="span5" style="height:90px;width:520px;"></s:textarea>
			</div>
		</div>
  	
	  	<div class="cont fn-clear control-group">
		<h3 style="text-align: center;">奖项设置</h3>
		<table class="prizetable" style="margin-left: 80px;">
			<thead>
				<tr>
					<th width="100" height="30px;"></th>
					<th>奖项名称<br>(<span class="maroon">*</span><span class="help-inline">不能超过50个字 </span>)</th>
					<th>奖品<br>(<span class="maroon">*</span><span class="help-inline">不能超过50个字 </span>)</th>
					<th>奖品数量<br>(<span class="maroon">*</span><span class="help-inline">必须大于0 </span>)</th>
					<th>中奖概率<br>(<span class="maroon">*</span><span class="help-inline">0-100, 单位为%支持小数</span>)</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>奖项一</td>
					<td>
					<s:textfield value="" name="bigwheel.prize1" id="xydzpj1mc" class="span3"/>
					</td>
					<td>
					<s:textfield value="" name="bigwheel.prizename1" id="xydzpj1ms" class="span3"/>
					</td>
					<td>
					<s:textfield value="" name="bigwheel.prizenumber1" id="xydzpj1sl"  class="span1"  isint="1"/>
					</td>
					<td>
					<s:textfield  value=""  name="bigwheel.prizeprob1" id="xydzpj1gl"  class="span1" isfloat="1" />
					</td>
				</tr>
				<tr>
					<td>奖项二</td>
					<td>
					<s:textfield value="" name="bigwheel.prize2" id="xydzpj1mc" noneed="1" class="span3"/>
					</td>
					<td>
					<s:textfield value="" name="bigwheel.prizename2" id="xydzpj1ms" noneed="1" class="span3"/>
					</td>
					<td>
					<s:textfield value="" name="bigwheel.prizenumber2" id="xydzpj1sl" noneed="1"  class="span1"  isint="1"/>
					</td>
					<td>
					<s:textfield value="" name="bigwheel.prizeprob2" id="xydzpj1gl"  isfloat="1" noneed="1" class="span1"/>
					</td>
				</tr>
				<tr>
					<td>奖项三</td>
					<td>
					<s:textfield value="" name="bigwheel.prize3" id="xydzpj1mc" noneed="1" class="span3"/>
					</td>
					<td>
					<s:textfield value="" name="bigwheel.prizename3" id="xydzpj1ms" noneed="1" class="span3"/>
					</td>
					<td>
					<s:textfield value="" name="bigwheel.prizenumber3" id="xydzpj1sl" noneed="1"  class="span1"  isint="1"/>
					</td>
					<td>
					<s:textfield  value="" name="bigwheel.prizeprob3" id="xydzpj1gl"  isfloat="1" noneed="1" class="span1"/>
					</td>
				</tr>
				<!-- 
				<tr class="more" style="display:none;">
					<td>奖项四</td>
					<td>
					<s:textfield value="" name="bigwheel.prize4" id="xydzpj1mc" noneed="1" class="span3"/>
					</td>
					<td>
					<s:textfield value="" name="bigwheel.prizename4" id="xydzpj1ms" noneed="1" class="span3"/>
					</td>
					<td>
					<s:textfield value="" name="bigwheel.prizenumber4" id="xydzpj1sl" noneed="1"  class="span1"  isint="1"/>
					</td>
					<td>
					<s:textfield value="" name="bigwheel.prizeprob4" id="xydzpj1gl"  isfloat="1" noneed="1" class="span1"/>
					</td>
				</tr>
				<tr class="more" style="display:none;">
					<td>奖项五</td>
					<td>
					<s:textfield value="" name="bigwheel.prize5" id="xydzpj1mc" noneed="1" class="span3"/>
					</td>
					<td>
					<s:textfield value="" name="bigwheel.prizename5" id="xydzpj1ms" noneed="1" class="span3"/>
					</td>
					<td>
					<s:textfield value="" name="bigwheel.prizenumber5" id="xydzpj1sl" noneed="1"  class="span1"  isint="1"/>
					</td>
					<td>
					<s:textfield value="" name="bigwheel.prizeprob5" id="xydzpj1gl"  isfloat="1" noneed="1" class="span1"/>
					</td>
				</tr>
				<tr class="more" style="display:none;">
					<td>奖项六</td>
					<td>
					<s:textfield value="" name="bigwheel.prize6" id="xydzpj1mc" noneed="1" class="span3"/>
					</td>
					<td>
					<s:textfield value="" name="bigwheel.prizename6" id="xydzpj1ms" noneed="1" class="span3"/>
					</td>
					<td>
					<s:textfield value="" name="bigwheel.prizenumber6" id="xydzpj1sl" noneed="1"  class="span1"  isint="1"/>
					</td>
					<td>
					<s:textfield value="" name="bigwheel.prizeprob6" id="xydzpj1gl"  isfloat="1" noneed="1" class="span1"/>
					</td>
				</tr>
				
				 <tr><td><button id="more_jx" type="button">更多奖项</button></td><td> 提示:请依次填写奖项</td></tr>
				-->
			</tbody>
		</table>
	</div>
	<div class="cont fn-clear other-setting">
		<div class="cont-left msg-preview">
		<h3 style="text-align: center;">其他设置</h3>
		</div>
		<div class="cont-right">
			<div class="form-horizontal">
			  <div class="control-group">
			   <label class="control-label" for="showamount">是否显示奖品数量</label>
			    <div class="controls" >
			    	<s:select value="1" list="#{1:'显示',0:'不显示'}" name="bigwheel.isshownum" listKey="key" listValue="value"/>
			      	<span class="help-inline">选择显示后在活动页面中将会显示奖品数量</span>
			    </div>
			  </div>
			  <div class="control-group">
			   <label class="control-label" for="showamount">活动状态</label>
			    <div class="controls" >
			    	<s:select value="1" list="#{0:'准备中',1:'进行中',2:'活动已终止'}" name="bigwheel.currentstate" listKey="key" listValue="value"/>
			    </div>
			  </div>
			  <div class="control-group">
			    <label class="control-label" for="playtotal">每人参与的总次数</label>
			    <div class="controls">
			    	<s:textfield value="" name="bigwheel.totimes" id="xydzpmrzs" class="span1" isint="1"/>
			    </div>
			  </div>
			  <!--  
			  <div class="control-group">
			    <label class="control-label" for="playperday">每天最多出奖数量</label>
			    <div class="controls">
			    	<s:textfield value="0" name="bigwheel.maxnumofprizes" id="xydzpmrzd" class="span1" isint="1"/>
			    	<span class="maroon">*</span><span class="help-inline">必填 ，0为不限制出奖数</span>
			    </div>
			  </div>
			  -->
			</div>
		</div>
	</div>
 		<div class="control-group">
		    <div class="controls">
		     <s:token></s:token>
		      <button id="save-btn" type="submit" class="btn btn-primary btn-large">保存并开启</button>
		     
		    </div>
	    </div>
	</form>
<script type="text/javascript" src="bigwheel/js/comm.js"></script>
<script type="text/javascript">
$(function(){
	$("#more_jx").click(function(){
		 $(".more").toggle();
		 
	 });
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
					$(this).val('0');
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
    });
});
</script>
<br><br><br>
</body>
</html>