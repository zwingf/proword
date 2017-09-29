function left_color(id){
	$('#'+id).addClass('active')
	$('#'+id).parent().parent().css('display','block')
	$('#'+id).parent().parent().parent().find(".downStatus").addClass('hide')
	$('#'+id).parent().parent().parent().find(".upStatus").removeClass('hide')
	$('#'+id).parent().parent().parent().css('background','#0cbbef')
}

//返回成功
function successMsg(show,content,callbackMsg,time){
	if(show){
		$('.successTool').css('display','block');
	}
	
	$('.successTool .successContent').html(content);
	if(callbackMsg){
		$('.successTool p').html(callbackMsg);
	}
	
	if(time){
		setTimeout(function(){
			$('.successTool').css('display','none');
		},time)
	} else {
		setTimeout(function(){
			$('.successTool').css('display','none');
		},3000)
	}
}

//返回失败
function errorMsg(show,content,callbackMsg,time){
	if(show){
		$('.faileTool').css('display','block');
	}
	
	$('.faileTool .faileContent').html(content);
	if(callbackMsg){
		$('.faileTool p').html(callbackMsg);
	}
	
	if(time){
		setTimeout(function(){
			$('.faileTool').css('display','none');
		},time)
	} else {
		setTimeout(function(){
			$('.faileTool').css('display','none');
		},3000)
	}
}