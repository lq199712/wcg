window.amGloble = window.amGloble ? window.amGloble : {};

/*/store/like?tenantId=1&storeId=1	
GET	/coupon/like?tenantId=1&couponId=1	
GET	/campaign/like?tenantId=1&campaignId=1*/

//window.amGloble.RATINGURLS = {
//    coupon: "/store/like",
//    store: "/coupon/like",
//    campaign: "/campaign/like",
//    barber: "/barber/like"
//};

//<p class="favor am-clickable" id="store_like"><span>(125)</span></p>
/*

��
window.amGloble.Rating($('#store_like'),amGloble.RATINGURLS.store,{tenantId:1,storeId:1},'get',function(){},function(){});

*/
window.amGloble.Rating = function (element, ratingType, formData, method, success, failure) {

    if (ratingType && ratingType.toString().length > 0) {
        var url = ratingType,
             search = [];
        if (formData && method == "get") {
            for (var a in formData) {
                if (formData.hasOwnProperty(a)) {
                    search.push(a + "=" + encodeURI(formData[a]));
                }
            }
        }

        var args = (search.length > 0) ? "?" + search.join("&") : "";

        var request = {
            url: url + args,
            type: method
        };

        if (method == "post") {
            request.data = formData;
        }

        var innerSpan = element.children("span");
        element.addClass("am-disabled").attr("data-history", innerSpan.text());
        innerSpan.text("").addClass("loading-inner-text");


        var _failure = function () {

            element.removeClass("am-disabled");
            innerSpan.removeClass("loading-inner-text").text(element.attr("data-history"));

            failure && failure();
        }

        $.ajax(request).done(function (xhr) {


            if (xhr && xhr.success == 200 && xhr.data) {
                innerSpan.removeClass("loading-inner-text").text("(" + xhr.data + ")");
                success && success();
            } else {
                _failure();
            }
            

        }).fail(function (xhr) {

            _failure();
        });
    }
}


window.amGloble.getCookie = function (name) {

    if (document.cookie.length > 0) {
        start = document.cookie.indexOf(name + "=")
        if (start != -1) {
            start = start + name.length + 1
            end = document.cookie.indexOf(";", start)
            if (end == -1) end = document.cookie.length
            return unescape(document.cookie.substring(start, end))
        }
    }
    return ""

}


	

/*amGloble.waterfall=function($d){
	var $copy = $("<"+$d[0].tagName+"/>");
	$copy.attr("class",$d.attr("class"));
	$lis = $d.children();
	$d.after($copy);
	var i=0,$lis;
	window._loadNext = function(j){
		console.log(j);
		var $li = $lis.eq(j);
		if($li.length<1){
			console.log("list done!");
			return;
		}
		if($d.height()>$copy.height()){
			$copy.append($li);
		}
		var $img = $li.show().find("img");
		if($img.length<1){
			i++;
			window._loadNext(i);
		}else{
			$img.attr("src",$img.attr("imgSrc")).bind({
				"load" : function() {
					$(this).css("visibility","visible");
					i++;
					window._loadNext(i);
				},
				"error" : function() {
					i++;
					window._loadNext(i);
				}
			});
		}
	}
	window._loadNext(i);
}
*/
amGloble.waterfall=function($d){
	var $copy = $("<"+$d[0].tagName+"/>");
	$copy.attr("class",$d.attr("class"));
	$lis = $d.children();
	$d.after($copy);
	var i=0,$lis;
	$lis.each(function(i){
		if($d.height()>$copy.height()){
			$copy.append($(this));
		}
		var $img = $(this).show().find("img");
		if($img.length<1){
			return;
		}
		var w=$img.parent().width();
		var src = $img.attr("imgSrc");
		var size;
		try{
			size=src.split("_");
			if(size.length>2){
				size = size[1].split("x");
			}else{
				size = size[1].split(".")[0].split("x");
			}
		}catch(e){
			size =[w,w];
		}
		$img.bind({
			"load" : function() {
				$(this).css("visibility","visible");
			},
			"error" : function() {
			}
		}).css({
			height:size[1]/size[0]*w+"px"
		}).attr("src",src);
		console.log($d.height()+"/"+$copy.height());
		
	});
}
