create table ST_WAY_BILL_ITEM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DIM_LENGTH double precision not null,
    DIM_WIDTH double precision not null,
    DIM_HEIGHT double precision not null,
    --
    NUMBER_ integer not null,
    NAME varchar(100) not null,
    WEIGHT double precision not null,
    CHARGE decimal(19, 2) not null,
    WAY_BILL_ID uuid not null,
    --
    primary key (ID)
);