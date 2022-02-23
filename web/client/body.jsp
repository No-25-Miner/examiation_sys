<%--
  Created by IntelliJ IDEA.
  User: zhangtianhao
  Date: 2020/12/20
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/manager/ExaminationServlet?method=list">开始考试</a>
<a href="${pageContext.request.contextPath }/manager/RecordServlet?method=list">查看历史记录</a>
</body>
</html>
