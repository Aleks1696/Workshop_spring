<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/import.jsp"%>

<html lang="${language}">
    <head>
        <%@ include file="/common/head.jsp"%>
    </head>
    <body>
        <div id="header-wrapper">
            <div id="header" class="container">
                <div id="logo">
                    <h1><span class="fa fa-bolt"></span><a href="${pageContext.request.contextPath}/old/index_o.jsp">Workshop</a></h1>
                </div>
                <div id="menu">
                    <ul>
                        <li class="current_page_item"><a href="${pageContext.request.contextPath}/" title="">Homepage</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout">Log out</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div id="wrapper">
            <div id="featured-wrapper">
                <div>
                    <form>
                        <span>Choose language: </span>
                        <a href="${pageContext.request.contextPath}/customer/request/language/en">EN</a>
                        <a href="${pageContext.request.contextPath}/customer/request/language/ua">UA</a>

<%--                        <select id="language" name="language" onchange="submit()" class="byline">--%>
<%--                            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>--%>
<%--                            <option value="ua" ${language == 'ua' ? 'selected' : ''}>Українська</option>--%>
<%--                        </select>--%>
                    </form>
                </div>
                <div>
                    <div>
                        <form method="post" action="${pageContext.request.contextPath}/customer/request/submit">
                            <select name="product_category">
                                <option value="APPLIANCE"><fmt:message key="input.request.product.category.appliance"/></option>
                                <option value="CAMERA"><fmt:message key="input.request.product.category.camera"/></option>
                                <option value="HOME_EQUIPMENT"><fmt:message key="input.request.product.category.home_equipment"/></option>
                                <option value="LAPTOP"><fmt:message key="input.request.product.category.laptop"/></option>
                                <option value="OFFICE_EQUIPMENT"><fmt:message key="input.request.product.category.office_equipment"/></option>
                                <option value="PC"><fmt:message key="input.request.product.category.pc"/></option>
                                <option value="PC_ACCESSORIES"><fmt:message key="input.request.product.category.pc_accessories"/></option>
                                <option value="PC_HARDWARE"><fmt:message key="input.request.product.category.pc_hardware"/></option>
                                <option value="SMARTPHONE"><fmt:message key="input.request.product.category.smartphone"/></option>
                                <option value="TV"><fmt:message key="input.request.product.category.tv"/></option>
                            </select>
                            <input type="text" name="device" placeholder="device" required="required"/> </br>
                            <input type="text" name="description" placeholder="description" required="required"/> </br>
                            <input type="submit" value="Create"/>
                        </form>
                        <div>
                            <c:set var="error_message" scope="request" value="${requestScope.error_message}"/>
                            <c:if test="${error_message != null}">
                            <c:forEach items="${error_message}" var="message">
                                <fmt:message key="${message}"/>
                            </c:forEach>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </body>
</html>
