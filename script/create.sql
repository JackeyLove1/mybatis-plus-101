create database if not exists mp;

drop table if exists t_user;

create table if not exists `t_user`
(
    id         bigint(20)  not null auto_increment,
    name       varchar(30) not null,
    user_name  varchar(30) not null,
    age        int(11)     not null,
    email      varchar(50) not null,
    password   varchar(50) not null,
    is_deleted tinyint default 0,
    constraint primary key (id),
    constraint unique (name)
);

create index idx_user_name on t_user (name);

insert into t_user (id, user_name, name, age, email, password)
values (1, 'Jone', 'Jone', 18, 'test1@baomidou.com', '123456'),
       (2, 'Jack', 'Jack', 20, 'test2@baomidou.com', '123456'),
       (3, 'Tom', 'Tom', 28, 'test3@baomidou.com', '123456'),
       (4, 'Sandy', 'Sandy', 21, 'test4@baomidou.com', '123456'),
       (5, 'Bollie', 'Billie', 24, 'test5@baomidou.com', '123456');

drop table if exists t_product;

create table `t_product`
(
    id      bigint(20)  not null auto_increment,
    name    varchar(30) not null default '',
    price   int(11)              default 0,
    version int(11)     not null default 0,
    gender  tinyint     not null default 0,
    constraint primary key (id)
);

insert into t_product(NAME, PRICE)
VALUES ('laptop', 100);

drop table if exists t_order;
create table `t_order`(
    id bigint(20) not null auto_increment,
    user_id bigint(20) not null,
    product_id bigint(20) not null,
    version int(11) not null default 0,
    constraint primary key (id),
    constraint unique (user_id, product_id),
    index idx_user_id (user_id),
    index idx_product_id (product_id),
    index idx_user_id_product_id (user_id, product_id)
);