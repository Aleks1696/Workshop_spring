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
        </div>
        <div class="col-sm-8 text-center">

        </div>

        <c:set var="new_requests" scope="request" value="${requestScope.new_requests}"/>
        <c:if test="${new_requests != null}">
            <c:forEach items="${new_requests}" var="request">
                <div class="col-sm-4 text-center">
                    <div class="card" style="width: auto; border: #2b2b2b">
                        <div class="card-body">
                            <form>
                                <h5 class="card-title"><fmt:message key="output.request.request"/> <c:out value="${request.getId()}"/></h5>
                                <h6 class="card-subtitle mb-2 text-muted"><fmt:message key="output.request.device"/> <c:out value="${request.getDevice()}"/></h6>
                                <p class="card-text"><fmt:message key="output.request.product.category"/> <c:out value="${request.getProductCategory()}"/></p>
                                <p class="card-text"><fmt:message key="output.request.creation.date"/> <c:out value="${request.getCreationDate()}"/></p>
                                <p class="card-text"><fmt:message key="output.request.status"/> <c:out value="${request.getStatus()}"/></p>
                                <p class="card-text"><fmt:message key="output.request.customer.name"/> CLIENT NAME should be here</p>
                                <p>
                                    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#decline" aria-expanded="false" aria-controls="decline">
                                        <fmt:message key="jsp.manager.decline.button"/>
                                    </button>
                                    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#accept" aria-expanded="false" aria-controls="accept">
                                        <a href="" class="card-link"><fmt:message key="jsp.manager.accept.button"/></a>
                                    </button>
                                </p>
                                <div id="decline" class="collapse" >
                                    <div class="card card-body">
                                        <fmt:message key="output.request.manager.commentary"/> <input type="text" name="managerAcceptComment"/>
                                        <input type="submit" formaction="${pageContext.request.contextPath}/manager/active/request/decline" value="<fmt:message key="jsp.manager.submit.button"/>"/>
                                    </div>
                                </div>
                                <div id="accept" class="collapse" >
                                    <div class="card card-body">
                                        <fmt:message key="output.request.price"/> <input type="text" name="price"/> <br>
                                        <fmt:message key="output.request.manager.commentary"/> <input type="text" name="managerAcceptComment"/>
                                        <input type="submit" formaction="${pageContext.request.contextPath}/manager/active/request/accept" value="<fmt:message key="jsp.manager.submit.button"/>"/>
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
