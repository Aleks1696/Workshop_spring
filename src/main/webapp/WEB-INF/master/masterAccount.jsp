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
                        <li class="current_page_item"><a href="#" title="">Homepage</a></li>
                        <li><a href="#">Log out</a></li>
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
                    <c:set var="response" scope="request" value="${requestScope.login_error_message}"/>
                    <c:if test="${response != null}">
                        <fmt:message key="${response}"/>
                    </c:if>
                </div>


            </div>

        </div>
    </body>
</html>
