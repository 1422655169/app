<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>图书管理</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/main.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="<c:url value="/user/house/show"/>">
        房屋地址&nbsp;&nbsp;<input type="text" name="address" placeholder="请输入房屋地址">
        <input type="hidden" name="pageNo" value="1">&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value="搜索">
    </form>
    <table class="table table-bordered">
        <tr>
            <td><a href="<c:url value="/view/house/add.jsp"/>">添加房屋信息</a></td>
        </tr>
    </table>
    <table class="table table-bordered">
        <tr><td>序号</td>
            <td>房屋地址</td>
            <td>楼层</td>
            <td>房间号</td>
            <td>面积</td>
            <td>朝向</td>
            <td>装修</td>
            <td>双气</td>
            <td>价格</td>
            <td>出租状态</td>
            <td>房屋图片路径</td>
            <td>添加时间</td>
            <td>更新时间</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${list}" var="h">
            <tr>
                <td>${h.hid}</td>
                <td>${h.haddress}</td>
                <td>${h.hfloor}</td>
                <td>${h.hroomNum}</td>
                <td>${h.harea}</td>
                <td>${h.hdir}</td>
                <td>
                    <c:if test="${h.hdeco == 1}">
                        毛坯
                    </c:if>
                    <c:if test="${h.hdeco == 2}">
                        简装
                    </c:if>
                    <c:if test="${h.hdeco == 3}">
                        精装
                    </c:if>
                </td>
                <td>
                    <c:if test="${h.hair == 1}">
                        是
                    </c:if>
                    <c:if test="${h.hair == 2}">
                        否
                    </c:if>
                </td>
                <td>${h.hprice}</td>
                <td>
                    <c:if test="${h.hrentStatus == 1}">
                        已出租
                    </c:if>
                    <c:if test="${h.hrentStatus == 2}">
                        未出租
                    </c:if>
                    <c:if test="${h.hrentStatus == 3}">
                        停止出租
                    </c:if>
                </td>
                <td><img src="${h.himage}"/></td>
                <td>${h.haddTime}</td>
                <td>${h.hupdateTime}</td>
                <td colspan="2"><a href="<c:url value="/user/house/update?hid=${h.hid}"/>"><span class="glyphicon glyphicon-pencil"></span></a>|
                    <a href="#" onclick="deleteHouseById(${h.hid})"><span class="glyphicon glyphicon-trash"></span></a></td>
            </tr>
        </c:forEach>
    </table>
    每页${pageUtil.pageSize }记录|总共${pageUtil.total }条记录|
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a class="${pageUtil.pageNo == 1 ?"disabled":""}" href="<c:url value="/user/house/show?pageNo=${pageUtil.pageNo -1}&keyword=${keyword}"/>" aria-label="Previous">
                    <span aria-hidden="true">上一页</span>
                </a>
            </li>
            <c:forEach var="i" begin="1" end="${pageUtil.getPageCount()}" step="1">
                <li
                        <c:if test="${pageUtil.getPageNo() == i}">
                            class="active"
                        </c:if>
                ><a href="<c:url value="/user/house/show?pageNo=${i}&keyword=${keyword}"/>">${i}</a></li>
            </c:forEach>
            <li>
                <a class = "${pageUtil.pageNo == pageUtil.pageCount ? "disabled":""}" href="<c:url value="/user/house/show?pageNo=${pageUtil.pageNo +1}&keyword=${keyword}"/>" aria-label="Next">
                    <span aria-hidden="true">下一页</span>
                </a>
            </li>
        </ul>
    </nav>
    页码${pageUtil.pageNo } / ${pageUtil.pageCount }
</div>
<script type="text/javascript">
    function
    deleteHouseById(id) {
        if (confirm("是否删除？")) {
            window.location = "http://localhost:8080/Crmproject_war_exploded/user/house/deleteone?hid="+id;
        }
        return false;
    }
</script>
</body>
</html>
