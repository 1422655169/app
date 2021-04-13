<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>活动</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/css/main.css"/> ">

</head>
<body>
<div class="container">
    <%--  模糊查询  --%>
    <form action="<c:url value="/user/activity/selectall"/>">
        活动主题:<input type="text" placeholder="请输入活动主题" name="subject"/>
        房屋价格:<input type="text" placeholder="请输入活动消费最低价格" name="lowprice"/>-
        <input type="text" placeholder="请输入活动消费最高价格" name="highprice"/>
        <input type="hidden" name = "pageNo" value="1"/>
        <input type="submit" value="搜索1"/>
    </form>



    <table class="table table-bordered">
        <tr>
            <td><a href="<c:url value="/view/activity/add.jsp"/>">添加活动</a></td>
        </tr>
    </table>
    <table class="table table-bordered">
        <tr>
            <td>序号</td>
            <td>活动时间</td>
            <td>活动主题</td>
            <td>活动内容</td>
            <td>活动地址</td>
            <td>活动消费</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list}" var="a">
            <tr>
                <td>${a.aid}</td>
                <td>${a.atime}</td>
                <td>${a.asubject}</td>
                <td>${a.aintr}</td>
                <td>${a.aaddress}</td>
                <td>${a.aprice}</td>
                <td><a href="<c:url value="/user/activity/update?aid=${a.aid}"/> "><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="#" onclick="deleteActivityById(${a.aid})"><span class="glyphicon glyphicon-trash"></span></a>
                </td>
            </tr>
        </c:forEach>
    </table>
        每页${pageUtil.pageSize }记录|总共${pageUtil.total }条记录|
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a class="${pageUtil.pageNo ==1?"disabled":""}" href="<c:url value="/user/activity/selectall?pageNo=${pageUtil.pageNo -1}&lowprice=${map.lowprice}&highprice=${map.highprice}&subject=${map.subject}"/>" aria-label="Previous">
                        <span aria-hidden="true">上一页</span>
                    </a>
                </li>
                <c:forEach var="i" begin="1" end="${pageUtil.getPageCount()}" step="1">
                    <li class ="paginate_button ${i== pageUtil.pageNo? "active":""}"><a href="#">${i}</a></li>
                </c:forEach>
                <li>
                    <a class="${pageUtil.pageNo==pageUtil.pageCount? "disabled":""}" href="<c:url value="/user/activity/selectall?pageNo=${pageUtil.pageNo +1}&lowprice=${map.lowprice}&highprice=${map.highprice}&subject=${map.subject}"/>" aria-label="Next">
                        <span aria-hidden="true">下一页</span>
                    </a>
                </li>
            </ul>
        </nav>
        页码${pageUtil.pageNo } / ${pageUtil.pageCount }


<%--    每页${pageUtil.pageSize }记录|总共${pageUtil.total }条记录|--%>
<%--    <nav aria-label="Page navigation">--%>
<%--        <ul class="pagination">--%>
<%--            <li>--%>
<%--                <a href="<c:url value="/user/activity/selectall?page=${pageUtil.pageNo -1}&keyword=${keyword}"/>" aria-label="Previous">--%>
<%--                    <span aria-hidden="true">&laquo;</span>--%>
<%--                </a>--%>
<%--            </li>--%>
<%--            <c:forEach var="i" begin="1" end="${pageUtil.getPageCount()}" step="1">--%>
<%--                <li--%>
<%--                        <c:if test="${pageUtil.getPageNo() == i}">--%>
<%--                            class="active"--%>
<%--                        </c:if>--%>
<%--                ><a href="<c:url value="/user/activity/selectall?page=${i}&keyword=${keyword}"/>">${i}</a></li>--%>
<%--            </c:forEach>--%>
<%--            <li>--%>
<%--                <a href="<c:url value="/user/activity/selectall?page=${pageUtil.pageNo +1}&keyword=${keyword}"/>" aria-label="Next">--%>
<%--                    <span aria-hidden="true">&raquo;</span>--%>
<%--                </a>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--    </nav>--%>
<%--    页码${pageUtil.pageNo } / ${pageUtil.pageCount }--%>
</div>
<script type="text/javascript">
    function deleteActivityById(id) {
        if (confirm("是否删除?")) {
            window.location = "http://localhost:8080/Crmproject_war_exploded/user/activity/deleteone?aid="+id;
        }
        return false;
    }
</script>
</body>
</html>
