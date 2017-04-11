<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="/springtest/js/jquery-1.11.3.min.js"></script>
	
	<script type="text/javascript">
	//加载页面后运行ready 函数
		$(document).ready(function()
		{
			$("#add").click(function()
			{
				//var userName =  $("#userName").Attr("value"); //错误
				//var userName = document.getElementById("userName").value;//通过js获得值
				//var userName =$("input[name='userName']").val(); //通过name 获得值
				var userName =$("#userName").val();
				var pwd =$("#pwd").val();
				//alert(userName);
				var user = {userName:userName,pwd:pwd};
				$.ajax({
					url:"/springtest/json/addUserAjax",
					type:"post",
					data:user,
					success:function(data)
					{
						//alert("userName:"+data.userName+"pwd:"+data.pwd);
						alert("userName:"+data.userName+"pwd:"+data.pwd);
					}
				});

			});
			
		});
	/* 	
		function submitData()
		{
			var form = document.forms[0];
			form.action="/springtest/json/addUser";
			form.method="post";
			form.submit();
		} */
	
	</script>
  </head>
  
  <body>
  <div>
  	<h2>增加用户</h2>
  <!-- 	<form action="/springtest/json/addUser" method="post"> -->
  <form action="">
	  用户名：	<input type="text" id="userName" name="userName">
	  	<br/>
	  密码：	<input type="text" id="pwd" name="pwd">
	  	<br/>
  	 	<!-- <input type="button" value="提交" id="add" onclick="submitData()"> --> 
  	 	<input type="button" value="提交" id="add" >
  	 </form>
  </div>
  
  
  	
    This is my JSP page. <br>
  </body>
</html>
