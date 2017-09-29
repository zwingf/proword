<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>管理员管理</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
	<!--引用showLoading的css文件-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/showLoading.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/datetimepicker/bootstrap-datetimepicker.min.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/administrator/administrator.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/header.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/showMsg.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/slider.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/modal-close.css"/>
<%-- 		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/common.css"/> --%>
	<style type="text/css">
		.page-table {
			text-align: center;
		}
	</style>
</head>


<body id="loading">
		<!--网页头部-->
		<div id="topBar">
            <div class='topLogo'>
                <img  src="${pageContext.request.contextPath}/images/login/logo.png" height="22" width="128"/> 
                <span>CDN融合平台</span>
            </div>
            <div id="logoutWrap">
                <span class="username">你好，${userName}！</span> 
                <span class="userexit" onclick="">退出</span>
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
            	<!-- <li class="father-menu">      
                  	<p class="clickButton">
                  		<img src="../../../images/common/ico_shujuyunying.png"/>
                     	用户
						<span class="glyphicon glyphicon-menu-down downButton downStatus"> </span>
                    	<span class="glyphicon glyphicon-menu-up downButton hide upStatus" aria-hidden="true"></span>
                  	</p>
                  	<ul class="son-menu" style="display:none;"> 
						<li>
							<a href="../user/user.html">用户管理</a>
						</li>
				  	</ul>
                </li> -->
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
        	<form class="form-inline" id="form"  method="post" action="${pageContext.request.contextPath}/admin/toAdministrator" >
        	<input type="hidden" id="start" name="start" />
        	<div id="rightTop">
        		<h3>管理员</h3>
        		<ul class="clearfix">
        			<li>
        				<input type="text" class="form-control forminput1" placeholder="请输入搜索内容"/>
        			</li>
        			<li>
        				<input type="button" class="formbtn2 btnClick" value="搜索" />
        			</li>
        		</ul>
        	</div>
        	</form>
        	<!--主体内容域名管理列表-->
        	<div id="rightBottom">
        		<div class="oper-button">
        			<input type="button" value="新增" class="addFirm" data-target="#addFirmModal" data-toggle="modal"/>
					<input type="button" value="删除" class="addFirm" data-target="#addFirmModal" data-toggle="modal"/>
        		</div>
        		<p class="listName">域名管理列表</p>
        		<div class="table-responsive">
	        		<table class="table table-bordered table-hover">
						<thead>
						    <tr>
								<th width="5%" style="text-align: center;"><input type="checkbox" id="all-check" class="allChecked"/></th>
								<th width="10%" style="text-align: center;">ID</th>
								<th width="35%">用户名</th>
								<th width="20%">密码</th>
								<th style="text-align: center;width:20%">操作</th>
						    </tr>
						</thead>
						<tbody>
						<c:forEach items="${map.adminList }" var="l">
						
						    <tr>
						      	<td class="check"><input type="checkbox" class="check-menu"/></td>
							    <td>${l.id }</td>
							    <td>${l.adminName }</td>
							    <td>${l.adminPassword }</td>
							    <td class="option">
							      	<span class="update" data-target="#updateFirmModal" data-toggle="modal">查看</span>
							      	<span class="delete" data-target="#deleModal" data-toggle="modal">修改</span>
							      	<span class="bindCdn" data-target="#seeFirmModal" data-toggle="modal">删除</span>
							    </td>
						    </tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<!--分页效果的实现-->
				<!-- 分页 -->
						<!-- 分页 -->
			
			<div class="page-table">
				<a onclick="setCurrentPage('1')" class="first-page">首页</a> <a
					onclick="setCurrentPage('${map.page.upper}')" class="page-rl"><i
					class="Hui-iconfont hui-fo">&#xe69b;</i></a>
				<c:forEach begin="${map.page.lpage}" end="${map.page.rpage}" var="pageNum">
					<a onclick="setCurrentPage('${pageNum}')"> <span
						<c:if test="${pageNum==map.page.currentPage}">style="color: #2bc8f3;"</c:if>>${pageNum}</span>
					</a>
				</c:forEach>
				<a onclick="setCurrentPage('${map.page.next}')" class="page-rl"><i
					class="Hui-iconfont hui-fo">&#xe69a;</i></a> <a
					onclick="setCurrentPage('${map.page.totalPage}')" class="first-page">尾页</a>
				&nbsp;&nbsp;&nbsp;
				共&nbsp;&nbsp;${map.page.totalPage}&nbsp;&nbsp;页，&nbsp;&nbsp;&nbsp;共&nbsp;&nbsp;&nbsp;${map.page.totalItemsCount}&nbsp;&nbsp;条记录，&nbsp;&nbsp;&nbsp;到第<input
					type="text" id="goP" maxlength="6" style="width: 30px" />页&nbsp;&nbsp;&nbsp;
				<a onclick="goPage()" class="first-page">确定</a>
			</div>
				
        	</div>
        	
        </div>
        
		<!--删除模态框-->
		<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
		                <h4 class="modal-title" id="myModalLabel">新增管理员</h4>
		            </div>
		            <div class="modal-body">
		            	<div class="row">
		            		<input type="text" id="id" class="form-control forminput2" placeholder="请输入需要添加的ID"/>
		            	</div>
						<div class="row">
		            		<input type="text" id="adminName" class="form-control forminput2" placeholder="请输入需要添加的用户名"/>
		            	</div>
						<div class="row">
		            		<input type="text" id="adminPassWord" class="form-control forminput2" placeholder="请输入需要添加的密码"/>
		            	</div>
						<div class="row">
		            		<input type="text" class="form-control forminput2" placeholder="请输入需要添加的确认密码"/>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/userManage.js"></script>
	<script src="${pageContext.request.contextPath}/js/common/sideBar.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/js/datetimepicker/bootstrap-datetimepicker.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/js/datetimepicker/bootstrap-datetimepicker.zh-CN.js" type="text/javascript" charset="utf-8"></script>
	<!--引用showLoading的js文件-->
	<script src="${pageContext.request.contextPath}/js/jquery.showLoading.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/js/administrator/administrator.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
	/*loading遮罩层的编写*/      
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
		//分页
	    function goPage(){
			var currentPage = $("#goP").val();
			if(!isInteger(currentPage)){
				//不是一个有效数字
				errorMsg("请输入符合规定的数字");
				return ;
			}
			$("#start").val(currentPage);
			$("#form").submit();
		}
		function setCurrentPage(currentPage) {
			$("#start").val(currentPage);
			$("#form").submit();
		}
		function isInteger(number){
			return number > 0 && String(number).split('.')[1] == undefined
		}
	</script>
</html>