<%@ page import="java.util.List" %>
<%@ page import="domain.Record" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:forEach var="question" varStatus="q" items="${questions}">


    <div><!---->
        <div >
            <div>
                <span>${q.index+1}</span>
            </div>
            <div>
                <div>
                        <span >
                        <span >【单选题】</span> <span>(1分)</span>
                        </span>
                </div>
                <div >
                    <p>${question.question} 正确答案是${question.right_option}</p>
                </div>
                <div></div>
            </div>
        </div>
        <div >
            <div >
                <label >
                    <div >
                        <input name="${q.index+1}" type="radio" value="1" disabled="disabled" <c:if test="${user_ans[q.index] == '1'}"> checked</c:if>/>
                        <span>A.</span>
                    </div>
                    <div>${question.option_A}<br><br></div>
                </label>
            </div>
            <div >
                <label >
                    <div >
                        <input name="${q.index+1}" type="radio" value="2" disabled="disabled" <c:if test="${user_ans[q.index] == '2'}"> checked</c:if>/>
                        <span >B.</span>
                    </div>
                    <div>${question.option_B}<br><br></div>
                </label></div>
            <div >
                <label>
                    <div>
                        <input name="${q.index+1}" type="radio" value="3" disabled="disabled" <c:if test="${user_ans[q.index] == '3'}"> checked</c:if>/>
                        <span >C.</span>
                    </div>
                    <div >${question.option_C}<br><br></div>
                </label>
            </div>
            <div>
                <label>
                    <div>
                        <input name="${q.index+1}" type="radio" value="4" disabled="disabled" <c:if test="${user_ans[q.index] == '4'}"> checked</c:if>/>
                        <span>D.</span>
                    </div>
                    <div >${question.option_D}<br><br></div>
                </label>
            </div>
        </div>
    </div>
</c:forEach>
</body>
</html>
