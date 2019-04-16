<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/common/import.jsp"%>

<html lang="${language}">
    <head>
        <%@ include file="/common/head.jsp"%>
<%--        <script language="JavaScript" src="${pageContext.request.contextPath}/resources/js/managerPage.js"></script>--%>
        <script>
            function showHideDiv(element) {
                var srcElement = document.getElementById(element);
                if (srcElement != null) {
                    if (srcElement.style.display == "block") {
                        srcElement.style.display = 'none';
                    }
                    else {
                        srcElement.style.display = 'block';
                    }
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <div id="header-wrapper">
            <div id="header" class="container">
                <div id="logo">
                    <h1><span class="fa fa-bolt"></span><a href="#">Workshop</a></h1>
                </div>
                <div id="menu">
                    <ul>
                        <li class="current_page_item"><a href="#" title="">Homepage</a></li>
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
                        <a href="${pageContext.request.contextPath}/manager/account/language/en">EN</a>
                        <a href="${pageContext.request.contextPath}/manager/account/language/ua">UA</a>

<%--                        <select id="language" name="language" onchange="submit()" class="byline">--%>
<%--                            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>--%>
<%--                            <option value="ua" ${language == 'ua' ? 'selected' : ''}>Українська</option>--%>
<%--                        </select>--%>
                    </form>
                </div>
                <nav class="nav">
                    <ul class="nav__list">
                        <li class="nav__item"><a href="${pageContext.request.contextPath}/manager/active/request">New requests</a></li>
                    </ul>
                </nav>
                <div>
                    <c:set var="new_requests" scope="request" value="${requestScope.new_requests}"/>
                    <c:if test="${new_requests != null}">
                        <c:forEach items="${new_requests}" var="request">
                            <form method="post">
                                <fieldset>
                                    <input hidden="hidden" name="id" value="${request.getId()}">
                                    Request id: <c:out value="${request.getId()}"/> <br>
                                    Product category: <c:out value="${request.getProductCategory()}"/> <br>
                                    Device: <c:out value="${request.getDevice()}"/> <br>
                                    Description: <c:out value="${request.getDescription()}"/> <br>
                                    Customer id: <c:out value="${request.getCustomer_id()}"/> <br>
                                    Creation date: <c:out value="${request.getCreationDate()}"/> <br>

                                    <input type="button" value="Accept" onClick="showHideDiv('accept')"/>
                                    <input type="button" value="Decline" onClick="showHideDiv('decline')"/>
                                    <div id="accept" style="display:none">
                                        Price: <input type="text" name="price"/> <br>
                                        Manager commentary: <input type="text" name="managerAcceptComment"/>
                                        <input type="submit" formaction="${pageContext.request.contextPath}/manager/active/request/accept" value="Submit"/>
                                    </div>
                                    <div id="decline" style="display:none">
                                        Manager commentary: <input type="text" name="managerDeclineComment"/>
                                        <input type="submit" formaction="${pageContext.request.contextPath}/manager/active/request/decline" value="Submit"/>
                                    </div>
                                </fieldset>
                            </form>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
