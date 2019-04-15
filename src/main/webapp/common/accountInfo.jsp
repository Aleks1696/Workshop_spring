<fieldset class="accountInfo">
    <c:set var="user" scope="session" value="${sessionScope.get('user')}"/>
    <h3><fmt:message key="jsp.customer.left.sidenav.account.label"/></h3>
    <c:choose>
        <c:when test="${language == 'ua'}">
            <c:out value="${user.getName_ua()}"/>
            <c:out value=" ${user.getSurname_ua()}"/> <br>
        </c:when>
        <c:otherwise>
            <c:out value="${user.getName()}"/>
            <c:out value=" ${user.getSurname()}"/> <br>
        </c:otherwise>
    </c:choose>
    <c:out value="${user.getEmail()}"/> <br>
    <c:out value="${user.getPhoneNumber()}"/>
</fieldset>
