<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单详情</title>
<%--	<base href="http://localhost:8088/javabook/">--%>
<%--<link type="text/css" rel="stylesheet" href="static/css/style.css" >--%>
	<%--	静态包含base标签，css样式，jQuery文件--%>
	<%@include file="/pages/common/head_info.jsp"%>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单详情</span>
		<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>书名</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
			</tr>
			<c:forEach items="${requestScope.orderDetails}" var="orderdetails">
				<tr>
					<td>《${orderdetails.name}》</td>
					<td>${orderdetails.count}</td>
					<td>${orderdetails.price}</td>
					<td>${orderdetails.totalPrice}</td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<%--		<div id="bottom">--%>
	<%--			<span>--%>
	<%--				贝壳田园BBS系统.Copyright &copy;2020--%>
	<%--			</span>--%>
	<%--		</div>--%>
	<%--静态包含页脚信息--%>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>