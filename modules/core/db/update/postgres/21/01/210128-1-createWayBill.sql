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
);