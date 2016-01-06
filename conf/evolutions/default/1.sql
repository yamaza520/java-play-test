# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table task (
  id                        bigint auto_increment not null,
  contents                  varchar(255),
  created_date              datetime(6) not null,
  updated_date              datetime(6) not null,
  constraint pk_task primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table task;

SET FOREIGN_KEY_CHECKS=1;

