<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/3/29
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>安全退出</title>
</head>
<body>
<%
    session.removeAttribute("username");
    session.invalidate();
%>
<script type="text/javascript">
    alert("成功退出，确认后转向登陆界面");
    location.href="../index.jsp";
</script>
</body>
</html>
