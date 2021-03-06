<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/common/import.jsp" %>

<html lang="${language}">
<head>
    <%@ include file="/common/head.jsp" %>
</head>
<body>
<%@ include file="/common/customer/mainNavigationPanel.jsp" %>
<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 float-sm-left sidenav text-left">
            <p><a href="${pageContext.request.contextPath}/customer/request"><fmt:message
                    key="jsp.customer.left.sidenav.create.request.button"/></a></p>
            <p><a href="${pageContext.request.contextPath}/customer/active/requests"><fmt:message
                    key="jsp.customer.left.sidenav.active.requests.button"/></a></p>
            <button type="button"
                    onclick="location.href='${pageContext.request.contextPath}/customer/notifications'">
                <fmt:message key="jsp.customer.left.sidenav.notifications.button"/>
            </button>

            <%@ include file="/common/accountInfo.jsp" %>

        </div>
        <div class="col-sm-8 text-center">
        </div

        <%--Pagination --%>
        <%@ include file="/common/pagination.jsp" %>

        <c:set var="active_requests" scope="request" value="${requestScope.active_requests}"/>
        <c:choose>
            <c:when test="${!active_requests.isEmpty()}">
                <c:forEach items="${active_requests}" var="request">
                    <div class="card">
                        <div class="card-header">
                            <fmt:message key="output.request.request"/> <c:out value="${request.getId()}"/>
                        </div>
                        <div class="card-body">
                            <h5 class="card-title"><fmt:message key="output.request.device"/> <c:out
                                    value="${request.getDevice()}"/></h5>
                            <p class="card-text"><fmt:message key="output.request.product.category"/> <c:out
                                    value="${request.getProductCategory()}"/>;</p>
                            <p class="card-text"><fmt:message key="output.request.creation.date"/> <c:out
                                    value="${request.getCreationDate()}"/>;</p>
                            <p class="card-text"><fmt:message key="output.request.status"/> <c:out
                                    value="${request.getStatus()}"/>;</p>
                            <c:if test="${request.getPrice() != null}">
                                <p class="card-text"><fmt:message key="output.request.price"/> <c:out
                                        value="${request.getPrice()}"/></p>
                            </c:if>
                            <c:if test="${!request.getManagerComment().isEmpty()}">
                                <p class="card-text"><fmt:message key="output.request.manager.commentary"/> <c:out
                                        value="${request.getManagerComment()}"/></p>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <div class="col-sm-8 text-center">
                    <h3><fmt:message key="jsp.no.active.requests.message"/></h3>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

</div>
<%@ include file="/common/footer.jsp" %>
</body>
</html>
