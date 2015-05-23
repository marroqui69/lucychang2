<%@page import="org.springframework.security.web.WebAttributes"%>
<%@page import="org.springframework.security.core.AuthenticationException"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Brainstorm Login</title>
    </head>
    <body>
        <h1>Login aub</h1>

        <div class="section">
                <c:if test="${not empty param.login_error}">
                        <div class="errors">
                                Er was een probleem om aan te loggen<br />Boodschap:
                                <%= ((AuthenticationException)
                                        session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION)).getMessage() %>
                                <br /> <br /> 
                        </div>
                </c:if>
        </div>

        <div class="section">
            <form name="f" action="<c:url value='/login' />" method="POST">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <fieldset>
                    <div class="field">
                            <div class="label"><label for="username">E-mailadres:</label></div>
                            <div class="output">
                                    <input type="text" name="username" id="username"  />
                            </div>
                    </div>
                    <div class="field">
                            <div class="label"><label for="password">Paswoord:</label></div>
                            <div class="output">
                                    <input type="password" name="password" id="password" />
                            </div>
                    </div>
                    <div class="form-buttons">
                        <div class="button">
                            <input name="submit" id="submit" type="submit" value="Login" />
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </body>
</html>
