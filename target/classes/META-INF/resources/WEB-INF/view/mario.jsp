<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>面向对象综合案例--超级马里奥游戏</title>
	<link rel="stylesheet" href="css/game.css" type="text/css">
</head>
<body>
	<script>
		function Mario(){
			//基本属性
			
			//移动 0-上 1-右 2-下 3-左
			this.move=function(direction){     //注意应该是点击之后进行了加减再获取其top，left坐标。而不是加减之前获取坐标，否则就是上一次的坐标
				var mymario=document.getElementById("marioimg");
				
				//var left=mymario.style.left;  //怎么获取为空   1.直接通过obj.style.left和obj.style.top，但是有局限性，这种获取的方法只能获取到行内样式的left和top的属性值，不能获取到style标签和link 外部引用的left和top属性值。
				//2使用obj.offsetLeft来获取对象的left属性值,用obj.offsetTop来获取对象的top属性值。  但这两个属性是只读的，不能赋值
				
				var left=mymario.style.left;   //取到的是带px的字符串
				left=parseInt(left.substring(0,left.length-2));  //转为int数字
				var top=mymario.style.top;
				top=parseInt(top.substring(0,top.length-2));
				var gamefield=document.getElementById("gamefield");  //获取游戏的div区域，用于边缘的碰撞检测
				var fieldWidth=gamefield.offsetWidth;
				var fieldHeight=gamefield.offsetHeight;
				//console.log("游戏区域的宽-高"+fieldWidth+"  "+fieldHeight);  //获取游戏区域的宽高
				
				//console.log("mario值"+mymario.offsetTop+" "+mymario.offsetHeight);
				//console.log("mario的之前top-left值"+top+" "+left);
				edgeCollision(left,top,fieldWidth,fieldHeight);
				var caomei=document.getElementById("caomei");
				var caomeileft=caomei.style.left;   //取到的是带px的字符串
				caomeileft=parseInt(caomeileft.substring(0,caomeileft.length-2));  //转为int数字
				var caomeitop=caomei.style.top;
				caomeitop=parseInt(caomeitop.substring(0,caomeitop.length-2));
				//console.log("草莓值"+caomei.offsetLeft+" "+caomei.offsetHeight);
				//console.log("草莓的位置"+caomeileft+" "+caomeitop);
				var spanArray=document.getElementById("score").getElementsByTagName("span");   //ByTagName获取的是一组元素
				//console.log("myscore"+" "+spanArray[0].innerHTML);
				var score=parseInt(spanArray[0].innerHTML);  //元素必须转化为int型的分数
				//console.log("myscore"+" "+score);
				
				switch(direction){
					case 0:
						if(edgeCollision(left,top-20,fieldWidth,fieldHeight)){
							mymario.style.top=top+"px";
						   	//console.log("向上移动");
						}else
							mymario.style.top=(top-20)+"px";
						if(objectCollision(mymario,caomei)){
							console.log("得分");
							score+=100;
							spanArray[0].innerHTML=score;
							//随机初始化草莓的位置
							caomei.style.left=(Math.floor(Math.random()*42+1))*20+"px";
							caomei.style.top=(Math.floor(Math.random()*17+1))*20+"px";
						}			
										
						break;
					case 1:
						if(edgeCollision(left+20,top,fieldWidth,fieldHeight)){
							mymario.style.left=left+"px";
							//console.log("向右移动");
						}else
							mymario.style.left=(left+20)+"px";
						if(objectCollision(mymario,caomei)){
							console.log("得分");
							score+=100;
							spanArray[0].innerHTML=score;
							//随机初始化草莓的位置
							caomei.style.left=(Math.floor(Math.random()*42+1))*20+"px";
							caomei.style.top=(Math.floor(Math.random()*17+1))*20+"px";
						}					
						
						break;
					case 2:
						if(edgeCollision(left,top+20,fieldWidth,fieldHeight)){
							mymario.style.top=top+"px";
							//console.log("向下移动");
						}else
							mymario.style.top=(top+20)+"px";
						if(objectCollision(mymario,caomei)){
							console.log("得分");
							score+=100;
							spanArray[0].innerHTML=score;
							//随机初始化草莓的位置
							caomei.style.left=(Math.floor(Math.random()*42+1))*20+"px";
							caomei.style.top=(Math.floor(Math.random()*17+1))*20+"px";
						}
																
						break;
					case 3:	
						if(edgeCollision(left-20,top,fieldWidth,fieldHeight)){
							mymario.style.left=left+"px";
							//console.log("向左移动");
						}else 
							mymario.style.left=(left-20)+"px";
						if(objectCollision(mymario,caomei)){
							console.log("得分");
							score+=100;
							spanArray[0].innerHTML=score;
							//随机初始化草莓的位置
							caomei.style.left=(Math.floor(Math.random()*42+1))*20+"px";
							caomei.style.top=(Math.floor(Math.random()*17+1))*20+"px";
						}
						break;						
				}
			}
				
		}
		//创建Mario
		var mario=new Mario();
		
		
		//全局函数
		function marioMove(direction){
			
			switch(direction){
				case 0:
					mario.move(0);
					
					break;
				case 1:
					mario.move(1);
					
					break;
				case 2:
					mario.move(2);
					
					break;
				case 3:
					mario.move(3);
					
					break;
			}
		}
		function objectCollision(obj1,obj2){  //检测和图片发生的碰撞
			var t1=obj1.offsetTop;
			var l1=obj1.offsetLeft;
			var b1=obj1.offsetHeight+obj1.offsetTop;
			var r1=obj1.offsetWidth+obj1.offsetLeft;
			var t2=obj2.offsetTop;
			var l2=obj2.offsetLeft;
			var b2=obj2.offsetHeight+obj2.offsetTop;
			var r2=obj2.offsetWidth+obj2.offsetLeft;
			if(t1>b2||r1<l2||b1<t2||l1>r2){//1在2的下边|1在2的左边|1在2的上边|1在2的右边
				return false;
			}else{
				console.log("碰到了物体");
				return true;//发生了碰撞
			
			}
			    
		}
		function edgeCollision(objectLeft,objectTop,fieldWidth,fieldHeight){   //检测物体和游戏区域边缘的碰撞检测
			//console.log("边缘检测");
			if(objectTop<0){
				//console.log("碰到了上边缘");
				return true;
				
			}else
			if(objectTop>(fieldHeight-60)){
				//console.log("碰到了下边缘");
				return true;
			}else
			if(objectLeft<0){
				//console.log("碰到了左边缘");
				return true;
			}else
			if(objectLeft>(fieldWidth-60)){
				//console.log("碰到了右边缘");
				return true;
			}
			else return false;
			
		}
	
	</script>
	

	
	

	<div id="content">
		<h3 id="title">超级马里奥（easy版）</h3>

		<div id="controlcenter">
		<table border=1 cellspacing="15" cellpadding="2" align="center">
			<tr>
				<td colspan="3" align="center">控制中心</td>
			</tr>
			<tr>
				<td>***</td>
				<td><input type="button" value="↑ ↑" onclick="marioMove(0)" ></td>
				<td>***</td>
			</tr>
			<tr>
				<td><input type="button" value="← ←" onclick="marioMove(3)"></td>
				<td>***</td>
				<td><input type="button" value="→ →" onclick="marioMove(1)"></td>
			</tr>
			<tr>
				<td>***</td>
				<td><input type="button" value="↓ ↓" onclick="marioMove(2)"></td>
				<td>***</td>
			</tr>
		</table>
			
		</div>
		<div id="score">
			<h3>得分统计:</h3>
			<span>0</span>分
		</div>
    </div>
	
	
	<div class="gamediv" id="gamefield">

		   <img id="marioimg" src="image/mario.jpg" style="width:60px;height:60px;  position:absolute; left:0px;top:0px;">
		   <img id="caomei" src="image/caomei.jpg" style="width:60px;height:60px;  position:absolute; left:200px;top:80px;">
				
	</div>
	
</body>
</html>