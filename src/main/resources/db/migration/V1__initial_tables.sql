
-- users
CREATE TABLE IF NOT EXISTS users(
    id serial not null primary key,
    email varchar(255) not null unique,
    password varchar(255),
    name varchar(60)
);

-- todos
CREATE TABLE IF NOT EXISTS todos(
    id serial not null primary key,
    title varchar(255) not null unique,
    completed boolean default false,
    user_id int4
);

