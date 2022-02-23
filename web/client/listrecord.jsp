<%--
  Created by IntelliJ IDEA.
  User: zhangtianhao
  Date: 2020/12/20
  Time: 1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>考试记录</title>
</head>
<body style="text-align:center;">
    <h2>考试记录列表</h2>
    <table width="40%" border="1" align="center" style="text-align: center;">
        <tr>
            <td>考试序号</td>
            <td>考试成绩</td>
            <td>考试时间</td>
            <td>删除记录</td>
        </tr>
        <c:forEach var="record" varStatus="r" items="${records}">
            <tr>
                <td>${record.user_number}</td>
                <td>${record.score}</td>
                <td><a href="<%=request.getServletContext().getContextPath()%>/manager/RecordServlet?method=find&user_number=${record.user_number}">查看详情</a></td>
                <td>
                    <a href="<%=request.getServletContext().getContextPath()%>/manager/RecordServlet?method=delete&user_number=${record.user_number}">删除</a>
                </td>

            </tr>
        </c:forEach>

    </table>
</body>
</html>
