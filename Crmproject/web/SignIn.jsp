<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>注册</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="<c:url value="/user/SignIn"/>" method="post">
        <table class="table table-bordered">
            <tr>
                <td>用户名</td>
                <td><input type="text"  name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>真实姓名</td>
                <td><input type="text" name="urealname"></td>
            </tr>
<%--            <tr>--%>
<%--                <td>关联ID</td>--%>
<%--                <td><input type="text" name="uroid"></td>--%>
<%--            </tr>--%>
            <tr>
                <td>添加日期</td>
                <td><input type="date" name="uaddTime"></td>
            </tr>
            <tr>
                <td>状态</td>
                <td><select name="ustatus">
                    <option value="1">正常</option>
                    <option value="2">离职</option>
                </select></td>
            </tr>
        </table>
        <input type="submit" value="注册">
        <input type="reset" value="重置">
    </form>
</div>
</body>
</html>
