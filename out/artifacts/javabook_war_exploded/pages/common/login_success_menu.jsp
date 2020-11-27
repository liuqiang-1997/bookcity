<%--
  Created by IntelliJ IDEA.
  User: liuqiang
  Date: 2020/11/13
  Time: 2:32 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临贝壳书城</span>
    <a href="orderServlet?action=myOrders">我的订单</a>
    <a href="pages/cart/cart.jsp">购物车</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回商城</a>
</div>
