create table ST_CARRIER_SPACE_PORT_LINK (
    SPACE_PORT_ID uuid,
    CARRIER_ID uuid,
    primary key (SPACE_PORT_ID, CARRIER_ID)
);
