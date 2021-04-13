<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>租户信息</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/css/main.css"/> ">
</head>
<body>
<div class="container">
    <%--  模糊查询 --%>
    <form action="<c:url value="/user/lessee/selectall"/>" method="get">
        租户姓名<input type="text" placeholder="请输入租户姓名" name="lname">
        <input type="hidden" name="pageNo" value="1">
        <input type="submit" value="搜索">
    </form>
    <table class="table table-bordered">
        <tr>
            <td><a href="<c:url value="/view/lesseee/add.jsp"/>">添加租户信息</a></td>
        </tr>
    </table>
    <table class="table table-bordered">
        <tr>
            <td>序号</td>
            <td>租户姓名</td>
            <td>租户电话</td>
            <td>租户性别</td>
            <td>租户籍贯</td>
            <td>租户身份证号</td>
            <td>租户添加时间</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${list}" var="l">
            <tr>
                <td>${l.lid}</td>
                <td>${l.lname}</td>
                <td>${l.ltel}</td>
                <td>
                    <c:if test="${l.lsex == 1}">
                        男
                    </c:if>
                    <c:if test="${l.lsex == 2}">
                        女
                    </c:if>
                </td>
                <td>${l.lnp}</td>
                <td>${l.lidCard}</td>
                <td>${l.laddTime}</td>
                <td colspan="2"><a href="<c:url value="/user/lessee/update?lid=${l.lid}"/>"><span class="glyphicon glyphicon-pencil"></span></a>|
                    <a href="#" onclick="deleteLessee(${l.lid})"><span class="glyphicon glyphicon-trash"></span></a>
                </td>
            </tr>
        </c:forEach>
    </table>
        每页${pageUtil.pageSize }记录|总共${pageUtil.total }条记录|
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a class="${pageUtil.pageNo ==1?"disabled":""}" href="<c:url value="/user/lessee/selectall?pageNo=${pageUtil.pageNo -1}&lname=${map.lname}"/>" aria-label="Previous">
                        <span aria-hidden="true">上一页</span>
                    </a>
                </li>
                <c:forEach var="i" begin="1" end="${pageUtil.getPageCount()}" step="1">
                    <li class ="paginate_button ${i== pageUtil.pageNo? "active":""}"><a href="#">${i}</a></li>
                </c:forEach>
                <li>
                    <a class="${pageUtil.pageNo==pageUtil.pageCount? "disabled":""}" href="<c:url value="/user/lessee/selectall?pageNo=${pageUtil.pageNo +1}&lname=${map.lname}"/>" aria-label="Next">
                        <span aria-hidden="true">下一页</span>
                    </a>
                </li>
            </ul>
        </nav>
        页码${pageUtil.pageNo } / ${pageUtil.pageCount }
</div>
<script type="text/javascript">
    function deleteLessee(id) {
        if(confirm("是否删除?")) {
            window.location = "http://localhost:8080/Crmproject_war_exploded/user/lessee/deleteone?lid="+id;
        }
        return false;
    }
</script>
</body>
</html>
