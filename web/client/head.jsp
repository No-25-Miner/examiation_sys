<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>考试系统</title>
    </head>
  <body style="text-align:center;">
    <h1>考试系统</h1>
    <br/>
    <div style="text-align:center;">
    	<c:if test="${user==null }"> 
	    <form action="${pageContext.request.contextPath }/client/LoginServlet" method="post">
	    	学号：<input type="text" name="sno" style="width:60px;">
	    	密码：<input type="password" name="password" style="width:60px;">
	    	<input type="submit" value="登陆">
            <a href="${pageContext.request.contextPath }/manager/addUser.jsp">注册</a>
	    </form>
	    </c:if>

    </div>
  </body>
</html>
