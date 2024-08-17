<%@ page import="pro.sujan.ee.http.cookie.SecuredCookie" %>
<%@ page import="pro.sujan.ee.url.PathHandler" %>
<%@ page import="pro.sujan.ee.database.Database" %>
<%@ page import="pro.sujan.ee.database.service.UserService" %>
<%@ page import="pro.sujan.ee.database.entity.LoginEntity" %>
<%@ page import="pro.sujan.ee.database.service.LoginService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    SecuredCookie.newCookie("safeCookie", "safeCookie")
            .addCookieToResponse(response);
%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="css/home.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="index-div"><%="Hello World!"%></div>
<a href="<%=PathHandler.getServletPath(request, "/login")%>">Login</a>
<label>Name: </label><%
    LoginEntity login = new LoginEntity();
    login.setUserId(1);
    new LoginService().save(login);
%>
<br/>
</body>
<script src="js/home.js"></script>
</html>