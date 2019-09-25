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
			function g(url){
				window.location.href=url;
			}
			function open () {
				$("#form1").html("");
				var table = $("<table></table>");
				var tr = $("<tr><td><input type=\"hidden\" name=\"id\"/></td></tr>");
				table.append(tr);
				tr = $("<tr><td align=\"right\">原始密码:</td><td><input type=\"password\" name=\"oldpwd\"/></td></tr>");
				table.append(tr);
				tr = $("<tr><td align=\"right\">新密码:</td><td><input type=\"password\" name=\"pwd\"/></td></tr>");
				table.append(tr);		
				tr = $("<tr><td align=\"right\">重复密码:</td><td><input type=\"password\" name=\"pwd1\"/></td></tr>");
				table.append(tr);
				$("#form1").html(table);
				$("#a_sub").attr("onclick","s();");
				$("#w").window("open");
				
			}
			function s () {
				if($("input[name=oldpwd]").val() == "" ){
					alert("原始密码不能为空.");
					$("input[name=oldpwd]").focus();
					return;
				}
				if($("input[name=pwd]").val() == "" ){
					alert("原始密码不能为空.");
					$("input[name=pwd]").focus();
					return;
				}
				if($("input[name=pwd1]").val() == "" ){
					alert("原始密码不能为空.");
					$("input[name=pwd1]").focus();
					return;
				}if($("input[name=pwd1]").val() != $("input[name=pwd]").val() ){
					alert("两次密码不同.");
					$("input[name=pwd1]").focus();
					return;
				}
				document.all.form1.action= "../user/cpwd";
				document.all.form1.submit();
			}
			function cm () {
				$("#form1").html("");
				var table = $("<table></table>");
				var tr  = $("<tr></tr>");
				var td = $("<td align=\"right\">手机:</td><td><input name=\"mobileNew\"></td>"); 
				tr.append(td);
				table.append(tr);
				tr = $("<tr><td align=\"right\">验证码:</td><td><input name=\"mobileCode\"></td><td>&nbsp;&nbsp;&nbsp;&nbsp;<a href = \"javascript:sendMc();\"><发送验证码></a></td></tr>");
				table.append(tr);
				$("#form1").html(table);
				$("#a_sub").attr("onclick","vMc();");
				$("#w").window("open");
			}
			function vMc () {
				$.ajax({
						type:"post",
						url:"../user/mobileCode?type=2&mobile="+$("input[name=mobileNew]").val()+"&code="+$("input[name=mobileCode]").val(),
						contentType : "application/json",
						dataType:"json",
						success: function (data){
							alert(data.errorMsg);
							if(data.errorMsg == '修改成功.')
								$("#w").window("close");
						},
						error:function () {
							alert("error");
						}					
				});
			}
			function sendMc (){
				var mobile = $("input[name=mobileNew]").val();
				$.ajax({
						type:"post",
						url:"../user/mobileCode?type=1&mobile="+mobile,
						contentType : "application/json",
						dataType:"json",
						success: function (data){
							alert(data.errorMsg);						
						},
						error:function () {
							alert("error");
						}					
				});
			}
			function tc(){
				$("#form1").html("");
				var table = $("<table></table>");
				var tr  = $("<tr><td>投资金额:</td><td><input name=\"money\"></td></tr>");
				table.append(tr);
				var tr  = $("<tr><td>选着期限:</td><td id=\"tdrate\">"+$("#div1").html()+"</td></tr>");
				table.append(tr);
				$("#form1").html(table);
				$("#a_sub").attr("onclick","tcS();");
				$("#w").window("open");
			}
			function tcS () {
				var money = $("input[name=money]").val();
				var rate = $("#tdrate").children("select").val();
				if(isNaN(money)){
					alert("投资金额必须为数字!");
					return;
				}
				document.all.form1.action="../user/tc?money="+money+"&rate="+rate;
				document.all.form1.submit();			
			}
			function ye(amount,freezeAmount){
				$("#form1").html("");
				var table = $("<table width=\"80%\" align=\"center\"></table>");
				var tr  = $("<tr><td align=\"center\">当前余额</td><td align=\"center\">可用余额</td></tr>");
				table.append(tr);
				tr =  $("<tr><td align=\"center\"><span style='color:red'>"+ amount +"</span></td><td align=\"center\"><span style='color:red'>"+ freezeAmount +"</span></td></tr>");
				table.append(tr);
				$("#form1").html(table);
				$("#a_sub").attr("onclick","$('#w').window('close');");
				$("#w").window("open");
			}
			function cRate (id,type) {
				$("#form1").html("");
				var rate ="";
				var stage = "";
				if(id != -1){
					if(type=='0'){
						rate = $("#rate_tr_"+id+"").children("td").eq(0).html().split("%")[0];
					 	stage =$("#rate_tr_"+id+"").children("td").eq(1).html();
					}else{
						rate = $("#rateinf_tr_"+id+"").children("td").eq(0).html().split("%")[0];
					 	stage =$("#rateinf_tr_"+id+"").children("td").eq(1).html();
					}
					
				}
				var table = $("<table></table>");
				var tr = $("<tr><td><input type=\"hidden\" value=\""+id+"\" name=\"id\"/><input type=\"hidden\" value=\""+type+"\" name=\"type\"/></td></tr>");
				table.append(tr);
				tr = $("<tr><td align=\"right\">年化率:</td><td><input type=\"\" value=\""+rate+"\" name=\"rate\"/></td></tr>");
				table.append(tr);
				tr = $("<tr><td align=\"right\">期限:</td><td><input  type=\"\" value=\""+stage+"\" name=\"stage\"/></td></tr>");
				table.append(tr);
				$("#form1").html(table);
				$("#a_sub").attr("onclick","sRate();");
				$("#w").window("open");
			}
			function sRate() {
				var rate = $("input[name=rate]").val();
				var id = $("input[name=id]").val();
				if(isNaN(rate) || rate.trim() == ''){
					alert("年化率必须为数字.");
					return;
				}if(id == ''){
					alert("获取年化率ID失败,请重新点击修改按钮'");
					return ;
				}
				document.all.form1.action = "../admin/rateEdit";
				document.all.form1.submit();
			}