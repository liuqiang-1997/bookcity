<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
<%--	<base href="http://localhost:8088/javabook/">--%>
<%--<link type="text/css" rel="stylesheet" href="static/css/style.css" >--%>
	<%--	静态包含base标签，css样式，jQuery文件--%>
	<%@include file="/pages/common/head_info.jsp"%>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>
<%--			<div>--%>
<%--				<a href="pages/manager/book_manager.html">图书管理</a>--%>
<%--				<a href="pages/manager/order_manager.html">订单管理</a>--%>
<%--				<a href="index.html">返回商城</a>--%>
<%--			</div>--%>
<%--		静态包含manager管理模块的菜单--%>
		<%@include file="/pages/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>订单号码</td>
				<td>下单日期</td>
				<td>订单金额</td>
				<td>订单详情</td>
				<td>订单状态</td>
				<td>发货</td>
				
			</tr>

			<c:forEach items="${requestScope.allOrders}" var="allOrders">
			<tr>
				<td>${allOrders.orderId}</td>
				<td>${allOrders.createTime}</td>
				<td>${allOrders.price}</td>
				<td><a href="orderServlet?action=orderDetails&orderId=${allOrders.orderId}">查看详情</a></td>
				<c:if test="${allOrders.status == 0}">
					<td style="color: red" >未发货</td>
				</c:if>
				<c:if test="${allOrders.status == 1}">
					<td style="color: darkorange">已发货</td>
				</c:if>
				<c:if test="${allOrders.status == 2}">
					<td style=" color:green">已签收</td>
				</c:if>
				<c:if test="${allOrders.status == 0}">
					<td><a href="orderServlet?action=sendorreveiveOrder&status=1&orderId=${allOrders.orderId}">点击发货</a></td>
				</c:if>
				<c:if test="${allOrders.status == 1}">
					<td style="color: darkorange">运输途中</td>
				</c:if>
				<c:if test="${allOrders.status == 2}">
					<td style=" color:green">已被签收</td>
				</c:if>


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