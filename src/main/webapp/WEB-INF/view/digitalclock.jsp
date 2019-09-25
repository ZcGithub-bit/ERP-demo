<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HomePage</title>
<script>
	function displayTime(){
		var elt = document.getElementById("clock");
		var now = new Date();
		elt.innerHTML=now.toLocaleTimeString();
		setTimeout(displayTime,1000);
		window.onload=displayTime;
	}
 </script>	
<style>
	#clock{
		font:bold 24pt sans ;
		background:#ddf ;
		padding:10px ;
		border:solid black 2px ;
		border-radius:10px;
	}
</style>
</head>
<body>
		<a href="javascript: void window.open();">打开一个新窗口 </a>
		<h1>Digital Clock</h1>
		<span id="clock" onclick=displayTime()>查看时间SJ</span>
</body>

</html>