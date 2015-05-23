<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de Brainstormapplicatie</title>
    </head>
    
    <body>
        <h1>Welkom in de brainstormsessie</h1>
        <c:out value="${rol.persoon.voornaam}" /> <c:out value="${rol.persoon.familienaam}" />,
        u speelt de rol van <c:out value="${rol.type}" /><br/><br/>
        <c:url var="menu" value="/menu.html" />
        <a href='<c:out value="${menu}"/>'>Menu</a><br/><br/>
        <c:url var="logoutUrl" value="/logout" />
	    <form class="form-inline" action="${logoutUrl}" method="post">
	      <input type="submit" value="Log out" />
	      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    </form>    
    </body>
</html>
