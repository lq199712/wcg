//amGloble.page.campaigns = {
//    Url: "/campaign", /* {


//        | GET | /barber?tenantId=1&page=1&pageLength=10 | |
//	| GET | /barber?tenantId=1&couponId=1&page=1&pageLength=10 | |
//	| GET | /barber?tenantId=1&campaignId=1&page=1&pageLength=10 | |*/



//    QueryString: {
//        tenantId: 1,
//        storeId: 1,
//        page: 1,
//        pageLength: 10
//    },

//    genertateUrlEcodeFormData: function (dic) {

//        var querys = [];
//        for (var a in dic) {
//            if (dic.hasOwnProperty(a)) {
//                querys.push(a + "=" + dic[a]);
//            }
//        }

//        if (querys.length == 0)
//            return "";

//        return "?" + querys.join("&");
//    },

//    OpenUrl: function (success, fail) {



//        var search = this.genertateUrlEcodeFormData({});

//        $.get(this.Url + search).done(function () {
//            success && success();

//        }).fail(function () {

//            fail && fail();
//        });
//    },

//    clear: function () {
//        $("#campaign-list").empty();
//    },

//    render: function (data) {
//        var list = $("#campaign-list");

//        /* <li class="am-clickable" onclick="location.href='campaign-detail.html'">
//                            <div class="img"></div>
//                            <div class="title">开业购物有惊喜！</div>
//                            <div class="time">2013/01/15-2013/01/30</div>
//                            <div class="favour am-clickable">(125)</div>
//                        </li>*/
//        var lis = [];

//        /*{
//			"id":1000032,
//			"title":"XXXX",
//			"likeCount":120,
//			"start":1390185666115,
//			"end":1390185766115,
//			"showcase":[
//				{
//					"thumb":"fileUrl"
//				}
//			]
//			}*/

//        for (var i = 0; i < data.length; i++) {
//            var d = data[i];


//            var img = (d.showcase && d.showcase.length > 0) ? d.showcase[0].thumb : "";
//            lis.push(
//                        "<li class=\"am-clickable\" onclick=\"location.href='campaign-detail.html?campaignId=" + d.id + "'\">" +
//                            "<div class=\"img\"><img src=\"" + img + "\" /></div>" +
//                            "<div class=\"title\">" + d.title + "</div>" +
//                            "<div class=\"time\">" + (new Date(d.start)).toLocaleDateString() + "-" + (new Date(d.end)).toLocaleDateString() + "</div>" +
//                            "<div class=\"favour am-clickable\">(" + d.likeCount + ")</div>" +
//                        "</li>"
//                );
//        }

//        list.append($(lis.join("")));
//    },

//    Action: {
//        refresh: 0,
//        next: 1
//    },

//    _currentAction: 0,

//    toggleLoadingStyle: function (beforeRequest) {
//        if (beforeRequest) {
//            $(".loading-bar").show();
//            if (this._currentAction == this.Action.next) {
//                $(".load-more").text("加载中...请稍后").addClass("am-disabled");
//            }
//        } else {
//            $(".loading-bar").hide();
//            if (this._currentAction == this.Action.next) {
//                $(".load-more").text("显示更多").removeClass("am-disabled");
//            }
//        }
//    },

//    getData: function () {
//        var $this = this;


//        if (this.QueryString.page == 1 || this._currentAction == this.Action.refresh) {
//            this.clear();
//        }


//        this.toggleLoadingStyle(true);

//        //this.OpenUrl(function () {

//        //    $(".loading-bar").hide();

//        //    var data = [];
//        //    for (var i = 1; i < 4; i++) {
//        //        data.push({
//        //            "id": 132 + i,
//        //            "title": "活动" + i,
//        //            "likeCount": Math.ceil(Math.random() * 100),
//        //            "start": 1390185666115,
//        //            "end": 1390185766115,
//        //            "showcase": [
//        //                {
//        //                    "thumb": "img/campaign_" + i + ".png"
//        //                }
//        //            ]
//        //        });
//        //    }

//        //    $this.render(data);

//        //    if (data.length > 0) {
//        //        $(".load-more").show();
//        //    } else {
//        //        $(".load-more").hide();
//        //    }

//        //}, function () {

//        //    $(".loading-bar").hide();

//        //    $(".empty-msg").html("当前门店暂时没有活动").show();
//        //});

//        //demo

//        setTimeout(function () {

//            $this.toggleLoadingStyle(false);

//            var data = [];
//            for (var i = 1; i < 4; i++) {
//                data.push({
//                    "id": 132 + i,
//                    "title": "活动" + i,
//                    "likeCount": Math.ceil(Math.random() * 100),
//                    "start": 1390185666115,
//                    "end": 1390185766115,
//                    "showcase": [
//                        {
//                            "thumb": "img/campaign_" + i + ".png"
//                        }
//                    ]
//                });
//            }

//            $this.render(data);

//            if (data.length > 0) {
//                $(".load-more").show();
//            } else {
//                $(".load-more").hide();
//            }

//        }, 3000);

//    },
//    init: function () {

//        var $this = this;
//        $(".load-more").click(function () {

//            $this._currentAction = $this.Action.next;
//            $this.QueryString.page += 1;
//            $this.getData();
//        });
//    }
//};


//$(function () {
//    amGloble.page.campaigns.init();
//    amGloble.page.campaigns.getData();
//});

$(function () {

    $("li.operation .favour").vclick(function () {
        var paths = location.pathname.split('/');
        window.amGloble.Rating(
            $(this), amGloble.RATINGURLS.campaign,
            {
                //tenantId: window.amGloble.getCookie("tenantId"),
            	tenantId: $("#tenantIdVal").val(),
                campaignId: $(this).attr("data-id")
            }, 'post', function () { }, function () { });

        return false;
    });
});






//$(".operation .favor").vclick(function () {
//    var paths = location.pathname.split('/');
//    window.amGloble.Rating($(this), amGloble.RATINGURLS.product,
//         {
//             //tenantId: window.amGloble.getCookie("tenantId"),
//             productId: paths[paths.length - 1]
//         }, 'post', function () { }, function () { });
//
//
//});