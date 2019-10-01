<%--
  Created by IntelliJ IDEA.
  User: yuliya
  Date: 01.10.19
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
<form method="POST" action="/signIn">
    <input type="text" name="login" placeholder="login">
    <input type="password" name="password" placeholder="password">
    <input type="submit" value="send">
</form>
</body>
</html>
