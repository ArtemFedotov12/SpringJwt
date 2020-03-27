create table permission
 (
    id bigint not null auto_increment,
    parent_id bigint,
    code varchar(255),
    description varchar(255),
    name varchar(255),
    orderr integer not null,
    permission_group_id bigint,
    primary key (id)
    ) ;

create table permission_group
     (
    id bigint not null auto_increment,
    parent_id bigint, code varchar(255),
    description varchar(255),
    name varchar(255), orderr integer not null,
    primary key (id)
) ;

create table role (
    id bigint not null auto_increment,
    description varchar(255),
    name varchar(255),
    primary key (id)
   ) ;
create table user (id bigint not null auto_increment, age integer, is_active bit, password varchar(255), salary float, username varchar(255), primary key (id)) ;
create table user_roles (user_id bigint not null, role_id bigint not null, primary key (user_id, role_id)) ;
alter table permission add constraint FKj8b47vqnucijscjac9jcca9gi foreign key (parent_id) references permission (id);
alter table permission add constraint FKtqibh46a99ho0ooxbqphdi2js foreign key (permission_group_id) references permission_group (id);
alter table permission_group add constraint FKtns7dv80msetni0am9s6hrgiq foreign key (parent_id) references permission_group (id);
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id);
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id);