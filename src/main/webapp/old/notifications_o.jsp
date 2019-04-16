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
                <li class="current_page_item"><a href="${pageContext.request.contextPath}/" title="">Homepage</a></li>
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
                <a href="${pageContext.request.contextPath}/customer/account/language/en">EN</a>
                <a href="${pageContext.request.contextPath}/customer/account/language/ua">UA</a>
            </form>

        </div>

        <div>
            <c:set var="requests_accomplished" scope="request" value="${requestScope.requests_accomplished}"/>
            <c:choose>
                <c:when test="${requests_accomplished != null}">
                    <c:forEach items="${requests_accomplished}" var="request">
                        <form method="post">
                            <fieldset>
                                <input hidden="hidden" name="id" value="${request.getId()}"/>
                                <p>Your device is fixed and ready for use. Please leave a comment bellow</p>
                                Request: <c:out value="${request.getId()}"/> <br>
                                Device: <c:out value="${request.getDevice()}"/> <br>
                                Status: <c:out value="${request.getStatus()}"/> <br>
                                <input type="submit" formaction="${pageContext.request.contextPath}/customer/request/archive" value="Archive"/>
                                <input type="submit" formaction="${pageContext.request.contextPath}/customer/feedback" value="Leave a feedback"/>
                            </fieldset>
                        </form>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <h1>There is no notifications for you right now</h1>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

</div>
</body>
</html>
