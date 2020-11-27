<%--
  Created by IntelliJ IDEA.
  User: liuqiang
  Date: 2020/11/13
  Time: 2:37 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--动态获取base标签值--%>
<%
    String basePath = request.getScheme()  //获取请求协议
            + "://"
            + request.getServerName()  //获取服务器ip
            +":"
            +request.getServerPort()  //获取端口号
            +request.getContextPath()  //获取工程路径
            +"/";

    pageContext.setAttribute("basePath",basePath);

%>

<%--<!--	base标签永远固定相对路径跳转的结果-->--%>
<%--<base href="http://localhost:8088/javabook/">--%>
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<%--<!--	引入jqurey文件-->--%>
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>