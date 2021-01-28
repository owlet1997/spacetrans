create table ST_DISCOUNTS (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    GRADE varchar(50) not null,
    VALUE_ decimal(2, 2) not null,
    --
    primary key (ID)
);