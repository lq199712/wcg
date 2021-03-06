﻿var carrousel = new $.am.Carrousel({
    id: "storeDetail_carrousel",
    visible: 1,
    height: ((window.innerWidth > 500 ? 500 : window.innerWidth) - 22) / 298 * 184,
    onchange: function (i) {
        this.$.next().find("p").eq(i).addClass("selected").siblings().removeClass("selected");
    }
});

$(function () {
	setTimeout(function(){
	    carrousel.$inner.delegate("img", "click", function () {
	        var pics = [], txt = [];
	        carrousel.$items.find("img").each(function () {
	            pics.push($(this).attr("hr"));
	            txt.push(this.alt);
	        });
	        $.am.photoViewer.show({
	            pics: pics,
	            text: txt,
	            select: carrousel.current
	        });
	    });
	},500);
    carrousel.refresh();

    var $wrap = $("div.content_box");
    var $inner = $wrap.children();
    var $btn = $("div.page-descAreaSize");
    
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
    
    $(".operation .favor").vclick(function () {
        var paths = location.pathname.split('/');
        window.amGloble.Rating(
            $(this), amGloble.RATINGURLS.store,
            {
            	tenantId: $("#tenantIdVal").val(),
                storeId: paths[paths.length - 1]
            }, 'post', function () { }, function () { });
    });

    $(".operation .share").vclick(function () {
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
    var storeId = window.amGloble.getCookie("storeId");
    var paths = location.pathname.split('/'), queryId = paths[paths.length - 1];

    if (storeId != queryId) {
        $("#change-store").show();
    } else {
        $("#change-store").hide();
    }
    //change-store
    
    $("#gotomap").vclick(function(){
    	location.href = $(this).attr("href");
    });
    
    $("#store_nav").vclick(function(){
    	storeNav.show();
    });
});
