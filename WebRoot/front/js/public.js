var common={
	slowAds:[],
	init:function(){
		var banTouchmove=function(e){
			e.preventDefault();
			return false;
		}
		//$('#myContainer')[0].addEventListener('touchmove', banTouchmove, false);
		document.addEventListener('touchmove', banTouchmove, false);
		//$('#myMain')[0].addEventListener('touchmove', banTouchmove, false);
		$('img')[0].addEventListener('touchmove', banTouchmove, false);
			
		var $slowAd = $('[data-slow]');
		$slowAd.each(function(){
			var $view = $(this);
			var elem = new slowObj(this);
			common.slowAds.push( elem );
		});
		
		function slowObj( view , options ) {
			options = options || {};
			var $view = $(view);
			this.view = $view;
			this.class=$view.attr('class');
			this.name=$view.attr('name');
		}
		
		//startEnterHome();
/*
		var len=$('.RO').length;
		for(var i=0;i<len;i++){
			$('.RO')[i].addEventListener('touchstart', common.touchstart, false);
			$('.RO')[i].addEventListener('touchend', common.touchend, false);
		}
		
		$('.RO').click(function(){
			//alert(1);
			var pano=$(this).attr('name');
			if(pano=='hot_line'){
				window.location='tel:02133820888';
				return false
			};
			
			if(pano=='panorama' || pano=='hot_line')return;
			
			
			$(this).css({'position':'fixed','zIndex':5});
			action.distortion('turn3d',this,90);
			
			var len=common.slowAds.length;
			var objClass=$(this).attr('name');
			for(var i=0;i<len;i++){
				if(common.slowAds[i].name==objClass)continue;
				var $slow=common.slowAds[i].view;
				TweenLite.to($slow,0.3,{delay:i*0.01,alpha:0.4});
			}
			
			$('.backBtn').css({'right':-106});
			TweenLite.to($('.backBtn'),0.5,{delay:1,css:{'right':0}});
			//暂停播放动画
			action.pause=true;
		});
*/
	},
	
	enterHome:function(){
		$('#myHome').show();
		var myH=$('.myScroll').height();
			
		$('#myHome').css({'top':-myH,'display':'block'});
		$('.myScroll').show();
		var slowAds=common.slowAds;
		slowAds.reverse();
				
		var len=slowAds.length;
		for(var i=0;i<len;i++){
			var $slow=slowAds[i].view;
			TweenLite.from($slow,1,{delay:i*0.05,css:{'transform':'translate(0px,'+(-(100+20*(len-i)))+'px)'},ease:Back.easeInOut});
		}
			
		TweenLite.to($('#myHome'),1.3,{css:{'top':0},ease:Expo.easeInOut,onComplete:common.addScroll});
		TweenLite.to($('.info'),0.9,{css:{'top':myH},ease:Expo.easeInOut});
		$('.enterSite').fadeOut(1000);
		$('.btnBorder').removeClass('btnBorder');
		$('#main').css('background-color','#000');
			
		//九宫格颜色随机变化	
		for(var i=0;i<9;i++){
			var gColor=160-Math.round(Math.random()*75);
			var bColor=255-Math.round(Math.random()*75);
			$('.module1').find('.rcolor').eq(i).css({'background-color':'rgb(0,'+gColor+','+bColor+')'});
		}
		slowAds=null;
	},
	
	addScroll:function(){
		var PH=$('.myScroll').height();
		var isChangeStatistics=false;
		myIScroll= new iScroll('myHome',{hScroll:false,vScroll:true,onScrollMove:function(){
			
			if(!isChangeStatistics){
				var dd=PH-(Math.abs(myIScroll.y)+SH);
				if(dd<175){
					window.setTimeout(function(){
						common.increase();
					},1000)
					isChangeStatistics=true;	
				}
				//trace('PH:'+PH+'   '+myIScroll.y+'    '+SH+'     DD:'+dd);
			}
		}});
		action.timeline();
		$('.info').hide();
		common.statistics();
	},
	
	aTime:[],
	
	statistics:function(){
		var oDiv=document.getElementById('statistics');
		var aTime=[];
		var count=0;
		
		var last='00000000';
		
		var statisticsInit=function(){
			count=Number(staCountNum);
			//alert(count);
			var txt=String(count);
			var len=txt.length;
			for(var i=0;i<len;i++)
			{
				var oBox=document.createElement('div');
				oBox.className='box';
				
				common.aTime.push(oBox);
				console.log(txt.charAt(i));
				oBox.innerHTML=
					'<span>'+txt.charAt(i)+'</span>'+
					'<div class="top"><span>'+txt.charAt(i)+'</span></div>'+
					'<div class="tran move">'+
						'<div class="front"><span>'+txt.charAt(i)+'</span></div>'+
						'<div class="back"><span>'+txt.charAt(i)+'</span></div>'+
					'</div>';
				
				oDiv.appendChild(oBox);
			}
		}
		
		
		
		
		statisticsInit();
	},
	
	increase:function(){
		//次数加一
		var oDiv=document.getElementById('statistics');
		var count=Number(staCountNum);
		var aTime=common.aTime;
		function statisticsTurn()
		{
			var last=String(count);
			var now=String(count+1);
			//last=now;
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
			common.aTime=[];
			aTime=[]
			oDiv=null;
		}
		statisticsTurn();
	},
	
	touchstart:function(e){
		var point = hasTouch ? e.touches[0] : e;
		var X=e.layerX,Y=e.layerY,W=$(this).width(),H=$(this).height(),centerX=W/2,centerY=H/2;
		var direction;
		//alert(e);
		
		if(Y<centerY && X<centerX){
			direction='up';
		}else if(X<centerX && Y>centerY){
			direction='left';
		}
		else if(Y>centerY && X>centerX){
			direction='down';
		}else if(X>centerX && Y<centerY){
			direction='right';
		}else{
			direction='right';
		}
		//trace('X:'+X+'  Y:'+Y+'  W:'+W+'  H:'+H+'   direction:'+direction+"  pageX:"+e.pageX);
		action.distortion(direction,this,20);
	},
		
	touchend:function(e){
		action.distortion(false,this,0);
	},
	
	test:function(){
		
	},
	
	ajaxLoad:function(){
		
	}
	,resetting:function(current){
		var len=common.slowAds.length;
		for(var i=0;i<len;i++){
			//if(common.slowAds[i].name==objClass)continue;
			var $slow=common.slowAds[i].view;
			$slow.css({'display':'block','opacity':1});
			//TweenLite.to($slow,0.3,{delay:i*0.01,alpha:0.4});
		}
		current.css({'-webkit-transform':'rotateX(0deg) rotateY(0deg) translateZ(0px) scale(1, 1)'});
	}
}



var action={
	pause:false,
	frame:0,
	timeRanArr:[],
	timelineList:[4,5,2,6,4,0,7,4,5,6,1,9,5,6,3,8,10],
	maxLen:0,
	/***************************************************************/
	/*时间线*/
	/***************************************************************/
	timeline:function(){
		//action.adModel1(true);
		var $timeline = $('[data-timeline]');
		function TL(n){return $timeline.eq(n)};
		//var timeObjArr = [TL(0),TL(5),TL(6),TL(2),TL(7),TL(4),TL(1),TL(9),TL(3),TL(8),TL(10)];
		/*for(var key in timeObjArr){
			var $view = $(timeObjArr[key]);
			var elem = new timelineObj($view);
			action.timeRanArr.push( elem );
		}*/
		for(var key in action.timelineList){
			var $view = TL(action.timelineList[key]);
			var elem = new timelineObj($view);
			action.timeRanArr.push(elem);
		}
		action.maxLen=action.timelineList.length;

		function timelineObj( view , options ) {
			options = options || {};
			var $view = $(view);
			this.view = $view;
			//this.isMIDlet=
			var num=$view.attr('data-timeline');
			var gifUrl=$view.find('.rotate').find('img').attr('data-gifurl');
			this.gifUrl=gifUrl;
			this.style=0;
			this.num=num;
			//trace('timelineObj_num:'+num);
			//trace('isSquared:'+isSquared);
		}
		//生成随机时间轴播放对象
		//action.timeRanArr=timeObjArr;
		//var timeRanArr=[];
		window.setTimeout(function(){
			action.play(action.frame,action.timeRanArr[action.frame]);
			action.setDataSlow(action.timeRanArr[action.frame],1);
			action.frame++;
		},400)
	},
	/***************************************************************/
	/*播放*/
	/***************************************************************/
	play:function(n,timeRanArr){
		var objAd=timeRanArr;
		var delay=1500;
		var gifUrl=objAd.gifUrl;
		//trace('play_gifUrl:'+gifUrl);
		
		if(gifUrl){
			//objAd.view.find('.rotate').find('img').attr('src',gifUrl);	
			if(objAd.num==5){
				//delay=500;
				action.adModel_5(objAd);
			}else if(objAd.num==6){
				action.adModel_6(objAd);
			}else{
				objAd.view.find('.rotate').find('img').attr('src',gifUrl);	
			}
		}else{
			if(objAd.num==4){
				action.adModel_4(objAd);
			}
			else if(objAd.num==9){
				action.adModel_9(objAd);
			}
			else if(objAd.num==10){
				action.adModel_10(objAd);
			}
		};
		
		window.setTimeout(function(){
			action.playControl();
			/*if(!action.pause){
				var AF=action.frame;
				var $rObj=action.timeRanArr[AF];
				action.play(AF,$rObj);
				
				var tmSNum=Number($rObj.view.attr('data-slow'));
				if(action.timeRanArr[AF].num!=4){
					if(tmSNum==0)action.setDataSlow($rObj,1);
						else action.setDataSlow($rObj,0);
				}else{
					if(tmSNum==0){action.setDataSlow($rObj,1)}
					else if(tmSNum==1){action.setDataSlow($rObj,2)}	
					else {action.setDataSlow($rObj,0)}
				}
				//alert('frame:'+action.frame+'   style:'+action.timeRanArr[AF].style);
				action.frame++;
				if(action.frame>=action.maxLen)action.frame=0;
			}*/
		},delay);
	},
	
	playControl:function(){
			if(!action.pause){
				var AF=action.frame;
				var $rObj=action.timeRanArr[AF];
				action.play(AF,$rObj);
				
				var tmSNum=Number($rObj.view.attr('data-slow'));
				if(action.timeRanArr[AF].num!=4){
					if(tmSNum==0)action.setDataSlow($rObj,1);
						else action.setDataSlow($rObj,0);
				}else{
					if(tmSNum==0){action.setDataSlow($rObj,1)}
					else if(tmSNum==1){action.setDataSlow($rObj,2)}	
					else {action.setDataSlow($rObj,0)}
				}
				//alert('frame:'+action.frame+'   style:'+action.timeRanArr[AF].style);
				action.frame++;
				if(action.frame>=action.maxLen)action.frame=0;
			}	
	},
	
	/***************************************************************/
	/*板块动画*/
	/***************************************************************/
	adModel_0:function(){
		
	},
	
	adModel_4:function(tmObj){
		var $rotate=$('.rotate li').find('.rimg');
		var dur=0.5,scale=0.7;
		//$rotate.css({'-webkit-transform':'rotateX('+0+'deg) rotateY(90deg) translateZ(0px)','-webkit-transform-origin':'center'});
		var tmSNum=action.getDataSlow(tmObj);
		$('.module1 .MD1 ul').css('background-color','inherit');
		//trace('tmSNum::-------------------------------------------------------------------:'+tmSNum);
		if(tmSNum==0){
			TweenLite.to($('.module1 .apTxt'),1,{css:{'bottom':-90},ease:Expo.easeInOut,onComplete:function(){
				var arrAp=[0,1,2,3,4,5,6,7,8];
				for(var i=0;i<9;i++){
					var ri=Math.ceil(Math.random()*arrAp.length-1);
					var n=arrAp[ri];
					arrAp.splice(ri,1);
					var $apImg=$('.rotate li').eq(n).find('.rimg');
					var $apBg=$('.rotate li').eq(n).find('.rpane');
					var ISX_Y=Math.round(Math.random()*1);
					var RX=ISX_Y==0?90:0,RY=ISX_Y==0?0:90;
					//trace('RX:'+RX+"  RY:"+RY);
					//TweenLite.to($ap,1,{delay:0.5*i+0.8,css:{'opacity':0},ease:Linear.easeInOut})
					//$ap.delay(i*300).fadeOut('slow');
					TweenLite.to($apImg,dur,{delay:0.1*i,css:{'transform':'rotateX('+RX+'deg) rotateY('+RY+'deg) scale('+scale+')'},ease:Linear.easeInOut});
					//$apBg.css({'-webkit-transform':'rotateX('+-RX+'deg) rotateY('+-RY+'deg) scale(0.8)'});
					TweenLite.to($apBg,0,{css:{'transform':'rotateX('+-RX+'deg) rotateY('+-RY+'deg) scale(0.8)'}});
					TweenLite.to($apBg,dur*2,{delay:0.1*i+dur,css:{'transform':'rotateX('+0+'deg) rotateY('+0+'deg) scale(1)'},ease:Expo.easeOut});
				}
				//test
				TweenLite.delayedCall(dur*2+0.9,function(){
					$('.module1 .MD1 ul').css('background-color','#00b8f4');
				})
			}});
			
		}else if(tmSNum==1){
			var arrAp=[0,1,2,3,4,5,6,7,8];
			for(var i=0;i<9;i++){
				var ri=Math.ceil(Math.random()*arrAp.length-1);
				var n=arrAp[ri];
				arrAp.splice(ri,1);
				var $apImg=$('.rotate li').eq(n).find('.rpane');
				var $apBg=$('.rotate li').eq(n).find('.rcolor');
				$apBg.show();
				var ISX_Y=Math.round(Math.random()*1);
				var RX=ISX_Y==0?90:0,RY=ISX_Y==0?0:90;
				
				TweenLite.to($apImg,dur,{delay:0.1*i,css:{'transform':'rotateX('+RX+'deg) rotateY('+RY+'deg) scale('+scale+')'},ease:Linear.easeInOut});
				//$apBg.css({'-webkit-transform':'rotateX('+-RX+'deg) rotateY('+-RY+'deg) scale(0.8)'});
				TweenLite.to($apBg,0,{css:{'transform':'rotateX('+-RX+'deg) rotateY('+-RY+'deg) scale(0.8)'}});
				TweenLite.to($apBg,dur*2,{delay:0.1*i+dur,css:{'transform':'rotateX('+0+'deg) rotateY('+0+'deg) scale(1)'},ease:Expo.easeOut});
			}
			
			TweenLite.delayedCall(dur*2+0.9,function(){
				$('.module1 .MD1 ul').css('background-color','#a76d1e');
			})
			
		}else{
			var arrAp=[0,1,2,3,4,5,6,7,8];
			for(var i=0;i<9;i++){
				var ri=Math.ceil(Math.random()*arrAp.length-1);
				var n=arrAp[ri];
				arrAp.splice(ri,1);
				var $apImg=$('.rotate li').eq(n).find('.rimg');
				var $apBg=$('.rotate li').eq(n).find('.rcolor');
				var ISX_Y=Math.round(Math.random()*1);
				var RX=ISX_Y==0?90:0,RY=ISX_Y==0?0:90;
				
				//trace('RX:'+RX+"  RY:"+RY);
				//$apBg.css({'-webkit-transform':'rotateX('+0+'deg) rotateY('+0+'deg) scale(1)'});
				//$apImg.css({'-webkit-transform':'rotateX('+0+'deg) rotateY('+0+'deg) scale(0.8)'});
				TweenLite.to($apBg,dur,{delay:0.1*i,css:{'transform':'rotateX('+-RX+'deg) rotateY('+-RY+'deg) scale('+scale+')'},ease:Linear.easeInOut});
				
				//$apImg.css({'-webkit-transform':'rotateX('+RX+'deg) rotateY('+RY+'deg) scale(0.8)'});
				TweenLite.to($apImg,0,{css:{'transform':'rotateX('+RX+'deg) rotateY('+RY+'deg) scale(0.8)'}});
				
				TweenLite.to($apImg,dur*2,{delay:0.1*i+dur,css:{'transform':'rotateX('+0+'deg) rotateY('+0+'deg) scale(1)'},ease:Expo.easeOut});
			}
			TweenLite.to($('.module1 .apTxt'),0.5,{delay:1.5,css:{'bottom':0},ease:Linear.easeOut});
			TweenLite.delayedCall(dur*2+0.9,function(){
				$('.module1 .MD1 ul').css('background-color','#a76d1e');
			})	
		}
	},
	
	adModel_5:function(tmObj){
		//TweenLite.to($('.module1 .apTxt'),0.5,{delay:1.5,css:{'bottom':0},ease:Linear.easeOut});
		//var $rImg=$('.module1 .MD2 .rotate img');
		var $rImg=tmObj.view.find('.SG');
		var $rGif=tmObj.view.find('.rGif');
		var tmSNum=action.getDataSlow(tmObj);
		if(tmSNum==0){
			TweenLite.to($rImg,1,{css:{'marginTop':-148},ease:Expo.easeInOut,onComplete:function(){
				$rGif.hide();
				$rGif.empty();
			}});
		}else{
			TweenLite.to($rImg,1,{css:{'marginTop':0},ease:Expo.easeInOut});
			
			TweenLite.delayedCall(1,function(){
				$rGif.show();
				$rGif.empty();
				//$rGif.html('<img src="images/module/module2.gif">');
			})
		}
	},
	
	adModel_6:function(tmObj){
		//var $rImg=$('.module1 .MD3 .rotate img');
		var $rImg=tmObj.view.find('.SG');
		var $rGif=tmObj.view.find('.rGif');
		var gifUrl=$rImg.attr('data-gifurl');
		var tmSNum=action.getDataSlow(tmObj);
		
		
		if(tmSNum==0){
			TweenLite.to($rImg,1,{css:{'marginTop':0},ease:Expo.easeInOut});
			
			TweenLite.delayedCall(1,function(){
				$rGif.show();
				$rGif.empty();
				//$rGif.html('<img src="images/module/module3.gif">');
				//alert($rGif.find('img').attr('src'));
				//$rGif.find('img').attr('src','images/public/sprite.gif')
			})	

		}else{
			TweenLite.to($rImg,1,{css:{'marginTop':-219},ease:Expo.easeInOut,onComplete:function(){
				$rGif.empty();
				$rGif.hide();
			}});	
		}
		//TweenLite.to($('.module1 .apTxt'),0.5,{delay:1.5,css:{'bottom':0},ease:Linear.easeOut});
	},
	
	adModel_9:function(tmObj){
		//var $rImg=$('.module3 .adList img');
		var $rImg=tmObj.view.find('img');
		var tmSNum=action.getDataSlow(tmObj);
		//alert('action.frame:'+action.frame);
		//alert(action.timeRanArr[action.frame].style);
		//alert(tmObj.style);
		if(tmSNum==0){
			TweenLite.to($rImg,1.3,{css:{'marginLeft':-312},ease:Expo.easeInOut});
			var apTxt=$('.module2 .MD3 .apTxt');
			TweenLite.to(apTxt,1,{delay:1,css:{'marginTop':0},ease:Expo.easeOut});
			
		}else{
			var apTxt=$('.module2 .MD3 .apTxt');
			TweenLite.to(apTxt,1,{css:{'marginTop':-80},ease:Expo.easeOut});
			TweenLite.to($rImg,1.3,{delay:0.4,css:{'marginLeft':0},ease:Expo.easeInOut});
		}
	},
	
	adModel_10:function(tmObj){
		//var $rImg=$('.module3 .adList img');
		var $rImg=tmObj.view.find('img');
		var tmSNum=action.getDataSlow(tmObj);
		//alert('action.frame:'+action.frame);
		//alert(action.timeRanArr[action.frame].style);
		//alert(tmObj.style);
		if(tmSNum==0){
			TweenLite.to($rImg,1.5,{css:{'marginLeft':-640},ease:Expo.easeInOut});
		}else{
			TweenLite.to($rImg,1.5,{css:{'marginLeft':0},ease:Expo.easeInOut});
		}
		
	},
	
	//设置 data slow参数
	setDataSlow:function(tmObj,n){
		tmObj.view.attr('data-slow',n)
	},
	//获取 data slow参数
	getDataSlow:function(tmObj){
		return Number(tmObj.view.attr('data-slow'));
	},
	
	
	//3D旋转效果
	distortion:function(dir,_this,deg){
		var n=deg;
			//$(_this).parent().css({'-webkit-perspective':800,'-webkit-transform-style': 'preserve-3d'});
			//$(_this).find('.SNC').css("-webkit-transition-duration", 0.5+"s");
		switch(dir){
			case 'up':
				$(_this).find('.rotate').css({'-webkit-transform':'rotateX('+n+'deg) rotateY(0deg) translateZ(0px)','-webkit-transform-origin':'bottom'});
			break;
				
			case 'left':
				$(_this).find('.rotate').css({'-webkit-transform':'rotateX(0deg) rotateY('+-n+'deg) translateZ(0px)','-webkit-transform-origin':'right'});
			break;
			
			case 'down':
				$(_this).find('.rotate').css({'-webkit-transform':'rotateX('+-n+'deg) rotateY(0deg) translateZ(0px)','-webkit-transform-origin':'top'});
			break;
				
			case 'right':
				$(_this).find('.rotate').css({'-webkit-transform':'rotateX(0deg) rotateY('+n+'deg) translateZ(0px)','-webkit-transform-origin':'left'});
			break;
				
			case 'turn3d':
				var W=$(_this).width();
				var H=$(_this).height();
				var TOP=$(_this).css('top');
				var LEFT=$(_this).css('left');
				var $rotate=$(_this).find('.rotate');
				//$(_this).find('.rotate').css({'transition':'all 3.8s ease'});
				$rotate.css({'-webkit-transform':'rotateX(0deg) rotateY('+90+'deg) translateZ(0px) scale(2,2)','-webkit-transform-origin':'center'});
				//$(_this).css({'top':'50%','left':'50%','margin-left':-W/2,'margin-top':-H/2});
				var MW=$('#main').width();
				var MY=Math.abs(myIScroll.y);
				//trace('myIScrollY:'+MY);
				//var ofL=$(_this).offset().left;
				//alert(ofL);
				TweenLite.to($(_this),0.4,{css:{'top':MY+SH/2,'left':'50%','marginLeft':-W/2,'marginTop':-H/2},ease:Expo.easeInOut});
				//$('#myContainer').css({'display':'block'});
				$('#myContainer').show();
				TweenLite.from($('#myContent'),0.9,{delay:0.3,css:{'transform':'rotateX(0deg) rotateY(-90deg) translateZ(0px)'},ease:Expo.easeOut,onComplete:function(){
					common.resetting($rotate);	
					$(_this).css({'marginTop':0,'marginLeft':0,'top':TOP,'left':LEFT,'position':'absolute','zIndex':0});
					
					$rotate=null;
				}});
				
				//TweenLite.to($(_this),0.5,{css:{'transform':'translate('+MW/2+'px,'+H/2+'px)'}});
			break;
				
			default:
				$(_this).find('.rotate').css({'-webkit-transform':'rotateX(0deg) rotateY(0deg) translateZ(0px)','-webkit-transform-origin':'left'});
		}
			
	}
	//end distortion(dir);
}