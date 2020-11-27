
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"  language="java" %>
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
    <span class="wel_word">图书评论</span>
<%--    <%@include file="/pages/common/manager_menu.jsp"%>--%>
    <c:if test="${not empty sessionScope.user}">
   <div>

    <a href="index.jsp">商城</a>
   </div>
    </c:if>
    <c:if test="${empty sessionScope.user}">
    <div>
    <a href="pages/user/login.jsp">登录</a>
    <a href="pages/user/regist.jsp">注册</a>
    </div>
    </c:if>
</div>

<c:if test="${empty sessionScope.user}">

<div class="msg_cont">
    <p align="center">"请注册登录后再来留下您的精彩书评"</p>
</div>
</c:if>

<div id="main" >

    <c:if test="${empty requestScope.remarks}">
        <p align="center">这本书还没有精彩书评，快来留下您的精彩评价吧</p>
    </c:if>

        <div class="comments">
    <div >
<%--        <c:forEach items="${requestScope.remarkUserId}" var="remarkuser">--%>
<%--            <p class="comment-text">${remarkuser.username}${remarkuser.id}</p>--%>
<%--        </c:forEach>--%>
        <div class="bottom-comment">

<%--            </div>--%>
            <c:forEach items="${requestScope.remarks}" var="remark">
                <c:if test="${remark.observer == null}" >
                    <h1>已注销用户的书评</h1>
                </c:if>


                    <c:if test="${not empty remark.observer}" >
                   <h1>用户[${remark.observer}]的书评:</h1>
                    </c:if>
                <div class="comment-wrap">
                    <div class="comment-block">
                        <p class="comment-text">${remark.remark}</p>
                        <div class="bottom-comment">
                            <div class="comment-date">${remark.remarkTime}</div>
                            <ul class="comment-actions">
                                <c:if test="${not empty sessionScope.user}">
                                    <c:if test="${remark.observer != null}" >
                                <button>
                                    <a class="complain"
                         href="replyServlet?action=queryReplyByRemarkId&observer=${remark.observer}&remarkId=${remark.id}">回复
                                    </a></button>
                                     </c:if>
                                </c:if>
                            </ul>
                        </div>
                    </div>
                </div>

            </c:forEach>
            <hr>
            <div class="comment-wrap">


                <div class="comment-block">
                    <form action="remarkServlet" method="post">
                        <input type="hidden" name="action" value="addRemark">
                        <input type="hidden" name="bookId" value=${param.get("bookId")}>
                        <input type="hidden" name="observer" value="${sessionScope.user.id}">

<%--                        <input type="hidden" name="remarkTime"--%>
<%--                               value="<%= new SimpleDateFormat("yyyy-MM-dd-HH:mm").format(new Date())%>" >--%>
                        <textarea name="remark" id="" cols="30" rows="3" placeholder="发表我的书评"></textarea>
                        <button> <input type="submit" value="评论"></button>

                    </form>
                </div>
            </div>
        </div>


</div>
        </div>
</div>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>