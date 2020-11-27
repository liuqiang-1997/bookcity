<%--
  Created by IntelliJ IDEA.
  User: liuqiang
  Date: 2020/11/22
  Time: 11:32 上午
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>贝壳书评</title>
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
    <span class="wel_word">我的评论</span>
<%--    <%@include file="/pages/common/manager_menu.jsp"%>--%>
    <div>
        <a href="pages/user/login_success.jsp">我的主页</a>
    </div>
</div>

<div id="main" >

    <div class="comments">
        <c:forEach items="${requestScope.observer_comment}" var="remark">


                    <h1>书号[${remark.bookId}]的评论:</h1>
            <div class="comment-wrap">
                <div class="comment-block">
                    <p class="comment-text">${remark.remark}</p>
                    <div class="bottom-comment">
                        <div class="comment-date">${remark.remarkTime}</div>
                        <ul class="comment-actions">
                            <button>
                                <a class="complain"
                                   href="remarkServlet?action=deleteRemark&observer=${remark.observer}&remarkId=${remark.id}">删除
                                </a></button>
                        </ul>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>


</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
