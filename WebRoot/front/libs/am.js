//创建am命名空间
$.fn.setTransformPos = function (pos, d, hasInput) {
    //$("input:focus").blur();

    var opt;

    if (hasInput && $.am.use2d) {

        switch (d) {
            case "x":
                opt = 'translate(' + pos + 'px, 0)';
                // this.parent().scrollLeft(-pos)
                //this[0].style.left = pos+"px";
                break;
            case "y":
                opt = 'translate(0,' + pos + 'px)';
                // this.parent().scrollTop(-pos)
                // this[0].style.top = pos + "px";
                break;
        }
        this[0].style.webkitTransform = opt;
    } else {

        switch (d) {
            case "x":
                opt = 'matrix3d(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, ' + pos + ', 0, 0, 1)';
                break;
            case "y":
                opt = 'matrix3d(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, ' + pos + ', 0, 1)';
                break;
            case "z":
                opt = 'matrix3d(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, ' + pos + ')';
                break;
            case "xy":
                opt = 'matrix3d(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, ' + pos[0] + "," + pos[1] + ', 0, 1)';
                break;
        }
        this[0].style.webkitTransform = opt;
    }

    return this;
}

$.fn.animateTranslate3d = function (cPos, tPos, d, t, cb) {
    //console.log(cPos+" | "+tPos+" | "+d+" | "+t);
    var ot = new Date().getTime();
    var _this = this;
    this.doAnimateTranslate3d = function () {
        var nt = new Date().getTime();
        var step = nt - ot;
        var nPos = cPos + (tPos - cPos) * step / t;
        _this.setTransformPos(nPos, d);
        if (step >= t) {
            _this.setTransformPos(tPos, d);
            //setTimeout(function(){
            cb && cb();
            //},300);
        } else {
            setTimeout(function () {
                _this.doAnimateTranslate3d();
            }, 10);
        }
    }
    this.doAnimateTranslate3d();
}

window.$ && (window.$.am = {})
$.am.supports = {
    CSS3DTransform: (typeof WebKitCSSMatrix != 'undefined' && new WebKitCSSMatrix().hasOwnProperty('m41'))
}
$.am.components = [];
$.am.Component = function (e) {
    if ($.am.apiReady) {
        this.componentInit && this.componentInit();
    }
}
$.am.use2d = false;
$.am.getInnerHeight = function () {
    var h = window.innerHeight;
    return h < 400 ? 400 : h;
}
//fix JSON.parse bug
/*JSON.originalParse = JSON.parse;
JSON.parse = function (text) {
    return text ? JSON.originalParse(text) : text;
}*/
//$ready事件做的事
$(function () {
    $.am.page && $.am.page.init();
    $.am.events && $.am.events.init();
    $.am.debug && $.am.debug.init();
    $.am.elements && $.am.elements.init();

    var device = window.device;

    for (var i = 0; i < $.am.components.length; i++) {
        $.am.components[i].componentInit && $.am.components[i].componentInit();
    }
    $.am.apiReady = true;
    for (var i in $.am.pages) {
        $.am.pages[i].init && $.am.pages[i].init();
    }
    $.am.init && $.am.init();
});