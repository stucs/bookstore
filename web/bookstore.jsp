<%--
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
<center>
    <p><a href="<%=request.getContextPath()%>/catagory.jsp">查看所有</a></p>
    <form action="bookdetails.jsp" method="post">
        <input type="text" size="20" name="bookId" value=""> <br><br>
        <input type="submit" value="查询">
    </form>
</center>


</body>
</html>
