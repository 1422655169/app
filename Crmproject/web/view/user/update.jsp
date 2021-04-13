<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>更新数据</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="<c:url value="/user/user/update"/>" method="post">
        <table class=" table table-bordered">
            <tr>
                <td><input type="hidden" value="${user.uid}" name="uid"></td>
            </tr>
            <tr>
                <td>用户名</td>
                <td><input type="text" value="${user.uname}" name="uname"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" value="${user.upassword}" name="upassword"></td>
            </tr>
            <tr>
                <td>真实姓名</td>
                <td><input type="text" value="${user.urealname}" name="urealname"></td>
            </tr>
<%--            <tr>--%>
<%--                <td>关联ID</td>--%>
<%--                <td><input type="text" value="${user.uroid}" name="uroid"></td>--%>
<%--            </tr>--%>
            <tr>
                <td>日期</td>
                <td><input type="date" value="${user.uaddTime}" name="uaddTime"></td>
            </tr>
            <tr>
                <td>状态</td>
                <td><select name="ustatus" value="${user.ustatus}">
                    <option value="1">正常</option>
                    <option value="2">离职</option>
                </select></td>
            </tr>
        </table>
        <input type="submit" value="更新">&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="<c:url value="/view/user/list.jsp"/>">返回</a>
    </form>
</div>
</body>
</html>
