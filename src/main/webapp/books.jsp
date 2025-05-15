<%@ page import="com.example.authorbookee.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.authorbookee.util.DateUtil" %><%--
  Created by IntelliJ IDEA.
  User: Hend
  Date: 14.05.2025
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<h2>Books:</h2>
<a href="/addBook">Add Book</a> | <a href="index.jsp">Main</a>
<% List<Book> books = (List<Book>) request.getAttribute("books");%>
<table border="1">
    <tr>
        <th>id</th>
        <th>title</th>
        <th>price</th>
        <th>qty</th>
        <th>author</th>
        <th>created_at</th>
        <th>delete</th>
        <th>edit</th>
    </tr>

    <% for (Book book : books) { %>
        <tr>
            <th><%= book.getId()%>></th>
            <th><%= book.getTitle()%></th>
            <th><%= book.getPrice()%></th>
            <th><%= book.getQty()%></th>
            <th><%= book.getAuthor().getName()%></th>
            <th><%= DateUtil.fromDateToString(book.getCreatedAt())%></th>
            <th><a href="/deleteBook?id=<%=book.getId()%>">Delete</a></th>
            <th><a href="/editBook?id=<%=book.getId()%>">Edit</a></th>
        </tr>
    <% }%>
</table>

</body>
</html>
