DROP TABLE IF EXISTS student;
CREATE TABLE student
(
    id SERIAL primary key,
    name varchar(255) not null,
    email varchar(255) not null
);


