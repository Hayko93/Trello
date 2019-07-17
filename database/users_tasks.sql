drop database users_tasks;
create database users_tasks;
use users_tasks;

create table users
(
    id        int          not null primary key auto_increment,
    name      varchar(255) not null,
    last_name varchar(255) not null,
    email     varchar(255) not null unique,
    password  varchar(255) not null

);

create table tasks
(
    id         int          not null primary key auto_increment,
    title     varchar(255) not null,
    body       text         not null,
    created_at timestamp    not null default now(),
    user_id    int          not null,
    constraint users_users_tasks_id foreign key (user_id) references users (id)
);

create table roles
(
    id   tinyint     not null primary key auto_increment,
    role varchar(50) not null unique
);

create table users_roles
(
    user_id int     not null,
    role_id tinyint not null,
    constraint user_id_foreign_key foreign key (user_id) references users (id),
    constraint role_id_foreign_key foreign key (role_id) references roles (id)

);