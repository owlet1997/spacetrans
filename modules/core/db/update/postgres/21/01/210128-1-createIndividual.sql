create table ST_INDIVIDUAL (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    FIRST_NAME varchar(50) not null,
    LAST_NAME varchar(50) not null,
    --
    primary key (ID)
);