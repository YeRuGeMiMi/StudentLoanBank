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
<link href="${root }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${root }/css/common.css" rel="stylesheet"></link>
<script src="${root }/js/jquery-1.7.2.min.js"></script>
<script src="${root }/bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
	#collage_top{
		position: relative;
		top:10px;
		left: 20px;
	}
</style>
</head>
<body>
	<div id="collage_top">
		<form class="form-inline" >
			<label class="text-center">搜索</label>
			<input type="text" class="input-small" placeholder="关键词">
			<input type="submit" value="查询">	
			<input type="button" value="添加学院">
			<input type="button" value="添加专业">		
		</form>
	</div>
	<div id="collage_main">
		<table class="table table-condensed">
			<tr>
				<th>学院代号</th>
				<th>学院名称</th>
				<th>专业代号</th>
				<th>专业名称</th>
				<th>学制</th>
				<th>操作</th>
			</tr>
		</table>
	</div>
</body>
</html>