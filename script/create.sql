create database if not exists mp;

drop table if exists t_user;

create table if not exists `t_user`
(
    id         bigint(20)  not null auto_increment,
    name       varchar(30) not null,
    age        int(11)     not null,
    email      varchar(50) not null,
    password   varchar(50) not null,
    is_deleted tinyint default 0,
    constraint primary key (id),
    constraint unique (name)
);

create index idx_user_name on t_user (name);

insert into t_user (id, name, age, email, password)
values (1, 'Jone', 18, 'test1@baomidou.com', '123456'),
       (2, 'Jack', 20, 'test2@baomidou.com', '123456'),
       (3, 'Tom', 28, 'test3@baomidou.com', '123456'),
       (4, 'Sandy', 21, 'test4@baomidou.com', '123456'),
       (5, 'Billie', 24, 'test5@baomidou.com', '123456');
