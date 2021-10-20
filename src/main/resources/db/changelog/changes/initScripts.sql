-- liquibase formatted sql
-- changeset vevteev:2021-10-20-1
-- preconditions onFail:MARK_RAN
-- precondition-sql-check expectedResult:0 select count(*) from pg_catalog.pg_tables where tablename = 'category';
CREATE TABLE category
(
    category_id   SERIAL,
    category_code varchar(256) not null,
    primary key (category_id)
);

INSERT INTO category (category_code) VALUES ('TRANSPORT'), ('FOOD'), ('HOBBY');

-- create table CLIENT_ENTITY
-- (
--     CLIENT_ID BIGINT not null primary key,
--     LOGIN     VARCHAR(255),
--     PASSWORD  VARCHAR(255)
-- );
--
--
--
-- create table COST_ENTITY
-- (
--     COST_ID          BIGINT not null primary key,
--     CATEGORY_NAME    VARCHAR(255),
--     EXPENDITURE      DECIMAL(19, 2),
--     CLIENT_CLIENT_ID BIGINT,
--     constraint FKS501LYFAROCNEVUW6IEOOLLFL
--         foreign key (CLIENT_CLIENT_ID) references CLIENT_ENTITY (CLIENT_ID)
-- );
--
-- create table CLIENT_ENTITY_COSTS
-- (
--     CLIENT_ENTITY_CLIENT_ID BIGINT not null,
--     COSTS_COST_ID           BIGINT not null
--         constraint UK_8D1VCQWKN57IEFXCOI7NYPH89
--             unique,
--     constraint FK47I32XPJA40IIB52LMUC11BK7
--         foreign key (CLIENT_ENTITY_CLIENT_ID) references CLIENT_ENTITY (CLIENT_ID),
--     constraint FKMUVVW6V9RCQALYV20QVVOIWRX
--         foreign key (COSTS_COST_ID) references COST_ENTITY (COST_ID)
-- );

