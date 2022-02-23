<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangtianhao
  Date: 2020/12/20
  Time: 1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考试</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/manager/RecordServlet?method=grade" method="post">

    <c:forEach var="question" varStatus="q" items="${questions}">
        <div><!---->
            <div >
                <div >
                    <span>${q.index+1}</span>
                </div>
                <div>
                    <div>
                        <span >
                        <span >【单选题】</span> <span>(1分)</span>
                        </span>
                    </div>
                    <div >
                        <p>${question.question}</p>
                    </div>
                    <div></div>
                </div>
            </div>
            <div >
                <div >
                    <label >
                        <div >
                            <input name="${q.index+1}" type="radio" value="1">
                            <span>A.</span>
                        </div>
                        <div>${question.option_A}<br><br></div>
                    </label>
                </div>
                <div >
                    <label >
                        <div >
                            <input name="${q.index+1}" type="radio" value="2">
                            <span >B.</span>
                        </div>
                        <div>${question.option_B}<br><br></div>
                    </label></div>
                <div >
                    <label>
                        <div>
                            <input name="${q.index+1}" type="radio" value="3">
                            <span >C.</span>
                        </div>
                        <div >${question.option_C}<br><br></div>
                    </label>
                </div>
                <div>
                    <label>
                        <div>
                            <input name="${q.index+1}" type="radio" value="4">
                            <span>D.</span>
                        </div>
                        <div >${question.option_D}<br><br></div>
                    </label>
                </div>
            </div>
        </div>

    </c:forEach>
    <input type="submit" value="确认提交">
</form>
</body>
</html>
