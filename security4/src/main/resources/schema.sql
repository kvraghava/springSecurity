create table my_user(username varchar2(20),password varchar2(30),enabled char(1));

create table my_auth(username varchar2(20),authority varchar2(50)); 


insert into my_user values("raghava","raghava","y");
insert into my_user values("suresh","sure","y");

insert into my_auth values("raghava","ADMIN");
insert into my_auth values("suresh","USER");