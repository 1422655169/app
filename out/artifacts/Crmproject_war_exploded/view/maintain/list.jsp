<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>公寓修缮记录</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <table class="table table-bordered">
        <tr>
            <td><a href="<c:url value="/view/maintain/add.jsp"/>">添加公寓修缮记录信息</a></td>
        </tr>
    </table>
    <table class="table table-bordered">
        <tr>
            <td>序号</td>
            <td>房屋号</td>
            <td>后勤人员号</td>
            <td>维修日期</td>
            <td>维修结果</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list}" var="m">
            <tr>
                <td>${m.mid}</td>
                <td>${m.mhid}</td>
                <td>${m.mloid}</td>
                <td>${m.mtime}</td>
                <td>${m.mresult}</td>
                <td><a href="<c:url value="/user/maintain/update?mid=${m.mid}"/>"><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="#" onclick="deleteMaintainById(${m.mid})"><span class="glyphicon glyphicon-trash"></span></a>
                </td>
            </tr>
        </c:forEach>
    </table>每页${pageUtil.pageSize }记录|总共${pageUtil.total }条记录|
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a href="<c:url value="/user/maintain/selectall?page=${pageUtil.pageNo -1}&keyword=${keyword}"/>" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach var="i" begin="1" end="${pageUtil.getPageCount()}" step="1">
                <li
                        <c:if test="${pageUtil.getPageNo() == i}">
                            class="active"
                        </c:if>
                ><a href="<c:url value="/user/maintain/selectall?page=${i}&keyword=${keyword}"/>">${i}</a></li>
            </c:forEach>
            <li>
                <a href="<c:url value="/user/maintain/selectall?page=${pageUtil.pageNo +1}&keyword=${keyword}"/>" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
    页码${pageUtil.pageNo } / ${pageUtil.pageCount }
</div>
<script type="text/javascript">
    function deleteMaintainById(id) {
        if (confirm("是否删除?")) {
            window.location = "http://localhost:8080/Crmproject_war_exploded/user/maintain/deleteone?mid="+id;
        }
        return false;
    }
</script>
</body>
</html>
