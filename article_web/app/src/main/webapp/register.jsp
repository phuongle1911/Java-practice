<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Register form</title>
</head>
<body>
  <h1>Register</h1>
  <form action="/api/users" method="POST">
    <label for="username">Username:</label>
    <input type="text" name="username" required><br>
    <label for="id">Id:</label>
    <input type="number" name="id" required><br>
    <label for="password">Password:</label>
    <input type="password" name="password" required><br>
    <input type="submit" value="submit">
  </form>
</body>
</html>