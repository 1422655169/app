<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>添加角色</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="<c:url value="/user/role/add"/>" method="post">
        <table class="table table-bordered">
            <tr>
                <td>职位</td>
                <td><input type="text" name="roname"></td>
            </tr>
            <tr>
                <td>权限</td>
                <td><input type="text" name="rodesc"></td>
            </tr>
            <tr>
                <td>添加日期</td>
                <td><input type="date" name="roaddTime"></td>
            </tr>
        </table>
        <input type="submit" value="更新">
        <a href="<c:url value="/view/role/list.jsp"/>">返回</a>
    </form>
</div>
</body>
</html>
