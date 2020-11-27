<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>贝壳书城注册页面</title>
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
</style>
</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="static/img/logo.gif" >
				<span class="wel_word">贝壳书城</span>
			<%--			   静态包含登录成功之后的菜单--%>
			<%@include file="/pages/common/login_success_menu.jsp"%>

		</div>

		<div class="login_banners">

			<div id="l_content">
				<span class="login_word">个人主页</span>
			</div>


			<div id="content">
				<div class="login_form">
					<div class="login_box">

						<div class="book_info">
							<div class="book_name">
								<span class="sp1">用户id:</span>
								<span class="sp2">${sessionScope.user.id}</span>
							</div><br/>
							<div class="book_name">
								<span class="sp1">用户名:</span>
								<span class="sp2">${sessionScope.user.username}</span>
							</div><br/>
							<div class="book_author">
								<span class="sp1">密码:</span>
								<span class="sp2">
							<a href="pages/user/updatePwd.jsp">修改密码</a></span>
							</div><br/>
							<div class="book_price">
								<span class="sp1">我的书评</span>
								<span class="sp2">
							<a href="remarkServlet?action=queryRemarkByObserver&observer=${sessionScope.user.id}">查看我的书评
						</a></span>
							</div><br/>
							<div class="book_sales">
								<span class="sp1">我的回复:</span>
								<span class="sp2">
					<a href="replyServlet?action=queryReplyByreplyUser&replyUser=${sessionScope.user.id}">查看我的回评
						</a></span>
							</div><br/>
							<div class="book_sales">
								<span class="sp1">回复我的:</span>
								<span class="sp2">
					<a href="replyServlet?action=queryReplyByremarkUser&remarkUser=${sessionScope.user.id}">查看回评我的
						</a></span>
							</div><br/>


						</div>




					</div>

				</div>
			</div>
		</div>


		</div>

<%--		<div id="bottom">--%>
<%--			<span>--%>
<%--				贝壳田园.Copyright &copy;2020--%>
<%--			</span>--%>
<%--		</div>--%>
		<%--静态包含页脚信息--%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>