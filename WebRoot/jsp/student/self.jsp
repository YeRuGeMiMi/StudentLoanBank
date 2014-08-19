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
		<form action="" method="">
			
			<table>
				<tr>
					<td align="right"><label class="control-label">姓名：</label></td>
					<td><input type="text" placeholder="请输入你的姓名"></td>
				</tr>
				<tr>
					<td align="right"><label class="control-label">出生年月日：</label></td>
					<td>
					<select id="year" onchange="toMonth(this.value)">
						<option value="">请选择</option>
						
					</select>
					<select id="month" onchange="toDay(this.value)">
					</select>
					<select id="day">
						
					</select>
				</td>
				</tr>
				<tr>
                    <td align="right"><label class="control-label">身份证号：</label></td>
                    <td><input type="text" placeholder="请输入你的身份证号"></td>
                </tr>
                <tr>
                    <td align="right"><label class="control-label">所在学校：</label></td>
                    <td><select onchange="getCollages(this.value)" id="school" name="school">
                    	<option>请选择</option>
                    	<c:forEach items="${requestScope.schools}" var="school">
							<option value="${school[0] }">${school[1] }</option>
						</c:forEach>
                    </select></td>
                </tr>
                <tr>
                    <td align="right"><label class="control-label">所属学院：</label></td>
                    <td><select onchange="getProfessions(this.value)" id="collage" name="collage">

                    </select></td>
                </tr>
                <tr>
                    <td align="right"><label class="control-label">所属专业：</label></td>
                    <td><select id="profession" name="profession">
                    </select></td>
                </tr>
                
				<tr>
					<td align="right"><label class="control-label">校园卡号：</label></td>
					<td><input type="text" placeholder="请输入你的校园卡号"></td>
				</tr>
				<tr>
                    <td align="right"><label class="control-label">家庭住址：</label></td>
                    <td><input type="text" placeholder="请输入你的地址"></td>
                </tr>
				<tr>
					<td align="right"><label class="control-label" >邮箱：</label></td>
					<td><input type="text" placeholder="请输入你的合法邮箱"></td>
				</tr>
				<tr>
					<td align="right"><label class="control-label">手机号码：</label></td>
					<td><input type="text" placeholder="请输入你的手机号码"></td>
				</tr>
				<tr>
					<td align="right"><label class="control-label">头像：</label></td>
					<td><input type="file"></td>
				</tr>
				<tr>
					<td align="right"><label class="control-label">开户银行：</label></td>
					<td><input type="text" placeholder="请输入你的开户银行"></td>
				</tr>
				<tr>
					<td align="right"><label class="control-label">银行卡号：</label></td>
					<td><input type="text" placeholder="请输入你的银行卡号"></td>
				</tr>
				
				<tr>
					<td align="center" colspan="2"><input type="submit" class="btn btn-large btn-primary" value="提交"/></td>
				</tr>
			</table>


		</form>		
	</div>

	<script type="text/javascript">
		window.onload = function(){
			y = new Date().getFullYear();
			for(var i=(y-90);i<=y;i++){
				//DOM对象添加
				// $("#year")[0].options.add(new Option(i,i));
				// $("#year")[0].options.value=y;
				//jquery对象添加
				$("#year").append("<option value=\""+i+"\">"+i+"</option>");
			}
		};

		function toMonth(year){
			if(year == null){
				return false;
			};

			$("#month").append("<option value=\"\">请选择</option>");
			for (var i = 1; i <= 12; i++) {
				$("#month").append("<option value=\""+i+"\">"+i+"</option>");
			};
		};

		function toDay(month){
			if(month == null){
				return false;
			};

			$("#day").append("<option value=\"\">请选择</option>");
			if(month == 2){
				var year = $("#year").val();
				if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
					for (var i = 1; i <= 29; i++) {
						$("#day").append("<option value=\""+i+"\">"+i+"</option>");
					};
					return;
				}
			};

			var MonthHed=[31,28,31,30,31,30,31,31,30,31,30,31];
			for (var i = 1; i <= MonthHed[month-1]; i++) {
						$("#day").append("<option value=\""+i+"\">"+i+"</option>");
			};
		};
	</script>
	<script type="text/javascript">
		function getCollages(scid){
			$.ajax({
				type:"POST",
				url:"../Ajax/getCollages",
				data:{school:scid},
				dataType:"json",
				success:function(data){
					var result = data.result;
					$("#collage").append("<option value=\"\">请选择</option>");
					for (var key in result) {
						$("#collage").append("<option value=\""+key+"\">"+result[key]+"</option>");
					};
				}
			});
		}
		
		function getProfessions(coid){
			$.ajax({
				type:"POST",
				url:"../Ajax/getProfessions",
				data:{coid:coid},
				dataType:"json",
				success:function(data){
					var result = data.result;
					$("#profession").append("<option value=\"\">请选择</option>");
					for (var key in result) {
						$("#profession").append("<option value=\""+key+"\">"+result[key]+"</option>");
					};
				}
			});
		}
	</script>
</body>

</html>
