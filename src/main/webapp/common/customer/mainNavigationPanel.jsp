<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Workshop</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/customer/account"><fmt:message
                        key="jsp.header.home.button"/></a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><fmt:message
                            key="jsp.header.language.button"/>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.request.contextPath}/customer/account/language/en">English</a></li>
                        <li><a href="${pageContext.request.contextPath}/customer/account/language/ua">Українська</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/logout"><span
                        class="glyphicon glyphicon-logout"></span> <fmt:message key="jsp.logout.label"/></a></li>
            </ul>
        </div>
    </div>
</nav>