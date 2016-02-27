window.amGloble = {
	versions : function() {
		var u = navigator.userAgent, app = navigator.appVersion;
		return {//移动终端浏览器版本信息
			trident : u.indexOf('Trident') > -1, //IE内核
			presto : u.indexOf('Presto') > -1, //opera内核
			webKit : u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
			gecko : u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核
			mobile : !!u.match(/AppleWebKit.*Mobile.*/) || !!u.match(/AppleWebKit/), //是否为移动终端
			ios : !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
			android : u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或者uc浏览器
			iPhone : u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1, //是否为iPhone或者QQHD浏览器
			iPad : u.indexOf('iPad') > -1, //是否iPad
			webApp : u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部
		};
	}(),
	page: {

	},
	msg: function (text) {
	    var msg = $('<div class="instantMessage" style="display: none"><span>' + text + '</span></div>')
	    msg.appendTo("body").fadeIn(200);
	    setTimeout(function () {
	        msg.fadeOut(200, function () {
	            msg.remove();
	        })
	    }, 3000)
	},
	confirm : function(opt,flip) {
		if (!this.$confirm) {
			this.$confirm = $("#globle-confirm");
		}
		var self = this;
		this.$confirm.find(".title").html(opt.title || "");
		this.$confirm.find(".content").html(opt.content || "");
		var btns = this.$confirm.find(".page-button")
		btns.eq(0).html(opt.btn1 || "").unbind().click(function() {
			opt.cb1 && opt.cb1();
			self.$confirm.fadeOut();
		});
		btns.eq(1).html(opt.btn2 || "").unbind().click(function() {
			opt.cb2 && opt.cb2();
			self.$confirm.fadeOut();
		});
		this.$confirm.fadeIn();
		
		if(flip){
			btns.eq(0).addClass("bright");
			btns.eq(1).removeClass("bright");
		}else{
			btns.eq(0).removeClass("bright");
			btns.eq(1).addClass("bright");
		}
	},
	$busy: $('<div class="busyview"><div class="busyviewinner"><div><span></span></div></div></div>'),
	showBusy: function () {
	    this.$busy.appendTo("body");
	},
	hideBusy: function () {
	    this.$busy.remove();
	},
    reMail : /^(?:[a-z\d]+[_\-\+\.]?)*[a-z\d]+@(?:([a-z\d]+\-?)*[a-z\d]+\.)+([a-z]{2,})+$/i,
    //手机，座机
	rePhone : /((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/,
	re4d: /^\d{4}$/i,
	isMicroMessenger:function(){
		var ua = navigator.userAgent.toLowerCase();
		return ua.match(/MicroMessenger/i)=="micromessenger";
	}
}

$(function() {
	$.am.debug.enable = false;
	
	$(document.body).bind("touchstart", function (e) {
        if (!$(e.target).is("input") && !$(e.target).is("textarea")) {
            $("input:focus").blur();
            $("textarea:focus").blur();
        }
    });
	
	var $back = $("div.am-backbutton");
	if(history.length>1){
		$back.show().click(function(){
			history.go(-1);
		});
	}else{
		$back.click(function(){
			location.href=config.homeUrl;
		});
	}
	
	$("[onvclick]").vclick(function(){
    	eval($(this).attr("onvclick"));
	});

	$(".page_adBar").each(function () {
	    var $ul= $(this).find("ul");
	    setInterval(function(){
	        var top = $ul.position().top;
	        if (top-30 <= -$ul.height()) {
	            $ul.css("top", (0) + "px");
	        } else {
	            $ul.css("top", (top - 30) + "px");
	        }
	    },5000);
	    
	});

	$(".page_adBar .close").click(function () {
	    $(this).parent().slideUp(300);
	});
});

//for weixin
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    WeixinJSBridge.call('hideToolbar');
    
    WeixinJSBridge.on('menu:share:timeline', function(argv){
      WeixinJSBridge.invoke('shareTimeline',{
         "img_url":dataForWeixin.TLImg,
         "img_width":"120",
         "img_height":"120",
         "link":location.href,
         "desc": dataForWeixin.desc || "",
         "title":$("title").text()
      }, function(res){});
   });
});
