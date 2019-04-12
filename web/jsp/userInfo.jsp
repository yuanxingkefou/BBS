<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/3/30
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String userId=(String)session.getAttribute("userId");
    %>
    <title>客户信息</title>
</head>
<body>
<h1>查看本站客户详细信息</h1>
<%
    if(userId.equals("admin")){
        out.println("");
    }else
    {
%>
您不是本站的系统管理员，不能浏览本页！<br>
<a href="success.jsp">返回论坛首页</a>
<%
    }
%>
</body>
</html>
