<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Error: Discussion Not Found</title>
    </head>
    <body>
        <h2>Error: Discussion Not Found</h2>
        The discussion you are looking for was not found.<br />
        <br />
        [<a href="<c:url value="/discussion/list" />">return to list</a>]
    </body>
</html>
