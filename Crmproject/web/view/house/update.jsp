<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>更新房屋信息</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="<c:url value="/user/house/update"/>" method="post" >
        <table class="table table-bordered">
            <tr>
                <td><input type="hidden" value="${house.hid}" name="hid"></td>
            </tr>
            <tr>
                <td>房屋地址</td>
                <td><input type="text" value="${house.haddress}" name="haddress"></td>
            </tr>
            <tr>
                <td>楼层</td>
                <td><input type="text" value="${house.hfloor}" name="hfloor"></td>
            </tr>
            <tr>
                <td>房间号</td>
                <td><input type="text" value="${house.hroomNum}" name="hroomNum"></td>
            </tr>
            <tr>
                <td>面积</td>
                <td><input type="text" value="${house.harea}" name="harea"></td>
            </tr>
            <tr>
                <td>朝向</td>
                <td><input type="text" value="${house.hdir}" name="hdir"></td>
            </tr>
            <tr>
                <td>装修</td>
                <td><select name="hdeco" value="${house.hdeco}">
                    <option value="1">毛坯</option>
                    <option value="2">简装</option>
                    <option value="3">精装</option>
                </select></td>
            </tr>
            <tr>
                <td>双气</td>
                <td><select value="${house.hair}" name="hair">
                    <option value="1">是</option>
                    <option value="2">否</option>
                </select></td>
            </tr>
            <tr>
                <td>价格</td>
                <td><input type="text" value="${house.hprice}" name="hprice"></td>
            </tr>
            <tr>
                <td>出租状态</td>
                <td><select value="${house.hrentStatus}" name="hrentStatus">
                    <option value="1">已出租</option>
                    <option value="2">未出租</option>
                    <option value="3">停止出租</option>
                </select></td>
            </tr>
            <tr>
                <td>房屋图片路径</td>
                <td><input type="text" value="${house.himage}" name="himage"></td>
            </tr>
            <tr>
                <td>添加时间</td>
                <td><input type="date" value="${house.haddTime}" name="haddTime"></td>
            </tr>
            <tr>
                <td>更新时间</td>
                <td><input type="date" value="${house.hupdateTime}" name="hupdateTime"></td>
            </tr>
        </table>
        <input type="submit" value="更新">
        <a href="<c:url value="/view/house/list.jsp"/>">返回</a>
    </form>
</div>
</body>
</html>
