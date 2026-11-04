package com.mikkel.postgresExample;

import com.mikkel.postgresExample.domain.Author;
import com.mikkel.postgresExample.domain.Book;

public class TestDataUtil {
    private TestDataUtil(){}

    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("John Snow")
                .age(25)
                .build();
    }

    public static Book createTestBookA() {
        return Book.builder()
                .isbn("999-1-2222-3333-0")
                .title("The Shadow")
                .author_id(1L)
                .build();
    }

    public static Book createTestBookB() {
        return Book.builder()
                .isbn("999-1-2222-3332-0")
                .title("The Blaster")
                .author_id(1L)
                .build();
    }
}
