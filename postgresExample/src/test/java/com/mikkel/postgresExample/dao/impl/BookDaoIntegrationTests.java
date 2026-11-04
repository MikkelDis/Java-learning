//package com.mikkel.postgresExample.dao.impl;
//
//import com.mikkel.postgresExample.TestDataUtil;
//import com.mikkel.postgresExample.domain.Author;
//import com.mikkel.postgresExample.domain.Book;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatTemporal;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@ActiveProfiles("test")
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class BookDaoIntegrationTests {
//
//    private AuthorDao authorDao;
//    private BookDao undertest;
//
//    @Autowired
//    public BookDaoIntegrationTests(BookDao undertest, AuthorDao authorDao){
//        this.undertest = undertest;
//        this.authorDao = authorDao;
//    }
//
//    @Test
//    public void testThatBookCanBeCreatedAndRecalled(){
//        authorDao.create(TestDataUtil.createTestAuthorA());
//        Book book = TestDataUtil.createTestBookA();
//        undertest.create(book);
//        Optional<Book> result = undertest.findOne(book.getIsbn());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(book);
//    }
//
//    @Test
//    public void testThatMultipleBooksCanBeCreatedAndRecalled(){
//        authorDao.create(TestDataUtil.createTestAuthorA());
//        undertest.create(TestDataUtil.createTestBookA());
//        undertest.create(TestDataUtil.createTestBookB());
//        List<Book> result = undertest.find();
//        assertThat(result).hasSize(2).containsExactly(TestDataUtil.createTestBookA(), TestDataUtil.createTestBookB());
//    }
//
//    @Test
//    public void testThatBookCanBeUpdated(){
//        Author authorA = TestDataUtil.createTestAuthorA();
//        authorDao.create(authorA);
//
//        Book book = TestDataUtil.createTestBookA();
//        undertest.create(book);
//
//        book.setTitle("UPDATED");
//        undertest.update(book.getIsbn(), book);
//
//        Optional<Book> result = undertest.findOne(book.getIsbn());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(book);
//    }
//
//    @Test
//    public void testThatBookCanBeDeleted(){
//        Author authorA = TestDataUtil.createTestAuthorA();
//        authorDao.create(authorA);
//
//        Book bookA = TestDataUtil.createTestBookB();
//        undertest.create(bookA);
//        undertest.delete(bookA.getIsbn());
//        Optional<Book> result = undertest.findOne(bookA.getIsbn());
//
//        assertThat(result).isEmpty();
//    }
//
//}
