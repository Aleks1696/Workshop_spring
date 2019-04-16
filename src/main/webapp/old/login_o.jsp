<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/common/import.jsp"%>

<html lang="${language}">
    <head>
        <%@ include file="/common/head.jsp"%>
    </head>
    <body>
        <div id="header-wrapper">
            <div id="header" class="container">
                <div id="logo">
                    <h1><span class="fa fa-bolt"></span><a href="${pageContext.request.contextPath}/">Workshop</a></h1>
                </div>
                <div id="menu">
                    <ul>
                        <li>
                            <div>
                                <span>Choose language: </span>
                                <a href="${pageContext.request.contextPath}/login/language/en">EN</a>
                                <a href="${pageContext.request.contextPath}/login/language/ua">UA</a>
                            </div>
                        </li>
                        <li class="current_page_item"><a href="${pageContext.request.contextPath}/" title="">Homepage</a></li>
                        <li><a href="${pageContext.request.contextPath}/registration">Registration</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div id="wrapper">
            <div id="featured-wrapper">
                <div>
                    <span>Choose language: </span>
                    <a href="${pageContext.request.contextPath}/login/language/en">EN</a>
                    <a href="${pageContext.request.contextPath}/login/language/ua">UA</a>
                </div>
                <div>
                    <h2>Enter login and password:</h2>
                    <form action="${pageContext.request.contextPath}/login/submit" method="post">
                        Login: <input type="text" name="login" required="required"/>
                        Password: <input type="text" name="password" required="required"/>
                        <input type="submit" value="Log in"/>
                    </form>
                </div>
                <div>
                    <c:set var="error_message" scope="request" value="${requestScope.error_message}"/>
                    <c:if test="${error_message != null}">
                        <c:forEach items="${error_message}" var="message">
                            <fmt:message key="${message}"/>
                        </c:forEach>
                    </c:if>
                </div>


            </div>

        </div>

        <div id="copyright" class="container">
            <p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
        </div>
    </body>

<%--    <body>--%>
<%--        <form>--%>
<%--            Choose language:--%>
<%--            <select id="language" name="language" onchange="submit()">--%>
<%--                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>--%>
<%--                <option value="ua" ${language == 'ua' ? 'selected' : ''}>Українська</option>--%>
<%--            </select>--%>
<%--        </form>--%>

<%--        <h2>Enter login and password:</h2>--%>
<%--        <form action="${pageContext.request.contextPath}/login" method="post">--%>
<%--            Login: <input type="text" name="login" required="required"/>--%>
<%--            Password: <input type="text" name="password" required="required"/>--%>
<%--            <input type="submit" value="Log in"/>--%>
<%--        </form>--%>
<%--        <div>--%>
<%--&lt;%&ndash;            <jstl:if test="${not empty requestScope.login_error_message}">&ndash;%&gt;--%>
<%--&lt;%&ndash;                <p><fmt:message key=""/></p>&ndash;%&gt;--%>
<%--&lt;%&ndash;            </jstl:if>&ndash;%&gt;--%>
<%--            <c:set var="response" scope="request" value="${requestScope.login_error_message}"/>--%>
<%--            <c:if test="${response != null}">--%>
<%--                <fmt:message key="${response}"/>--%>
<%--            </c:if>--%>
<%--        </div>--%>

<%--    </body>--%>
</html>
