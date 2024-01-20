create table ${primarySchema}.Company (
    id bigint not null primary key,
    name VARCHAR(200),
    address varchar(200),
    phone varchar(50),
    contact_first_name varchar(200),
    contact_last_name varchar(200),
    contact_phone varchar(50)
);


CREATE SEQUENCE ${primarySchema}.company_id_seq START 1;

