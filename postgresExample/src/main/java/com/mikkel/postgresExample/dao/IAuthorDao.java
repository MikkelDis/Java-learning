package com.mikkel.postgresExample.dao;

import com.mikkel.postgresExample.domain.Author;

import java.util.Optional;

public interface IAuthorDao {
    void create(Author author);

    Optional<Author> findOne(long l);
}
