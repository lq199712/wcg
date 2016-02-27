$.am.PhotoViewer = function (opt) {
    this.id = opt.id;
    $.am.components.push(this);
    $.am.Component.call(this, opt);
}
$.am.PhotoViewer.prototype = {
	componentInit : function(){
	    this.$ = $("#"+this.id);
	    var _this = this;
	    this.carrousel = new $.am.Carrousel({
	        id: "photoViewer_carrousel",
	        height: window.innerHeight,
	        onchange: function (i) {
	            _this.$.find("ul.dots li:eq(" + i + ")").addClass("selected").siblings().removeClass("selected");
	        }
	    });

		this.$.find("div.close").vclick(function () {
		    _this.onclose && _this.onclose();
		    setTimeout(function () {
		        _this.hide();
		    }, 100);
		});

	},
    /*
    opt = {
        pics:[1,2,3],           //图片ID
        select:0,               //默认显示第几个
        onclose:function(){     //关闭时回调

        }
    }
    */
	show: function (opt) {
	    if (!opt.pics || opt.pics.length < 1) {
	        return;
	    }
	    this.onclose = opt.onclose;
	    this.pics = opt.pics;
	    this.text = opt.text;
	    this.$.show();
	    this.render(opt.select || 0);
	},
	hide: function () {
	    this.$.fadeOut(200);
	},
	render: function (r) {
	    var $picList = this.$.find("ul:first").empty();
	    this.$.find("ul.dots").empty();
	    for (var i = 0; i < this.pics.length; i++) {
	        var $temp = $('<li class="am-clickable"><img src="' + this.pics[i] + '" /><div class="text"><p class="text_inner">' + this.text[i] + '<p></div></li>');
	        $picList.append($temp);
	        this.$.find("ul.dots").append("<li></li>");
	    }
	    this.carrousel.cloned = false;
	    this.carrousel.refresh();
	    this.carrousel.show(r);
	}
}

$.am.photoViewer = new $.am.PhotoViewer({
    id : "photoViewer"
})


