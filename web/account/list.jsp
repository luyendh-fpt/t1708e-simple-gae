<%@ page import="demo.entity.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 2019-06-18
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Account> list = (List<Account>) request.getAttribute("list");
    String email = (String) request.getAttribute("email");
    int limit = (int) request.getAttribute("limit");
    int totalPages = (int) request.getAttribute("totalPages");
    int currentPage = (int) request.getAttribute("currentPage");

    if(email == null){
        email = "";
    }
%>
<html>
<head>
    <title>List Account</title>
</head>
<body>
<h1>List Account</h1>
<form action="/account/list" method="get">
    Search by email <input type="text" name="email" value="<%=email%>">
</form>
<ul>
    <%
        for (int i = 0; i < list.size(); i++) {
    %>
    <li>
        <a href="/account/detail?id=<%=list.get(i).getUsername()%>">
            <img src="<%=list.get(i).getAvatarUrl()%>=w200-c" alt="<%=list.get(i).getFullName()%>">
            <%=list.get(i).getUsername()%>
        </a>
    </li>
    <%
        }%>
</ul>


    <%
        if(currentPage > 1){
    %>
            <a href="/account/list?page=1&limit=<%=limit%>">First</a>&nbsp;
            <a href="/account/list?page=<%= currentPage-1%>&limit=<%=limit%>">Previous</a>&nbsp;
    <%
        }
    %>

    <%
        if(currentPage > 2){
    %>
            <a href="/account/list?page=<%= currentPage-2%>&limit=<%=limit%>"><%= currentPage-2%></a>
    <%
        }
    %>

    <%
        if(currentPage > 1){
    %>
            <a href="/account/list?page=<%= currentPage-1%>&limit=<%=limit%>"><%= currentPage-1%></a>
    <%
        }
    %>

        <a href="/account/list?page=<%= currentPage%>&limit=<%=limit%>"><b><%=currentPage%></b></a>

    <%
        if(totalPages-currentPage > 0){
    %>
        <a href="/account/list?page=<%= currentPage+1%>&limit=<%=limit%>"><%= currentPage+1%></a>
    <%
        }
    %>

    <%
        if(totalPages-currentPage > 1){
    %>
        <a href="/account/list?page=<%= currentPage+2%>&limit=<%=limit%>"><%= currentPage+2%></a>
    <%
        }
    %>

    <%
        if(currentPage<totalPages){
    %>
        <a href="/account/list?page=<%= currentPage+1%>&limit=<%=limit%>">Next</a>&nbsp;
        <a href="/account/list?page=<%=totalPages%>&limit=<%=limit%>">Last</a>&nbsp;
    <%
        }
    %>

</body>
</html>
