<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/common/import.jsp"%>

<html lang="${language}">

    <%@ include file="/common/head.jsp"%>

    <body>
        <div id="header-wrapper">
            <div id="header" class="container">
                <div id="logo">
                    <h1><span class="fa fa-bolt"></span><a href="#">Workshop</a></h1>
                </div>
                <div id="menu">
                    <ul>
                        <li class="current_page_item"><a href="${pageContext.request.contextPath}/index.jsp" title="">Homepage</a></li>
                        <li><a href="${pageContext.request.contextPath}/login.jsp">Log in</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div id="wrapper">
            <div id="featured-wrapper">
                <div>
                    <form>
                        <span>Choose language: </span>
                        <select id="language" name="language" onchange="submit()" class="byline">
                            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                            <option value="ua" ${language == 'ua' ? 'selected' : ''}>Українська</option>
                        </select>
                    </form>
                </div>
                <div>
                    <h2>Enter data:</h2>
                    <form action="${pageContext.request.contextPath}/registration" method="post">
                        Name: <input type="text" name="login" required="required"/>
                        Surname: <input type="text" name="password" required="required"/>
                        <input type="submit" value="Log in"/>
                    </form>
                </div>
                <div>
                    <c:set var="response" scope="request" value="${requestScope.login_error_message}"/>
                    <c:if test="${response != null}">
                        <fmt:message key="${response}"/>
                    </c:if>
                </div>


            </div>

        </div>

    </body>
</html>
