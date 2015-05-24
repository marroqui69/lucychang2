<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="MacRoman"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=MacRoman">
        <title>Tot weerziens</title>
    </head>
    <body>
        <h1>Lucy Chang groet u!</h1>
        <c:url var="login" value="/login.html" />
        <a href='<c:out value="${login}"/>'>Log opnieuw in</a>

    </body>
</html>
