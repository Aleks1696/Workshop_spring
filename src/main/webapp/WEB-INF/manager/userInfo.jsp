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
            <div style="margin: 15px 40px 10px 40px" class="col-sm-4 text-center">
                <form method="post" action="${pageContext.request.contextPath}/manager/find/customer/result">
                    <input type="text" class="form-control" name="id" placeholder="Customer id ..."/>
                    <button type="submit"><span class="glyphicon glyphicon-search"></span></button>
                </form>
            </div>
        </div>

        <div class="col-sm-10 text-center">
            <c:set var="error_message" scope="request" value="${requestScope.error_message}"/>
            <c:if test="${error_message != null}">
                <c:forEach items="${error_message}" var="message">
                    <h3 class="errorMessage"><fmt:message key="${message}"/></h3>
                </c:forEach>
            </c:if>
        </div>

        <div style="margin: 100px 10px 10px 10px" class="row content">
            <c:set var="customer" scope="request" value="${requestScope.customer}"/>
            <c:if test="${customer != null}">
            <div class="card">
                <div class="card-header">
                    <fmt:message key="output.request.customer.id"/> <c:out value="${customer.getId()}"/>
                </div>
                <div class="card-body">
                    <c:choose>
                        <c:when test="${language == 'en'}">
                            <h5 class="card-title"><fmt:message key="output.request.customer.name"/>
                                <c:out value="${customer.getName()}"/>
                                <c:out value="${customer.getSurname()}"/>
                            </h5>
                        </c:when>
                        <c:otherwise>
                            <h5 class="card-title"><fmt:message key="output.request.customer.name"/>
                                <c:out value="${customer.getName_ua()}"/>
                                <c:out value="${customer.getSurname_ua()}"/>
                            </h5>
                        </c:otherwise>
                    </c:choose>
                    <p class="card-text"><fmt:message key="output.request.customer.email"/> <c:out
                            value="${customer.getEmail()}"/></p> <br>
                    <p class="card-text"><fmt:message key="output.request.customer.phoneNumber"/> <c:out
                            value="${customer.getPhoneNumber()}"/>;</p>
                    <form method="post">
                        <input type="hidden" name="id" value="${customer.getId()}"/>
                        <input type="submit" formaction="${pageContext.request.contextPath}/manager/requests/from/customer" value="Requests"/>
                        <input type="submit" formaction="${pageContext.request.contextPath}/manager/feedback/from/customer" value="Feedbacks"/>
                    </form>
                </div>
            </div>

        </div>
        </c:if>
    </div>


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
