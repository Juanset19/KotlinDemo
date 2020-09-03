drop table if exists book;
drop table if exists author;
drop table if exists genre;

create table genre
(
    id BIGINT PRIMARY KEY,
    name VARCHAR(256)
);

create table author
(
    id BIGINT PRIMARY KEY,
    name VARCHAR(256),
    last_name VARCHAR(256)
);

create table book
(
    id BIGINT PRIMARY KEY,
    title VARCHAR(256),
    genre_id BIGINT,
    author_id BIGINT,
    FOREIGN KEY (genre_id) REFERENCES genre(id),
    FOREIGN KEY (author_id) REFERENCES author(id)
);

