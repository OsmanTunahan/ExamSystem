<!DOCTYPE html>
<html>
<head>
    <title>Seat Management</title>
</head>
<body>
<h1>Seat Allocation</h1>
<form action="seat" method="post">
    <input type="hidden" name="action" value="allocate">
    Student ID: <input type="text" name="studentId"><br>
    Seat Number: <input type="text" name="seatNumber"><br>
    Exam Hall: <input type="text" name="examHall"><br>
    <input type="submit" value="Allocate Seat">
</form>
<h2>All Seats</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Student ID</th>
        <th>Seat Number</th>
        <th>Exam Hall</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="seat" items="${seats}">
        <tr>
            <td>${seat.id}</td>
            <td>${seat.studentId}</td>
            <td>${seat.seatNumber}</td>
            <td>${seat.examHall}</td>
            <td>
                <form action="seat" method="post" style="display:inline">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${seat.id}">
                    <input type="submit" value="Delete">
                </form>
                <form action="seat" method="post" style="display:inline">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="id" value="${seat.id}">
                    Student ID: <input type="text" name="studentId" value="${seat.studentId}">
                    Seat Number: <input type="text" name="seatNumber" value="${seat.seatNumber}">
                    Exam Hall: <input type="text" name="examHall" value="${seat.examHall}">
                    <input type="submit" value="Update">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>