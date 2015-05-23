<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom bij Netflix</title>
        <style>label{width:160px;}
        		.btn{
  background: #3498db;
  background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
  background-image: -moz-linear-gradient(top, #3498db, #2980b9);
  background-image: -ms-linear-gradient(top, #3498db, #2980b9);
  background-image: -o-linear-gradient(top, #3498db, #2980b9);
  background-image: linear-gradient(to bottom, #3498db, #2980b9);
  -webkit-border-radius: 28;
  -moz-border-radius: 28;
  border-radius: 28px;
  font-family: Arial;
  color: #ffffff;
  font-size: 20px;
  padding: 10px 20px 10px 20px;
  text-decoration: none;
}

.btn:hover {
  background: #3cb0fd;
  background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -o-linear-gradient(top, #3cb0fd, #3498db);
  background-image: linear-gradient(to bottom, #3cb0fd, #3498db);
  text-decoration: none;
}
</style>
    </head>
    
    <body>
        <h1>Tutorial details</h1>
        <b>Id:</b>
        <c:out value="${reclamebericht.id}" /><br/>
        <div>
	        <b>Titel:</b>
	        <c:out value="${reclamebericht.titel}" /><br/>
	        <b>Probleembeschrijving:</b>
	        <c:out value="${reclamebericht.prombleemOmschrijving}" /><br/>
	        <b>status:</b>
	        <c:out value="${reclamebericht.status}" /><br/>
	        <b>oplossing:</b>
	     
	        <c:url var="del" value="${reclamebericht.oplossing}" />
	        <a href='<c:out value="${del}"/>'>Oplossing link</a>
	        <br/>
	        <br/>
	        <c:url var="update" value="/reclameberichtUpdate.html">
	        	<c:param name="id" value="${reclamebericht.id}" />
	        </c:url>
	        <a class="btn" href='<c:out value="${update}"/>'>Edit</a>
	        
	        <c:url var="del" value="/deletereclambericht.html">
	        	<c:param name="id" value="${reclamebericht.id}" />
	        </c:url>
	        <a class="btn" href='<c:out value="${del}"/>'>Delete</a>
	        
	        <c:url var="home" value="/home.html" />
	        <a class="btn" href='<c:out value="${home}"/>'>Home</a>
	         <c:url var="logoutUrl" value="/logout" />
	    <form class="form-inline" action="${logoutUrl}" method="post">
	      <input type="submit" value="Log out" />
	      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    </form>    
        </div>
    </body>
</html>
