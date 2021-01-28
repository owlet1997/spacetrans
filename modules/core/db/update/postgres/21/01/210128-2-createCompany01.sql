alter table ST_COMPANY add constraint FK_ST_COMPANY_ON_ID foreign key (ID) references ST_CUSTOMER(ID) on delete CASCADE;
