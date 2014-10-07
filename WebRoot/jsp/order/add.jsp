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
	#xieyi{
	margin: 20px auto;
	}
	
	#xieyi h3{
		text-align:center;
	}
	#xieyi h5{
		text-align:center;
	}
	#xieyi p{
		position:relative;
		left:250px;
		width:500px;
	}
</style>
</head>
<body>


	<div class="self_main">
		<div id="xieyi">
			<h3>贷款学生贷款协议书</h3>
			<p>借款人（甲方）:（借款学生）</p>
			<p>贷款人（乙方）:（经办银行）</p>
			<p>介绍人（丙方）:（学校机构）</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;甲方经丙方向乙方申请国家助学贷款，乙方经审查同意发放贷款。为维护各方利益，明确责任，恪守信用，根据国家法律、法规、国家助学贷款政策和乙方或其上级机构与全国学生贷款管理中心签订的《国家助学贷款合作协议》，经协商一致，订立本合同。</p>
			<h5>一、借款利率与计息方法</h5>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本合同项下借款，执行中国人民银行颁布的同期同档次法定贷款利率。本合同签订时国家助学贷款年利率为   2.25％。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;实际发放贷款时，如遇法定利率调整，乙方将执行调整后的利率，不再另行通知甲方。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在贷款期内，如遇法定利率调整，贷款期限在一年以内（含一年），按合同约定利率计息；贷款期限在一年以上的，则从次年贷款发放日的对应日起按调整后的利率档次执行。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;贷款展期后累计期限达到新的利率期限档次的，从展期之日起按新的期限利率执行。</p>
			<h5>二、贷款利息</h5>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;甲方在校期间的借款利息100％由财政补贴，具体补贴办法根据国家相关规定执行。甲方毕业后的利息及罚息由其本人全额支付。</p>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;甲方毕业后自付利息的开始时间为其取得毕业证书之日的下月1日（含1日）;当甲方按照丙方所在学校学籍管理规定结业、肄业、休学、退学、被取消学籍时，自办理有关手续之日的下月1日起自付利息。如甲方休学，当其复学后，恢复财政贴息起始日为当月的1日。</p>
		</div>
		
		<form action="add" method="POST">
			
			<table>
				<tr>
					<td><input type="checkbox" name="isArgee" id="isArgee"/></td>
					<td>是否同意此协议？</td>
				</tr>
				<tr>
					<td>贷款金额：</td>
					<td><input type="text" name="money"/></td>
				</tr>
				<tr>
					<td>选择银行：</td>
					<td><select name="bank">
						<option>请选择</option>
						<c:forEach items="${requestScope.banks}" var="bank">
							<option value="${bank.bid }">${bank.bname }</option>
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>银行卡号：</td>
					<td><input type="text" name="bankcode" value="${requestScope.student.bankcode }"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="提交" class="btn btn-large btn-primary"/></td>
				</tr>
			</table>

		</form>		
	</div>
	
<script type="text/javascript">
	$(document).ready(function(){
		$("input[type='submit']").attr('disabled',true);
		$("input[type='submit']").css({'background':'gray'});
	});
	
	$("#isArgee").click(function(){
		if($("#isArgee").attr("checked") == 'checked'){
			$("input[type='submit']").attr('disabled',false);
			$("input[type='submit']").removeAttr('style');
		}else{
			$("input[type='submit']").attr('disabled',true);
			$("input[type='submit']").css({'background':'gray'});
		}
	});
</script>
</body>
</html>