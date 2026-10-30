package com.mikkel.postgresExample.dao.impl;

import com.mikkel.postgresExample.dao.IAuthorDao;
import com.mikkel.postgresExample.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

    public Optional<Author> findOne(long author_id){
        List<Author> results = jdbcTemplate.query("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1",
                new AuthorRowMapper(), author_id);
        return results.stream().findFirst();
    }

    public static class AuthorRowMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Author.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }
    }
}
