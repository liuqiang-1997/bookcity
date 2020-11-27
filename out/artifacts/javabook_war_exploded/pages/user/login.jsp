<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>贝壳书城登录页面</title>
<%--	<base href="http://localhost:8088/javabook/">--%>
<%--<link type="text/css" rel="stylesheet" href="static/css/style.css" >--%>
<%--	<!--	引入jqurey文件-->--%>
<%--	<!--	引入jqurey文件-->--%>
<%--	<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>--%>
	<%--	静态包含base标签，css样式，jQuery文件--%>
	<%@include file="/pages/common/head_info.jsp"%>
	<script type="text/javascript">
		// 页面加载完成之后
		$(function (){
			//给注册绑定单击事件
			$("#sub_btn").click(function (){

				// alert("登陆成功！");
			});
		});

	</script>


</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">贝壳书城</span>
		</div>
		
			<div class="login_banners">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>贝壳书城会员</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
<%--								<span class="errorMsg">请输入用户名和密码</span>--%>
								<span class="errorMsg">
<%--									<%=request.getAttribute("msg")==null?"请输入用户名与密码":request.getAttribute("msg")%>--%>
									${ empty requestScope.msg?"请输入用户名和密码":requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="login">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username"
<%--									value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"--%>
											value="${requestScope.username}"
									/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
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