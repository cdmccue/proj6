<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--@elvariable id="discussions" type="java.util.List<edu.usm.cos.375.springboot.entity.Discussion>"--%>
<!DOCTYPE html>
<html>
    <head>
        <title>Dogs On My Street</title>
    </head>
    <body>
        <h2>Discussion Board:</h2>
        <c:choose>
            <c:when test="${fn:length(discussions) > 0}">
                <c:forEach items="${discussions}" var="discussion">
                <c:out value="${discussion}" />
                    <%-- <a href="<c:url value="/discussion/1" />"> --%>
<%--                     <c:out value="${discussion.id}" /><br />
                    <c:out value="${discussion.town}" /><br/>
                    <c:out value="${discussion.street}" /><br/>
                    <c:out value="${discussion.user}" /><br/>
                    <c:out value="${discussion.subject}" /><br/>
                    <c:out value="${discussion.message}" /><br/> --%>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <i>There are no discussions yet '_'</i>
            </c:otherwise>
        </c:choose>
    </body>
</html>