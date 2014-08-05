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
<script src="${root}/js/jquery-1.7.2.min.js"></script>
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
  .list ul{
  	list-style-type:none;
  	margin-left:0px;
  }
  .list ul li{
  	text-align: center;
  }
</style>
</head>
<body style="background-image: url(${root}/img/login_bg.jpg)">
	<div id="top" >
    <img src="${root}/img/logo.png" style="width:250px;"/>
    <span style="color: white;position: relative;top:25px;">欢迎<span style="color:red;">${sessionScope.member.username }</span>登录！今天是${sessionScope.today }</span>

    <span style="position: relative;top:25px;left:500px;"><a href="../User/quit" class="btn btn-danger">退出</a></span>
  </div>
  <div id="left">
    <div class="btn-group-vertical">
    <c:set var="menus" value="${requestScope.menus}"></c:set>
    	<c:forEach var="vo" items="${menus[\"0\"]}">
<button type="button" class="btn btn-primary" style="width: 150px;" onclick="jh(${vo.path})">${vo.title}</button>    		
    		<c:if test="${vo.has_submenu==1}">
    		<div id="${vo.path}" class="list">
    		<c:set var="plid" value="${vo.title}"></c:set>
	        <ul>
	        <c:forEach var="vo1" items="${menus[plid]}">
	        
	          <li><a href="${root}${vo1.path}">${vo1.title}</a><i class="icon-hand-left"></i></li>
	         </c:forEach>
	        </ul>
        	</div>
        	</c:if>
    	</c:forEach>
    	
   </div>
  </div>
  <div id="right" >
    <iframe src="" class="main" name="view_main">
      
    </iframe>
  </div>
<div style="position: fixed;bottom: 0;width:100%;text-align: center;">
    <p style="color:white;">专业学生贷款&nbsp;@&nbsp;给你一个更好的明天</p>
</div>
<script type="text/javascript">
	window.onload = function(){
		$("div[id$='_list']").css("display","none");
	}
	
	function jh(vlist){
    	var t = $(vlist);
    	if(t.css("display") == "none"){
    		t.css("display","block");
    	}else{
    		t.css("display","none");
    	}
	}
</script>
</body>
</html>