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
