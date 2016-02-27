if (!amGloble) amGloble = {};
if (!amGloble.page) amGloble.page = {};
amGloble.page.home = {
    init: function () {
        var _this = this;
        this.$ = $("#page_home");
        this.$li = this.$.find("li");
        this.carrousel && this.carrousel.$.animate({ "opacity": 1 }, 300);
        this.carrousel.refresh();

        this.show();
    },
    show: function (opt) {
        if (opt == "back") return;
        $("div.home-loading").fadeOut(500);
    },
    showItem: function (i, t) {
        var _this = this;
        setTimeout(function () {
            _this.$li.eq(i).addClass("show");
        }, t);
    }
}

$(function () {
    var h = (window.innerWidth > 500 ? 500 : window.innerWidth) * 0.6125;

    $("#home_carrousel").find("img").show().each(function () {
        $("#home_carrousel").next().append("<p></p>");
    });
    amGloble.page.home.carrousel = new $.am.Carrousel({
        id: "home_carrousel",
        visible: 1,
        height: h,
        onchange: function (i) {
            this.$.next().find("p").eq(i).addClass("selected").siblings().removeClass("selected");
        }
    });
});

$(window).load(function () {
	$("div.home-logo").show();
	$("div.home-text").show();
    amGloble.page.home.init();
    var v = amGloble.versions;
    var ua = navigator.userAgent.toLowerCase();
	if(ua.match(/MicroMessenger/i)=="micromessenger") {
		/*$("#microMsg").show().click(function(){
			$(this).hide();
		});
		setTimeout(function(){
			$("#microMsg").fadeOut(500);
		},4000);*/
    }else if (v.iPhone && !v.iPad && localStorage.getItem("reeli_home_addBtnShown") != "true"){
        $("#addToScreenTip").show().click(function () {
            try {//.find(".close-btn")
                localStorage.setItem("reeli_home_addBtnShown", "true");
                $("#addToScreenTip").hide();
            } catch (err) {
                $("#addToScreenTip").hide();
            }
        });
        setTimeout(function () {
            $("#addToScreenTip").fadeOut(500);
        }, 4000);
    }
});
