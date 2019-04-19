<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/common/import.jsp" %>

<html lang="${language}">
<head>
    <%@ include file="/common/head.jsp" %>
</head>
<body>

<%@ include file="/common/manager/mainNavigationPanel.jsp" %>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 float-sm-left sidenav text-left">
            <p><a href="${pageContext.request.contextPath}/manager/active/request"><fmt:message
                    key="jsp.manager.left.sidenav.new.requests.button"/></a></p>
            <p><a href="${pageContext.request.contextPath}/manager/find/customer"><fmt:message
                    key="jsp.manager.left.sidenav.customer.by.id.button"/></a></p>

            <%@ include file="/common/accountInfo.jsp" %>
        </div>
        <div class="col-sm-8 text-center">
        </div>
    </div>
</div>
<%@ include file="/common/footer.jsp" %>
</body>
</html>
