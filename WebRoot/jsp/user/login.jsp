<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:set var="root" value="${pageContext.request.contextPath}"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="${root}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${root}/css/common.css" rel="stylesheet"></link>
<script src="${root}/js/jquery.min.js"></script>
<script src="${root}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="background-image: url(${root}/img/login_bg.jpg)">
	<div class="logo"></div>
	<div class="touxiang"><img src="${root}/img/touxiang.png" class="img-rounded" width="150px"></div>
   <div class="login">
   	<div id="nei">
   <form class="bs-example bs-example-form" role="form" action="user/login" method="POST">
      <div class="input-group">
         <span class="ltext">用户名:</span>
         <input type="text" class="form-control" placeholder="请输入用户名" name="username">
      </div>
      <br>

      <div class="input-group">
      	 <span class="ltext">密&nbsp;&nbsp;&nbsp;&nbsp;码:</span>
         <input type="password" class="form-control" placeholder="请输入密码 " name="password">
      </div>
      <span class="submit">
     <input type="submit" class="btn btn-primary" value="登录">
     <input type="button" class="btn btn-info" onclick="zc()"  value="注册">
     </span>
   </form>
   </div>

</div>
<div class="foot">
	专注于学生贷款  @2014-07-01
</div>
	<script type="text/javascript">
		function zc(){
			window.location="user/reg";
		}
	</script>
</body>
</html>
