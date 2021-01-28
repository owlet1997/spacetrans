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
-- begin ST_WAY_BILL
create table ST_WAY_BILL (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    REFERENCE varchar(100) not null,
    CREATOR_ID uuid not null,
    SHIPPER_ID uuid not null,
    CONSIGNEE_ID uuid not null,
    DEPARTURE_PORT_ID uuid not null,
    DESTINATION_PORT_ID uuid,
    CARRIER_ID uuid not null,
    TOTAL_WEIGHT double precision not null,
    TOTAL_CHARGE double precision not null,
    --
    primary key (ID)
)^
-- end ST_WAY_BILL
-- begin ST_CARRIER
create table ST_CARRIER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(50) not null,
    --
    primary key (ID)
)^
-- end ST_CARRIER
-- begin ST_SPACE_PORT
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
)^
-- end ST_SPACE_PORT
-- begin ST_CUSTOMER
create table ST_CUSTOMER (
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
    NAME varchar(50) not null,
    EMAIL varchar(100) not null,
    GRADE varchar(50) not null,
    --
    primary key (ID)
)^
-- end ST_CUSTOMER
-- begin ST_INDIVIDUAL
create table ST_INDIVIDUAL (
    ID uuid,
    --
    FIRST_NAME varchar(50) not null,
    LAST_NAME varchar(50) not null,
    --
    primary key (ID)
)^
-- end ST_INDIVIDUAL

-- begin ST_WAY_BILL_ITEM
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
)^
-- end ST_WAY_BILL_ITEM
-- begin ST_DISCOUNTS
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
)^
-- end ST_DISCOUNTS
-- begin ST_CARRIER_SPACE_PORT_LINK
create table ST_CARRIER_SPACE_PORT_LINK (
    SPACE_PORT_ID uuid,
    CARRIER_ID uuid,
    primary key (SPACE_PORT_ID, CARRIER_ID)
)^
-- end ST_CARRIER_SPACE_PORT_LINK
-- begin ST_COMPANY
create table ST_COMPANY (
    ID uuid,
    --
    REGISTRATION_ID varchar(100) not null,
    COMPANY_TYPE varchar(100) not null,
    --
    primary key (ID)
)^
-- end ST_COMPANY
