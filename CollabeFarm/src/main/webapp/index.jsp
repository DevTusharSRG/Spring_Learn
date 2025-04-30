<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>

<h2>User Registration Form</h2>

<!-- Display success message if available -->
<% if (request.getAttribute("message") != null) { %>
    <p style="color: green;"><%= request.getAttribute("message") %></p>
<% } %>

<!-- Form to register a user -->
<form action="${pageContext.request.contextPath}/users/register" method="POST">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="contact">Contact:</label>
    <input type="text" id="contact" name="contact" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <label for="type_of_user">Type of User:</label>
    <select id="type_of_user" name="typeOfUser" required>
        <option value="FARMER">Farmer</option>
        <option value="CONSUMER">Consumer</option>
    </select><br><br>

    <button type="submit">Register</button>
</form>

</body>
</html>
