<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/3/30
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发帖</title>
</head>
<body>
<%
    String userId=(String)session.getAttribute("userId");
%>
<h1>欢迎:<%=userId%>></h1>
<br>
发表新主题
<form action="../Post" method="post">
    <div>
        主题：
        <input type="text" name="title">
    </div>
    <div>
        内容：
        <textarea type="text" name="content"></textarea>
    </div>
    <div>
        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </div>
    <div>
        <a href="logout.jsp">退出</a>
    </div>
</form>
</body>
</html>
