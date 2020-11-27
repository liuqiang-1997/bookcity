<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%--	<base href="http://localhost:8088/javabook/">--%>
<%--<link type="text/css" rel="stylesheet" href="static/css/style.css" >--%>
	<%--	静态包含base标签，css样式，jQuery文件--%>
	<%@include file="/pages/common/head_info.jsp"%>
	<script type="text/javascript">
		$(function (){
			$("a.deleteClass").click(function (){
				/**
				 * confirm 是确认提示框函数，参数为其提示的内容，有两个按钮，返回true表示点击确认，false表示点击取消
				 * 在事件的function函数中，有一个this对象，这个this对象是当前正在响应事件的dom对象
				 */

				return confirm("你确定要删除这本"+$(this).parent().parent().find("td:first").text()+"吗？".trim());
			});

			$("#cleanItem").click(function (){
				return confirm("你确定要清空您的购物车吗?");
			});



			$(".updateCounts").change(function (){
				var name = $(this).parent().parent().find("td:first").text();
				var counts = this.value;
				var id = $(this).attr("bookid");

				if(confirm("你确定要将"+name+"的数量修改为"+counts+"嘛？")){
					location.href="http://localhost:8088/javabook/cartServlet?action=updateCount&id="+id+"&counts="+counts.trim();
				}else{
					this.value = this.defaultValue;
				}
			});

		});


	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main" >
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items}">
<%--				如果购物车为空--%>
				<tr>
					<td colspan="5">您的购物车和您的知识一样空荡！！！<br/> <a href="index.jsp">快去买书吧</a></td>
				</tr>
			</c:if>
			<c:forEach items="${sessionScope.cart.items}" var="entry">
				<tr>
					<td>《${entry.value.name}》</td>
					<td>
						<input class="updateCounts" type="text" style="width: 60px"
							  bookid="${entry.value.id}" value=" ${entry.value.count}"/>
					</td>
					<td>${entry.value.price}</td>
					<td>${entry.value.totalPricr}</td>
					<td><a class="deleteClass" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
				</tr>
			</c:forEach>

			


		</table>
		<c:if test="${not empty sessionScope.cart.items}">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalprice}</span>元</span>
			<span class="cart_span"><a id="cleanItem" href="cartServlet?action=cleanItem">清空购物车</a></span>
			<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
		</div>
		</c:if>

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