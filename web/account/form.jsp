<%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 2019-06-18
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Form</title>
</head>
<body>
    <h1>Register Form</h1>
    <form action="/account/register" method="post">
        <div>
            Username <input type="text" name="username">
        </div>
        <div>
            Password <input type="password" name="password">
        </div>
        <div>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </div>
    </form>
</body>
</html>
