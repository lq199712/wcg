//pageKit.js
//登陆页面，验证码
function changeImage()
{
			var v=document.getElementById("im");
			v.innerHTML="<img src=validateCode width=80 height=32  />";
}
//委员列表分页显示
function jumpPage(url,page){
	var page=page;
	if(isNaN(page)){
		var page2=document.getElementById(page).value;
		page=parseInt(page2);
	}
	
	var url=url+'?page='+page;
	window.location=url;
}
function jumpConmanagePage(url,page,constatusarg){
	var page=page;
	if(isNaN(page)){
		var page2=document.getElementById(page).value;
		page=parseInt(page2);
	}
	
	var url=url+'?page='+page+'&constatusarg='+constatusarg;
	window.location=url;
}
//proposal_mylistByStatus.jsp
function jumpPpStatusPage(url,page,prstatus){
	var page=page;
	if(isNaN(page)){
		var page2=document.getElementById(page).value;
		page=parseInt(page2);
	}
	
	var url=url+'?page='+page+'&cmid='+cmid+'&prstatus='+prstatus;
	window.location=url;
}
//委员个人列表分页显示
function jumpItsPage(url,page,cmid){
	var page=page;
	if(isNaN(page)){
		var page2=document.getElementById(page).value;
		page=parseInt(page2);
	}
	
	var url=url+'?page='+page+'&cmid='+cmid;
	window.location=url;
}
//contribution_mylist.jsp
function jumpContributionPage(url,page,constatus){
	var page=page;
	if(isNaN(page)){
		var page2=document.getElementById(page).value;
		page=parseInt(page2);
	}
	
	var url=url+'?page='+page+'&constatusarg='+constatus;
	window.location=url;
}
//我的提案按状态分页显示
function jumpPpStatusPage(url,page,prstatus){
	var page=page;
	if(isNaN(page)){
		var page2=document.getElementById(page).value;
		page=parseInt(page2);
	}
	
	var url=url+'?page='+page+'&prstatus='+prstatus;
	window.location=url;
}
function jumpManageStatusPage(url,page,prstatus){
	var page=page;
	if(isNaN(page)){
		var page2=document.getElementById(page).value;
		page=parseInt(page2);
	}
	
	var url=url+'?page='+page+'&prstatus='+prstatus;
	window.location=url;
}
//委员信息查询
function jumpCommitteeQueryPage(url,page,arg){
	var page=page;
	if(isNaN(page)){
		var page2=document.getElementById(page).value;
		page=parseInt(page2);
	}
	
	var url=url+'?page='+page+'&arg='+arg;
	window.location=url;
}

//管理员条件查询、proposal_conditionResult.jsp
function jumpManageConditionPage(url,page,con,convalue,prstart,prend){
	var page=page;
	if(isNaN(page)){
		var page2=document.getElementById(page).value;
		page=parseInt(page2);
	}
	
	var url=url+'?page='+page+'&con='+con+'&convalue='+convalue+'&prstart='+prstart+'&prend='+prend;
	url=encodeURI(url);
	url=encodeURI(url);
	window.location=url;
}

function jumpContriConditionPage(url,page,con,convalue,contype){
	var page=page;
	if(isNaN(page)){
		var page2=document.getElementById(page).value;
		page=parseInt(page2);
	}
	
	var url=url+'?page='+page+'&contype='+contype+'&con='+con+'&convalue='+convalue;
	url=encodeURI(url);
	url=encodeURI(url);
	window.location=url;
}

//zwh
function jumpzwhPage(url,page,ctype,cvalue){
	var page=page;
	if(isNaN(page)){
		var page2=document.getElementById(page).value;
		page=parseInt(page2);
	}
	
	var url=url+'?page='+page+'&ctype='+ctype+'&cvalue='+cvalue;
	window.location=url;
}
//committee_addresslist.jsp
function jumpCommitteeAddressPage(url,page,con,convalue,conperid){
	var page=page;
	if(isNaN(page)){
		var page2=document.getElementById(page).value;
		page=parseInt(page2);
	}
	
	var url=url+'?page='+page+'&conperid='+conperid+'&con='+con+'&convalue='+convalue;
	url=encodeURI(url);
	url=encodeURI(url);
	window.location=url;
}
//committee_list.jsp
function jumpCommitteelistPage(url,page,con,convalue,conperid,isconfirm){
	var page=page;
	if(isNaN(page)){
		var page2=document.getElementById(page).value;
		page=parseInt(page2);
	}
	
	var url=url+'?page='+page+'&conperid='+conperid+'&isconfirm='+isconfirm+'&con='+con+'&convalue='+convalue;
	url=encodeURI(url);
	url=encodeURI(url);
	window.location=url;
}
//委员列表分页显示（带条件）
/*
function jumpPage(page){
	var addr=document.getElementById("addr");
	var addresult;
	var url;
	if(addr.value.length!=0){
		addresult=addr.value.replace(/(^\s*)|(\s*$)/g,'');
		url="showRentInfo?page="+page+"&addr="+addresult;
	}else{
		url="showRentInfo?page="+page;
	}
	url=encodeURI(url);
	url=encodeURI(url);
	window.location=url;
}
*/

function jumpStatisticPage(url,page,contype,constart,conend,conpeople){
	var page=page;
	if(isNaN(page)){
		var page2=document.getElementById(page).value;
		page=parseInt(page2);
	}
	
	var url=url+"?page="+page+"&contype="+contype+"&constart="+constart+"&conend="+conend+"&conpeople="+conpeople;
	url=encodeURI(url);
	url=encodeURI(url);
	window.location=url;
}

function jumpPrStatisticPage(url,page,prstart,prend,prpeople){
	var page=page;
	if(isNaN(page)){
		var page2=document.getElementById(page).value;
		page=parseInt(page2);
	}
	
	var url=url+"?page="+page+"&prstart="+prstart+"&prend="+prend+"&prpeople="+prpeople;
	url=encodeURI(url);
	url=encodeURI(url);
	window.location=url;
}
//全选
function selectAll(){
	var aa=document.getElementsByName("chek");
	if(aa.length){
		for(var i=0;i<aa.length;i++){
			aa[i].checked=true;
		}
	}

}
//反选
function reverse(){
	var aa=document.getElementsByName("chek");
	if(aa.length){
		for(var i=0;i<aa.length;i++){
			if(aa[i].checked==false){
				aa[i].checked=true;
			}else{
				aa[i].checked=false;
			}
		}
	}

}

//多选择删除contribution_manage.jsp
function selectConManageDel(url,page,constatusarg){
				var aa=document.getElementsByName("chek");
				var loc=url+"?page="+page+"&constatusarg="+constatusarg+"&conids=0";
				if(aa.length){
					for(var i=0;i<aa.length;i++){
						if(aa[i].checked==true){
							var conid=aa[i].value;
							loc=loc+","+conid;
						}
					}
				}
				window.location=loc;
}
//多选择删除contribution_queryResult.jsp
function selectConQueryDel(url,page,con,convalue,contype){
				var aa=document.getElementsByName("chek");
				var loc=url+"?page="+page+"&contype="+contype+"&con="+con+"&convalue="+convalue+"&conids=0";
				if(aa.length){
					for(var i=0;i<aa.length;i++){
						if(aa[i].checked==true){
							var conid=aa[i].value;
							loc=loc+","+conid;
						}
					}
				}
				url=encodeURI(url);
				url=encodeURI(url);
				window.location=loc;
}
//多选择删除minyi_manage.jsp
function selectMinyiManageDel(url,page,constatusarg){
				var aa=document.getElementsByName("chek");
				var loc=url+"?page="+page+"&constatusarg="+constatusarg+"&conids=0";
				if(aa.length){
					for(var i=0;i<aa.length;i++){
						if(aa[i].checked==true){
							var conid=aa[i].value;
							loc=loc+","+conid;
						}
					}
				}
				window.location=loc;
}
//多选择删除proposal_manage.jsp
function selectPrDel(url,page){
				var aa=document.getElementsByName("chek");
				var loc=url+"?page="+page+"&prids=0";
				if(aa.length){
					for(var i=0;i<aa.length;i++){
						if(aa[i].checked==true){
							var prid=aa[i].value;
							loc=loc+","+prid;
						}
					}
				}
				window.location=loc;
}
//多选择删除proposal_manageResult.jsp
function selectPrQueryDel(url,page,con,convalue){
				var aa=document.getElementsByName("chek");
				var loc=url+"?page="+page+"&con="+con+"&convalue="+convalue+"&prids=0";
				if(aa.length){
					for(var i=0;i<aa.length;i++){
						if(aa[i].checked==true){
							var prid=aa[i].value;
							loc=loc+","+prid;
						}
					}
				}
				window.location=loc;
}
//多选择删除proposal_manageByStatus.jsp
function selectPrStatusDel(url,page,prstatus){
				var aa=document.getElementsByName("chek");
				var loc=url+"?page="+page+"&prstatus="+prstatus+"&prids=0";
				if(aa.length){
					for(var i=0;i<aa.length;i++){
						if(aa[i].checked==true){
							var prid=aa[i].value;
							loc=loc+","+prid;
						}
					}
				}
				window.location=loc;
}
//禁止使用退格键backspace
function keyDown(){
            // 禁止使用backspace键
            if(window.event.keyCode == 8){
                alert("该文本框为只读");
                event.returnValue=false;
            }
            // 后面还可以禁止其它键，照着上面的方法写就行了
            // 比如：if(event.shiftKey&&event.keyCode == 121) // 屏蔽shift+F10
}
