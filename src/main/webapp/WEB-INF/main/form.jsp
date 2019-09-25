<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/default.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.11.4.css" />
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jnwtv/jnwtv.qiniu.js"></script>
<script type="text/javascript" src="js/jquery-ui/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/jquery-ui/jquery-ui-1.11.4.js"></script>
<script type="text/javascript" src="http://www.codefans.net/ajaxjs/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="http://gosspublic.alicdn.com/aliyun-oss-sdk-4.4.4.min.js"></script>
</head>

<script type="text/javascript">
	
	function toUploadPicture(){
		window.location.href='getpicuploadpage' ; 
	}
	
</script>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <form action="editUserInfo" method="post" enctype="multipart/form-data">
	    <ul class="forminfo">
	   <!--  <li><label>上传图片</label><button type="button" onclick="toUploadPicture()">去上传</button></li> -->
	    <li><label>上传头像</label><input type="file" name="file" id="file" /><br><img src="" id="img" width="10%" heigth="10%"></li>
	    <li>
	    		 <label>性别</label><cite>
	    		 <input name="sex" type="radio" value="1" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;
	   		 <input name="sex" type="radio" value="0" />女</cite>
	   	</li>
	    <li><label>昵称</label><input name="userNick" type="text" class="dfinput" /><i>不能超过8个字符</i></li>
	    <li><label>简介</label><input name="desc" type="text" class="dfinput" /><i>一句话彰显自己的个性吧</i></li>
	    <li><label>状态</label><textarea name="status" cols="" rows="" class="textinput"></textarea></li>
	    <li><label>&nbsp;</label><input  type="submit" class="btn" value="保存"/></li>
	    </ul>
	</form> 
    
    </div>

<script  type="text/javascript">  
	$("#file").change(function(){
	  // getObjectURL是自定义的函数，见下面
	  // this.files[0]代表的是选择的文件资源的第一个，因为上面写了 multiple="multiple" 就表示上传文件可能不止一个
	  // ，但是这里只读取第一个 
	  var objUrl = getObjectURL(this.files[0]) ;
	  // 这句代码没什么作用，删掉也可以
	  // console.log("objUrl = "+objUrl) ;
	  if (objUrl) {
	    // 在这里修改图片的地址属性
	    $("#img").attr("src", objUrl) ;
	  }
	}) ;
	//建立一個可存取到該file的url
	function getObjectURL(file) {
	  var url = null ; 
	  // 下面函数执行的效果是一样的，只是需要针对不同的浏览器执行不同的 js 函数而已
	  if (window.createObjectURL!=undefined) { // basic
	    url = window.createObjectURL(file) ;
	  } else if (window.URL!=undefined) { // mozilla(firefox)
	    url = window.URL.createObjectURL(file) ;
	  } else if (window.webkitURL!=undefined) { // webkit or chrome
	    url = window.webkitURL.createObjectURL(file) ;
	  }
	  return url ;
	}
</script>
</body>

</html>
