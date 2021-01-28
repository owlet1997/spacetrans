create table ST_SPACE_PORT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    COORDINATES_LATITUDE double precision not null,
    COORDINATES_LONGTITUDE double precision not null,
    --
    NAME varchar(50) not null,
    PLANET_ID uuid,
    MOON_ID uuid,
    IS_DEFAULT boolean,
    --
    primary key (ID)
);