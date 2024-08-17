<%@ page import="pro.sujan.ee.http.cookie.SecuredCookie" %>
<%@ page import="pro.sujan.ee.url.PathHandler" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    SecuredCookie.newCookie("safeCookie", "safeCookie")
            .addCookieToResponse(response);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link href="css/home.css" rel="stylesheet" type="text/css">
</head>
<body>
    <form method="post" action="<%=PathHandler.getServletPath(request, "/home")%>">
        <label>
            Username
            <input type="text" name="username"/>
        </label>
        <label>
            Password
            <input type="password" name="password"/>
        </label>
        <input type="submit" value="Save User">
    </form>
</body>
<script src="js/home.js"></script>
</html>