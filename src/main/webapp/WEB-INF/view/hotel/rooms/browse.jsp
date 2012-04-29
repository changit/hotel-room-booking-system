<%--
  Created by IntelliJ IDEA.
  User: uchan
  Date: 4/19/12
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>

Select your desired rooms

<table>
    <tr>
        <td>No</td>
        <td>Type</td>
        <td>Size</td>
    </tr>
<c:forEach var="room" items="${rooms}">
    <tr>
        <td>${room.id}</td>
        <td>${room.roomType.name}</td>
        <td>${room.roomSize.name}</td>
    </tr>
</c:forEach>
</table>

</body>
</html>