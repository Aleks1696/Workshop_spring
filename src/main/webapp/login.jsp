<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.get('language')}" />
<fmt:setBundle basename="messages"/>
<html>
    <head>
        <title>Authorization</title>
    </head>

    <body>
        <div>
            <a href="${pageContext.request.requestURI}/language/en">EN</a>
            <a href="${pageContext.request.requestURI}/language/ua">UA</a>
        </div>
        <h2>Enter login and password:</h2>
        <form action="${pageContext.request.contextPath}/login" method="post">
            Login: <input type="text" name="login"/>
            Password: <input type="text" name="password"/>
            <input type="submit" value="Log in"/>
        </form>
        <fmt:message key="input"/>
    </body>
</html>
