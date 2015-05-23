<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom bij Netflix</title>
    </head>
    
    <body>
        <h1>Tutorial toevoegen</h1>
        <c:url var="url" value="/nieuwReclamebericht.html" />
        <form:form action="${url}" commandName="reclameber">   <%-- Spring form tags --%>
            <fieldset>
                <div><label>Titel:</label><form:input path="titel"/></div>
                <div><label>Probleembeschrijving:</label><form:input path="prombleemOmschrijving"/></div>
                <div><label>Status:</label><form:input path="status"/></div>
                <div><label>Oplossing:</label><form:input path="oplossing"/></div>
                <div><input name="submit" type="submit" value="save"/></div>
            </fieldset>
        </form:form>
    </body>
</html>
