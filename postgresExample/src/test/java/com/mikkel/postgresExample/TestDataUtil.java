package com.mikkel.postgresExample;

import com.mikkel.postgresExample.domain.Author;
import com.mikkel.postgresExample.domain.Book;

public class TestDataUtil {
    private TestDataUtil(){}

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();
    }

    public static Book createTestBook() {
        return Book.builder()
                .isbn("999-1-2222-3333-0")
                .title("The Shadow")
                .author_id(1L)
                .build();
    }
}
