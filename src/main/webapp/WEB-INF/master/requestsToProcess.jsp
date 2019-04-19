<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/common/import.jsp" %>

<html lang="${language}">
<head>
    <%@ include file="/common/head.jsp" %>
</head>
<body>

<%@ include file="/common/master/mainNavigationPanel.jsp" %>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 float-sm-left sidenav text-left">
            <p><a href="${pageContext.request.contextPath}/master/bucket"><fmt:message
                    key="jsp.master.left.sidenav.bucket.button"/></a></p>
            <p><a href="${pageContext.request.contextPath}/master/active/request"><fmt:message
                    key="jsp.master.left.sidenav.requests_to_process.button"/></a></p>

            <%@ include file="/common/accountInfo.jsp" %>

        </div>
        <div class="col-sm-8 text-center">
        </div>

        <%--Pagination --%>
        <%@ include file="/common/pagination.jsp" %>

        <c:set var="requests_to_process" scope="request" value="${requestScope.requests_to_process}"/>
        <c:if test="${requests_to_process != null}">
            <c:forEach items="${requests_to_process}" var="request">
                <div class="card">
                    <div class="card-header">
                        <fmt:message key="output.request.request"/> <c:out value="${request.getId()}"/>
                    </div>
                    <div class="card-body">
                        <form method="post" action="${pageContext.request.contextPath}/master/active/request/process">
                            <input hidden="hidden" name="id" value="${request.getId()}">
                            <h5 class="card-title"><fmt:message key="output.request.device"/> <c:out
                                    value="${request.getDevice()}"/></h5>
                            <p class="card-text"><fmt:message key="output.request.product.category"/> <c:out
                                    value="${request.getProductCategory()}"/>;</p>
                            <p class="card-text"><fmt:message key="output.request.description"/> <c:out
                                    value="${request.getDescription()}"/>";</p>
                            <p class="card-text"><fmt:message key="output.request.status"/> <c:out
                                    value="${request.getStatus()}"/></p> <br>
                            <input type="submit" value="<fmt:message key="jsp.master.process.button"/>">
                        </form>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
</div>
</div>
<%@ include file="/common/footer.jsp" %>
</body>
</html>
