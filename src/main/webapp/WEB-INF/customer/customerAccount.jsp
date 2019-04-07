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
                    <h1><span class="fa fa-bolt"></span><a href="#">Workshop</a></h1>
                </div>
                <div id="menu">
                    <ul>
                        <li class="current_page_item"><a href="#" title="">Homepage</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout">Log out</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div id="wrapper">
            <div id="featured-wrapper">
                <%--Menu list (navigation bar)--%>
                <nav class="nav">
                    <ul class="nav__list">
                        <li class="nav__item"><a href="#">Create request</a></li>
                        <li class="nav__item"><a href="#">All requests</a></li>
                        <li class="nav__item"><a href="#">Update profile</a></li>
                    </ul>
                </nav>
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
                    <c:set var="activeRequests" scope="request" value="${requestScope.active_requests}"/>
                    <c:if test="${activeRequests != null}">
                        <c:forEach items="${activeRequests}" var="request">
                            <fieldset>
                                <c:out value="${request}"/>
                                <br>
                                <c:out value="${request.getPrice()}"/>
                            </fieldset>
                        </c:forEach>
                    </c:if>
                </div>


            </div>

        </div>
    </body>
</html>
