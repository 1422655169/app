<%--
  Created by IntelliJ IDEA.
  User: rooy
  Date: 2021/2/6
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta charset="UTF-8">
  <title>智游公寓系统 - 登录页面</title>
  <link rel="stylesheet" href="<%=request.getContextPath()  %>/css/index.css">
  <link href="<%=request.getContextPath()  %>/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
  <link href="<%=request.getContextPath()  %>/bootstrap-3.3.7-dist/css/signin.css" rel="stylesheet">
</head>
<body>
<div class="login">
  <img src="<%=request.getContextPath()  %>/image/logo.png" alt="智游">
  <p>智游登录系统</p>
  <form action="<c:url value="/user/login"/>" method="post">
    <div>
      <input type="text" id="username" name="username" value="" placeholder="请输入用户名">
    </div>
    <div>
      <input type="password" id="password" name="password" value="" placeholder="请输入密码">
    </div>
    <div>
      <p class="error-message">
        <span>
          ${msg}
        </span>
      </p>
      <input type="submit" value="登录">
      <a href="<c:url value="/SignIn.jsp"/>">注册</a>
      <a href="<c:url value="view/user/excel.jsp"/>">导出</a>
    </div>
  </form>
</div>
<script>
  if (window.top !== window) {
    window.top.location.reload();
  }
</script>
</body>
</html>
