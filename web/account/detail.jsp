<%@ page import="demo.entity.Account" %><%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 2019-06-18
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Account account = (Account) request.getAttribute("account");
%>
<html>
<head>
    <title>Account detail</title>
</head>
<body>
    <h1>Account</h1>
    <div>
        Username <p><%= account.getUsername()%></p>
    </div>
</body>
</html>
