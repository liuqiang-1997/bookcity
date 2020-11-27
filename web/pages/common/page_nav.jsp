<%--
  Created by IntelliJ IDEA.
  User: liuqiang
  Date: 2020/11/15
  Time: 6:21 下午
  To change this template use File | Settings | File Templates.
--%>
<%--分页条模块--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">

    <c:if test="${requestScope.page.pageNo >1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>
    <%--            页码输出的开始--%>
    <c:choose>
        <%--			情况一：总页码小于5 ，页码范围：1-总页码--%>
        <c:when test="${requestScope.page.pageTotal<5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageTotal}"/>
        </c:when>
        <%--				情况二：总页码大于5--%>
        <c:when test="${requestScope.page.pageTotal>5}">
            <c:choose>
                <%--						2.1 当前页码为前面三个：1，2，3的情况，页码范围：1-5--%>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>

                <%--				2.2 当前页码为最后三个：8，9，10的情况，页码范围：总页码减4 -总页码--%>
                <c:when test="${requestScope.page.pageNo >requestScope.page.pageTotal-3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}"/>
                </c:when>
                <%--				2.3 4，5，6，7 页码范围：当前页码减二 - 当前页码加二--%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo-2}"/>
                    <c:set var="end" value="${requestScope.page.pageNo+2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>


    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == requestScope.page.pageNo}">
            [${i}]
        </c:if>
        <c:if test="${i != requestScope.page.pageNo}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>


    <%--			页码输出的结束--%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
    <script type="text/javascript">
        $(function(){
            //跳到指定的页码
            $("#searchPageBtn").click(function (){

                var pageNo = $("#pn_input").val();

                if(pageNo<1 || pageNo>${requestScope.page.pageTotal}){

                    alert("页码错误！")
                }else{
                    // js中提供了location地址栏对象，href属性可获取浏览器地址栏中的地址(该属性可读可写(可赋值))
                    location.href="${pageScope.basePath}${requestScope.page.url}&pageNo="+pageNo;

                }


            });

        });


    </script>
</div>