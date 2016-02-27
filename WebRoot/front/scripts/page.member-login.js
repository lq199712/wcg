function imageOnError(defaultSrc,self){
			self.src = defaultSrc;
			self.onerror = "";
}

$(function() {
	// get tenant code from url
//	var baseurl = window.location.pathname.split("/")[1];
	var tenantCode = "";
	var openId = "";
	var storeId="";
	var redirect = "";

	var controller = {
		init : function() {
			tenantCode = this.hash.get(true).tenantCode==undefined?"":this.hash.get(true).tenantCode;
			storeId = this.hash.get(true).storeId==undefined?"":this.hash.get(true).storeId;
			openId = this.hash.get(true).openId==undefined?"":this.hash.get(true).openId;
			redirect = this.hash.get(true).redirect==undefined?"":this.hash.get(true).redirect;
			if($(".register").size()==1){
				$_register = $(".register a");
				$_register.attr("href",$_register.attr("href")+"?tenantCode="+tenantCode+"&storeId="+storeId+"&redirect="+redirect);
			}
//			$("#tenantLogo").css("background-image",$(".logo").css("background-image"));
			$("#login").click(
					function() {
						var $_this = $(this);
						if (!$_this.hasClass("disabled")) {
							$_this.addClass("disabled");
							var phone = $("#phone").val();
							var rePhone = /^0?(13[0-9]|15[012356789]|18[0-9]|14[57])[0-9]{8}$/;
							if (!rePhone.test(phone)) {
								amGloble.msg("请输入有效手机号!");
								$_this.removeClass("disabled");
								return;
							}
							var smscode = $("#smscode").val();
							if (smscode == "" || smscode == null) {
								amGloble.msg("请输入短信验证码");
								$_this.removeClass("disabled");
								return;
							}
							var succesCallback = function(ret) {
								amGloble.hideBusy();
								$_this.removeClass("disabled");
								if (ret.success == 200) {
									if(ret.data.length>0){
										window.location.href = ret.data;
									}else{
										window.location.href = "./member-info";
									}
									
								} else if(ret.success==301){
									var tenants = ret.data;
									var html = '';
									$.each(tenants,function(_index,_item){
										html+= '<li><label>';
										html+='<input type="radio" name="tenantSelect" '+(_index==0?'checked="checked"':'')+' value="'+_item.code+'" /> <span>'+_item.name+'</span>';
										html+= '</label></li>'
									});
									$(".tanantChoose>ul").empty();
									$(".tanantChoose>ul").html(html);
									$(".tanantChoose").show();
								} else {
									amGloble.msg(ret.message);
								}
							};
							var tenantSelected = $("input[name=tenantSelect]:checked").val();
							if(tenantSelected!=undefined){
								tenantCode = tenantSelected;
							}
							amGloble.showBusy();
							$.ajax({
								url : "./login?ts="+(new Date()).getTime(),
								type : "POST",
								data : {
									phone : $("#phone").val(),
									smscode : $("#smscode").val(),
									tenantCode: tenantCode,
									openId:openId,
									storeId:storeId,
									redirect:redirect
								},
								dataType : "json",
								success : succesCallback,
								error : function() {
									amGloble.hideBusy();
									$_this.removeClass("disabled");
									amGloble.msg("用戶验证失败!");
								}
							});
						}
					});

			$("#getCode").click(function() {
				var $_this = $(this);
				var phone = $("#phone").val();
				var rePhone = /^0?(13[0-9]|15[012356789]|18[0-9]|14[57])[0-9]{8}$/;
				if (!rePhone.test(phone)) {
					amGloble.msg("请输入有效手机号!");
					return;
				}
				if (!$_this.hasClass("disabled")) {
					$_this.addClass("disabled");
					amGloble.msg("验证码已发送，请查收");
					var succesCallback = function() {
						var _timer = 60;
						var timerId = self.setInterval(function() {
							if (_timer < 0) {
								$_this.removeClass("disabled");
								$_this.text("再次获取验证码");
								window.clearInterval(timerId);
								return;
							}
							$_this.text("再次发送 " + _timer);
							_timer--;
						}, 1000);
					};
					$.ajax({
						url : "./smscode?ts="+(new Date()).getTime(),
						type : "POST",
						data : JSON.stringify({
							phone : $("#phone").val()
						}),
						dataType : "json",
						success : succesCallback,
						error : function() {
							console.log("error");
						}
					});
				}
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