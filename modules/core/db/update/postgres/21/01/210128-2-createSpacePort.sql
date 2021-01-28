alter table ST_SPACE_PORT add constraint FK_ST_SPACE_PORT_ON_PLANET foreign key (PLANET_ID) references ST_PLANET(ID);
alter table ST_SPACE_PORT add constraint FK_ST_SPACE_PORT_ON_MOON foreign key (MOON_ID) references ST_MOON(ID);
create unique index IDX_ST_SPACE_PORT_UK_NAME on ST_SPACE_PORT (NAME) where DELETE_TS is null ;
create index IDX_ST_SPACE_PORT_ON_PLANET on ST_SPACE_PORT (PLANET_ID);
create index IDX_ST_SPACE_PORT_ON_MOON on ST_SPACE_PORT (MOON_ID);
