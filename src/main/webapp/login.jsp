<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/common/import.jsp" %>

<html lang="${language}">
<head>
    <%@ include file="/common/head.jsp" %>
    <style>
        <%@include file="/resources/css/bootstrap/login.css" %>
    </style>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Workshop</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/"><fmt:message
                        key="jsp.header.home.button"/></a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><fmt:message
                            key="jsp.header.language.button"/><span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.request.contextPath}/login/language/en">English</a></li>
                        <li><a href="${pageContext.request.contextPath}/login/language/ua">Українська</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/registration"><span
                        class="glyphicon glyphicon-log-in"></span> <fmt:message key="jsp.registration.label"/></a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="signin-form">
    <form action="${pageContext.request.contextPath}/login/submit" method="post">
        <h2><fmt:message key="jsp.login.label"/></h2>
        <p class="hint-text">
            <c:set var="error_message" scope="request" value="${requestScope.error_message}"/>
            <c:if test="${error_message != null}">
                <c:forEach items="${error_message}" var="message">
                    <fmt:message key="${message}"/>
                </c:forEach>
            </c:if>
        </p>
        <div class="form-group">
            <input type="text" class="form-control" name="login"
                   placeholder="<fmt:message key="jsp.placeholder.login"/>" required="required"
                   oninvalid="setCustomValidity('<fmt:message key="login.please.fill.in.field"/>')"
                   oninput="setCustomValidity('')" title="<fmt:message key="login.please.fill.in.field"/>"/> <br/>
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="password"
                   placeholder="<fmt:message key="jsp.placeholder.password"/>" required="required"
                   oninvalid="setCustomValidity('<fmt:message key="login.please.fill.in.field"/>')"
                   oninput="setCustomValidity('')" title="<fmt:message key="login.please.fill.in.field"/>"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block"><fmt:message
                    key="jsp.placeholder.login"/></button>
        </div>
    </form>
</div>
<%@ include file="/common/footer.jsp" %>
</body>
</html>
