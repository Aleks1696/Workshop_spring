<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/common/import.jsp"%>
<html lang="${language}">
<head>
    <%@ include file="/common/head.jsp" %>
</head>
<body>

<%@ include file="/common/master/mainNavigationPanel.jsp" %>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 float-sm-left sidenav text-left">
            <p><a href="${pageContext.request.contextPath}/master/bucket"><fmt:message key="jsp.master.left.sidenav.bucket.button"/></a></p>
            <p><a href="${pageContext.request.contextPath}/master/active/request"><fmt:message key="jsp.master.left.sidenav.requests_to_process.button"/></a></p>

            <%@ include file="/common/accountInfo.jsp" %>

        </div>
        <div class="col-sm-8 text-center">

        </div>

        <c:set var="requests_in_process" scope="request" value="${requestScope.requests_in_process}"/>
        <c:if test="${requests_in_process != null}">
            <c:forEach items="${requests_in_process}" var="request">
                <div class="col-sm-5 text-center">
                    <div class="card" style="width: auto">
                        <div class="card-body">
                            <form method="post" action="${pageContext.request.contextPath}/master/bucket/request/close">
                                <fieldset>
                                    <input hidden="hidden" name="id" value="${request.getId()}">
                                    <h5 class="card-title"><fmt:message key="output.request.request"/> <c:out value="${request.getId()}"/></h5>
                                    <h6 class="card-subtitle mb-2 text-muted"><fmt:message key="output.request.device"/> <c:out value="${request.getDevice()}"/></h6>
                                    <p class="card-text"><fmt:message key="output.request.product.category"/> <c:out value="${request.getProductCategory()}"/></p>
                                    <p class="card-text"><fmt:message key="output.request.description"/> <c:out value="${request.getDescription()}"/>"/></p>
                                    <p class="card-text"><fmt:message key="output.request.creation.date"/> <c:out value="${request.getCreationDate()}"/></p>
                                    <p class="card-text"><fmt:message key="output.request.status"/> <c:out value="${request.getStatus()}"/></p>
                                    <p class="card-text"><fmt:message key="output.request.manager"/> <c:out value="${request.getManager_id()}"/></p>
                                    <input type="submit" value="<fmt:message key="jsp.bucket.fixed.button"/>">
                                </fieldset>
                            </form>
                            </div>
                        </div>
                </div>
            </c:forEach>
        </c:if>
    </div>

</div>

<footer class="page-footer">
    <div class="footer-copyright text-center">
        <a href="https://github.com/Aleks1696/Workshop">Git repository</a>
    </div>
    <div class="footer-copyright text-center"> © 2019 Copyright:
        <a href="https://mdbootstrap.com/education/bootstrap/"> MDBootstrap.com</a>
    </div>
</footer>

</body>
</html>
