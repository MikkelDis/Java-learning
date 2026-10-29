package com.mikkel.postgresExample.dao;

import com.mikkel.postgresExample.dao.impl.BookDao;
import com.mikkel.postgresExample.domain.Author;
import com.mikkel.postgresExample.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDao bookDao;

    @Test
    public void testThatCreateBookGeneratesCorrectSQL(){
        Book book = Book.builder()
                .isbn("999-1-2222-3333-0")
                .title("The Shadow")
                .author_id(1L)
                .build();

        bookDao.create(book);
        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author_id) VALUES (?,?,?)"),
                eq("999-1-2222-3333-0"), eq("The Shadow"), eq(1L)
        );
    }

}
