<%@ page import="com.example.authorbookee.model.Author" %>
<%@ page import="com.example.authorbookee.util.DateUtil" %>
<%@ page import="com.example.authorbookee.model.Gender" %>
<%@ page import="static com.example.authorbookee.model.Gender.MALE" %><%--
  Created by IntelliJ IDEA.
  User: Hend
  Date: 14.05.2025
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Author</title>
</head>
<body>
<% Author author = (Author) request.getAttribute("author");%>
<h1>Edit Author</h1>
<a href="/authors">Authors</a> | <a href="index.jsp"> Main Page </a> <br>

<form action="/editAuthor" method="post">
    <input type= "hidden"  name="id" value="<%= author.getId()%>"><br>
    Name: <input type="text" name="name" value="<%=author.getName()%>"><br>
    Surname: <input type="text" name="surname" value="<%=author.getSurname()%>"><br>
    Phone: <input type="text" name="phone" value="<%=author.getPhone()%>"><br>
    Date Of Birthday: <input type="date" name="dob"
                            value="<%=DateUtil.fromDateToWebString(author.getDateOfBirthday())%>"><br>
    GENDER: <select name="gender">
    <% if (author.getGender() == Gender.MALE) { %>
    <option value="MALE" selected>MALE</option>
    <option value="FEMALE">FEMALE</option>
    <% } else { %>

    <option value="MALE">MALE</option>
    <option value="FEMALE" selected>FEMALE</option>

    <% } %>

</select><br>
    <input type="submit" value="UPDATE">
</form>

</body>
</html>
