/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.17-log : Database - tcgbtms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tcgbtms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tcgbtms`;

/*Table structure for table `t_documents` */

DROP TABLE IF EXISTS `t_documents`;

CREATE TABLE `t_documents` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '文档名',
  `contentType` varchar(100) NOT NULL COMMENT '内容类型',
  `filePath` varchar(255) NOT NULL COMMENT '文件存储路径',
  `contentDigest` varchar(255) NOT NULL COMMENT '内容摘要',
  `categoryId` int(11) unsigned DEFAULT NULL COMMENT '文档类型',
  `status` smallint(1) unsigned DEFAULT '1' COMMENT '文档状态(1-UNPUBLISHED,2-PUBLISHED,3-DOWNLINE)',
  `remark` mediumtext COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='文档表';

/*Data for the table `t_documents` */

insert  into `t_documents`(`id`,`name`,`contentType`,`filePath`,`contentDigest`,`categoryId`,`status`,`remark`,`createdTime`,`modifiedTime`,`createdUser`,`modifiedUser`) values (1,'a.doc','application/doc','/uploads/projects/a.doc','AAAAAAAAAAAAAAAA',NULL,1,'aaaaaaaaaa','2018-10-29 17:19:53','2018-10-29 17:19:53','admin','admin'),(2,'b.doc','application/doc','/uploads/projects/b.doc','AAAAAAAAAAAAAAAA',NULL,2,'aaaaaaaaaa','2018-10-29 17:20:27','2018-10-29 17:20:27','admin','admin'),(3,'c.doc','application/doc','/uploads/projects/b.doc','AAAAAAAAAAAAAAAA',NULL,2,'aaaaaaaaaa','2018-12-23 04:55:29','2018-12-23 04:55:29','admin','admin'),(4,'c.doc','application/doc','/uploads/projects/b.doc','AAAAAAAAAAAAAAAA',NULL,2,'aaaaaaaaaa','2018-12-23 05:15:59','2018-12-23 05:15:59','admin','admin'),(5,'d.doc','application/doc','/uploads/projects/b.doc','AAAAAAAAAAAAAAAA',NULL,2,'aaaaaaaaaa','2018-12-23 05:18:44','2018-12-23 05:18:44','admin','admin'),(6,'d.doc','application/doc','/uploads/projects/b.doc','AAAAAAAAAAAAAAAA',NULL,2,'aaaaaaaaaa','2019-05-07 14:41:29','2019-05-07 14:41:29','admin','admin');

/*Table structure for table `t_members` */

DROP TABLE IF EXISTS `t_members`;

CREATE TABLE `t_members` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) DEFAULT NULL COMMENT '鏄电О',
  `password` char(32) NOT NULL DEFAULT '' COMMENT '瀵嗙爜',
  `realname` varchar(36) NOT NULL DEFAULT '' COMMENT '鐪熷疄濮撳悕',
  `gender` enum('MALE','FEMALE','NONE') NOT NULL DEFAULT 'NONE' COMMENT '濮撳悕',
  `rank` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '浼氬憳绛夌骇',
  `email` char(50) NOT NULL DEFAULT '' COMMENT '閭??',
  `mobile` varchar(15) NOT NULL DEFAULT '' COMMENT '鎵嬫満鍙',
  `safequestion` varchar(255) NOT NULL DEFAULT '0' COMMENT '瀹夊叏闂??',
  `safeanswer` char(30) NOT NULL DEFAULT '' COMMENT '瀹夊叏绛旀?',
  `createdTime` datetime DEFAULT NULL COMMENT '鍒涘缓鏃堕棿',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='浼氬憳琛';

/*Data for the table `t_members` */

insert  into `t_members`(`id`,`nickname`,`password`,`realname`,`gender`,`rank`,`email`,`mobile`,`safequestion`,`safeanswer`,`createdTime`) values (3,'nick-01','654321','real-01','MALE',1,'e1@t.com','11111111111','1+1=?','2',NULL),(4,'nick-02','123456','real-02','MALE',1,'e1@t.com','11111111111','1+1=?','2',NULL),(5,'nick-02','123456','real-02','MALE',1,'e1@t.com','11111111111','1+1=?','2',NULL),(6,'nick-03','123456','real-03','MALE',1,'e1@t.com','11111111111','1+1=?','2','2018-10-21 18:21:07'),(8,'nick-04','123456','real-04','MALE',1,'e1@t.com','11111111111','1+1=?','2','2018-10-21 21:15:32'),(9,'nick-05','123456','real-05','MALE',3,'e1@t.com','11111111111','1+1=?','2','2018-10-21 21:36:44'),(10,'xiaoqiang','123456','zhaoqiang','MALE',1,'e1@t.com','11111111111','1+1=?','2','2018-12-19 15:18:20'),(11,'xiaoqiang','123456','zhaoqiang','MALE',1,'e1@t.com','11111111111','1+1=?','2','2018-12-19 15:23:46'),(12,'xiaoqiang','123456','zhaoqiang','MALE',1,'e1@t.com','11111111111','1+1=?','2','2019-03-27 13:06:25'),(13,'xiaoqiang','123456','zhaoqiang','MALE',1,'e1@t.com','11111111111','1+1=?','2','2019-03-28 17:13:17'),(14,'xiaoqiang','123456','zhaoqiang','MALE',1,'e1@t.com','11111111111','1+1=?','2','2019-04-22 12:08:13'),(15,'xiaoqiang','123456','zhaoqiang','MALE',1,'e1@t.com','11111111111','1+1=?','2','2019-04-22 14:40:56'),(16,'xiaoqiang','123456','zhaoqiang','MALE',1,'e1@t.com','11111111111','1+1=?','2','2019-04-22 14:47:14'),(17,'xiaoqiang','123456','zhaoqiang','MALE',1,'e1@t.com','11111111111','1+1=?','2','2019-04-22 14:51:20'),(18,'xiaoqiang','123456','zhaoqiang','MALE',1,'e1@t.com','11111111111','1+1=?','2','2019-05-07 14:22:49'),(19,'xiaoqiang','123456','zhaoqiang','MALE',1,'e1@t.com','11111111111','1+1=?','2','2019-05-07 14:38:59'),(20,'xiaoqiang','123456','zhaoqiang','MALE',1,'e1@t.com','11111111111','1+1=?','2','2019-05-07 14:40:05'),(21,'xiaoqiang','123456','zhaoqiang','MALE',1,'e1@t.com','11111111111','1+1=?','2','2019-06-22 19:01:10');

/*Table structure for table `t_orders` */

DROP TABLE IF EXISTS `t_orders`;

CREATE TABLE `t_orders` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '订单号',
  `memberid` int(11) unsigned DEFAULT NULL COMMENT '会员id',
  `goodsid` int(11) unsigned DEFAULT NULL COMMENT '商品id',
  `totalprice` float(10,2) unsigned DEFAULT NULL COMMENT '总价(价格)',
  `status` int(1) unsigned DEFAULT '0' COMMENT '订单状态',
  `remark` mediumtext COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='会员表';

/*Data for the table `t_orders` */

insert  into `t_orders`(`id`,`code`,`memberid`,`goodsid`,`totalprice`,`status`,`remark`,`createdTime`) values (1,'100001',3,1,100.00,1,'mark ...','2018-10-22 22:38:58'),(2,'100002',3,2,101.00,1,'mark ...','2018-10-23 09:57:31');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
