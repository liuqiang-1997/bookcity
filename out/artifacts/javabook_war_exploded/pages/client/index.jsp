<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%--	静态包含base标签，css样式，jQuery文件--%>
    <%@include file="/pages/common/head_info.jsp"%>
    <script type="text/javascript">
        $(function (){

            // 给加入购物车按钮绑定事件
            $("button.addToCart").click(function (){
                var bookId = $(this).attr("bookId")
                location.href="http://localhost:8088/javabook/cartServlet?action=addItem&id="+bookId;
            });
        });
    </script>
</head>
<body >

<div id="header" >
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">贝壳书城</span>
    <div>
<%--        如果用户未登陆，显示登陆注册菜单--%>
        <c:if test="${empty sessionScope.user.username}">
            <a href="pages/user/login.jsp">登录</a>
            <a href="pages/user/regist.jsp">注册</a>
            <a href="pages/cart/cart.jsp">购物车</a>

        </c:if>
<%--    如果用户以登陆，显示登陆后的个人信息--%>
        <c:if test="${not empty  sessionScope.user}">
            <span>欢迎
                <span class="um_span"><a href="pages/user/login_success.jsp">${sessionScope.user.username}</a></span>
                光临贝壳书城</span>
            <a href="orderServlet?action=myOrders">我的订单</a>
            <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
            <a href="pages/cart/cart.jsp">购物车</a>
        </c:if>

        <c:if test="${  sessionScope.user.id == 1 }">
        <a href="pages/manager/manager.jsp">后台管理</a>
        </c:if>


    </div>
</div>
<div id="main" >
    <div id="book">
        <div class="book_cond">
            <form action="client/bookServlet" method="get">
                <input type="hidden" name="action" value="pageByPrice">
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询" />
            </form>
        </div>
        <div style="text-align: center">
            <c:if test="${empty sessionScope.user}">
                <div class="msg_cont">
                    <span class="errorMsg"><p align="center">"注册登录后才能正常逛书城啊"</p></span>
                </div>
            </c:if>
            <c:if test="${empty sessionScope.cart.items}">
                <span style="color: red">您的购物车空空如也！！！</span>
            </c:if>

            <c:if test="${not empty sessionScope.cart.items}">
            <div>
                <span>您的购物车中有${sessionScope.cart.totalCount}件商品</span><br/>
                您刚刚将<span style="color: red">${sessionScope.lastName}</span>加入到了购物车中
            </div>
            </c:if>
        </div>

        <c:forEach items="${requestScope.page.items}" var="book">
        <div class="b_list">
            <div class="img_div">
                <img class="book_img" alt="" src="${book.imgPath}" />
            </div>
            <div class="book_info">
                <div class="book_name">
                    <span class="sp1">书名:</span>
                    <span class="sp2">《${book.name}》</span>
                </div>
                <div class="book_author">
                    <span class="sp1">作者:</span>
                    <span class="sp2">${book.author}</span>
                </div>
                <div class="book_price">
                    <span class="sp1">价格:</span>
                    <span class="sp2">${book.price}</span>
                </div>
                <div class="book_sales">
                    <span class="sp1">销量:</span>
                    <span class="sp2">${book.sales}</span>
                </div>
                <div class="book_amount">
                    <span class="sp1">库存:</span>
                    <span class="sp2">${book.stock}</span>
                </div>
                <div class="book_add">
                    <button bookId="${book.id}" class="addToCart">加入购物车</button>

                    <button><a href="remarkServlet?action=queryRemarkByBookId&bookId=${book.id}"> 书评</a> </button>
                </div>


            </div>
        </div>
        </c:forEach>

    </div>

    <%@include file="/pages/common/page_nav.jsp"%>

</div>

<%--静态包含页脚信息--%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>