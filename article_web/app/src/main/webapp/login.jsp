<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Log in</title>
</head>

<body>
  <h1>Log in</h1>
  <form action="/api/login" method="POST">
    <label for="id">Id:</label>
    <input type="number" name="id" required><br>
    <label for="password">Password:</label>
    <input type="password" name="password" required><br>
    <input type="submit" value="submit">
  </form>
</body>

</html>