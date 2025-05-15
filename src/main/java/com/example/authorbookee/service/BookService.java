package com.example.authorbookee.service;



import com.example.authorbookee.db.DBConnectionProvider;

import com.example.authorbookee.model.Author;
import com.example.authorbookee.model.Book;
import com.example.authorbookee.util.DateUtil;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    private final  Connection connection = DBConnectionProvider.getInstance().getConnection();
    private final AuthorService authorService = new AuthorService();

    public void add(Book book) {
        String sql = """
        INSERT INTO book(title, price, qty, author_id, created_at)
        VALUES (?, ?, ?, ?, ?)
    """;

        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, book.getTitle());
            ps.setDouble(2, book.getPrice());
            ps.setInt(3, book.getQty());
            ps.setInt(4, book.getAuthor().getId());
            ps.setTimestamp(5, Timestamp.valueOf(DateUtil.fromDateToSqlDateTimeString(book.getCreatedAt())));

            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    book.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Book> getAllBooks() {
        String sql = "SELECT * from book";
        List<Book> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setQty(resultSet.getInt("qty"));
                book.setCreatedAt(DateUtil.fromSqlStringToDateTime(resultSet.getString("created_at")));
                book.setAuthor(authorService.getAuthorById(resultSet.getInt("author_id")));
                result.add(book);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Book> searchByBookName(String keyword) {
        String sql = "SELECT * from book WHERE title LIKE '%" + keyword + "%'";
        List<Book> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setQty(resultSet.getInt("qty"));
                book.setCreatedAt(DateUtil.fromSqlStringToDateTime(resultSet.getString("created_at")));
                book.setAuthor(authorService.getAuthorById(resultSet.getInt("author_id")));
                result.add(book);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Book getBookById(int id) {
        String sql = "SELECT * from book WHERE id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setQty(resultSet.getInt("qty"));
                book.setCreatedAt(DateUtil.fromSqlStringToDateTime(resultSet.getString("created_at")));
                book.setAuthor(authorService.getAuthorById(resultSet.getInt("author_id")));
                return book;
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteBook(int bookId) {
        String sql = "DELETE FROM book WHERE id = " + bookId;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> searchByPrice(double min, double max) {
        String sql = "SELECT * from book WHERE price BETWEEN " + min + " AND " + max;
        List<Book> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setQty(resultSet.getInt("qty"));
                book.setCreatedAt(DateUtil.fromSqlStringToDateTime(resultSet.getString("created_at")));
                book.setAuthor(authorService.getAuthorById(resultSet.getInt("author_id")));
                result.add(book);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Book> searchByAuthor(Author author) {
        String sql = "SELECT * from book WHERE author_id = " + author.getId();
        List<Book> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setQty(resultSet.getInt("qty"));
                book.setCreatedAt(DateUtil.fromSqlStringToDateTime(resultSet.getString("created_at")));
                book.setAuthor(authorService.getAuthorById(resultSet.getInt("author_id")));
                result.add(book);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
