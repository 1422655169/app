<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>角色管理</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
<%--    <form action="<c:url value="/user/role/search"/>">--%>
<%--        职位&nbsp;&nbsp;<input type="text" name="keyword" placeholder="关键字">--%>
<%--        <input type="hidden" name="pageNo" value="1">&nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--        <input type="submit" value="搜索">--%>
<%--    </form>--%>
    <table class="table table-bordered">
        <tr>
            <td><a href="<c:url value="/view/role/add.jsp"/>">添加角色信息</a></td>
        </tr>
    </table>
    <table class="table table-bordered">
        <tr>
            <td>序号</td>
            <td>职位</td>
            <td>权限</td>
            <td>添加日期</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list}" var="ro">
            <tr>
                <td>${ro.roid}</td>
                <td>${ro.roname}</td>
                <td>${ro.rodesc}</td>
                <td>${ro.roaddTime}</td>
                <td><a href="<c:url value="/user/role/update?roid=${ro.roid}"/>"><span class="glyphicon glyphicon-pencil"></span></a>|
                <a href="#" onclick="deleteRoleById(${ro.roid})"><span class="glyphicon glyphicon-trash"></span></a>
                </td>
            </tr>
        </c:forEach>
    </table>
    每页${pageUtil.pageSize }记录|总共${pageUtil.total }条记录|
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a href="<c:url value="/user/role/selectall?page=${pageUtil.pageNo -1}&keyword=${keyword}"/>" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach var="i" begin="1" end="${pageUtil.getPageCount()}" step="1">
                <li
                        <c:if test="${pageUtil.getPageNo() == i}">
                            class="active"
                        </c:if>
                ><a href="<c:url value="/user/role/selectall?page=${i}&keyword=${keyword}"/>">${i}</a></li>
            </c:forEach>
            <li>
                <a href="<c:url value="/user/role/selectall?page=${pageUtil.pageNo +1}&keyword=${keyword}"/>" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
    页码${pageUtil.pageNo } / ${pageUtil.pageCount }
</div>
<script type="text/javascript">
    function deleteRoleById(id) {
            if (confirm("是否删除?")) {
                window.location = "http://localhost:8080/Crmproject_war_exploded/user/role/deleteone?roid="+id;
            }
            return false;
    }
</script>
</body>
</html>
