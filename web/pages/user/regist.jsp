<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>贝壳书城会员注册页面</title>
<%--<!--	base标签永远固定相对路径跳转的结果-->--%>
<%--	<base href="http://localhost:8088/javabook/">--%>
<%--    <link type="text/css" rel="stylesheet" href="static/css/style.css" >--%>
<%--<!--	引入jqurey文件-->--%>
<%--	<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>--%>
	<%--	静态包含base标签，css样式，jQuery文件--%>
	<%@include file="/pages/common/head_info.jsp"%>
	<script type="text/javascript">


		// 页面加载完成之后
		$(function (){


			// 给验证码图片绑定单击刷新事件
			$("#code_img").click(function (){

				// 事件响应的funct函数中，this对象表示当前正在响应事件的dom对象，src属性表示验证码图片的路径，可读可写
				this.src="${basePath}kaptcha.jpg?=" + new Date();
			})


					//给注册绑定单击事件
			$("#sub_btn").click(function (){
				//验证用户名：必须由字母数字下划线组成，长度5-12
				//1。获取用户名输入框的内容
				var usernameText = $("#username").val();
				//2。创建正则表达式对象
				var usernamePatt = /^\w{5,12}$/;
				//3。使用test方法验证
				if(!usernamePatt.test(usernameText)){
					//4。提示用户结果
					$("span.errorMsg").text("用户名不合法");

					return false;
				}

				//验证密码：必须由字母数字下划线组成，长度5-12
				//1。获取用户名输入框的内容
				var passwordText = $("#password").val();
				//2。创建正则表达式对象
				var passwordPatt = /^\w{5,12}$/;
				//3。使用test方法验证
				if(!passwordPatt.test(passwordText)){
					//4。提示用户结果
					$("span.errorMsg").text("密码不合法");

					return false;
				}
				//验证确认密码：和密码相同
				//1。获取密码内容
				var repwdText = $("#repwd").val();
				//2。和密码相比较
				if(repwdText != passwordText){
					//3。提示用户
					$("span.errorMsg").text("密码确认失败！");
					return false;
				}

				//邮箱验证：***@**.com
				//1.获取邮箱内容
				var emailText = $("#email").val();
				//2。创键正则表达式对象
				var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
				//3。使用test 方法验证是否合法
				if(!emailPatt.test(emailText)){
					//4。提示用户
					$("span.errorMsg").text("邮箱格式不合法");
					return false;
				}

				//验证码
				var codeText = $("#code").val();
				//去除验证码前后空格
				// alert(codeText);
				codeText = $.trim(codeText);
				// alert(codeText);
				if(codeText == null || codeText == ""){
					//提示用户
					$("span.errorMsg").text("验证码不合法");
					return false;
				}
				$("span.errorMsg").text(); // 验证成功取消页面不合法提示
				alert("注册成功！");
			});
		});

	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">贝壳书城</span>

		</div>
		
			<div class="login_banners">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册贝壳书城会员</h1>
								<span class="errorMsg">
<%--									<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username"
<%--									value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"--%>
											value="${requestScope.username}"
									/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email"
<%--									value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"--%>
											value="${requestScope.email}"
									/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" name="code" style="width: 80px;" id="code"/>
									<img id="code_img" alt="" src="kaptcha.jpg" style="float: right;
									margin-right: 40px;width:
									150px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
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