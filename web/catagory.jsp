<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lhao
  Date: 18-7-14
  Time: 上午11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="common.jsp"%>
<jsp:useBean id="cart" scope="session" class="mypack.ShowCart"/>

<html>
<head>
    <title>catagory</title>
</head>
<body>

<%
    String id = request.getParameter("add");
    if (id != null) {
    Book book = bookBean.getBookById(id);
    cart.addCart(id, book);
%>

<p>您已经将<%=book.getmBookName()%>放入购物车</p>

<%}%>

<%
    List<Book> lists = bookBean.getBooks();
    for (Book b : lists) {
%>
<p><a href="bookdetails.jsp?bookId=<%=b.getmBookId()%>"><%=b.getmBookName()%></a> &nbsp; <%=b.getmWriter()%> &nbsp;<a href="<%=request.getContextPath()%>/catagory.jsp?add=<%=b.getmBookId()%>" > <input type="submit" value="加入购物车"></a>
</p>

<%}%>


<a href="<%=request.getContextPath()%>/showcart.jsp">查看购物车</a>
</body>
</html>
