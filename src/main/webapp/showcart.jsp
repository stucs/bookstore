<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: lhao
  Date: 18-7-14
  Time: 下午2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp"%>
<jsp:useBean id="cart" scope="session" class="mypack.ShowCart"/>

<html>
<head>
    <title>Title</title>
</head>
<body>

<p>购物车内有<%=cart.getCount()%> 本书</p>

<%
    Collection c = cart.getItems();
    Iterator iterator = c.iterator();
    while (iterator.hasNext()) {
        ShowCartItem book = (ShowCartItem) iterator.next();

%>
<p> <%=book.getItem().getmBookName()%> </p>

<%}%>

</body>
</html>
