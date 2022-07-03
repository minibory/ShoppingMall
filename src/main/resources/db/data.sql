SET foreign_key_checks = 0;
drop table if exists tbl_user_role;
drop table if exists tbl_user_product;
drop table if exists tbl_user;
drop table if exists tbl_product;
drop table if exists tbl_role;
SET foreign_key_checks = 1;

create table if not exists tbl_role
(
    id        bigint auto_increment
        primary key,
    role_name int null
);

create table if not exists tbl_user
(
    id       bigint auto_increment
        primary key,
    active   bit          null,
    address  varchar(255) null,
    nickname varchar(50)  null,
    password varchar(255) null,
    tel_no   varchar(12)  null,
    username varchar(100) not null,
    constraint UK_k0bty7tbcye41jpxam88q5kj2
        unique (username)
);

create table if not exists tbl_product
(
    id                 bigint auto_increment
        primary key,
    product_img        varchar(255) null,
    product_name       varchar(100) not null,
    product_price      int          null,
    product_sale_price int          null,
    product_sale_yn    bit          null,
    product_stock      int          null,
    user_id            bigint       null,
    constraint UK_225w24goxmb9p466u5inv6g0b
        unique (product_name),
    constraint FKbcejabdqv6xehq9386c69job
        foreign key (user_id) references tbl_user (id)
);

create table if not exists tbl_user_product
(
    user_id     bigint not null,
    products_id bigint not null,
    constraint UK_hn8qyf7bopol4rn6lkxmgrys5
        unique (products_id),
    constraint FKk1mch1efey1vhxbyse3ad32rq
        foreign key (user_id) references tbl_user (id),
    constraint FKtasi1rb77nhji92eyphyp3xxf
        foreign key (products_id) references tbl_product (id)
);

create table if not exists tbl_user_role
(
    role_id bigint null,
    user_id bigint not null
        primary key,
    constraint FK6phlytlf1w3h9vutsu019xor5
        foreign key (role_id) references tbl_role (id),
    constraint FKggc6wjqokl2vlw89y22a1j2oh
        foreign key (user_id) references tbl_user (id)
);

INSERT INTO TBl_USER (ACTIVE, ADDRESS, NICKNAME, PASSWORD, TEL_NO, USERNAME) VALUES (true, '지구', '마스터','$2a$10$BCxDtQqo87oe69JFc5liW.TdJtusKHhYr3z/y9vLDm5Z.yvMSHH1y','00100020003','superadmin');
-- password user1234

insert into tbl_role (role_name) values (0);
insert into tbl_role (role_name) values (1);

insert into tbl_user_role (role_id, user_id)
VALUES (1, 1);

