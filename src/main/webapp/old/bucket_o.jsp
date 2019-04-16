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
                <div>
                    <form>
                        <span>Choose language: </span>
                        <a href="${pageContext.request.contextPath}/master/account/language/en">EN</a>
                        <a href="${pageContext.request.contextPath}/master/account/language/ua">UA</a>
                    </form>
                </div>

                <nav class="nav">
                    <ul class="nav__list">
                        <%--menu--%>
                    </ul>
                </nav>
                <div>
                    <c:set var="requests_in_process" scope="request" value="${requestScope.requests_in_process}"/>
                    <c:if test="${requests_in_process != null}">
                        <c:forEach items="${requests_in_process}" var="request">
                            <%--Implement buttons for accepted requests--%>
                            <form method="post" action="${pageContext.request.contextPath}/master/bucket/request/close">
                                <fieldset>
                                    <input hidden="hidden" name="id" value="${request.getId()}">
                                    Request id: <c:out value="${request.getId()}"/> <br>
                                    Product category: <c:out value="${request.getProductCategory()}"/> <br>
                                    Device: <c:out value="${request.getDevice()}"/> <br>
                                    Description: <c:out value="${request.getDescription()}"/> <br>
                                    Creation date: <c:out value="${request.getCreationDate()}"/> <br>
                                    Manager: <c:out value="${request.getManager_id()}"/> <br>
                                    <input type="submit" value="Fixed"/>
                                </fieldset>
                            </form>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
