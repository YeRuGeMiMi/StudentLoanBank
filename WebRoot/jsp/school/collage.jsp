<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
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
		<form class="form-inline" action="collage" method="POST">
			<label class="text-center">搜索</label>
			<input type="text" class="input-small" placeholder="学院名" name="textword" value="${requestScope.keys.textword }">
			<input type="submit" value="查询" class="btn btn-primary">	
			<input type="button" value="添加学院" onclick="toCol()" class="btn btn-success">
			<input type="button" value="添加专业" onclick="toPro()" class="btn btn-success">		
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
			<c:forEach items="${requestScope.collages}" var="col">
				<c:forEach items="${col.professions}" var="pro" varStatus="proindex">
					<tr class="success">
						<c:if test="${proindex.index == 0}">
						<td rowspan="${fn:length(col.professions) }" style="vertical-align:middle;">${col.cocode }</td>
						<td rowspan="${fn:length(col.professions) }" style="vertical-align:middle;">${col.coname }</td>
						</c:if>
						<td>${pro.procode }</td>
						<td>${pro.proname }</td>
						<td>${pro.year }</td>
						<td></td>
					</tr>
					
				</c:forEach>
			</c:forEach>
		</table>
	</div>
	${requestScope.pagepaper}
</body>

<script type="text/javascript">
	function toCol(){
		window.location = "addCollage";
	}
	
	function toPro(){
		window.location = "addProfession";
	}
</script>
</html>