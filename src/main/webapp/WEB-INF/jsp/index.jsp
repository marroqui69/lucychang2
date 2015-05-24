<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom bij Lucy Chang</title>
    </head>
<style type="text/css">
	body {
	  margin: 0 auto;
	  padding: 40px 20px 20px 20px;
	  font-family: sans-serif;
	  color: #333;
	  line-height: 140%;
	}
	
	ul{
		list-style-type: none;
	}
	
	a {
	    color: #2098D1;
	    text-decoration: none;
	}
	
	[class^="hvr-"] {
	  /*display: inline-block;*/
	  /*vertical-align: middle;*/
	  margin: .4em;
	  padding: 1em;
	  cursor: pointer;
	  background: #e1e1e1;
	  text-decoration: none;
	  color: #666;
	  /* Prevent highlight colour when element is tapped */
	  -webkit-tap-highlight-color: rgba(0,0,0,0);
	}
	
	/* Underline From Center */
	.hvr-underline-from-center {
      min-width: 200px;
      text-align:center;
	  display: inline-block;
	  vertical-align: middle;
	  -webkit-transform: translateZ(0);
	  transform: translateZ(0);
	  box-shadow: 0 0 1px rgba(0, 0, 0, 0);
	  -webkit-backface-visibility: hidden;
	  backface-visibility: hidden;
	  -moz-osx-font-smoothing: grayscale;
	  position: relative;
	  overflow: hidden;
	}
	.hvr-underline-from-center:before {
	  content: "";
	  position: absolute;
	  z-index: -1;
	  left: 50%;
	  right: 50%;
	  bottom: 0;
	  background: #2098d1;
	  height: 4px;
	  -webkit-transition-property: left, right;
	  transition-property: left, right;
	  -webkit-transition-duration: 0.3s;
	  transition-duration: 0.3s;
	  -webkit-transition-timing-function: ease-out;
	  transition-timing-function: ease-out;
	}
	.hvr-underline-from-center:hover:before, .hvr-underline-from-center:focus:before, .hvr-underline-from-center:active:before {
	  left: 0;
	  right: 0;
	}    
</style>
    <body>
        <h1>Reclameberichten</h1>
        <ul>							
            <c:forEach items="${reclameberichten}" var="reclamebericht">
                <c:url var="reclameberichtUrl" value="/reclamebericht.html">
                    <c:param name="id" value="${reclamebericht.id}" />
                </c:url>
                <li>             
                    <a class="hvr-underline-from-center" href='<c:out value="${reclameberichtUrl}"/>'>
                       <c:out value="${reclamebericht.titel}" />
                    </a>
                </li>
            </c:forEach>
        </ul>
        <br/>
        <br/>
        <c:url var="nieuwReclameberichtUrl" value="/nieuwReclamebericht.html?id=${reclamebericht.id}" />
        <a class="hvr-underline-from-center" href='<c:out value="${nieuwReclameberichtUrl}"/>'>Reclamebericht toevoegen</a>
        <c:url var="logoutUrl" value="/logout" />
	    <form class="form-inline" action="${logoutUrl}" method="post">
	      <input type="submit" value="Log out" />
	      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    </form>    
    </body>
</html>
