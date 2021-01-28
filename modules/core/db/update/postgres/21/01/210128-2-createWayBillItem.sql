alter table ST_WAY_BILL_ITEM add constraint FK_ST_WAY_BILL_ITEM_ON_WAY_BILL foreign key (WAY_BILL_ID) references ST_WAY_BILL(ID);
create unique index IDX_ST_WAY_BILL_ITEM_UK_NUMBER_ on ST_WAY_BILL_ITEM (NUMBER_) where DELETE_TS is null ;
create unique index IDX_ST_WAY_BILL_ITEM_UK_NAME on ST_WAY_BILL_ITEM (NAME) where DELETE_TS is null ;
create index IDX_ST_WAY_BILL_ITEM_ON_WAY_BILL on ST_WAY_BILL_ITEM (WAY_BILL_ID);
