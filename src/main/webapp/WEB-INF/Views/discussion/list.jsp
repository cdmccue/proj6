<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--@elvariable id="posts" type="java.util.List<edu.usm.cos.375.springboot.entity.Discussion>"--%>
<!DOCTYPE html>
<html>
    <head>
        <title>Dogs On My Street</title>
    </head>
    <body>
        <h2>Posts for Discussion 1</h2>
        [<a href="<c:url value="/discussion/create" />">new discussion</a>]<br />
        <br />
        <c:choose>
            <c:when test="${fn:length(posts) > 0}">
                <c:forEach items="${posts}" var="discussion">
                    <a href="<c:url value="/discussion/1" />">
                        <c:out value="${post.subject}" /></a><br />
                    (<c:out value="${post.user}" />)<br/>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <i>There are no posts for discussion 1 yet.</i>
            </c:otherwise>
        </c:choose>
    </body>
</html>