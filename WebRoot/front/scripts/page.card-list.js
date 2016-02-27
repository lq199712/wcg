function imageOnError(defaultSrc, self) {
	self.src = defaultSrc;
	self.onerror = "";
}

$(function() {
	var controller = {
		init : function() {
			if ($(".type0 .card").size() == 0){
				$(".type0 .tipMessage").show();
			}
			if ($(".type1 .card").size() == 0){
				$(".type1 .tipMessage").show();
			}
			if ($(".type0 .card").size() > 0) {
				$(".blockItem").hide();
				$(".cards.type0").show();
				$(".steps>li").removeClass("selected");
				$(".steps>li:eq(0)").addClass("selected");
			} else if($(".type1 .card").size() > 0){
				$(".blockItem").hide();
				$(".cards.type1").show();
				$(".steps>li").removeClass("selected");
				$(".steps>li:eq(1)").addClass("selected");
			} else if($(".combo .fileds").size() > 0){
				$(".blockItem").hide();
				$(".combo").show();
				$(".steps>li").removeClass("selected");
				$(".steps>li:eq(2)").addClass("selected");
			}else{
				$(".blockItem").hide();
				$(".cards.type0").show();
				$(".steps>li").removeClass("selected");
				$(".steps>li:eq(0)").addClass("selected");
			}
			$(".steps").on("click", "li", function() {
				var $_this = $(this);
				$(".blockItem").hide();
				$(".steps>li").removeClass("selected");
				$_this.addClass("selected");
				switch ($_this.index()) {
				case 0: {
					$(".cards.type0").show();
					break;
				}
				case 1: {
					$(".cards.type1").show();
					break;
				}
				case 2: {
					$(".combo").show();
					break;
				}
				}
			});
			$(".tenantLogo.small").css("background-image",
					$(".home:eq(0)").css("background-image"));
		},
		hash : {
			get : function(isSearch) {
				var str = isSearch ? location.search : location.hash;
				var kvs = str.substring(1).split("&");
				var ret = {};
				for (var i = 0; i < kvs.length; i++) {
					var item = kvs[i].split("=");
					if (item[1] == null) {
						continue;
					}
					ret[item[0]] = item[1];
				}
				;
				return ret;
			},
			set : function(data, isSearch) {
				location.href = "#" + $.param(data);
			},

			add : function(data) {
				this.set($.extend(this.get(), data));
			},
			remove : function(keys) {
				var data = this.get();
				for (var i = 0; i < keys.length; i++) {
					delete data[keys[i]];
				}
				;
				this.set(data);
			}
		}
	};

	controller.init();

});