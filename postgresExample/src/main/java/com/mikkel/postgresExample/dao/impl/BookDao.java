package com.mikkel.postgresExample.dao.impl;

import com.mikkel.postgresExample.dao.IBookDao;
import com.mikkel.postgresExample.domain.Author;
import com.mikkel.postgresExample.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.crypto.spec.OAEPParameterSpec;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class BookDao implements IBookDao {

    private final JdbcTemplate jdbcTemplate;

    public BookDao(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {
        jdbcTemplate.update(
                "INSERT INTO books (isbn, title, author_id) VALUES (?,?,?)",
                book.getIsbn(), book.getTitle(), book.getAuthor_id()

        );
    }

    @Override
    public Optional<Book> findOne(String isbn){
        List<Book> results = jdbcTemplate.query("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1",
                new BookDao.BookRowMapper(), isbn);
        return results.stream().findFirst();
    }

    public static class BookRowMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Book.builder()
                    .isbn(rs.getString("isbn"))
                    .title(rs.getString("title"))
                    .author_id(rs.getLong("author_id"))
                    .build();
        }
    }

    @Override
    public List<Book> find(){
        List<Book> books = jdbcTemplate.query("SELECT isbn, title, author_id FROM books", new BookDao.BookRowMapper());
        return books;
    }

    @Override
    public void update(String isbn, Book book){
        jdbcTemplate.update("UPDATE books SET isbn=?, title=?, author_id=? WHERE isbn=?",
                book.getIsbn(), book.getTitle(), book.getAuthor_id(), isbn);
    }

    @Override
    public void delete(String isbn){
        jdbcTemplate.update("DELETE FROM books WHERE isbn = ?", isbn);
    }

}
