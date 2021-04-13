<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>添加后勤人员信息</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="<c:url value="/user/logi/add"/>" method="post">
        <table class="table table-bordered">
            <tr>
                <td>姓名</td>
                <td><input type="text" name="loname"></td>
            </tr>
            <tr>
                <td>身份证号</td>
                <td><input type="text" name="loidCard"></td>
            </tr>
            <tr>
                <td>电话</td>
                <td><input type="text" name="lotel"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><select  name="losex">
                    <option value="1">男</option>
                    <option value="2">女</option>
                </select></td>
            </tr>
            <tr>
                <td>添加日期</td>
                <td><input type="date" name="loaddTime"></td>
            </tr>
            <tr>
                <td>价格</td>
                <td><input type="text" name="losalary"></td>
            </tr>
        </table>
        <input type="submit" value="添加">
        <a href="<c:url value="/view/logi/show.jsp"/>">返回</a>
    </form>
</div>
</body>
</html>
