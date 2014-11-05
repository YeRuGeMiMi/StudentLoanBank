<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.lyh.com" prefix="yl"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:set var="orderstatus" value="${requestScope.order_status}"></c:set>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>申请单详情页</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link href="${root }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${root }/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${root }/js/jquery-1.7.2.min.js"></script>
</head>
<body>
	<div class="navbar" style="margin-bottom:0px">
		<div class="navbar-inner" sytle="text-align: center;">
			<h5>权限管理</h5> 
		</div>
	</div>
    <table class="table table-bordered">
    <tr>
    	<th>角色名称</th>
    	<th>角色描述</th>
    	<th width="50%">用户组</th>
    	<th>操作</th>
    </tr>
    	<c:forEach items="${requestScope.roles}" var="role">
    		<tr>
    			<td>${role.roname }</td>
    			<td>${role.rodec }</td>
    			<td>
    			【
    				<c:forEach items="${role.members}" var="member" varStatus="stat">
    					<c:choose>
    						<c:when test="${stat.last}">${member.username }</c:when>
    						<c:otherwise>${member.username }，</c:otherwise>
    					</c:choose>
    				</c:forEach>
    				】
    			</td>
    			<td><a href="setPower?roid=${role.roid }" class="btn">设置权限</a></td>
    		</tr>
    	</c:forEach>
    </table>
</body>
</html>