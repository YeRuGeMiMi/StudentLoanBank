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
				<dt>头像</dt>
				<dd><yl:logImg name="${requestScope.student.photo}" root="${root}"></yl:logImg></dd>
			</dl>
			<dl class="dl-horizontal">
  				<dt>姓名：</dt>
  				<dd>${requestScope.student.name }</dd>
			</dl>
			<dl class="dl-horizontal">
				<dt>
  					生日：
  				</dt>
  				<dd><yl:dateFomat name="${requestScope.student.born}"></yl:dateFomat></dd>
			</dl>
			<dl class="dl-horizontal">
  				<dt>身份证号：</dt>
  				<dd>${requestScope.student.selfcode }</dd>
			</dl>
			<dl class="dl-horizontal">
  				<dt>所属学校：</dt>
  				<dd>${requestScope.student.school.name}</dd>
			</dl>
			<dl class="dl-horizontal">
  				<dt>所属学院：</dt>
  				<dd>${requestScope.student.collage.coname}</dd>
			</dl>
			<dl class="dl-horizontal">
  				<dt>所属专业：</dt>
  				<dd>${requestScope.student.profession.proname}</dd>
			</dl>
			<dl class="dl-horizontal">
  				<dt>校园卡号：</dt>
  				<dd>${requestScope.student.schoolcode}</dd>
			</dl>
			<dl class="dl-horizontal">
  				<dt>家庭地址：</dt>
  				<dd>${requestScope.student.address}</dd>
			</dl>
			<dl class="dl-horizontal">
  				<dt>个人邮箱：</dt>
  				<dd>${requestScope.student.email}</dd>
			</dl>
			<dl class="dl-horizontal">
  				<dt>手机：</dt>
  				<dd>${requestScope.student.phone}</dd>
			</dl>
			<dl class="dl-horizontal">
  				<dt>开户银行：</dt>
  				<dd>${requestScope.student.bank}</dd>
			</dl>
			<dl class="dl-horizontal">
  				<dt>银行卡号：</dt>
  				<dd>${requestScope.student.bankcode}</dd>
			</dl>
		</form>		
	</div>

	
</body>

</html>
