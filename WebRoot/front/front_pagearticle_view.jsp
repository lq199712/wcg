<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html xmlns="http://www.w3.org/1999/html">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, width=device-width">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta content="black" name="apple-mobile-web-app-status-bar-style">
    <meta name="format-detection" content="telephone=no">
    <meta content="telephone=no" name="format-detection">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>文章详细页</title>

    <link type="text/css" rel="stylesheet" href="stylesheets/vweisiteV01.css"/>
    <link type="text/css" rel="stylesheet" href="stylesheets/font-awesome.css"/>
    <link href="stylesheets/vweisiteV01/article/article6.css" media="screen" rel="stylesheet" type="text/css" />

    <script src="assets/mobile/vweisiteV01-e2ea5a80772cd54559b36cf747bc391d.js" type="text/javascript"></script>
    <meta content="authenticity_token" name="csrf-param" />
<meta content="oCzumFzQ+fKXd45DyJNZn/FqZpnenbGQUJI6ziEAMKY=" name="csrf-token" />
  </head>

  <body>
    

    
    <div class="html" style="">
      <div class="stage" id="stage">
        <section id="sec-index">
          
          <div class="body">
            


<div class="article ckeditor_content" id="article">

  <div class="hd">
    <h1><s:property value="pagearticle.name"/></h1>
    <small><s:date name="pagearticle.createtime" format="yyyy-MM-dd HH:mm:ss"/></small>
  </div>

  <div class="bd">
    
    
  
  
  
  <div style="text-align: center;"><br>
  </div>
  <div>
  <font size="3">
    <img src="<%=basePath %>/<s:property value="pagearticle.image"/>" alt="" /><br><br>
    <s:property value="pagearticle.description" escape="false"/><br>
    
    <s:property value="pagearticle.project"/>
</font>
</div>


</div>






<script>
$(function(){
  $(".ckeditor_content img").css({"height":"auto","width":"auto","max-width":"100%"});
});
</script>

          </div>
        </section>

        

        


      </div><!--.stage end-->
    </div><!--.html end-->

    <div class="alert J-guanzhu" style="display:none">
  <div class="alert-m">
    <div class="alert-img"></div>
    <div class="alert-c">
      <p>请先关注公众帐号</p>
      <p><span class="alert-num">1</span>点击右上角<span class="alert-text">分享按钮</span>查看公众号</p>
      <p><span class="alert-num">2</span>在【添加朋友】—【查找公众号】中搜索</p>
      <p><span class="alert-btn">金公子</span>（长按可复制）</p>
      <p>如果已关注，请打开该公众帐号回复<span class="alert-text"></span>，参与此活动</p>
    </div>
    <div class="alert-f">
      <a href="javascript:;" class="alert-f-btn J-close">我知道了</a>
    </div>
  </div>
</div>
<div class="alert J-register" style="display:none">
  <div class="alert-m">
    <div class="alert-img"></div>
    <div class="alert-c text-center">
    </div>
    <div class="alert-btn-box">
      <div class="alert-cell cell-4">
        <a href="javascript:;" class="alert-f-btn btn-gray J-close">我知道了</a>
      </div>
    </div>
  </div>
</div>

    <footer>
      技术支持：<a href="http://www.39mnet.com:8080/39mi/index.html" >39MI</a>
    </footer>

      <!-- tongji code -->
      <script type="text/javascript">
        var _paq = _paq || [];
        _paq.push(['trackPageView']);
        _paq.push(['enableLinkTracking']);
        (function() {
          var u=(("https:" == document.location.protocol) ? "https" : "http") + "://tongji.vkelai.com/";
          _paq.push(['setTrackerUrl', u+'piwik.php']);
          _paq.push(['setSiteId', 63379]);
          var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0]; g.type='text/javascript';
          g.defer=true; g.async=true; g.src=u+'piwik.js'; s.parentNode.insertBefore(g,s);
        })();

      </script>
      <noscript><p><img src="http://tongji.vkelai.com/piwik.php?idsite=63379" style="border:0;" alt="" /></p></noscript>
      <!-- end tongji code -->

<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js" language="JavaScript"></script>
<script type="text/javascript">
  wx.config({
    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
    appId: 'wxe887bfbbdf8d8860', // 必填，公众号的唯一标识
    timestamp: '1422247872', // 必填，生成签名的时间戳
    nonceStr: 'qJF1IcdkylIHdTbwOx2wcA', // 必填，生成签名的随机串
    signature: '102e7a7c9dfa24380d497cec88bfada7fc962d91',// 必填，签名，见附录1
    jsApiList: [
      'onMenuShareTimeline',
      'onMenuShareAppMessage',
      'onMenuShareQQ',
      'onMenuShareWeibo',
      'getNetworkType',
      'openLocation',
      'getLocation',
      'hideOptionMenu',
      'showOptionMenu',
      'hideMenuItems',
      'showMenuItems',
      'hideAllNonBaseMenuItem',
      'showAllNonBaseMenuItem',
      'closeWindow',
      'scanQRCode'
    ]
  });


    wx.ready(function () {
      // 2. 分享接口
      // 2.1 监听“分享给朋友”，按钮点击、自定义分享内容及分享结果接口



      wx.onMenuShareAppMessage({
        title: '' || document.title,
        desc: '' || document.title,
        link: 'http://m.vcooline.com/73287/detail/512895?material_id=129421&amp;origin_openid='.replace('&amp;', '&'),
        imgUrl: 'http://vcl-pictures.qiniucdn.com/FiF0tSo5WZzH_i0_CDUgemvPd8Et',
        trigger: function (res) {
          // alert('用户点击发送给朋友');
        },
        success: function (res) {
          // alert('已分享');
        },
        cancel: function (res) {
          // alert('已取消');
        },
        fail: function (res) {
          // alert(JSON.stringify(res));
        }
      });

      // 2.2 监听“分享到朋友圈”按钮点击、自定义分享内容及分享结果接口
      wx.onMenuShareTimeline({
        title: '' || document.title,
        link: 'http://m.vcooline.com/73287/detail/512895?material_id=129421&amp;origin_openid='.replace('&amp;', '&'),
        imgUrl: 'http://vcl-pictures.qiniucdn.com/FiF0tSo5WZzH_i0_CDUgemvPd8Et',
        trigger: function (res) {
          // alert('用户点击分享到朋友圈');
        },
        success: function (res) {
          // alert('已分享');
        },
        cancel: function (res) {
          // alert('已取消');
        },
        fail: function (res) {
          // alert(JSON.stringify(res));
        }
      });

      // 2.3 监听“分享到QQ”按钮点击、自定义分享内容及分享结果接口
      wx.onMenuShareQQ({
        title: '' || document.title,
        desc: '' || document.title,
        link: 'http://m.vcooline.com/73287/detail/512895?material_id=129421&amp;origin_openid='.replace('&amp;', '&'),
        imgUrl: 'http://vcl-pictures.qiniucdn.com/FiF0tSo5WZzH_i0_CDUgemvPd8Et',
        trigger: function (res) {
          // alert('用户点击分享到QQ');
        },
        complete: function (res) {
          // alert(JSON.stringify(res));
        },
        success: function (res) {
          // alert('已分享');
        },
        cancel: function (res) {
          // alert('已取消');
        },
        fail: function (res) {
          // alert(JSON.stringify(res));
        }
      });

      // 2.4 监听“分享到微博”按钮点击、自定义分享内容及分享结果接口
      wx.onMenuShareWeibo({
        title: '' || document.title,
        desc: '' || document.title,
        link: 'http://m.vcooline.com/73287/detail/512895?material_id=129421&amp;origin_openid='.replace('&amp;', '&'),
        imgUrl: 'http://vcl-pictures.qiniucdn.com/FiF0tSo5WZzH_i0_CDUgemvPd8Et',
        trigger: function (res) {
          // alert('用户点击分享到微博');
        },
        complete: function (res) {
          // alert(JSON.stringify(res));
        },
        success: function (res) {
          // alert('已分享');
        },
        cancel: function (res) {
          // alert('已取消');
        },
        fail: function (res) {
          // alert(JSON.stringify(res));
        }
      });
    })
</script>
<script type="text/javascript">
//var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
//document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F70cd0b5522647a22a0c663468ebfc0df' type='text/javascript'%3E%3C/script%3E"));
</script>


  <style type="text/css">
        /*pop*/
    .pop-zoom{display:none;width:100%;height:100%;color:#fff;position:fixed;left:0;top:0;background:rgba(0,0,0,0.5);z-index:10000;}
    .pop-zoom-img{background:#000;text-align:center;overflow:hidden;}
    .show-img{width:100%;height:100%;overflow:hidden;position:relative;}
    .show-img img{max-width:100%;}
    .zoom-close{position:fixed;right:5px;top:5px;display:block;z-index:99999;}
    .zoom-close .fa{width:30px;height:30px;font-size:25px;line-height:30px;border-radius:50%;color:#fff;background:#999;}
</style>
<script src="assets/mobile/lib/iScroll-4.2.5.js"></script>
<script type="text/javascript">
    var flag = true; css_reg = /^[\w]*font-awesome\.min[\w]*/;
    $.each($('link[type="text/css"]'), function(){
        var arr = $(this).attr('href').split('/');
        if(arr.length == 0){
            return true;
        }
        if(css_reg.test(arr[arr.length - 1])){
            flag = false;
            return flag;
        }
    });
    if(flag){
        document.write('<link rel="stylesheet" href="assets/font/font-awesome.min.css">')
    }
    var img_zoom_myscroll, img_zoom_scrollTop;

    function loaded(){
        img_zoom_myscroll = new iScroll("imgScroll",{
            hScroll: true,
            useTransition: true,
            hScrollbar: false,
            vScrollbar: false,
            zoom: true
        });
        document.addEventListener("DOMContentLoaded",loaded,false);
    }

    $(function(){
        $('body').append('<div class="pop-zoom pop-zoom-img"><div class="show-img" id="imgScroll"><div><img src=""></div></div><a href="javascript:;" class="zoom-close"><i class="fa fa-times"></i></a>')
        $('body').on('click', 'img', function(){
            if(($(this).closest('a').length > 0 && ($(this).closest('a').attr('href') != '#' && $(this).closest('a').attr('href') != 'javascript:;')) || $(this).closest('.mod-navLine').length > 0 || $(this).hasClass('website_list_21')){

            }else{
                var $this = $(this),
                    $src = null,
                    $img = $(".show-img img"),
                    $pop = $(".pop-zoom-img");
                img_zoom_scrollTop = $(document).scrollTop();
                $(document).scrollTop(0);
                if(!$this.attr('data-src')){
                  $src = $this.attr("src");
                }else{
                  $src = $this.attr("data-src");
                }
                $img.attr("src",$src);
                $pop.show();
                setTimeout(function(){
                    loaded();
                },300);
                //console.log(scrollTop);
            }
        });
        $(document).on("click",".zoom-close",function(){
            $(document).scrollTop(img_zoom_scrollTop);
            $(this).parents(".pop-zoom").hide();
            $(".show-img img").attr('src', '');
            img_zoom_myscroll.destroy();
        })
        var initTop = 0,
            isScroll = true;
        function fnAnimate(thisTop){
            $("header:not('.untoppable')").animate({top:thisTop},"500",function(){isScroll=true});
        }
        $(window).on("scroll",function(){
            var scrollTop = $(document).scrollTop();
            if(isScroll){
                if(scrollTop > initTop){
                    fnAnimate("-44px");
                }else{
                    fnAnimate("0");
                }
            }
            initTop = scrollTop;
            isScroll = false;
        });
    });
</script>


    
    

    
    
    



    

    <a href="javascript:scroll(0,0)" class="btn-up btn-up-1"><i class="fa fa-arrow-up"></i></a>
    <div class="loading fixed-top"></div>

    <div class="mod-pop" id="pop-share" onclick="hidePop('#pop-share')"><span class="text-share"></span></div>

    <script type="text/javascript">
      $(document).ready(function(){

        

        showBtnUp(100);

        $("a.dev-prev").click(function(){
            history.back();
        });

        $("a.dev-next").click(function(){
          history.go(1);
        });

        $("a.dev-index").click(function(){
          location.href = "http://m.vcooline.com/73287?id=26837#mp.weixin.qq.com";
        });

        $("a.dev-refresh").click(function(){
          location.reload();
        });

        $("a.dev-tel").attr("href", "tel:电话号码未设置");

        $("a.dev-member").click(function(){
          $(this).attr("href", "http://m.vcooline.com/app/vips?wxmuid=41930#mp.weixin.qq.com")
        });

        $("a.dev-location").click(function(){
          $(this).attr("href", "http://m.vcooline.com/73287/map?id=26837")
        });
      });
    </script>

  </body>
</html>
