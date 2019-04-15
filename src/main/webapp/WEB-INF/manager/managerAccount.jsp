<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/common/import.jsp"%>

<html lang="${language}">
<head>
    <%@ include file="/common/head.jsp" %>
</head>
<body>

<%@ include file="/common/manager/mainNavigationPanel.jsp" %>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 float-sm-left sidenav text-left">
            <p><a href="${pageContext.request.contextPath}/manager/active/request"><fmt:message key="jsp.manager.left.sidenav.new.requests.button"/></a></p>

            <%@ include file="/common/accountInfo.jsp" %>

        </div>

        <div class="col-sm-8 text-center">

        </div>

        <c:set var="new_requests" scope="request" value="${requestScope.new_requests}"/>
        <c:if test="${new_requests != null}">
            <c:forEach items="${new_requests}" var="request">
                <div class="col-sm-4 text-center">
                    <div class="card" style="width: auto; border: #2b2b2b">
                        <div class="card-body">
                            <form method="post">
                                <h5 class="card-title"><fmt:message key="output.request.request"/> <c:out value="${request.getId()}"/></h5>
                                <h6 class="card-subtitle mb-2 text-muted"><fmt:message key="output.request.device"/> <c:out value="${request.getDevice()}"/></h6>
                                <p class="card-text"><fmt:message key="output.request.product.category"/> <c:out value="${request.getProductCategory()}"/></p>
                                <p class="card-text"><fmt:message key="output.request.creation.date"/> <c:out value="${request.getCreationDate()}"/></p>
                                <p class="card-text"><fmt:message key="output.request.status"/> <c:out value="${request.getStatus()}"/></p>
                                <p class="card-text"><fmt:message key="output.request.customer.name"/> CLIENT NAME should be here</p>
                                <a href="#decline" class="trigger-btn" data-toggle="modal"><span class="glyphicon"></span><fmt:message key="jsp.manager.decline.button"/></a>
                                <a href="#accept" class="trigger-btn" data-toggle="modal"><span class="glyphicon"></span><fmt:message key="jsp.manager.accept.button"/></a>

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
                                                        <input type="text" class="form-control" name="price" placeholder="<fmt:message key="output.request.price"/>">
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="text" class="form-control" name="managerAcceptComment" placeholder="<fmt:message key="output.request.manager.commentary"/>">
                                                    </div>
                                                    <div class="form-group">
                                                        <button type="submit" formaction="${pageContext.request.contextPath}/manager/active/request/accept" class="btn btn-primary btn-lg btn-block login-btn"><fmt:message key="jsp.manager.submit.button"/></button>
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
                                                        <input type="text" class="form-control" name="managerDeclineComment" placeholder="<fmt:message key="output.request.manager.commentary"/>">
                                                    </div>
                                                    <div class="form-group">
                                                        <button type="submit" formaction="${pageContext.request.contextPath}/manager/active/request/decline" class="btn btn-primary btn-lg btn-block login-btn"><fmt:message key="jsp.manager.submit.button"/></button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
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
