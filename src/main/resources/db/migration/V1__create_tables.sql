create table cash_desk
(
    cash_desk_id      bigserial      not null,
    balance           numeric(19, 2) not null,
    name              varchar(255)   not null,
    cash_desk_auth_id int8,
    primary key (cash_desk_id)
);

create table cash_desk_auth
(
    cash_desk_auth_id bigserial    not null,
    password          varchar(255) not null,
    username          varchar(255) not null,
    primary key (cash_desk_auth_id)
);

create table operation
(
    operation_id          bigserial      not null,
    amount                numeric(19, 2) not null,
    code                  varchar(255)   not null,
    created_date          timestamp      not null,
    currency              varchar(255)   not null,
    description           varchar(255),
    receiver_name         varchar(255)   not null,
    receiver_phone_number varchar(255),
    sender_name           varchar(255)   not null,
    sender_phone_number   varchar(255),
    total_som_amount      numeric(19, 2),
    status                varchar(255)   not null,
    from_cash_desk_id     int8,
    to_cash_desk_id       int8,
    primary key (operation_id)
);

alter table if exists cash_desk add constraint cash_desk_name_unique_constraint unique (name);

alter table if exists cash_desk_auth add constraint cash_desk_auth_unique_username_constraint unique (username);

alter table if exists operation add constraint operation_code_unique_constraint unique (code);

alter table if exists cash_desk
    add constraint cash_desk_cash_desk_auth_id_foreign_key_constaint foreign key (cash_desk_auth_id) references cash_desk_auth;

alter table if exists operation
    add constraint operation_from_cash_desk_id_foreign_key_constraint foreign key (from_cash_desk_id) references cash_desk;

alter table if exists operation
    add constraint operation_to_cash_desk_id_foreign_key_constraint foreign key (to_cash_desk_id) references cash_desk;
