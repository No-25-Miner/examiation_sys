<%--
  Created by IntelliJ IDEA.
  User: zhangtianhao
  Date: 2020/12/20
  Time: 0:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/manager/UserServlet?method=add">
    学号：<input type="text" name="sno"><br>
    用户名:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="确定">
</form>
</body>
</html>
