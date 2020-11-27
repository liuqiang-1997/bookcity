<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
<%--	<base href="http://localhost:8088/javabook/">--%>
<%--<link type="text/css" rel="stylesheet" href="static/css/style.css" >--%>
	<%--	静态包含base标签，css样式，jQuery文件--%>
	<%@include file="/pages/common/head_info.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
			<%--			<div>--%>
			<%--				<a href="pages/manager/book_manager.html">图书管理</a>--%>
			<%--				<a href="pages/manager/order_manager.html">订单管理</a>--%>
			<%--				<a href="index.html">返回商城</a>--%>
			<%--			</div>--%>
			<%--		静态包含manager管理模块的菜单--%>
			<%@include file="/pages/common/manager_menu.jsp"%>
		</div>
		
		<div id="main">
			<form action="manager/bookServlet" method="get">
<%--				用于分页后添加图书完成后跳转到新加图书所在页--%>
				<input type="hidden" name="pageNo" value="${param.pageNo}">
<%--	//根据id参数判断功能--%>
				<input type="hidden" name="action" value="${empty param.id?"add":"update"}" />
				<input type="hidden" name="id" value="${requestScope.bookinfo.id}"/>
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>

					<tr>
						<td><input name="name" type="text" value="《${requestScope.bookinfo.name}》"/></td>
						<td><input name="price" type="text" value="${requestScope.bookinfo.price}"/></td>
						<td><input name="author" type="text" value="${requestScope.bookinfo.author}"/></td>
						<td><input name="sales" type="text" value="${requestScope.bookinfo.sales}"/></td>
						<td><input name="stock" type="text" value="${requestScope.bookinfo.stock}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>

				</table>
			</form>
			
	
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