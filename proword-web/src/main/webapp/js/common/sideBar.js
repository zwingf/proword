/*控制导航的显隐*/
$(function(){ 
  
    $('.father-menu').on('click',function(){
      	$(this).css('background','#0cbbef').siblings().css('background','#33485c')
      	$(this).siblings().removeClass("father-active")
      	$(this).siblings().find(".son-menu").css('display','none')
      	$(this).siblings().find(".downStatus").removeClass('hide')
      	$(this).siblings().find(".upStatus").addClass('hide')
      	var sonMenu = $(this).find(".son-menu");
        var downStatus = $(this).find(".downStatus");
        var upStatus = $(this).find(".upStatus");
        
        if($(this).hasClass("father-active")){ 
          	$(this).removeClass("father-active");
          	downStatus.removeClass("hide");
            upStatus.addClass("hide");
          	sonMenu.css({display:'none'});
        }else{ 
           	$(this).addClass("father-active");
            downStatus.addClass("hide");
          	upStatus.removeClass("hide");
            sonMenu.css({display:'block'});
        } 
    })

})
