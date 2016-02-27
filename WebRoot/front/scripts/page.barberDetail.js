var carrousel = new $.am.Carrousel({
    id: "barberDetail_pics",
    visible:4,
    height: 80,
    onchange: function (i) {
    }
});

$(function () {
    carrousel.$inner.delegate("img", "click", function () {
        var pics = [], txt = [];
        carrousel.$items.find("img").each(function () {
            pics.push($(this).attr("hr"));
            txt.push(this.alt);
        });
        $.am.photoViewer.show({
            pics: pics,
            text: txt,
            select: carrousel.$items.find("img").index($(this))
        });
    });
    carrousel.refresh();
    
    var $wrap = $("div.content_box");
    var $inner = $wrap.children();
    var $btn = $("div.page-descAreaSize")
    
    if ($inner.height()-5 > $wrap.height()) {
        $btn.show();
    } else {
        $wrap.css("height", "auto");
        $btn.hide();
    }
    $btn.vclick(function () {
        if ($(this).hasClass("more")) {
            $wrap.css("height", "auto");
            $btn.addClass("less").removeClass("more");
            $btn.html('');
            $btn.html('收起');
        } else {
            $wrap.css("height", "87px");
            $btn.addClass("more").removeClass("less");
            $btn.html('');
            $btn.html('展开');
        }
    });


    $(".social .favor").vclick(function () {
        var paths = location.pathname.split('/');
        window.amGloble.Rating($(this), amGloble.RATINGURLS.barber,
             {
        		 tenantId: $("#tenantIdVal").val(),
                 barberId: paths[paths.length - 1]
             }, 'post', function () { }, function () { });
    });

    $(".social .share").vclick(function () {
    	if(amGloble.isMicroMessenger()){
    		$("#microMessengerShareTips").show();
    	}else{
    		$("#app_share,#app_share_mask").show();
    	}
    });
    $("#microMessengerShareTips").vclick(function(){
    	$(this).hide();
    	return false;
    });
    
    $("#app_share_mask").vclick(function () { $("#app_share,#app_share_mask").hide(); });
    
    var $thumb = $("#barber_thumb img");
    
    $thumb.attr("src",$thumb.attr("imgSrc")).load(function(){
    	$(this).show();
    });
    
    $("#barber_thumb img").load(function(){
		$(this).show();
		var w = this.naturalWidth;
		var h = this.naturalHeight;
		var pw = $(this).parent().width();
		if(w>h){
			var l = (h-w)/2;
			$(this).css({"height":"100%","width":"auto","position":"relative","left": l*pw/h+"px","top":"0"});
		}else{
			var t = (w-h)/2;
			$(this).css({"width":"100%","height":"auto","position":"relative","top": t*pw/w+"px","left":"0"});
		}
	});
});
