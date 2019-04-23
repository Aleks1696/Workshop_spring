<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/common/import.jsp" %>

<html lang="${language}">
<head>
    <%@ include file="/common/head.jsp" %>
    <style>
        <%@include file="/resources/css/bootstrap/popUp.css" %>
    </style>
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
        </div>
        <div class="col-sm-8 text-center">
        </div>

        <c:set var="error_message" scope="request" value="${requestScope.error_message}"/>
        <c:if test="${error_message != null}">
            <c:forEach items="${error_message}" var="message">
                <h3 class="errorMessage"><fmt:message key="${message}"/></h3>
            </c:forEach>
        </c:if>

        <c:set var="requests_accomplished" scope="request" value="${requestScope.requests_accomplished}"/>
        <c:choose>
            <c:when test="${!requests_accomplished.isEmpty()}">
                <c:forEach items="${requests_accomplished}" var="request">
                    <div class="card">
                        <div class="card-header">
                            <h4>
                                <c:choose>
                                    <c:when test="${request.getStatus() == 'DECLINED'}">
                                        <p class="card-text"><fmt:message key="output.request.manager.commentary"/>
                                            <c:out value="${request.getManagerComment()}"/> </p>
                                    </c:when>
                                    <c:otherwise>
                                        <fmt:message
                                                key="jsp.notifications.device.is.fixed.message"/>
                                    </c:otherwise>
                                </c:choose>
                            </h4>
                        </div>
                        <div class="card-body">
                            <form method="post" action="">
                                <input hidden="hidden" name="id" value="${request.getId()}"/>
                                <p class="card-text"><fmt:message key="output.request.device"/> <c:out
                                        value="${request.getDevice()}"/>;</p>
                                <p class="card-text"><fmt:message key="output.request.creation.date"/> <c:out
                                        value="${request.getCreationDate()}"/>;</p>
                                <p class="card-text"><fmt:message key="output.request.status"/> <c:out
                                        value="${request.getStatus()}"/>;</p> <br>
                                <form method="post">
                                    <input class="buttonLikeLink" type="submit"
                                           formaction="${pageContext.request.contextPath}/customer/request/archive" value="<fmt:message
                                        key="jsp.notifications.archive.button"/>"/>
                                </form>
                                <a class="link" href="#feedback" class="trigger-btn" data-toggle="modal"><fmt:message
                                        key="jsp.notifications.leave.feedback.button"/></a>

                                <div id="feedback" class="modal fade">
                                    <div class="modal-dialog modal-login">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title"><fmt:message
                                                        key="jsp.notifications.accept/decline.form.title"/></h4>
                                            </div>
                                            <div class="modal-body">
                                                <form method="post">
                                                    <input hidden="hidden" name="id" value="${request.getId()}">
                                                    <div class="form-group">
                                                        <input type="radio" id="star5" name="mark"
                                                               value="GREAT" required="required"/><label>GREAT</label>
                                                        <input type="radio" id="star4" name="mark"
                                                               value="FINE"/><label>FINE</label>
                                                        <input type="radio" id="star3" name="mark"
                                                               value="NORMAL"/><label>NORMAL</label>
                                                        <input type="radio" id="star2" name="mark"
                                                               value="BAD"/><label>BAD</label>
                                                        <input type="radio" id="star1" name="mark"
                                                               value="TERRIBLE"/><label>TERRIBLE</label>
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="text" class="form-control" name="commentary"
                                                               placeholder="<fmt:message key="jsp.placeholder.feedback"/>"
                                                               oninvalid="setCustomValidity('<fmt:message
                                                                       key="login.please.fill.in.field"/>')"
                                                               oninput="setCustomValidity('')"
                                                               title="<fmt:message key="login.please.fill.in.field"/>"/>
                                                    </div>
                                                    <div class="form-group">
                                                        <button type="submit"
                                                                formaction="${pageContext.request.contextPath}/customer/feedback/leave"
                                                                class="btn btn-primary btn-lg btn-block login-btn">
                                                            <fmt:message
                                                                    key="jsp.notifications.submit.button"/></button>
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
                <div class="col-sm-8 text-center">
                    <h3><fmt:message key="jsp.notifications.no.notifications.message"/></h3>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<%@ include file="/common/footer.jsp" %>
</body>
</html>
