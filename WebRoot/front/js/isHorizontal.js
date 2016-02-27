		var isHorizontal=true;
		$(document).ready(function(e) {
			var roImg='images/public/ro.png';
			var intro='<div id="horizontal" style="width:100%; height:100%; background:url('+roImg+') no-repeat center center; position:fixed; background-color:#004d91; z-index:10000">'+
				'<div style=" position:absolute; bottom:10px; width:100%; text-align:center; font-family:Arial, "微软雅黑"; font-size:26px; color:#fff">© 2015 燊记石烤 Powered by  <a href="http://www.39mnet.com:8080/39mi/index.html" target="_blank" style="color:#fff">39MI</a></div>'+
			'</div>';
           	/*$(window).bind( 'orientationchange', function(e){
				var body=document.body;  
                var viewport=document.getElementById("viewport");  
                if(body.getAttribute("orient")=="landscape"){  
                    body.setAttribute("orient","portrait");
					horizontalHandler(false);
                }else{  
                    body.setAttribute("orient","landscape");  
					horizontalHandler(true);
                }  
			});*/
			
			if(window.orientation==90)horizontalHandler(true);
			
			window.onorientationchange=function(){  
				if(window.orientation==0){  
				  	//alert("竖屏")
					horizontalHandler(false);
				}else{  
					//alert("横屏")
					horizontalHandler(true);
				}  
			}; 
			
			function horizontalHandler(b){
				if(isHorizontal){
					var isObj=$('#horizontal')[0];
					if(b){
						if(!isObj){
							$('body').before(intro);
							document.getElementById('horizontal').addEventListener('touchmove',horizontalTouchmove);
						}
					}else{
						if(isObj){
							document.getElementById('horizontal').removeEventListener('touchmove',horizontalTouchmove);
							$('#horizontal').remove();
						}
					}
				}
			}
			
			
			//horizontalHandler(true);
			function horizontalTouchmove(event){
				//alert(1);
				event.preventDefault();
				return false;	
			}
        });