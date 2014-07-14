CREATE DATABASE lfycore;
USE lfycore;

--test DB
--DROP INDEX IF EXISTS productCat;

DROP TABLE IF EXISTS tb_user;

create table tb_user (
    id int not null AUTO_INCREMENT,
    name varchar(80) null,
    passwd varchar(80) null,
    status varchar(2) not null,
    constraint pk_user primary key (id)
);




