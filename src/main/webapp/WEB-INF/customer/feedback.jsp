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
            <h1><span class="fa fa-bolt"></span><a href="#">Workshop</a></h1>
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
        <%--Menu list (navigation bar)--%>
        <nav class="nav">
            <ul class="nav__list">
                <li class="nav__item"><a href="${pageContext.request.contextPath}/customer/request">Create request</a></li>
                <li class="nav__item"><a href="${pageContext.request.contextPath}/customer/active/requests">Active requests</a></li>
                <li class="nav__item"><a href="#">All requests</a></li>
                <li class="nav__item"><a href="#">Update profile</a></li>
            </ul>
        </nav>
        <div>
            <form>
                <span>Choose language: </span>
                <a href="${pageContext.request.contextPath}/customer/account/language/en">EN</a>
                <a href="${pageContext.request.contextPath}/customer/account/language/ua">UA</a>

            </form>
        </div>
            <div class="container">
                    <h3>Please leave a feedback</h3>
                            <form method="post" action="${pageContext.request.contextPath}/customer/feedback/leave">
                                <input hidden="hidden" name="id" value="${requestScope.id}">
                                <p>ID: <c:out value="${requestScope.id}"></c:out></p>
                                <p>ID: <c:out value="${requestScope.get('id')}"></c:out></p>
                                <fieldset class="rating">
                                    <legend>Please rate:</legend>
                                    <input type="radio" id="star5" name="rating" value="GREAT" /><label for="star5" title="Rocks!">GREAT</label>
                                    <input type="radio" id="star4" name="rating" value="FINE" /><label for="star4" title="Pretty good">FINE</label>
                                    <input type="radio" id="star3" name="rating" value="NORMAL" /><label for="star3" title="Meh">NORMAL</label>
                                    <input type="radio" id="star2" name="rating" value="BAD" /><label for="star2" title="Kinda bad">BAD</label>
                                    <input type="radio" id="star1" name="rating" value="TERRIBLE" /><label for="star1" title="Sucks big time">TERRIBLE</label>
                                </fieldset>
                                <input type="text" name="commentary" placeholder="Text you message..."/>
                                <input type="submit" value="Submit"/>
                            </form>
            </div>

    </div>

</div>
</body>
</html>
