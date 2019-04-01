<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${sessionScope.get('language')}" />
<fmt:setBundle basename="messages"/>
<html lang="${language}">
    <head>
       <title>Workshop</title>
    </head>

    <body>
        <form>
            Choose language:
            <select id="language" name="language" onchange="submit()">
                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                <option value="ua" ${language == 'ua' ? 'selected' : ''}>Українська</option>
            </select>
        </form>

        <a href="${pageContext.request.contextPath}/login.jsp">Log in</a>
        <a href="${pageContext.request.contextPath}/registration.jsp">Registration</a>

        <fmt:message key="input"/>
    </body>
</html>
