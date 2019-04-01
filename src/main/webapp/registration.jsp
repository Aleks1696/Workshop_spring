<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${sessionScope.get('language')}" />
<fmt:setBundle basename="messages"/>
<html>
    <head>
        <title>Registration</title>
    </head>
    <body>
        <form>
            Choose language:
            <select id="language" name="language" onchange="submit()">
                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                <option value="ua" ${language == 'ua' ? 'selected' : ''}>Українська</option>
            </select>
        </form>
        <h2>Enter your:</h2>
        <form action="${pageContext.request.contextPath}/login" method="post">
            Login: <input type="text" name="login"/>
            Password: <input type="text" name="password"/>
            <input type="submit" value="Log in"/>
        </form>
    </body>
</html>
