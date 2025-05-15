package com.example.authorbookee.servlet;

import com.example.authorbookee.model.Author;
import com.example.authorbookee.model.Book;
import com.example.authorbookee.service.AuthorService;
import com.example.authorbookee.service.BookService;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {

    private final BookService bookService = new BookService();
    private final AuthorService authorService = new AuthorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> authors = authorService.getAllAuthors();
        req.setAttribute("authors", authors);
        req.getRequestDispatcher("/addBook.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String title = req.getParameter("title");
        double price = Double.parseDouble(req.getParameter("price"));
        int qty = Integer.parseInt(req.getParameter("qty"));
        int authorId = Integer.parseInt(req.getParameter("authorId"));

        Book book = Book.builder()
                .title(title)
                .price(price)
                .qty(qty)
                .createdAt(new Date())
                .author(authorService.getAuthorById(authorId))
                .build();

        bookService.add(book);
        resp.sendRedirect("/books");
    }
}
