<%-- 
    Document   : Hello
    Created on : Jul 24, 2018, 1:55:57 PM
    Author     : doduy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="mybean" scope="session" class="org.mypackage.Hello.NameHandler" />
        <jsp:setProperty name="mybean" property="username" />
        <h1>Hello World! , <jsp:getProperty name="mybean" property="username" /></h1>
    </body>
</html>
