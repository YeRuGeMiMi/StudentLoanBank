<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.lyh.com" prefix="yl"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
<form action="setPower" method="POST" id="powerForm" onsubmit="return subRoids()">
	<div class="navbar" style="margin-bottom:0px">
		<div class="navbar-inner" sytle="text-align: center;">
			<h5>设置权限<input type="submit" value="保存" class="btn" style="float:right;vertical-align: middle;position: relative;bottom: 5px;"/><a href="javascript:history.back();" class="btn" style="float:right;vertical-align: middle;position: relative;bottom: 5px;">返回</a></h5> 
		</div>
	</div>
   <ul>
    <c:set var="menus" value="${requestScope.result}"></c:set>
    <c:forEach items="${menus[\"0\"]}" var="vo">
    	<c:choose>
    	<c:when test="${vo.isCheck == 1}">
    		<li><input type="checkbox" checked="checked" id="roids[${vo.mlid }]" name="roids[${vo.mlid }]" value="${vo.mlid }"/>${vo.title }</li>
    	</c:when>
    	<c:otherwise>
    		<li><input type="checkbox" id="roids[${vo.mlid }]" name="roids[${vo.mlid }]" value="${vo.mlid }"/>${vo.title }</li>
    	</c:otherwise>
    	</c:choose>
    	
    	<c:set var="plid" value="${vo.title}"></c:set>
    	<ul>
    		<c:forEach var="vo1" items="${menus[plid]}">
    			<c:choose>
    			<c:when test="${vo1.isCheck == 1}">
    				<li><input type="checkbox" id="roids[${vo1.mlid }]" checked="checked" name="roids[${vo1.mlid }]" value="${vo1.mlid }"/>${vo1.title }</li>
    			</c:when>
    			<c:otherwise>
    				<li><input type="checkbox" id="roids[${vo1.mlid }]" name="roids[${vo1.mlid }]" value="${vo1.mlid }"/>${vo1.title }</li>
    			</c:otherwise>
    			</c:choose>
    		</c:forEach>
    	</ul>
    </c:forEach>
    </ul>
    <input type="hidden" name="roid" value="${requestScope.roid }"/>
    <input type="hidden" name="roids" id="roids" value="">
</form>
<script type="text/javascript">
	function subRoids(){
		var roids = "";
		$("input[name^=roids]").each(function(){
			if($(this).attr("checked") == "checked"){
				roids += $(this).val()+",";
			}
		});
		roids = roids.slice(0,roids.length-1);
		$("#roids").attr("value",roids);
		return true;
	}
</script>
</body>
</html>