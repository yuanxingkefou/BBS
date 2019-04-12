<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/3/29
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎来到BBS！！！</title>
</head>
<body>
<%
    String userId=(String)session.getAttribute("userId");
%>
<h1>欢迎：<font color="red"><%=userId%></font>的到来</h1>
<br>
进入论坛直接发帖！请单击<a href="post.jsp">这里</a><br><br>
查看论坛列表！请点击<a href="list.jsp">这里</a><br><br>
查看论坛用户详细信息(仅管理员进入)!请点击<a href="userInfo.jsp">这里</a><br><br>
<a href="logout.jsp">安全退出</a>
</body>
</html>
