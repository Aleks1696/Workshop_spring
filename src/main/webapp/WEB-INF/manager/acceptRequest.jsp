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
                        <a href="${pageContext.request.contextPath}/manager/account/language/en">EN</a>
                        <a href="${pageContext.request.contextPath}/manager/account/language/ua">UA</a>
                    </form>
                </div>
                <div>
                    <c:set var="newRequests" scope="request" value="${requestScope.new_requests}"/>
                    <c:if test="${newRequests != null}">
                        <c:forEach items="${newRequests}" var="request">
                            <form method="post">
                                <div>
                                    <c:set var="error_message" scope="request" value="${requestScope.error_message}"/>
                                    <c:if test="${error_message != null}">
                                        <c:forEach items="${error_message}" var="message">
                                            <fmt:message key="${message}"/>
                                        </c:forEach>
                                    </c:if>
                                </div>
                                <fieldset>
                                    <input hidden="hidden" name="id" value="${request.getId()}">
                                    Request id: <c:out value="${request.getId()}"/> <br>
                                    Product category: <c:out value="${request.getProductCategory()}"/> <br>
                                    Device: <c:out value="${request.getDevice()}"/> <br>
                                    Description: <c:out value="${request.getDescription()}"/> <br>
                                    Creation date: <c:out value="${request.getCreationDate()}"/> <br>
                                    Closing date: <c:out value="${request.getCreationDate()}"/> <br>
                                    Price: <input type="text" name="price"/> <br>
                                    Manager commentary: <input type="text" name="managerComment"/>
                                    <input type="submit" formaction="${pageContext.request.contextPath}/manager/active/request/accept/submit" value="Submit"/>
                                </fieldset>
                            </form>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
