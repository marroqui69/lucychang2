<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="MacRoman"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=MacRoman">
        <title>Welkom in de Brainstormapplicatie</title>
    </head>
    <body>
        <h1>Oeps! Dit mag je niet doen</h1>
        <c:url var="menu" value="/menu.html" />
        <a href='<c:out value="${menu}"/>'>Menu</a><br/><br/>
    </body>
</html>
