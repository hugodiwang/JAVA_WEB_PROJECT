CREATE TABLE `merchants` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'merchants name',
  `logo_url` varchar(256) COLLATE utf8_bin NOT NULL COMMENT 'merchants logo',
  `business_license_url` varchar(256) COLLATE utf8_bin NOT NULL COMMENT 'merchants license',
  `phone` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'merchants phone',
  `address` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'merchants address',
  `is_audit` BOOLEAN NOT NULL COMMENT 'autdit',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;