<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>房屋合同</title>
    <link href="<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css"/>" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/css/admin.css"/> ">
    <link rel="stylesheet" href="<c:url value="/css/main.css"/> ">
    <link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css"/>">
</head>
<body>
<div class="container">
    <%--  模糊查询  --%>
    <form action="<c:url value="/user/contract/selectall"/>">
        房屋价格:<input type="text" placeholder="请输入最低价格" name="lowprice"/>-
                <input type="text" placeholder="请输入最高价格" name="highprice"/>
        <input type="hidden" name = "pageNo" value="1"/>
        <input type="submit" value="搜索1"/>
    </form>


    <table class="table table-bordered">
        <tr>
            <td><a href="<c:url value="/view/contract/add.jsp"/>">添加合同信息</a></td>
        </tr>
    </table>
    <table class="table table-bordered">
        <tr>
            <td>序号</td>
            <td>合同号</td>
            <td>房屋号</td>
            <td>租户号</td>
            <td>合同签订日期</td>
            <td>合同生效起使时间</td>
            <td>合同失效日期</td>
            <td>价格</td>
            <td>付款方式</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${list}" var="c">
            <tr>
                <td>${c.cid}</td>
                <td>${c.cnum}</td>
                <td>${c.house.haddress}</td>
                <td>${c.lessee.lname}</td>
                <td>${c.ctime}</td>
                <td>${c.cstartTime}</td>
                <td>${c.cendTime}</td>
                <td>${c.ctotalMoney}</td>
                <td>
                    <c:if test="${c.cpayType == 1}">
                        月付
                    </c:if>
                    <c:if test="${c.cpayType == 2}">
                        半年付
                    </c:if>
                    <c:if test="${c.cpayType == 3}">
                        年付
                    </c:if>
                </td>
                <td colspan="2"><a href="<c:url value="/user/contract/update?cid=${c.cid}"/>"><span class="glyphicon glyphicon-pencil"></span></a>|
                    <a href="#" onclick="deleteContractById(${c.cid})"><span class="glyphicon glyphicon-trash"></span></a></td>
            </tr>
        </c:forEach>
    </table>每页${pageUtil.pageSize }记录|总共${pageUtil.total }条记录|
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a class="${pageUtil.pageNo ==1?"disabled":""}" href="<c:url value="/user/contract/selectall?pageNo=${pageUtil.pageNo -1}&lowprice=${map.lowprice}&highprice=${map.highprice}"/>" aria-label="Previous">
                    <span aria-hidden="true">上一页</span>
                </a>
            </li>
            <c:forEach var="i" begin="1" end="${pageUtil.getPageCount()}" step="1">
                <li class ="paginate_button ${i== pageUtil.pageNo? "active":""}"><a href="#">${i}</a></li>
            </c:forEach>
            <li>
                <a class="${pageUtil.pageNo==pageUtil.pageCount? "disabled":""}" href="<c:url value="/user/contract/selectall?pageNo=${pageUtil.pageNo +1}&lowprice=${map.lowprice}&highprice=${map.highprice}"/>" aria-label="Next">
                    <span aria-hidden="true">下一页</span>
                </a>
            </li>
        </ul>
    </nav>
    页码${pageUtil.pageNo } / ${pageUtil.pageCount }
</div>
<script type="text/javascript">
    function deleteContractById(id) {
        if (confirm("是否删除?")) {
            window.location = "http://localhost:8080/Crmproject_war_exploded/user/contract/deleteone?cid="+id;
        }
        return false;
    }
</script>
</body>
</html>
