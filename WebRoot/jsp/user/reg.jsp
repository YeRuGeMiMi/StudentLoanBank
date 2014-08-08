<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:set var="root" value="${pageContext.request.contextPath}"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="${root}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${root}/css/reg.css">
<script src="${root}/js/jquery.min.js"></script>
<script src="${root}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="background-image: url(${root}/img/login_bg.jpg)">
    <div class="main">
    	<form action="Reg/reg" method="POST" >
    		<h3>账户信息</h3>
            <hr>
            <table  height="100%" border="0" cellspacing="0" cellpadding="0" class="regtable">
                <tr>
                    <td align="right"><label class="control-label">用户名：</label></td>
                    <td ><input type="text" placeholder="请输入用户名" name="username"></td>
                </tr>
                <tr>
                    <td align="right"><label class="control-label">密码：</label></td>
                    <td ><input type="password" placeholder="请输入密码" name="password"></td>
                </tr>
                <tr>
                    <td align="right"><label class="control-label">重复密码：</label></td>
                    <td ><input type="password" placeholder="请再次输入密码" name="repassword"></td>
                </tr>
                <tr>
                    <td align="right"><label class="control-label">邮箱：</label></td>
                    <td ><input type="text" placeholder="请输入合法邮箱" name="email"></td>
                </tr>
                <tr>
                    <td align="right"><label class="control-label">注册账户类型：</label></td>
                    <td >
                        <select name="type">
                            <option value="0">--请选择类型--</option>
                            <option value="1">学生账户</option>
                            <option value="2">学校账户</option>
                            <option value="3">银行账户</option>
                            <option value="4">管理员账户</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right"><input type="submit" class="btn btn-large btn-primary" value="去注册"></td>
                    <td><input type="button" class="btn btn-large" value="不注册" onclick="back()"></td>
                </tr>
            </table>
            
    	</form>
    </div>
</body>
	<script type="text/javascript">
		function back(){
			window.location="User/login";
		}
	</script>
</html>
