<nav aria-label="Navigation for countries">
    <ul class="pagination">
        <c:if test="${requestScope.currentPage != 1}">
            <li class="page-item"><a class="page-link"
                                     href="${pageContext.request.contextPath}/customer/active/requests?currentPage=${requestScope.currentPage - 1}">Previous</a>
            </li>
        </c:if>

        <c:forEach begin="1" end="${requestScope.numberOfPages}" var="i">
            <c:choose>
                <c:when test="${requestScope.currentPage eq i}">
                    <li class="page-item active"><a class="page-link">
                            ${i} <span class="sr-only">(current)</span></a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/customer/active/requests?currentPage=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${requestScope.currentPage lt requestScope.numberOfPages}">
            <li class="page-item"><a class="page-link"
                                     href="${pageContext.request.contextPath}/customer/active/requests?currentPage=${requestScope.currentPage + 1}">Next</a>
            </li>
        </c:if>
    </ul>
</nav>