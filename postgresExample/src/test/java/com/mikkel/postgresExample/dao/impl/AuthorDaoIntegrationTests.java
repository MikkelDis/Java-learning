//package com.mikkel.postgresExample.dao.impl;
//
//import com.mikkel.postgresExample.TestDataUtil;
//import com.mikkel.postgresExample.domain.Author;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) //Cleans the context after each test. Cleasn DB
//public class AuthorDaoIntegrationTests {
//
//
//    private AuthorDao underTest;
//
//    @Autowired
//    public AuthorDaoIntegrationTests(AuthorDao underTest){
//        this.underTest = underTest;
//    }
//
//    @Test
//    public void testThatAuthorCanBeCreatedAndRecalled(){
//        Author author = TestDataUtil.createTestAuthorA();
//        underTest.create(author);
//        Optional<Author> result = underTest.findOne(author.getId());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(author);
//    }
//
//    @Test
//    public void testThatMultipleAuthorsCanBeRecordedAndRecalled(){
//        Author authorA = TestDataUtil.createTestAuthorA();
//        Author authorB = TestDataUtil.createTestAuthorB();
//
//        underTest.create(authorA);
//        underTest.create(authorB);
//        List<Author> result = underTest.find();
//
//        assertThat(result).hasSize(2).containsExactly(authorA, authorB);
//    }
//
//    @Test
//    public void testThatAuthorCanBeUpdated(){
//        Author authorA = TestDataUtil.createTestAuthorA();
//        underTest.create(authorA);
//
//        authorA.setName("UPDATED");
//        underTest.update(authorA.getId(), authorA);
//        Optional<Author> result = underTest.findOne(authorA.getId());
//
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(authorA);
//
//    }
//
//    @Test
//    public void testThatAuthorCanBeDeleted(){
//        Author authorA = TestDataUtil.createTestAuthorA();
//        underTest.create(authorA);
//
//        underTest.delete(authorA.getId());
//        Optional<Author> result = underTest.findOne(authorA.getId());
//
//        assertThat(result).isEmpty();
//    }
//}
