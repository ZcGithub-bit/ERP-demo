<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
    <title>2048小游戏</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no"></meta>
    <script src="https://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet"></link>
    <script type="text/javascript"  src="js/main.js"></script>
    	<link rel="stylesheet" href="css/main.css" type="text/css"></link>
</head>
<body>
	<canvas id="can" width="400" height="400" style="background: Black"></canvas>
	<script>
		var sn = [ 42, 41 ], dz = 43, fx = 1, n, ctx = document.getElementById("can").getContext("2d");
		function draw(t, c) {
			ctx.fillStyle = c;
			ctx.fillRect(t % 20 * 20 + 1, ~~(t / 20) * 20 + 1, 18, 18);
		}
		document.onkeydown = function(e) {
			fx = sn[1] - sn[0] == (n = [ -1, -20, 1, 20 ][(e || event).keyCode - 37] || fx) ? fx : n
		};
		!function() {
			sn.unshift(n = sn[0] + fx);
			if (sn.indexOf(n, 1) > 0 || n<0||n>399 || fx == 1 && n % 20 == 0 || fx == -1 && n % 20 == 19)
				return alert("GAME OVER");
			draw(n, "Lime");
			if (n == dz) {
				while (sn.indexOf(dz = ~~(Math.random() * 400)) >= 0);
				draw(dz, "Yellow");
			} else
				draw(sn.pop(), "Black");
				setTimeout(arguments.callee, 1000);
		}();
	</script>
</body>
</html>