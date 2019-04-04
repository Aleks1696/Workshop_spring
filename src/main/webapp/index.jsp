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
                    <li><a href="">Services</a></li>
                    <li><a href="${pageContext.request.contextPath}/registration.jsp">Registration</a></li>
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
            <div id="featured" class="margin-btm container">
                <div class="main-title">
                    <h2>Welcome in our workshop</h2>
                    <span class="byline">In order to create a new request please sign in first</span>
                </div>
            </div>
        </div>

    </div>

    <div id="copyright" class="container">
        <p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
    </div>
    </body>


<%--    <head>--%>
<%--       <title>Workshop</title>--%>
<%--    </head>--%>

<%--    <body>--%>
<%--        <form>--%>
<%--            Choose language:--%>
<%--            <select id="language" name="language" onchange="submit()">--%>
<%--                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>--%>
<%--                <option value="ua" ${language == 'ua' ? 'selected' : ''}>Українська</option>--%>
<%--            </select>--%>
<%--        </form>--%>

<%--        <a href="${pageContext.request.contextPath}/login.jsp">Log in</a>--%>
<%--        <a href="${pageContext.request.contextPath}/registration.jsp">Registration</a>--%>

<%--    </body>--%>
</html>
