<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/common/import.jsp"%>

<html lang="${language}">
    <head>
        <%@ include file="/common/head.jsp"%>
        <style><%@include file="/resources/css/bootstrap/form.css"%></style>
    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Workshop</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="${pageContext.request.contextPath}/"><fmt:message key="jsp.header.home.button"/></a></li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><fmt:message key="jsp.header.language.button"/><span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="${pageContext.request.contextPath}/registration/language/en">English</a></li>
                                <li><a href="${pageContext.request.contextPath}/registration/language/ua">Українська</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="${pageContext.request.contextPath}/login" class="trigger-btn" data-toggle="modal"><span class="glyphicon glyphicon-log-in"></span>  <fmt:message key="jsp.login.label"/></a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="signup-form">
            <form action="${pageContext.request.contextPath}/registration/submit" method="post">
                <h2>Registration</h2>
                <p class="hint-text">
                    <c:set var="error_message" scope="request" value="${requestScope.error_message}"/>
                    <c:if test="${error_message != null}">
                        <c:forEach items="${error_message}" var="message">
                            <fmt:message key="${message}"/>
                        </c:forEach>
                    </c:if>
                </p>
                <div class="form-group">
                    <input type="text" class="form-control" name="login" placeholder="<fmt:message key="jsp.placeholder.login"/>" required="required">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" placeholder="<fmt:message key="jsp.placeholder.password"/>" required="required">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="name" placeholder="<fmt:message key="jsp.placeholder.name"/>" required="required">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="name_ua" placeholder="<fmt:message key="jsp.placeholder.name_ua"/>" required="required">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="surname" placeholder="<fmt:message key="jsp.placeholder.surname"/>" required="required">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="surname_ua" placeholder="<fmt:message key="jsp.placeholder.surname_ua"/>" required="required">
                </div>
                <div class="form-group">
                    <input type="email" class="form-control" name="email" placeholder="<fmt:message key="jsp.placeholder.email"/>" required="required">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="phone_number" placeholder="<fmt:message key="jsp.placeholder.phoneNumber"/>" required="required">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-lg btn-block"><fmt:message key="jsp.registration.signUp.button"/></button>
                </div>
            </form>
        </div>

    <footer class="page-footer">
        <div class="footer-copyright text-center">
            <a href="https://github.com/Aleks1696/Workshop">Git repository</a>
        </div>
        <div class="footer-copyright text-center">© 2019 Copyright:
            <a href="https://mdbootstrap.com/education/bootstrap/"> MDBootstrap.com</a>
        </div>
    </footer>

    </body>
</html>
