<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/3/29
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Welcome to BBS !!!</title>
  </head>
  <body>
  <h1>
    欢迎来到BBS论坛！！！
  </h1>
  <form action="Login" method="post">
    <td>
      <div>用户名：</div>
      <input type="text" name="userId"></td>
    <td>
      <div>密码：</div>
      <input type="text" name="password">
    </td>
    <br>
    <td>
      <input type="submit" value="提交">
      <input type="reset" value="重置">
    </td>
    <br>
    新用户，请<a href="./html/register.html">注册</a>
  </form>
  </body>
</html>
