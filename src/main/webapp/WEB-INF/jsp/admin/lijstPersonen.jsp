<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de Brainstormapplicatie</title>
    </head>
    
    <body>
        <h1>Lijst van de personen</h1>
        <ul>
            <c:forEach items="${personen}" var="persoon">
                <c:url var="persoonUrl" value="persoon.html">
                    <c:param name="id" value="${persoon.id}" />
                </c:url>
                <li>
                    <a href='<c:out value="${persoonUrl}"/>'>
                        <c:out value="${persoon.voornaam}" />
                        <c:out value="${persoon.familienaam}" />
                    </a>
                </li>
            </c:forEach>
        </ul>
        <c:url var="nieuwePersoonUrl" value="nieuwePersoon.html" />
        <a href='<c:out value="${nieuwePersoonUrl}"/>'>Persoon Toevoegen</a><br/><br/>
        <c:url var="menu" value="/menu.html" />
        <a href='<c:out value="${menu}"/>'>Menu</a><br/><br/>
        <c:url var="logoutUrl" value="/logout" />
	    <form class="form-inline" action="${logoutUrl}" method="post">
	      <input type="submit" value="Log out" />
	      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    </form>    
    </body>
</html>
