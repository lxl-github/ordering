/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.23-log : Database - ordering_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ordering_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ordering_db`;

/*Table structure for table `ordering_activity` */

DROP TABLE IF EXISTS `ordering_activity`;

CREATE TABLE `ordering_activity` (
  `c_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'c_id',
  `c_code` varchar(5) NOT NULL COMMENT '活动编码',
  `c_name` varchar(50) NOT NULL COMMENT '活动名称',
  `c_type` int(11) NOT NULL DEFAULT '0' COMMENT '活动类型(1满减 、2折扣)',
  `c_range` int(11) NOT NULL DEFAULT '0' COMMENT '活动范围(1全部 2部分门店)',
  `c_start_time` int(11) NOT NULL DEFAULT '0' COMMENT '活动开始时间',
  `c_end_time` int(11) NOT NULL DEFAULT '0' COMMENT '活动结束时间',
  `c_status` int(11) NOT NULL DEFAULT '0' COMMENT '活动状态(0未审核、1已审核、2未开始、3已开始、4、已结束 )',
  `c_is_force_end` int(11) NOT NULL DEFAULT '0' COMMENT '是否强制结束(0否 1是)',
  `c_merchant_id` int(11) NOT NULL DEFAULT '0' COMMENT '商家id',
  `c_create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除(0否 1是)',
  `c_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `c_threshold_value` int(11) DEFAULT '0' COMMENT '阈值(满多少，单位：分)',
  `c_derate_amount` int(11) DEFAULT '0' COMMENT '减免金额(单位：分)',
  `c_discount` decimal(18,2) DEFAULT '0.00' COMMENT '折扣(0.95)',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='活动表;';

/*Data for the table `ordering_activity` */

insert  into `ordering_activity`(`c_id`,`c_code`,`c_name`,`c_type`,`c_range`,`c_start_time`,`c_end_time`,`c_status`,`c_is_force_end`,`c_merchant_id`,`c_create_time`,`c_is_deleted`,`c_modify_time`,`c_threshold_value`,`c_derate_amount`,`c_discount`) values (1,'10000','新店开业满50减10元',1,1,1514217600,1514563200,0,0,1,1514122547,0,'2017-12-24 21:35:47',50,10,'0.00');

/*Table structure for table `ordering_attribute` */

DROP TABLE IF EXISTS `ordering_attribute`;

CREATE TABLE `ordering_attribute` (
  `c_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'c_id',
  `c_name` varchar(20) NOT NULL COMMENT '属性名称',
  `c_type` int(11) NOT NULL DEFAULT '0' COMMENT '属性类型(0文本框、1下拉框、2复选框、3单选)',
  `c_orders` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `c_is_required` int(11) NOT NULL DEFAULT '0' COMMENT '是否必选(0否 1 是)',
  `c_merchant_id` int(11) NOT NULL DEFAULT '0' COMMENT '商家id',
  `c_create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除(0否，1是)',
  `c_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='菜品属性表;';

/*Data for the table `ordering_attribute` */

insert  into `ordering_attribute`(`c_id`,`c_name`,`c_type`,`c_orders`,`c_is_required`,`c_merchant_id`,`c_create_time`,`c_is_deleted`,`c_modify_time`) values (2,'口味',2,2,1,0,1512204154,0,'2017-12-02 16:42:34'),(4,'辣度',2,3,1,1,1514127476,0,'2017-12-24 22:57:56'),(10,'特色',0,555,0,1,1514705419,0,'2017-12-31 15:30:19'),(11,'口味',2,3,0,1,1514707525,0,'2017-12-31 16:05:25'),(12,'温度',3,4,0,1,1515061743,0,'2018-01-04 18:29:03'),(13,'规格',1,5,0,1,1515062657,0,'2018-01-04 18:44:17');

/*Table structure for table `ordering_attribute_value` */

DROP TABLE IF EXISTS `ordering_attribute_value`;

CREATE TABLE `ordering_attribute_value` (
  `c_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'c_id',
  `c_attribute_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '属性id',
  `c_value` varchar(20) NOT NULL DEFAULT '0' COMMENT '属性value',
  `c_create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除(0否 1是)',
  `c_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='菜品属性值表;';

/*Data for the table `ordering_attribute_value` */

insert  into `ordering_attribute_value`(`c_id`,`c_attribute_id`,`c_value`,`c_create_time`,`c_is_deleted`,`c_modify_time`) values (1,4,'微辣',1514127476,0,'2017-12-24 22:57:56'),(2,4,'中辣',1514127476,0,'2017-12-24 22:57:56'),(3,4,'麻辣',1514127476,0,'2017-12-24 22:57:56'),(4,4,'变态辣',1514127476,0,'2017-12-24 22:57:56'),(5,5,'大份',1514127750,0,'2017-12-24 23:02:30'),(6,5,'小份',1514127750,0,'2017-12-24 23:02:30'),(7,6,'大份',1514705145,0,'2017-12-31 15:25:45'),(8,6,'小份',1514705145,0,'2017-12-31 15:25:45'),(9,7,'是',1514705195,0,'2017-12-31 15:26:35'),(10,7,'否',1514705195,0,'2017-12-31 15:26:35'),(11,11,'咸',1514707525,0,'2017-12-31 16:05:25'),(12,11,'甜',1514707525,0,'2017-12-31 16:05:25'),(13,12,'微热',1515061743,0,'2018-01-04 18:29:03'),(14,12,'中热',1515061743,0,'2018-01-04 18:29:03'),(18,13,'份',1515958269,0,'2018-01-15 03:31:09'),(19,13,'斤',1515958269,0,'2018-01-15 03:31:09');

/*Table structure for table `ordering_category` */

DROP TABLE IF EXISTS `ordering_category`;

CREATE TABLE `ordering_category` (
  `c_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'c_id',
  `c_code` int(11) NOT NULL DEFAULT '0' COMMENT '分类编码',
  `c_name` varchar(20) NOT NULL COMMENT '分类名称',
  `c_parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '分类父id',
  `c_status` int(11) NOT NULL DEFAULT '0' COMMENT '分类状态(0正常 1作废)',
  `c_merchant_id` int(11) NOT NULL DEFAULT '0' COMMENT '商家id',
  `c_create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除(0否，1是)',
  `c_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='菜品分类表;';

/*Data for the table `ordering_category` */

insert  into `ordering_category`(`c_id`,`c_code`,`c_name`,`c_parent_id`,`c_status`,`c_merchant_id`,`c_create_time`,`c_is_deleted`,`c_modify_time`) values (1,10,'特殊推荐',0,0,0,1514114032,0,'2017-12-24 19:13:52'),(2,20,'主食',0,0,0,1514114066,0,'2017-12-24 19:14:26'),(3,30,'酒水',0,0,0,1514114088,0,'2017-12-24 19:14:48'),(4,40,'热饮',0,0,0,1514114200,0,'2017-12-24 19:16:40'),(5,50,'川湘风味',0,0,0,1514114232,0,'2017-12-24 19:17:12'),(6,10,'主食',0,0,1,1514114628,0,'2017-12-24 19:23:48'),(7,20,'酒水',0,0,1,1514126118,0,'2017-12-24 22:35:18'),(8,30,'热销推荐',0,0,1,1514126154,0,'2017-12-24 22:35:54'),(9,40,'川菜',0,0,1,1514126173,0,'2017-12-24 22:36:13'),(10,50,'凉菜',0,0,1,1514126230,0,'2017-12-24 22:37:10'),(11,60,'热菜',0,0,1,1514126249,0,'2017-12-24 22:37:29'),(12,44,'dfgfdsg',0,0,1,1530153553,0,'2018-06-28 10:39:13'),(13,34,'dfg',0,0,1,1530153560,0,'2018-06-28 10:39:20'),(14,434,'3434',0,0,1,1530153564,0,'2018-06-28 10:39:24'),(15,433,'44343',0,0,1,1530153569,0,'2018-06-28 10:39:29'),(18,3222,'sdfsdf',0,0,1,1530153663,0,'2018-06-28 10:41:03');

/*Table structure for table `ordering_member` */

DROP TABLE IF EXISTS `ordering_member`;

CREATE TABLE `ordering_member` (
  `c_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'c_id',
  `c_name` varchar(30) NOT NULL COMMENT '会员名称',
  `c_is_business` int(11) NOT NULL DEFAULT '0' COMMENT '是否企业会员(0否 1是)',
  `c_rank` int(11) NOT NULL DEFAULT '0' COMMENT '会员等级(1普通会员 2银牌会员 3金牌会员)',
  `c_telphone` varchar(11) NOT NULL COMMENT '会员手机号',
  `c_pass_word` varchar(50) DEFAULT '' COMMENT '密码',
  `c_merchant_id` int(11) NOT NULL DEFAULT '0' COMMENT '商家id',
  `c_score` int(11) DEFAULT '0' COMMENT '积分（1积分=1元）',
  `c_weixin_number` varchar(30) DEFAULT '' COMMENT '微信号',
  `c_open_id` varchar(30) DEFAULT '' COMMENT '微信openId',
  `c_weixin_name` varchar(30) DEFAULT '' COMMENT '微信名',
  `c_create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除(0否 1是)',
  `c_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员表;';

/*Data for the table `ordering_member` */

/*Table structure for table `ordering_merchant_info` */

DROP TABLE IF EXISTS `ordering_merchant_info`;

CREATE TABLE `ordering_merchant_info` (
  `c_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'c_id',
  `c_name` varchar(50) NOT NULL COMMENT '商家名称',
  `c_company_name` varchar(100) NOT NULL COMMENT '企业名称',
  `c_company_code` varchar(50) DEFAULT '' COMMENT '企业代码',
  `c_create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除(0否 1是)',
  `c_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商家表;';

/*Data for the table `ordering_merchant_info` */

insert  into `ordering_merchant_info`(`c_id`,`c_name`,`c_company_name`,`c_company_code`,`c_create_time`,`c_is_deleted`,`c_modify_time`) values (1,'青年餐厅','北京青年餐饮管理有限公司','1010101010001',1514111480,0,'2017-12-24 18:31:20');

/*Table structure for table `ordering_order` */

DROP TABLE IF EXISTS `ordering_order`;

CREATE TABLE `ordering_order` (
  `c_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'c_id',
  `c_order_sn` varchar(30) NOT NULL COMMENT '订单流水号',
  `c_order_status` int(11) NOT NULL DEFAULT '0' COMMENT '订单状态(0 待支付、1已支付 、2已取消)',
  `c_order_amount` int(11) NOT NULL DEFAULT '0' COMMENT '订单总金额(单位：分)',
  `c_pack_fee` int(11) NOT NULL DEFAULT '0' COMMENT '打包费(单位：分)',
  `c_discount` int(11) NOT NULL DEFAULT '0' COMMENT '优惠金额(单位：分)',
  `c_actual_amount` int(11) NOT NULL DEFAULT '0' COMMENT '实付金额(单位：分)',
  `c_pay_id` int(5) NOT NULL DEFAULT '0' COMMENT '支付方式id (1微信、2充值卡、3现金、4银联卡)',
  `c_pay_time` int(11) NOT NULL DEFAULT '0' COMMENT '支付时间',
  `c_order_source` int(11) NOT NULL DEFAULT '0' COMMENT '订单来源(1扫码点餐、2打包)',
  `c_member_id` int(11) DEFAULT '0' COMMENT '会员id',
  `c_remark` varchar(50) DEFAULT '' COMMENT '订单描述',
  `c_store_id` int(11) NOT NULL DEFAULT '0' COMMENT '门店id',
  `c_table_code` varchar(5) DEFAULT '' COMMENT '餐桌号',
  `c_create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除(0否 1是)',
  `c_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表;';

/*Data for the table `ordering_order` */

/*Table structure for table `ordering_order_activity` */

DROP TABLE IF EXISTS `ordering_order_activity`;

CREATE TABLE `ordering_order_activity` (
  `c_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'c_id',
  `c_activity_id` int(11) NOT NULL DEFAULT '0' COMMENT '活动id',
  `c_order_id` int(11) NOT NULL COMMENT '订单id',
  `c_order_sn` varchar(30) NOT NULL COMMENT '订单流水号',
  `c_create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除(0否 1是)',
  `c_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单与活动关联表;';

/*Data for the table `ordering_order_activity` */

/*Table structure for table `ordering_order_product` */

DROP TABLE IF EXISTS `ordering_order_product`;

CREATE TABLE `ordering_order_product` (
  `c_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'c_id',
  `c_order_id` int(11) NOT NULL COMMENT '订单id',
  `c_order_sn` varchar(30) NOT NULL COMMENT '订单流水号',
  `c_product_id` int(11) NOT NULL COMMENT '商品id',
  `c_product_number` varchar(10) NOT NULL COMMENT '商品编号',
  `c_product_name` varchar(50) NOT NULL COMMENT '商品名称',
  `c_product_price` int(11) NOT NULL DEFAULT '0' COMMENT '商品价格(单位：分)',
  `c_product_attribute_value` varchar(50) NOT NULL COMMENT '商品属性值(用逗号隔开，微辣,9分熟)',
  `c_num` int(11) NOT NULL DEFAULT '0' COMMENT '商品数量',
  `c_cost_price` int(11) NOT NULL DEFAULT '0' COMMENT '商品成本价(单位：分)',
  `c_create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除(0否 1是)',
  `c_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单明细表;';

/*Data for the table `ordering_order_product` */

/*Table structure for table `ordering_product` */

DROP TABLE IF EXISTS `ordering_product`;

CREATE TABLE `ordering_product` (
  `c_product_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `c_product_number` varchar(10) NOT NULL COMMENT '菜品编码',
  `c_product_name` varchar(50) NOT NULL COMMENT '菜品名称',
  `c_category_id` int(11) NOT NULL DEFAULT '0' COMMENT '菜品分类id',
  `c_product_picture` varchar(100) DEFAULT '' COMMENT '菜品图片',
  `c_unit` varchar(4) NOT NULL DEFAULT '' COMMENT '菜品单位（份、斤、等）',
  `c_sale_num` int(11) NOT NULL DEFAULT '0' COMMENT '起售数量',
  `c_is_back_print` int(11) NOT NULL DEFAULT '0' COMMENT '是否后厨打印(0是 1否)',
  `c_product_status` int(11) NOT NULL DEFAULT '0' COMMENT '菜品状态(0待上架、1在售、2已下架、3已删除)',
  `c_material_desc` varchar(200) DEFAULT '' COMMENT '原料描述(如:基础配料)',
  `c_features` varchar(100) DEFAULT '' COMMENT '特征(如:有养生作用)',
  `c_merchant_id` int(11) NOT NULL DEFAULT '0' COMMENT '商家id',
  `c_create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除(0 否,1 是)',
  `c_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`c_product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='菜品表;';

/*Data for the table `ordering_product` */

insert  into `ordering_product`(`c_product_id`,`c_product_number`,`c_product_name`,`c_category_id`,`c_product_picture`,`c_unit`,`c_sale_num`,`c_is_back_print`,`c_product_status`,`c_material_desc`,`c_features`,`c_merchant_id`,`c_create_time`,`c_is_deleted`,`c_modify_time`) values (4,'sltds001','酸辣土豆丝',11,'/img/1515870278.jpg','份',100,0,1,'土豆、胡萝卜、香醋、蒜、辣椒','香、美味',1,1514716790,0,'2017-12-31 18:39:50'),(5,'3333','rrrtr',11,'/img/1515833597.jpg','斤',111,0,2,'3333','3333',1,1514720337,0,'2017-12-31 19:38:58'),(6,'sltds002','酸辣土豆丝',11,'static/u=1827056041,2289396654&fm=58&bpow=1024&bpoh=680.jpg','份',100,0,1,'土豆、辣椒、蒜、醋、胡萝卜','下饭菜',1,1514894064,0,'2018-01-02 19:54:24'),(7,'ssss','sss',11,'/img/u=1827056041,2289396654&fm=58&bpow=1024&bpoh=680.jpg','份',100,0,1,'3333','333',1,1515037165,0,'2018-01-04 11:39:25'),(8,'fdfd','ddfe',8,'/img/1515043684.jpg','fee',166,0,1,'ddf','dff',1,1515038039,0,'2018-01-04 11:53:59'),(9,'eeee','sss',8,'/img/1530589705.JPG','份',331,0,1,'的地方','都放到',1,1515062557,0,'2018-01-04 18:42:37'),(10,'333','333',9,'/img/1515063272.jpg','克',0,0,1,'地方','水电费',1,1515062712,0,'2018-01-04 18:45:12'),(12,'3333','sssee',10,'/img/1530589743.jpg','份',111,0,1,'订单','订单',1,1515066455,0,'2018-01-04 19:47:35');

/*Table structure for table `ordering_product_attribute` */

DROP TABLE IF EXISTS `ordering_product_attribute`;

CREATE TABLE `ordering_product_attribute` (
  `c_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'c_id',
  `c_product_id` int(11) NOT NULL DEFAULT '0' COMMENT '菜品id',
  `c_value_id` varchar(10) DEFAULT '0' COMMENT '属性值id',
  `c_text_value` varchar(20) DEFAULT '' COMMENT '文本值',
  `c_attribute_id` int(11) NOT NULL DEFAULT '0' COMMENT '属性id',
  `c_create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除(0否 1是)',
  `c_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='菜品属性表;';

/*Data for the table `ordering_product_attribute` */

insert  into `ordering_product_attribute`(`c_id`,`c_product_id`,`c_value_id`,`c_text_value`,`c_attribute_id`,`c_create_time`,`c_is_deleted`,`c_modify_time`) values (5,6,'1','1',4,1514894064,0,'2018-01-02 19:54:24'),(6,6,'2','1',4,1514894064,0,'2018-01-02 19:54:24'),(7,7,'1','1',4,1515037166,0,'2018-01-04 11:39:26'),(8,7,'2','1',4,1515037166,0,'2018-01-04 11:39:26'),(11,8,'12','1',11,1515043701,0,'2018-01-04 13:28:21'),(17,10,'17','1',13,1515063358,0,'2018-01-04 18:55:58'),(29,5,'1','',4,1515833598,0,'2018-01-13 16:53:18'),(30,5,'2','',4,1515833598,0,'2018-01-13 16:53:18'),(33,4,'1','',4,1515958316,0,'2018-01-15 03:31:56'),(34,4,'2','',4,1515958316,0,'2018-01-15 03:31:56'),(38,9,'14','',12,1530589707,0,'2018-07-03 11:48:27'),(39,12,'1','',4,1530589745,0,'2018-07-03 11:49:05'),(40,12,'2','',4,1530589745,0,'2018-07-03 11:49:05'),(41,12,'3','',4,1530589745,0,'2018-07-03 11:49:05');

/*Table structure for table `ordering_product_rel_product` */

DROP TABLE IF EXISTS `ordering_product_rel_product`;

CREATE TABLE `ordering_product_rel_product` (
  `c_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'c_id',
  `c_product_id` int(11) DEFAULT NULL COMMENT 'c_product_id',
  `c_rel_product_id` int(11) NOT NULL DEFAULT '0' COMMENT '关联菜品id',
  `c_merchant_id` int(11) NOT NULL DEFAULT '0' COMMENT '商家id',
  `c_create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除(0否 1是)',
  `c_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜品关联菜品表;';

/*Data for the table `ordering_product_rel_product` */

/*Table structure for table `ordering_product_specification` */

DROP TABLE IF EXISTS `ordering_product_specification`;

CREATE TABLE `ordering_product_specification` (
  `c_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'c_id',
  `c_product_id` int(11) NOT NULL DEFAULT '0' COMMENT '菜品id',
  `c_specification_name` varchar(10) NOT NULL COMMENT '规格',
  `c_price` int(11) DEFAULT '0' COMMENT '销售价格(单位：分)',
  `c_member_price` int(11) DEFAULT '0' COMMENT '会员价（单位：分）',
  `c_cost_price` int(11) DEFAULT '0' COMMENT '成本价（单位：分）',
  `c_box_price` int(11) DEFAULT '0' COMMENT '餐盒价（单位：分）',
  `c_box_num` int(11) DEFAULT '0' COMMENT '餐盒数量',
  `c_create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除(0否 1是)',
  `c_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='菜品规格表;';

/*Data for the table `ordering_product_specification` */

insert  into `ordering_product_specification`(`c_id`,`c_product_id`,`c_specification_name`,`c_price`,`c_member_price`,`c_cost_price`,`c_box_price`,`c_box_num`,`c_create_time`,`c_is_deleted`,`c_modify_time`) values (3,6,'小份',16,15,8,2,1,1514894064,0,'2018-01-02 19:54:24'),(4,7,'份',33,20,22,3,3,1515037165,0,'2018-01-04 11:39:25'),(6,8,'efd',22,22,2,2,1,1515043701,0,'2018-01-04 13:28:21'),(12,10,'克',22,21,23,2,2,1515063358,0,'2018-01-04 18:55:58'),(17,5,'1斤',22,18,11,2,1,1515833598,0,'2018-01-13 16:53:18'),(19,4,'小份',18,16,8,2,1,1515958316,0,'2018-01-15 03:31:56'),(20,4,'大份',22,18,8,2,2,1515958316,0,'2018-01-15 03:31:56'),(22,9,'份',33,23,11,1,1,1530589707,0,'2018-07-03 11:48:27'),(23,12,'份',3,3,3,3,0,1530589745,0,'2018-07-03 11:49:05');

/*Table structure for table `ordering_resource` */

DROP TABLE IF EXISTS `ordering_resource`;

CREATE TABLE `ordering_resource` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(50) NOT NULL DEFAULT '' COMMENT '资源名称',
  `c_type` int(11) NOT NULL DEFAULT '0' COMMENT '资源类型 1:目录 2:菜单 3:按钮',
  `c_parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父级id',
  `c_icon` varchar(100) DEFAULT '' COMMENT '资源图标',
  `c_url` varchar(100) NOT NULL DEFAULT '' COMMENT '资源路径',
  `c_permission_value` varchar(50) DEFAULT '' COMMENT '资源权限码',
  `c_orders` int(11) NOT NULL DEFAULT '0' COMMENT '排序（1,2,3,4）',
  `c_create_time` int(11) DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) DEFAULT '0' COMMENT '是否删除 0 未删除 1已删除',
  `c_modified_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '系统修改时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COMMENT='资源表';

/*Data for the table `ordering_resource` */

insert  into `ordering_resource`(`c_id`,`c_name`,`c_type`,`c_parent_id`,`c_icon`,`c_url`,`c_permission_value`,`c_orders`,`c_create_time`,`c_is_deleted`,`c_modified_time`) values (1,'系统管理',1,0,'','','',1,0,0,'2017-11-25 21:34:21'),(2,'资源管理',2,1,'','menu/menu','menu:menu',1,0,0,'2017-11-25 21:35:00'),(3,'角色管理',2,1,'','role/role','role:role',2,0,0,'2017-11-25 21:35:28'),(4,'用户管理',2,1,'','user/user','user:user',3,0,0,'2017-11-25 21:35:49'),(5,'菜品管理',1,0,'','','',4,0,0,'2017-12-24 23:05:03'),(6,'商家管理',2,1,'','merchantInfo/merchantInfo','merchantInfo:merchantInfo',4,0,0,'2017-12-10 21:37:20'),(7,'菜单管理',1,0,'','','',5,0,0,'2017-12-24 23:05:45'),(8,'桌台管理',1,0,'','','',3,0,0,'2017-12-24 23:04:49'),(9,'销售管理',1,0,'','','',6,0,0,'2017-12-24 23:05:31'),(10,'订单管理',2,9,'','order/order','order:order',1,0,0,'2017-11-25 21:41:12'),(11,'活动管理',2,9,'','activity/activity','activity:activity',2,0,0,'2017-11-25 21:41:45'),(12,'菜品属性设置',2,5,'','product/attribute/attribute','product:attribute:attribute',1,0,0,'2017-12-02 15:29:33'),(13,'菜品分类设置',2,5,'','product/category/category','product:category:category',2,0,0,'2017-12-23 15:14:07'),(14,'菜品设置',2,5,'','product/product/product','product:product:product',3,0,0,'2017-12-23 15:14:45'),(15,'菜单设置',2,7,'','productmenu/productmenu','productmenu:productmenu',1,0,0,'2017-11-25 21:44:38'),(16,'添加',3,2,'','menu/add','menu:add',1,0,0,'2017-11-25 21:45:47'),(17,'删除',3,2,'','menu/remove','menu:remove',2,0,0,'2017-11-25 21:47:31'),(18,'编辑',3,2,'','menu/edit','menu:edit',3,0,0,'2017-11-25 21:47:44'),(19,'批量删除',3,2,'','menu/batchRemove','menu:batchRemove',4,0,0,'2017-11-25 21:47:16'),(20,'添加',3,3,'','role/add','role:add',1,0,0,'2017-11-25 21:48:15'),(21,'删除',3,3,'','role/remove','role:remove',2,0,0,'2017-11-25 21:48:45'),(22,'编辑',3,3,'','role/edit','role:edit',3,0,0,'2017-11-25 21:49:12'),(23,'授权',3,3,'','role/permis','role:permis',4,0,0,'2017-11-25 21:50:27'),(24,'添加',3,4,'','user/add','user:add',1,0,0,'2017-11-25 21:51:10'),(25,'修改',3,4,'','user/edit','user:edit',2,0,0,'2017-11-25 21:51:35'),(26,'删除',3,4,'','user/remove','user:remove',3,0,0,'2017-11-25 21:52:05'),(27,'角色授权',3,4,'','user/author','user:author',4,0,0,'2017-11-25 21:52:41'),(28,'门店管理',1,0,'','','',2,0,0,'2017-12-24 23:04:40'),(29,'桌台设置',2,8,'','table/table','table:table',1,0,0,'2017-12-10 21:40:39'),(30,'门店设置',2,28,'','store/store','store:store',1,0,0,'2017-12-23 15:07:54'),(31,'会员管理',2,9,'','member/member','member:member',3,0,0,'2017-12-10 21:42:55'),(32,'添加',3,30,'','store/add','store:add',1,0,0,'2017-12-23 15:06:27'),(33,'删除',3,30,'','store/remove','store:remove',2,0,0,'2017-12-23 15:07:09'),(34,'修改',3,30,'','store/edit','store:edit',3,0,0,'2017-12-23 15:08:28'),(35,'添加',3,29,'','table/add','table:add',1,0,0,'2017-12-23 15:09:01'),(36,'删除',3,29,'','table/remove','table:remove',2,0,0,'2017-12-23 15:09:40'),(37,'修改',3,29,'','table/edit','table:edit',3,0,0,'2017-12-23 15:10:20'),(38,'添加',3,11,'','activity/add','activity:add',1,0,0,'2017-12-23 15:10:53'),(39,'删除',3,11,'','activity/remove','activity:remove',2,0,0,'2017-12-23 15:11:33'),(40,'修改',3,11,'','activity/edit','activity:edit',3,0,0,'2017-12-23 15:12:14'),(41,'查看详情',3,10,'','order/order','order:detail',1,0,0,'2017-12-23 15:12:47'),(42,'添加',3,12,'','product/attribute/add','product:attribute:add',1,0,0,'2017-12-23 15:15:27'),(43,'删除',3,12,'','product/attribute/remove','product:attribute:remove',2,0,0,'2017-12-23 15:15:58'),(44,'修改',3,12,'','product/attribute/edit','product:attribute:edit',3,0,0,'2017-12-23 15:16:31'),(45,'添加',3,13,'','product/category/add','product:category:add',1,0,0,'2017-12-23 15:17:04'),(46,'删除',3,13,'','product/category/remove','product:category:remove',2,0,0,'2017-12-23 15:17:38'),(47,'修改',3,13,'','product/category/edit','product:category:edit',3,0,0,'2017-12-23 15:18:15'),(48,'添加',3,14,'','product/product/add','product:product:add',1,0,0,'2017-12-23 15:19:02'),(49,'删除',3,14,'','product/product/remove','product:product:remove',2,0,0,'2017-12-23 15:19:40'),(50,'修改',3,14,'','product/product/edit','product:product:edit',3,0,0,'2017-12-23 15:20:21'),(51,'添加',3,6,'','merchantInfo/add','merchantInfo:add',1,0,0,'2017-12-24 18:28:28'),(52,'删除',3,6,'','merchantInfo/remove','merchantInfo:remove',2,0,0,'2017-12-24 18:28:42'),(53,'修改',3,6,'','merchantInfo/edit','merchantInfo:edit',3,0,0,'2017-12-24 18:29:03'),(54,'查看详情',3,11,'','activity/detail','activity:detail',4,0,0,'2017-12-24 23:08:14'),(55,'一键生成菜单',3,14,'','product/product/generic','product:product:generic',4,0,0,'2017-12-30 22:24:55'),(56,'上架下架',3,14,'','product/product/upOrDown','product:product:upOrDown',5,0,0,'2018-01-13 16:40:35'),(58,'生成桌贴二维码',3,29,'','table/genericQrcode','table:genericQrcode',4,0,0,'2018-01-05 18:58:07'),(59,'推荐',3,15,'','productmenu/recommend','productmenu:recommend',1,0,0,'2018-01-13 19:40:06'),(60,'售罄',3,15,'','productmenu/sale','productmenu:sale',2,0,0,'2018-01-13 19:42:05');

/*Table structure for table `ordering_role` */

DROP TABLE IF EXISTS `ordering_role`;

CREATE TABLE `ordering_role` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(50) NOT NULL DEFAULT '' COMMENT '角色名称',
  `c_title` varchar(100) NOT NULL DEFAULT '' COMMENT '角色标题',
  `c_status` int(11) NOT NULL DEFAULT '0' COMMENT '角色状态（1启用 0停用）',
  `c_description` varchar(255) DEFAULT '' COMMENT '角色描述',
  `c_create_time` int(11) DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) DEFAULT '0' COMMENT '是否删除 0 未删除 1已删除',
  `c_modified_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '系统修改时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `ordering_role` */

insert  into `ordering_role`(`c_id`,`c_name`,`c_title`,`c_status`,`c_description`,`c_create_time`,`c_is_deleted`,`c_modified_time`) values (1,'supperadmin','超级管理员',1,'超级管理员',0,0,'2017-11-25 22:14:10'),(2,'merchant','商家管理员',1,'商家管理员',0,0,'2017-12-24 19:22:00');

/*Table structure for table `ordering_role_resource` */

DROP TABLE IF EXISTS `ordering_role_resource`;

CREATE TABLE `ordering_role_resource` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_role_id` int(11) NOT NULL DEFAULT '0' COMMENT '角色id',
  `c_resource_id` int(11) NOT NULL DEFAULT '0' COMMENT '资源id',
  `c_create_time` int(11) DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) DEFAULT '0' COMMENT '是否删除 0 未删除 1已删除',
  `c_modified_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '系统修改时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=408 DEFAULT CHARSET=utf8 COMMENT='角色-资源表';

/*Data for the table `ordering_role_resource` */

insert  into `ordering_role_resource`(`c_id`,`c_role_id`,`c_resource_id`,`c_create_time`,`c_is_deleted`,`c_modified_time`) values (310,1,16,1515843620,0,'2018-01-13 19:40:20'),(311,1,17,1515843620,0,'2018-01-13 19:40:20'),(312,1,18,1515843620,0,'2018-01-13 19:40:21'),(313,1,19,1515843620,0,'2018-01-13 19:40:21'),(314,1,2,1515843620,0,'2018-01-13 19:40:21'),(315,1,20,1515843620,0,'2018-01-13 19:40:21'),(316,1,21,1515843620,0,'2018-01-13 19:40:21'),(317,1,22,1515843620,0,'2018-01-13 19:40:21'),(318,1,23,1515843620,0,'2018-01-13 19:40:21'),(319,1,3,1515843620,0,'2018-01-13 19:40:21'),(320,1,24,1515843620,0,'2018-01-13 19:40:21'),(321,1,25,1515843620,0,'2018-01-13 19:40:21'),(322,1,26,1515843620,0,'2018-01-13 19:40:21'),(323,1,27,1515843620,0,'2018-01-13 19:40:21'),(324,1,4,1515843620,0,'2018-01-13 19:40:21'),(325,1,51,1515843620,0,'2018-01-13 19:40:21'),(326,1,52,1515843620,0,'2018-01-13 19:40:21'),(327,1,53,1515843620,0,'2018-01-13 19:40:21'),(328,1,6,1515843620,0,'2018-01-13 19:40:21'),(329,1,1,1515843620,0,'2018-01-13 19:40:21'),(330,1,42,1515843620,0,'2018-01-13 19:40:21'),(331,1,43,1515843620,0,'2018-01-13 19:40:21'),(332,1,44,1515843620,0,'2018-01-13 19:40:21'),(333,1,12,1515843620,0,'2018-01-13 19:40:21'),(334,1,45,1515843620,0,'2018-01-13 19:40:22'),(335,1,46,1515843620,0,'2018-01-13 19:40:22'),(336,1,47,1515843620,0,'2018-01-13 19:40:22'),(337,1,13,1515843620,0,'2018-01-13 19:40:22'),(338,1,48,1515843620,0,'2018-01-13 19:40:22'),(339,1,49,1515843620,0,'2018-01-13 19:40:22'),(340,1,50,1515843620,0,'2018-01-13 19:40:22'),(341,1,55,1515843620,0,'2018-01-13 19:40:22'),(342,1,56,1515843620,0,'2018-01-13 19:40:22'),(343,1,14,1515843620,0,'2018-01-13 19:40:22'),(344,1,5,1515843620,0,'2018-01-13 19:40:22'),(345,1,15,1515843620,0,'2018-01-13 19:40:22'),(346,1,7,1515843620,0,'2018-01-13 19:40:22'),(347,1,35,1515843620,0,'2018-01-13 19:40:22'),(348,1,36,1515843620,0,'2018-01-13 19:40:22'),(349,1,37,1515843620,0,'2018-01-13 19:40:22'),(350,1,58,1515843620,0,'2018-01-13 19:40:22'),(351,1,29,1515843620,0,'2018-01-13 19:40:22'),(352,1,8,1515843620,0,'2018-01-13 19:40:22'),(353,1,41,1515843620,0,'2018-01-13 19:40:22'),(354,1,10,1515843620,0,'2018-01-13 19:40:22'),(355,1,38,1515843620,0,'2018-01-13 19:40:22'),(356,1,39,1515843620,0,'2018-01-13 19:40:23'),(357,1,40,1515843620,0,'2018-01-13 19:40:23'),(358,1,54,1515843620,0,'2018-01-13 19:40:23'),(359,1,11,1515843620,0,'2018-01-13 19:40:23'),(360,1,31,1515843620,0,'2018-01-13 19:40:23'),(361,1,9,1515843620,0,'2018-01-13 19:40:23'),(362,1,32,1515843620,0,'2018-01-13 19:40:23'),(363,1,33,1515843620,0,'2018-01-13 19:40:23'),(364,1,34,1515843620,0,'2018-01-13 19:40:23'),(365,1,30,1515843620,0,'2018-01-13 19:40:23'),(366,1,28,1515843620,0,'2018-01-13 19:40:23'),(367,1,59,1515843620,0,'2018-01-13 19:40:23'),(368,1,60,1515843620,0,'2018-01-13 19:40:23'),(369,2,42,1515843639,0,'2018-01-13 19:40:39'),(370,2,43,1515843639,0,'2018-01-13 19:40:39'),(371,2,44,1515843639,0,'2018-01-13 19:40:40'),(372,2,12,1515843639,0,'2018-01-13 19:40:40'),(373,2,45,1515843639,0,'2018-01-13 19:40:40'),(374,2,46,1515843639,0,'2018-01-13 19:40:40'),(375,2,47,1515843639,0,'2018-01-13 19:40:40'),(376,2,13,1515843639,0,'2018-01-13 19:40:40'),(377,2,48,1515843639,0,'2018-01-13 19:40:40'),(378,2,49,1515843639,0,'2018-01-13 19:40:40'),(379,2,50,1515843639,0,'2018-01-13 19:40:40'),(380,2,55,1515843639,0,'2018-01-13 19:40:40'),(381,2,56,1515843639,0,'2018-01-13 19:40:40'),(382,2,14,1515843639,0,'2018-01-13 19:40:40'),(383,2,5,1515843639,0,'2018-01-13 19:40:40'),(384,2,35,1515843639,0,'2018-01-13 19:40:40'),(385,2,36,1515843639,0,'2018-01-13 19:40:40'),(386,2,37,1515843639,0,'2018-01-13 19:40:40'),(387,2,58,1515843639,0,'2018-01-13 19:40:40'),(388,2,29,1515843639,0,'2018-01-13 19:40:41'),(389,2,8,1515843639,0,'2018-01-13 19:40:41'),(390,2,41,1515843639,0,'2018-01-13 19:40:41'),(391,2,10,1515843639,0,'2018-01-13 19:40:41'),(392,2,38,1515843639,0,'2018-01-13 19:40:41'),(393,2,39,1515843639,0,'2018-01-13 19:40:41'),(394,2,40,1515843639,0,'2018-01-13 19:40:41'),(395,2,54,1515843639,0,'2018-01-13 19:40:41'),(396,2,11,1515843639,0,'2018-01-13 19:40:41'),(397,2,31,1515843639,0,'2018-01-13 19:40:41'),(398,2,9,1515843639,0,'2018-01-13 19:40:41'),(399,2,32,1515843639,0,'2018-01-13 19:40:41'),(400,2,33,1515843639,0,'2018-01-13 19:40:41'),(401,2,34,1515843639,0,'2018-01-13 19:40:41'),(402,2,30,1515843639,0,'2018-01-13 19:40:41'),(403,2,28,1515843639,0,'2018-01-13 19:40:41'),(404,2,7,1515843639,0,'2018-01-13 19:40:41'),(405,2,59,1515843639,0,'2018-01-13 19:40:42'),(406,2,60,1515843639,0,'2018-01-13 19:40:42'),(407,2,15,1515843639,0,'2018-01-13 19:40:42');

/*Table structure for table `ordering_store` */

DROP TABLE IF EXISTS `ordering_store`;

CREATE TABLE `ordering_store` (
  `c_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'c_id',
  `c_store_code` varchar(10) NOT NULL COMMENT '门店编码',
  `c_store_name` varchar(20) NOT NULL COMMENT '门店名称',
  `c_address` varchar(100) DEFAULT '' COMMENT '门店地址',
  `c_telphone` varchar(15) DEFAULT '' COMMENT '门店电话',
  `c_status` int(11) NOT NULL DEFAULT '0' COMMENT '门店状态(0 正常 1冻结)',
  `c_lat` varchar(10) DEFAULT '' COMMENT '横坐标',
  `c_lng` varchar(10) DEFAULT '' COMMENT '纵坐标',
  `c_province` int(11) DEFAULT '0' COMMENT '省',
  `c_city` int(11) DEFAULT '0' COMMENT '市',
  `c_county` int(11) DEFAULT '0' COMMENT '区域',
  `c_merchant_id` int(11) NOT NULL DEFAULT '0' COMMENT '商家id',
  `c_create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除(0否 1是)',
  `c_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='门店信息;';

/*Data for the table `ordering_store` */

insert  into `ordering_store`(`c_id`,`c_store_code`,`c_store_name`,`c_address`,`c_telphone`,`c_status`,`c_lat`,`c_lng`,`c_province`,`c_city`,`c_county`,`c_merchant_id`,`c_create_time`,`c_is_deleted`,`c_modify_time`) values (1,'QNCT001','青年餐厅朝阳门店','北京市东城区西水井胡同3号','18701240014',0,'','',0,0,0,1,1514123580,0,'2017-12-24 21:53:00');

/*Table structure for table `ordering_store_product_menu` */

DROP TABLE IF EXISTS `ordering_store_product_menu`;

CREATE TABLE `ordering_store_product_menu` (
  `c_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'c_id',
  `c_product_id` int(11) DEFAULT '0' COMMENT '商品id',
  `c_status` int(11) DEFAULT '0' COMMENT '商品状态（1售罄、0在售）',
  `c_store_id` int(11) DEFAULT '0' COMMENT '门店id',
  `c_merchant_id` int(11) NOT NULL DEFAULT '0' COMMENT '商家id',
  `c_star_index` int(11) DEFAULT '0' COMMENT '星级指数（1星、2星）',
  `c_create_time` int(11) DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) DEFAULT '0' COMMENT '是否删除',
  `c_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间，系统时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COMMENT='门店菜单表（门店与商品关系，选品）';

/*Data for the table `ordering_store_product_menu` */

insert  into `ordering_store_product_menu`(`c_id`,`c_product_id`,`c_status`,`c_store_id`,`c_merchant_id`,`c_star_index`,`c_create_time`,`c_is_deleted`,`c_modify_time`) values (62,4,0,0,1,5,1515854674,0,'2018-01-13 22:44:34'),(63,5,0,0,1,4,1515854674,0,'2018-01-13 22:44:34'),(64,6,0,0,1,5,1515854674,0,'2018-01-13 22:44:34'),(65,7,0,0,1,4,1515854674,0,'2018-01-13 22:44:34'),(66,8,0,0,1,5,1515854674,0,'2018-01-13 22:44:34'),(67,9,0,0,1,3,1515854674,0,'2018-01-13 22:44:34'),(68,10,0,0,1,3,1515854674,0,'2018-01-13 22:44:34'),(69,12,0,0,1,5,1515854674,0,'2018-01-13 22:44:34');

/*Table structure for table `ordering_table_info` */

DROP TABLE IF EXISTS `ordering_table_info`;

CREATE TABLE `ordering_table_info` (
  `c_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'c_id',
  `c_code` varchar(5) NOT NULL COMMENT '桌台编号(A区1号、A区2号)',
  `c_type` int(11) NOT NULL DEFAULT '0' COMMENT '桌台大小(1 大、 2 小)',
  `c_store_id` int(11) DEFAULT '0' COMMENT '门店id',
  `c_merchant_id` int(11) NOT NULL DEFAULT '0' COMMENT '商家id',
  `c_create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除(0否 1是)',
  `c_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`c_id`),
  KEY `index_unique_code` (`c_code`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='桌台表;';

/*Data for the table `ordering_table_info` */

insert  into `ordering_table_info`(`c_id`,`c_code`,`c_type`,`c_store_id`,`c_merchant_id`,`c_create_time`,`c_is_deleted`,`c_modify_time`) values (1,'A区1号',1,1,1,1514123614,0,'2017-12-24 21:53:34'),(2,'A区2号',1,1,1,1514123629,0,'2017-12-24 21:53:49'),(3,'A区3号',1,1,1,1514123639,0,'2017-12-24 21:53:59'),(4,'A区4号',2,1,1,1514123650,0,'2017-12-24 21:54:10'),(5,'A区5号',2,1,1,1514123659,0,'2017-12-24 21:54:19'),(6,'B区1号',1,1,1,1514123673,0,'2017-12-24 21:54:33'),(7,'B区2号',1,1,1,1514123682,0,'2017-12-24 21:54:42'),(8,'C区1号',1,1,1,1514123699,0,'2017-12-24 21:54:59'),(9,'C区2号',1,1,1,1514123712,0,'2017-12-24 21:55:12'),(10,'D区1号',1,1,1,1514123726,0,'2017-12-24 21:55:27'),(11,'D区2号',1,1,1,1514123739,0,'2017-12-24 21:55:39');

/*Table structure for table `ordering_user` */

DROP TABLE IF EXISTS `ordering_user`;

CREATE TABLE `ordering_user` (
  `c_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'c_id',
  `c_user_name` varchar(20) NOT NULL COMMENT '用户名',
  `c_password` varchar(50) NOT NULL COMMENT '密码(md5)',
  `c_type` int(11) NOT NULL DEFAULT '0' COMMENT '用户类型(1系统员工、2商家、3门店)',
  `c_parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父级用户id(如：系统员工下有多个商家、商家有多个门店)',
  `c_store_id` int(11) DEFAULT '0' COMMENT '所属门店id',
  `c_status` int(11) NOT NULL DEFAULT '0' COMMENT '用户状态(0停用、1启用)',
  `c_user_mode` int(11) DEFAULT '0' COMMENT '用户模式(1试用 2正式)',
  `c_try_start_time` int(11) DEFAULT '0' COMMENT '试用开始时间',
  `c_try_end_time` int(11) DEFAULT '0' COMMENT '试用结束时间',
  `c_merchant_id` int(11) DEFAULT '0' COMMENT '所属商家id',
  `c_create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除(0否，1是)',
  `c_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户账户表;';

/*Data for the table `ordering_user` */

insert  into `ordering_user`(`c_id`,`c_user_name`,`c_password`,`c_type`,`c_parent_id`,`c_store_id`,`c_status`,`c_user_mode`,`c_try_start_time`,`c_try_end_time`,`c_merchant_id`,`c_create_time`,`c_is_deleted`,`c_modify_time`) values (1,'admin','21232f297a57a5a743894a0e4a801fc3',1,0,0,1,2,0,0,1,1511677338,0,'2017-11-25 22:22:50'),(2,'lxl','21232f297a57a5a743894a0e4a801fc3',2,0,0,1,2,1511625600,1514217599,1,1511677988,0,'2017-11-26 14:16:17'),(3,'123456','e855b45052de9a85655f584589edd0f9',1,0,0,1,2,0,0,1,1522063784,0,'2018-03-26 19:29:44');

/*Table structure for table `ordering_user_role` */

DROP TABLE IF EXISTS `ordering_user_role`;

CREATE TABLE `ordering_user_role` (
  `c_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `c_user_id` int(11) NOT NULL DEFAULT '0' COMMENT '用户id',
  `c_role_id` int(11) NOT NULL DEFAULT '0' COMMENT '角色id',
  `c_create_time` int(11) DEFAULT '0' COMMENT '创建时间',
  `c_is_deleted` int(11) DEFAULT '0' COMMENT '是否删除 0 未删除 1已删除',
  `c_modified_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '系统修改时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户-角色表';

/*Data for the table `ordering_user_role` */

insert  into `ordering_user_role`(`c_id`,`c_user_id`,`c_role_id`,`c_create_time`,`c_is_deleted`,`c_modified_time`) values (1,1,1,1511684936,0,'2017-11-26 16:28:57'),(2,2,2,1514114548,0,'2017-12-24 19:22:28');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
