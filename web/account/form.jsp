<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="demo.entity.Account" %><%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 2019-06-18
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
//    String uploadUrl = blobstoreService.createUploadUrl("/account/register");
%>
<html>
<head>
    <title>Register Form</title>
</head>
<body>
    <h1>Register Form</h1>
    <form action="<%= BlobstoreServiceFactory.getBlobstoreService().createUploadUrl("/account/register")%>"
          method="post"
          enctype="multipart/form-data">
        <div>
            Username <input type="text" name="username">
        </div>
        <div>
            Password <input type="password" name="password">
        </div>
        <div>
            Fullname <input type="text" name="fullName">
        </div>
        <div>
            Email <input type="text" name="email">
        </div>
        <div>
            Avatar <input type="file" name="avatar">
        </div>
        <div>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </div>
    </form>
</body>
</html>
