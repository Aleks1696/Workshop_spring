<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="${sessionScope.get('language')}" />
<fmt:setBundle basename="messages"/>
<html>
    <head>
        <title>CustomerAccount</title>
    </head>

    <body>
        <div>
            <a href="${pageContext.request.requestURI}/language/en">EN</a>
            <a href="${pageContext.request.requestURI}/language/ua">UA</a>
        </div>

        <fmt:message key="input"/>
    </body>
</html>
