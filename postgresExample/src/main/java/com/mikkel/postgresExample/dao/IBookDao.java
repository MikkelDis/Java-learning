package com.mikkel.postgresExample.dao;

import com.mikkel.postgresExample.domain.Book;

import java.util.List;
import java.util.Optional;

public interface IBookDao {

    void create(Book book);

    Optional<Book> findOne(String isbn);

    List<Book> find();

    void update(String isbn, Book book);

    void delete(String isbn);
}
