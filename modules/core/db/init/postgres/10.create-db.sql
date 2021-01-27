-- begin ST_ATMOSPHERE
create table ST_ATMOSPHERE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DESCRIPTION varchar(255) not null,
    PRESSURE double precision,
    --
    primary key (ID)
)^
-- end ST_ATMOSPHERE
-- begin ST_GAS
create table ST_GAS (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end ST_GAS
-- begin ST_ATMOSPHERIC_GAS
create table ST_ATMOSPHERIC_GAS (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    GAS_ID uuid not null,
    VOLUME double precision not null,
    ATMOSPHERE_ID uuid not null,
    --
    primary key (ID)
)^
-- end ST_ATMOSPHERIC_GAS
-- begin ST_PLANET
create table ST_PLANET (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255) not null,
    MASS double precision not null,
    PICTURE_ID uuid,
    --
    SEMI_MAJOR_AXES double precision not null,
    ORBITAL_PERIOD double precision not null,
    ROTATION_PERIOD double precision,
    ATMOSPHERE_ID uuid,
    RINGS boolean not null,
    --
    primary key (ID)
)^
-- end ST_PLANET
-- begin ST_MOON
create table ST_MOON (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255) not null,
    MASS double precision not null,
    PICTURE_ID uuid,
    --
    ATMOSPHERE_ID uuid,
    PLANET_ID uuid not null,
    --
    primary key (ID)
)^
-- end ST_MOON
