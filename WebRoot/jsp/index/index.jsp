<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:set var="root" value="${pageContext.request.contextPath}"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>欢迎--银行学生贷款系统</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link href="${root}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${root}/css/common.css" rel="stylesheet"></link>
<script src="${root}/js/jquery.min.js"></script>
<script src="${root}/bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
  .divcss5{border:1px solid #F00}
  #top{
    height:80px;
  }
  #left{
    width: 150px;
    position: absolute;
    top: 85px;
    left:25px;
    background-color: #fadede;
    border-radius:5px;
  }
  #right{
    width: 960px;
    position: absolute;
    left: 200px;
    top: 85px;
    background-color: #fadede;
    border-radius:5px;
  }

  .main{
    width: 100%;
    height: 100%;
    border: 0px;
  }
</style>
</head>
<body style="background-image: url(${root}/img/login_bg.jpg)">
	<div id="top" >
    <img src="${root}/img/logo.png" style="width:250px;"/>
    <span style="color: white;position: relative;top:25px;">欢迎<span style="color:red;">${sessionScope.member.username }</span>登录！今天是${sessionScope.today }</span>

    <span style="position: relative;top:25px;left:500px;"><a href="">退出</a></span>
  </div>
  <div id="left">
    <ul>
      <li><a href="" target="view_main">贷款管理</a></li>
      <li><a href="" target="view_main">学生管理</a></li>
      <li><a href="" target="view_main">学校管理</a></li>
      <li><a href="" target="view_main">银行管理</a></li>
      <li><a href="" target="view_main">系统管理</a></li>
    </ul>
  </div>
  <div id="right" >
    <iframe src="" class="main" name="view_main">
      
    </iframe>
  </div>
<div style="position: fixed;bottom: 0;width:100%;text-align: center;">
    <p style="color:white;">专业学生贷款&nbsp;@&nbsp;给你一个更好的明天</p>
</div>
</body>
</html>