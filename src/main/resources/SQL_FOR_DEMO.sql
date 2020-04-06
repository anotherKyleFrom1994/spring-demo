drop table DEMO_USERS;
drop sequence DEMO_USERS_PK_S;

create sequence DEMO_USERS_PK_S
increment by 1
start with 0
maxvalue 99999999999999999999
minvalue 0
nocycle;

create table DEMO_USERS(
  USER_ID number(20)  not null ,
  USER_NAME varchar(45) not null,
  PASSWD varchar(45) not null,
  constraint USER_PK primary key (USER_ID));
  
  
insert into DEMO_USERS(USER_ID, USER_NAME, PASSWD ) values (DEMO_USERS_PK_S.NEXTVAL, 'MarkZuckerberg', '123456789');

commit;