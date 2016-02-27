$(function(){
	//禁止窗口滚动
	$(window).scroll(function(){
		if(window.helpmsg){
			$(window).scrollTop(window.helpscrolltop);
			$(window).scrollLeft(window.helpscrollleft);
		}
	});
});

function openhelp(msg){
	if(!window.helpmsg){
		window.helpmsg = msg;
		window.helpind = 0;
		
	}
	$('.maskdivgen').remove();
	window.helpscrolltop = $(window).scrollTop();
	window.helpscrollleft = $(window).scrollLeft();
	window.helpmask = $('<div class="maskdivgen" style="position: absolute;z-index: 9966;left:'+window.helpscrollleft+'px;top:'+window.helpscrolltop+'px;overflow:hidden;height:'+$(window).height()+'px;width:'+$(window).width()+'px;"><div class="maskdivgensub" style="position:relative;width:100%;height:100%;"></div></div>');
	$('body').append(window.helpmask);
	window.helpmasksub = window.helpmask.find('.maskdivgensub');
	window.helpmaskpic = $('<img style="border: none;position: absolute;" src="/res/helpmask.png" class="maskdivgensubpic"/>');
	window.helpmasksub.append(window.helpmaskpic);
	window.helpmasksub.append('<img style="border: none;position: absolute;right:20px;top:20px;cursor: pointer;" onclick="openhelp_stop()" src="/res/helpclose.png" class="maskdivgensubpicclose"/>');
	
	var cmsg = window.helpmsg[window.helpind];
	var x = cmsg.ele.offset().left;
	var y = cmsg.ele.offset().top;
	var w = cmsg.ele.width();
	var h = cmsg.ele.height();
	//计算遮罩并添加遮罩层
	var iw = w*100;
	var ih = h*100;
	var ix = x-iw/2+w/2;
	var iy = y-ih/2+h/2;
	window.helpmaskpic.height(ih).width(iw).css({ left:ix+'px',top:iy+'px'});	
	openhelp_cicle(x-6,y-6,w,h);
	

	window.helpmaskmain = $('<div style="position: absolute;max-width:800px;min-width:500px;width:'+(cmsg.pic_w+40)+'px;border-radius:12px;background: #ffffff;"><div style="margin:20px;margin-top:40px;font-size: 20px;font-weight: bold;color: #ce8e00;">'+cmsg.msg+'</div><div style="text-align:center;"><img src="'+cmsg.pic+'" style="margin:20px;width:'+cmsg.pic_w+'px;height:'+cmsg.pic_h+'px;"/></div><div style="font-size: 20px;font-weight: bold;color: #943400;margin:20px;margin-bottom:40px;">'+cmsg.des+'</div></div>');
	window.helpmasksub.append(window.helpmaskmain);
	//判断位置增加指向箭头
	var zy = 'y';
	var ax = x-20;
	
	var mx = ax-40-window.helpmaskmain.width();
	if(x<$(window).width()/2){
		zy = 'z';
		ax = x+w-20;
		mx = ax+80;
	}
	var sx = 'x';
	var ay = y-80;
	var my = ay-window.helpmaskmain.height()/2;
	if(y<$(window).height()/2){
		sx = 's';
		ay = y+h+6;
		my = ay+80-window.helpmaskmain.height()/2;		
	}
	if(my<0){
		my = 60;
	}
	if(my+window.helpmaskmain.height()>$(window).height()){
		my = $(window).height()-window.helpmaskmain.height()-40;
	}
	//添加信息
	window.helpmaskarrow = $('<img style="border: none;position: absolute;" src="/res/'+zy+sx+'.png" class="maskdivgensubarrow"/>');
	window.helpmasksub.append(window.helpmaskarrow);
	window.helpmaskarrow.css({ left:ax+'px',top:ay+'px'});
	window.helpmaskmain.css({ left:mx+'px',top:my+'px'});
	openhelp_cicle(mx-16,my-16,window.helpmaskmain.width()+20,window.helpmaskmain.height()+20,'red');
	//添加步骤
	if(window.helpind !=0){
		window.helpmaskprev = $('<img style="border: none;position: absolute;cursor: pointer;" onclick="window.helpind--;openhelp();" src="/res/helpprev.png"/>');
		window.helpmasksub.append(window.helpmaskprev);
		window.helpmaskprev.css({ left:(mx-70)+'px',top:(my-30)+'px'});
	}
	if(window.helpind<window.helpmsg.length-1){
		window.helpmasknexy = $('<img style="border: none;position: absolute;cursor: pointer;" onclick="window.helpind++;openhelp();" src="/res/helpnext.png"/>');
		window.helpmasksub.append(window.helpmasknexy);
		window.helpmasknexy.css({ left:(mx+window.helpmaskmain.width()-70)+'px',top:(my+window.helpmaskmain.height()-30)+'px'});
	}
	if(window.helpind==window.helpmsg.length-1){
		window.helpmasknexy = $('<img style="border: none;position: absolute;cursor: pointer;" onclick="openhelp_stop();" src="/res/helpgo.png"/>');
		window.helpmasksub.append(window.helpmasknexy);
		window.helpmasknexy.css({ left:(mx+window.helpmaskmain.width()/2-70)+'px',top:(my+window.helpmaskmain.height()-30)+'px'});
	}
}
function openhelp_stop(){
	$('.maskdivgen').remove();
	$('.openhelp_cicle_div').remove();
	window.helpmsg = null;
}

function openhelp_cicle(x,y,w,h,cor){
	if(!cor){
		cor = '#ffffff';
	}
	window.helpmasksub.append('<div class="openhelp_cicle_div" style="border: 6px dashed '+cor+';border-radius:10px;position: absolute;width: '+w+'px;height: '+h+'px;left: '+x+'px;top: '+y+'px;"></div>');
}