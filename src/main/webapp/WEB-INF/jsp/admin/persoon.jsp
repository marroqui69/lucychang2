<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de Brainstormapplicatie</title>
    </head>
    
    <body>
        <h1>Details van persoon</h1>
        <b>Id:</b>
        <c:out value="${persoon.id}" /><br/>
        <b>Voornaam:</b>
        <c:out value="${persoon.voornaam}" /><br/>
        <b>Familienaam:</b>
        <c:out value="${persoon.familienaam}" /><br/>
        <b>E-mailadres:</b>
        <c:out value="${persoon.emailadres}" /><br/>
        <b>Paswoord:</b>
        <c:out value="${persoon.paswoord}" /><br/>
        <br/>
        <c:url var="home" value="/admin/home.html" />
        <a href='<c:out value="${home}"/>'>Admin Home</a>
    </body>
</html>
