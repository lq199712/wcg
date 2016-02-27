$(function(){
	$('.backtomenu').click(function(){
		$('.main-menu-list').show();
		$('.frame-wrapper').hide();
		$('.left > .intro').show();		
		$('.left > .menu').hide();
		$('#main').attr('src','');
	});
	$('.spliter').click(function(){
		if($('.left').is(':visible')){
			$('.left').hide();
			$('.spliter').css('left','0px');
			$('.right').css('left','9px');			
		}else{
			$('.left').show();
			$('.spliter').css('left','240px');
			$('.right').css('left','249px');
		}
	});
	$('.main-menu-list').delegate('div.menu','click',function(){ 
	    var module     = $(this).parent().attr('id');
		var targetpage = $.trim($(this).attr('data-mname'));
		if(targetpage==''){
			return;
		}
		$('#main').attr('src','/admin/'+module+'/'+targetpage+'.html');		
		$('.main-menu-list').hide();
		$('.frame-wrapper').show();
		$('.left > .intro').hide();		
		$('.left > .menu').show();
		$('.backtomenu').next('ul').html($(this).find('ul').html());
		setLeftmenuSelect(targetpage);
	});
	$('.left > .menu').delegate('a[data-mname]','click',function(){
		var module = $(this).attr('href'); 
		var targetpage = $(this).attr('data-mname');
		$('#main').attr('src',module);
		setLeftmenuSelect(targetpage);
		return false;
	});
	resetsize();
	$(window).resize(resetsize);
});
function resetsize(){
	$('#main').height($('.frame-wrapper').height());
}

function setLeftmenuSelect(targetpage){
	$('.left > .menu').find('a').parent().removeClass('selected');
	$('.left > .menu').find('a[data-mname="'+targetpage+'"]').parent().addClass('selected');
}