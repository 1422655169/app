<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>添加公寓修缮记录</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="<c:url value="/user/maintain/add"/>" method="post">
        <table class="table table-bordered">
            <tr>
                <td>房屋号</td>
                <td><input type="text" name="mhid"></td>
            </tr>
            <tr>
                <td>后勤人员号</td>
                <td><input type="text" name="mloid"></td>
            </tr>
            <tr>
                <td>维修日期</td>
                <td><input type="date" name="mtime"></td>
            </tr>
            <tr>
                <td>维修结果</td>
                <td><input type="text" name="mresult"></td>
            </tr>
        </table>
        <input type="submit" value="添加">
        <a href="<c:url value="/view/maintain/list.jsp"/>">返回</a>
    </form>
</div>
</body>
</html>
