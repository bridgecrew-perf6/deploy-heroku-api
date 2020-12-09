CREATE TABLE kb_test_master (
	id BIGSERIAL PRIMARY KEY NOT NULL,
	name varchar(255) NOT NULL,
	status varchar(255) NULL,
	level varchar(255) NULL,
	created_by varchar(255) NOT NULL,
    created_on timestamp NOT NULL,
    updated_by varchar(255) NULL,
    updated_on timestamp NULL
);

CREATE table kb_question_master (
	id BIGSERIAL PRIMARY KEY NOT NULL,
	question varchar(255) NULL,
	status varchar(255) NULL,
	level varchar(255) NULL,
	type varchar(255) NULL,
	created_by varchar(255) NOT NULL,
    created_on timestamp NOT NULL,
    updated_by varchar(255) NULL,
    updated_on timestamp NULL
);

ALTER TABLE kb_question_master ADD COLUMN test_id int;

ALTER TABLE kb_question_master ADD FOREIGN KEY (test_id) REFERENCES kb_test_master(id);

CREATE TABLE kb_question_option_master(
	id BIGSERIAL PRIMARY KEY NOT NULL,option varchar(255) NULL,
	question_id int,
	is_answer varchar(255) NULL,
	answer_description varchar(255) NULL,
	created_by varchar(255) NOT NULL,
	created_on timestamp NOT NULL,
	updated_by varchar(255) NULL,
	updated_on timestamp NULL,
	status varchar(255) NOT null,
	CONSTRAINT kb_question_option_question_id_fkey FOREIGN KEY (question_id) REFERENCES kb_qustion_master(id)
);

CREATE TABLE kb_user_master(
	id BIGSERIAL PRIMARY KEY NOT NULL,
	email varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
    first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	mobile varchar(255) NULL,
	created_by varchar(255) NOT NULL,
	created_on timestamp NOT NULL,
	updated_by varchar(255) NULL,
	updated_on timestamp NULL,
	status varchar(255) NOT null
);

CREATE TABLE kb_category_master (
	id BIGSERIAL PRIMARY KEY NOT NULL,
	name varchar(255) NOT NULL,
	status varchar(255) NULL,
	parent_id varchar(255) NULL,
	created_by varchar(255) NOT NULL,
    created_on timestamp NOT NULL,
    updated_by varchar(255) NULL,
    updated_on timestamp NULL
);

ALTER TABLE kb_test_master ADD COLUMN category_id int;
ALTER TABLE kb_test_master ADD FOREIGN KEY (category_id) REFERENCES kb_category_master(id);

ALTER TABLE kb_question_master ADD COLUMN category_id int;
ALTER TABLE kb_question_master ADD FOREIGN KEY (category_id) REFERENCES kb_category_master(id);

ALTER TABLE kb_user_master ADD COLUMN role_type varchar;
