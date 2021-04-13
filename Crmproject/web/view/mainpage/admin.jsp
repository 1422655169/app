<%--
  Created by IntelliJ IDEA.
  User: rooy
  Date: 2021/2/14
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>智游公寓系统 - 后台管理</title>
    <link href="<c:url value="/css/admin.css"/>" rel="stylesheet">
    <link href="<c:url value="/lib/font-awesome/css/font-awesome.css"/>" rel="stylesheet">
</head>
<body>
<div class="header">
    <h1><a href="#">智游公寓系统</a></h1>
    <!--<div class="nav">
        <a target="right" href="#">工作台</a>
        <a target="right" href="#">报表</a>
        <a target="right" href="#">客户信息</a>
        <a target="right" href="#">员工信息</a>
        <a target="right" href="#">公告信息</a>
        <a target="right" href="#">发件箱</a>
    </div>-->
    <div class="user">
        <a href="#">${user.uname}</a>
        <a href="/Crmproject_war_exploded/index.jsp">退出</a>
    </div>
</div>
<div class="main">
    <ul class="left-side">
        <li class="menu-title active">
            <a href="#">
                <i class=" fa fa-users"></i>&nbsp;&nbsp;公寓管理
            </a>
        </li>
        <li class="sub-menu">
            <ul>
                <li class="active">
                    <a href="<c:url value="/user/house/show?pageNo=1"/>"  target="pageBox">
                        <i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;房屋信息
                    </a>
                </li>
                <li>
                    <a  href="<c:url value="/user/contract/selectall?pageNo=1"/>" target="pageBox">
                        <i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;租赁合同
                    </a>
                </li>
                <li>
                    <a  href="<c:url value="/user/lessee/selectall?pageNo=1"/>" target="pageBox">
                        <i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;租户信息
                    </a>
                </li>
                <li>
                    <a   href="<c:url value="/user/rent/selectall?pageNo=1"/>"  target="pageBox">
                        <i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;房租信息
                    </a>
                </li>

            </ul>
        </li>
        <li class="menu-title">
            <a href="#">
                <i class=" fa fa-file-text"></i>&nbsp;&nbsp;服务管理
            </a>
        </li>
        <li class="sub-menu">
            <ul>
                <li>
                    <a target="pageBox" href="<c:url value="/user/logi/selectall?pageNo=1"/>">
                        <i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;后勤人员
                    </a>
                </li>
                <li>
                    <a target="pageBox" href="<c:url value="/user/maintain/selectall?page=1"/>">
                        <i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;修缮记录
                    </a>
                </li>
                <li>
                    <a target="pageBox" href="<c:url value="/user/activity/selectall?pageNo=1"/>">
                        <i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;公寓活动
                    </a>
                </li>

            </ul>
        </li>
        <li class="menu-title">
            <a href="#" >
                <i class=" fa fa-sitemap"></i>&nbsp;&nbsp;管理员
            </a>
        </li>
        <li class="sub-menu">
            <ul class="menu">
                <li>
                    <a target="pageBox" href="<c:url value="/user/role/selectall?page=1"/>">
                        <i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;角色管理
                    </a>
                </li>
                <li>
                    <a target="pageBox" href="<c:url value="/user/user/selectall?pageNo=1"/>">
                        <i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;用户管理
                    </a>
                </li>
            </ul>
        </li>
    </ul>
    <div class="right-side">
        <iframe name="pageBox" src="<c:url value="/user/house/show?pageNo=1"/>"></iframe>
        <div class="footer">
            智游教育 ©2018 河南智游臻龙教育科技有限公司
        </div>
    </div>
</div>
<script src="<c:url value="/lib/jquery/jquery.js"/>"></script>
<script src="<c:url value="/js/admin.js"/>"></script>
</body>
</html>
