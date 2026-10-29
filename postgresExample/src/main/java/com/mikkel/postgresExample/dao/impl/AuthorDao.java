package com.mikkel.postgresExample.dao.impl;

import com.mikkel.postgresExample.dao.IAuthorDao;
import com.mikkel.postgresExample.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;

public class AuthorDao implements IAuthorDao {

    private final JdbcTemplate jdbcTemplate;

    public AuthorDao(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author){
        jdbcTemplate.update(
                "INSERT INTO authors (id, name, age) VALUES(?,?,?)",
                author.getId(), author.getName(), author.getAge()
        );
    }
}
