<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/25
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user list</title>
</head>
<body>
    <h1>hello</h1>
    <br>
    <c:forEach items="${userlist}" var="item" >
        userId:<c:out value="${item.id}"/>
        <br>
        username:<c:out value="${item.username}"/>
        <br>
    </c:forEach>
</body>
</html>
