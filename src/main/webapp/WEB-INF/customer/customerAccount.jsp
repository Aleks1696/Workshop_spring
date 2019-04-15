<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/common/import.jsp"%>

<html lang="${language}">
<head>
    <%@ include file="/common/head.jsp" %>
</head>
<body>

<%@ include file="/common/customer/mainNavigationPanel.jsp" %>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 float-sm-left sidenav text-left">
            <p><a href="${pageContext.request.contextPath}/customer/request"><fmt:message key="jsp.customer.left.sidenav.create.request.button"/></a></p>
            <p><a href="${pageContext.request.contextPath}/customer/active/requests"><fmt:message key="jsp.customer.left.sidenav.active.requests.button"/></a></p>
            <p><a href="#"><fmt:message key="jsp.customer.left.sidenav.all.requests.button"/></a></p>
            <button type="button"
                       onclick="location.href='${pageContext.request.contextPath}/customer/notifications'">
                <fmt:message key="jsp.customer.left.sidenav.notifications.button"/>
            </button>

            <%@ include file="/common/accountInfo.jsp" %>

        </div>
        <div class="col-sm-8 text-center">

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
