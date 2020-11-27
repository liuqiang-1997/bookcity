<%--
  Created by IntelliJ IDEA.
  User: liuqiang
  Date: 2020/11/20
  Time: 11:24 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书评回复</title>
    <%@include file="/pages/common/head_info.jsp"%>
    <style type="text/css">
        html,
        body {
            background-color: #f0f2fa;
            font-family: "PT Sans", "Helvetica Neue", "Helvetica", "Roboto", "Arial", sans-serif;
            color: #555f77;
            -webkit-font-smoothing: antialiased;
        }
        input,
        textarea {
            outline: none;
            border: none;
            display: block;
            margin: 0;
            padding: 0;
            -webkit-font-smoothing: antialiased;
            font-family: "PT Sans", "Helvetica Neue", "Helvetica", "Roboto", "Arial", sans-serif;
            font-size: 1rem;
            color: #555f77;
        }
        input::-webkit-input-placeholder,
        textarea::-webkit-input-placeholder {
            color: #ced2db;
        }
        input::-moz-placeholder,
        textarea::-moz-placeholder {
            color: #ced2db;
        }
        input:-moz-placeholder,
        textarea:-moz-placeholder {
            color: #ced2db;
        }
        input:-ms-input-placeholder,
        textarea:-ms-input-placeholder {
            color: #ced2db;
        }
        p {
            line-height: 1.3125rem;
        }
        .comments {
            margin: 2.5rem auto 0;
            max-width: 60.75rem;
            padding: 0 1.25rem;
        }
        .comment-wrap {
            margin-bottom: 1.25rem;
            display: table;
            width: 100%;
            min-height: 5.3125rem;
        }
        .photo {
            padding-top: 0.625rem;
            display: table-cell;
            width: 3.5rem;
        }
        .photo .avatar {
            height: 2.25rem;
            width: 2.25rem;
            border-radius: 50%;
            background-size: contain;
        }
        .comment-block {
            padding: 1rem;
            background-color: #fff;
            display: table-cell;
            vertical-align: top;
            border-radius: 0.1875rem;
            box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.08);
        }
        .comment-block textarea {
            width: 100%;
            max-width: 100%;
        }
        .comment-text {
            margin-bottom: 1.25rem;
        }
        .bottom-comment {
            color: #acb4c2;
            font-size: 0.875rem;
        }
        .comment-date {
            float: left;
        }
        .comment-actions {
            float: right;
        }
        .comment-actions li {
            display: inline;
        }
        .comment-actions li.complain {
            padding-right: 0.625rem;
            border-right: 1px solid #e1e5eb;
        }
        .comment-actions li.reply {
            padding-left: 0.625rem;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">书评回复</span>
<%--    <%@include file="/pages/common/manager_menu.jsp"%>--%>
    <div>

        <a href="index.jsp">商城</a>
    </div>
</div>

<div id="main" >

    <div class="comments">
<c:forEach items="${requestScope.replys}" var="reply">

                <h1>用户[${reply.replyUser}]对用户[${reply.remarkUser}]的回复:</h1>

            <div class="comment-wrap">
                <div class="comment-block">
                <p class="comment-text">${reply.reply}</p>
                <div class="bottom-comment">
                    <div class="comment-date">${reply.replyTime}</div>

                </div>
            </div>
        </div>
</c:forEach>
<hr/>
        <div class="comment-wrap">
            <div class="comment-block">
                <form action="replyServlet" method="post">
                    <input type="hidden" name="action" value="addReply">
                    <input type="hidden" name="replyUser" value="${sessionScope.user.id}">
                    <input type="hidden" name="remarkId" value="${param.get("remarkId")}">
                    <input type="hidden" name="remarkUser" value="${param.get("observer")}">


                    <textarea name="reply" id="" cols="30" rows="3" placeholder="发表我的回复"></textarea>
                    <button><input type="submit" value="回复"/></button>
                </form>
            </div>
        </div>



    </div>

</div>


<%@include file="/pages/common/footer.jsp"%>
</body>
</html>