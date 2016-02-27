
function imageOnError(defaultSrc,self){
			self.src = defaultSrc;
			self.onerror = "";
}

$(function() {
	var controller = {
		init : function() {
			var initial = this.hash.get(true).initial==undefined?"":this.hash.get(true).initial;
			if(initial!=""){
				switch(initial){
				case "coupon":
					$(".blockItem").hide();
					$(".coupons").show();
					$(".steps>li").removeClass("selected");
					$(".steps>li:eq(4)").addClass("selected");
				}
			}else{
				if($(".cardItem").size()>0){
					$(".blockItem").hide();
					$(".cards").show();
					$(".steps>li").removeClass("selected");
					$(".steps>li:eq(0)").addClass("selected");
				}else{
						var searchStr = location.search.slice(1).split("&");
						searchStr = searchStr[1].substr(4,1);
						if(searchStr==2)
						{
							$(".blockItem").hide();
							$(".package").show();
							$(".steps>li").removeClass("selected");
							$(".steps>li:eq(2)").addClass("selected");
						}
						else
						{
							$(".blockItem").hide();
							$(".me").show();
							$(".steps>li").removeClass("selected");
							$(".steps>li:eq(4)").addClass("selected");
						}
					
				}
			}
			$(".cardItem:gt(0)").hide();
			if($(".cardItem").size()==1){
				$(".card").css("padding-top","10px");
			}
			$(".steps").on("click","li",function(){
				var $_this = $(this);
				$(".blockItem").hide();
				$(".steps>li").removeClass("selected");
				$_this.addClass("selected");
				switch($_this.index()){
				case 0:{
					$(".cards").show();
					break;
				}
				case 1:{
					$(".package").show();
					break;
				}
				case 2:{
					$(".record").show();
					break;
				}
				case 3:{
					$(".coupons").show();
					break;
				}
				case 4:{
					$(".me").show();
					break;
				}
				}
			});
			var cardInterval;
			$(".cardItem .card").click(function(){
				var $_this = $(this);
				$_this.next().children(".barcodeLoaderContainer").children(".barcodeLoader").height($_this.children("img").height());
				$_this.next().children("img").hide().height($_this.children("img").height()).attr("src","./getAndShowDynamicCode?cardNumber="+$_this.attr("data")+"&ts="+(new Date()).getTime());
				cardInterval = setInterval(function(){
					$_this.next().children("img").attr("src","./getAndShowDynamicCode?cardNumber="+$_this.attr("data")+"&ts="+(new Date()).getTime());
				},60000);
//				console.log("interval["+cardInterval+"] created");
				$_this.hide();
				$_this.next().show();
			});
			$(".barcode").click(function(){
				clearInterval(cardInterval);
//				console.log("interval["+cardInterval+"] destroyed");
				$(this).hide();
				$(this).children(".barcodeLoaderContainer").show();
				$(this).prev().show();
			});
			
			$(".tenantLogo.small").css("background-image",$(".home:eq(0)").css("background-image"));
			
			$(".c_dropbox .current").click(function(){
				$(this).next().toggle();
			});
			
			$(".c_dropbox .list li").click(function(){
				$(this).parent().parent().hide();
				if($(this).index()!=($(".cardItem:visible").index()-1)){
					$(".cardItem").hide();
					var $_selectedItem = $(".cardItem:eq("+$(this).index()+")");
					clearInterval(cardInterval);
//					console.log("interval["+cardInterval+"] destroyed");
					$_selectedItem.show();
					$_selectedItem.children(".card").show();
					$_selectedItem.children(".barcode").hide().children(".barcodeLoaderContainer").show();
					$(".current").text($(this).text());
				}
			});
			
			$("span.comment.green").click(function(){
				var $_this = $(this);
				$_this.parent().next().toggle();
			});
			
			$("ul.score").on("click","li",function(){
				var $_this = $(this);
				$_this.parent().children("li").removeClass("selected");
				$_this.addClass("selected");
			});
			
			$(".submitFeedback").click(function(){
				var $_this = $(this);
				var feedbackText = $_this.prev().children().val();
				if(feedbackText==""||feedbackText==null){
					amGloble.msg("请输入点评内容");
					return;
				}
				var overallScore = $_this.parent().prev().children(".selected").index();
				var serviceId = $_this.next().val();
				var prevElement = $_this.parent().parent().prev();
				var succesCallback = function(ret){
					amGloble.hideBusy();
					if(ret.data==true){
						amGloble.msg("点评成功");
						prevElement.children(".comment").remove();
						var html='<div class="commentText">';
						html+='<div class="score icon'+(overallScore+1)+'">';
						switch(overallScore){
						case 0:{
							html+="好评";
							break;
						}
						case 1:{
							html+="中评";
							break;
						}
						case 2:{
							html+="差评";
							break;
						}
						}
						html+='</div>';
						html+='<div class="content">'+feedbackText+'</div>';
						html+='</div>';
						
						prevElement.next().remove();
						prevElement.after(html);
					}else{
						amGloble.msg("点评失败");
					}
				};
				amGloble.showBusy();
				$.ajax({
					url : "./member-info/submitFeedback", 
					type : "POST",
					data : {
						'feedbackText' : feedbackText,
						'overallScore': overallScore,
						'serviceId': serviceId
					},
					dataType : "json",
					success : succesCallback,
					error : function(){
						amGloble.hideBusy();
						amGloble.msg("点评失败");
					}
				});
			});
			$("#logout").click(function(){
				amGloble.showBusy();
				window.location.href = "./member-logout";
			});
			//adbar
			if($(".page_adBar").size()>0){
				setTimeout(function(){
					$(".page_adBar").slideDown(300);
				},2000);
			}
			//defaultBarber
			if($("#defaultBarber").size()==1){
				$("#defaultBarber").click(function(){
					window.location.href = $(this).attr("data");
				});
			}
			//reservation
			//$("li.reservation").click(function(){
				//window.location.href = "tel:15250838555";
			//});
			//goto coupon store
			$(".page-button.red.buy").vclick(function(){
				window.location.href = $(this).attr("data");
			});
			
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
				};
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
				};
				this.set(data);
			}
		}
	};

	controller.init();

});