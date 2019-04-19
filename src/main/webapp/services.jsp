<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/common/import.jsp" %>

<html lang="${language}">
<head>
    <%@ include file="/common/head.jsp" %>
    <style>
        <%@include file="/resources/css/bootstrap/services.css" %>
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
                            key="jsp.header.language.button"/> <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.request.contextPath}/services/language/en">English</a></li>
                        <li><a href="${pageContext.request.contextPath}/services/language/ua">Українська</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/registration" class="trigger-btn"
                       data-toggle="modal"><span class="glyphicon glyphicon-registration-mark"></span> <fmt:message
                        key="jsp.registration.label"/></a></li>
                <li><a href="${pageContext.request.contextPath}/login" class="trigger-btn" data-toggle="modal"><span
                        class="glyphicon glyphicon-log-in"></span> <fmt:message key="jsp.login.label"/></a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <ul class="nav md-pills pills-unique">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/services">Our services</a>
                </li>
            </ul>
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2 col-sm-6">
                    <div class="serviceBox">
                        <div class="service-content">
                            <div class="service-icon">
                                <i class="fa fa-globe"></i>
                            </div>
                            <h3 class="title"><fmt:message key="jsp.services.card.electric.appliance"/></h3>
                            <p class="description">
                                <fmt:message key="jsp.services.card.electric.appliance.message"/>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-2 col-sm-6">
                    <div class="serviceBox green">
                        <div class="service-content">
                            <div class="service-icon">
                                <i class="fa fa-users"></i>
                            </div>
                            <h3 class="title"><fmt:message key="jsp.services.card.pc"/></h3>
                            <p class="description">
                                <fmt:message key="jsp.services.card.pc.message"/>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-2 col-sm-6">
                    <div class="serviceBox">
                        <div class="service-content">
                            <div class="service-icon">
                                <i class="fa fa-globe"></i>
                            </div>
                            <h3 class="title"><fmt:message key="jsp.services.card.furniture"/></h3>
                            <p class="description">
                                <fmt:message key="jsp.services.card.furniture.message"/>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-2 col-sm-6">
                    <div class="serviceBox green">
                        <div class="service-content">
                            <div class="service-icon">
                                <i class="fa fa-users"></i>
                            </div>
                            <h3 class="title"><fmt:message key="jsp.services.card.accessories"/></h3>
                            <p class="description">
                                <fmt:message key="jsp.services.card.accessories.message"/>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="/common/footer.jsp" %>
    </div>
</div>
</body>
</html>
