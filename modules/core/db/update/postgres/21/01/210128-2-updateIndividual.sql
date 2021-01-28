alter table ST_INDIVIDUAL rename column dtype to dtype__u40951 ;
alter table ST_INDIVIDUAL rename column deleted_by to deleted_by__u87993 ;
alter table ST_INDIVIDUAL rename column delete_ts to delete_ts__u92282 ;
alter table ST_INDIVIDUAL rename column updated_by to updated_by__u87938 ;
alter table ST_INDIVIDUAL rename column update_ts to update_ts__u85564 ;
alter table ST_INDIVIDUAL rename column created_by to created_by__u90723 ;
alter table ST_INDIVIDUAL rename column create_ts to create_ts__u77134 ;
alter table ST_INDIVIDUAL rename column version to version__u55738 ;
alter table ST_INDIVIDUAL alter column version__u55738 drop not null ;
