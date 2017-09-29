<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>词库后台管理</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
	<!--引用showLoading的css文件-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/showLoading.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/lexicon/lexicon.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/header.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/showMsg.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/slider.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/modal-close.css"/>
</head>
<body id="loading">
		<!--网页头部-->
		<div id="topBar">
            <div class='topLogo'>
                <img  src="${pageContext.request.contextPath}/images/login/logo.png" height="22" width="128"/> 
                <span>词库后台管理</span>
            </div>
            <div id="logoutWrap">
                <span class="username" >你好，${userName }</span> 
                <span class="userexit" onclick="logout()">退出</span>
            </div>
        </div>
        
        <!--网页侧边栏-->
        <div id="leftMenu">   
        	<ul class="menuList">
            	<li class="father-menu">      
                  	<p class="clickButton">
                  		<img src="${pageContext.request.contextPath}/images/common/ico_peizhiguanli.png" />
                     	词库
						<span class="glyphicon glyphicon-menu-down downButton downStatus"> </span>
                    	<span class="glyphicon glyphicon-menu-up downButton hide upStatus" aria-hidden="true"></span>
                  	</p>
                  	<ul class="son-menu" style="display:none;"> 
						<li>
							<a class='active' href="${pageContext.request.contextPath}/word/toLexico">词库管理</a>
						</li>
				  	</ul>
                </li>
    <%--             
            	<li class="father-menu">      
                  	<p class="clickButton">
                  		<img src="${pageContext.request.contextPath}/images/common/ico_shujuyunying.png"/>
                     	用户
						<span class="glyphicon glyphicon-menu-down downButton downStatus"> </span>
                    	<span class="glyphicon glyphicon-menu-up downButton hide upStatus" aria-hidden="true"></span>
                  	</p>
                  	<ul class="son-menu" style="display:none;"> 
						<li>
							<a href="../user/user.html">用户管理</a>
						</li>
				  	</ul>
                </li> --%>
                <li class="father-menu">      
                  	<p class="clickButton">
                  		<img src="${pageContext.request.contextPath}/images/common/ico_diaoduguanli.png"/>
                     	管理员
						<span class="glyphicon glyphicon-menu-down downButton downStatus"> </span>
                    	<span class="glyphicon glyphicon-menu-up downButton hide upStatus" aria-hidden="true"></span>
                  	</p>
                  	<ul class="son-menu" style="display:none;"> 
						<li>
							<a href="${pageContext.request.contextPath}/admin/toAdministrator">管理员管理</a>
						</li>
				  	</ul>
                </li>
            </ul>               
        </div>
        
        <!--网页主体内容-->
        <div id="rightContent">
        	<!--主体内容头部域名管理表单域-->
        	<div id="rightTop">
        		<h3>词库</h3>
        		<ul class="clearfix">
        			<li>
        				<input type="text" class="form-control forminput1" placeholder="请输入搜索内容"/>
        			</li>
        			<li>
        				<input type="button" class="formbtn2 btnClick" value="搜索" name="groupData" onclick="searchBtn(this)"/>
        			</li>
        		</ul>
        	</div>
        	
        	<!--主体内容域名管理列表-->
        	<div id="rightBottom">
        		<div class="oper-button">
        			<input type="button" value="添加" class="addFirm" data-target="#addModal" data-toggle="modal"/>
					<input type="button" value="删除" class="addFirm" data-target="#addFirmModal" data-toggle="modal"/>
        		</div>
        		<p class="listName">厂商列表</p>
        		<div class="table-responsive">
	        		<table class="table table-bordered table-hover">
						<thead>
						    <tr>
								<th width="5%" style="text-align: center;"><input type="checkbox" id="all-check" class="allChecked"/></th>
								<th width="5%" style="text-align: center;">ID</th>
								<th width="20%">词组</th>
								<th width="10%">类别</th>
								<th width="20%">前景色</th>
								<th width="20%">背景色</th>
								<th width="20%" style="text-align: center;width:20%">操作</th>
						    </tr>
						</thead>
						<tbody>
						    <tr>
							    <c:forEach items="${wordList.dataMap }" var="wordList">
							    	
							    </c:forEach>
								<td class="check"><input type="checkbox" class="check-menu"/></td>
							    <td class="num">01</td>
							    <td>www.baidu.com</td>
							    <td>2017-06-16</td>
							    <td>2017-07-17</td>
							    <td>2017-07-17</td>
								<td class="option">
							      	<span class="update" data-target="#updateFirmModal" data-toggle="modal">查看</span>
							      	<span class="delete" data-target="#deleModal" data-toggle="modal">修改</span>
							      	<span class="bindCdn" data-target="#seeFirmModal" data-toggle="modal">删除</span>
							    </td>
						    </tr>
						</tbody>
					</table>
				</div>
				<!--分页效果的实现-->
				<div class="page-style">
					<nav aria-label="Page navigation">
					  <ul class="pagination">
					    <li>
					      <a href="#" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					    <li class="active"><a href="#">1</a></li>
					    <li><a href="#">2</a></li>
					    <li><a href="#">3</a></li>
					    <li><a href="#">4</a></li>
					    <li><a href="#">5</a></li>
					    <li>
					      <a href="#" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					  </ul>
					</nav>
				</div>
				<!--分页效果的实现-->
				
        	</div>
        	
        </div>
        
		<!--删除模态框-->
		<div class="modal fade" id="deleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		            	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">确定要删除吗？</h4>
		            </div>
		            <div class="modal-body">删除后这个域名将消失，无法查看</div>
		            <div class="modal-footer">
		            	<input type="button" value="确定" class="btnClick okeBtn"/>
		                <input type="button" value="取消"  data-dismiss="modal" class="btnClick closeBtn"/>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
		
		<!--添加厂商模态框-->
		<div class="modal fade" id="addFirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		            	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">添加厂商</h4>
		            </div>
		            <div class="modal-body">
		            	<div class="row">
		            		<input type="text" class="form-control forminput2" placeholder="请输入需要添加的厂商名称"/>
		            	</div>
		            	<div class="row">
		            		<input type="button" value="确定" class="btnClick addOkBtn"/>
		            		<input type="button" value="取消"  data-dismiss="modal" class="btnClick addCloseBtn"/>
		            	</div>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
		<!--添加厂商模态框结束-->
		 <!-- 模态框（Modal）新增用户 -->
		<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="addModalLabel">新增词库</h4>
		            </div>
		            <div class="modal-body">
		            	<form class="form-inline">
		            	   <div class="user-info">
			            		<div class="form-group">
			            			<label>ID</label>
			            			<input type="text" class="form-control" name="id"/>
			            		</div>
		            	   </div>
		            	   <div class="user-info">
			            		<div class="form-group">
			            			<label>词组</label>
			            			<input type="text" class="form-control" name="groupData" />
			            		</div>
		            	   </div>
		            	   <div class="user-info">
			            		<div class="form-group">
			            			<label>前景色</label>
				            			<select id="fColor" name="frontColor"></select>
			            		</div>
			            		<div class="form-group form-right">
			            			<label>背景色</label>
			            			<select id="bColor" name="backColor"></select>
			            			<!-- <input type="text" class="form-control" /> -->
			            		</div>
		            	  </div>
		            	 <div class="user-info">
		            	 	<p>类别（可多选）</p>
		            	 	<div class="rolecheck">
		            		<span class="option-style"> 
								<input type="checkbox" value="option1"/> 
								<span title>某某某某某某某某某某某某某某某某某某某某某某某某某</span>
		            		</span>
		            		<span class="option-style"> 
								<input type="checkbox" value="option1"/> 
								<span title>某某某某某某某某某某某某某某某某某某某某某某某某某</span>
		            		</span>
		            		<span class="option-style"> 
								<input type="checkbox" value="option1"/> 
								<span title>某某某某某某某某某某某某某某某某某某某某某某某某某</span>
		            		</span>
		            		<span class="option-style"> 
								<input type="checkbox" value="option1"/> 
								<span title>某某某某某某某某某某某某某某某某某某某某某某某某某</span>
		            		</span>
		            		<span class="option-style"> 
								<input type="checkbox" value="option1"/> 
								<span>某某某某某</span>
		            		</span>
		            		<span class="option-style"> 
								<input type="checkbox" value="option1"/> 
								<span>某某某某某</span>
		            		</span>
		            		<span class="option-style"> 
								<input type="checkbox" value="option1"/> 
								<span>某某某某某</span>
		            		</span>
		            		<span class="option-style"> 
								<input type="checkbox" value="option1"/> 
								<span>某某某某某</span>
		            		</span>
		            		<span class="option-style"> 
								<input type="checkbox" value="option1"/> 
								<span>某某某某某</span>
		            		</span>
		            		<span class="option-style"> 
								<input type="checkbox" value="option1"/> 
								<span>某某某某某</span>
		            		</span>
		            		<span class="option-style"> 
								<input type="checkbox" value="option1"/> 
								<span>某某某某某</span>
		            		</span>
		            		<span class="option-style"> 
								<input type="checkbox" value="option1"/> 
								<span>某某某某某</span>
		            		</span>
		            		<span class="option-style"> 
								<input type="checkbox" value="option1"/> 
								<span>某某某某某</span>
		            		</span>
		            		<span class="option-style"> 
								<input type="checkbox" value="option1"/> 
								<span>某某某某某</span>
		            		</span>
		            		<span class="option-style"> 
								<input type="checkbox" value="option1"/> 
								<span>某某某某某</span>
		            		</span>
		            		<span class="option-style"> 
								<input type="checkbox" value="option1"/> 
								<span>某某某某某</span>
		            		</span>
		            		<span class="option-style"> 
								<input type="checkbox" value="option1"/> 
								<span>某某某某某</span>
		            		</span>
		            		<span class="option-style"> 
								<input type="checkbox" value="option1"/> 
								<span>某某某某某</span>
		            		</span>
		            	</div>

		            	 </div>
		            	</form>
		            </div>
		            <div class="modal-footer">
		                <input type="button" name="" id="addSuccess" class="formbtn3 btnClick" value="添加" />
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
		<!--模态框结束-->
		
		<!--修改厂商模态框-->
		<div class="modal fade" id="updateFirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		            	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">修改厂商名称</h4>
		            </div>
		            <div class="modal-body">
		            	<div class="row">
		            		<label>修改前厂商名 : </label>
		            		<span class="beforeUpdateName">腾讯</span>
		            	</div>
		            	<div class="row">
		            		<label>修改后厂商名 : </label>
		            		<input type="text" class="form-control afterUpdateName" placeholder="请输入需要添加的厂商名称" value="阿里"/>
		            	</div>
		            	<div class="row updateBtn">
		            		<input type="button" value="确定" class="btnClick updateOkBtn"/>
		            		<input type="button" value="取消"  data-dismiss="modal" class="btnClick updateCloseBtn"/>
		            	</div>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
		<!--修改厂商模态框结束-->
		
		<!--厂商管理绑定域名模态框-->
		<div class="modal fade" id="seeFirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		            	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">绑定域名</h4>
		            </div>
		            <div class="modal-body">
		            	<div class="row">
		            		<label>域名： </label>
		            		<input type="text" class="form-control cnameInput"/>
		            		<input type="button" value="搜索" class="btnClick seeSearchBtn"/>
		            		<input type="button" value="解除绑定" class="btnClick closeBindBtn"/>
		            		<input type="button" value="绑定" class="btnClick seeBindBtn"/>
		            	</div>
		            	<div class="row">
		            		<div class="table-responsive">
			            		<table class="table table-bordered table-hover">
									<thead>
									    <tr>
									      	<th width="10%" style="text-align: center;">序号</th>
									      	<th width="30%">域名</th>
									      	<th width="25%">CNAME</th>
									      	<th width="25%">绑定状态</th>
									      	<th width="50px" style="text-align: center;">
										      	<input type="checkbox" id="all-button-modal" class="allChecked"/>
										    </th>
									    </tr>
									</thead>
									<tbody>
									    <tr>
										    <td class="num">01</td>
										    <td>baidu.com</td>
										    <td>CNAME</td>
										    <td>已绑定</td>
										    <td class="check"><input type="checkbox" class="check-menu-modal"/></td>
									    </tr>
									    <tr>
									       	<td class="num">02</td>
									       	<td>www.baidu.com</td>
										    <td>CNAME</td>
										    <td>已绑定</td>
										    <td class="check"><input type="checkbox" class="check-menu-modal"/></td>
									    </tr>
									    <tr>
									      	<td class="num">02</td>
									       	<td>baidu.com</td>
										    <td><input type="text" class="noBindInput"/></td>
										    <td class="noBind">未绑定</td>
										    <td class="check"><input type="checkbox" class="check-menu-modal"/></td>
									    </tr>
									</tbody>
								</table>
							</div>
		            	</div>
		            	<div class="row seeBtn">
		            		<input type="button" value="确定" class="btnClick seeOkBtn"/>
		            		<input type="button" value="取消"  data-dismiss="modal" class="btnClick seeCloseBtn"/>
		            	</div>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
		<!--查看厂商模态框结束-->
		
		<!--绑定域名模态框-->
		<div class="modal fade" id="bindCdnModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		            	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">绑定域名</h4>
		            </div>
		            <div class="modal-body">
		            	<div class="row">
		            		<label>域名 : </label>
		            		<input type="text" class="form-control afterUpdateName" placeholder="" value="www.baidu.com"/>
		            	</div>
		            	<div class="row">
		            		<label>CNAME : </label>
		            		<input type="text" class="form-control afterUpdateName" placeholder="" value="CNAME"/>
		            	</div>
		            	<div class="row bindBtn">
		            		<input type="button" value="确定" class="btnClick bindOkBtn"/>
		            		<input type="button" value="取消"  data-dismiss="modal" class="btnClick bindCloseBtn"/>
		            	</div>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
		<!--绑定域名模态框结束-->
		
		<!--成功提示-->
		<div class="successTool">
			<div>
				<img src="${pageContext.request.contextPath}/images/ico_allow.png"/>
				<span class="successContent"></span>
			</div>
		</div>
		
		<!--失败提示-->
		<div class="faileTool">
			<div>
				<img src="${pageContext.request.contextPath}/images/ico_error.png"/>
				<span class="faileContent"></span>
			</div>
			<p></p>
		</div>
	</body>
	
	<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/js/common/showMsg.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/js/common/sideBar.js" type="text/javascript" charset="utf-8"></script>
	<!--引用showLoading的js文件-->
	<script src="${pageContext.request.contextPath}/js/jquery.showLoading.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
	/*loading遮罩层的编写*/
	  /*ajax请求的时候调用显示加载按钮*/

	  //jQuery('#loading').showLoading();
	  
	  /*请求成功调用隐藏加载按钮*/
      //jQuery('#loading').hideLoading();
      
		$(function () { 
			//域名管理设置全选
			//全选按钮
			$("#all-button-modal").on("click",function(){ 
				if($(this).is(':checked')){ 
					$(".check-menu-modal").prop('checked',true);
				}else{ 
					$(".check-menu-modal").prop('checked',false);
				}
			});
			
			var index = 0;
			//当所有的checkout都被选择，全选按钮也选中，否则取消
			$(".check-menu-modal").on('click',function(){
				if($(this).is(':checked')){
					index ++;
				} else {
					index --;
				}
				if(index == $('.check-menu-modal').length){
					$("#all-button-modal").prop('checked',true);
				}else{
					$("#all-button-modal").prop('checked',false);
				}
		    });

		     $("#all-check").on("click",function(){ 
				if($('#all-check').is(':checked')){ 
					$(".check-menu").prop('checked',true);
				}else{ 
					$(".check-menu").prop('checked',false);
				}
			});	
			
			/*新增厂商模态框居中*/
		    centerFun($("#addFirmModal"));
		    /*修改厂商模态框居中*/
		    centerFun($("#updateFirmModal"));
		    /*删除模态框居中*/
		    centerFun($("#deleModal"));
		    /*查看模态框居中*/
		    centerFun($("#seeFirmModal"));
		    /*绑定域名模态框居中*/
		    centerFun($("#bindCdnModal"));
			
		});
		
		/*处理模态框上下居中函数*/
	    function centerFun(ele){ 
	        $(ele).on("shown.bs.modal",function(e){ 
	          	// 关键代码，如没将modal设置为 block，则$modala_dialog.height() 为零  
	            $(this).css('display', 'block');  
              	var modalHeight=$(window).height() / 2 - $(ele).find('.modal-dialog').height() / 2;  
              	$(this).find('.modal-dialog').css({  
                	'margin-top': modalHeight  
            	}); 
	        })
	    }
	</script>
</html>