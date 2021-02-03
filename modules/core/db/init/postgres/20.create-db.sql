-- begin ST_GAS
create unique index IDX_ST_GAS_UK_NAME on ST_GAS (NAME) where DELETE_TS is null ^
-- end ST_GAS
-- begin ST_ATMOSPHERIC_GAS
alter table ST_ATMOSPHERIC_GAS add constraint FK_ST_ATMOSPHERIC_GAS_ON_GAS foreign key (GAS_ID) references ST_GAS(ID)^
alter table ST_ATMOSPHERIC_GAS add constraint FK_ST_ATMOSPHERIC_GAS_ON_ATMOSPHERE foreign key (ATMOSPHERE_ID) references ST_ATMOSPHERE(ID)^
create index IDX_ST_ATMOSPHERIC_GAS_ON_GAS on ST_ATMOSPHERIC_GAS (GAS_ID)^
create index IDX_ST_ATMOSPHERIC_GAS_ON_ATMOSPHERE on ST_ATMOSPHERIC_GAS (ATMOSPHERE_ID)^
-- end ST_ATMOSPHERIC_GAS
-- begin ST_PLANET
alter table ST_PLANET add constraint FK_ST_PLANET_ON_ATMOSPHERE foreign key (ATMOSPHERE_ID) references ST_ATMOSPHERE(ID)^
alter table ST_PLANET add constraint FK_ST_PLANET_ON_PICTURE foreign key (PICTURE_ID) references SYS_FILE(ID)^
create unique index IDX_ST_PLANET_UK_NAME on ST_PLANET (NAME) where DELETE_TS is null ^
create index IDX_ST_PLANET_ON_ATMOSPHERE on ST_PLANET (ATMOSPHERE_ID)^
create index IDX_ST_PLANET_ON_PICTURE on ST_PLANET (PICTURE_ID)^
-- end ST_PLANET
-- begin ST_MOON
alter table ST_MOON add constraint FK_ST_MOON_ON_ATMOSPHERE foreign key (ATMOSPHERE_ID) references ST_ATMOSPHERE(ID)^
alter table ST_MOON add constraint FK_ST_MOON_ON_PLANET foreign key (PLANET_ID) references ST_PLANET(ID)^
alter table ST_MOON add constraint FK_ST_MOON_ON_PICTURE foreign key (PICTURE_ID) references SYS_FILE(ID)^
create unique index IDX_ST_MOON_UK_NAME on ST_MOON (NAME) where DELETE_TS is null ^
create index IDX_ST_MOON_ON_ATMOSPHERE on ST_MOON (ATMOSPHERE_ID)^
create index IDX_ST_MOON_ON_PLANET on ST_MOON (PLANET_ID)^
create index IDX_ST_MOON_ON_PICTURE on ST_MOON (PICTURE_ID)^
-- end ST_MOON
-- begin ST_WAY_BILL
alter table ST_WAY_BILL add constraint FK_ST_WAY_BILL_ON_CREATOR foreign key (CREATOR_ID) references SEC_USER(ID)^
alter table ST_WAY_BILL add constraint FK_ST_WAY_BILL_ON_SHIPPER foreign key (SHIPPER_ID) references ST_CUSTOMER(ID)^
alter table ST_WAY_BILL add constraint FK_ST_WAY_BILL_ON_CONSIGNEE foreign key (CONSIGNEE_ID) references ST_CUSTOMER(ID)^
alter table ST_WAY_BILL add constraint FK_ST_WAY_BILL_ON_DEPARTURE_PORT foreign key (DEPARTURE_PORT_ID) references ST_SPACE_PORT(ID)^
alter table ST_WAY_BILL add constraint FK_ST_WAY_BILL_ON_DESTINATION_PORT foreign key (DESTINATION_PORT_ID) references ST_SPACE_PORT(ID)^
alter table ST_WAY_BILL add constraint FK_ST_WAY_BILL_ON_CARRIER foreign key (CARRIER_ID) references ST_CARRIER(ID)^
create index IDX_ST_WAY_BILL_ON_CREATOR on ST_WAY_BILL (CREATOR_ID)^
create index IDX_ST_WAY_BILL_ON_SHIPPER on ST_WAY_BILL (SHIPPER_ID)^
create index IDX_ST_WAY_BILL_ON_CONSIGNEE on ST_WAY_BILL (CONSIGNEE_ID)^
create index IDX_ST_WAY_BILL_ON_DEPARTURE_PORT on ST_WAY_BILL (DEPARTURE_PORT_ID)^
create index IDX_ST_WAY_BILL_ON_DESTINATION_PORT on ST_WAY_BILL (DESTINATION_PORT_ID)^
create index IDX_ST_WAY_BILL_ON_CARRIER on ST_WAY_BILL (CARRIER_ID)^
-- end ST_WAY_BILL
-- begin ST_CARRIER
create unique index IDX_ST_CARRIER_UK_NAME on ST_CARRIER (NAME) where DELETE_TS is null ^
-- end ST_CARRIER
-- begin ST_SPACE_PORT
alter table ST_SPACE_PORT add constraint FK_ST_SPACE_PORT_ON_PLANET foreign key (PLANET_ID) references ST_PLANET(ID)^
alter table ST_SPACE_PORT add constraint FK_ST_SPACE_PORT_ON_MOON foreign key (MOON_ID) references ST_MOON(ID)^
create unique index IDX_ST_SPACE_PORT_UK_NAME on ST_SPACE_PORT (NAME) where DELETE_TS is null ^
create index IDX_ST_SPACE_PORT_ON_PLANET on ST_SPACE_PORT (PLANET_ID)^
create index IDX_ST_SPACE_PORT_ON_MOON on ST_SPACE_PORT (MOON_ID)^
-- end ST_SPACE_PORT
-- begin ST_CUSTOMER
create unique index IDX_ST_CUSTOMER_UK_NAME on ST_CUSTOMER (NAME) where DELETE_TS is null ^
create unique index IDX_ST_CUSTOMER_UK_EMAIL on ST_CUSTOMER (EMAIL) where DELETE_TS is null ^
-- end ST_CUSTOMER

-- begin ST_WAY_BILL_ITEM
alter table ST_WAY_BILL_ITEM add constraint FK_ST_WAY_BILL_ITEM_ON_WAY_BILL foreign key (WAY_BILL_ID) references ST_WAY_BILL(ID)^
create unique index IDX_ST_WAY_BILL_ITEM_UK_NAME on ST_WAY_BILL_ITEM (NAME) where DELETE_TS is null ^
create index IDX_ST_WAY_BILL_ITEM_ON_WAY_BILL on ST_WAY_BILL_ITEM (WAY_BILL_ID)^
-- end ST_WAY_BILL_ITEM
-- begin ST_DISCOUNTS
create unique index IDX_ST_DISCOUNTS_UK_GRADE on ST_DISCOUNTS (GRADE) where DELETE_TS is null ^
create unique index IDX_ST_DISCOUNTS_UK_VALUE_ on ST_DISCOUNTS (VALUE_) where DELETE_TS is null ^
-- end ST_DISCOUNTS
-- begin ST_CARRIER_SPACE_PORT_LINK
alter table ST_CARRIER_SPACE_PORT_LINK add constraint FK_CARSPAPOR_ON_SPACE_PORT foreign key (SPACE_PORT_ID) references ST_SPACE_PORT(ID)^
alter table ST_CARRIER_SPACE_PORT_LINK add constraint FK_CARSPAPOR_ON_CARRIER foreign key (CARRIER_ID) references ST_CARRIER(ID)^
-- end ST_CARRIER_SPACE_PORT_LINK
-- begin ST_INDIVIDUAL
alter table ST_INDIVIDUAL add constraint FK_ST_INDIVIDUAL_ON_ID foreign key (ID) references ST_CUSTOMER(ID) on delete CASCADE^
-- end ST_INDIVIDUAL
-- begin ST_COMPANY
alter table ST_COMPANY add constraint FK_ST_COMPANY_ON_ID foreign key (ID) references ST_CUSTOMER(ID) on delete CASCADE^
-- end ST_COMPANY
