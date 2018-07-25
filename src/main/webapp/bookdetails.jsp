<%@ page import="mypack.pojo.Book" %><%--
  Created by IntelliJ IDEA.
  User: lhao
  Date: 18-7-14
  Time: 下午1:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String id = request.getParameter("bookId");
    Book book = bookBean.getBookById(id);
    if (book == null) {
%>
<p>该书在数据库中不存在</p>
<%}%>

<p>书名： <%=book.getmBookName()%> </p>
<p>作者： <%=book.getmWriter()%> </p>
<p>价格： <%=book.getmPrice()%></p>

<a href="<%=request.getContextPath()%>/catagory.jsp?add=<%=book.getmBookId()%>"> <input type="submit" value="加入购物车"></a>
</body>
</html>
