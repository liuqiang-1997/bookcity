<%--
  Created by IntelliJ IDEA.
  User: liuqiang
  Date: 2020/11/23
  Time: 5:44 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>贝壳书城</title>
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


            $("#sub_btn").click(function (){

                //验证密码：必须由字母数字下划线组成，长度5-12
                //1。获取用户名输入框的内容
                var passwordText = $("#password").val();
                //验证确认密码：和密码相同
                //1。获取密码内容
                var rinpwdText = $("#finpwd").val();
                //2。和密码相比较
                if(rinpwdText != passwordText){
                    //3。提示用户
                    $("span.errorMsg").text("密码确认失败！请重新输入！");
                    return false;
                }
                $("span.errorMsg").text(); // 验证成功取消页面不合法提示
                alert("密码修改成功！返回重新登录！！");
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
        <span class="login_word">修改密码</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>贝壳书城会员</h1>

                </div>
                <div class="msg_cont">
                    <b></b>
                    <%--								<span class="errorMsg">请输入用户名和密码</span>--%>
                    <span class="errorMsg">
          ${ empty requestScope.msg?"请确认两次密码输入相同":requestScope.msg}

								</span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="updateUserPassword">
                        <input type="hidden" name="userId" value="${sessionScope.user.id}">
                        <label>新置密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="newpwd" id="password" />
                        <br />
                        <br />
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="finpwd" id="finpwd" />
                        <br />
                        <br />

                        <input type="submit" value="确认修改" id="sub_btn" />
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
