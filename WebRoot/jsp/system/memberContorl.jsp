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
			<h5>修改账户密码</h5> 
		</div>
	</div>
	<form action="memberContorl" method="POST" onsubmit="return yz()">
    <table class="table table-bordered">
    	<tr>
    		<td>账户名：</td>
    		<td>${member.username }</td>
    	</tr>
    	<tr>
    		<td>原密码：</td>
    		<td><input type="password" name="oldpasswd" id="oldpasswd"/></td>
    	</tr>
    	<tr>
    		<td>新密码：</td>
    		<td><input type="password" name="newpasswd" id="newpasswd"/></td>
    	</tr>
    	<tr>
    		<td>重复新密码：</td>
    		<td><input type="password" id="repasswd"/></td>
    	</tr>
    	<tr><td colspan="2" style="text-align: center;"><input type="submit" value="提交" class="btn"/></td></tr>
    </table>
    <input type="hidden" name="username" value="${member.username }">
    </form>
    
<script type="text/javascript">
	function yz(){
		if($("#oldpasswd").val() == ""){
			alert("原密码不能为空");
			return false;
		}
		if($("#newpasswd").val() == ""){
			alert("新密码不能为空");
			return false;
		}
		if($("#repasswd").val() == ""){
			alert("重复密码不能为空");
			return false;
		}
		if($("#repasswd").val() != $("#newpasswd").val()){
			alert("两次输入的密码不一致");
			return false;
		}
		
		return true;
	}
</script>
</body>
</html>