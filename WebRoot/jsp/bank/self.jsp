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
	.self_main table{
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
		<form action="self" method="POST">
			
			<table>
				<tr>
					<td align="right"><label class="control-label">银行名：</label></td>
					<td><input type="text" placeholder="请输入银行名称" name="bname" ></td>
				</tr>
				<tr>
					<td align="right"><label class="control-label">银行代码：</label></td>
					<td><input type="text" placeholder="请输入银行代码" name="bcode" ></td>
				</tr>
				<tr>
					<td align="right"><label class="control-label">办公室电话：</label></td>
					<td><input type="text" placeholder="请输入办公室电话" name="officetel" ></td>
				</tr>
				<tr>
					<td align="right"><label class="control-label">邮箱：</label></td>
					<td><input type="text" placeholder="请输入邮箱" name="email" ></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="提交" class="btn btn-large btn-primary" >
					</td>
				</tr>
			</table>

		</form>		
	</div>
</body>
</html>
