/*===============================================================
***************************************************************
*-*           author:低吟的风  qq:17391193                  *-*

//////////////////////////////////
图片预加载/
//////////////////////////////////

****************************************************************/
$.fn.imagesLoaded = function( callback ){
  var elems = this.find( 'img' ),
      elems_src = [],
      self = this,
      len = elems.length;
 
  if ( !elems.length ) {
    callback.call( this );
    return this;
  }
 
  elems.one('load error', function() {
    if ( --len === 0 ) {
      // Rinse and repeat.
      len = elems.length;
      elems.one( 'load error', function() {
        if ( --len === 0 ) {
          callback.call( self );
        }
      }).each(function() {
        this.src = elems_src.shift();
      });
    }
  }).each(function() {
    elems_src.push( this.src );
    // webkit hack from http://groups.google.com/group/jquery-dev/browse_thread/thread/eee6ab7b2da50e1f
    // data uri bypasses webkit log warning (thx doug jones)
    this.src = "data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///ywAAAAAAQABAAACAUwAOw==";
  });
 	
  return this;
};

//perload
$.fn.preload_images = function(options,callback) {
	options = $.extend({
		src : ""
	},options);
	var _self = this;
	var img = new Image();
	$(img).load(function(){
		_self.attr("src", options.src);
		//执行回调函数
		callback.call(options.src)
	}).attr("src", options.src);
	
	return _self;
}



//图片的预加载
//参数sources:图片信息关联数组
//参数callback:回调函数——图片预加载完成后立即执行此函数。
var loadImages=function(sources, callback){
	
    var count = 0,//图片数量
		images ={},//图片LIST
        imgNum = 0;//图片张数
	
	//获取图片张图
    for(src in sources){
        imgNum++;
    }
	//images loader
    for(src in sources){
        images[src] = new Image();//创建一个Image对象，实现图片的预下载
        images[src].onload = function(){
			//alert('img重新加载：'+count);
            if(++count >= imgNum){
                callback.call(images);//执行回调函数
            }
			//var pro=Math.floor((100/imgNum*(count)));
			//$(".progress").html('Loading…'+pro+"%");
        }
        images[src].src = sources[src];//图片加载路径
    }
} 