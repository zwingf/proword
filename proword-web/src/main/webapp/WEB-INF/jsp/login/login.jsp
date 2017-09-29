<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>系统登录页面</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login/login.css" />
</head>
<body>
	<div class="main"> 
	  <!--头部内容展示-->
		<div class="main-header">
		    <a class="left-content">
		    </a>
		</div>
	  <!--头部结束-->
	  <!--主体部分-->
	   <div class="container-style">
	      <div class="main-right">
	      	<h4>词库后台登录系统</h4>
			<div class="form-detail">
				<form action="${pageContext.request.contextPath}/admin/login" method="post" onsubmit="return checkInfo();">
					<div id="form-widgt">
					   <div class="form-group" style="margin-top:30px">
							<label class="account">Account</label>
							<input type="text" name="userName" id="userName" class="form-control" placeholder=""/>
						</div>
						<div class="form-group">
							<label>Password</label>
							<input type="password" id="password" name="password" class="form-control"/>
						</div>
						<p class="login-button">
							<input type="submit" value="login"/>
						</p>
					</div>
				</form>
			</div>
	      </div>
	   	
	   </div>
	  <!--主体部分结束-->
		<div class="copy-right">
			<p class="copy-right-top">&copy;2017Meizu Telecom Equipment Co,.Ltd. All rights reserved.</p>
			<p class="copy-right-bottom">粤ICP备13003602号-2 粤B2-20130198 营业执照 法律声明 粤公网安备 44049102496009号</p>
		</div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/common/showMsg.js" type="text/javascript" charset="utf-8"></script>


<script type="text/javascript">

	function checkInfo(){
	    
		var userName = $("#userName").val();
		var password = $("#password").val();
		
		if(userName == null || userName == ""){
			alert("账号不能为空!");
			return false;
		}else{
			var len = userName.length;
 			if(len < 4 || len > 8){
                alert("用户名应在4--8位");
                return false;
			}
		}
		
		if(password == null || password == ""){			
			alert("密码不能为空!");
			return false;
		}  else{
            var len = password.length;
            if(len < 6 || len > 18){
                alert("密码应在6--18位!");
                return false;
			}
		}
	}
</script>
</html>