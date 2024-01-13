create table ${primarySchema}.Student (
    id bigint not null primary key,
    STUDENT_NAME varchar(100)
);


CREATE SEQUENCE ${primarySchema}.student_id_seq START 1;

