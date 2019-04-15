<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/common/import.jsp"%>

<html lang="${language}">
    <head>
        <%@ include file="/common/head.jsp"%>
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
                            <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><fmt:message key="jsp.header.language.button"/> <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="${pageContext.request.contextPath}/language/en">English</a></li>
                                <li><a href="${pageContext.request.contextPath}/language/ua">Українська</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="${pageContext.request.contextPath}/registration" class="trigger-btn" data-toggle="modal"><span class="glyphicon glyphicon-registration-mark"></span>  <fmt:message key="jsp.registration.label"/></a></li>
                        <li><a href="${pageContext.request.contextPath}/login" class="trigger-btn" data-toggle="modal"><span class="glyphicon glyphicon-log-in"></span>  <fmt:message key="jsp.login.label"/></a></li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="container-fluid text-center">
            <div class="row content">
                <div class="col-sm-2 sidenav">
                    <ul class="nav md-pills pills-unique">
                        <li class="nav-item">
                            <a class="nav-link" href="#!">Link 1</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#!">Link 2</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#!">Link 3</a>
                        </li>
                    </ul>
                </div>
                <div class="col-sm-8 text-center">
                    <h1><fmt:message key="jsp.index.welcome.message"/></h1>
                    <p><fmt:message key="jsp.index.info.message"/></p>
                </div>
            </div>
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
