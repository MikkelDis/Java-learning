package com.mikkel.postgresExample.dao;

import com.mikkel.postgresExample.domain.Book;

import java.util.Optional;

public interface IBookDao {

    void create(Book book);

    Optional<Book> findOne(String isbn);
}
