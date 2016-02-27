function tellcjok(fs){
	$.ajax({
		url:'/wx/toendhd2-'+fs+'.html',
		data:{ hid:$('#hdid').val()},
		type:'post',
		success:function(jx){
			if(jx && jx[0] != '0'){
				$('#zjtzdiv').slideDown('normal');
				window.lid = jx[1];
			}else{
				tusi('很遗憾，您没有中奖');
				setTimeout(function(){
					location.reload(true);
				},1888);
			}
		}
	});
}
function tellcjxxok(fs){
	var sjh = $.trim($('#tel').val());
	var un = $.trim($('#un').val());
	var wxun = $.trim($('#wxun').val());
	var hid = $.trim($('#hdid').val());
	if (hid==432){
		$.ajax({
			url:'http://m.dashipin.com/mobile/user.php',
			data:{act:'checkcode',tel:sjh,username:un,sex:1,code:'aca48b07750f82f383a7371e746b1da8'},
			type:'get',
			success:function(msg){
				if (msg=0){
					tusi('OK!')
				}
			}
		});
	}
	if(sjh!='' && un !=''){
		$.ajax({
			url:'/wx/toendhd2-'+fs+'.html',
			data:{ hid:$('#hdid').val(),sjh:sjh,un:un,wxun:wxun,'lid':window.lid},
			type:'post',
			success:function(jx){
				tusi('提交成功.');
				setTimeout(function(){
					location.reload(true);
				},1888);
				
			}
		});
	}else{
		tusi('请填写完整信息');
		return false;
	}	
}