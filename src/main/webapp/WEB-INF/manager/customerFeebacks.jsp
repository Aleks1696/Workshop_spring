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

        <%--Pagination --%>
        <%@ include file="/common/pagination.jsp" %>

        <div class="row content">
            <c:set var="customer_feedbacks" scope="request" value="${requestScope.customer_feedbacks}"/>
            <c:choose>
                <c:when test="${customer_feedbacks != null && !customer_feedbacks.isEmpty()}">
                    <c:forEach items="${customer_feedbacks}" var="feedback">
                        <div class="card">
                            <div class="card-header">
                                <fmt:message key="output.feedback.id"/> <c:out value="${feedback.getId()}"/>
                            </div>
                            <div class="card-body">
                                <p class="card-text"><fmt:message key="output.request.feedback"/> <c:out
                                        value="${feedback.getCommentary()}"/></p> <br>
                                <p class="card-text"><fmt:message key="output.request.mark"/> <c:out
                                        value="${feedback.getMark()}"/>;</p>
                            </div>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <h3><fmt:message key="jsp.no.customer.feedbacks"/></h3>
                </c:otherwise>
            </c:choose>
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
