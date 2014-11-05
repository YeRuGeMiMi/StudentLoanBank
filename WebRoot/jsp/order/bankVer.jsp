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
	#collage_top{
		position: relative;
		top:10px;
		left: 20px;
	}
</style>
</head>
<body>
	<div id="collage_top">
		<form class="form-inline" action="schoolVer" method="POST">
			<label class="text-center">搜索</label>
			<input type="text" class="input-small" placeholder="关键词" name="textword" value="${requestScope.keys.textword }">
			<input type="submit" value="查询" class="btn btn-primary">	
			
		</form>
	</div>
	<div id="collage_main">
		<table class="table table-condensed">
			<tr>
				<td><input type="checkbox" id="id"/></td>
				<th>申请编号</th>
				<th>学生姓名</th>
				<th>邮箱</th>
				<th>电话</th>
				<th>申请银行</th>
				<th>金额</th>
				<th>创建时间</th>
				<th>状态</th>
				<th>操作</th>
				
			</tr>
			<c:set var="orderstatus" value="${requestScope.order_status}"></c:set>
			<c:forEach items="${requestScope.applys}" var="apply">
				<tr>
					<td><input type="checkbox" id="id[${apply.apid }]"/></td>
					<td><a href="orderItem?apid=${apply.apid }">${apply.apsn }</a></td>
					<td>${apply.student.name }</td>
					<td>${apply.student.email }</td>
					<td>${apply.student.phone }</td>
					<td>${apply.bank.bname }</td>
					<td>${apply.money }</td>
					<td><yl:dateFomat name="${apply.created}"></yl:dateFomat></td>
					<td>${orderstatus[apply.status] }</td>
					<td><c:choose>
						<c:when test="${apply.status == 2}">
							<a href="orderItem?apid=${apply.apid }">审核</a>
						</c:when>
						<c:otherwise>
							<a href="orderItem?apid=${apply.apid }">查看</a>
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
	${requestScope.pagepaper}
	<script type="text/javascript">
		$("#id").click(function(){
			if($(this).attr("checked")){
				$("input[id^='id[']").attr({'checked':true});
			}else{
				$("input[id^='id[']").attr({'checked':false});
			}
		});
	</script>
</body>


</html>