<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>公寓系统</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="<c:url value="/user/user/selectall"/>">
        登录名称:<input type="text" name="uname" placeholder="请输入登录名称">-
        真实姓名:<input type="text" name="rname" placeholder="请输入登录名称">-
        <input type="hidden" name="pageNo" value="1">
        <input type="submit" value="搜索">
    </form>

    <hr>
    <table class="table table-bordered">
        <tr>
            <td>
                <c:forEach items="${auths}" var="a">
                <c:if test="${a.aid == 1}">
                <a href="<c:url value="/view/user/add.jsp"/>">添加角色信息</a>
                </c:if>
               </c:forEach>
            </td>
        </tr>
        <tr>
            <td>序号</td>
            <td>名称</td>
            <td>密码</td>
            <td>真实姓名</td>
            <td>员工职位</td>
            <td>注册时间</td>
            <td>状态</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list}" var="u">

            <tr>
                <td>${u.uid}</td>
                <td>${u.uname}</td>
                <td>${u.upassword}</td>
                <td>${u.urealname}</td>
                <td>
                    <c:forEach items="${u.roles}" var="r">
                        ${r.roname}/
                    </c:forEach>
                </td>
                <td>${u.uaddTime}</td>
                <td><c:if test="${u.ustatus == 1}">
                    正常
                </c:if>
                    <c:if test="${u.ustatus == 2}">
                        离职
                    </c:if>
                </td>
                <td>
                    <c:forEach items="${auths}" var="a">
                        <c:if test="${a.aid == 3}">
                            <a href="<c:url value="/user/user/update?uid=${u.uid}"/>"><span class="glyphicon glyphicon-pencil"></span></a>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${auths}" var="a">
                        <c:if test="${a.aid == 2}">
                            <a href="#" onclick="deleteUserById(${u.uid})"><span class="glyphicon glyphicon-trash"></span></a>
                        </c:if>
                    </c:forEach>

                </td>
            </tr>
        </c:forEach>
    </table>
    每页${pageUtil.pageSize }记录|总共${pageUtil.total }条记录|
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a class="${pageUtil.pageNo == 1 ?"disabled":""}" href="<c:url value="/user/user/selectall?pageNo=${pageUtil.pageNo -1}&keyword=${keyword}"/>" aria-label="Previous">
                    <span aria-hidden="true">上一页</span>
                </a>
            </li>
            <c:forEach var="i" begin="1" end="${pageUtil.getPageCount()}" step="1">
                <li
                        <c:if test="${pageUtil.getPageNo() == i}">
                            class="active"
                        </c:if>
                ><a href="<c:url value="/user/user/selectall?pageNo=${i}&keyword=${keyword}"/>">${i}</a></li>
            </c:forEach>
            <li>
                <a class = "${pageUtil.pageNo == pageUtil.pageCount ? "disabled":""}" href="<c:url value="/user/user/selectall?pageNo=${pageUtil.pageNo +1}&keyword=${keyword}"/>" aria-label="Next">
                    <span aria-hidden="true">下一页</span>
                </a>
            </li>
        </ul>
    </nav>
    页码${pageUtil.pageNo } / ${pageUtil.pageCount }
</div>
<script type="text/javascript">
    function deleteUserById(id) {
        if(confirm("是否删除！")) {
            window.location = "http://localhost:8080/Crmproject_war_exploded/user/user/deleteone?uid="+id;
        }
        return false;
    }
</script>
</body>
</html>
