<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>更新合同信息</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="<c:url value="/user/contract/update"/>" method="post">
        <table class="table table-bordered">
            <tr>
                <td><input type="hidden" value="${contract.cid}" name="cid"></td>
            </tr>
            <tr>
                <td>合同号</td>
                <td><input type="text" value="${contract.cnum}" name="cnum"></td>
            </tr>
            <tr>
                <td>房屋号</td>
                <td><input type="text" value="${contract.chid}" name="chid"></td>
            </tr>
            <tr>
                <td>租户号</td>
                <td><input type="text" value="${contract.clid}" name="clid"></td>
            </tr>
            <tr>
                <td>合同签订日期</td>
                <td><input type="date" value="${contract.ctime}" name="ctime"></td>
            </tr>
            <tr>
                <td>合同生效起使日期</td>
                <td><input type="date" value="${contract.cstartTime}" name="cstartTime"></td>
            </tr>
            <tr>
                <td>合同失效日期</td>
                <td><input type="date" value="${contract.cendTime}" name="cendTime"></td>
            </tr>
            <tr>
                <td>价格</td>
                <td><input type="text" value="${contract.ctotalMoney}" name="ctotalMoney"></td>
            </tr>
            <tr>
                <td>付款方式</td>
                <td><select value="${contract.cpayType}" name="cpayType">
                    <option value="1">月付</option>
                    <option value="2">半年付</option>
                    <option value="3">年付</option>
                </select></td>
            </tr>
        </table>
        <input type="submit" value="更新">
        <a href="<c:url value="/view/contract/show.jsp"/>">返回</a>

    </form>
</div>
</body>
</html>
