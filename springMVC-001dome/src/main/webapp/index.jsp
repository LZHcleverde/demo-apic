<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/6/3
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/demo.action">zou</a>

    <form action="${pageContext.request.contextPath}/req.action" method="post">
        姓名:<input type="text" name="name">
        年龄:<input type="text" name="age">
        <input type="submit" value="提交">
    </form>

    <a href="${pageContext.request.contextPath}/dong/lzh/23.action">dong</a>

    <form action="${pageContext.request.contextPath}/reqparam.action" method="get">
        姓名:<input type="text" name="name">
        年龄:<input type="text" name="age">
        <input type="submit" value="提交">
    </form>
</body>
</html>
