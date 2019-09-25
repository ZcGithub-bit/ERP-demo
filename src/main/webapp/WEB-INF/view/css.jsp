<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>css style</title>
<style type="text/css">
	h1,h2{
		color:blue;
		font-style: italic
	}
	.warning{
		font-weight: blod ; 
		font-size: 150%;
		margin: 0 lin 0 lin ; /* 上下左右 */
		background-color: yellow ;
		border: solid red 8px ;
		padding: 10px 
	}
	#special{
		text-align: center;
		text-transform: uppsercase
	}
</style>
</head>
<body>
	<h1>Cascading Style Sheets Demo</h1>
	<div class="warning">
		<h2> Warning</h2>
		This is a warning! 
		Notice how is grabs your attention with its bold text and bright colors.
		Also notice that the heading is centered and in blue italics .
	</div>
	<p id="special">
		This paragraph is centered<br>
		and appears in uppercase letters.<br>
		<span style="text-transform: none"> Here we explicitly use an online style to override the uppercase letters.</span>
	</p>
</body>
</html>