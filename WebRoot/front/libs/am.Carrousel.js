(function (window, $) {
    /**
	 * 1. Carrousel类,用于创建一个Carrousel对象
	 * @class
	 * @param [string]    	opt.id			必需						Carrousel控件ID
	 * @param [int]			opt.height		必需						控件高度
	 * @param [int]			opt.width  		可选		默认100%			控件宽度
	 * @param [int]			opt.visible		可选  	默认1			显示区包含的item的个数
	 * @param [int]			opt.time		可选  	默认300ms		回弹时间
	 * @param [function]		opt.onchange	可选
	 * @param [function]		opt.autoSwitch	可选 	默认10s,0disable	自动切换

	 * @return [object]	 产生的Carrousel对象
	 * @description  1.
	 *
	 * @example
	 */
    var Carrousel = function (opt) {
        this.id = opt.id;
        this.$ = opt.$;
        this.width = opt.width;
        this.visible = opt.visible || 1;
        this.height = opt.height;
        this.time = opt.time || 200;
        this.onchange = opt.onchange;
        this.current = 0;
        this.autoSwitch = typeof (opt.autoSwitch) == "undefined" ? 10000 : opt.autoSwitch;
        $.am.components.push(this);
        $.am.Component.call(this, opt);
    }
    Carrousel.prototype = {
        componentInit: function () {
            this.$ = this.$ || $("#" + this.id);
            this.$.find("img").bind({
            	"load":function(){
            		$(this).addClass("show");
	            },"error":function(){
	            	$(this).addClass("hide");
	            }
            	});
            this.$.addClass("am-touchable");
            this.$inner = this.$.children(":first");
            var cssSet = {};
            if (this.width) {
                this.width = cssSet.width = this.width + "px";
            }
            cssSet.height = this.height + "px";
            this.$.css(cssSet);

            var _this = this;
            var sPos = null;
            var mPos = null;
            var isMove = false;
            this.$.bind({
                "touchstart": function (event, position) {
                    sPos = {
                        x: event.originalEvent.touches[0].pageX,
                        y: event.originalEvent.touches[0].pageY
                    }
                    if (_this.$items) {
                        _this.start(sPos.x);
                    }
                    isMove = false;
                    mPos = null;
                    //return false;
                },
                "touchmove": function (event, position) {
                    if (!mPos) {
                        mPos = {
                            x: event.originalEvent.touches[0].pageX,
                            y: event.originalEvent.touches[0].pageY
                        }
                        var t = Math.abs(mPos.x - sPos.x) > Math.abs(mPos.y - sPos.y);
                        if (t) {
                            isMove = true;
                            if (_this.$items) {
                                _this.move(mPos.x);
                            }
                            return false;
                        } else {

                        }
                    } else {
                        mPos = {
                            x: event.originalEvent.touches[0].pageX,
                            y: event.originalEvent.touches[0].pageY
                        }
                        if (isMove) {
                            if (_this.$items) {
                                _this.move(mPos.x);
                            }
                            return false;
                        } else {

                        }
                    }
                    //position.e.preventDefault();
                    //return false;
                },
                "touchend": function (event, position) {
                    if (isMove && _this.$items) {
                        _this.end();//position.x
                    }
                    isMove = false;
                    sPos = null;
                    mPos = null;
                }
            });
        },
        refresh: function () {
        	if(this.visible>1){
        		this.refreshMuti();
        		return;
        	}
            var innerWidth = this.$.innerWidth();
            var w = this._itemw = innerWidth / this.visible, h = this.height;
            this.$items = this.$inner.children();
            var phtml = "";
            for(var i=0;i<this.$items.length;i++){
            	phtml+= "<p></p>";
            }
            this.$.next(".count").html(phtml);
            
            if (this.$items.length <= this.visible) {
                return;
            }
            this.$items.each(function () {
                $(this).css({
                    'width': w + "px",
                    'height': h + "px",
                    'float': "left"
                });
            });
            this.nPos = -w;
            this.current = 0;
            if (!this.cloned) {
                this.cloned = true;
                this.$inner.prepend(this.$items.last().clone().addClass("cloneItem"));
                this.$inner.append(this.$items.first().clone().addClass("cloneItem"));
            } else {
                this.$items = this.$inner.children(":not(.cloneItem)");
            }
            this.$inner.css({
                width: w * (this.$items.length + 2) + "px"
            });
            this.show(0);
        },
        refreshMuti : function() {
		    var w = this._itemw = (this.width || this.$.innerWidth()) / this.visible, h = this.height;
			this.$items = this.$inner.children();
			if (this.$items.length <= this.visible) {
				return;
			}

			this.$inner.css({
				width : w * this.$items.length + "px"
			});
			this.$items.each(function() {
				$(this).css({
					'width' : w + "px",
					'height' : h + "px",
					'float' : "left"
				});
			});
			this.nPos = 0;
			this.current = 0;
			this.show(0);
		},
        start: function (e) {
            if (this.$items.length <= this.visible) {
                return;
            }
            this.startPos = e;
            this.startTime = new Date().getTime();
        },
        move: function (e) {
            if (this.$items.length <= this.visible) {
                return;
            }
            this.carrouselTimer && clearTimeout(this.carrouselTimer);
            if (this.visible > 1 && e - this.startPos > this.current * this._itemw)
				return;
			if (this.visible > 1 && e - this.startPos < -(this.$items.length - this.current - this.visible) * this._itemw)
				return;
            this.endPos = e;
            var m = this.endPos - this.startPos;
            if(this.visible>1){
            	this.nPos = -this._itemw * this.current + m;
        	}else{
        		this.nPos = -this._itemw * (this.current + 1) + m;
        	}
            this.$inner.setTransformPos(this.nPos, "x");
        },
        end: function () {
            if (this.$items.length <= this.visible) {
                return;
            }
            var m = this.endPos - this.startPos;
            var duration = new Date().getTime() - this.startTime;
            var speed = m / duration;
            // console.log(speed);
            if (m && ((m > this._itemw / 2) || speed > 0.6)) {
                var i = Math.ceil(m / this._itemw);
                this.show(this.current - i);
            } else if (m && (m < -this._itemw / 2 || speed < -0.6)) {
                var i = Math.ceil(Math.abs(m) / this._itemw);
                this.show(this.current + i);
            } else if (m) {
                this.show(this.current);
            }
            this.endPos = 'undefined';
        },
        show: function (i) {
        	if(this.visible>1){
        		this.showMuti(i);
        		return;
        	}
            if (this.$items.length <= this.visible) {
                return;
            }
            this.current = i;
            //$("div.page-header").text("current:"+ i);
            //$("div.page-header").append(this.nPos+" | "+(-this._itemw *(this.current+1)));
            var _this = this;
            this.$inner.animateTranslate3d(this.nPos, -this._itemw * (this.current + 1), "x", this.time, function () {
                if (i < 0) {
                    _this.current = _this.$items.length - _this.visible;//0
                }
                if (i > _this.$items.length - _this.visible) {
                    _this.current = 0;//this.$items.length - this.visible;
                }
                _this.nPos = -_this._itemw * (_this.current + 1);
                _this.$inner.setTransformPos(_this.nPos, "x");
                _this.onchange && _this.onchange(_this.current);
            });

            this.carrouselTimer && clearTimeout(this.carrouselTimer);
            if (this.autoSwitch != 0) {
                this.carrouselTimer = setTimeout(function () {
                    _this.show(_this.current + 1);
                }, this.autoSwitch);
            }
        },
		showMuti : function(i) {
			if (this.$items.length <= this.visible) {
				return;
			}
			this.current = i;
			if (i < 0) {
				this.current = 0;
			}
			if (i >= this.$items.length - this.visible) {
				this.current = this.$items.length - this.visible;
			}
			var _this = this;
			this.$inner.animateTranslate3d(this.nPos, -this._itemw * this.current, "x", this.time, function() {
				_this.nPos = -_this._itemw * _this.current;
				_this.onchange && _this.onchange(_this.current);
			});

			this.carrouselTimer && clearTimeout(this.carrouselTimer);
			if (this.autoSwitch != 0) {
				this.carrouselTimer = setTimeout(function() {
					// console.log("auto move:"+ (_this.current+1));
					_this.show(i >= _this.$items.length - _this.visible ? 0 : _this.current + 1);
				}, this.autoSwitch);
			}
		}
    }
    $.am.Carrousel = Carrousel

})(window, jQuery);