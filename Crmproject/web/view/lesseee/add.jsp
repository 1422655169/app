<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>添加租户信息</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="<c:url value="/user/lessee/addone"/>" method="post">
        <table class="table table-bordered">
            <tr>
                <td>租户姓名</td>
                <td><input type="text" name="lname"></td>
            </tr>
            <tr>
                <td>租户电话</td>
                <td><input type="text" name="ltel"></td>
            </tr>
            <tr>
                <td>租户性别</td>
                <td><select name="lsex">
                    <option value="1">男</option>
                    <option value="2">女</option>
                </select>
            </tr>
            <tr>
                <td>租户籍贯</td>
                <td><input type="text" name="lnp"></td>
            </tr>
            <tr>
                <td>租户身份证号</td>
                <td><input type="text" name="lidCard"></td>
            </tr>
            <tr>
                <td>租户添加时间</td>
                <td><input type="date" name="laddTime"></td>
            </tr>
        </table>
        <input type="submit" value="添加">
        <a href="<c:url value="/view/lesseee/show.jsp"/>">返回</a>
    </form>
</div>
</body>
</html>
