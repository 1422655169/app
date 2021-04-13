<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>后勤人员管理</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/main.css"/>" rel="stylesheet">

</head>
<body>
<div class="container">
    <%--  模糊查询  --%>
    <form action="<c:url value="/user/logi/selectall"/>">
        姓名:<input type="text" placeholder="请输入姓名" name="loname"/>-
        <input type="hidden" name = "pageNo" value="1"/>
        <input type="submit" value="搜索1"/>
    </form>
    <table class="table table-bordered">
        <tr>
            <td><a href="<c:url value="/view/logi/add.jsp"/>">添加后勤人员信息</a></td>
        </tr>
    </table>
    <table class="table table-bordered">
        <tr>
            <td>序号</td>
            <td>姓名</td>
            <td>身份证号</td>
            <td>电话</td>
            <td>性别</td>
            <td>添加日期</td>
            <td>价格</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list}" var="lo">
            <tr>
                <td>${lo.loid}</td>
                <td>${lo.loname}</td>
                <td>${lo.loidCard}</td>
                <td>${lo.lotel}</td>
                <td>
                    <c:if test="${lo.losex == 1}">
                        男
                    </c:if>
                    <c:if test="${lo.losex == 2}">
                        女
                    </c:if>
                </td>
                <td>${lo.loaddTime}</td>
                <td>${lo.losalary}</td>
                <td><a href="<c:url value="/user/logi/update?loid=${lo.loid}"/>"><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="#" onclick="deleteLogiById(${lo.loid})"><span class="glyphicon glyphicon-trash"></span></a>
                </td>
            </tr>
        </c:forEach>
    </table> 每页${pageUtil.pageSize }记录|总共${pageUtil.total }条记录|
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a class="${pageUtil.pageNo == 1 ?"disabled":""}" href="<c:url value="/user/logi/selectall?pageNo=${pageUtil.pageNo -1}&keyword=${keyword}&loname=${map.loname}"/>" aria-label="Previous">
                        <span aria-hidden="true">上一页</span>
                    </a>
                </li>
                <c:forEach var="i" begin="1" end="${pageUtil.getPageCount()}" step="1">
                    <li
                            <c:if test="${pageUtil.getPageNo() == i}">
                                class="active"
                            </c:if>
                    ><a href="<c:url value="/user/logi/selectall?pageNo=${i}&keyword=${keyword}&loname=${map.loname}&loname=${map.loname}"/>">${i}</a></li>
                </c:forEach>
                <li>
                    <a class = "${pageUtil.pageNo == pageUtil.pageCount ? "disabled":""}" href="<c:url value="/user/logi/selectall?pageNo=${pageUtil.pageNo +1}&keyword=${keyword}&loname=${map.loname}"/>" aria-label="Next">
                        <span aria-hidden="true">下一页</span>
                    </a>
                </li>
            </ul>
        </nav>
        页码${pageUtil.pageNo } / ${pageUtil.pageCount }
</div>
<script type="text/javascript">
    function deleteLogiById(id) {
        if (confirm("是否删除?")) {
            window.location = "http://localhost:8080/Crmproject_war_exploded/user/logi/delete?loid="+id;
        }
    }
</script>
</body>
</html>
