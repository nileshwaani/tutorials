create table employees (
    login varchar_ignorecase(50) not null primary key,
    password varchar_ignorecase(50) not null
);

create table roles (
    username varchar_ignorecase(50) not null,
    role varchar_ignorecase(50) not null,
    constraint fk_roles_employees foreign key(username) references employees(login)
);

create unique index ix_auth_username on roles (username,role);