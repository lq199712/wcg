
var getStoreCommentList = function (data, cb) {
	console.log(data);
	var opt = {
		url:config.url,
		dataType:'json',
		data:data,
		success:function(ret){
			cb(ret);
		},
		error:function(ret){
			cb({
				succss:-1
			});
		}
	}
	$.ajax(opt);
	return;
    var data = {
        "succss": 200,
        "message": "",
        "data": []
    }
    for (var i = 0; i < 10; i++) {
        data.data.push({
            "id": 132 + i,
            "name": "Tom"+i,
            "time": 1390185766115,
            "content": "Just do it!",
            "score": Math.ceil(Math.random()*5)
        });
    }

    setTimeout(function () {
        cb(data);
    }, 2*1000);
}
var submitStoreComment = function (data, cb) {
	console.log(data);
	var opt = {
		url:config.submit,
		data:JSON.stringify(data),
		dataType:'json',
		contentType: "application/json",
		success:function(ret){
			cb(ret);
		},
		type:"POST",
		error:function(ret){
			cb({
				succss:-1
			});
		}
	}
	$.ajax(opt);
	return;
    var data = {
        "succss": 200,
        "message": ""
    }
    setTimeout(function () {
        cb(data);
    }, 2 * 1000);
}



var signin = {
    //initial ui event binding or style
    init: function () {
        var _this = this;
        //点评，打开
        this.$ = $("#storeSignin");
        this.$.find("div.creat").vclick(function () {
            //重置表单
            _this.$creat.find("textarea").val("");
//            _this.$creat.find("input").val("");
//            _this.$creat.find("input").val("");
            _this.$stars.children().css("width", "150px");
            _this.$creat.show();
            _this.starsPos = _this.$stars.offset();
        });

        //点评窗口
        this.$creat = $("#storeSignin-creat");
        //点评 X
        this.$creat.find("div.close").vclick(function () {
            _this.$creat.hide();
        });
        this.$stars = this.$creat.find("div.stars").bind("vtouchstart", function (event, position) {
        	var s = Math.ceil((position.x - _this.starsPos.left) / 30);
            $(this).children().css("width", (s<1?1:s) * 30 + "px");
        }).bind("vtouchmove", function (event, position) {
        	var s = Math.ceil((position.x - _this.starsPos.left) / 30);
            var w = (s<1?1:s) * 30;
            $(this).children().css("width", (w > 150 ? 150 : w) + "px");
        })
        //点评提交
        this.$creat.find("div.actionButton").vclick(function () {
            var opt = {
                tenantId: config.tenantId,
                storeId: config.storeId,
                content: _this.$creat.find("textarea").val(),
                name: _this.$creat.find("input").val(),
                score: Math.ceil(_this.$stars.children().width() / 30)
            }
            if (!opt.content) {
                amGloble.msg("请输入留言!");
                return;
            }else if (opt.content.length>50) {
                amGloble.msg("留言内容请在50个字符以内!");
                return;
            }
            if (!opt.name) {
                amGloble.msg("请留下您的大名!");
                return;
            }else if (opt.name.length>10) {
                amGloble.msg("姓名内容请在10个字符以内!");
                return;
            }
            _this.submit(opt);
            _this.$creat.hide();
        });
        this.$list = this.$.find("ul.storeBulletin-list");

        this.$loading = this.$.find("div.loading-bar");
        this.$more = this.$.find("div.load-more").vclick(function () {
            if ($(this).hasClass("am-disabled")) return;
            $(this).text("正在努力为您加载中...").addClass("am-disabled");
            _this.getData();
        });
        this.$msg = this.$.find("div.empty-msg");

        this.page = 0;
        this.pageLength = 10;
    },
    //before page show
    beforeShow: function (paras) {
        this.store = paras;
        this.$msg.hide();
        this.getData();
    },
    getData: function () {
        var _this = this;
        //重置界面
        this.page == 0 && this.$loading.show();
        getStoreCommentList({
            tenantId: config.tenantId,
            storeId: config.storeId,
            pageLength: this.pageLength,
            page: this.page
        }, function (ret) {
            _this.$loading.hide();
            if (ret && ret.success == 200 && typeof (ret.data) == "object" && ret.data) {
                _this.data = ret.data;
                _this.render();
            } else {
                if (_this.$list.find("li").length<1) {
                    _this.$msg.text("数据载入失败!").show();
                }
            }
            _this.$more.text("点击加载更多").removeClass("am-disabled");
        });
    },
    render: function () {
        var items = this.data, temp = '';
        $.am.debug.log("items.length:" + items.length);
        try {
            for (var i = 0; i < items.length; i++) {
                temp += this.creatItem(items[i]);
            }
        } catch (e) {
            alert(e);
        }
        this.$list.append(temp);
        if (this.$list.find("li").length<1) {
            this.$msg.text("还没有人来点评过!").show();
        } else {
        	if (items.length > 0 && items.length == this.pageLength) {
                this.$more.show();
            }else{
            	this.$more.hide();
            	amGloble.msg("已加载全部信息!");
            }
        }
        this.page++;
    },
    creatItem:function(items){
    	var temp= '<li>';
        temp += '<div class="content">' + items.content + '</div>';
        items.replied && items.reply && (temp += '<div class="reply"><span>回复：</span>'+items.reply+'</div>');
        temp += '<div class="time"><span>' + items.name + '</span>' + (items.date?new Date(items.date):new Date()).format("yyyy-mm-dd HH:MM") + '</div>';
        var p = (items.score || items.stars) * 15;
        temp += '<div class="stars"><p style="width:' + p + 'px"></p></div>';
        temp += '</li>';
        
        return temp;
    },
    submit: function (opt) {
        amGloble.showBusy();
        var _this = this;
        submitStoreComment(opt, function (ret) {
            amGloble.hideBusy();
            if (ret && ret.success == 200) {
            	_this.$list.prepend(_this.creatItem(opt));
            	_this.$msg.hide();
                amGloble.msg("点评成功，谢谢您对我们工作的支持!");
            } else {
                amGloble.msg("点评失败!");
            }
        });
    }
}

$(function () {
    signin.init();
    signin.beforeShow({
        id:1
    });
});
