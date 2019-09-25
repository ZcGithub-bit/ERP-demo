<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script	type="text/javascript">
	function changeName(){
		var name = $("#txName").val();
		alert(name);
		$.post("changename",	{name : name } ,  function(data){
			alert(data.codeMsg);
		})
	}
</script>
</head>

<body>
	
	<div>
		<input type="text" name="txName" id="txName" />
		<button type="button" onclick=changeName()>修改昵称</button>
	</div>
	
</body>
</html>