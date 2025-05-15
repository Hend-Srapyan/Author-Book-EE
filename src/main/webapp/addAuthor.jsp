<%--
  Created by IntelliJ IDEA.
  User: Hend
  Date: 14.05.2025
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Author</title>
</head>
<body>

<h1>Add Author</h1>
<a href="/authors">Authors</a> | <a href="index.jsp"> Main Page </a> <br>

<form action="/addAuthor" method="post">
    Name <input type="text" name="name"><br>
    Surname <input type="text" name="surname"><br>
    Phone <input type = "text" name="phone"><br>
    Date Of Birthday <input type = "date" name="dob"><br>
    GENDER: <select name="gender">
        <option value="MALE">MALE</option>
        <option value="FEMALE">FEMALE</option>
    </select><br>
    <input type = "submit" value="ADD">
</form>

</body>
</html>
