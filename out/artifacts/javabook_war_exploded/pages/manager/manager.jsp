<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
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
			<span class="wel_word">后台管理系统</span>
		<%--			<div>--%>
		<%--				<a href="pages/manager/book_manager.html">图书管理</a>--%>
		<%--				<a href="pages/manager/order_manager.html">订单管理</a>--%>
		<%--				<a href="index.html">返回商城</a>--%>
		<%--			</div>--%>
		<%--		静态包含manager管理模块的菜单--%>
		<%@include file="/pages/common/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<h1>欢迎管理员进入后台管理系统</h1>
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