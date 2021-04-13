<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>更新公寓修缮记录</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="<c:url value="/user/maintain/update"/>" method="post">
        <table class="table table-bordered">
            <tr>
                <td><input type="hidden" value="${maintain.mid}" name="mid"></td>
            </tr>
            <tr>
                <td>房屋号</td>
                <td><input type="text" value="${maintain.mhid}" name="mhid"></td>
            </tr>
            <tr>
                <td>后勤人员号</td>
                <td><input type="text" value="${maintain.mloid}" name="mloid"></td>
            </tr>
            <tr>
                <td>维修日期</td>
                <td><input type="date" value="${maintain.mtime}" name="mtime"></td>
            </tr>
            <tr>
                <td>维修结果</td>
                <td><input type="text" value="${maintain.mresult}" name="mresult"></td>
            </tr>
        </table>
        <input type="submit" value="更新">
        <a href="<c:url value="/view/maintain/list.jsp"/>">返回</a>
    </form>
</div>
</body>
</html>
