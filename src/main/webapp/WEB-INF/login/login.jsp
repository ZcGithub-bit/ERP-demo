<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>欢迎登录后台管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/toastr.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/toastr.min.js"></script>

<script type="text/javascript">
	$(function(){
	    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		$(window).resize(function(){  
	    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	    })  
	});  
	
	function logincheck(){
		var account = $("#account").val();
		var pwd = $("#pwd").val();
		$.post("logincheck" , {	account:account , pwd:pwd} , function(data){
			if(data.code == '0'){
				window.location.href='tomainpage' ; 
			}else{
				alert(data.codeMsg);
			}
		})
	}
</script> 

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    <span class="systemlogo"></span> 
    <div class="loginbox">
    
    <ul>
	    <li><input name="account" id="account" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/></li>
	    <li><input name="pwd" id="pwd" type="text" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/></li>
	    <li><input name="" type="button" class="loginbtn" value="登录"  onclick="logincheck()"  /><label>
	    <input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
    </ul>
    </div>
    </div>
</body>

<script type="text/javascript">
	$(function(){
		toastr.options= {
		"closeButton":false,//显示关闭按钮
		"debug":false,//启用debug
		"positionClass":"toast-top-center",//弹出的位置
		"showDuration":"300",//显示的时间
		"hideDuration":"1000",//消失的时间
		"timeOut":"5000",//停留的时间
		"extendedTimeOut":"1000",//控制时间
		"showEasing":"swing",//显示时的动画缓冲方式
		"hideEasing":"linear",//消失时的动画缓冲方式
		"showMethod":"fadeIn",//显示时的动画方式
		"hideMethod":"fadeOut"//消失时的动画方式
		};
		$("#success").click(function(){
			toastr.success("成功样式");
		})
		$("#info").click(function(){
			toastr.info("提示样式");
		})
		$("#warning").click(function(){
			toastr.warning("警告样式");
		})
		$("#error").click(function(){
			toastr.error("错误样式");
		})
		$("#clear").click(function(){
			toastr.clear();//清楚当前页面弹出框
		})
	});
</script>

</html>
