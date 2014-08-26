<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.lyh.com" prefix="yl"%>
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
	#student_top{
		position: relative;
		top:10px;
		left: 20px;
	}
</style>
</head>
<body>
	<div id="student_top">
		<form class="form-inline" action="info" method="POST">
			<label class="text-center">搜索</label>
			<input type="text" class="input-small" placeholder="关键词" name="textword" value="${requestScope.keys.textword }">
			<input type="submit" value="查询" class="btn btn-primary">	
			
		</form>
	</div>
	<div id="student_main">
		<table class="table table-condensed">
			<tr>
				<th>校园卡号</th>
				<th>姓名</th>
				<th>邮箱</th>
				<th>学院</th>
				<th>专业</th>
				<th>生日</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${requestScope.students}" var="student">
				<tr>
					<td>${student.schoolcode }</td>
					<td>${student.name }</td>
					<td>${student.email }</td>
					<td>${student.collage.coname }</td>
					<td>${student.profession.proname }</td>
					<td><yl:dateFomat name="${student.born}"></yl:dateFomat></td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	${requestScope.pagepaper}
</body>


</html>