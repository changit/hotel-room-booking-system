<%--
  Created by IntelliJ IDEA.
  User: uchan
  Date: 4/19/12
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link  type="text/css" rel="stylesheet" href="<c:url value="/css/jquery/css/ui-lightness/jquery-ui-1.8.19.custom.css"/>" />
    <link  type="text/css" rel="stylesheet" href="<c:url value="/css/custom/main.css"/>" />
    <script type="text/javascript" src="<c:url value='/css/jquery/js/jquery-1.7.2.min.js'/>"> </script>
    <script type="text/javascript" src="<c:url value='/css/jquery/js/jquery-ui-1.8.19.custom.min.js'/>"> </script>
    <script>
        $(function() {
            $( "#startDate" ).datepicker();
            $( "#endDate" ).datepicker();
        });
    </script>
    <title></title>
</head>
<body>
Select start date and end date to search
<form:form commandName="searchRoomForm" >
    <table>
        <tr>
            <td><fmt:message key="search.rooms.start.date"/></td>
            <td><form:input path="startDate" /></td>
            <td><form:errors path="startDate" cssClass="error-message"/></td>
        </tr>
        <tr>
            <td><fmt:message key="search.rooms.end.date"/></td>
            <td><form:input path="endDate"/></td>
            <td><form:errors path="endDate" cssClass="error-message"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>