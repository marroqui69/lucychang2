<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom bij Netflix</title>
    </head>
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
 ul {
 	width:100%;
 	 list-style-type: none;
 }
li {
  font: 200 20px/1.5 Helvetica, Verdana, sans-serif;
  border-bottom: 1px solid #ccc;
  width:100%;
   list-style-type: none;
}
 
li:last-child {
  border: none;
}
 
li a {
  text-decoration: none;
  color: #000;
  display: block;
  width: 100%;
 
  -webkit-transition: font-size 0.3s ease, background-color 0.3s ease;
  -moz-transition: font-size 0.3s ease, background-color 0.3s ease;
  -o-transition: font-size 0.3s ease, background-color 0.3s ease;
  -ms-transition: font-size 0.3s ease, background-color 0.3s ease;
  transition: font-size 0.3s ease, background-color 0.3s ease;
}
 
li a:hover {
  font-size: 30px;
  background: #3498db;
  width: 100%;
  color:white;
}
</style>
    <body>
        <h1>Lijst van de tutorials</h1>
        <ul>
            <c:forEach items="${reclameberichten}" var="reclamebericht">
                <c:url var="reclameberichtUrl" value="/reclamebericht.html">
                    <c:param name="id" value="${reclamebericht.id}" />
                </c:url>
                <li>             
                    <a href='<c:out value="${reclameberichtUrl}"/>'>
                        <c:out value="${reclamebericht.titel}" />
                    </a>
                </li>
            </c:forEach>
        </ul>
        <br/>
        <br/>
        <c:url var="nieuwReclameberichtUrl" value="/nieuwReclamebericht.html?id=${reclamebericht.id}" />
        <a class="btn" href='<c:out value="${nieuwReclameberichtUrl}"/>'>Tutorial Toevoegen</a>
        <c:url var="logoutUrl" value="/logout" />
	    <form class="form-inline" action="${logoutUrl}" method="post">
	      <input type="submit" value="Log out" />
	      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    </form>    
    </body>
</html>
