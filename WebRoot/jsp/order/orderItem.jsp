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
			<h5>申请详情<button style="float:right;" onclick="javascipt:history.back();">返回</button></h5> 
		</div>
	</div>
	<c:set var="apply" value="${requestScope.apply}"></c:set>
    <table class="table table-bordered">
    	<tr>
    		<td width="10%">申请单号</td>
    		<td width="40%">${apply.apsn }</td>
    		<td width="10%">学生姓名</td>
    		<td width="40%">${apply.student.name }</td>
    	</tr>
    	<tr>
    		<td width="10%">校园卡号</td>
    		<td width="40%">${apply.student.schoolcode }</td>
    		<td width="10%">身份证号</td>
    		<td width="40%">${apply.student.selfcode }</td>
    	</tr>
    	<tr>
    		<td width="10%">学生邮箱</td>
    		<td width="40%">${apply.student.email}</td>
    		<td width="10%">学生电话</td>
    		<td width="40%">${apply.student.phone }</td>
    	</tr>
    	<tr>
    		<td width="10%">所在学校</td>
    		<td width="40%">${apply.student.school.name }</td>
    		<td width="10%">所属院系</td>
    		<td width="40%">${apply.student.collage.coname }-${apply.student.profession.proname }</td>
    	</tr>
    	<tr>
    		<td width="10%">申请银行</td>
    		<td width="40%">${apply.bank.bname }</td>
    		<td width="10%">银行卡号</td>
    		<td width="40%">${apply.bankcode }</td>
    	</tr>
    	<tr>
    		<td width="10%">申请时间</td>
    		<td width="40%"><yl:dateFomat name="${apply.created}"></yl:dateFomat></td>
    		<td width="10%">金额</td>
    		<td width="40%">${apply.money }</td>
    	</tr>
    </table>
    <c:if test="${apply.status == 1 && requestScope.type == 2 }">
    	<div align="center">
    		<span><a class="btn btn-primary" href="apply?id=${apply.apid }&status=2">同意</a></span>
    		<span><a class="btn" href="apply?id=${apply.apid }&status=4">拒绝</a></span>
    	</div>
    </c:if>
    <c:if test="${apply.status == 2 && requestScope.type == 3 }">
    	<div align="center">
    		<span><a class="btn btn-primary" href="apply?id=${apply.apid }&status=3">同意</a></span>
    		<span><a class="btn" href="apply?id=${apply.apid }&status=4">拒绝</a></span>
    	</div>
    </c:if>
    <div style="text-align: center;">
    	<dl>
    		<dt>当前状态</dt>
    		<dd>${orderstatus[apply.status] }</dd>
    	</dl>
    </div>
</body>
</html>