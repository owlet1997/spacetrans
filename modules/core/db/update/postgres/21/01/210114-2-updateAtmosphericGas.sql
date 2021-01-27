alter table ST_ATMOSPHERIC_GAS rename column volume to volume__u22368 ;
alter table ST_ATMOSPHERIC_GAS alter column volume__u22368 drop not null ;
alter table ST_ATMOSPHERIC_GAS add column VOLUME double precision ^
update ST_ATMOSPHERIC_GAS set VOLUME = 0 where VOLUME is null ;
alter table ST_ATMOSPHERIC_GAS alter column VOLUME set not null ;
