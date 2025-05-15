<%@ page import="java.util.List" %>
<%@ page import="com.example.authorbookee.util.DateUtil" %>
<%@ page import="com.example.authorbookee.model.Author" %><%--
  Created by IntelliJ IDEA.
  User: Hend
  Date: 14.05.2025
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authors</title>
</head>
<body>
<h2>Authors:</h2> <a href="/addAuthor">Add Author</a> | <a href="index.jsp">Main</a>
<% List<Author> authors = (List<Author>) request.getAttribute("authors");%>

<table border="1">
  <tr>
    <th>id</th>
    <th>name</th>
    <th>surname</th>
    <th>phone</th>
    <th>dob</th>
    <th>gender</th>
    <th>delete</th>
    <th>edit</th>
  </tr>

<% for (Author author : authors) { %>
    <tr>
      <td><%= author.getId()%> </td>
      <td><%= author.getName()%> </td>
      <td><%= author.getSurname()%> </td>
      <td><%= author.getPhone()%> </td>
      <td><%= DateUtil.fromDateToString(author.getDateOfBirthday())%> </td>
      <td><%= author.getGender().name()%> </td>
      <td><a href ="/deleteAuthor?id=<%= author.getId()%>">Delete</a></td>
      <td><a href="/editAuthor?id=<%= author.getId()%>">Edit</a></td>
    </tr>
<% } %>
</table>
</body>
</html>
