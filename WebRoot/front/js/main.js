var SW,SH,myIScroll,
	isTouchPad = (/hp-tablet/gi).test(navigator.appVersion),hasTouch = 'ontouchstart' in window && !isTouchPad,
	START_EV = hasTouch ? 'touchstart' : 'mousedown',
	MOVE_EV = hasTouch ? 'touchmove' : 'mousemove',
	END_EV = hasTouch ? 'touchend' : 'mouseup',
	CANCEL_EV = hasTouch ? 'touchcancel' : 'mouseup',isAjaxLoad=false;
	
$(document).ready(function(e) {
	var currentHash=window.location.hash;
    var init=function(){
		//$('.stage1 .stageBg').fadeIn(1500);
		window.setTimeout(function(){
			$('.loading').fadeOut(1000);
			$('.stage1 .stageBg').fadeIn(1000);
			common.init();
			var myS6=$('.s6-container').s6();
			if(currentHash=='#pano'){
				common.enterHome();
				window.location.hash='#home';
			}else{
				window.setTimeout(disInfo1,800);
				window.location.hash='#info';
			}
		},100)
	}
	
	
	
	$('.homeContent ').live('click', function(e) {
		var url = $(this).attr('name');
		//trace('url=========================================================================:'+url);
		//$('#myContainer').fadeOut(function(){
		url = url.replace(/^.*#/, '');
		if(url!='panorama'){
			$.history.load(url);
		}else{
			window.open('360/index.html');
			//var intro='<iframe src="360/index.html" frameborder=0 scrolling="no" width="100%" height="100%"></iframe>';	
			/*
			window.setTimeout(function(){
				//$('#myPage').html(intro);
			},1000);*/
		}
		//$('#loading').fadeIn('slow');
		//});
		return false;
	});
	
	/********************************************************************************/
	/*AJAX加载页面*/
	/********************************************************************************/
	
	$.history.init(function(url) {
		trace('url++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++:'+url)
		//if(url=='home')return;
		if(currentHash==url)return;
		if(url=='info'){isAjaxLoad=true;return;}
		if(isAjaxLoad){
			if(url)lazyLoading(url == "" ? "qr" : url);
			currentHash=url;
		}
		//alert(window.location.hash);
		isAjaxLoad=true;
		//lazyLoading(url);
	});
		
	function lazyLoading(url){		
		setTimeout(function(){
			loadadd(url);
		},1400)
	}
		
	function loadadd(src) {
		$('#myPage').hide();
		$('#myPage').load(src +".html",loaded);
		//$('#myPage').load('index' +".html",loaded);
	}
	
	function loaded(){
		$('#myPage').fadeIn(1000);
		
		trace('page loaded!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!');	
	}
	
	/********************************************************************************/
	/*引导页*/
	/********************************************************************************/
	var disInfo1=function(){
		var $t1=$('.stageTxt .t1');
		var $t2=$('.stageTxt .t2');
		var $t3=$('.stageTxt .t3');
		
		//$t1.fadeIn(1000);
		//$t2.delay(600).fadeIn(1000);
		$t1.css({'opacity':0,'marginTop':-300});
		TweenLite.to($t1,2,{delay:0.2,css:{'marginTop':-330,'opacity':1,'display':'block'},ease:Linear.easeInOut})
		
		$t2.css({'opacity':0,'marginTop':-40});
		TweenLite.to($t2,1.5,{delay:0.6,css:{'marginTop':-70,'opacity':1,'display':'block'},ease:Linear.easeInOut})
		
		$t3.css({'opacity':0,'marginTop':200});
		TweenLite.to($t3,1,{delay:1,css:{'marginTop':170,'opacity':1,'display':'block'},ease:Linear.easeInOut})
		
		var isEnterHome=false;
		TweenLite.delayedCall(3.5,function(){
			if(!isEnterHome){
				$('#main').unbind('click');
				common.enterHome();
			}
		});
		$('#main').one('click',function(){
			isEnterHome=true;
			common.enterHome();
		});
	}
	

	
	function resizeHandler(){
		SH=$(window).height();
		SW=$(window).width();
		trace(SH);
	}
	
	$(window).resize(function(e){
		resizeHandler();
	})
	resizeHandler();
	
	//init();
	loadImages(siteData,init);
});


//返回主页
function backHome(){
	trace('backHome');
	window.location.hash='home';
	TweenLite.to('#myContainer',1,{css:{'margin-left':-SW},ease:Expo.easeInOut,onComplete:function(){
		$('#myPage').empty();
		$('#myContainer').css({'margin-left':0,'display':'none'});
		
		action.pause=false;
		action.playControl();
	}})
	
	
}

function trace(src){
	console.log(src);
	//$('.output').html(src);
	
}





/*
window.onload=function ()
{
	var oDiv=document.getElementById('div1');
	var aTime=[];
	
	var last='000000';
	
	for(var i=0;i<8;i++)
	{
		var oBox=document.createElement('div');
		oBox.className='box';
		
		if((i+1)%3)
		{
			aTime.push(oBox);
			oBox.innerHTML=
				'<span>0</span>'+
				'<div class="top"><span>0</span></div>'+
				'<div class="tran move">'+
					'<div class="front"><span>0</span></div>'+
					'<div class="back"><span>0</span></div>'+
				'</div>';
		}
		else
		{
			oBox.innerHTML='<span class="dian">:</span>';
		}
		
		oDiv.appendChild(oBox);
	}
	
	function inner()
	{
		function toDou(n){return n<10?'0'+n:''+n;}
		var oDate=new Date();
		var now=toDou(oDate.getHours())+toDou(oDate.getMinutes())+toDou(oDate.getSeconds());
		
		for(var i=0;i<now.length;i++)
		{
			if(now.charAt(i)!=last.charAt(i))
			{
				aTime[i].className='box';
				aTime[i].innerHTML=
					'<span>'+last.charAt(i)+'</span>'+
					'<div class="top"><span>'+now.charAt(i)+'</span></div>'+
					'<div class="tran move">'+
						'<div class="front"><span>'+last.charAt(i)+'</span></div>'+
						'<div class="back"><span>'+now.charAt(i)+'</span></div>'+
					'</div>';
				
				(function (box){
					setTimeout(function (){
						box.className='box active';
					}, 0);
				})(aTime[i]);
			}
		}
		
		last=now;
	}
	
	setInterval(inner, 1000);
};*/