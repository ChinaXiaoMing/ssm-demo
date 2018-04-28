<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/28 0028
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>shiro登录验证</title>
  </head>
  <body>
    <form action="/loginSubmit" method="post">
      <label for="username">账号：</label>
      <input type="text" id="username" name="username" value=""/><br/>
      <label for="password">密码：</label>
      <input type="text" id="password" name="password" value=""/><br/>
      <button type="submit">登录</button>
    </form>
  </body>
</html>
