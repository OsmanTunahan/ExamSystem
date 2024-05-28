<!DOCTYPE html>
<html>
<head>
    <title>Student Management</title>
</head>
<body>
<h1>Students</h1>
<form action="student" method="post">
    <input type="hidden" name="action" value="add">
    Name: <input type="text" name="name"><br>
    Roll No: <input type="text" name="rollNo"><br>
    Section: <input type="text" name="section"><br>
    Branch: <input type="text" name="branch"><br>
    Year: <input type="text" name="year"><br>
    <input type="submit" value="Add Student">
</form>
<h2>All Students</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Roll No</th>
        <th>Section</th>
        <th>Branch</th>
        <th>Year</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.rollNo}</td>
            <td>${student.section}</td>
            <td>${student.branch}</td>
            <td>${student.year}</td>
            <td>
                <form action="student" method="post" style="display:inline">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${student.id}">
                    <input type="submit" value="Delete">
                </form>
                <form action="student" method="post" style="display:inline">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="id" value="${student.id}">
                    Name: <input type="text" name="name" value="${student.name}">
                    Roll No: <input type="text" name="rollNo" value="${student.rollNo}">
                    Section: <input type="text" name="section" value="${student.section}">
                    Branch: <input type="text" name="branch" value="${student.branch}">
                    Year: <input type="text" name="year" value="${student.year}">
                    <input type="submit" value="Update">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>