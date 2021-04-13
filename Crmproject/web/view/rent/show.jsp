<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>房租信息</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="<c:url value="/user/rent/selectall"/>">
        登录名称:<input type="text" name="rlname" placeholder="请输入租户姓名">-
        真实姓名:<input type="text" name="raddress" placeholder="请输入房屋地址">-
        <input type="hidden" name="pageNo" value="1">
        <input type="submit" value="搜索">
    </form>
    <table>
        <tr>
            <td><a href="<c:url value="/view/rent/add.jsp"/>">添加房租信息</a></td>
        </tr>
    </table>
    <table class="table table-bordered">
        <tr>
            <td>序号</td>
            <td>房屋号</td>
            <td>租户号</td>
            <td>缴纳房租</td>
            <td>付款时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${rent}" var="r" >
            <tr>
                <td>${r.rid}</td>
                <td>${r.rhid}</td>
                <td>${r.rlid}</td>
                <td>${r.rprice}</td>
                <td>${r.rpayTime}</td>
                <td><a href="<c:url value="/user/rent/update?rid=${r.rid}"/>"><span class="glyphicon glyphicon-pencil"></span></a>|
                    <a href="#" onclick="deleteRentById(${r.rid})"><span class="glyphicon glyphicon-trash"></span></a>
                </td>
            </tr>
        </c:forEach>
    </table>每页${pageUtil.pageSize }记录|总共${pageUtil.total }条记录|
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a href="<c:url value="/user/rent/selectall?page=${pageUtil.pageNo -1}&keyword=${keyword}"/>" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach var="i" begin="1" end="${pageUtil.getPageCount()}" step="1">
                <li
                        <c:if test="${pageUtil.getPageNo() == i}">
                            class="active"
                        </c:if>
                ><a href="<c:url value="/user/rent/selectall?page=${i}&keyword=${keyword}"/>">${i}</a></li>
            </c:forEach>
            <li>
                <a href="<c:url value="/user/rent/selectall?page=${pageUtil.pageNo +1}&keyword=${keyword}"/>" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
    页码${pageUtil.pageNo } / ${pageUtil.pageCount }
</div>
<script type="text/javascript">
    function deleteRentById(id) {
        if (confirm("是否删除?")) {
            window.location = "http://localhost:8080/Crmproject_war_exploded/user/rent/deleteone?rid="+id;
        }
        return false;
    }
</script>
</body>
</html>
