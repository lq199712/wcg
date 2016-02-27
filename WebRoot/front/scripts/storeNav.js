var storeNav = {
	init:function(){
		$("div.am-app").css({
			"overflow-x":"hidden"
		});

		$("#store_nav_list").delegate("li","vclick",function(){
			$(this).addClass("active").siblings().removeClass("active");
			location.href=$(this).attr("href");
		});
		
		$("div.am-page").css({
			"position":"relative",
			"z-index":1,
			"min-height":window.innerHeight+"px"
		});
		
		this.scrollview = new $.am.ScrollView({
			$wrap : $("div.store_nav_body"),
			$inner : $("div.store_nav_body ul"),
			direction : [0, 1],
			hasInput : 0
		});
	},
	show:function(){
		var w = (window.innerWidth>500?500:window.innerWidth);
		$("#stores-tab").hide();
		$("#store_nav_list").show();
		//$("div.am-page").setTransformPos(-w*0.8,"x");
		$("div.am-page").animateTranslate3d(0, -w*0.8,"x", 300, function(){
			var left = window.innerWidth>500?((window.innerWidth-500)/2):0;
			$("#storeNavCover").show().css({
				left:left+"px",
				width:w*0.2
			});
		});
		this.scrollview.$wrap.css("height",(window.innerHeight-41) +"px");
		this.scrollview.refresh();
	},
	hide:function(){
		var w = (window.innerWidth>500?500:window.innerWidth);
		$("div.am-page").setTransformPos(0,"x");
		$("div.am-page").animateTranslate3d( -w*0.8,0,"x", 200, function(){
			$("#storeNavCover").hide();
			$("#store_nav_list").hide();
			$("#stores-tab").show();
		});
		//$("#store_nav").animateTranslate3d( -w*0.8,0,"x", 200);
	}
}
$(function(){
	storeNav.init();
	$("#storeNavCover").vclick(function(){
		storeNav.hide();
	});
});









