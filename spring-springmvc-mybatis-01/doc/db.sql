
create database test collate utf8_general_ci;

use test;

create table user
(
	id int auto_increment	primary key,
	name varchar(40) null,
	password varchar(40) null,
	email varchar(60) null,
	birthday varchar(50) null
);

INSERT INTO user (name, password, email, birthday) VALUES ('zhansan', '123456', 'zs@sina.com', '1980-12-04');
INSERT INTO user (name, password, email, birthday) VALUES ('lisi', '123456', 'lisi@sina.com', '1981-12-04');
INSERT INTO user (name, password, email, birthday) VALUES ('wangwu', '123456', 'wangwu@sina.com', '1979-12-04');
INSERT INTO user (name, password, email, birthday) VALUES ('麻子', '123456', 'mazi@sina.com', '1999-12-04');

