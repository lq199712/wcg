amGloble.nav = {
    init: function () {
        var _this = this;
        this.$ = $("#nav");
        this.$.find("div.nav-bg").vclick(function () {
            _this.$.fadeOut(300);
	    });

	    $("div.am-header div.menu").vclick(function () {
	        amGloble.nav.show();
	    });

	    this.$.find("li").vclick(function (e) {
	        var url = $(this).attr("href");
	        if (!url) return;
	        $(this).addClass("active").siblings().removeClass("active");
	        setTimeout(function () {
	            window.location.href = url;
	        }, 200);
	    });

	    var _start,_end;
	    $("body").bind({
	        "touchstart":function (evt) {
	            _start = evt.originalEvent.touches[0];
	        },
	        "touchmove":function (evt) {
	            _end = evt.originalEvent.touches[0];
	            //$("div.am-app").css("left", (_end.pageX - _start.pageX) + "px");
	        },
	        "touchend": function (event, position) {
	            $.am.debug.log("touchend----->CA");
	            var w = window.innerWidth > 500 ? 500 : window.innerWidth;
	            if (_start && _end && _end.pageX - _start.pageX > w / 3 && Math.abs(_end.pageY - _start.pageY) < 50) {
	                _this.show();
	            }
	            _start = null;
	            _end = null;
	        }
	    });
	},
	show: function () {
	    this.$.fadeIn(300);
	},
	hide: function () {
	    this.$.fadeOut(300);
	}
}
$(function () {
    amGloble.nav.init();
});
