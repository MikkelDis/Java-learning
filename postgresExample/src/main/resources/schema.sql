DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS books;

CREATE TABLE authors (
    id BIGSERIAL PRIMARY KEY,
    name TEXT,
    age INTEGER
);

CREATE TABLE books (
    isbn text PRIMARY KEY,
    title TEXT,
    author_id BIGINT,
    CONSTRAINT "fk_author" FOREIGN KEY(author_id)
    REFERENCES authors(id)
);