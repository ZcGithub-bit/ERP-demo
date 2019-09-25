<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function shake(e , oncomplete , distance ,time){
		if (typeof e==="string") e= document. getElementByI(e)；
		if(!time) time=500 ;
		if(!distance) distance=5;
		var originalStyle= e.style.cssText；
		e.style.position="relative"；
		var start=(new Date()).getTime();
		animate();
		
		function animate(){
			var now=(new Date()).getTime();
			var elapsed = now -start ;
			var fraction =elapsed/time ;
			if(fraction<1){
				var x= distance*Math.sin (fraction*4*Math.PI)； 
				e. style. left= x+" px"；
			}
			
		}
	}
</script>

</head>
<body>

</body>
</html>