<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>更新活动</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="<c:url value="/user/activity/update"/>" method="post">
        <table class="table table-bordered">
            <tr>
                <td><input type="hidden" value="${activity.aid}" name="aid"></td>
            </tr>
            <tr>
                <td>活动时间</td>
                <td><input type="date" value="${activity.atime}" name="atime"></td>
            </tr>
            <tr>
                <td>活动主题</td>
                <td><input type="text" value="${activity.asubject}" name="asubject"></td>
            </tr>
            <tr>
                <td>活动内容</td>
                <td><input type="text" value="${activity.aintr}" name="aintr"></td>
            </tr>
            <tr>
                <td>活动地址</td>
                <td><input type="text" value="${activity.aaddress}" name="aaddress"></td>
            </tr>
            <tr>
                <td>活动消费</td>
                <td><input type="text" value="${activity.aprice}" name="aprice"></td>
            </tr>
        </table>
        <input type="submit" value="更新">
        <a href="<c:url value="/view/activity/list.jsp"/>">返回</a>
    </form>
</div>
</body>
</html>
