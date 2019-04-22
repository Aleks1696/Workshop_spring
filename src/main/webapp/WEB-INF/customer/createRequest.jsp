<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/common/import.jsp" %>

<html lang="${language}">
<head>
    <%@ include file="/common/head.jsp" %>
    <style>
        <%@include file="/resources/css/bootstrap/form.css" %>
    </style>
</head>
<body>
<%@ include file="/common/customer/mainNavigationPanel.jsp" %>
<div class="signup-form" style="width: 600px;">
    <form action="${pageContext.request.contextPath}/customer/request/submit" method="post">
        <h2><fmt:message key="jsp.request.new.request.label"/></h2>
        <p class="hint-text">
            <c:set var="error_message" scope="request" value="${requestScope.error_message}"/>
            <c:if test="${error_message != null}">
                <c:forEach items="${error_message}" var="message">
                    <fmt:message key="${message}"/>
                </c:forEach>
            </c:if>
        </p>
        <div class="form-group">
            <p style="display: inline"><fmt:message key="output.request.product.category"/></p>
            <select name="product_category">
                <option value="APPLIANCE"><fmt:message key="input.request.product.category.appliance"/></option>
                <option value="CAMERA"><fmt:message key="input.request.product.category.camera"/></option>
                <option value="HOME_EQUIPMENT"><fmt:message
                        key="input.request.product.category.home_equipment"/></option>
                <option value="LAPTOP"><fmt:message key="input.request.product.category.laptop"/></option>
                <option value="OFFICE_EQUIPMENT"><fmt:message
                        key="input.request.product.category.office_equipment"/></option>
                <option value="PC"><fmt:message key="input.request.product.category.pc"/></option>
                <option value="PC_ACCESSORIES"><fmt:message
                        key="input.request.product.category.pc_accessories"/></option>
                <option value="PC_HARDWARE"><fmt:message key="input.request.product.category.pc_hardware"/></option>
                <option value="SMARTPHONE"><fmt:message key="input.request.product.category.smartphone"/></option>
                <option value="TV"><fmt:message key="input.request.product.category.tv"/></option>
            </select>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="device"
                   placeholder="<fmt:message key="jsp.placeholder.device"/>" required="required"
                   oninvalid="setCustomValidity('<fmt:message key="login.please.fill.in.field"/>')"
                   oninput="setCustomValidity('')" title="<fmt:message key="login.please.fill.in.field"/>"/>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="description"
                   placeholder="<fmt:message key="jsp.placeholder.description"/>" required="required"
                   oninvalid="setCustomValidity('<fmt:message key="login.please.fill.in.field"/>')"
                   oninput="setCustomValidity('')" title="<fmt:message key="login.please.fill.in.field"/>"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block"><fmt:message
                    key="jsp.createRequest.create.button"/></button>
        </div>
    </form>
</div>
<%@ include file="/common/footer.jsp" %>
</body>
</html>
