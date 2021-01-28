create table ST_COMPANY (
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
    REGISTRATION_ID varchar(100) not null,
    COMPANY_TYPE varchar(100) not null,
    --
    primary key (ID)
);