<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuário</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:forEach var="u" items="${users}">
            <span>${u.name}</span>
        </c:forEach>
    </body>
</html>
