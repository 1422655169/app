<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>添加房租信息</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="<c:url value="/user/rent/add"/>" method="post">
        <table class="table table-bordered">
            <tr>
                <td>房屋号</td>
                <td><input type="text" name="rhid" placeholder="请输入房屋号"></td>
            </tr>
            <tr>
                <td>租户号</td>
                <td><input type="text" name="rlid" placeholder="请输入租户号"></td>
            </tr>
            <tr>
                <td>缴纳房租</td>
                <td><input type="text" name="rprice" ></td>
            </tr>
            <tr>
                <td>付款时间</td>
                <td><input type="date" name="rpayTime"></td>
            </tr>
        </table>
        <input type="submit" value="更新">
        <a href="<c:url value="/view/rent/show.jsp"/>">返回</a>
    </form>
</div>
</body>
</html>
