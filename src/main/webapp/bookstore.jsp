<%@ page import="java.util.List" %>
<%@ page import="mypack.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: lhao
  Date: 18-7-14
  Time: 上午10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>BookStore</title>
</head>
<body>
<%
    String username = "";
    username = request.getParameter("username");
    if (username == null) username = "hello";
    session.setAttribute("user", new User(username));
%>

<%
    OnlineUsers users = OnlineUsers.getInstance();
    List<String> lists = users.getUsers();
    for (String name : lists) {


%>

<p><%=name%></p>
<%}%>
<center>
    <%--<p><a href="<%=request.getContextPath()%>/catagory.jsp">查看所有</a></p>--%>
    <p><a href="${pageContext.request.contextPath}/hello">查看所有</a></p>
    <form action="bookdetails.jsp" method="post">
        <input type="text" size="20" name="bookId" value=""> <br><br>
        <input type="submit" value="查询">
    </form>
</center>


</body>
</html>
