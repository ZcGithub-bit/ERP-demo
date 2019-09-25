	
$(document).ready(
				function () {
					showLeftTime();
				}
			);
function showLeftTime() {
			var now=new Date();
			var month=now.getMonth();
			var day=now.getDate();
			var hours=now.getHours();
			var minutes=now.getMinutes();
			var seconds=now.getSeconds();
			$("#show").html();
			document.all.show.innerHTML=a(month+1)+"月"+a(day)+"日 "+a(hours)+":"+a(minutes)+":"+a(seconds)+"";
			setTimeout(showLeftTime,1000);
	}
function a (val) {
	if(val<10){
		return "0"+val;
	}else{
		return val;
	}
}