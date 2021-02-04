DROP DATABASE IF EXISTS tcgbdms;
CREATE DATABASE tcgbdms default character set utf8;
USE tcgbdms;
--
-- Table structure for table `tms_member`
--
drop table  if exists `tms_members`;
CREATE TABLE `t_members` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `password` char(32) NOT NULL DEFAULT '' COMMENT '密码',
  `realname` varchar(36) NOT NULL DEFAULT '' COMMENT '真实姓名',
  `gender` enum('MALE','FEMALE','NONE') NOT NULL DEFAULT 'NONE' COMMENT '姓名',
  `rank` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '会员等级',
  `email` char(50) NOT NULL DEFAULT '' COMMENT '邮箱',
  `mobile` varchar(15) NOT NULL DEFAULT '' COMMENT '手机号',
  `safequestion` varchar(255) NOT NULL DEFAULT '0' COMMENT '安全问题',
  `safeanswer` char(30) NOT NULL DEFAULT '' COMMENT '安全答案',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='会员表';


drop table  if exists `t_orders`;
CREATE TABLE `t_orders` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '订单号',
  `memberid` int(11) unsigned DEFAULT NULL COMMENT '会员id',
  `goodsid` int(11) unsigned DEFAULT NULL COMMENT '商品id',
  `totalprice` float(10,2) unsigned DEFAULT NULL COMMENT '总价(价格)',
  `status` smallint(1) unsigned DEFAULT '0' COMMENT '订单状态',
  `remark` mediumtext COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
   UNIQUE KEY   (`code`) USING BTREE,
   PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单表';

drop table  if exists `t_documents`;
CREATE TABLE `t_documents` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '文档名',
  `contentType` varchar(100) NOT NULL COMMENT '内容类型',
  `filePath` varchar(255) NOT NULL COMMENT '文件存储路径',
  `contentDigest` varchar(255)  NOT NULL COMMENT '内容摘要',
  `categoryId` int(11) unsigned DEFAULT NULL COMMENT '文档类型',
  `status` smallint(1) unsigned DEFAULT '1'  COMMENT '文档状态(1-UNPUBLISHED,2-PUBLISHED,3-DOWNLINE)',
  `remark` mediumtext COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
   PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='文档表';
