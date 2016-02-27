//删除用户,代理,员工等操作
/*function delete(id,o){
		var ids = [];
		$('td').find('input[type="checkbox"]:checked').each(function(){
			ids[ids.length] = $(this).val();
		});
		if(ids.length == 0){
			tusi('请选择！');
			return false;
		}
		if(confirm('确定删除吗？')){
			ajax('delete-del-'+id+'.html',{ id:ids.join(',')},function(data){
				if(data == 'ok'){
					tusi('操作成功');
					setTimeout(function(){
						goto(location.href);
					},500);
				}
			});	
		}
}
*/
$(function(){
	var picjk = setInterval(function(){
		if($('#picsethere').find('img').size()>0){
			$('#picsethere').find('img').each(function(){
				$(this).error(function(){
					$(this).attr('src','../res/demopic.jpg');
				});
				$(this).attr('src',$(this).attr('src'));
			});
			clearInterval(picjk);
		}
	},500);
});
//标识使用
function toused(id,o){
	if(!window.pophtm){
		window.pophtm = $('#jfczarea').html();
		$('#jfczarea').remove();
	}
	window.yjsid = id;
	pophtml(window.pophtm,360,150);
}
//门店消费
function fyjs(controlName){
	var bz = $('.bz').val();
	var md = $('.mdlb').val();
	ajax(controlName+'-used.html',{ id:window.yjsid,md:md,bz:bz},function(m){
		tusi('操作成功');
		setTimeout(function(){
			location.href =location.href; 
		},1000);
	});
}
//上传图片
function setpic(imgid,hideid){
	window.piccbk = function(m){
		$('#'+imgid).attr('src',m);
		$('#'+hideid).val(m);
		window.piccbk = null;
	}
	window.curpic = null;
	openpicset();	
} 
function openpicset(){
	pophtml('<iframe src="../businessModule/wspicif.html" style="width:630px;height:470px;border:none;background-color: #dfdfdf;" width="630px" height="475px"></iframe>',670,510,true);
}
//upload pic end

function selallck(o){
	if($(o).prop('checked')){
		$('td').find('input[type="checkbox"]').prop('checked',true);
	}else{
		$('td').find('input[type="checkbox"]').prop('checked',false);
	}
}
// delete all or delete single
function dellbs(controlName,id,o){
	if(id=='a'){
		var ids = [];
		$('td').find('input[type="checkbox"]:checked').each(function(){
			ids[ids.length] = $(this).val();
		});
		if(ids.length == 0){
			alert('请选择要删除的选项');
	        return false;
		}else{
		if(confirm('确定删除这些信息吗？')){
			ajax(controlName+'-del.html',{ id:ids.join(',')},function(){
				$('td').find('input[type="checkbox"]:checked').each(function(){
					$(this).parent().parent().remove();
				});
			});	
		}
	}
	}else{
		if(confirm('确定删除此条信息吗？')){
			ajax(controlName+'-del.html',{ id:id},function(){
				$(o).parent().parent().remove();
			});	
		}
	}	
}