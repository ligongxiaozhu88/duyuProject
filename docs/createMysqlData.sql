DROP DATABASE IF exists `project`;
go

CREATE database if not exists `project` default character set utf8;
go

USE `project`;
go

SET FOREIGN_KEY_CHECKS=0;
go

DROP　TABLE if exists `user`;
go

CREATE TABLE `user` (
   `uid` varchar(40) NOT NULL,
   `username` varchar(30) default NULL,
   `upassword` varchar(30) default NULL,
   `comm` varchar(30) default NULL,
   `createDate` datetime default NULL,
   `sexId` tinyint(1) default NULL,
   `sfsc` tinyint(1) default NULL,
   `scr_id` varchar(40) default NULL,
   `scsj` datetime default NULL,
   `scyy` varchar(255) default NULL,
   PRIMARY KEY  (`uid`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
go

DROP　table if exists `updateTableInfo`;
go

create table `updateTableInfo`(
	`id` int(11) not null auto_increment,
	`updateTaskName` varchar(255) not null default '' comment '更新库任务名称',
	`updateTaskTime` datetime default null comment '更新时间',
	primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
go

