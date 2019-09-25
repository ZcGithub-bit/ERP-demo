<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>相册</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.11.4.css" />
<link rel="stylesheet" type="text/css" href="css/default.css" />
<link href="css/lanrenzhijia.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/mootools-core.js"></script>
<script type="text/javascript" src="js/mediabox.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/jquery-ui/jquery-ui-1.11.4.js"></script>
<script type="text/javascript" src="js/jquery.mypagination.js"></script>
<script language="javascript">
	window.dataCount = ${pageInfo.dataCount};
	window.currentlyPageNo = ${pageInfo.currentlyPageNo};
	window.pageSize = ${pageInfo.pageSize};
	 $(function (){
		var oInput = document.getElementsByTagName("input");
	 	$('#mypage').mypagination( window.dataCount, window.currentlyPageNo, window.pageSize);
		$('#pageSize').val(window.pageSize);
	});
	
 	function select(pageNo) {
		var pageNo = isNaN(pageNo) ? 1 : pageNo;
		var url = 'queryFanInfoList?pageNow='+pageNo ;  
		window.location.href = url ;
	}	

	$(function(){	
		//导航切换
		$(".imglist li").click(function(){
			$(".imglist li.selected").removeClass("selected");
			$(this).addClass("selected");
		})	
	})	


</script>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">模块设计</a></li>
    <li><a href="#">图片</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <form action="uploadphoto" method="post" enctype="multipart/form-data">
		    <input type="file" name="files" multiple />
		   	<input type="submit" value="上传" />
		</form>
    </div>
    
   <table class="imgtable">
    
    <thead>
    <tr>
	    <th width="10px;">缩略图 </th>
	    <th>上传日期</th>
	    <th>上传时间</th>
    </tr>
    </thead>
    
    <tbody>
    <c:forEach items="${pageInfo.dataList}" var="photo" >
      <tr>
	    <td class="image_container" ><img src="${photo.imgUrl}" style="width:100px;height:100px; " /></td>
	    <td>${photo.createDt}</td>
	    <td>${photo.createTm}</td>
	  </tr>
    </c:forEach>
    </tbody>
    
    </table>
  <!--  <div id="mypage" class="page mypagination" align="right"></div> -->
    
  <div class="pagin">
   <div class="message">共<i class="blue">${pageInfo.dataCount}</i>条记录，当前显示第&nbsp;<i class="blue">${pageInfo.currentlyPageNo}&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="getimglistpage?pageNow=${pageInfo.currentlyPageNo}&pageAction=pagepre"><span class="pagepre"></span></a></li>
        <li class="paginItem current"><a href="getimglistpage?pageNow=1">1</a></li>
        <li class="paginItem"><a href="getimglistpage?pageNow=2">2</a></li>
        <li class="paginItem"><a href="getimglistpage?pageNow=3">3</a></li>
        <li class="paginItem"><a href="getimglistpage?pageNow=4">4</a></li>
        <li class="paginItem"><a href="getimglistpage?pageNow=5">5</a></li>
        <li class="paginItem"><a href="getimglistpage?pageNow=${pageInfo.currentlyPageNo}&pageAction=pagenxt"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
    <div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:2;width:100%;height:100%;display:none;">
    <div id="innerdiv"style="position:absolute;"><img id="bigimg" style="border:5px solid #fff;" src="" /></div></div>
    
    </div>
    
   <center>
        <ul id="list" style="list-style-type: none;">
        </ul>
        <div id="Pagination" class=""></div>
    </center>
  
    <script type="text/javascript">
		$('.imgtable tbody tr:odd').addClass('odd');
	</script>

</body>
<script type="text/javascript">
	
</script>

</html>
