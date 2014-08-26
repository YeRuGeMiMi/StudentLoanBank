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
		<form class="form-inline" action="list" method="POST">
			<label class="text-center">搜索</label>
			<input type="text" class="input-small" placeholder="关键词" name="textword" value="${requestScope.keys.textword }">
			<input type="submit" value="查询" class="btn btn-primary">	
			
		</form>
	</div>
	<div id="collage_main">
		<table class="table table-condensed">
			<tr>
				<th>学校代码</th>
				<th>学校名称</th>
				<th>对外邮箱</th>
				<th>办公室电话</th>
				<th>传真</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${requestScope.schools}" var="school">
				<tr>
					<td>${school.scode }</td>
					<td>${school.name }</td>
					<td>${school.email }</td>
					<td>${school.officetel }</td>
					<td>${school.fax }</td>
					<td></td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
	${requestScope.pagepaper}
</body>


</html>