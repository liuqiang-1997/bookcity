<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<%--	<base href="http://localhost:8088/javabook/">--%>
<%--<link type="text/css" rel="stylesheet" href="static/css/style.css" >--%>
	<%--	静态包含base标签，css样式，jQuery文件--%>
	<%@include file="/pages/common/head_info.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
		<%--			   静态包含登录成功之后的菜单--%>
		<%@include file="/pages/common/login_success_menu.jsp"%>

	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>订单号码</td>
				<td>下单日期</td>
				<td>订单金额</td>
				<td>订单状态</td>
				<td>订单详情</td>
				<td>订单签收</td>
			</tr>
			<c:forEach items="${requestScope.myOrders}" var="myOrder">
			<tr>
				<td>${myOrder.orderId}</td>
				<td>${myOrder.createTime}</td>
				<td>${myOrder.price}</td>
				<c:if test="${myOrder.status == 0}">
					<td style="color: red">未发货</td>
				</c:if>
				<c:if test="${myOrder.status == 1}">
					<td style="color: goldenrod">已发货</td>
				</c:if>
				<c:if test="${myOrder.status == 2}">
					<td style="color: green">已签收</td>
				</c:if>

				<td><a href="orderServlet?action=orderDetails&orderId=${myOrder.orderId}">查看详情</a></td>
				<c:if test="${myOrder.status == 1}">
					<td><a href="orderServlet?action=sendorreveiveOrder&status=2&orderId=${myOrder.orderId}">确认签收
					</a></td>
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