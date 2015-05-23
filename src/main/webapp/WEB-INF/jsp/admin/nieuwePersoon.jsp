<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de Brainstormapplicatie</title>
    </head>
    
    <body>
        <h1>Persoon toevoegen</h1>
        <c:url var="url" value="/admin/nieuwePersoon.html" />
        <form:form action="${url}" commandName="depersoon">   <%-- Spring form tags --%>
            <fieldset>
                <div>
                    <label>Voornaam:</label><form:input path="voornaam"/>
                    <font color="red"><form:errors path="voornaam" /></font>
                </div>
                <div>
                    <label>Familienaam:</label><form:input path="familienaam"/>
                    <font color="red"><form:errors path="familienaam" /></font>
                </div>
                <div>
                    <label>E-mailadres:</label><form:input path="emailadres"/>
                    <font color="red"><form:errors path="emailadres" /></font>
                </div>
                <div>
                    <label>Paswoord:</label><form:input path="paswoord"/>
                    <font color="red"><form:errors path="paswoord" /></font>
                </div>
                <div><input name="submit" type="submit" value="save"/></div>
            </fieldset>
        </form:form>
    </body>
</html>
