<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>添加活动</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="<c:url value="/user/activity/add"/>" method="post">
        <table class="table table-bordered">
            <tr>
                <td>活动时间</td>
                <td><input type="date" name="atime"></td>
            </tr>
            <tr>
                <td>活动主题</td>
                <td><input type="text" name="asubject"></td>
            </tr>
            <tr>
                <td>活动内容</td>
                <td><input type="text" name="aintr"></td>
            </tr>
            <tr>
                <td>活动地址</td>
                <td><input type="text" name="aaddress"></td>
            </tr>
            <tr>
                <td>活动消费</td>
                <td><input type="text" name="aprice"></td>
            </tr>
        </table>
        <input type="submit" value="添加">
        <a href="<c:url value="/view/activity/list.jsp"/>">返回</a>
    </form>
</div>
</body>
</html>
