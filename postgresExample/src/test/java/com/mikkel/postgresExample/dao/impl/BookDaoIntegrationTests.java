package com.mikkel.postgresExample.dao.impl;

import com.mikkel.postgresExample.TestDataUtil;
import com.mikkel.postgresExample.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class BookDaoIntegrationTests {

    private AuthorDao authorDao;
    private BookDao undertest;

    @Autowired
    public BookDaoIntegrationTests(BookDao undertest, AuthorDao authorDao){
        this.undertest = undertest;
        this.authorDao = authorDao;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        authorDao.create(TestDataUtil.createTestAuthor());
        Book book = TestDataUtil.createTestBook();
        undertest.create(book);
        Optional<Book> result = undertest.findOne(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

}
