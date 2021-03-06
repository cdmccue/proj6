<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Create Discussion</title>
    </head>
    <body>
        <h2>Create Discussion</h2>
        [<a href="<c:url value="/discussion/list" />">return to list</a>]<br />
        <br />
        <form:form method="post" modelAttribute="discussionForm">
            <form:label path="town">Town:</form:label><br />
            <form:input path="town"/><br />
            <br />
            <form:label path="street">Street:</form:label><br />
            <form:input path="street" /><br />
            <br />
            <form:label path="user">Your Email</form:label><br />
            <form:input path="user" type="email" /><br />
            <br />
            <form:label path="subject">Subject</form:label><br />
            <form:input path="subject"/><br />
            <br />
            <form:label path="message">Message</form:label><br />
            <form:textarea path="message" cols="40" rows="5" /><br />
            <br />
            <input type="submit" value="Submit" />
        </form:form>
    </body>
</html>
