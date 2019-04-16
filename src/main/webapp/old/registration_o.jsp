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
                        <li class="current_page_item"><a href="${pageContext.request.contextPath}/" title="">Homepage</a></li>
                        <li><a href="${pageContext.request.contextPath}/login">Log in</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div id="wrapper">
            <div id="featured-wrapper">
                <div>
                    <form>
                        <span>Choose language: </span>
                        <a href="${pageContext.request.contextPath}/registration/language/en">EN</a>
                        <a href="${pageContext.request.contextPath}/registration/language/ua">UA</a>

<%--                        <select id="language" name="language" onchange="submit()" class="byline">--%>
<%--                            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>--%>
<%--                            <option value="ua" ${language == 'ua' ? 'selected' : ''}>Українська</option>--%>
<%--                        </select>--%>
                    </form>
                </div>
                <div class="login-page">
                    <div class="form">
                        <form class="register-form" method="post" action="${pageContext.request.contextPath}/registration/submit">
                            <input type="text" name="login" placeholder="login" required="required"/> </br>
                            <input type="password" name="password" placeholder="password" required="required"/> </br>
                            <input type="text" name="name" placeholder="name"/> </br>
                            <input type="text" name="name_ua" placeholder="name(ukrainian)"/> </br>
                            <input type="text" name="surname" placeholder="surname"/> </br>
                            <input type="text" name="surname_ua" placeholder="surname(ukrainian)"/> </br>
                            <input type="text" name="email" placeholder="email address"/> </br>
                            <input type="text" name="phone_number" placeholder="phone number"/> </br>
                            <button>Sign up</button>
                        </form>
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
            </div>

        </div>

    </body>
</html>