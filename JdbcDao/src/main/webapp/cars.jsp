
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Hello, world!</title>
</head>
<body>
    <h1>
        Cписок машин:
    </h1>
    <p>
        <c:forEach items="${requestScope.Cars}" var="currentCar">
            <tr>
                <td><c:out value="${currentCar}" /><td>
                <br>
            </tr>
        </c:forEach>
    </p>
    <form action="cars" method="post">
        Name: <input type="text" name="carName">
        Mileage: <input type="text" name="mileage">
        <input type="submit" value="Add">
    <span class="error">${error}</span>
</form>
</body>
</html>
