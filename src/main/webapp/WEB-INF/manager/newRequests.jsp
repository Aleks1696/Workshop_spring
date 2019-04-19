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
            <c:set var="error_message" scope="request" value="${requestScope.error_message}"/>
            <c:if test="${error_message != null}">
                <c:forEach items="${error_message}" var="message">
                    <h3 class="errorMessage"><fmt:message key="${message}"/></h3>
                </c:forEach>
            </c:if>
        </div>

        <%--Pagination --%>
        <%@ include file="/common/pagination.jsp" %>

        <c:set var="new_requests" scope="request" value="${requestScope.new_requests}"/>
        <c:choose>
            <c:when test="${new_requests != null}">
                <c:forEach items="${new_requests}" var="request">
                    <div class="card">
                        <div class="card-header">
                            <fmt:message key="output.request.request"/> <c:out value="${request.getId()}"/>
                        </div>
                        <div class="card-body">
                            <form method="post">
                                <h6 class="card-subtitle mb-2 text-muted"><fmt:message key="output.request.device"/>
                                    <c:out
                                            value="${request.getDevice()}"/></h6>
                                <p class="card-text"><fmt:message key="output.request.product.category"/> <c:out
                                        value="${request.getProductCategory()}"/>;</p>
                                <p class="card-text"><fmt:message key="output.request.creation.date"/> <c:out
                                        value="${request.getCreationDate()}"/>;</p>
                                <p class="card-text"><fmt:message key="output.request.status"/> <c:out
                                        value="${request.getStatus()}"/>;</p>
                                <p class="card-text"><fmt:message key="output.request.customer.id"/><c:out
                                        value="${request.getCustomer_id()}"/>;</p> <br>
                                <a class="link" href="#decline" class="trigger-btn" data-toggle="modal"><span
                                        class="glyphicon"></span><fmt:message key="jsp.manager.decline.button"/></a>
                                <a class="link" href="#accept" class="trigger-btn" data-toggle="modal"><span
                                        class="glyphicon"></span><fmt:message key="jsp.manager.accept.button"/></a>

                                <div id="accept" class="modal fade">
                                    <div class="modal-dialog modal-login">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title">Please leave a comment</h4>
                                            </div>
                                            <div class="modal-body">
                                                <form method="post">
                                                    <input hidden="hidden" name="id" value="${request.getId()}">
                                                    <div class="form-group">
                                                        <input type="text" class="form-control" name="price"
                                                               placeholder="<fmt:message key="output.request.price"/>">
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="text" class="form-control"
                                                               name="managerAcceptComment"
                                                               placeholder="<fmt:message key="output.request.manager.commentary"/>">
                                                    </div>
                                                    <div class="form-group">
                                                        <button type="submit"
                                                                formaction="${pageContext.request.contextPath}/manager/active/request/accept"
                                                                class="btn btn-primary btn-lg btn-block login-btn">
                                                            <fmt:message key="jsp.manager.submit.button"/></button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div id="decline" class="modal fade">
                                    <div class="modal-dialog modal-login">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title">Please leave a comment</h4>
                                            </div>
                                            <div class="modal-body">
                                                <form method="post">
                                                    <input hidden="hidden" name="id" value="${request.getId()}">
                                                    <div class="form-group">
                                                        <input type="text" class="form-control"
                                                               name="managerDeclineComment"
                                                               placeholder="<fmt:message key="output.request.manager.commentary"/>">
                                                    </div>
                                                    <div class="form-group">
                                                        <button type="submit"
                                                                formaction="${pageContext.request.contextPath}/manager/active/request/decline"
                                                                class="btn btn-primary btn-lg btn-block login-btn">
                                                            <fmt:message key="jsp.manager.submit.button"/></button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <h3><fmt:message key="jsp.no.new.requests.message"/></h3>
            </c:otherwise>
        </c:choose>
    </div>
</div>

</div>
<%@ include file="/common/footer.jsp" %>
</body>
</html>
