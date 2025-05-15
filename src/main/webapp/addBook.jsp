<%@ page import="com.example.authorbookee.model.Author" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.authorbookee.service.AuthorService" %><%--
  Created by IntelliJ IDEA.
  User: Hend
  Date: 14.05.2025
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
<% List<Author> authors = (List<Author>) request.getAttribute("authors");%>
<h1>Add Book</h1>
<a href="/books">Books</a> | <a href="index.jsp"> Main Page </a> <br>
<form action="/addBook" method="post">
    Name: <input type="text" name="title"><br>
    Price: <input type="number" step="0.01" name="price"><br>
    Qty: <input type="number" name="qty"><br>

    <!-- Optional: if you want user to pick a date, and handle it in servlet -->
    <!-- createdAt: <input type="date" name="createdAt"><br> -->

    Author:
    <select name="authorId">
        <% for (Author author : (List<Author>) request.getAttribute("authors")) { %>
        <option value="<%= author.getId() %>">
            <%= author.getName() + " " + author.getSurname() %>
        </option>
        <% } %>
    </select><br>

    <input type="submit" value="ADD">
</form>

</body>
</html>
