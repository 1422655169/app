<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>更新角色</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="<c:url value="/user/role/update"/>" method="post">
        <table class="table table-bordered">
            <tr>
                <td><input type="hidden" value="${role.roid}" name="roid"></td>
            </tr>
            <tr>
                <td>职位</td>
                <td><input type="text" value="${role.roname}" name="roname"></td>
            </tr>
            <tr>
                <td>权限</td>
                <td><input type="text" value="${role.rodesc}" name="rodesc"></td>
            </tr>
            <tr>
                <td>职位</td>
                <td><input type="date" value="${role.roaddTime}" name="roaddTime"></td>
            </tr>
        </table>
        <input type="submit" value="更新">
        <a href="<c:url value="/view/role/list.jsp"/>">返回</a>
    </form>
</div>
</body>
</html>
