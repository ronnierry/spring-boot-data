```aidl
CREATE TABLE `ex_entrust` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `entrustNum` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '委托单号',
  `customerId` bigint(20) NOT NULL COMMENT '委托人',
  PRIMARY KEY (`id`),
  KEY `entrustNum_index` (`entrustNum`) USING BTREE,
  KEY `ex_entrust_id` (`id`) USING BTREE,
  KEY `ex_entrust_customerId` (`customerId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21498679 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='委托表（包括买方，卖方）,买方卖方多对多，即部分交易';


```