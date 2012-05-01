<%--
  Created by IntelliJ IDEA.
  User: uchan
  Date: 4/19/12
  Time: 10:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title></title>
    <script type="text/javascript">
        function submitSelectedItem() {
            var checkBoxes = document.roomDetailListForm.selectedRooms;
            var selectedCheckBoxes = "";
            for (i = 0; i < checkBoxes.length; i++) {
                if(checkBoxes[i].id == "mockSelectedRooms") {
                    continue;
                }

                selectedCheckBoxes = selectedCheckBoxes + "," + checkBoxes[i].id + "=" + checkBoxes[i].checked;
            }
            document.getElementById("selectedItemIds").value = selectedCheckBoxes;
        }
    </script>
</head>
<body>

Select your desired rooms

<table>
    <form:form name="roomDetailListForm" commandName="roomDetailListForm" action="select.html" method="POST">
        <tr>
            <td>No</td>
            <td>Type</td>
            <td>Size</td>
            <td>Select</td>
        </tr>
        <c:forEach var="roomDetails" items="${roomDetailListForm.roomDetailsList}">
            <tr>
                <td>${roomDetails.room.id}</td>
                <td>${roomDetails.room.roomType.name}</td>
                <td>${roomDetails.room.roomSize.name}</td>
                <td><input type="checkbox" id="${roomDetails.room.id}" name="selectedRooms"  <c:if test="${roomDetails.selected}"> checked="checked" </c:if>/></td>
            </tr>
        </c:forEach>
        <form:hidden path="startDate"/>
        <form:hidden path="endDate"/>
        <form:hidden path="selectedItemIds"/>
        <tr>
            <td>
                <input type="submit" onclick="submitSelectedItem()"/>
            </td>
        </tr>
        <input type="hidden" id="mockSelectedRooms" name="selectedRooms" />
    </form:form>

</table>

</body>
</html>