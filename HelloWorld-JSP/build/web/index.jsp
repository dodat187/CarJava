<%-- 
    Document   : index
    Created on : Jul 24, 2018, 1:49:48 PM
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
        <div>Chào bạn. Mời bạn nhập tên</div>
        <form name="Name Input Form" action="Hello.jsp" method="post">
            <label>Yourname : </label>
            <input type="text" name="username" />
            <input type="submit" value="OK" />
        </form>
    </body>
</html>
