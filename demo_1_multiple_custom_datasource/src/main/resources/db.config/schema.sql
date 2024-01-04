create table learning_jpa_hibernate.message (
	id bigint,
	text varchar(255)
)

CREATE SEQUENCE IF NOT EXISTS learning_jpa_hibernate.message_id_seq START WITH 1 INCREMENT BY 1;

create table learning_jpa_hibernate.messageTwo (
	id bigint,
	text varchar(255)
)

CREATE SEQUENCE IF NOT EXISTS learning_jpa_hibernate.message_two_id_seq START WITH 1 INCREMENT BY 1;
