<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom bij Lucy Chang</title>
        <style>
        	form, div{width:100%;}
        	input[type="text"]{width:70%;}
        	label{display:inline-block;width:180px;}
        	@media all (max-width: 582px)
        	{
        		input[type="text"]{
        			width: 100%;
        		}
        	}
       	</style>
    </head>
    
    <body>
        <h1>Edit Reclamebericht</h1>
        <c:url var="url" value="/update.html">
        	<c:param name="id" value="${updateReclame.id}" />
        </c:url>
      	<form:form action="${url}" commandName="updateReclame">   <%-- Spring form tags --%>
            <fieldset>
            	<div><label>Id:</label><form:input type="text" disabled="true" path="id"/></div>
                <div><label>Titel:</label><form:input type="text" path="titel"/></div>
                <div><label>Probleembeschrijving:</label><form:input type="text" path="prombleemOmschrijving"/></div>
                <div><label>Status:</label><form:input type="text" path="status"/></div>
                <div><label>Oplossing:</label><form:input type="text" path="oplossing"/></div>
                <div><input name="submit" type="submit" value="save"/></div>
            </fieldset>
        </form:form>
    </body>
</html>
