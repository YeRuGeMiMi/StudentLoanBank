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
<title>个人信息</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link href="${root}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${root}/css/common.css" rel="stylesheet"></link>
<script src="${root}/js/jquery-1.7.2.min.js"></script>
<script src="${root}/bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
	.self_main dl{
		width: 50%;
		margin: 20px auto;
	}
	.self_main select{
		width: 100px;
	}
</style>
</head>
<body>
	<div class="self_main">
		<form action="" method="POST" >
			<dl class="dl-horizontal">
				<dt>银行名称：</dt>
				<dd>${requestScope.bank.bname}</dd>
			</dl>
			<dl class="dl-horizontal">
				<dt>银行代码：</dt>
				<dd>${requestScope.bank.bcode }</dd>
			</dl>
			<dl class="dl-horizontal">
				<dt>对外邮箱：</dt>
				<dd>${requestScope.bank.email }</dd>
			</dl>
			
			<dl class="dl-horizontal">
				<dt>办公室电话：</dt>
				<dd>${requestScope.bank.officetel }</dd>
			</dl>
			<dl class="dl-horizontal">
				<dt>用户名：</dt>
				<dd>${requestScope.bank.member.username }</dd>
			</dl>
		</form>		
	</div>

	
</body>

</html>
