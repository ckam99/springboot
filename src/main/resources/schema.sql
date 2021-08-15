drop table if exists SUBJECTS;
create table SUBJECTS(
    id int AUTO_INCREMENT primary key,
    name varchar(60) not null
);

drop table if exists STUDENTS;
create table STUDENTS(
    id int AUTO_INCREMENT primary key,
    name varchar(60) not null
);

drop table if exists TEACHERS;
create table TEACHERS(
    id int AUTO_INCREMENT primary key,
    name varchar(60) not null
);