create unique index IDX_ST_CUSTOMER_UK_NAME on ST_CUSTOMER (NAME) where DELETE_TS is null ;
create unique index IDX_ST_CUSTOMER_UK_EMAIL on ST_CUSTOMER (EMAIL) where DELETE_TS is null ;
