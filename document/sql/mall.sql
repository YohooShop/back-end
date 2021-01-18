/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost
 Source Database       : mall

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : utf-8

 Date: 01/18/2021 11:01:52 AM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `alipay_config`
-- ----------------------------
DROP TABLE IF EXISTS `alipay_config`;
CREATE TABLE `alipay_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_id` varchar(255) DEFAULT NULL COMMENT '应用ID',
  `charset` varchar(255) DEFAULT NULL COMMENT '编码',
  `format` varchar(255) DEFAULT NULL COMMENT '类型 固定格式json',
  `gateway_url` varchar(255) DEFAULT NULL COMMENT '网关地址',
  `notify_url` varchar(255) DEFAULT NULL COMMENT '异步回调',
  `private_key` text COMMENT '私钥',
  `public_key` text COMMENT '支付宝公钥',
  `return_url` varchar(255) DEFAULT NULL COMMENT '回调地址',
  `sign_type` varchar(255) DEFAULT NULL COMMENT '签名方式',
  `sys_service_provider_id` varchar(255) DEFAULT NULL COMMENT '商户号',
  `input_charset` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `alipay_config`
-- ----------------------------
BEGIN;
INSERT INTO `alipay_config` VALUES ('1', '2021001179601439', 'UTF-8', 'JSON', 'https://openapi.alipay.com/gateway.do', 'https://503c4224de1d.ngrok.io/alipay/getAsyncAliPayNotice.htm', '', 'https://3134004cbc49.ngrok.io/#/pages/money/paySuccess', 'RSA2', 'admin', 'utf-8');
COMMIT;

-- ----------------------------
--  Table structure for `aliyun_sms`
-- ----------------------------
DROP TABLE IF EXISTS `aliyun_sms`;
CREATE TABLE `aliyun_sms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `access_key_id` varchar(255) DEFAULT NULL,
  `access_secret` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `aliyun_sms_template`
-- ----------------------------
DROP TABLE IF EXISTS `aliyun_sms_template`;
CREATE TABLE `aliyun_sms_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '描述',
  `endpoint_name` varchar(255) NOT NULL,
  `key` int(11) NOT NULL COMMENT '1是验证码',
  `region_id` varchar(255) NOT NULL,
  `access_key_id` varchar(255) NOT NULL,
  `access_secret` varchar(255) NOT NULL,
  `sign_name` varchar(255) NOT NULL COMMENT '短信签名-可在短信控制台中找到',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT '1' COMMENT '0不可用，1可以用',
  `template_code` varchar(255) NOT NULL COMMENT '必填:短信模板',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `aliyun_sms_template`
-- ----------------------------
BEGIN;
INSERT INTO `aliyun_sms_template` VALUES ('3', '短信验证码', 'cn-hangzhou', '1', 'cn-hangzhou', '', '', 'yoooho臻选', '短信验证码', '2020-06-17 18:32:04', '1', 'SMS_181555632');
COMMIT;

-- ----------------------------
--  Table structure for `aliyunoss_config`
-- ----------------------------
DROP TABLE IF EXISTS `aliyunoss_config`;
CREATE TABLE `aliyunoss_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `endpoint` varchar(255) DEFAULT NULL COMMENT '外网Endpoint',
  `access_key_id` varchar(255) DEFAULT NULL COMMENT '访问身份验证中用到用户标识',
  `access_key_secre` varchar(255) DEFAULT NULL COMMENT '用户用于加密签名字符串和oss用来验证签名字符串的密钥',
  `bucket_name` varchar(255) DEFAULT NULL COMMENT 'oss的存储空间',
  `expire` varchar(255) DEFAULT NULL COMMENT '签名有效期(S)',
  `max_size` varchar(255) DEFAULT NULL COMMENT '上传文件大小(M)',
  `callback` varchar(255) DEFAULT NULL COMMENT '文件上传成功后的回调地址',
  `prefix` varchar(255) DEFAULT NULL COMMENT '上传文件夹路径前缀',
  `host` varchar(255) DEFAULT NULL COMMENT 'oss对外服务的访问域名',
  `zone` varchar(255) DEFAULT NULL COMMENT 'Region中文名称',
  `type` varchar(255) DEFAULT NULL COMMENT '空间类型：公开/私有 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `aliyunoss_config`
-- ----------------------------
BEGIN;
INSERT INTO `aliyunoss_config` VALUES ('1', 'oss-cn-beijing.aliyuncs.com', '', '', 'yoooho', '300', '10', '/aliyun/oss/callback', 'mall/images', '', '华东 2', '公开');
COMMIT;

-- ----------------------------
--  Table structure for `aliyunoss_content`
-- ----------------------------
DROP TABLE IF EXISTS `aliyunoss_content`;
CREATE TABLE `aliyunoss_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '文件名',
  `bucket` varchar(255) DEFAULT NULL COMMENT '空间名',
  `size` varchar(255) DEFAULT NULL COMMENT '大小',
  `url` varchar(255) DEFAULT NULL COMMENT '文件地址',
  `type` varchar(255) DEFAULT NULL COMMENT '空间类型：0公开/1私有 ',
  `suffix` varchar(255) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=584 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `aliyunoss_content`
-- ----------------------------
BEGIN;
INSERT INTO `aliyunoss_content` VALUES ('466', 'IMG_3786', 'yoooho', '16.00KB   ', 'mall/images/20191206/IMG_3786.PNG', '公开', 'PNG', '2020-05-16 11:36:22'), ('468', '0b39f94b0fe93bc83c05d7a461d2bb5b', 'yoooho', '28.62KB   ', 'mall/images/20191223/0b39f94b0fe93bc83c05d7a461d2bb5b.jpg', '公开', 'jpg', '2020-05-16 11:36:22'), ('469', '0fb6299b37b5b5d4d4d9e78e085e79ca', 'yoooho', '103.31KB   ', 'mall/images/20191223/0fb6299b37b5b5d4d4d9e78e085e79ca.jpg', '公开', 'jpg', '2020-05-16 11:36:23'), ('470', '2510c9d3280809b3cd767a439828d529', 'yoooho', '90.74KB   ', 'mall/images/20191223/2510c9d3280809b3cd767a439828d529.jpg', '公开', 'jpg', '2020-05-16 11:36:23'), ('471', '330859-1P1031K10568', 'yoooho', '209.90KB   ', 'mall/images/20191223/330859-1P1031K10568.jpg', '公开', 'jpg', '2020-05-16 11:36:23'), ('472', '596c2b82dc5fe47619f56dde29dc9f13', 'yoooho', '90.38KB   ', 'mall/images/20191223/596c2b82dc5fe47619f56dde29dc9f13.jpg', '公开', 'jpg', '2020-05-16 11:36:23'), ('473', '76e02e73ebca3800529d4e089f72f7e6', 'yoooho', '62.89KB   ', 'mall/images/20191223/76e02e73ebca3800529d4e089f72f7e6.jpg', '公开', 'jpg', '2020-05-16 11:36:23'), ('474', '8296b3035a04923270113ddf221bd03a', 'yoooho', '30.03KB   ', 'mall/images/20191223/8296b3035a04923270113ddf221bd03a.jpg', '公开', 'jpg', '2020-05-16 11:36:23'), ('475', '94575eb79cc569f0456a949fc29e5690', 'yoooho', '84.35KB   ', 'mall/images/20191223/94575eb79cc569f0456a949fc29e5690.jpg', '公开', 'jpg', '2020-05-16 11:36:24'), ('476', '9e4ec18d9a8246ec9640d7abf270385d', 'yoooho', '9.49KB   ', 'mall/images/20191223/9e4ec18d9a8246ec9640d7abf270385d.jpg', '公开', 'jpg', '2020-05-16 11:36:24'), ('477', 'MTAwMHgw', 'yoooho', '80.04KB   ', 'mall/images/20191223/MTAwMHgw.jpeg', '公开', 'jpeg', '2020-05-16 11:36:24'), ('478', 'a35a709ed7d11de1062f46e726215e3d', 'yoooho', '74.94KB   ', 'mall/images/20191223/a35a709ed7d11de1062f46e726215e3d.jpg', '公开', 'jpg', '2020-05-16 11:36:24'), ('479', 'ab95ed16fc2f4f253340459129815684', 'yoooho', '88.16KB   ', 'mall/images/20191223/ab95ed16fc2f4f253340459129815684.jpg', '公开', 'jpg', '2020-05-16 11:36:24'), ('480', 'b3bad028db9c00f6d8b9d4783358ddbe', 'yoooho', '66.49KB   ', 'mall/images/20191223/b3bad028db9c00f6d8b9d4783358ddbe.jpg', '公开', 'jpg', '2020-05-16 11:36:24'), ('481', 'ddf1cf242b988953c2cb6174d1972c70', 'yoooho', '38.31KB   ', 'mall/images/20191223/ddf1cf242b988953c2cb6174d1972c70.jpg', '公开', 'jpg', '2020-05-16 11:36:25'), ('482', 'f14b8fa157328de720f4512d96679dc3', 'yoooho', '19.08KB   ', 'mall/images/20191223/f14b8fa157328de720f4512d96679dc3.jpg', '公开', 'jpg', '2020-05-16 11:36:26'), ('483', 'f43912a522ccec4ae8a293de5374012e', 'yoooho', '24.41KB   ', 'mall/images/20191223/f43912a522ccec4ae8a293de5374012e.jpg', '公开', 'jpg', '2020-05-16 11:36:26'), ('484', 'IMG_3846', 'yoooho', '137.92KB   ', 'mall/images/20191224/IMG_3846.JPG', '公开', 'JPG', '2020-05-16 11:36:26'), ('485', 'IMG_3847', 'yoooho', '143.59KB   ', 'mall/images/20191224/IMG_3847.JPG', '公开', 'JPG', '2020-05-16 11:36:26'), ('486', 'IMG_3848', 'yoooho', '201.93KB   ', 'mall/images/20191224/IMG_3848.JPG', '公开', 'JPG', '2020-05-16 11:36:27'), ('487', 'IMG_3850', 'yoooho', '210.30KB   ', 'mall/images/20191224/IMG_3850.JPG', '公开', 'JPG', '2020-05-16 11:36:27'), ('488', 'IMG_3851', 'yoooho', '138.13KB   ', 'mall/images/20191224/IMG_3851.JPG', '公开', 'JPG', '2020-05-16 11:36:27'), ('489', 'IMG_3852', 'yoooho', '202.57KB   ', 'mall/images/20191224/IMG_3852.JPG', '公开', 'JPG', '2020-05-16 11:36:27'), ('490', 'IMG_3853', 'yoooho', '214.11KB   ', 'mall/images/20191224/IMG_3853.JPG', '公开', 'JPG', '2020-05-16 11:36:27'), ('491', 'IMG_3854', 'yoooho', '249.26KB   ', 'mall/images/20191224/IMG_3854.JPG', '公开', 'JPG', '2020-05-16 11:36:27'), ('492', 'IMG_3855', 'yoooho', '188.99KB   ', 'mall/images/20191224/IMG_3855.JPG', '公开', 'JPG', '2020-05-16 11:36:28'), ('493', 'IMG_3856', 'yoooho', '105.89KB   ', 'mall/images/20191224/IMG_3856.JPG', '公开', 'JPG', '2020-05-16 11:36:28'), ('494', 'IMG_3857', 'yoooho', '147.50KB   ', 'mall/images/20191224/IMG_3857.JPG', '公开', 'JPG', '2020-05-16 11:36:28'), ('495', 'IMG_3858', 'yoooho', '163.76KB   ', 'mall/images/20191224/IMG_3858.JPG', '公开', 'JPG', '2020-05-16 11:36:28'), ('496', 'IMG_3859', 'yoooho', '92.13KB   ', 'mall/images/20191224/IMG_3859.JPG', '公开', 'JPG', '2020-05-16 11:36:28'), ('497', 'IMG_3860', 'yoooho', '149.38KB   ', 'mall/images/20191224/IMG_3860.JPG', '公开', 'JPG', '2020-05-16 11:36:28'), ('498', 'IMG_3861', 'yoooho', '150.81KB   ', 'mall/images/20191224/IMG_3861.JPG', '公开', 'JPG', '2020-05-16 11:36:29'), ('499', 'IMG_3862', 'yoooho', '65.44KB   ', 'mall/images/20191224/IMG_3862.JPG', '公开', 'JPG', '2020-05-16 11:36:29'), ('500', 'IMG_3872', 'yoooho', '163.50KB   ', 'mall/images/20191224/IMG_3872.JPG', '公开', 'JPG', '2020-05-16 11:36:29'), ('501', 'IMG_3873', 'yoooho', '166.10KB   ', 'mall/images/20191224/IMG_3873.JPG', '公开', 'JPG', '2020-05-16 11:36:29'), ('502', 'IMG_3874', 'yoooho', '109.50KB   ', 'mall/images/20191224/IMG_3874.JPG', '公开', 'JPG', '2020-05-16 11:36:29'), ('503', 'IMG_3875', 'yoooho', '126.32KB   ', 'mall/images/20191224/IMG_3875.JPG', '公开', 'JPG', '2020-05-16 11:36:29'), ('504', 'IMG_3876', 'yoooho', '186.24KB   ', 'mall/images/20191224/IMG_3876.JPG', '公开', 'JPG', '2020-05-16 11:36:30'), ('505', 'IMG_3877', 'yoooho', '209.34KB   ', 'mall/images/20191224/IMG_3877.JPG', '公开', 'JPG', '2020-05-16 11:36:30'), ('506', 'IMG_3878', 'yoooho', '166.03KB   ', 'mall/images/20191224/IMG_3878.JPG', '公开', 'JPG', '2020-05-16 11:36:30'), ('507', 'IMG_3879', 'yoooho', '124.54KB   ', 'mall/images/20191224/IMG_3879.JPG', '公开', 'JPG', '2020-05-16 11:36:30'), ('508', 'IMG_3880', 'yoooho', '81.78KB   ', 'mall/images/20191224/IMG_3880.JPG', '公开', 'JPG', '2020-05-16 11:36:30'), ('509', 'IMG_3882', 'yoooho', '163.13KB   ', 'mall/images/20191224/IMG_3882.JPG', '公开', 'JPG', '2020-05-16 11:36:33'), ('510', 'IMG_3883', 'yoooho', '78.05KB   ', 'mall/images/20191224/IMG_3883.JPG', '公开', 'JPG', '2020-05-16 11:36:38'), ('511', '-fen-', 'yoooho', '32.04KB   ', 'mall/images/20191225/-fen-.png', '公开', 'png', '2020-05-16 11:36:38'), ('512', '0b39f94b0fe93bc83c05d7a461d2bb5b', 'yoooho', '28.62KB   ', 'mall/images/20191225/0b39f94b0fe93bc83c05d7a461d2bb5b.jpg', '公开', 'jpg', '2020-05-16 11:36:38'), ('513', '0fb6299b37b5b5d4d4d9e78e085e79ca', 'yoooho', '103.31KB   ', 'mall/images/20191225/0fb6299b37b5b5d4d4d9e78e085e79ca.jpg', '公开', 'jpg', '2020-05-16 11:36:38'), ('514', '2510c9d3280809b3cd767a439828d529', 'yoooho', '90.74KB   ', 'mall/images/20191225/2510c9d3280809b3cd767a439828d529.jpg', '公开', 'jpg', '2020-05-16 11:36:38'), ('515', '4659e9b01c9c035795a3a65ecb12447a', 'yoooho', '17.86KB   ', 'mall/images/20191225/4659e9b01c9c035795a3a65ecb12447a.jpg', '公开', 'jpg', '2020-05-16 11:36:38'), ('516', '596c2b82dc5fe47619f56dde29dc9f13', 'yoooho', '90.38KB   ', 'mall/images/20191225/596c2b82dc5fe47619f56dde29dc9f13.jpg', '公开', 'jpg', '2020-05-16 11:36:39'), ('517', '6b39b97eff18728f894e088ea27807e9', 'yoooho', '55.86KB   ', 'mall/images/20191225/6b39b97eff18728f894e088ea27807e9.jpeg', '公开', 'jpeg', '2020-05-16 11:36:39'), ('518', '765838caf11d3156567521a57db84127', 'yoooho', '46.29KB   ', 'mall/images/20191225/765838caf11d3156567521a57db84127.jpg', '公开', 'jpg', '2020-05-16 11:36:39'), ('519', '76e02e73ebca3800529d4e089f72f7e6', 'yoooho', '62.89KB   ', 'mall/images/20191225/76e02e73ebca3800529d4e089f72f7e6.jpg', '公开', 'jpg', '2020-05-16 11:36:39'), ('520', '8296b3035a04923270113ddf221bd03a', 'yoooho', '30.03KB   ', 'mall/images/20191225/8296b3035a04923270113ddf221bd03a.jpg', '公开', 'jpg', '2020-05-16 11:36:39'), ('521', '9e4ec18d9a8246ec9640d7abf270385d', 'yoooho', '171.23KB   ', 'mall/images/20191225/9e4ec18d9a8246ec9640d7abf270385d.jpg', '公开', 'jpg', '2020-05-16 11:36:39'), ('522', 'MTAwMHgw', 'yoooho', '80.04KB   ', 'mall/images/20191225/MTAwMHgw.jpeg', '公开', 'jpeg', '2020-05-16 11:36:40'), ('523', 'a35a709ed7d11de1062f46e726215e3d', 'yoooho', '74.94KB   ', 'mall/images/20191225/a35a709ed7d11de1062f46e726215e3d.jpg', '公开', 'jpg', '2020-05-16 11:36:40'), ('524', 'dianxin', 'yoooho', '19.09KB   ', 'mall/images/20191225/dianxin.png', '公开', 'png', '2020-05-16 11:36:40'), ('525', 'icon-test', 'yoooho', '14.44KB   ', 'mall/images/20191225/icon-test.png', '公开', 'png', '2020-05-16 11:36:40'), ('526', 'shouji', 'yoooho', '3.48KB   ', 'mall/images/20191225/shouji.png', '公开', 'png', '2020-05-16 11:36:40'), ('527', 'xingxing-2', 'yoooho', '21.50KB   ', 'mall/images/20191225/xingxing-2.png', '公开', 'png', '2020-05-16 11:36:41'), ('528', 'xiyiji', 'yoooho', '11.04KB   ', 'mall/images/20191225/xiyiji.png', '公开', 'png', '2020-05-16 11:36:41'), ('529', '8c42b3beabd071b06e9e88aef115d1f3', 'yoooho', '33.60KB   ', 'mall/images/20191226/8c42b3beabd071b06e9e88aef115d1f3.jpg', '公开', 'jpg', '2020-05-16 11:36:41'), ('530', '1717910c97e33316a625fd68a7fdde2e', 'yoooho', '703.78KB   ', 'mall/images/20191231/1717910c97e33316a625fd68a7fdde2e.png', '公开', 'png', '2020-05-16 11:36:41'), ('531', '2546f18c211eaca6c557353b5477c22c', 'yoooho', '130.71KB   ', 'mall/images/20191231/2546f18c211eaca6c557353b5477c22c.jpg', '公开', 'jpg', '2020-05-16 11:36:41'), ('532', '2e89edd68104574d6c75ae0cb9656c42', 'yoooho', '6.61KB   ', 'mall/images/20191231/2e89edd68104574d6c75ae0cb9656c42.jpg', '公开', 'jpg', '2020-05-16 11:36:41'), ('533', '309882ffaa3ccff54ac204fadd157c41', 'yoooho', '6.56KB   ', 'mall/images/20191231/309882ffaa3ccff54ac204fadd157c41.jpg', '公开', 'jpg', '2020-05-16 11:36:42'), ('534', '690aa6392ad3abc69631a9f6762bcf3a', 'yoooho', '16.73KB   ', 'mall/images/20191231/690aa6392ad3abc69631a9f6762bcf3a.jpg', '公开', 'jpg', '2020-05-16 11:36:42'), ('535', '6e7a5b6fd8d716fb4b626951cb6f5733', 'yoooho', '36.72KB   ', 'mall/images/20191231/6e7a5b6fd8d716fb4b626951cb6f5733.jpg', '公开', 'jpg', '2020-05-16 11:36:42'), ('536', '7c70fabfb74640149676adbd184c64ba', 'yoooho', '59.78KB   ', 'mall/images/20191231/7c70fabfb74640149676adbd184c64ba.jpg', '公开', 'jpg', '2020-05-16 11:36:42'), ('537', '816e1ab5763a718212a61328ba423939', 'yoooho', '23.87KB   ', 'mall/images/20191231/816e1ab5763a718212a61328ba423939.jpg', '公开', 'jpg', '2020-05-16 11:36:42'), ('538', '9a43ba535061c3e6b12227afa3628716', 'yoooho', '113.05KB   ', 'mall/images/20191231/9a43ba535061c3e6b12227afa3628716.jpg', '公开', 'jpg', '2020-05-16 11:36:43'), ('539', 'a8f3d8202d108541c91e5c61bb9519e1', 'yoooho', '54.67KB   ', 'mall/images/20191231/a8f3d8202d108541c91e5c61bb9519e1.jpg', '公开', 'jpg', '2020-05-16 11:36:43'), ('540', 'abe4aef9f70f67953a5df5c779a5ca0a', 'yoooho', '56.45KB   ', 'mall/images/20191231/abe4aef9f70f67953a5df5c779a5ca0a.jpg', '公开', 'jpg', '2020-05-16 11:36:43'), ('541', 'bba9380fecc39b84e44af3094f67e710', 'yoooho', '11.57KB   ', 'mall/images/20191231/bba9380fecc39b84e44af3094f67e710.jpg', '公开', 'jpg', '2020-05-16 11:36:44'), ('542', 'c4a249730b51d80490c42c6b87c41104', 'yoooho', '9.32KB   ', 'mall/images/20191231/c4a249730b51d80490c42c6b87c41104.jpg', '公开', 'jpg', '2020-05-16 11:36:44'), ('543', 'cate13', 'yoooho', '11.27KB   ', 'mall/images/20191231/cate13.jpg', '公开', 'jpg', '2020-05-16 11:36:45'), ('544', 'cate14', 'yoooho', '10.27KB   ', 'mall/images/20191231/cate14.jpg', '公开', 'jpg', '2020-05-16 11:36:45'), ('545', 'fb4c2650ba49a6d83a4d32ae38e93e95', 'yoooho', '6.30KB   ', 'mall/images/20191231/fb4c2650ba49a6d83a4d32ae38e93e95.jpg', '公开', 'jpg', '2020-05-16 11:36:45'), ('546', 'u=1378932079,2504369177&fm=26&gp=0', 'yoooho', '23.23KB   ', 'mall/images/20191231/u=1378932079,2504369177&fm=26&gp=0.jpg', '公开', 'jpg', '2020-05-16 11:36:45'), ('547', 'IMG_3912', 'yoooho', '253.62KB   ', 'mall/images/20200108/IMG_3912.JPG', '公开', 'JPG', '2020-05-16 11:36:45'), ('548', 'timg', 'yoooho', '45.24KB   ', 'mall/images/20200108/timg.jpeg', '公开', 'jpeg', '2020-05-16 11:36:46'), ('549', '1024x1024', 'yoooho', '71.56KB   ', 'mall/images/20200109/1024x1024.png', '公开', 'png', '2020-05-16 11:36:46'), ('550', 'u=2427097497,1425821937&fm=26&gp=0', 'yoooho', '47.39KB   ', 'mall/images/20200425/u=2427097497,1425821937&fm=26&gp=0.jpg', '公开', 'jpg', '2020-05-16 11:36:46'), ('551', 'u=2631688207,299249325&fm=26&gp=0', 'yoooho', '40.28KB   ', 'mall/images/20200425/u=2631688207,299249325&fm=26&gp=0.jpg', '公开', 'jpg', '2020-05-16 11:36:46'), ('552', '微信图片_20200425152316', 'yoooho', '205.36KB   ', 'mall/images/20200425/微信图片_20200425152316.jpg', '公开', 'jpg', '2020-05-16 11:36:46'), ('553', '微信图片_202004251523161', 'yoooho', '151.47KB   ', 'mall/images/20200425/微信图片_202004251523161.jpg', '公开', 'jpg', '2020-05-16 11:36:46'), ('554', '微信图片_2020042515231610', 'yoooho', '218.97KB   ', 'mall/images/20200425/微信图片_2020042515231610.jpg', '公开', 'jpg', '2020-05-16 11:36:47'), ('555', '微信图片_2020042515231611', 'yoooho', '230.40KB   ', 'mall/images/20200425/微信图片_2020042515231611.jpg', '公开', 'jpg', '2020-05-16 11:36:47'), ('556', '微信图片_2020042515231612', 'yoooho', '140.92KB   ', 'mall/images/20200425/微信图片_2020042515231612.jpg', '公开', 'jpg', '2020-05-16 11:36:47'), ('557', '微信图片_2020042515231613', 'yoooho', '165.74KB   ', 'mall/images/20200425/微信图片_2020042515231613.jpg', '公开', 'jpg', '2020-05-16 11:36:47'), ('558', '微信图片_2020042515231614', 'yoooho', '259.18KB   ', 'mall/images/20200425/微信图片_2020042515231614.jpg', '公开', 'jpg', '2020-05-16 11:36:47'), ('559', '微信图片_2020042515231615', 'yoooho', '167.73KB   ', 'mall/images/20200425/微信图片_2020042515231615.jpg', '公开', 'jpg', '2020-05-16 11:36:48'), ('560', '微信图片_202004251523162', 'yoooho', '128.99KB   ', 'mall/images/20200425/微信图片_202004251523162.jpg', '公开', 'jpg', '2020-05-16 11:36:48'), ('561', '微信图片_202004251523163', 'yoooho', '180.33KB   ', 'mall/images/20200425/微信图片_202004251523163.jpg', '公开', 'jpg', '2020-05-16 11:36:48'), ('562', '微信图片_202004251523164', 'yoooho', '185.27KB   ', 'mall/images/20200425/微信图片_202004251523164.jpg', '公开', 'jpg', '2020-05-16 11:36:48'), ('563', '微信图片_202004251523165', 'yoooho', '240.28KB   ', 'mall/images/20200425/微信图片_202004251523165.jpg', '公开', 'jpg', '2020-05-16 11:36:48'), ('564', '微信图片_202004251523166', 'yoooho', '185.58KB   ', 'mall/images/20200425/微信图片_202004251523166.jpg', '公开', 'jpg', '2020-05-16 12:11:12'), ('570', '微信图片_202004251523167', 'yoooho', '209.65KB   ', 'mall/images/20200425/微信图片_202004251523167.jpg', '公开', 'jpg', '2020-05-19 18:58:08'), ('571', 'normal video', 'yoooho', '3.10MB   ', 'mall/images/normal video.mp4', '公开', 'mp4', '2020-05-24 13:20:44'), ('572', 'tab-goodscenter-select', 'yoooho', '10.24KB   ', 'mall/images/tab-goodscenter-select.png', '公开', 'png', '2020-08-18 10:17:32'), ('573', 'miaosha-2', 'yoooho', '10.47KB   ', 'mall/images/miaosha-2.png', '公开', 'png', '2020-08-18 10:21:06'), ('574', 'shoucang4', 'yoooho', '10.43KB   ', 'mall/images/shoucang4.png', '公开', 'png', '2020-08-18 10:22:09'), ('575', 'tab-home-select', 'yoooho', '10.98KB   ', 'mall/images/tab-home-select.png', '公开', 'png', '2020-08-18 10:24:58'), ('576', 'tab-home-select', 'yoooho', '10.98KB   ', 'mall/images/tab-home-select.png', '公开', 'png', '2020-08-18 10:27:43'), ('577', 'tab-goodscenter-select', 'yoooho', '10.24KB   ', 'mall/images/tab-goodscenter-select.png', '公开', 'png', '2020-08-18 10:27:52'), ('578', 'tab-usercenter-select', 'yoooho', '8.55KB   ', 'mall/images/tab-usercenter-select.png', '公开', 'png', '2020-08-18 10:27:56'), ('579', 'tab-goodscenter-select', 'yoooho', '10.24KB   ', 'mall/images/tab-goodscenter-select.png', '公开', 'png', '2020-08-18 10:28:49'), ('580', '18103818-ef2a0ff8bb2204ac', 'yoooho', '27.30KB   ', 'mall/images/18103818-ef2a0ff8bb2204ac.png', '公开', 'png', '2020-09-08 15:54:32'), ('581', '18103818-ef2a0ff8bb2204ac-2', 'yoooho', '27.30KB   ', 'mall/images/18103818-ef2a0ff8bb2204ac-2.png', '公开', 'png', '2020-09-08 15:57:44'), ('582', '1975926-4a610a4d6dfc2b07-2', 'yoooho', '144.71KB   ', 'mall/images/1975926-4a610a4d6dfc2b07-2.jpg', '公开', 'jpg', '2020-09-08 15:57:49'), ('583', 'apiclient_cert', 'yoooho', '2.65KB   ', 'mall/images/apiclient_cert.p12', '公开', 'p12', '2020-10-16 11:31:01');
COMMIT;

-- ----------------------------
--  Table structure for `cms_help`
-- ----------------------------
DROP TABLE IF EXISTS `cms_help`;
CREATE TABLE `cms_help` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `show_status` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `read_count` int(11) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='帮助表';

-- ----------------------------
--  Table structure for `cms_help_category`
-- ----------------------------
DROP TABLE IF EXISTS `cms_help_category`;
CREATE TABLE `cms_help_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT '分类图标',
  `help_count` int(11) DEFAULT NULL COMMENT '专题数量',
  `show_status` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='帮助分类表';

-- ----------------------------
--  Table structure for `cms_member_report`
-- ----------------------------
DROP TABLE IF EXISTS `cms_member_report`;
CREATE TABLE `cms_member_report` (
  `id` bigint(20) DEFAULT NULL,
  `report_type` int(11) DEFAULT NULL COMMENT '举报类型：0->商品评价；1->话题内容；2->用户评论',
  `report_member_name` varchar(100) DEFAULT NULL COMMENT '举报人',
  `create_time` datetime DEFAULT NULL,
  `report_object` varchar(100) DEFAULT NULL,
  `report_status` int(11) DEFAULT NULL COMMENT '举报状态：0->未处理；1->已处理',
  `handle_status` int(11) DEFAULT NULL COMMENT '处理结果：0->无效；1->有效；2->恶意',
  `note` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户举报表';

-- ----------------------------
--  Table structure for `cms_prefrence_area`
-- ----------------------------
DROP TABLE IF EXISTS `cms_prefrence_area`;
CREATE TABLE `cms_prefrence_area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sub_title` varchar(255) DEFAULT NULL,
  `pic` varbinary(500) DEFAULT NULL COMMENT '展示图片',
  `sort` int(11) DEFAULT NULL,
  `show_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='优选专区';

-- ----------------------------
--  Records of `cms_prefrence_area`
-- ----------------------------
BEGIN;
INSERT INTO `cms_prefrence_area` VALUES ('1', '让音质更出众', '音质不打折 完美现场感', null, null, '1'), ('2', '让音质更出众22', '让音质更出众22', null, null, null), ('3', '让音质更出众33', null, null, null, null), ('4', '让音质更出众44', null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `cms_prefrence_area_product_relation`
-- ----------------------------
DROP TABLE IF EXISTS `cms_prefrence_area_product_relation`;
CREATE TABLE `cms_prefrence_area_product_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prefrence_area_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='优选专区和产品关系表';

-- ----------------------------
--  Records of `cms_prefrence_area_product_relation`
-- ----------------------------
BEGIN;
INSERT INTO `cms_prefrence_area_product_relation` VALUES ('1', '1', '12'), ('2', '1', '13'), ('3', '1', '14'), ('4', '1', '18'), ('5', '1', '7'), ('6', '2', '7'), ('7', '1', '22'), ('24', '1', '23');
COMMIT;

-- ----------------------------
--  Table structure for `cms_subject`
-- ----------------------------
DROP TABLE IF EXISTS `cms_subject`;
CREATE TABLE `cms_subject` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `pic` varchar(500) DEFAULT NULL COMMENT '专题主图',
  `product_count` int(11) DEFAULT NULL COMMENT '关联产品数量',
  `recommend_status` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `collect_count` int(11) DEFAULT NULL,
  `read_count` int(11) DEFAULT NULL,
  `comment_count` int(11) DEFAULT NULL,
  `album_pics` varchar(1000) DEFAULT NULL COMMENT '画册图片用逗号分割',
  `description` varchar(1000) DEFAULT NULL,
  `show_status` int(11) DEFAULT NULL COMMENT '显示状态：0->不显示；1->显示',
  `content` text,
  `forward_count` int(11) DEFAULT NULL COMMENT '转发数',
  `category_name` varchar(200) DEFAULT NULL COMMENT '专题分类名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='专题表';

-- ----------------------------
--  Records of `cms_subject`
-- ----------------------------
BEGIN;
INSERT INTO `cms_subject` VALUES ('1', '1', '轮廓分明，双摄手机映现细腻美照', 'https://img10.360buyimg.com/mobilecms/s1500x600_jfs/t26434/217/1381240043/254214/290f9d5b/5bc6c11cN54567a27.jpg!q70.jpg', null, '1', '2020-06-27 00:25:59', '100', '1000', '100', null, '手机对于拍照党来说，已经不仅仅是通讯工具那么简单了。因为有时TA还充当着“单反”的角色，来不断地带给那些喜欢拍照的人惊喜。所以，在这里准备一波高颜值的双摄手机来给大家。让TA们灵敏捕捉影像的能力，为你展现出轮廓更加分明、且画质更加细腻的美照。', '1', null, null, '精选专题'), ('2', '1', '交通拥挤有妙招，电动车小巧穿行无障碍', 'https://img11.360buyimg.com/mobilecms/s1500x600_jfs/t14224/229/529700229/74868/a1cc7364/5a314f85N5bfd22c7.jpg!q70.jpg', null, '1', '2018-11-12 13:27:00', '100', '1000', '100', null, '随着人们消费水平的提高，公路上的小车是越来越多了，导致每到上下班高峰期的时候，大路的车辆堵了一环又一环，而且你根本不知道它到底会塞多久，所以我们需要变通一下，不妨骑上电动车来个绿色出行，它够小巧玲珑，即使交通再怎么拥挤，也总有它可以通过的地方。', '1', null, null, '精选专题'), ('3', '1', '无酒不成席，甘香白酒开怀助兴', 'https://img12.360buyimg.com/mobilecms/s1500x600_jfs/t1/881/4/12265/114011/5bd1446fEc71114bf/68925bfb4a2adc44.jpg!q70.jpg', null, '1', '2018-11-13 13:27:05', '100', '1000', '100', null, '白酒是由各种优质的高粱，小麦，大米等谷物为原料，经过传统工艺的长时间酿造，酒液在这样的环境中慢慢发酵，最终变成清香浓郁的白酒，被摆上人们的餐桌，供人畅饮，是一种受到大众喜爱的绝佳饮品。', '1', null, null, '精选专题'), ('4', '2', '真规划不盲扫，全域清洁净无尘', 'https://img10.360buyimg.com/mobilecms/s1500x600_jfs/t15205/35/2539924281/429185/72fa7857/5aab2c4bN6a32a6c5.png', null, '1', '2018-11-01 13:27:09', '100', '1000', '100', null, '科技时代，聪明女人会选择用智慧来减负，和繁琐的家务挥手再见，才能腾出更多休闲时间。规划式扫地机器人设计个性化，它能够跟据房间布置呈现清扫路线，实现规划式覆盖性清洁，少遗漏不盲扫，从而大幅度降低损耗，侦测技术遇到家具及时避让，杜绝猛烈撞击，任它灵巧穿梭于低矮空间，坐享居家净无尘。', '1', null, null, '家电专题'), ('5', '2', '抑菌更纯净，直饮净水保家人健康', 'https://img11.360buyimg.com/mobilecms/s1500x600_jfs/t11428/340/1504074828/20474/1e8cab1e/5a0305d3Nb1e7a762.jpg!q70.jpg', null, '1', '2018-11-06 13:27:18', '100', '1000', '100', null, '在城里居住，首先要担心的是饮水问题。桶装水太贵不够经济，还不一定是干净的。自己去干净的水源地取水也不切实际。此时只有选择在家里安装一台净水器才实在。装上一台直饮式的净水器，方便安全，关键是水质过滤得比较纯净，很大限度地处理了大部分的废弃物，留下健康的矿物质水。好生活，从一口干净的纯净水开始。', '1', null, null, '家电专题'), ('6', '2', '储鲜冷冻灵活变，多门无霜更贴心', 'https://img12.360buyimg.com/mobilecms/s1500x600_jfs/t13015/356/2397552584/605232/46c88e6e/5a5321bcN6a8866f0.png', null, '1', '2018-11-07 13:27:21', '100', '1000', '100', null, '春节临近，每个家庭都要储备不少食材，但各种食材的保鲜方式与温度不尽相同，而多门风冷冰箱能轻松满足您。它们容积大占地小，拥有多个可以独立调节温度的温区，满足对不同类食材的存放需求，同时省去除霜烦恼，还可以通过温度调节满足您对大冷藏及大冷冻的需求变化，从而带来更好的保鲜冷冻体验，为新年宴请保驾护航。', '1', null, null, '家电专题'), ('7', '2', '想喝健康水，就用304不锈钢热水壶', 'https://img13.360buyimg.com/mobilecms/s1500x600_jfs/t12541/90/443985343/33603/65d6e884/5a0bb77aNff08550a.jpg!q70.jpg', null, '1', '2019-01-29 11:21:55', '100', '1000', '100', null, '大冬天的喝一口热水，不仅能够暧身还可以给身体补充足够的水份，但是对于热水壶的购买却是需要慎之又慎，材质不好的热水壶在烧水的过程当中极容易产生对身体不利的有害物，极大影响人们的身体健康。304不锈钢热水壶选用食品级不不锈钢，确保水质安全，烧水健康好水，为您的饮水健康保驾护航。', '1', null, null, '家电专题'), ('8', '2', '你尽情赖床！早餐“煲”在它身上', 'https://img14.360buyimg.com/mobilecms/s1500x600_jfs/t15949/363/1450937723/89513/7d8c1219/5a531d28N2aaec2a6.jpg!q70.jpg', null, '1', '2019-01-29 13:07:13', '100', '1000', '100', null, '赖床不想起，饿了的时候想吃饭又要现做等待简直饥肠辘辘让人心烦，所以一款带有预约功能的电饭煲简直不要太贴心，你睡懒觉的时候它已经给你做好了香滑软糯的粥，起床就能享美味是不是很贴心呐。', '1', null, null, '家电专题'), ('9', '2', '小白变大厨，微波炉为实力加持', 'https://img10.360buyimg.com/mobilecms/s1500x600_jfs/t1/8774/21/11460/38908/5c2cbfcfEdab1ef03/d5800f0f7cf05b38.jpg!q70.jpg', null, '1', '2019-01-29 13:08:18', '100', '1000', '100', null, '对于厨艺小白而言，没有什么能比掌握好火候更来得困难的了！毕竟烹饪出食物的味道好坏，很大程度上还是对火候的掌控，想要轻松掌握火候，当然少不了一款微波炉的撑场，内设多功能，满足不同的烹饪需求，简单方便易操作，让厨艺小白秒变大师！', '1', null, null, '家电专题'), ('10', '2', '十秒鲜榨，冬日把爱浓缩成杯果汁', 'https://img11.360buyimg.com/mobilecms/s1500x600_jfs/t13708/126/308291722/542847/26ee6edd/5a07dc72N3252a9e0.png', null, '1', '2019-01-29 13:10:02', '100', '1000', '100', null, '寒瑟冬日女友不喜欢吃水果，用便携迷你果汁机，撩妹又养胃。一按一转，碾压切割，简单快速制作，压榨出纯原味果汁。一键启动，十秒出汁，保留食物营养，轻轻松松粉碎食物，营养在手，说走就走。', '1', null, null, '家电专题'), ('11', '3', '饭点未到肚已空？美味饼干先充饥', 'https://img10.360buyimg.com/mobilecms/s1500x600_jfs/t13240/79/443357432/38567/94792c4c/5a0ba054N89388654.jpg!q70.jpg', null, '1', '2019-01-29 13:10:45', '100', '1000', '100', null, '一上午都把精力集中在工作中，刚闲下来就发现自己已是饥肠辘辘了，可饭点却还没到，怎么办呢？不妨让这些美味饼干先帮你充充饥吧！酥香松脆有营养，每一口都让人回味无穷，既能满足你挑剔的味蕾又能起到果腹效果，快快为自己备上吧！', '1', null, null, '美食专题'), ('12', '3', '赖床无罪，香酥面包营养又便捷', 'https://img11.360buyimg.com/mobilecms/s1500x600_jfs/t9775/33/1197239610/38547/34899011/59ddbd01N0bd693bb.jpg!q70.jpg', null, '1', '2019-01-29 13:11:41', '100', '1000', '100', null, '赖床是很多年轻人的通病，特别是秋冬季节，都会恋恋不舍温暖的被窝。对于苦逼的上班族来说，就算再多睡几分钟，还是要起床的，甚至来不及吃早餐。面包营养丰富，能快速饱腹，且携带方便，再搭配一盒牛奶，一顿简单而不失营养的早餐能提供一天的能量，让赖床族多睡几分钟也无妨。', '1', null, null, '美食专题'), ('13', '3', '夹心饼干，予多重滋味交织舌尖', 'https://img12.360buyimg.com/mobilecms/s1500x600_jfs/t18877/139/652452758/27262/36e6ed6e/5a9d5b6dN327150e8.jpg!q70.jpg', null, '1', '2019-01-29 13:12:38', '100', '1000', '100', null, '饼干味道香脆可口，深受不少人的青睐。饼干的种类多样，而夹心饼干就是其中一种，相比普通饼干而言，夹心饼干有着更丰富的口感，当肚子空空如也的时候，来一些美味的夹心饼干，既能解馋，又能扛饿。下面就为大家推荐一组好吃的夹心饼干，作为办公室小零食非常不错。', '1', null, null, '美食专题'), ('14', '4', '户外Party，便携音箱烘气氛', 'https://img10.360buyimg.com/mobilecms/s1500x600_jfs/t17125/265/644948348/42066/6f2dc610/5a9c9da1N9a95ee2c.jpg!q70.jpg', null, '1', '2019-01-29 13:13:53', '100', '1000', '100', null, '初春的季节，除了户外的各种踏青旅行，在户外开异常Party也是很惬意。户外派对，气氛的烘托肯定不能离开音箱的衬托，选择一款户外的便携音箱，无线蓝牙连接，免去有线的束缚，携带使用更方便。', '1', null, null, '数码专题'), ('15', '5', '今冬潮包look，凹出绚丽女王范', 'https://img10.360buyimg.com/mobilecms/s1500x600_jfs/t8365/191/1901440450/575969/c71560c9/59c3144dNe6d8dd2f.png', null, '1', '2019-01-29 13:15:12', '100', '1000', '100', null, '潮流时尚的美包，搭配潮服，会让你魅力一直在线。因为潮包一直是女性出游扮美的秘籍，它不仅能够帮你收纳日常小物件，还能让你解放双手，这里推荐的时尚美包，随意搭配一件服饰，都可以让你潮范十足，凹出绚丽女王范。', '1', null, null, '服饰专题'), ('16', '1', '轮廓分明，双摄手机映现细腻美照', 'https://img10.360buyimg.com/mobilecms/s1500x600_jfs/t26434/217/1381240043/254214/290f9d5b/5bc6c11cN54567a27.jpg!q70.jpg', null, '1', '2020-06-27 00:26:30', '100', '1000', '100', 'https://yoooho.bkbedu.com/mall/images/20191225/4659e9b01c9c035795a3a65ecb12447a.jpg,https://yoooho.bkbedu.com/mall/images/20191225/596c2b82dc5fe47619f56dde29dc9f13.jpg', '手机对于拍照党来说，已经不仅仅是通讯工具那么简单了。因为有时TA还充当着“单反”的角色，来不断地带给那些喜欢拍照的人惊喜。所以，在这里准备一波高颜值的双摄手机来给大家。让TA们灵敏捕捉影像的能力，为你展现出轮廓更加分明、且画质更加细腻的美照。', '1', '香蕉-吃香蕉能帮助内心软弱、多愁善感的人驱散悲观、烦躁的情绪，保持平和、快乐的心情。这主要是因为它能增加大脑中使人愉悦的5—羟色胺物质的含量。抑郁症患者脑中5—羟色胺的含量就比常人要少。在创意文化水果里，香蕉是“开心起来”，具有传递快乐的文化营养。\n猕猴桃-含有蛋白质、脂肪、糖、钙、磷、铁、镁、钠、钾及硫等，还含有胡萝卜素。另外还具有药用价值，适用于消化不良、食欲不振、呕吐及维生素缺乏等症。但性寒，易伤脾阳而引起腹泻，故不宜多食。脾胃虚寒者应慎食。先兆性流产、月经过多和尿频者忌食。\n猕猴桃-有生津、益智、促气养颜作用，常吃补脾益肝悦颜，生血、养心神，常食荔枝可使人百色红润，身体健康。\n榴莲-含有丰富的蛋白质和脂类，对机体有很好的补养作用，是良好的果品类营养来源。榴莲有特殊的气味，不同的人感受不同，有的人认为其臭如猫屎，有的人认为香气馥郁。榴莲的这种气味有开胃、促进食欲之功效，其中的膳食纤维还能促进肠蠕动。', null, '精选专题');
COMMIT;

-- ----------------------------
--  Table structure for `cms_subject_category`
-- ----------------------------
DROP TABLE IF EXISTS `cms_subject_category`;
CREATE TABLE `cms_subject_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT '分类图标',
  `subject_count` int(11) DEFAULT NULL COMMENT '专题数量',
  `show_status` int(11) DEFAULT '0',
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='专题分类表';

-- ----------------------------
--  Records of `cms_subject_category`
-- ----------------------------
BEGIN;
INSERT INTO `cms_subject_category` VALUES ('1', '精选专题', 'https://yoooho.bkbedu.com/mall/images/20191225/xingxing-2.png', '3', '1', '102'), ('2', '家电专题', 'https://yoooho.bkbedu.com/mall/images/20191225/xiyiji.png', '7', '1', '0'), ('3', '美食专题', 'https://yoooho.bkbedu.com/mall/images/20191225/dianxin.png', '3', '1', '0'), ('4', '数码专题', 'https://yoooho.bkbedu.com/mall/images/20191225/shouji.png', '1', '1', '0'), ('5', '服饰专题', 'https://yoooho.bkbedu.com/mall/images/20191225/icon-test.png', '1', '1', '0'), ('6', '臻选水果', 'https://yoooho.bkbedu.com/mall/images/20191225/-fen-.png', null, '1', '0');
COMMIT;

-- ----------------------------
--  Table structure for `cms_subject_comment`
-- ----------------------------
DROP TABLE IF EXISTS `cms_subject_comment`;
CREATE TABLE `cms_subject_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subject_id` bigint(20) DEFAULT NULL,
  `member_nick_name` varchar(255) DEFAULT NULL,
  `member_icon` varchar(255) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `show_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='专题评论表';

-- ----------------------------
--  Table structure for `cms_subject_product_relation`
-- ----------------------------
DROP TABLE IF EXISTS `cms_subject_product_relation`;
CREATE TABLE `cms_subject_product_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subject_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='专题商品关系表';

-- ----------------------------
--  Records of `cms_subject_product_relation`
-- ----------------------------
BEGIN;
INSERT INTO `cms_subject_product_relation` VALUES ('3', '1', '28'), ('4', '1', '29'), ('5', '2', '30'), ('6', '2', '31'), ('7', '2', '35'), ('29', '2', '36'), ('30', '2', '32'), ('31', '3', '33'), ('38', '3', '34'), ('39', '1', '27'), ('44', '16', '37'), ('45', '16', '38'), ('55', '16', '40'), ('57', '1', '26');
COMMIT;

-- ----------------------------
--  Table structure for `cms_topic`
-- ----------------------------
DROP TABLE IF EXISTS `cms_topic`;
CREATE TABLE `cms_topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `attend_count` int(11) DEFAULT NULL COMMENT '参与人数',
  `attention_count` int(11) DEFAULT NULL COMMENT '关注人数',
  `read_count` int(11) DEFAULT NULL,
  `award_name` varchar(100) DEFAULT NULL COMMENT '奖品名称',
  `attend_type` varchar(100) DEFAULT NULL COMMENT '参与方式',
  `content` text COMMENT '话题内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='话题表';

-- ----------------------------
--  Table structure for `cms_topic_category`
-- ----------------------------
DROP TABLE IF EXISTS `cms_topic_category`;
CREATE TABLE `cms_topic_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT '分类图标',
  `subject_count` int(11) DEFAULT NULL COMMENT '专题数量',
  `show_status` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='话题分类表';

-- ----------------------------
--  Table structure for `cms_topic_comment`
-- ----------------------------
DROP TABLE IF EXISTS `cms_topic_comment`;
CREATE TABLE `cms_topic_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_nick_name` varchar(255) DEFAULT NULL,
  `topic_id` bigint(20) DEFAULT NULL,
  `member_icon` varchar(255) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `show_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='专题评论表';

-- ----------------------------
--  Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '名称',
  `pid` bigint(20) DEFAULT NULL COMMENT '上级部门',
  `enabled` bit(1) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门表';

-- ----------------------------
--  Records of `dept`
-- ----------------------------
BEGIN;
INSERT INTO `dept` VALUES ('1', 'mall', '0', b'1', '2020-05-17 10:46:34'), ('2', '大连晓阳网络科技有限公司', '1', b'1', '2020-05-17 10:58:31'), ('3', '研发部门', '2', b'1', '2020-05-17 10:58:47'), ('4', '销售部门', '2', b'1', '2020-05-17 10:59:05'), ('5', '大前端', '3', b'1', '2020-05-17 10:59:52'), ('6', 'UI设计师', '3', b'1', '2020-05-17 11:00:10'), ('7', '微服务', '3', b'1', '2020-05-17 11:00:54'), ('8', '数据科学', '3', b'1', '2020-05-17 11:01:09'), ('10', '产品组', '3', b'1', '2020-05-17 11:02:15'), ('11', '售前部门', '4', b'1', '2020-05-17 11:02:39'), ('12', '售后部门', '4', b'1', '2020-05-17 11:03:04'), ('13', '市场部门', '4', b'1', '2020-05-17 11:03:37');
COMMIT;

-- ----------------------------
--  Table structure for `dict`
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '字典名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `dict_detail`
-- ----------------------------
DROP TABLE IF EXISTS `dict_detail`;
CREATE TABLE `dict_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) DEFAULT NULL COMMENT '字典标签',
  `value` varchar(255) DEFAULT NULL COMMENT '字典值',
  `sort` varchar(255) DEFAULT NULL COMMENT '排序',
  `dict_id` bigint(20) DEFAULT NULL COMMENT '字典id',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `email_config`
-- ----------------------------
DROP TABLE IF EXISTS `email_config`;
CREATE TABLE `email_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `from_user` varchar(255) DEFAULT NULL COMMENT '收件人',
  `host` varchar(255) DEFAULT NULL COMMENT '邮件服务器SMTP地址',
  `pass` varchar(255) DEFAULT NULL COMMENT '密码',
  `port` varchar(255) DEFAULT NULL COMMENT '端口',
  `user` varchar(255) DEFAULT NULL COMMENT '发件者用户名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='邮箱配置表';

-- ----------------------------
--  Records of `email_config`
-- ----------------------------
BEGIN;
INSERT INTO `email_config` VALUES ('1', 'service@bkbedu.com', 'smtp.exmail.qq.com', 'PbJBRuQGMgmzGCZW', '465', 'service@bkbedu.com');
COMMIT;

-- ----------------------------
--  Table structure for `kdn_express_company`
-- ----------------------------
DROP TABLE IF EXISTS `kdn_express_company`;
CREATE TABLE `kdn_express_company` (
  `id` int(10) unsigned NOT NULL,
  `company_name` varchar(11) DEFAULT NULL,
  `company_code` varchar(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `is_show` tinyint(1) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `kdn_express_company`
-- ----------------------------
BEGIN;
INSERT INTO `kdn_express_company` VALUES ('1', '顺丰速运', 'SF', '1', null, null, null), ('2', '百世快递', 'HTKY', '2', null, null, null), ('3', '中通快递', 'ZTO', '3', null, null, null), ('4', '申通快递', 'STO', '3', null, null, null), ('5', '圆通速递', 'YTO', '4', null, null, null), ('6', '韵达速递', 'YD', '5', null, null, null), ('7', '邮政快递包裹', 'YZPY', '6', null, null, null), ('8', 'EMS', 'EMS', '7', null, null, null), ('9', '天天快递', 'HHTT', '8', null, null, null), ('10', '京东快递', 'JD', '9', null, null, null), ('11', '优速快递', 'UC', '10', null, null, null), ('12', '德邦快递', 'DBL', '11', null, null, null), ('13', '宅急送', 'ZJS', '12', null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `land_pages`
-- ----------------------------
DROP TABLE IF EXISTS `land_pages`;
CREATE TABLE `land_pages` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url_key` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `need_expire` tinyint(1) DEFAULT '0',
  `expire_date` datetime DEFAULT NULL,
  `components` json NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `extra` json NOT NULL,
  `delete_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0未删除，1已删除',
  `show_status` tinyint(1) DEFAULT '0' COMMENT '0未显示，1已显示',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='落地表';

-- ----------------------------
--  Records of `land_pages`
-- ----------------------------
BEGIN;
INSERT INTO `land_pages` VALUES ('1', 'test', '11', '11', null, '1', '2020-06-24 12:54:56', '[{\"id\": \"mkft69pqujo\", \"name\": \"图片\", \"type\": \"Picture\", \"imageUrl\": \"http://localhost:8091/file/pic/微信图片_202004251525551-20200622111842389.jpg\"}]', '2020-06-22 11:19:54', '2020-06-22 13:01:39', '{\"needShare\": false, \"shareText\": \"\", \"shareImage\": \"\", \"needBackTop\": false, \"backTopImage\": \"\", \"backgroundColor\": \"\"}', '1', null), ('2', 'trst', 'ddf', 'fff', null, '0', null, '[{\"id\": \"r0dtmcqt4ig\", \"name\": \"图片\", \"type\": \"Picture\", \"imageUrl\": \"http://localhost:8091/file/pic/微信图片_202004251525551-20200622011838400.jpg\"}, {\"id\": \"migbaq3vmr\", \"name\": \"视频\", \"type\": \"Video\", \"imageUrl\": \"http://localhost:8091/file/pic/qwe-2020062203410253.jpg\", \"isSwitch\": true, \"videoLink\": \"http://localhost:8091/file/vedio/normal video-2020062203405663.mp4\"}]', '2020-06-22 13:21:08', '2020-06-22 16:36:10', '{\"needShare\": true, \"shareText\": \"sdfdgdf\", \"shareImage\": \"http://localhost:8091/file/pic/微信图片_202004251525552-202006220435515.jpg\", \"needBackTop\": true, \"backTopImage\": \"http://localhost:8091/file/pic/微信图片_202004251525552-20200622043556487.jpg\", \"backgroundColor\": \"rgba(255, 0, 0, 0.64)\"}', '1', '1'), ('3', '2', '落地首页', '落地首页', null, '0', null, '[{\"id\": \"0akibjihmro\", \"name\": \"搜索控件\", \"type\": \"IndexSearch\", \"searchPlace\": \"\"}, {\"id\": \"phnr3smcrb\", \"name\": \"轮播图\", \"type\": \"IndexBanner\", \"bannerData\": [{\"link\": \"\", \"color\": \"252,140,68\", \"imageUrl\": \"http://192.168.1.18:8091/file/pic/tuwen-20200724041603263.png\", \"linkType\": \"page\"}, {\"link\": \"\", \"color\": \"250,238,215\", \"imageUrl\": \"http://192.168.1.18:8091/file/pic/u=1558734614,2571467604&fm=26&gp=0-20200724033905799.jpg\", \"linkType\": \"page\"}], \"disableDrag\": false}, {\"id\": \"ugo5mfefjk8\", \"name\": \"购物券\", \"type\": \"IndexCoupon\", \"couponData\": [{\"type\": \"cash\", \"title\": \"商品优惠券\", \"value\": 20}, {\"id\": 22, \"link\": \"\", \"type\": \"cash\", \"title\": \"满99减5优惠券\", \"value\": 5}], \"disableDrag\": false}, {\"id\": \"1hd7vuksiso\", \"name\": \"快捷导航\", \"type\": \"IndexNav\", \"navData\": [{\"link\": \"dad\", \"name\": \"活动秒杀2\", \"imageUrl\": \"http://192.168.0.108:8091/file/pic/秒杀-20200706100746290.png\", \"linkType\": \"page\", \"needLogin\": \"true\"}, {\"link\": \"asdasd\", \"name\": \"活动秒杀1\", \"imageUrl\": \"http://192.168.0.108:8091/file/pic/秒杀-20200706100801450.png\", \"linkType\": \"h5\", \"needLogin\": \"true\"}, {\"link\": \"dasdasd\", \"name\": \"活动秒杀4\", \"imageUrl\": \"http://192.168.0.108:8091/file/pic/秒杀-20200706100807762.png\", \"linkType\": \"page\", \"needLogin\": \"false\"}, {\"link\": \"utyyt\", \"name\": \"活动秒杀3\", \"imageUrl\": \"http://192.168.0.108:8091/file/pic/秒杀-20200706100813273.png\", \"linkType\": \"page\", \"needLogin\": \"false\"}], \"disableDrag\": false}, {\"id\": \"g7e8punuv\", \"name\": \"图片魔方\", \"type\": \"IndexCube\", \"cubeData\": {\"mode\": 2, \"showType\": \"2_3\", \"cubeTitle\": \"\", \"cubeImages\": [{\"link\": \"\", \"imageUrl\": \"http://192.168.0.108:8091/file/pic/u=2802746215,1434233027&fm=26&gp=0-20200706101349100.jpg\", \"linkType\": \"page\"}, {\"link\": \"\", \"imageUrl\": \"http://192.168.0.108:8091/file/pic/u=2023634314,1823197544&fm=26&gp=0-20200706101525299.jpg\", \"linkType\": \"page\"}]}}, {\"id\": \"bvj97j6htno\", \"name\": \"团购\", \"type\": \"IndexGroupon\", \"disableDrag\": false, \"grouponData\": {\"type\": 1, \"title\": \"超值拼团\", \"moreLink\": \"1111\", \"showMore\": true, \"goodsList\": [{\"id\": 1, \"pic\": \"https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525553.jpg\", \"name\": \"当季孕妇水果现摘大连车厘子2斤拼团\", \"sale\": 10, \"sort\": \"1\", \"price\": 0.1, \"stock\": 100, \"browse\": 0, \"isShow\": true, \"people\": 2, \"addTime\": \"1592992113\", \"endTime\": 1593446400, \"postage\": 0, \"unitName\": \"斤\", \"albumPics\": \"https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525552.jpg,https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525551.jpg,https://yoooho.bkbedu.com/mall/images/20200425/微信图片_20200425152555.jpg\", \"giftPoint\": 10, \"hotStatus\": true, \"lockStock\": 0, \"productId\": 40, \"startTime\": 1592928000, \"detailHtml\": \"<p><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_20200425152316.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523161.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523162.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523163.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523164.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_20200425153015.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523165.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523166.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523167.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523168.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523169.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231610.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231611.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231615.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231612.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231613.jpg\\\" /></p>\", \"description\": \"新鲜车厘子大果\", \"endTimeDate\": 1593446400000, \"deleteStatus\": false, \"originalPrice\": 158, \"postageStatus\": true, \"startTimeDate\": 1592928000000, \"detailMobileHtml\": \"\"}]}}, {\"id\": \"3ohn28df0rg\", \"name\": \"秒杀\", \"type\": \"IndexSeckill\", \"disableDrag\": false, \"seckillData\": {\"type\": 2, \"title\": \"热门秒杀\", \"moreLink\": \"/pages/seckill/seckill\", \"showMore\": true, \"goodsList\": [{\"id\": 1, \"num\": 1, \"pic\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg\", \"name\": \"华为 HUAWEI P20 \", \"sale\": 11, \"sort\": 2, \"price\": 0.01, \"stock\": 100, \"isShow\": 1, \"status\": 1, \"timeId\": 2, \"addTime\": \"\", \"postage\": 2, \"stopTime\": 1623081600, \"unitName\": \"件\", \"albumPics\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ab46a3cN616bdc41.jpg,http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf5fN2522b9dc.jpg\", \"giftPoint\": 3788, \"hotStatus\": 1, \"lockStock\": 0, \"productId\": 26, \"startTime\": 1590681600, \"detailHtml\": \"<p><img class=\\\"wscnph\\\" src=\\\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad44f1cNf51f3bb0.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad44fa8Nfcf71c10.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad44fa9N40e78ee0.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad457f4N1c94bdda.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad457f5Nd30de41d.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5b10fb0eN0eb053fb.jpg\\\" /></p>\", \"description\": \"AI智慧全面屏 6GB +64GB 亮黑色 全网通版 移动联通电信4G手机 双卡双待手机 双卡双待\", \"endTimeDate\": 1623081600000, \"deleteStatus\": 0, \"originalPrice\": 4288, \"postageStatus\": 0, \"startTimeDate\": 1590681600000}, {\"id\": 25, \"num\": 1, \"pic\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5ad83a4fN6ff67ecd.jpg!cc_350x449.jpg\", \"name\": \"HLA海澜之家简约动物印花短袖T恤\", \"sale\": 0, \"sort\": 2, \"price\": 0.1, \"stock\": 100, \"isShow\": 1, \"status\": 1, \"timeId\": 4, \"addTime\": \"1591152500\", \"postage\": 0, \"stopTime\": 1780934400, \"unitName\": \"\", \"albumPics\": \"http://localhost:8091/file/pic/微信图片_202004251523168-20200520063636108.jpg,http://localhost:8091/file/pic/微信图片_202004251523169-20200520063636108.jpg,http://localhost:8091/file/pic/微信图片_202004251523165-20200520063636108.jpg\", \"giftPoint\": 0, \"hotStatus\": 1, \"lockStock\": 0, \"productId\": 30, \"startTime\": 1591113600, \"detailHtml\": \"\", \"description\": \"2018夏季新品微弹舒适新款短T男生 6月6日-6月20日，满300减30，参与互动赢百元礼券，立即分享赢大奖\", \"endTimeDate\": 1780934400000, \"deleteStatus\": 0, \"originalPrice\": 98, \"postageStatus\": 1, \"startTimeDate\": 1591113600000}, {\"id\": 26, \"num\": 1, \"pic\": \"https://yoooho.bkbedu.com/mall/images/20191224/IMG_3876.JPG\", \"name\": \"新鲜红富士苹果10斤当季整箱\", \"sale\": 10, \"sort\": 1, \"price\": 0.01, \"stock\": 99, \"isShow\": 1, \"status\": 1, \"timeId\": 6, \"addTime\": \"1591421560\", \"postage\": 0, \"stopTime\": 1626278400, \"unitName\": \"斤\", \"albumPics\": \"https://yoooho.bkbedu.com/mall/images/20191224/IMG_3872.JPG,https://yoooho.bkbedu.com/mall/images/20191224/IMG_3873.JPG,https://yoooho.bkbedu.com/mall/images/20191224/IMG_3874.JPG,https://yoooho.bkbedu.com/mall/images/20191224/IMG_3875.JPG\", \"giftPoint\": 0, \"hotStatus\": 1, \"lockStock\": -2, \"productId\": 38, \"startTime\": 1559664000, \"detailHtml\": \"<p><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3877.JPG\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3883.JPG\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3880.JPG\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3879.JPG\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3878.JPG\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3882.JPG\\\" /></p>\", \"description\": \"新鲜红富士苹果\", \"endTimeDate\": 1626278400000, \"deleteStatus\": 0, \"originalPrice\": 44, \"postageStatus\": 1, \"startTimeDate\": 1559664000000, \"detailMobileHtml\": \"\"}, {\"id\": 27, \"num\": 1, \"pic\": \"https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525553.jpg\", \"name\": \"当季孕妇水果现摘大连车厘子2斤\", \"sale\": 10, \"sort\": 1, \"price\": 0.01, \"stock\": 100, \"isShow\": 1, \"status\": 1, \"timeId\": 3, \"addTime\": \"1591493719\", \"postage\": 0, \"stopTime\": 1784131200, \"unitName\": \"斤\", \"albumPics\": \"https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525552.jpg,https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525551.jpg,https://yoooho.bkbedu.com/mall/images/20200425/微信图片_20200425152555.jpg\", \"giftPoint\": 10, \"hotStatus\": 1, \"lockStock\": 0, \"productId\": 40, \"startTime\": 1591459200, \"detailHtml\": \"<p><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_20200425152316.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523161.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523162.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523163.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523164.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_20200425153015.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523165.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523166.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523167.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523168.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523169.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231610.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231611.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231615.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231612.jpg\\\" /><img class=\\\"wscnph\\\" src=\\\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231613.jpg\\\" /></p>\", \"description\": \"新鲜车厘子大果\", \"endTimeDate\": 1784131200000, \"deleteStatus\": 0, \"originalPrice\": 158, \"postageStatus\": 1, \"startTimeDate\": 1591459200000, \"detailMobileHtml\": \"\"}]}}, {\"id\": \"aq2f8u6pcig\", \"name\": \"商品列表\", \"type\": \"IndexGrouping\", \"disableDrag\": false, \"groupingData\": {\"name\": \"热门推荐\", \"goodsArr\": [{\"id\": 26, \"pic\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg\", \"name\": \"华为 HUAWEI P20 \", \"note\": \"\", \"sale\": 0, \"sort\": 100, \"unit\": \"件\", \"price\": 3788, \"stock\": 1000, \"weight\": 0, \"brandId\": 3, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \"AI智慧全面屏 6GB +64GB 亮黑色 全网通版 移动联通电信4G手机 双卡双待手机 双卡双待\", \"brandName\": \"华为\", \"giftPoint\": 3788, \"newStatus\": 0, \"productSn\": \"6946605\", \"giftGrowth\": 3788, \"serviceIds\": \"2,3,1\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 4288, \"previewStatus\": 1, \"promotionType\": 1, \"publishStatus\": 0, \"usePointLimit\": 0, \"recommandStatus\": 1, \"feightTemplateId\": 0, \"productCategoryId\": 19, \"promotionPerLimit\": 0, \"productCategoryName\": \"手机通讯\", \"productAttributeCategoryId\": 3}, {\"id\": 31, \"pic\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5ac98b64N70acd82f.jpg!cc_350x449.jpg\", \"name\": \"HLA海澜之家蓝灰花纹圆领针织布短袖T恤\", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"\", \"price\": 98, \"stock\": 100, \"weight\": 0, \"brandId\": 50, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \"2018夏季新品短袖T恤男HNTBJ2E080A 蓝灰花纹80 175/92A/L80A 蓝灰花纹80 175/92A/L\", \"brandName\": \"海澜之家\", \"giftPoint\": 0, \"newStatus\": 0, \"productSn\": \"HNTBJ2E080A\", \"giftGrowth\": 0, \"serviceIds\": \"\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 98, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 0, \"usePointLimit\": 0, \"recommandStatus\": 0, \"feightTemplateId\": 0, \"productCategoryId\": 8, \"promotionPerLimit\": 0, \"productCategoryName\": \"T恤\", \"productAttributeCategoryId\": 1}, {\"id\": 32, \"pic\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a51eb88Na4797877.jpg\", \"name\": \"HLA海澜之家短袖T恤男基础款\", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"\", \"price\": 68, \"stock\": 100, \"weight\": 0, \"brandId\": 50, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \"HLA海澜之家短袖T恤男基础款简约圆领HNTBJ2E153A藏青(F3)175/92A(50)\", \"brandName\": \"海澜之家\", \"giftPoint\": 0, \"newStatus\": 0, \"productSn\": \"HNTBJ2E153A\", \"giftGrowth\": 0, \"serviceIds\": \"\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 68, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 0, \"usePointLimit\": 0, \"recommandStatus\": 0, \"feightTemplateId\": 0, \"productCategoryId\": 8, \"promotionPerLimit\": 0, \"productCategoryName\": \"T恤\"}, {\"id\": 34, \"pic\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b028530N51eee7d4.jpg\", \"name\": \"小米（MI）小米电视4A 65英寸\", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"\", \"price\": 3999, \"stock\": 100, \"weight\": 0, \"brandId\": 6, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \" L65M5-AZ/L65M5-AD 2GB+8GB HDR 4K超高清 人工智能网络液晶平板电视\", \"brandName\": \"小米\", \"giftPoint\": 0, \"newStatus\": 0, \"productSn\": \"4609660\", \"giftGrowth\": 0, \"serviceIds\": \"\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 3999, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 0, \"usePointLimit\": 0, \"recommandStatus\": 0, \"feightTemplateId\": 0, \"productCategoryId\": 35, \"promotionPerLimit\": 0, \"productCategoryName\": \"手机数码\"}, {\"id\": 33, \"pic\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b02804dN66004d73.jpg\", \"name\": \"小米（MI）小米电视4A \", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"\", \"price\": 2499, \"stock\": 100, \"weight\": 0, \"brandId\": 6, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \"小米（MI）小米电视4A 55英寸 L55M5-AZ/L55M5-AD 2GB+8GB HDR 4K超高清 人工智能网络液晶平板电视\", \"brandName\": \"小米\", \"giftPoint\": 0, \"newStatus\": 0, \"productSn\": \"4609652\", \"giftGrowth\": 0, \"serviceIds\": \"\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 2499, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 0, \"usePointLimit\": 0, \"recommandStatus\": 0, \"feightTemplateId\": 0, \"productCategoryId\": 35, \"promotionPerLimit\": 0, \"productCategoryName\": \"手机数码\"}, {\"id\": 36, \"pic\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b19403eN9f0b3cb8.jpg\", \"name\": \"耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码\", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"\", \"price\": 499, \"stock\": 100, \"weight\": 0, \"brandId\": 58, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \"耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码\", \"brandName\": \"NIKE\", \"giftPoint\": 0, \"newStatus\": 0, \"productSn\": \"6799345\", \"giftGrowth\": 0, \"serviceIds\": \"\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 499, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 0, \"usePointLimit\": 0, \"recommandStatus\": 1, \"feightTemplateId\": 0, \"productCategoryId\": 29, \"promotionPerLimit\": 0, \"productCategoryName\": \"男鞋\"}, {\"id\": 35, \"pic\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b235bb9Nf606460b.jpg\", \"name\": \"耐克NIKE 男子 休闲鞋 ROSHE RUN 运动鞋 511881-010黑色41码\", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"\", \"price\": 369, \"stock\": 100, \"weight\": 0, \"brandId\": 58, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \"耐克NIKE 男子 休闲鞋 ROSHE RUN 运动鞋 511881-010黑色41码\", \"brandName\": \"NIKE\", \"giftPoint\": 0, \"newStatus\": 0, \"productSn\": \"6799342\", \"giftGrowth\": 0, \"serviceIds\": \"\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 369, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 0, \"usePointLimit\": 0, \"recommandStatus\": 0, \"feightTemplateId\": 0, \"productCategoryId\": 29, \"promotionPerLimit\": 0, \"productCategoryName\": \"男鞋\"}, {\"id\": 37, \"pic\": \"https://yoooho.bkbedu.com/mall/images/20191224/IMG_3848.JPG\", \"name\": \"正宗广西砂糖桔\", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"件\", \"price\": 27.8, \"stock\": 100000, \"weight\": 5000, \"brandId\": 59, \"keywords\": \"砂糖桔\", \"lowStock\": 0, \"subTitle\": \"新鲜当季水果沙糖桔5斤包邮\", \"brandName\": \"砂糖桔\", \"giftPoint\": 0, \"newStatus\": 1, \"productSn\": \"20191212301\", \"giftGrowth\": 0, \"serviceIds\": \"3\", \"detailTitle\": \"正宗广西砂糖桔10斤\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 0, \"previewStatus\": 1, \"promotionType\": 0, \"publishStatus\": 1, \"usePointLimit\": 0, \"recommandStatus\": 1, \"feightTemplateId\": 0, \"productCategoryId\": 55, \"promotionPerLimit\": 0, \"productCategoryName\": \"桔子\", \"productAttributeCategoryId\": 11}, {\"id\": 38, \"pic\": \"https://yoooho.bkbedu.com/mall/images/20191224/IMG_3876.JPG\", \"name\": \"新鲜红富士苹果10斤当季整箱\", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"\", \"price\": 44.8, \"stock\": 0, \"weight\": 5000, \"brandId\": 51, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \"新鲜红富士苹果\", \"brandName\": \"苹果\", \"giftPoint\": 0, \"newStatus\": 1, \"productSn\": \"2020010801\", \"giftGrowth\": 0, \"serviceIds\": \"\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 0, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 1, \"usePointLimit\": 0, \"recommandStatus\": 1, \"feightTemplateId\": 0, \"productCategoryId\": 54, \"promotionPerLimit\": 0, \"productCategoryName\": \"苹果\", \"productAttributeCategoryId\": 13}, {\"id\": 39, \"pic\": \"https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png\", \"name\": \"测试商品\", \"note\": \"\", \"sale\": 7, \"sort\": 0, \"unit\": \"\", \"price\": 0.01, \"stock\": 100, \"weight\": 0, \"brandId\": 6, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \"测试商品\", \"brandName\": \"小米\", \"giftPoint\": 0, \"newStatus\": 0, \"productSn\": \"20200109001\", \"giftGrowth\": 0, \"serviceIds\": \"1,2,3\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 0.01, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 1, \"usePointLimit\": 0, \"recommandStatus\": 0, \"feightTemplateId\": 0, \"productCategoryId\": 53, \"promotionPerLimit\": 0, \"productCategoryName\": \"水果集市\", \"productAttributeCategoryId\": 11}, {\"id\": 40, \"pic\": \"https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525553.jpg\", \"name\": \"当季孕妇水果现摘大连车厘子2斤3斤5斤顺丰包邮\", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"斤\", \"price\": 99, \"stock\": 100000000, \"weight\": 10000, \"brandId\": 60, \"keywords\": \"孕妇水果，新鲜水果\", \"lowStock\": 0, \"subTitle\": \"新鲜车厘子大果\", \"brandName\": \"水果\", \"giftPoint\": 10, \"newStatus\": 1, \"productSn\": \"202004251457\", \"giftGrowth\": 10, \"serviceIds\": \"3\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 158, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 1, \"usePointLimit\": 0, \"recommandStatus\": 1, \"feightTemplateId\": 0, \"productCategoryId\": 61, \"promotionPerLimit\": 0, \"productCategoryName\": \"车厘子/樱桃\", \"productAttributeCategoryId\": 14}]}}, {\"id\": \"tg4b13qarr8\", \"name\": \"专题组\", \"type\": \"IndexSubject\", \"disableDrag\": false, \"subjectData\": {\"title\": \"专题推荐\", \"subjectList\": [{\"id\": 1, \"pic\": \"https://img10.360buyimg.com/mobilecms/s1500x600_jfs/t26434/217/1381240043/254214/290f9d5b/5bc6c11cN54567a27.jpg!q70.jpg\", \"title\": \"轮廓分明，双摄手机映现细腻美照\", \"readCount\": 1000, \"categoryId\": 1, \"createTime\": 1593188759000, \"showStatus\": 1, \"description\": \"手机对于拍照党来说，已经不仅仅是通讯工具那么简单了。因为有时TA还充当着“单反”的角色，来不断地带给那些喜欢拍照的人惊喜。所以，在这里准备一波高颜值的双摄手机来给大家。让TA们灵敏捕捉影像的能力，为你展现出轮廓更加分明、且画质更加细腻的美照。\", \"categoryName\": \"精选专题\", \"collectCount\": 100, \"commentCount\": 100, \"recommendStatus\": 1}, {\"id\": 2, \"pic\": \"https://img11.360buyimg.com/mobilecms/s1500x600_jfs/t14224/229/529700229/74868/a1cc7364/5a314f85N5bfd22c7.jpg!q70.jpg\", \"title\": \"交通拥挤有妙招，电动车小巧穿行无障碍\", \"readCount\": 1000, \"categoryId\": 1, \"createTime\": 1542000420000, \"showStatus\": 1, \"description\": \"随着人们消费水平的提高，公路上的小车是越来越多了，导致每到上下班高峰期的时候，大路的车辆堵了一环又一环，而且你根本不知道它到底会塞多久，所以我们需要变通一下，不妨骑上电动车来个绿色出行，它够小巧玲珑，即使交通再怎么拥挤，也总有它可以通过的地方。\", \"categoryName\": \"精选专题\", \"collectCount\": 100, \"commentCount\": 100, \"recommendStatus\": 1}, {\"id\": 3, \"pic\": \"https://img12.360buyimg.com/mobilecms/s1500x600_jfs/t1/881/4/12265/114011/5bd1446fEc71114bf/68925bfb4a2adc44.jpg!q70.jpg\", \"title\": \"无酒不成席，甘香白酒开怀助兴\", \"readCount\": 1000, \"categoryId\": 1, \"createTime\": 1542086825000, \"showStatus\": 1, \"description\": \"白酒是由各种优质的高粱，小麦，大米等谷物为原料，经过传统工艺的长时间酿造，酒液在这样的环境中慢慢发酵，最终变成清香浓郁的白酒，被摆上人们的餐桌，供人畅饮，是一种受到大众喜爱的绝佳饮品。\", \"categoryName\": \"精选专题\", \"collectCount\": 100, \"commentCount\": 100, \"recommendStatus\": 1}, {\"id\": 4, \"pic\": \"https://img10.360buyimg.com/mobilecms/s1500x600_jfs/t15205/35/2539924281/429185/72fa7857/5aab2c4bN6a32a6c5.png\", \"title\": \"真规划不盲扫，全域清洁净无尘\", \"readCount\": 1000, \"categoryId\": 2, \"createTime\": 1541050029000, \"showStatus\": 1, \"description\": \"科技时代，聪明女人会选择用智慧来减负，和繁琐的家务挥手再见，才能腾出更多休闲时间。规划式扫地机器人设计个性化，它能够跟据房间布置呈现清扫路线，实现规划式覆盖性清洁，少遗漏不盲扫，从而大幅度降低损耗，侦测技术遇到家具及时避让，杜绝猛烈撞击，任它灵巧穿梭于低矮空间，坐享居家净无尘。\", \"categoryName\": \"家电专题\", \"collectCount\": 100, \"commentCount\": 100, \"recommendStatus\": 1}, {\"id\": 5, \"pic\": \"https://img11.360buyimg.com/mobilecms/s1500x600_jfs/t11428/340/1504074828/20474/1e8cab1e/5a0305d3Nb1e7a762.jpg!q70.jpg\", \"title\": \"抑菌更纯净，直饮净水保家人健康\", \"readCount\": 1000, \"categoryId\": 2, \"createTime\": 1541482038000, \"showStatus\": 1, \"description\": \"在城里居住，首先要担心的是饮水问题。桶装水太贵不够经济，还不一定是干净的。自己去干净的水源地取水也不切实际。此时只有选择在家里安装一台净水器才实在。装上一台直饮式的净水器，方便安全，关键是水质过滤得比较纯净，很大限度地处理了大部分的废弃物，留下健康的矿物质水。好生活，从一口干净的纯净水开始。\", \"categoryName\": \"家电专题\", \"collectCount\": 100, \"commentCount\": 100, \"recommendStatus\": 1}]}}, {\"id\": \"hfnch124mmg\", \"name\": \"商品类\", \"type\": \"IndexCategory\", \"disableDrag\": false, \"categoryData\": {\"title\": \"猜你喜欢\", \"goodsList\": [{\"id\": 36, \"pic\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b19403eN9f0b3cb8.jpg\", \"name\": \"耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码\", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"\", \"price\": 499, \"stock\": 100, \"weight\": 0, \"brandId\": 58, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \"耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码\", \"brandName\": \"NIKE\", \"giftPoint\": 0, \"newStatus\": 0, \"productSn\": \"6799345\", \"giftGrowth\": 0, \"serviceIds\": \"\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 499, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 0, \"usePointLimit\": 0, \"recommandStatus\": 1, \"feightTemplateId\": 0, \"productCategoryId\": 29, \"promotionPerLimit\": 0, \"productCategoryName\": \"男鞋\"}, {\"id\": 37, \"pic\": \"https://yoooho.bkbedu.com/mall/images/20191224/IMG_3848.JPG\", \"name\": \"正宗广西砂糖桔\", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"件\", \"price\": 27.8, \"stock\": 100000, \"weight\": 5000, \"brandId\": 59, \"keywords\": \"砂糖桔\", \"lowStock\": 0, \"subTitle\": \"新鲜当季水果沙糖桔5斤包邮\", \"brandName\": \"砂糖桔\", \"giftPoint\": 0, \"newStatus\": 1, \"productSn\": \"20191212301\", \"giftGrowth\": 0, \"serviceIds\": \"3\", \"detailTitle\": \"正宗广西砂糖桔10斤\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 0, \"previewStatus\": 1, \"promotionType\": 0, \"publishStatus\": 1, \"usePointLimit\": 0, \"recommandStatus\": 1, \"feightTemplateId\": 0, \"productCategoryId\": 55, \"promotionPerLimit\": 0, \"productCategoryName\": \"桔子\", \"productAttributeCategoryId\": 11}, {\"id\": 38, \"pic\": \"https://yoooho.bkbedu.com/mall/images/20191224/IMG_3876.JPG\", \"name\": \"新鲜红富士苹果10斤当季整箱\", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"\", \"price\": 44.8, \"stock\": 0, \"weight\": 5000, \"brandId\": 51, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \"新鲜红富士苹果\", \"brandName\": \"苹果\", \"giftPoint\": 0, \"newStatus\": 1, \"productSn\": \"2020010801\", \"giftGrowth\": 0, \"serviceIds\": \"\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 0, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 1, \"usePointLimit\": 0, \"recommandStatus\": 1, \"feightTemplateId\": 0, \"productCategoryId\": 54, \"promotionPerLimit\": 0, \"productCategoryName\": \"苹果\", \"productAttributeCategoryId\": 13}, {\"id\": 39, \"pic\": \"https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png\", \"name\": \"测试商品\", \"note\": \"\", \"sale\": 7, \"sort\": 0, \"unit\": \"\", \"price\": 0.01, \"stock\": 100, \"weight\": 0, \"brandId\": 6, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \"测试商品\", \"brandName\": \"小米\", \"giftPoint\": 0, \"newStatus\": 0, \"productSn\": \"20200109001\", \"giftGrowth\": 0, \"serviceIds\": \"1,2,3\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 0.01, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 1, \"usePointLimit\": 0, \"recommandStatus\": 0, \"feightTemplateId\": 0, \"productCategoryId\": 53, \"promotionPerLimit\": 0, \"productCategoryName\": \"水果集市\", \"productAttributeCategoryId\": 11}, {\"id\": 40, \"pic\": \"https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525553.jpg\", \"name\": \"当季孕妇水果现摘大连车厘子2斤3斤5斤顺丰包邮\", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"斤\", \"price\": 99, \"stock\": 100000000, \"weight\": 10000, \"brandId\": 60, \"keywords\": \"孕妇水果，新鲜水果\", \"lowStock\": 0, \"subTitle\": \"新鲜车厘子大果\", \"brandName\": \"水果\", \"giftPoint\": 10, \"newStatus\": 1, \"productSn\": \"202004251457\", \"giftGrowth\": 10, \"serviceIds\": \"3\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 158, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 1, \"usePointLimit\": 0, \"recommandStatus\": 1, \"feightTemplateId\": 0, \"productCategoryId\": 61, \"promotionPerLimit\": 0, \"productCategoryName\": \"车厘子/樱桃\", \"productAttributeCategoryId\": 14}, {\"id\": 31, \"pic\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5ac98b64N70acd82f.jpg!cc_350x449.jpg\", \"name\": \"HLA海澜之家蓝灰花纹圆领针织布短袖T恤\", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"\", \"price\": 98, \"stock\": 100, \"weight\": 0, \"brandId\": 50, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \"2018夏季新品短袖T恤男HNTBJ2E080A 蓝灰花纹80 175/92A/L80A 蓝灰花纹80 175/92A/L\", \"brandName\": \"海澜之家\", \"giftPoint\": 0, \"newStatus\": 0, \"productSn\": \"HNTBJ2E080A\", \"giftGrowth\": 0, \"serviceIds\": \"\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 98, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 0, \"usePointLimit\": 0, \"recommandStatus\": 0, \"feightTemplateId\": 0, \"productCategoryId\": 8, \"promotionPerLimit\": 0, \"productCategoryName\": \"T恤\", \"productAttributeCategoryId\": 1}, {\"id\": 32, \"pic\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a51eb88Na4797877.jpg\", \"name\": \"HLA海澜之家短袖T恤男基础款\", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"\", \"price\": 68, \"stock\": 100, \"weight\": 0, \"brandId\": 50, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \"HLA海澜之家短袖T恤男基础款简约圆领HNTBJ2E153A藏青(F3)175/92A(50)\", \"brandName\": \"海澜之家\", \"giftPoint\": 0, \"newStatus\": 0, \"productSn\": \"HNTBJ2E153A\", \"giftGrowth\": 0, \"serviceIds\": \"\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 68, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 0, \"usePointLimit\": 0, \"recommandStatus\": 0, \"feightTemplateId\": 0, \"productCategoryId\": 8, \"promotionPerLimit\": 0, \"productCategoryName\": \"T恤\"}, {\"id\": 33, \"pic\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b02804dN66004d73.jpg\", \"name\": \"小米（MI）小米电视4A \", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"\", \"price\": 2499, \"stock\": 100, \"weight\": 0, \"brandId\": 6, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \"小米（MI）小米电视4A 55英寸 L55M5-AZ/L55M5-AD 2GB+8GB HDR 4K超高清 人工智能网络液晶平板电视\", \"brandName\": \"小米\", \"giftPoint\": 0, \"newStatus\": 0, \"productSn\": \"4609652\", \"giftGrowth\": 0, \"serviceIds\": \"\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 2499, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 0, \"usePointLimit\": 0, \"recommandStatus\": 0, \"feightTemplateId\": 0, \"productCategoryId\": 35, \"promotionPerLimit\": 0, \"productCategoryName\": \"手机数码\"}, {\"id\": 34, \"pic\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b028530N51eee7d4.jpg\", \"name\": \"小米（MI）小米电视4A 65英寸\", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"\", \"price\": 3999, \"stock\": 100, \"weight\": 0, \"brandId\": 6, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \" L65M5-AZ/L65M5-AD 2GB+8GB HDR 4K超高清 人工智能网络液晶平板电视\", \"brandName\": \"小米\", \"giftPoint\": 0, \"newStatus\": 0, \"productSn\": \"4609660\", \"giftGrowth\": 0, \"serviceIds\": \"\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 3999, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 0, \"usePointLimit\": 0, \"recommandStatus\": 0, \"feightTemplateId\": 0, \"productCategoryId\": 35, \"promotionPerLimit\": 0, \"productCategoryName\": \"手机数码\"}, {\"id\": 35, \"pic\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b235bb9Nf606460b.jpg\", \"name\": \"耐克NIKE 男子 休闲鞋 ROSHE RUN 运动鞋 511881-010黑色41码\", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"\", \"price\": 369, \"stock\": 100, \"weight\": 0, \"brandId\": 58, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \"耐克NIKE 男子 休闲鞋 ROSHE RUN 运动鞋 511881-010黑色41码\", \"brandName\": \"NIKE\", \"giftPoint\": 0, \"newStatus\": 0, \"productSn\": \"6799342\", \"giftGrowth\": 0, \"serviceIds\": \"\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 369, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 0, \"usePointLimit\": 0, \"recommandStatus\": 0, \"feightTemplateId\": 0, \"productCategoryId\": 29, \"promotionPerLimit\": 0, \"productCategoryName\": \"男鞋\"}, {\"id\": 29, \"pic\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5acc5248N6a5f81cd.jpg\", \"name\": \"Apple iPhone 8 Plus 64GB 红色特别版 移动联通电信4G手机\", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"\", \"price\": 5499, \"stock\": 100, \"weight\": 0, \"brandId\": 51, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \"【限时限量抢购】Apple产品年中狂欢节，好物尽享，美在智慧！速来 >> 勾选[保障服务][原厂保2年]，获得AppleCare+全方位服务计划，原厂延保售后无忧。\", \"brandName\": \"苹果\", \"giftPoint\": 5499, \"newStatus\": 0, \"productSn\": \"7437799\", \"giftGrowth\": 5499, \"serviceIds\": \"\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 5499, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 0, \"usePointLimit\": 0, \"recommandStatus\": 0, \"feightTemplateId\": 0, \"productCategoryId\": 19, \"promotionPerLimit\": 0, \"productCategoryName\": \"手机通讯\", \"productAttributeCategoryId\": 3}, {\"id\": 30, \"pic\": \"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5ad83a4fN6ff67ecd.jpg!cc_350x449.jpg\", \"name\": \"HLA海澜之家简约动物印花短袖T恤\", \"note\": \"\", \"sale\": 0, \"sort\": 0, \"unit\": \"\", \"price\": 98, \"stock\": 100, \"weight\": 0, \"brandId\": 50, \"keywords\": \"\", \"lowStock\": 0, \"subTitle\": \"2018夏季新品微弹舒适新款短T男生 6月6日-6月20日，满300减30，参与互动赢百元礼券，立即分享赢大奖\", \"brandName\": \"海澜之家\", \"giftPoint\": 0, \"newStatus\": 0, \"productSn\": \"HNTBJ2E042A\", \"giftGrowth\": 0, \"serviceIds\": \"\", \"detailTitle\": \"\", \"deleteStatus\": 0, \"verifyStatus\": 0, \"originalPrice\": 98, \"previewStatus\": 0, \"promotionType\": 0, \"publishStatus\": 0, \"usePointLimit\": 0, \"recommandStatus\": 0, \"feightTemplateId\": 0, \"productCategoryId\": 8, \"promotionPerLimit\": 0, \"productCategoryName\": \"T恤\", \"productAttributeCategoryId\": 1}]}}]', '2020-06-27 10:55:14', '2020-07-24 16:16:05', '{\"needShare\": false, \"shareText\": \"\", \"shareImage\": \"\", \"needBackTop\": false, \"backTopImage\": \"\", \"backgroundColor\": \"\"}', '0', '1');
COMMIT;

-- ----------------------------
--  Table structure for `local_storage`
-- ----------------------------
DROP TABLE IF EXISTS `local_storage`;
CREATE TABLE `local_storage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(255) DEFAULT NULL COMMENT '文件真实的名称',
  `name` varchar(255) DEFAULT NULL COMMENT '文件名',
  `suffix` varchar(255) DEFAULT NULL COMMENT '后缀',
  `path` varchar(255) DEFAULT NULL COMMENT '路径',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `size` varchar(255) DEFAULT NULL COMMENT '大小',
  `operate` varchar(255) DEFAULT NULL COMMENT '操作人',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `local_storage`
-- ----------------------------
BEGIN;
INSERT INTO `local_storage` VALUES ('8', 'OA办公系统报价单-悟空创新-20191119-20200516062118649.xlsx', 'OA办公系统报价单-悟空创新-20191119', 'xlsx', 'D:\\mall\\file\\txt\\OA办公系统报价单-悟空创新-20191119-20200516062118649.xlsx', 'txt', '15.56KB   ', null, '2020-05-16 18:21:19'), ('9', '新建 Microsoft Word 文档-20200516062139905.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-20200516062139905.docx', 'txt', '14.34KB   ', null, '2020-05-16 18:21:40'), ('10', '微信图片_2020042515231614-20200520060750967.jpg', '微信图片_2020042515231614', 'jpg', 'D:\\mall\\file\\pic\\微信图片_2020042515231614-20200520060750967.jpg', 'pic', '259.18KB   ', 'admin', '2020-05-20 18:07:51'), ('11', '微信图片_2020042515231615-20200520060750967.jpg', '微信图片_2020042515231615', 'jpg', 'D:\\mall\\file\\pic\\微信图片_2020042515231615-20200520060750967.jpg', 'pic', '167.73KB   ', 'admin', '2020-05-20 18:07:51'), ('12', '微信图片_2020042515231615-202005200608546.jpg', '微信图片_2020042515231615', 'jpg', 'D:\\mall\\file\\pic\\微信图片_2020042515231615-202005200608546.jpg', 'pic', '167.73KB   ', 'admin', '2020-05-20 18:08:54'), ('13', '微信图片_2020042515231614-20200520060928514.jpg', '微信图片_2020042515231614', 'jpg', 'D:\\mall\\file\\pic\\微信图片_2020042515231614-20200520060928514.jpg', 'pic', '259.18KB   ', 'admin', '2020-05-20 18:09:29'), ('14', '微信图片_2020042515231613-20200520061117479.jpg', '微信图片_2020042515231613', 'jpg', 'D:\\mall\\file\\pic\\微信图片_2020042515231613-20200520061117479.jpg', 'pic', '165.74KB   ', 'admin', '2020-05-20 18:11:18'), ('15', '微信图片_2020042515231614-20200520061424271.jpg', '微信图片_2020042515231614', 'jpg', 'D:\\mall\\file\\pic\\微信图片_2020042515231614-20200520061424271.jpg', 'pic', '259.18KB   ', 'admin', '2020-05-20 18:14:24'), ('16', '微信图片_2020042515231613-20200520061800865.jpg', '微信图片_2020042515231613', 'jpg', 'D:\\mall\\file\\pic\\微信图片_2020042515231613-20200520061800865.jpg', 'pic', '165.74KB   ', 'admin', '2020-05-20 18:18:01'), ('17', '微信图片_20200425153015-20200520061822359.jpg', '微信图片_20200425153015', 'jpg', 'D:\\mall\\file\\pic\\微信图片_20200425153015-20200520061822359.jpg', 'pic', '213.74KB   ', 'admin', '2020-05-20 18:18:22'), ('18', '微信图片_2020042515231614-20200520061849614.jpg', '微信图片_2020042515231614', 'jpg', 'D:\\mall\\file\\pic\\微信图片_2020042515231614-20200520061849614.jpg', 'pic', '259.18KB   ', 'admin', '2020-05-20 18:18:50'), ('19', '微信图片_2020042515231615-20200520062012945.jpg', '微信图片_2020042515231615', 'jpg', 'D:\\mall\\file\\pic\\微信图片_2020042515231615-20200520062012945.jpg', 'pic', '167.73KB   ', 'admin', '2020-05-20 18:20:13'), ('20', '微信图片_2020042515231615-20200520062150726.jpg', '微信图片_2020042515231615', 'jpg', 'D:\\mall\\file\\pic\\微信图片_2020042515231615-20200520062150726.jpg', 'pic', '167.73KB   ', 'admin', '2020-05-20 18:21:51'), ('21', '微信图片_2020042515231614-20200520062150726.jpg', '微信图片_2020042515231614', 'jpg', 'D:\\mall\\file\\pic\\微信图片_2020042515231614-20200520062150726.jpg', 'pic', '259.18KB   ', 'admin', '2020-05-20 18:21:51'), ('22', '微信图片_202004251523168-20200520063636108.jpg', '微信图片_202004251523168', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251523168-20200520063636108.jpg', 'pic', '117.36KB   ', 'admin', '2020-05-20 18:36:36'), ('23', '微信图片_202004251523165-20200520063636108.jpg', '微信图片_202004251523165', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251523165-20200520063636108.jpg', 'pic', '240.28KB   ', 'admin', '2020-05-20 18:36:36'), ('24', '微信图片_202004251523169-20200520063636108.jpg', '微信图片_202004251523169', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251523169-20200520063636108.jpg', 'pic', '220.19KB   ', 'admin', '2020-05-20 18:36:36'), ('25', '微信图片_20200425152316-20200520063647316.jpg', '微信图片_20200425152316', 'jpg', 'D:\\mall\\file\\pic\\微信图片_20200425152316-20200520063647316.jpg', 'pic', '205.36KB   ', 'admin', '2020-05-20 18:36:47'), ('26', '微信图片_2020042515231614-20200520063755922.jpg', '微信图片_2020042515231614', 'jpg', 'D:\\mall\\file\\pic\\微信图片_2020042515231614-20200520063755922.jpg', 'pic', '259.18KB   ', 'admin', '2020-05-20 18:37:56'), ('27', '微信图片_2020042515231614-20200520063822274.jpg', '微信图片_2020042515231614', 'jpg', 'D:\\mall\\file\\pic\\微信图片_2020042515231614-20200520063822274.jpg', 'pic', '259.18KB   ', 'admin', '2020-05-20 18:38:22'), ('28', '新建 Microsoft Word 文档-20200527114734164.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-20200527114734164.docx', 'txt', '14.34KB   ', 'admin', '2020-05-27 11:47:34'), ('29', '新建 Microsoft Word 文档-20200527114900104.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-20200527114900104.docx', 'txt', '14.34KB   ', 'admin', '2020-05-27 11:49:00'), ('30', '新建 Microsoft Word 文档-20200527114930353.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-20200527114930353.docx', 'txt', '14.34KB   ', 'admin', '2020-05-27 11:49:30'), ('31', '新建 Microsoft Word 文档-20200527114935794.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-20200527114935794.docx', 'txt', '14.34KB   ', 'admin', '2020-05-27 11:49:36'), ('32', '新建 Microsoft Word 文档-20200527115212499.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-20200527115212499.docx', 'txt', '14.34KB   ', 'admin', '2020-05-27 11:52:13'), ('33', '新建 Microsoft Word 文档-20200527115334797.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-20200527115334797.docx', 'txt', '14.34KB   ', 'admin', '2020-05-27 11:53:35'), ('34', '新建 Microsoft Word 文档-202005271154304.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-202005271154304.docx', 'txt', '14.34KB   ', 'admin', '2020-05-27 11:54:30'), ('35', '新建 Microsoft Word 文档-20200527115439554.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-20200527115439554.docx', 'txt', '14.34KB   ', 'admin', '2020-05-27 11:54:40'), ('36', '新建 Microsoft Word 文档-2020052711574710.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-2020052711574710.docx', 'txt', '14.34KB   ', 'admin', '2020-05-27 11:57:47'), ('37', '新建 Microsoft Word 文档-20200527115808680.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-20200527115808680.docx', 'txt', '14.34KB   ', 'admin', '2020-05-27 11:58:09'), ('38', '新建 Microsoft Word 文档-20200527115905609.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-20200527115905609.docx', 'txt', '14.34KB   ', 'admin', '2020-05-27 11:59:06'), ('39', '新建 Microsoft Word 文档-20200527115915485.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-20200527115915485.docx', 'txt', '14.34KB   ', 'admin', '2020-05-27 11:59:15'), ('40', '新建 Microsoft Word 文档-20200527120005238.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-20200527120005238.docx', 'txt', '14.34KB   ', 'admin', '2020-05-27 12:00:05'), ('41', '新建 Microsoft Word 文档-20200527120016684.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-20200527120016684.docx', 'txt', '14.34KB   ', 'admin', '2020-05-27 12:00:17'), ('42', '新建 Microsoft Word 文档-20200527120029105.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-20200527120029105.docx', 'txt', '14.34KB   ', 'admin', '2020-05-27 12:00:29'), ('43', '新建 Microsoft Word 文档-20200527120355585.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-20200527120355585.docx', 'txt', '14.34KB   ', 'admin', '2020-05-27 12:03:56'), ('44', '新建 Microsoft Word 文档-20200527120443290.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-20200527120443290.docx', 'txt', '14.34KB   ', 'admin', '2020-05-27 12:04:43'), ('45', '新建 Microsoft Word 文档-20200527120513545.docx', '新建 Microsoft Word 文档', 'docx', 'D:\\mall\\file\\txt\\新建 Microsoft Word 文档-20200527120513545.docx', 'txt', '14.34KB   ', 'admin', '2020-05-27 12:05:14'), ('46', 'OA办公系统报价单-悟空创新-20191119-20200527120536750.xlsx', 'OA办公系统报价单-悟空创新-20191119', 'xlsx', 'D:\\mall\\file\\txt\\OA办公系统报价单-悟空创新-20191119-20200527120536750.xlsx', 'txt', '15.56KB   ', 'admin', '2020-05-27 12:05:37'), ('47', '秒杀-20200609083125178.png', '秒杀', 'png', 'D:\\mall\\file\\pic\\秒杀-20200609083125178.png', 'pic', '10.64KB   ', 'admin', '2020-06-09 20:31:25'), ('48', '微信图片_202004251525552-20200621101538650.jpg', '微信图片_202004251525552', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251525552-20200621101538650.jpg', 'pic', '85.73KB   ', 'admin', '2020-06-21 22:15:39'), ('49', '微信图片_202004251525552-20200621101710944.jpg', '微信图片_202004251525552', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251525552-20200621101710944.jpg', 'pic', '85.73KB   ', 'admin', '2020-06-21 22:17:11'), ('50', '微信图片_202004251525552-20200621101916440.jpg', '微信图片_202004251525552', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251525552-20200621101916440.jpg', 'pic', '85.73KB   ', 'admin', '2020-06-21 22:19:16'), ('51', '微信图片_202004251525551-20200621102641945.jpg', '微信图片_202004251525551', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251525551-20200621102641945.jpg', 'pic', '154.30KB   ', 'admin', '2020-06-21 22:26:42'), ('52', '微信图片_202004251525553-20200621102710939.jpg', '微信图片_202004251525553', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251525553-20200621102710939.jpg', 'pic', '133.38KB   ', 'admin', '2020-06-21 22:27:11'), ('53', '微信图片_202004251525551-20200621102724154.jpg', '微信图片_202004251525551', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251525551-20200621102724154.jpg', 'pic', '154.30KB   ', 'admin', '2020-06-21 22:27:24'), ('54', '微信图片_2020042515231611-20200621103451347.jpg', '微信图片_2020042515231611', 'jpg', 'D:\\mall\\file\\pic\\微信图片_2020042515231611-20200621103451347.jpg', 'pic', '230.40KB   ', 'admin', '2020-06-21 22:34:51'), ('55', 'normal video-20200621104538836.mp4', 'normal video', 'mp4', 'D:\\mall\\file\\vedio\\normal video-20200621104538836.mp4', 'vedio', '3.10MB   ', 'admin', '2020-06-21 22:45:39'), ('56', 'normal video-20200621104605276.mp4', 'normal video', 'mp4', 'D:\\mall\\file\\vedio\\normal video-20200621104605276.mp4', 'vedio', '3.10MB   ', 'admin', '2020-06-21 22:46:05'), ('57', 'normal video-20200621104755331.mp4', 'normal video', 'mp4', 'D:\\mall\\file\\vedio\\normal video-20200621104755331.mp4', 'vedio', '3.10MB   ', 'admin', '2020-06-21 22:47:55'), ('58', 'normal video-20200621104859607.mp4', 'normal video', 'mp4', 'D:\\mall\\file\\vedio\\normal video-20200621104859607.mp4', 'vedio', '3.10MB   ', 'admin', '2020-06-21 22:49:00'), ('59', 'normal video-2020062110501960.mp4', 'normal video', 'mp4', 'D:\\mall\\file\\vedio\\normal video-2020062110501960.mp4', 'vedio', '3.10MB   ', 'admin', '2020-06-21 22:50:19'), ('60', 'normal video-20200621105710608.mp4', 'normal video', 'mp4', 'D:\\mall\\file\\vedio\\normal video-20200621105710608.mp4', 'vedio', '3.10MB   ', 'admin', '2020-06-21 22:57:11'), ('61', 'normal video-20200621110352213.mp4', 'normal video', 'mp4', 'D:\\mall\\file\\vedio\\normal video-20200621110352213.mp4', 'vedio', '3.10MB   ', 'admin', '2020-06-21 23:03:52'), ('62', 'normal video-20200621110512708.mp4', 'normal video', 'mp4', 'D:\\mall\\file\\vedio\\normal video-20200621110512708.mp4', 'vedio', '3.10MB   ', 'admin', '2020-06-21 23:05:13'), ('63', 'normal video-20200621111059670.mp4', 'normal video', 'mp4', 'D:\\mall\\file\\vedio\\normal video-20200621111059670.mp4', 'vedio', '3.10MB   ', 'admin', '2020-06-21 23:11:00'), ('64', 'qwe-2020062111112538.jpg', 'qwe', 'jpg', 'D:\\mall\\file\\pic\\qwe-2020062111112538.jpg', 'pic', '47.39KB   ', 'admin', '2020-06-21 23:11:25'), ('65', 'qwe-20200621111215563.jpg', 'qwe', 'jpg', 'D:\\mall\\file\\pic\\qwe-20200621111215563.jpg', 'pic', '47.39KB   ', 'admin', '2020-06-21 23:12:16'), ('66', 'normal video-20200621111236157.mp4', 'normal video', 'mp4', 'D:\\mall\\file\\vedio\\normal video-20200621111236157.mp4', 'vedio', '3.10MB   ', 'admin', '2020-06-21 23:12:36'), ('67', 'qwe-20200621111415810.jpg', 'qwe', 'jpg', 'D:\\mall\\file\\pic\\qwe-20200621111415810.jpg', 'pic', '47.39KB   ', 'admin', '2020-06-21 23:14:16'), ('68', 'normal video-20200621111423813.mp4', 'normal video', 'mp4', 'D:\\mall\\file\\vedio\\normal video-20200621111423813.mp4', 'vedio', '3.10MB   ', 'admin', '2020-06-21 23:14:24'), ('69', 'normal video-20200621111446438.mp4', 'normal video', 'mp4', 'D:\\mall\\file\\vedio\\normal video-20200621111446438.mp4', 'vedio', '3.10MB   ', 'admin', '2020-06-21 23:14:46'), ('70', 'qwe-20200621111452184.jpg', 'qwe', 'jpg', 'D:\\mall\\file\\pic\\qwe-20200621111452184.jpg', 'pic', '47.39KB   ', 'admin', '2020-06-21 23:14:52'), ('71', 'qwe-20200622102426660.jpg', 'qwe', 'jpg', 'D:\\mall\\file\\pic\\qwe-20200622102426660.jpg', 'pic', '47.39KB   ', 'admin', '2020-06-22 10:24:27'), ('72', '微信图片_202004251525551-20200622111842389.jpg', '微信图片_202004251525551', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251525551-20200622111842389.jpg', 'pic', '154.30KB   ', 'admin', '2020-06-22 11:18:42'), ('73', '微信图片_202004251525551-20200622011838400.jpg', '微信图片_202004251525551', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251525551-20200622011838400.jpg', 'pic', '154.30KB   ', 'admin', '2020-06-22 13:18:38'), ('74', 'normal video-2020062203405663.mp4', 'normal video', 'mp4', 'D:\\mall\\file\\vedio\\normal video-2020062203405663.mp4', 'vedio', '3.10MB   ', 'admin', '2020-06-22 15:40:56'), ('75', 'qwe-2020062203410253.jpg', 'qwe', 'jpg', 'D:\\mall\\file\\pic\\qwe-2020062203410253.jpg', 'pic', '47.39KB   ', 'admin', '2020-06-22 15:41:02'), ('76', '微信图片_202004251525552-202006220435515.jpg', '微信图片_202004251525552', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251525552-202006220435515.jpg', 'pic', '85.73KB   ', 'admin', '2020-06-22 16:35:51'), ('77', '微信图片_202004251525552-20200622043556487.jpg', '微信图片_202004251525552', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251525552-20200622043556487.jpg', 'pic', '85.73KB   ', 'admin', '2020-06-22 16:35:56'), ('78', '微信图片_202004251523169-20200626110609296.jpg', '微信图片_202004251523169', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251523169-20200626110609296.jpg', 'pic', '220.19KB   ', 'admin', '2020-06-26 23:06:09'), ('79', '微信图片_202004251525552-2020062703325125.jpg', '微信图片_202004251525552', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251525552-2020062703325125.jpg', 'pic', '85.73KB   ', 'admin', '2020-06-27 15:32:51'), ('80', '微信图片_202004251525552-20200627034902598.jpg', '微信图片_202004251525552', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251525552-20200627034902598.jpg', 'pic', '85.73KB   ', 'admin', '2020-06-27 15:49:03'), ('81', '微信图片_202004251525553-20200627034913100.jpg', '微信图片_202004251525553', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251525553-20200627034913100.jpg', 'pic', '133.38KB   ', 'admin', '2020-06-27 15:49:13'), ('82', '秒杀-20200628115700137.png', '秒杀', 'png', 'D:\\mall\\file\\pic\\秒杀-20200628115700137.png', 'pic', '10.64KB   ', 'admin', '2020-06-28 23:57:00'), ('83', '秒杀-20200629120156872.png', '秒杀', 'png', 'D:\\mall\\file\\pic\\秒杀-20200629120156872.png', 'pic', '10.64KB   ', 'admin', '2020-06-29 00:01:57'), ('84', '秒杀-20200629120242298.png', '秒杀', 'png', 'D:\\mall\\file\\pic\\秒杀-20200629120242298.png', 'pic', '10.64KB   ', 'admin', '2020-06-29 00:02:42'), ('85', '秒杀-20200629120305587.png', '秒杀', 'png', 'D:\\mall\\file\\pic\\秒杀-20200629120305587.png', 'pic', '10.64KB   ', 'admin', '2020-06-29 00:03:06'), ('86', 'qwe-20200629120317759.jpg', 'qwe', 'jpg', 'D:\\mall\\file\\pic\\qwe-20200629120317759.jpg', 'pic', '47.39KB   ', 'admin', '2020-06-29 12:03:18'), ('87', 'qwe-20200629122957184.jpg', 'qwe', 'jpg', 'D:\\mall\\file\\pic\\qwe-20200629122957184.jpg', 'pic', '47.39KB   ', 'admin', '2020-06-29 12:29:57'), ('88', '微信图片_202004251525553-20200629123009971.jpg', '微信图片_202004251525553', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251525553-20200629123009971.jpg', 'pic', '133.38KB   ', 'admin', '2020-06-29 12:30:10'), ('89', '微信图片_202004251523166-20200704092652861.jpg', '微信图片_202004251523166', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251523166-20200704092652861.jpg', 'pic', '185.58KB   ', 'admin', '2020-07-04 09:26:53'), ('90', '微信图片_202004251525553-20200704092745544.jpg', '微信图片_202004251525553', 'jpg', 'D:\\mall\\file\\pic\\微信图片_202004251525553-20200704092745544.jpg', 'pic', '133.38KB   ', 'admin', '2020-07-04 09:27:46'), ('91', '秒杀-20200706100746290.png', '秒杀', 'png', 'D:\\mall\\file\\pic\\秒杀-20200706100746290.png', 'pic', '10.64KB   ', 'admin', '2020-07-06 22:07:46'), ('92', '秒杀-20200706100801450.png', '秒杀', 'png', 'D:\\mall\\file\\pic\\秒杀-20200706100801450.png', 'pic', '10.64KB   ', 'admin', '2020-07-06 22:08:01'), ('93', '秒杀-20200706100807762.png', '秒杀', 'png', 'D:\\mall\\file\\pic\\秒杀-20200706100807762.png', 'pic', '10.64KB   ', 'admin', '2020-07-06 22:08:08'), ('94', '秒杀-20200706100813273.png', '秒杀', 'png', 'D:\\mall\\file\\pic\\秒杀-20200706100813273.png', 'pic', '10.64KB   ', 'admin', '2020-07-06 22:08:13'), ('95', 'u=259364631,2307942273&fm=26&gp=0-20200706100951512.jpg', 'u=259364631,2307942273&fm=26&gp=0', 'jpg', 'D:\\mall\\file\\pic\\u=259364631,2307942273&fm=26&gp=0-20200706100951512.jpg', 'pic', '44.99KB   ', 'admin', '2020-07-06 22:09:52'), ('96', 'u=1367884093,2254863616&fm=26&gp=0-20200706100956949.jpg', 'u=1367884093,2254863616&fm=26&gp=0', 'jpg', 'D:\\mall\\file\\pic\\u=1367884093,2254863616&fm=26&gp=0-20200706100956949.jpg', 'pic', '43.05KB   ', 'admin', '2020-07-06 22:09:57'), ('97', 'u=1558734614,2571467604&fm=26&gp=0-2020070610100551.jpg', 'u=1558734614,2571467604&fm=26&gp=0', 'jpg', 'D:\\mall\\file\\pic\\u=1558734614,2571467604&fm=26&gp=0-2020070610100551.jpg', 'pic', '26.65KB   ', 'admin', '2020-07-06 22:10:05'), ('98', 'u=1558734614,2571467604&fm=26&gp=0-20200706101014469.jpg', 'u=1558734614,2571467604&fm=26&gp=0', 'jpg', 'D:\\mall\\file\\pic\\u=1558734614,2571467604&fm=26&gp=0-20200706101014469.jpg', 'pic', '26.65KB   ', 'admin', '2020-07-06 22:10:14'), ('99', 'u=2011292736,2426988592&fm=26&gp=0-20200706101021470.jpg', 'u=2011292736,2426988592&fm=26&gp=0', 'jpg', 'D:\\mall\\file\\pic\\u=2011292736,2426988592&fm=26&gp=0-20200706101021470.jpg', 'pic', '37.80KB   ', 'admin', '2020-07-06 22:10:21'), ('100', 'u=2011292736,2426988592&fm=26&gp=0-20200706101027483.jpg', 'u=2011292736,2426988592&fm=26&gp=0', 'jpg', 'D:\\mall\\file\\pic\\u=2011292736,2426988592&fm=26&gp=0-20200706101027483.jpg', 'pic', '37.80KB   ', 'admin', '2020-07-06 22:10:27'), ('101', 'u=2987675329,2171331638&fm=26&gp=0-20200706101035954.jpg', 'u=2987675329,2171331638&fm=26&gp=0', 'jpg', 'D:\\mall\\file\\pic\\u=2987675329,2171331638&fm=26&gp=0-20200706101035954.jpg', 'pic', '46.44KB   ', 'admin', '2020-07-06 22:10:36'), ('102', 'u=2802746215,1434233027&fm=26&gp=0-20200706101349100.jpg', 'u=2802746215,1434233027&fm=26&gp=0', 'jpg', 'D:\\mall\\file\\pic\\u=2802746215,1434233027&fm=26&gp=0-20200706101349100.jpg', 'pic', '32.81KB   ', 'admin', '2020-07-06 22:13:49'), ('103', 'u=2023634314,1823197544&fm=26&gp=0-20200706101525299.jpg', 'u=2023634314,1823197544&fm=26&gp=0', 'jpg', 'D:\\mall\\file\\pic\\u=2023634314,1823197544&fm=26&gp=0-20200706101525299.jpg', 'pic', '82.46KB   ', 'admin', '2020-07-06 22:15:25'), ('104', 'tuwen-20200724021305988.png', 'tuwen', 'png', '/Users/apple/Documents/GitHub/mall/D:\\mall\\file\\pic/tuwen-20200724021305988.png', 'pic', '6.60KB   ', 'admin', '2020-07-24 14:13:06'), ('105', 'tuwen-20200724021449591.png', 'tuwen', 'png', '/Users/apple/Documents/GitHub/mall/D:\\mall\\file\\pic/tuwen-20200724021449591.png', 'pic', '6.60KB   ', 'admin', '2020-07-24 14:14:50'), ('106', 'tuwen-20200724021542826.png', 'tuwen', 'png', '/Users/apple/Documents/GitHub/mall/D:\\mall\\file\\pic/tuwen-20200724021542826.png', 'pic', '6.60KB   ', 'admin', '2020-07-24 14:15:43'), ('107', 'tuwenxianshikuang-20200724021704556.png', 'tuwenxianshikuang', 'png', '/Users/apple/Documents/mall/file/pic/tuwenxianshikuang-20200724021704556.png', 'pic', '7.34KB   ', 'admin', '2020-07-24 14:17:05'), ('108', 'qiandao-20200724021945826.png', 'qiandao', 'png', '/Users/apple/Documents/mall/file/pic/qiandao-20200724021945826.png', 'pic', '6.68KB   ', 'admin', '2020-07-24 14:19:46'), ('109', 'tuwenxianshikuang-20200724022031173.png', 'tuwenxianshikuang', 'png', '/Users/apple/Documents/mall/file/pic/tuwenxianshikuang-20200724022031173.png', 'pic', '7.34KB   ', 'admin', '2020-07-24 14:20:31'), ('110', 'qiandao-20200724022118893.png', 'qiandao', 'png', '/Users/apple/Documents/mall/file/pic/qiandao-20200724022118893.png', 'pic', '6.68KB   ', 'admin', '2020-07-24 14:21:19'), ('111', 'tuwenxianshikuang-20200724023108973.png', 'tuwenxianshikuang', 'png', '/Users/apple/Documents/mall/file/pic/tuwenxianshikuang-20200724023108973.png', 'pic', '7.34KB   ', 'admin', '2020-07-24 14:31:09'), ('112', 'qiandao-202007240231388.png', 'qiandao', 'png', '/Users/apple/Documents/mall/file/pic/qiandao-202007240231388.png', 'pic', '6.68KB   ', 'admin', '2020-07-24 14:31:38'), ('113', 'tuwenxianshikuang-20200724023253359.png', 'tuwenxianshikuang', 'png', '/Users/apple/Documents/mall/file/pic/tuwenxianshikuang-20200724023253359.png', 'pic', '7.34KB   ', 'admin', '2020-07-24 14:32:53'), ('114', 'tuwen-20200724023706944.png', 'tuwen', 'png', '/Users/apple/Documents/mall/file/pic/tuwen-20200724023706944.png', 'pic', '6.60KB   ', 'admin', '2020-07-24 14:37:07'), ('115', 'tuwenxianshikuang-20200724023715427.png', 'tuwenxianshikuang', 'png', '/Users/apple/Documents/mall/file/pic/tuwenxianshikuang-20200724023715427.png', 'pic', '7.34KB   ', 'admin', '2020-07-24 14:37:15'), ('116', 'tuwenxianshikuang-20200724025056690.png', 'tuwenxianshikuang', 'png', '/Users/apple/Documents/mall/file/pic/tuwenxianshikuang-20200724025056690.png', 'pic', '7.34KB   ', 'admin', '2020-07-24 14:50:57'), ('117', 'tuwen-20200724025250898.png', 'tuwen', 'png', '/Users/apple/Documents/mall/file/pic/tuwen-20200724025250898.png', 'pic', '6.60KB   ', 'admin', '2020-07-24 14:52:51'), ('118', 'qiandao-20200724025316600.png', 'qiandao', 'png', '/Users/apple/Documents/mall/file/pic/qiandao-20200724025316600.png', 'pic', '6.68KB   ', 'admin', '2020-07-24 14:53:17'), ('119', 'tuwenxianshikuang-20200724025407903.png', 'tuwenxianshikuang', 'png', '/Users/apple/Documents/mall/file/pic/tuwenxianshikuang-20200724025407903.png', 'pic', '7.34KB   ', 'admin', '2020-07-24 14:54:08'), ('120', 'tuwenxianshikuang-20200724025450291.png', 'tuwenxianshikuang', 'png', '/Users/apple/Documents/mall/file/pic/tuwenxianshikuang-20200724025450291.png', 'pic', '7.34KB   ', 'admin', '2020-07-24 14:54:50'), ('121', 'qiandao-20200724025551849.png', 'qiandao', 'png', '/Users/apple/Documents/mall/file/pic/qiandao-20200724025551849.png', 'pic', '6.68KB   ', 'admin', '2020-07-24 14:55:52'), ('122', 'tuwen-20200724025803683.png', 'tuwen', 'png', '/Users/apple/Documents/mall/file/pic/tuwen-20200724025803683.png', 'pic', '6.60KB   ', 'admin', '2020-07-24 14:58:04'), ('123', 'tuwenxianshikuang-20200724030403419.png', 'tuwenxianshikuang', 'png', '/Users/apple/Documents/mall/file/pic/tuwenxianshikuang-20200724030403419.png', 'pic', '7.34KB   ', 'admin', '2020-07-24 15:04:03'), ('124', 'tuwen-20200724030435641.png', 'tuwen', 'png', '/Users/apple/Documents/mall/file/pic/tuwen-20200724030435641.png', 'pic', '6.60KB   ', 'admin', '2020-07-24 15:04:36'), ('125', 'tuwenxianshikuang-20200724030605651.png', 'tuwenxianshikuang', 'png', '/Users/apple/Documents/mall/file/pic/tuwenxianshikuang-20200724030605651.png', 'pic', '7.34KB   ', 'admin', '2020-07-24 15:06:06'), ('126', 'tuwen-20200724030908817.png', 'tuwen', 'png', '/Users/apple/Documents/mall/file/pic/tuwen-20200724030908817.png', 'pic', '6.60KB   ', 'admin', '2020-07-24 15:09:09'), ('127', 'qiandao-20200724030919194.png', 'qiandao', 'png', '/Users/apple/Documents/mall/file/pic/qiandao-20200724030919194.png', 'pic', '6.68KB   ', 'admin', '2020-07-24 15:09:19'), ('128', 'tuwen-20200724030937968.png', 'tuwen', 'png', '/Users/apple/Documents/mall/file/pic/tuwen-20200724030937968.png', 'pic', '6.60KB   ', 'admin', '2020-07-24 15:09:38'), ('129', 'tuwen-20200724030952797.png', 'tuwen', 'png', '/Users/apple/Documents/mall/file/pic/tuwen-20200724030952797.png', 'pic', '6.60KB   ', 'admin', '2020-07-24 15:09:53'), ('130', 'tuwenxianshikuang-20200724031005829.png', 'tuwenxianshikuang', 'png', '/Users/apple/Documents/mall/file/pic/tuwenxianshikuang-20200724031005829.png', 'pic', '7.34KB   ', 'admin', '2020-07-24 15:10:06'), ('131', 'qiandao-20200724031653608.png', 'qiandao', 'png', '/Users/apple/Documents/mall/file/pic/qiandao-20200724031653608.png', 'pic', '6.68KB   ', 'admin', '2020-07-24 15:16:54'), ('132', 'tuwenxianshikuang-20200724031738452.png', 'tuwenxianshikuang', 'png', '/Users/apple/Documents/mall/file/pic/tuwenxianshikuang-20200724031738452.png', 'pic', '7.34KB   ', 'admin', '2020-07-24 15:17:38'), ('133', 'tuwen-20200724031817301.png', 'tuwen', 'png', '/Users/apple/Documents/mall/file/pic/tuwen-20200724031817301.png', 'pic', '6.60KB   ', 'admin', '2020-07-24 15:18:17'), ('134', 'tuwenxianshikuang-20200724032001539.png', 'tuwenxianshikuang', 'png', '/Users/apple/Documents/mall/file/pic/tuwenxianshikuang-20200724032001539.png', 'pic', '7.34KB   ', 'admin', '2020-07-24 15:20:02'), ('135', 'tuwenxianshikuang-20200724032615659.png', 'tuwenxianshikuang', 'png', '/Users/apple/Documents/mall/file/pic/tuwenxianshikuang-20200724032615659.png', 'pic', '7.34KB   ', 'admin', '2020-07-24 15:26:16'), ('136', 'tuwenxianshikuang-20200724032650696.png', 'tuwenxianshikuang', 'png', '/Users/apple/Documents/mall/file/pic/tuwenxianshikuang-20200724032650696.png', 'pic', '7.34KB   ', 'admin', '2020-07-24 15:26:51'), ('137', 'u=1558734614,2571467604&fm=26&gp=0-20200724032848570.jpg', 'u=1558734614,2571467604&fm=26&gp=0', 'jpg', '/Users/apple/Documents/mall/file/pic/u=1558734614,2571467604&fm=26&gp=0-20200724032848570.jpg', 'pic', '26.65KB   ', 'admin', '2020-07-24 15:28:49'), ('138', 'tuwen-20200724033129905.png', 'tuwen', 'png', '/Users/apple/Documents/mall/file/pic/tuwen-20200724033129905.png', 'pic', '6.60KB   ', 'admin', '2020-07-24 15:31:30'), ('139', 'tuwenxianshikuang-20200724033149447.png', 'tuwenxianshikuang', 'png', '/Users/apple/Documents/mall/file/pic/tuwenxianshikuang-20200724033149447.png', 'pic', '7.34KB   ', 'admin', '2020-07-24 15:31:49'), ('140', 'tuwen-20200724033347123.png', 'tuwen', 'png', '/Users/apple/Documents/mall/file/pic/tuwen-20200724033347123.png', 'pic', '6.60KB   ', 'admin', '2020-07-24 15:33:47'), ('141', 'tuwenxianshikuang-20200724033538799.png', 'tuwenxianshikuang', 'png', '/Users/apple/Documents/mall/file/pic/tuwenxianshikuang-20200724033538799.png', 'pic', '7.34KB   ', 'admin', '2020-07-24 15:35:39'), ('142', 'u=1558734614,2571467604&fm=26&gp=0-20200724033814867.jpg', 'u=1558734614,2571467604&fm=26&gp=0', 'jpg', '/Users/apple/Documents/mall/file/pic/u=1558734614,2571467604&fm=26&gp=0-20200724033814867.jpg', 'pic', '26.65KB   ', 'admin', '2020-07-24 15:38:15'), ('143', 'u=1558734614,2571467604&fm=26&gp=0-20200724033905799.jpg', 'u=1558734614,2571467604&fm=26&gp=0', 'jpg', '/Users/apple/Documents/mall/file/pic/u=1558734614,2571467604&fm=26&gp=0-20200724033905799.jpg', 'pic', '26.65KB   ', 'admin', '2020-07-24 15:39:06'), ('144', 'tuwen-20200724041603263.png', 'tuwen', 'png', '/Users/apple/Documents/mall/file/pic/tuwen-20200724041603263.png', 'pic', '6.60KB   ', 'admin', '2020-07-24 16:16:03');
COMMIT;

-- ----------------------------
--  Table structure for `material`
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `id` varchar(32) NOT NULL,
  `del_flag` char(2) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `create_id` varchar(100) DEFAULT NULL,
  `type` char(2) NOT NULL,
  `group_id` varchar(32) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `url` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `material`
-- ----------------------------
BEGIN;
INSERT INTO `material` VALUES ('0203d395a323457b9804b9996d1a781d', '0', '2020-07-04 09:27:46', 'admin', '1', null, '微信图片_202004251525553.jpg', 'http://localhost:8091/file/pic/微信图片_202004251525553-20200704092745544.jpg'), ('0cc5f17cbaf8497b8eebd1ce6919edb9', '0', '2020-05-20 18:36:36', 'admin', '1', '0539a2b5c2d54944b2764d08b4326503', '微信图片_202004251523168.jpg', 'http://localhost:8091/file/pic/微信图片_202004251523168-20200520063636108.jpg'), ('1a51c1df2ecd4275b74dd635bfcbb0d1', '0', '2020-06-21 22:15:39', 'admin', '1', null, '微信图片_202004251525552.jpg', 'http://localhost:8091/file/pic/微信图片_202004251525552-20200621101538650.jpg'), ('2f981bb58df74fb982c10115c90dec57', '0', '2020-05-20 18:22:01', 'admin', '1', null, '微信图片_2020042515231615.jpg', 'http://localhost:8091/file/pic/微信图片_2020042515231615-20200520062150726.jpg'), ('35c2271c501e4e9490482a472d06a70f', '0', '2020-05-20 18:22:01', 'admin', '1', null, '微信图片_2020042515231614.jpg', 'http://localhost:8091/file/pic/微信图片_2020042515231614-20200520062150726.jpg'), ('419c2d0a4ac44ab084f8146667a5e80d', '0', '2020-05-20 18:36:36', 'admin', '1', '0539a2b5c2d54944b2764d08b4326503', '微信图片_202004251523169.jpg', 'http://localhost:8091/file/pic/微信图片_202004251523169-20200520063636108.jpg'), ('6415b1a0fd33496e9875c8ffea3e26f1', '0', '2020-05-20 18:36:47', 'admin', '1', '499dcdc76dba41768b0e6490f741ce61', '微信图片_20200425152316.jpg', 'http://localhost:8091/file/pic/微信图片_20200425152316-20200520063647316.jpg'), ('beb101a2d2554c18913a4ac1344539bd', '0', '2020-07-04 09:26:53', 'admin', '1', null, '微信图片_202004251523166.jpg', 'http://localhost:8091/file/pic/微信图片_202004251523166-20200704092652861.jpg'), ('e08382ef7ff2408d8aa2953ce138b05b', '0', '2020-06-09 20:31:25', 'admin', '1', 'ec5bd8ac4ce144dc9b4e347d8807b7d5', '秒杀.png', 'http://localhost:8091/file/pic/秒杀-20200609083125178.png'), ('efb4f0e02a68451ebca4b10bb9c95f65', '0', '2020-05-20 18:36:36', 'admin', '1', '0539a2b5c2d54944b2764d08b4326503', '微信图片_202004251523165.jpg', 'http://localhost:8091/file/pic/微信图片_202004251523165-20200520063636108.jpg');
COMMIT;

-- ----------------------------
--  Table structure for `material_group`
-- ----------------------------
DROP TABLE IF EXISTS `material_group`;
CREATE TABLE `material_group` (
  `id` varchar(32) NOT NULL,
  `del_flag` varchar(2) NOT NULL DEFAULT '0' COMMENT '逻辑删除标记（0：显示；1：隐藏）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者ID',
  `name` varchar(200) NOT NULL COMMENT '分组名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `material_group`
-- ----------------------------
BEGIN;
INSERT INTO `material_group` VALUES ('0539a2b5c2d54944b2764d08b4326503', '0', '2020-05-20 18:26:51', null, '1'), ('11668f386eea4ce88cfb253833ff7d08', '0', '2020-05-20 18:24:06', null, '1'), ('499dcdc76dba41768b0e6490f741ce61', '0', '2020-05-20 18:25:46', null, 'q'), ('c036b05c71fd4523909bdc6b8aca54e0', '0', '2020-05-20 18:23:28', null, '1'), ('ec5bd8ac4ce144dc9b4e347d8807b7d5', '0', '2020-06-09 20:31:11', null, 'nav');
COMMIT;

-- ----------------------------
--  Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `i_frame` bit(1) NOT NULL COMMENT '是否外链',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `component` varchar(255) DEFAULT NULL COMMENT '组件',
  `pid` bigint(20) DEFAULT NULL COMMENT '上级菜单ID',
  `sort` bigint(20) DEFAULT NULL COMMENT '排序',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `path` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `cache` bit(1) DEFAULT NULL COMMENT '缓存',
  `hidden` bit(1) DEFAULT NULL COMMENT '是否隐藏',
  `component_name` varchar(255) DEFAULT NULL COMMENT '组件名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`,`i_frame`) USING BTREE,
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `menu`
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES ('1', b'0', '系统管理', null, '0', '99', 'system-manger', 'system', b'0', b'0', null, '2020-05-17 13:05:25', null, '1'), ('2', b'0', '用户管理', 'system/user/index', '1', '2', 'system-user', 'user', b'0', b'0', null, '2020-05-17 13:10:03', null, '1'), ('3', b'0', '角色管理', 'system/role/index', '1', '3', 'system-role', 'role', b'0', b'0', null, '2020-05-17 13:11:48', null, '1'), ('4', b'0', '菜单管理', 'system/menu/index', '1', '5', 'system-menu', 'menu', b'0', b'0', null, '2020-05-17 13:15:13', 'admin,menu:list,roles:list', '1'), ('5', b'0', '部门管理', 'system/dept/index', '1', '6', 'system-dept', 'dept', b'0', b'0', null, '2020-05-17 13:17:33', null, '1'), ('6', b'0', '岗位管理', 'system/job/index', '1', '7', 'system-job', 'job', b'0', b'0', null, '2020-05-17 13:18:51', null, '1'), ('7', b'0', '部门新增', null, '5', '2', null, null, b'0', b'0', null, '2020-05-17 13:21:38', 'dept:add', '2'), ('8', b'0', '部门编辑', null, '5', '3', null, null, b'0', b'0', null, '2020-05-17 13:22:11', 'dept:edit', '2'), ('9', b'0', '部门删除', null, '5', '4', null, null, b'0', b'0', null, '2020-05-17 13:22:58', 'dept:del', '2'), ('10', b'0', '岗位新增', null, '6', '2', null, null, b'0', b'0', null, '2020-05-17 13:24:19', 'job:add', '2'), ('11', b'0', '岗位编辑', null, '6', '3', null, null, b'0', b'0', null, '2020-05-17 13:25:17', 'job:edit', '2'), ('12', b'0', '岗位删除', null, '6', '4', null, null, b'0', b'0', null, '2020-05-17 13:25:51', 'job:del', '2'), ('13', b'0', '菜单新增', null, '4', '2', null, null, b'0', b'0', null, '2020-05-17 15:03:14', 'menu:add', '2'), ('14', b'0', '菜单编辑', null, '4', '3', null, null, b'0', b'0', null, '2020-05-17 15:03:36', 'menu:edit', '2'), ('15', b'0', '菜单删除', null, '4', '4', null, null, b'0', b'0', null, '2020-05-17 15:04:02', 'menu:del', '2'), ('17', b'0', '角色创建', null, '3', '2', null, null, b'0', b'0', null, '2020-05-17 15:06:07', 'roles:add', '2'), ('18', b'0', '角色修改', null, '3', '3', null, null, b'0', b'0', null, '2020-05-17 15:06:36', 'roles:edit', '2'), ('19', b'0', '角色删除', null, '3', '4', null, null, b'0', b'0', null, '2020-05-17 15:07:08', 'roles:del', '2'), ('20', b'0', '用户新增', null, '2', '2', null, null, b'0', b'0', null, '2020-05-17 15:08:10', 'user:add', '2'), ('21', b'0', '用户编辑', null, '2', '3', null, null, b'0', b'0', null, '2020-05-17 15:08:48', 'user:edit', '2'), ('22', b'0', '用户删除', null, '2', '4', null, null, b'0', b'0', null, '2020-05-17 15:09:23', 'user:del', '2'), ('23', b'0', '商品管理', null, '0', '1', 'product', 'pms', b'0', b'0', null, '2020-05-19 10:36:03', null, '0'), ('24', b'0', '商品列表', 'pms/product/index', '23', '2', 'product-list', 'product', b'0', b'0', null, '2020-05-19 10:40:09', 'pms:product:read', '1'), ('25', b'0', '添加商品', 'pms/product/add', '23', '3', 'product-add', 'addProduct', b'0', b'0', null, '2020-05-19 11:14:01', 'pms:product:create', '1'), ('26', b'0', '修改商品', 'pms/product/update', '23', '4', null, 'updateProduct', b'0', b'1', null, '2020-05-19 11:18:04', 'pms:product:update', '1'), ('27', b'0', '商品分类', 'pms/productCate/index', '23', '5', 'product-cate', 'productCate', b'0', b'0', null, '2020-05-19 11:21:13', 'pms:productCategory:read', '1'), ('28', b'0', '添加商品分类', 'pms/productCate/add', '23', '6', null, 'addProductCate', b'0', b'1', null, '2020-05-19 11:27:16', 'pms:productCategory:create', '1'), ('29', b'0', '修改商品分类', 'pms/productCate/update', '23', '7', null, 'updateProductCate', b'0', b'1', null, '2020-05-19 11:29:17', 'pms:productCategory:update', '1'), ('30', b'0', '删除商品分类', null, '23', '8', null, null, b'0', b'0', null, '2020-05-19 11:31:06', 'pms:productCategory:delete', '2'), ('31', b'0', '商品删除', null, '23', '999', null, null, b'0', b'0', null, '2020-05-19 11:34:17', 'pms:product:delete', '2'), ('32', b'0', '商品类型', 'pms/productAttr/index', '23', '999', 'product-attr', 'productAttr', b'0', b'0', null, '2020-05-19 11:38:47', null, '1'), ('33', b'0', '商品属性列表', 'pms/productAttr/productAttrList', '23', '999', null, 'productAttrList', b'0', b'1', null, '2020-05-19 11:41:31', null, '1'), ('34', b'0', '添加商品属性', 'productAttr/addProductAttr', '23', '999', null, 'addProductAttr', b'0', b'1', null, '2020-05-19 11:42:20', null, '1'), ('35', b'0', '修改商品属性', 'pms/productAttr/updateProductAttr', '23', '999', null, 'updateProductAttr', b'0', b'1', null, '2020-05-19 11:43:51', null, '1'), ('36', b'0', '品牌管理', 'pms/brand/index', '23', '999', 'product-brand', 'brand', b'0', b'0', null, '2020-05-19 11:46:21', null, '1'), ('37', b'0', '添加品牌', 'pms/brand/add', '23', '999', null, 'addBrand', b'0', b'1', null, '2020-05-19 11:47:12', 'pms:brand:create', '1'), ('38', b'0', '编辑品牌', 'pms/brand/update', '23', '999', null, 'updateBrand', b'0', b'1', '', '2020-05-19 11:48:35', 'pms:brand:update', '1'), ('39', b'0', '查询品牌信息', null, '23', '999', null, null, b'0', b'0', null, '2020-05-19 11:49:54', 'pms:brand:read', '2'), ('40', b'0', '删除品牌', null, '23', '999', null, null, b'0', b'0', null, '2020-05-19 11:50:38', 'pms:brand:delete', '2'), ('41', b'0', '专题管理', null, '0', '2', 'subject', 'sub', b'0', b'0', null, '2020-05-19 13:11:36', null, '0'), ('42', b'0', '专题列表', 'sub/subjectList', '41', '1', 'subject-list', 'subjectList', b'0', b'0', null, '2020-05-19 13:13:50', null, '1'), ('43', b'0', '添加专题', 'sub/subjectList/add', '41', '2', null, 'addSubject', b'0', b'1', null, '2020-05-19 13:15:28', 'sub:subject:create', '1'), ('44', b'0', '编辑专题', 'sub/subjectList/update', '41', '3', null, 'updateSubject', b'0', b'1', null, '2020-05-19 13:16:48', 'sub:subject:update', '1'), ('45', b'0', '专题分类', 'sub/subjectCate/index', '41', '4', 'subject-cate', 'subjectCate', b'0', b'0', null, '2020-05-19 13:18:05', null, '1'), ('46', b'0', '添加专题分类', 'sub/subjectCate/add', '41', '5', null, 'addSubjectCate', b'0', b'1', null, '2020-05-19 13:18:46', 'sub:subjectcate:create', '1'), ('47', b'0', '编辑专题分类', 'sub/subjectCate/update', '41', '6', null, 'updateSubjectCate', b'0', b'1', null, '2020-05-19 13:19:42', 'sub:subjectcate:update', '1'), ('48', b'0', '订单管理', null, '0', '3', 'order', 'oms', b'0', b'0', null, '2020-05-19 13:31:27', null, '0'), ('49', b'0', '订单列表', 'oms/order/index', '48', '1', 'product-list', 'order', b'0', b'0', null, '2020-05-19 13:33:40', null, '1'), ('50', b'0', '订单详情', 'oms/order/orderDetail', '48', '2', null, 'orderDetail', b'0', b'1', null, '2020-05-19 13:35:31', null, '1'), ('51', b'0', '发货列表', 'oms/order/deliverOrderList', '48', '3', null, 'deliverOrderList', b'0', b'1', '', '2020-05-19 13:36:51', '', '1'), ('52', b'0', '订单设置', 'oms/order/setting', '48', '4', 'order-setting', 'orderSetting', b'0', b'0', null, '2020-05-19 13:39:15', null, '1'), ('53', b'0', '退货申请处理', 'oms/apply/index', '48', '5', 'order-return', 'returnApply', b'0', b'0', null, '2020-05-19 13:40:42', null, '1'), ('54', b'0', '退款申请处理', 'oms/refund/index', '48', '6', 'order-refund', 'refund', b'0', b'0', null, '2020-05-19 13:41:46', null, '1'), ('55', b'0', '退货原因设置', 'oms/apply/reason', '48', '7', 'order-return-reason', 'returnReason', b'0', b'0', null, '2020-05-19 13:43:55', null, '1'), ('56', b'0', '退货原因详情', 'oms/apply/applyDetail', '48', '8', null, 'returnApplyDetail', b'0', b'1', '', '2020-05-19 13:45:44', null, '1'), ('57', b'0', '退款详情', 'oms/refund/refundDetail', '48', '9', null, 'refundDetail', b'0', b'1', null, '2020-05-19 13:47:21', null, '1'), ('58', b'0', '订单更新', null, '48', '10', null, null, b'0', b'0', null, '2020-05-19 13:52:55', 'oms:order:update', '2'), ('59', b'0', '删除订单', null, '48', '11', null, null, b'0', b'0', null, '2020-05-19 13:53:29', 'oms:order:del', '2'), ('60', b'0', '修改退款申请状态', null, '48', '12', null, null, b'0', b'0', null, '2020-05-19 13:55:03', 'oms:orderRefund:update', '2'), ('61', b'0', '删除订单退货申请', null, '48', '13', null, null, b'0', b'0', null, '2020-05-19 13:56:37', 'oms:returnApply:del', '2'), ('62', b'0', '修改订单退货申请状态', null, '48', '14', null, null, b'0', b'0', null, '2020-05-19 13:57:51', 'oms:returnApply:update', '2'), ('63', b'0', '添加退货原因', null, '48', '15', null, null, b'0', b'0', null, '2020-05-19 13:59:33', 'oms:returnReason:create', '2'), ('64', b'0', '修改退货原因', null, '48', '16', null, null, b'0', b'0', null, '2020-05-19 14:00:14', 'oms:returnReason:update', '2'), ('65', b'0', '删除退货原因', null, '48', '17', null, null, b'0', b'0', null, '2020-05-19 14:01:06', 'oms:returnReason:del', '2'), ('66', b'0', '修改订单设置', null, '48', '17', null, null, b'0', b'0', null, '2020-05-19 14:03:02', 'oms:orderSetting:update', '2'), ('67', b'0', '营销管理', null, '0', '4', 'sms', 'sms', b'0', b'0', null, '2020-05-19 14:05:36', null, '0'), ('68', b'0', '秒杀活动配置', 'sms/flash/index', '67', '1', 'sms-flash', 'flash', b'0', b'0', null, '2020-05-19 14:09:01', null, '1'), ('69', b'0', '秒杀时间段列表', 'sms/flash/sessionList', '67', '2', null, 'flashSession', b'0', b'1', null, '2020-05-19 14:15:17', null, '1'), ('70', b'0', '秒杀时间段选择', 'sms/flash/selectSessionList', '67', '3', null, 'selectSession', b'0', b'1', null, '2020-05-19 14:17:58', null, '1'), ('71', b'0', '秒杀商品列表', 'sms/flash/productRelationList', '67', '4', null, 'flashProductRelatio', b'0', b'1', null, '2020-05-19 14:19:04', null, '1'), ('72', b'0', '添加秒杀活动', null, '67', '999', null, null, b'0', b'0', null, '2020-05-19 14:22:16', 'sms:flash:creat', '2'), ('73', b'0', '编辑秒杀活动信息', null, '67', '999', null, null, b'0', b'0', null, '2020-05-19 14:23:30', 'sms:flash:update', '2'), ('74', b'0', '删除秒杀活动信息', null, '67', '999', null, null, b'0', b'0', null, '2020-05-19 14:24:25', 'sms:flash:del', '2'), ('75', b'0', '优惠券配置', 'sms/coupon/index', '67', '5', 'sms-coupon', 'coupon', b'0', b'0', null, '2020-05-19 14:26:44', null, '1'), ('76', b'0', '添加优惠券', 'sms/coupon/add', '67', '999', null, 'addCoupon', b'0', b'1', null, '2020-05-19 14:27:50', 'sms:coupon:create', '1'), ('77', b'0', '修改优惠券', 'sms/coupon/update', '67', '999', null, 'updateCoupon', b'0', b'1', null, '2020-05-19 14:28:51', 'sms:coupon:update', '1'), ('78', b'0', '优惠券领取详情', 'sms/coupon/history', '67', '999', null, 'couponHistory', b'0', b'1', null, '2020-05-19 14:29:53', null, '1'), ('79', b'0', '删除优惠券', null, '67', '999', null, null, b'0', b'0', null, '2020-05-19 14:37:04', 'sms:coupon:del', '2'), ('80', b'0', '品牌推荐', 'sms/brand/index', '67', '6', 'product-brand', 'brand', b'0', b'0', null, '2020-05-19 14:42:27', null, '1'), ('81', b'0', '新品推荐', 'sms/new/index', '67', '7', 'sms-new', 'new', b'0', b'0', null, '2020-05-19 14:43:42', null, '1'), ('82', b'0', '人气推荐', 'sms/hot/index', '67', '8', 'sms-hot', 'hot', b'0', b'0', null, '2020-05-19 14:45:09', null, '1'), ('83', b'0', '专题推荐', 'sms/subject/index', '67', '9', 'sms-subject', 'subject', b'0', b'0', null, '2020-05-19 14:46:43', null, '1'), ('84', b'0', '广告列表', 'shop/advertise/index', '134', '10', 'sms-ad', 'advertise', b'0', b'0', null, '2020-05-19 14:48:23', '', '1'), ('85', b'0', '添加广告', 'shop/advertise/add', '134', '11', null, 'addAdvertise', b'0', b'1', null, '2020-05-19 14:49:24', 'sms:advertise:create', '1'), ('86', b'0', '编辑广告', 'shop/advertise/update', '134', '999', null, 'updateAdvertise', b'0', b'1', null, '2020-05-19 14:50:14', 'sms:advertise:update', '1'), ('87', b'0', '删除广告权限', null, '134', '999', null, null, b'0', b'0', null, '2020-05-19 14:52:40', 'sms:advertise:del', '2'), ('88', b'0', '添加首页推荐品牌权限', null, '67', '999', null, null, b'0', b'0', null, '2020-05-19 14:55:51', 'sms:banner:create', '2'), ('89', b'0', '修改首页品牌权限', null, '67', '999', null, null, b'0', b'0', null, '2020-05-19 14:57:49', 'sms:banner:update', '2'), ('90', b'0', '删除首页品牌权限', null, '67', '999', null, null, b'0', b'0', null, '2020-05-19 14:58:09', 'sms:banner:del', '2'), ('91', b'0', '添加首页新品权限', null, '67', '999', null, null, b'0', b'0', null, '2020-05-19 14:59:10', 'sms:newProduct:create', '2'), ('92', b'0', '修改首页新品', null, '67', '999', null, null, b'0', b'0', null, '2020-05-19 14:59:43', 'sms:newProduct:update', '2'), ('93', b'0', '删除首页新品权限', null, '67', '999', null, null, b'0', b'0', null, '2020-05-19 15:06:04', 'sms:newProduct:del', '2'), ('94', b'0', '人气推荐添加权限', null, '67', '999', null, null, b'0', b'0', null, '2020-05-19 15:08:17', 'sms:recommendProduct:create', '2'), ('95', b'0', '人气推荐更新权限', null, '67', '999', null, null, b'0', b'0', null, '2020-05-19 15:08:49', 'ms:recommendProduct:update', '2'), ('96', b'0', '人气推荐删除权限', null, '67', '999', null, null, b'0', b'0', null, '2020-05-19 15:09:27', 'sms:recommendProduct:del', '2'), ('97', b'0', '首页专题推荐添加权限', null, '67', '999', null, null, b'0', b'0', null, '2020-05-19 15:11:34', 'sms:recommendSubject:create', '2'), ('98', b'0', '首页专题推荐更新权限', null, '67', '999', null, null, b'0', b'0', null, '2020-05-19 15:12:15', 'sms:recommendSubject:update', '2'), ('99', b'0', '首页专题推荐删除权限', null, '67', '999', null, null, b'0', b'0', null, '2020-05-19 15:12:44', 'sms:recommendSubject:del', '2'), ('100', b'0', '系统工具', null, '0', '999', 'sys-tools', 'tools', b'0', b'0', null, '2020-05-19 15:50:53', null, '0'), ('101', b'0', '邮箱工具', 'tools/email', '100', '1', 'tools-email', 'email', b'0', b'0', null, '2020-05-19 15:52:03', null, '1'), ('102', b'0', '支付宝工具', 'tools/aliPay', '100', '2', 'tools-ailPay', 'aliPay', b'0', b'0', null, '2020-05-19 15:52:54', null, '1'), ('103', b'0', '云存储工具', 'tools/aliyunOSS', '100', '999', 'tools-oss', 'aliyunOSS', b'0', b'0', null, '2020-05-19 15:53:43', null, '1'), ('104', b'0', '配置支付宝权限', null, '102', '999', null, null, b'0', b'0', null, '2020-05-19 15:58:08', 'tools:alipay:config', '2'), ('105', b'0', '邮箱配置权限', null, '101', '999', null, null, b'0', b'0', null, '2020-05-19 15:59:19', 'tools:email:config', '2'), ('106', b'0', '发送邮件权限', null, '101', '999', null, null, b'0', b'0', null, '2020-05-19 16:00:02', 'ools:email:send', '2'), ('107', b'0', '配置阿里云存储权限', null, '103', '999', null, null, b'0', b'0', null, '2020-05-19 16:01:48', 'tools:aliyunOss:config', '2'), ('108', b'0', '阿里云上传文件', null, '103', '999', null, null, b'0', b'0', null, '2020-05-19 16:02:41', 'tools:aliyunOss:upload', '2'), ('109', b'0', '阿里云查询文件', null, '103', '999', null, null, b'0', b'0', null, '2020-05-19 16:03:29', 'tools:aliyunOss:read', '2'), ('110', b'0', '同步阿里云数据权限', null, '103', '999', null, null, b'0', b'0', null, '2020-05-19 16:04:32', 'tools:aliyunOss:synchronize', '2'), ('111', b'0', '阿里云导出数据权限', null, '103', '999', null, null, b'0', b'0', null, '2020-05-19 16:06:12', 'tools:aliyunOss:download', '2'), ('112', b'0', '阿里云删除文件权限', null, '103', '999', null, null, b'0', b'0', null, '2020-05-19 16:07:10', 'tools:aliyunOss:del', '2'), ('113', b'0', '本地文件查询导出权限', null, '103', '999', null, null, b'0', b'0', null, '2020-05-19 16:08:45', 'storage:list', '2'), ('115', b'0', '本地上传文件权限', null, '103', '999', null, null, b'0', b'0', null, '2020-05-19 16:12:44', 'storage:add', '2'), ('116', b'0', '本地修改文件', null, '103', '999', null, null, b'0', b'0', null, '2020-05-19 16:13:15', 'storage:edit', '2'), ('117', b'0', '本地文件删除权限', null, '103', '999', null, null, b'0', b'0', null, '2020-05-19 16:13:57', 'storage:del', '2'), ('118', b'0', '导出查询部门数据', null, '1', '999', null, null, b'0', b'0', null, '2020-05-19 16:26:48', 'admin\',\'dept:list', '2'), ('119', b'0', '微信管理', null, '0', '5', 'wx', 'wechat', b'0', b'0', null, '2020-05-27 12:42:36', null, '0'), ('120', b'0', '微信菜单', 'wechat/menu/index', '119', '1', 'wx-menus', 'menu', b'0', b'0', null, '2020-05-27 12:47:50', null, '1'), ('121', b'0', '图文管理', 'wechat/article/index', '119', '2', 'wx-article', 'article', b'0', b'0', null, '2020-05-27 12:50:47', '', '1'), ('122', b'0', '自动回复', 'wechat/reply/index', '119', '999', 'wx-reply', 'reply', b'0', b'0', null, '2020-05-27 12:58:15', null, '1'), ('123', b'0', '新增自动回复', 'wechat/reply/add', '119', '999', null, 'addReply', b'0', b'1', '', '2020-05-27 13:13:09', null, '1'), ('124', b'0', '更新自动回复', 'wechat/reply/update', '119', '999', null, 'updateReply', b'0', b'1', 'updateReply', '2020-05-27 13:13:41', null, '1'), ('125', b'0', '粉丝管理', 'wechat/fans/index', '119', '999', 'wx-fans', 'fans', b'0', b'0', null, '2020-05-27 13:16:25', null, '1'), ('126', b'0', '消息管理', 'wechat/message/index', '119', '999', 'wx-message', 'message', b'0', b'0', null, '2020-05-27 13:19:56', null, '1'), ('127', b'0', '模板管理', 'wechat/template/index', '119', '999', 'wx-template', 'template', b'0', b'0', null, '2020-05-27 13:21:44', null, '1'), ('128', b'0', '公共号配置', 'wechat/config/index', '119', '999', 'wx-office', 'config/office', b'0', b'0', null, '2020-05-27 13:23:50', null, '1'), ('129', b'0', '微信支付配置', 'wechat/config/pay', '119', '999', 'wx-pay', 'config/pay', b'0', b'0', null, '2020-05-27 13:26:06', null, '1'), ('130', b'0', '微信小程序配置', 'wechat/config/wxapp', '119', '999', 'wx-app', 'config/app', b'0', b'0', null, '2020-05-27 13:28:06', '', '1'), ('131', b'0', '秒杀商品', 'sms/kill/index', '67', '999', 'sms-flash', 'kill', b'0', b'0', null, '2020-05-30 07:25:58', null, '1'), ('132', b'0', '创建秒杀商品', 'sms/kill/add', '67', '999', null, 'addkill', b'0', b'1', null, '2020-05-30 07:37:40', null, '1'), ('133', b'0', '更新秒杀商品', 'sms/kill/update', '67', '999', null, 'updateKill', b'0', b'1', null, '2020-05-30 07:38:45', null, '1'), ('134', b'0', '商城配置', null, '0', '6', 'shop', 'shop', b'0', b'0', null, '2020-06-09 18:24:49', null, '0'), ('135', b'0', '首页导航按钮', 'shop/menu/menu', '134', '999', 'wx-menus', 'navmeun', b'0', b'0', null, '2020-06-09 20:15:00', null, '1'), ('136', b'0', '短信管理', 'tools/sms', '100', '999', 'tools-sms', 'sms', b'0', b'0', null, '2020-06-15 17:24:51', null, '1'), ('137', b'0', '首页配置', 'shop/homeconfig', '134', '999', 'shop-homeconfig', 'homeconfig', b'0', b'0', null, '2020-06-20 22:40:02', null, '1'), ('138', b'0', '新增首页配置', 'shop/homeconfig/PageCreate', '134', '999', null, 'pageCreate', b'0', b'1', null, '2020-06-21 13:48:38', null, '1'), ('139', b'0', '修改首页配置', 'shop/homeconfig/PageEditor', '134', '999', null, 'pageEditor', b'0', b'1', null, '2020-06-22 12:20:51', null, '1'), ('140', b'0', '落地预览', 'shop/homeconfig/PagePreview', '134', '999', null, 'pagePreview', b'0', b'1', null, '2020-06-22 13:53:17', null, '1'), ('142', b'0', '团购产品', 'sms/comb/index', '67', '999', 'sms_comb', 'comb', b'0', b'0', null, '2020-06-24 16:41:29', null, '1'), ('143', b'0', '添加拼团产品', 'sms/comb/add', '67', '999', null, 'addcomb', b'0', b'1', null, '2020-06-24 17:12:41', null, '1'), ('144', b'0', '修改拼团产品', 'sms/comb/update', '67', '999', null, 'updatecomb', b'0', b'1', null, '2020-06-24 17:13:43', null, '1'), ('145', b'0', '门店管理', null, '0', '7', 'order-setting', 'store', b'0', b'0', null, '2020-06-25 11:07:22', null, '0'), ('146', b'0', '门店配置', 'shop/store/set/index', '145', '1', 'setting', 'storeset', b'0', b'0', null, '2020-06-25 11:10:35', null, '1'), ('147', b'0', '门店列表', 'shop/store/index', '145', '2', 'form', 'list', b'0', b'0', null, '2020-06-25 11:57:41', null, '1'), ('148', b'0', '店员列表', 'shop/store/staff/index', '145', '999', 'seting-account', 'staff', b'0', b'0', null, '2020-06-25 13:29:00', null, '1'), ('149', b'0', '首页设置', 'shop/homesetting', '134', '999', 'setting', 'shophomesetting', b'0', b'0', null, '2020-07-03 10:23:05', null, '1');
COMMIT;

-- ----------------------------
--  Table structure for `oms_cart_item`
-- ----------------------------
DROP TABLE IF EXISTS `oms_cart_item`;
CREATE TABLE `oms_cart_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL COMMENT '商品id',
  `product_sku_id` bigint(20) DEFAULT NULL COMMENT '商品SKUID',
  `member_id` bigint(20) DEFAULT NULL COMMENT '会员id',
  `quantity` int(11) DEFAULT NULL COMMENT '购买数量',
  `price` decimal(10,2) DEFAULT NULL COMMENT '添加到购物车的价格',
  `sp1` varchar(200) DEFAULT NULL COMMENT '销售属性1',
  `sp2` varchar(200) DEFAULT NULL COMMENT '销售属性2',
  `sp3` varchar(200) DEFAULT NULL COMMENT '销售属性3',
  `product_pic` varchar(1000) DEFAULT NULL COMMENT '商品主图',
  `product_name` varchar(500) DEFAULT NULL COMMENT '商品名称',
  `product_sub_title` varchar(500) DEFAULT NULL COMMENT '商品副标题（卖点）',
  `product_sku_code` varchar(200) DEFAULT NULL COMMENT '商品sku条码',
  `member_nickname` varchar(500) DEFAULT NULL COMMENT '会员昵称',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_status` int(11) DEFAULT '0' COMMENT '是否删除',
  `product_category_id` bigint(20) DEFAULT NULL COMMENT '商品分类',
  `product_brand` varchar(200) DEFAULT NULL,
  `product_sn` varchar(200) DEFAULT NULL,
  `product_attr` varchar(500) DEFAULT NULL COMMENT '商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]',
  `is_new` tinyint(1) DEFAULT '0' COMMENT '是否为立即购买',
  `combination_id` bigint(20) DEFAULT NULL COMMENT '拼团id',
  `seckill_id` bigint(20) DEFAULT NULL COMMENT '秒杀产品ID',
  `bargain_id` int(11) DEFAULT NULL COMMENT '砍价id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='购物车表';

-- ----------------------------
--  Records of `oms_cart_item`
-- ----------------------------
BEGIN;
INSERT INTO `oms_cart_item` VALUES ('1', '39', '158', '10', '2', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-09-03 13:16:07', null, '1', null, null, null, '3kg', '0', null, null, null), ('2', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-09-03 13:16:12', null, '1', null, null, null, '3kg', '0', null, null, null), ('3', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-09-03 14:23:22', null, '1', null, null, null, '3kg', '0', null, null, null), ('4', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-09-15 09:46:17', null, '1', null, null, null, '3kg', '0', null, null, null), ('5', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-09-15 09:55:03', null, '1', null, null, null, '3kg', '0', null, null, null), ('6', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-09-15 09:57:33', null, '1', null, null, null, '3kg', '0', null, null, null), ('7', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-09-15 14:17:27', null, '1', null, null, null, '3kg', '0', null, null, null), ('8', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-09-15 15:57:50', null, '1', null, null, null, '3kg', '0', null, null, null), ('9', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-09-16 14:43:22', null, '1', null, null, null, '3kg', '0', null, null, null), ('10', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-09-16 14:45:46', null, '1', null, null, null, '3kg', '0', null, null, null), ('11', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-09-16 14:48:39', null, '1', null, null, null, '3kg', '0', null, null, null), ('12', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-09-16 14:54:35', null, '1', null, null, null, '3kg', '0', null, null, null), ('13', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-09-16 14:57:40', null, '1', null, null, null, '3kg', '0', null, null, null), ('14', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-09-16 15:01:40', null, '1', null, null, null, '3kg', '0', null, null, null), ('15', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-09-16 15:01:54', null, '1', null, null, null, '3kg', '0', null, null, null), ('16', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-16 17:00:49', null, '1', null, null, null, '3kg', '0', null, null, null), ('17', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-16 17:12:33', null, '1', null, null, null, '3kg', '0', null, null, null), ('18', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-16 17:14:52', null, '1', null, null, null, '3kg', '0', null, null, null), ('19', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-16 17:20:27', null, '1', null, null, null, '3kg', '0', null, null, null), ('20', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-16 17:22:53', null, '1', null, null, null, '3kg', '0', null, null, null), ('21', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-16 17:31:07', null, '1', null, null, null, '3kg', '0', null, null, null), ('22', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-16 17:35:11', null, '1', null, null, null, '3kg', '0', null, null, null), ('23', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-16 17:36:27', null, '1', null, null, null, '3kg', '0', null, null, null), ('24', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-16 17:37:43', null, '1', null, null, null, '3kg', '0', null, null, null), ('25', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-16 17:44:32', null, '1', null, null, null, '3kg', '0', null, null, null), ('26', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-16 17:46:40', null, '1', null, null, null, '3kg', '0', null, null, null), ('27', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-16 17:51:53', null, '1', null, null, null, '3kg', '0', null, null, null), ('28', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-16 17:52:51', null, '1', null, null, null, '3kg', '0', null, null, null), ('29', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-16 17:57:00', null, '1', null, null, null, '3kg', '0', null, null, null), ('30', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-16 17:59:16', null, '1', null, null, null, '3kg', '0', null, null, null), ('31', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-16 18:00:16', null, '1', null, null, null, '3kg', '0', null, null, null), ('32', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-19 10:42:10', null, '1', null, null, null, '3kg', '0', null, null, null), ('33', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-19 11:49:07', null, '1', null, null, null, '3kg', '0', null, null, null), ('34', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-19 11:58:52', null, '1', null, null, null, '3kg', '0', null, null, null), ('35', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-19 12:01:36', null, '1', null, null, null, '3kg', '0', null, null, null), ('36', '39', '158', '10', '1', '0.01', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-19 14:42:15', null, '1', null, null, null, '3kg', '0', null, null, null), ('37', '37', '153', '10', '1', '15.80', '3kg', 'undefined', 'undefined', 'https://yoooho.bkbedu.com/mall/images/20191224/IMG_3848.JPG', '正宗广西砂糖桔', '新鲜当季水果沙糖桔5斤包邮', 'STJ0001', null, '2020-10-19 15:00:47', null, '1', null, null, null, '3kg', '0', null, null, null), ('38', '39', '158', '10', '1', '0.01', '3kg', 'null', 'null', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-22 10:35:44', null, '1', null, null, null, '3kg', '0', null, null, null), ('39', '39', '158', '10', '1', '0.01', '3kg', 'null', 'null', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-22 12:37:28', null, '1', null, null, null, '3kg', '0', null, null, null), ('40', '39', '158', '10', '1', '0.01', '3kg', 'null', 'null', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', '测试商品', '202001090039001', null, '2020-10-22 12:43:00', null, '1', null, null, null, '3kg', '0', null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `oms_company_address`
-- ----------------------------
DROP TABLE IF EXISTS `oms_company_address`;
CREATE TABLE `oms_company_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address_name` varchar(200) DEFAULT NULL COMMENT '地址名称',
  `send_status` int(11) DEFAULT NULL COMMENT '默认发货地址：0->否；1->是',
  `receive_status` int(11) DEFAULT NULL COMMENT '是否默认收货地址：0->否；1->是',
  `name` varchar(64) DEFAULT NULL COMMENT '收发货人姓名',
  `phone` varchar(64) DEFAULT NULL COMMENT '收货人电话',
  `province` varchar(64) DEFAULT NULL COMMENT '省/直辖市',
  `city` varchar(64) DEFAULT NULL COMMENT '市',
  `region` varchar(64) DEFAULT NULL COMMENT '区',
  `detail_address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='公司收发货地址表';

-- ----------------------------
--  Records of `oms_company_address`
-- ----------------------------
BEGIN;
INSERT INTO `oms_company_address` VALUES ('1', '深圳发货点', '1', '1', '大梨', '18000000000', '广东省', '深圳市', '南山区', '科兴科学园'), ('2', '北京发货点', '0', '0', '大梨', '18000000000', '北京市', null, '南山区', '科兴科学园'), ('3', '南京发货点', '0', '0', '大梨', '18000000000', '江苏省', '南京市', '南山区', '科兴科学园');
COMMIT;

-- ----------------------------
--  Table structure for `oms_logistic`
-- ----------------------------
DROP TABLE IF EXISTS `oms_logistic`;
CREATE TABLE `oms_logistic` (
  `id` int(10) unsigned NOT NULL,
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `eBusinessID` varchar(110) DEFAULT NULL,
  `orderCode` varchar(110) DEFAULT NULL,
  `logisticCode` varchar(110) DEFAULT NULL,
  `traces` text NOT NULL,
  `shipperCode` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `oms_order`
-- ----------------------------
DROP TABLE IF EXISTS `oms_order`;
CREATE TABLE `oms_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `member_id` bigint(20) NOT NULL COMMENT '成员id',
  `coupon_id` bigint(20) DEFAULT NULL,
  `order_sn` varchar(64) DEFAULT NULL COMMENT '订单编号',
  `create_time` datetime DEFAULT NULL COMMENT '提交时间',
  `member_username` varchar(64) DEFAULT NULL COMMENT '用户帐号',
  `total_amount` decimal(10,2) DEFAULT NULL COMMENT '订单总金额',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '应付金额（实际支付金额）',
  `freight_amount` decimal(10,2) DEFAULT NULL COMMENT '运费金额',
  `promotion_amount` decimal(10,2) DEFAULT NULL COMMENT '促销优化金额（促销价、满减、阶梯价）',
  `integration_amount` decimal(10,2) DEFAULT NULL COMMENT '积分抵扣金额',
  `coupon_amount` decimal(10,2) DEFAULT NULL COMMENT '优惠券抵扣金额',
  `discount_amount` decimal(10,2) DEFAULT NULL COMMENT '管理员后台调整订单使用的折扣金额',
  `pay_type` int(11) DEFAULT NULL COMMENT '支付方式：0->未支付；1->支付宝；2->微信',
  `pay_source` int(11) DEFAULT NULL COMMENT '0->支付宝；1->微信app;2->微信H5,3->微信小程序；4公众号',
  `source_type` int(11) DEFAULT NULL COMMENT '订单来源：0->网页订单；1->app订单;2微信小程序',
  `status` int(11) DEFAULT '0' COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
  `order_type` int(11) DEFAULT NULL COMMENT '订单类型：0->正常订单；1->秒杀订单',
  `delivery_company` varchar(64) DEFAULT NULL COMMENT '物流公司(配送方式)',
  `delivery_code` varchar(11) DEFAULT NULL,
  `delivery_sn` varchar(64) DEFAULT NULL COMMENT '物流单号',
  `auto_confirm_day` int(11) DEFAULT NULL COMMENT '自动确认时间（天）',
  `integration` int(11) DEFAULT NULL COMMENT '可以获得的积分',
  `growth` int(11) DEFAULT NULL COMMENT '可以活动的成长值',
  `promotion_info` varchar(100) DEFAULT NULL COMMENT '活动信息',
  `bill_type` int(11) DEFAULT NULL COMMENT '发票类型：0->不开发票；1->电子发票；2->纸质发票',
  `bill_header` varchar(200) DEFAULT NULL COMMENT '发票抬头',
  `bill_content` varchar(200) DEFAULT NULL COMMENT '发票内容',
  `bill_receiver_phone` varchar(32) DEFAULT NULL COMMENT '收票人电话',
  `bill_receiver_email` varchar(64) DEFAULT NULL COMMENT '收票人邮箱',
  `receiver_name` varchar(100) DEFAULT '' COMMENT '收货人姓名',
  `sender_name` varchar(100) DEFAULT NULL,
  `receiver_phone` varchar(32) DEFAULT '' COMMENT '收货人电话',
  `sender_phone` varchar(32) DEFAULT NULL,
  `sender_province` varchar(32) DEFAULT NULL,
  `receiver_post_code` varchar(32) DEFAULT NULL COMMENT '收货人邮编',
  `receiver_province` varchar(32) DEFAULT NULL COMMENT '省份/直辖市',
  `receiver_city` varchar(32) DEFAULT NULL COMMENT '城市',
  `sender_city` varchar(32) DEFAULT NULL,
  `receiver_region` varchar(32) DEFAULT NULL COMMENT '区',
  `sender_region` varchar(32) DEFAULT NULL,
  `receiver_detail_address` varchar(200) DEFAULT NULL COMMENT '详细地址',
  `sender_detail_address` varchar(200) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL COMMENT '订单备注',
  `confirm_status` int(11) DEFAULT NULL COMMENT '确认收货状态：0->未确认；1->已确认',
  `delete_status` int(11) NOT NULL DEFAULT '0' COMMENT '删除状态：0->未删除；1->已删除',
  `use_integration` int(11) DEFAULT NULL COMMENT '下单时使用的积分',
  `payment_time` datetime DEFAULT NULL COMMENT '支付时间',
  `delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
  `receive_time` datetime DEFAULT NULL COMMENT '确认收货时间',
  `comment_time` datetime DEFAULT NULL COMMENT '评价时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `outTradeNo` varchar(100) DEFAULT NULL,
  `member_delete_status` int(11) NOT NULL DEFAULT '0' COMMENT '会员删除状态：0->未删除；1->已删除',
  `out_refund_no` varchar(100) DEFAULT NULL COMMENT '退款流水号',
  `shopping_type` int(11) DEFAULT '1' COMMENT '配送方式 1=快递 ，2=门店自提',
  `face_pay` tinyint(1) DEFAULT '0',
  `pink_id` bigint(20) DEFAULT NULL COMMENT '拼团id 0没有拼团',
  `combination_id` bigint(20) DEFAULT NULL COMMENT '拼团产品id0一般产品',
  `bargain_id` bigint(20) DEFAULT NULL COMMENT '砍价id',
  `kill_id` bigint(20) DEFAULT NULL COMMENT '秒杀id',
  `store_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单表';

-- ----------------------------
--  Records of `oms_order`
-- ----------------------------
BEGIN;
INSERT INTO `oms_order` VALUES ('97', '10', '0', '20200716000195', '2020-07-16 15:07:18', '新用户', '158.00', '0.10', '0.00', '0.10', '0.00', '0.00', '0.00', '1', '0', '1', '2', '2', null, null, null, null, '10', '0', '开团活动', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '1', null, '2020-07-16 15:08:39', null, null, null, null, '2020071622001409501446608961', '0', null, '1', null, '97', '1', null, null, null), ('105', '18', '0', '20200716000203', '2020-07-16 16:26:50', '用户18', '158.00', '0.01', '0.00', '0.01', '0.00', '0.00', '0.00', '1', '0', '1', '2', '2', null, 'SF', '1111', null, '10', '0', '开团活动', null, null, null, null, null, 'yoooho', null, '17887153081', null, null, null, '北京市', '北京市', null, '东城区', null, '诗的远方', null, '', '0', '0', null, '2020-07-16 16:28:51', '2020-09-01 17:24:31', null, null, null, '2020071622001409501446556773', '0', null, '1', null, '97', '1', null, null, null), ('106', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '4', null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, '', null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, '0', null, '1', null, null, null, null, null, null), ('107', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '4', null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, '', null, null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null, null, null, null, '0', null, '1', null, null, null, null, null, null), ('108', '10', null, '20200903000001', '2020-09-03 13:16:12', '新用户', '0.01', null, '0.00', '0.00', null, '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', null, null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, null, '0', '0', null, null, null, null, null, null, null, '0', null, '1', null, null, null, null, null, null), ('109', '10', null, '20200903000002', '2020-09-03 14:23:23', '新用户', '0.01', null, '0.00', '0.00', null, '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', null, null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, null, '0', '0', null, null, null, null, null, null, null, '0', null, '1', null, null, null, null, null, null), ('110', '10', '0', '20200915000001', '2020-09-15 09:46:17', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, null, null, null, null, null, null, '0', null, '1', null, null, null, null, null, null), ('111', '10', '0', '20200915000002', '2020-09-15 09:55:03', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, null, null, null, null, null, null, '0', null, '1', null, null, null, null, null, null), ('112', '10', '0', '20200915000003', '2020-09-15 09:57:33', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, null, null, null, null, null, null, '0', null, '2', null, null, null, null, null, null), ('113', '10', '0', '20200915000001', '2020-09-15 14:17:27', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '0', null, '1', '2', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, null, null, null, null, null, null, '0', null, '2', '1', null, null, null, null, null), ('114', '10', '0', '20200915000002', '2020-09-15 15:57:50', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '0', null, '1', '2', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, null, null, null, null, null, null, '0', null, '2', '1', null, null, null, null, null), ('115', '10', null, '20200916000001', '2020-09-16 14:43:22', '新用户', '0.01', null, '0.00', '0.00', null, '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', null, null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, null, '0', '0', null, null, null, null, null, null, null, '0', null, '1', '0', null, null, null, null, null), ('116', '10', null, '20200916000002', '2020-09-16 14:43:51', '新用户', '0.02', null, '0.00', '0.00', null, '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', null, null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, null, '0', '0', null, null, null, null, null, null, null, '0', null, '1', '0', null, null, null, null, null), ('118', '10', null, '20200916000004', '2020-09-16 14:45:46', '新用户', '0.01', null, '0.00', '0.00', null, '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', null, null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, null, '0', '0', null, null, null, null, null, null, null, '0', null, '1', '0', null, null, null, null, null), ('122', '10', null, '20200916000008', '2020-09-16 14:48:39', '新用户', '0.01', null, '0.00', '0.00', null, '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', null, null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, null, '0', '1', null, null, null, null, null, null, null, '0', null, '1', '0', null, null, null, null, null), ('124', '10', null, '20200916000010', '2020-09-16 14:54:35', '新用户', '0.01', null, '0.00', '0.00', null, '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', null, null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, null, '0', '1', null, null, null, null, null, null, null, '0', null, '1', '0', null, null, null, null, null), ('125', '10', '0', '20200916000001', '2020-09-16 15:01:40', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '1', null, null, null, null, null, null, null, '0', null, '1', '0', null, null, null, null, '0'), ('126', '10', '0', '20200916000002', '2020-09-16 15:01:54', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '0', null, '1', '2', '0', '顺丰速运', 'SF', 'SF1110001223', null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, null, '2020-10-16 10:43:21', '2020-09-28 15:41:39', null, '2020-09-28 15:41:39', null, '0', null, '2', '1', null, null, null, null, '2'), ('127', '10', '0', '20201016000001', '2020-10-16 14:30:57', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, null, null, null, null, null, null, '0', null, '1', '0', null, null, null, null, '0'), ('128', '10', '0', '20201016000002', '2020-10-16 17:00:51', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '2', '2', '1', '1', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, '2020-10-16 17:35:28', null, null, null, null, '4200000772202010162813649250', '0', null, '1', '0', null, null, null, null, '0'), ('129', '10', '0', '20201016000003', '2020-10-16 17:12:36', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, null, null, null, null, null, null, '0', null, '1', '0', null, null, null, null, '0'), ('130', '10', '0', '20201016000004', '2020-10-16 17:14:53', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, null, null, null, null, null, null, '0', null, '1', '0', null, null, null, null, '0'), ('131', '10', '0', '20201016000005', '2020-10-16 17:20:28', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, null, null, null, null, null, null, '0', null, '1', '0', null, null, null, null, '0'), ('132', '10', '0', '20201016000006', '2020-10-16 17:22:56', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '2', '2', '1', '1', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, '2020-10-16 17:23:15', null, null, null, null, '4200000760202010161307788325', '0', null, '1', '0', null, null, null, null, '0'), ('133', '10', '0', '20201016000007', '2020-10-16 17:31:09', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '2', '2', '1', '1', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, '2020-10-16 17:31:22', null, null, null, null, '4200000758202010166047396471', '0', null, '1', '0', null, null, null, null, '0'), ('134', '10', '0', '20201016000008', '2020-10-16 17:35:14', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '2', '2', '1', '1', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, '2020-10-16 17:35:26', null, null, null, null, '4200000763202010169161904101', '0', null, '1', '0', null, null, null, null, '0'), ('135', '10', '0', '20201016000009', '2020-10-16 17:36:28', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '2', '2', '1', '1', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, '2020-10-16 17:36:43', null, null, null, null, '4200000764202010168347944727', '0', null, '1', '0', null, null, null, null, '0'), ('136', '10', '0', '20201016000010', '2020-10-16 17:37:44', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '2', '2', '1', '1', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, '2020-10-16 18:05:57', null, null, null, null, '4200000761202010167732047324', '0', null, '1', '0', null, null, null, null, '0'), ('137', '10', '0', '20201016000011', '2020-10-16 17:44:33', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '2', '2', '1', '1', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, '2020-10-16 17:45:11', null, null, null, null, '4200000762202010167895129525', '0', null, '1', '0', null, null, null, null, '0'), ('138', '10', '0', '20201016000012', '2020-10-16 17:46:42', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '2', '2', '1', '1', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, '2020-10-16 17:47:02', null, null, null, null, '4200000761202010165748757486', '0', null, '1', '0', null, null, null, null, '0'), ('139', '10', '0', '20201016000013', '2020-10-16 17:51:54', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '2', '2', '1', '1', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, '2020-10-16 17:52:11', null, null, null, null, '4200000765202010166981129323', '0', null, '1', '0', null, null, null, null, '0'), ('140', '10', '0', '20201016000014', '2020-10-16 17:52:53', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '2', '2', '1', '1', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, '2020-10-16 17:55:28', null, null, null, null, '4200000754202010162355175644', '0', null, '1', '0', null, null, null, null, '0'), ('141', '10', '0', '20201016000015', '2020-10-16 17:57:03', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '2', '2', '1', '1', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, '2020-10-16 17:57:18', null, null, null, null, '4200000759202010162248889108', '0', null, '1', '0', null, null, null, null, '0'), ('142', '10', '0', '20201016000016', '2020-10-16 17:59:17', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '2', '2', '1', '1', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, '2020-10-16 18:04:21', null, null, null, null, '4200000756202010166927949187', '0', null, '1', '0', null, null, null, null, '0'), ('143', '10', '0', '20201016000017', '2020-10-16 18:00:18', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '2', '2', '1', '1', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, '2020-10-16 18:03:03', null, null, null, null, '4200000768202010169991303567', '0', null, '1', '0', null, null, null, null, '0'), ('144', '10', '0', '20201019000001', '2020-10-19 10:42:14', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, null, null, null, null, null, null, '0', null, '1', '0', null, null, null, null, '0'), ('145', '10', '0', '20201019000002', '2020-10-19 11:49:13', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, null, null, null, null, null, null, '0', null, '1', '0', null, null, null, null, '0'), ('146', '10', '0', '20201019000003', '2020-10-19 11:58:54', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, null, null, null, null, null, null, '0', null, '1', '0', null, null, null, null, '0'), ('147', '10', '0', '20201019000004', '2020-10-19 12:01:39', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '2', '2', '1', '2', '0', '圆通速递', 'YTO', '11111111', null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, '2020-10-19 12:01:54', '2020-10-19 16:01:58', null, null, null, '4200000755202010198759803014', '0', null, '1', '0', null, null, null, null, '0'), ('148', '10', '0', '20201019000005', '2020-10-19 14:42:18', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '2', '3', '1', '2', '0', '顺丰速运', 'SF', '1112222111', null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, '2020-10-19 15:00:24', '2020-10-19 15:41:03', null, null, null, '4200000756202010191999662300', '0', null, '1', '0', null, null, null, null, '0'), ('149', '10', '0', '20201019000006', '2020-10-19 15:00:50', '新用户', '15.80', '15.80', '0.00', '0.00', '0.00', '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, null, null, null, null, null, null, '0', null, '1', '0', null, null, null, null, '0'), ('150', '10', '0', '20201022000001', '2020-10-22 10:35:46', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, null, null, null, null, null, null, '0', null, '1', '0', null, null, null, null, '0'), ('151', '10', '0', '20201022000002', '2020-10-22 12:37:29', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, null, null, null, null, null, null, '0', null, '1', '0', null, null, null, null, '0'), ('152', '10', '0', '20201022000003', '2020-10-22 12:43:08', '新用户', '0.01', '0.01', '0.00', '0.00', '0.00', '0.00', '0.00', '0', null, '1', '4', '0', null, null, null, null, '0', '0', '无优惠', null, null, null, null, null, '赵阳', null, '18125255678', null, null, null, '北京市', '北京市', null, '东城区', null, 'CoCo都可(阳光鑫隆店)', null, '', '0', '0', null, null, null, null, null, null, null, '0', null, '1', '0', null, null, null, null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `oms_order_comment`
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_comment`;
CREATE TABLE `oms_order_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `oid` bigint(20) NOT NULL COMMENT '订单ID',
  `unique` varchar(32) NOT NULL COMMENT '唯一id',
  `product_id` bigint(20) NOT NULL COMMENT '产品id',
  `reply_type` int(11) NOT NULL COMMENT '某种商品类型(普通商品、秒杀商品',
  `product_score` tinyint(1) NOT NULL COMMENT '商品分数',
  `service_score` tinyint(1) NOT NULL COMMENT '服务分数',
  `comment` varchar(521) NOT NULL COMMENT '评论内容',
  `pics` text NOT NULL COMMENT '评论图片',
  `add_time` datetime NOT NULL COMMENT '评论时间',
  `merchant_reply_content` varchar(300) DEFAULT NULL COMMENT '管理员回复内容',
  `merchant_reply_time` datetime DEFAULT NULL COMMENT '管理员回复时间',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0未删除1已删除',
  `is_reply` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0未回复1已回复',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单评论';

-- ----------------------------
--  Table structure for `oms_order_face`
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_face`;
CREATE TABLE `oms_order_face` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` bigint(11) DEFAULT NULL,
  `order_sn` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `pay_amount` decimal(11,2) DEFAULT NULL,
  `member_id` bigint(11) DEFAULT NULL,
  `rq_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `oms_order_face`
-- ----------------------------
BEGIN;
INSERT INTO `oms_order_face` VALUES ('1', '113', '20200915000001', '2020-09-15 14:19:28', null, '10', 'mall/images/20200915000001.PNG'), ('2', '114', '20200915000002', '2020-09-15 15:58:03', null, '10', 'mall/images/20200915000002.PNG'), ('3', '126', '20200916000002', '2020-09-16 15:02:17', null, '10', 'https://yoooho.bkbedu.com/mall/images/orderface_20200916000002.PNG');
COMMIT;

-- ----------------------------
--  Table structure for `oms_order_item`
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_item`;
CREATE TABLE `oms_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
  `order_sn` varchar(64) DEFAULT NULL COMMENT '订单编号',
  `product_id` bigint(20) DEFAULT NULL,
  `product_pic` varchar(500) DEFAULT NULL,
  `product_name` varchar(200) DEFAULT NULL,
  `product_brand` varchar(200) DEFAULT NULL,
  `product_sn` varchar(64) DEFAULT NULL,
  `product_price` decimal(10,2) DEFAULT NULL COMMENT '销售价格',
  `product_quantity` int(11) DEFAULT NULL COMMENT '购买数量',
  `product_sku_id` bigint(20) DEFAULT NULL COMMENT '商品sku编号',
  `product_sku_code` varchar(50) DEFAULT NULL COMMENT '商品sku条码',
  `product_category_id` bigint(20) DEFAULT NULL COMMENT '商品分类id',
  `sp1` varchar(100) DEFAULT NULL COMMENT '商品的销售属性',
  `sp2` varchar(100) DEFAULT NULL,
  `sp3` varchar(100) DEFAULT NULL,
  `promotion_name` varchar(200) DEFAULT NULL COMMENT '商品促销名称',
  `promotion_amount` decimal(10,2) DEFAULT NULL COMMENT '商品促销分解金额',
  `coupon_amount` decimal(10,2) DEFAULT NULL COMMENT '优惠券优惠分解金额',
  `integration_amount` decimal(10,2) DEFAULT NULL COMMENT '积分优惠分解金额',
  `real_amount` decimal(10,2) DEFAULT NULL COMMENT '该商品经过优惠后的分解金额',
  `gift_integration` int(11) DEFAULT '0',
  `gift_growth` int(11) DEFAULT '0',
  `product_attr` varchar(500) DEFAULT NULL COMMENT '商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]',
  `kill_id` bigint(20) DEFAULT NULL COMMENT '秒杀id',
  `pink_id` bigint(20) DEFAULT NULL COMMENT '拼团id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单中所包含的商品';

-- ----------------------------
--  Records of `oms_order_item`
-- ----------------------------
BEGIN;
INSERT INTO `oms_order_item` VALUES ('26', '97', '20200716000195', '40', 'https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525553.jpg', '当季孕妇水果现摘大连车厘子2斤拼团', null, null, '158.00', '1', null, null, null, null, null, null, '开团活动', '0.10', '0.00', '0.00', '0.10', '10', '0', null, null, '1'), ('34', '105', '20200716000203', '40', 'https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525553.jpg', '当季孕妇水果现摘大连车厘子2斤拼团', null, null, '158.00', '1', null, null, null, null, null, null, '开团活动', '0.01', '0.00', '0.00', '0.01', '10', '0', null, null, '1'), ('35', '108', '20200903000001', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('36', '109', '20200903000002', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('37', '110', '20200915000001', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('38', '111', '20200915000002', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('39', '112', '20200915000003', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('40', '113', '20200915000001', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('41', '114', '20200915000002', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('42', '115', '20200916000001', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('43', '116', '20200916000002', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '2', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('44', '118', '20200916000004', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('45', '122', '20200916000008', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('46', '124', '20200916000010', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('47', '125', '20200916000001', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('48', '126', '20200916000002', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('49', '127', '20201016000001', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('50', '128', '20201016000002', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('51', '129', '20201016000003', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('52', '130', '20201016000004', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('53', '131', '20201016000005', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('54', '132', '20201016000006', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('55', '133', '20201016000007', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('56', '134', '20201016000008', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('57', '135', '20201016000009', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('58', '136', '20201016000010', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('59', '137', '20201016000011', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('60', '138', '20201016000012', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('61', '139', '20201016000013', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('62', '140', '20201016000014', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('63', '141', '20201016000015', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('64', '142', '20201016000016', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('65', '143', '20201016000017', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('66', '144', '20201019000001', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('67', '145', '20201019000002', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('68', '146', '20201019000003', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('69', '147', '20201019000004', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('70', '148', '20201019000005', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('71', '149', '20201019000006', '37', 'https://yoooho.bkbedu.com/mall/images/20191224/IMG_3848.JPG', '正宗广西砂糖桔', null, null, '15.80', '1', '153', 'STJ0001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '15.80', '0', '0', '3kg', null, null), ('72', '150', '20201022000001', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('73', '151', '20201022000002', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null), ('74', '152', '20201022000003', '39', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '测试商品', null, null, '0.01', '1', '158', '202001090039001', null, null, null, null, '无优惠', '0.00', '0.00', '0.00', '0.01', '0', '0', '3kg', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `oms_order_operate_history`
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_operate_history`;
CREATE TABLE `oms_order_operate_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
  `operate_man` varchar(100) DEFAULT NULL COMMENT '操作人：用户；系统；后台管理员',
  `create_time` datetime DEFAULT NULL COMMENT '操作时间',
  `order_status` int(11) DEFAULT NULL COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单操作历史记录';

-- ----------------------------
--  Records of `oms_order_operate_history`
-- ----------------------------
BEGIN;
INSERT INTO `oms_order_operate_history` VALUES ('5', '12', '后台管理员', '2018-10-12 14:01:29', '2', '完成发货'), ('6', '13', '后台管理员', '2018-10-12 14:01:29', '2', '完成发货'), ('7', '12', '后台管理员', '2018-10-12 14:13:10', '4', '订单关闭:买家退货'), ('8', '13', '后台管理员', '2018-10-12 14:13:10', '4', '订单关闭:买家退货'), ('9', '22', '后台管理员', '2018-10-15 16:31:48', '4', '订单关闭:xxx'), ('10', '22', '后台管理员', '2018-10-15 16:35:08', '4', '订单关闭:xxx'), ('11', '22', '后台管理员', '2018-10-15 16:35:59', '4', '订单关闭:xxx'), ('12', '17', '后台管理员', '2018-10-15 16:43:40', '4', '订单关闭:xxx'), ('13', '25', '后台管理员', '2018-10-15 16:52:14', '4', '订单关闭:xxx'), ('14', '26', '后台管理员', '2018-10-15 16:52:14', '4', '订单关闭:xxx'), ('15', '23', '后台管理员', '2018-10-16 14:41:28', '2', '完成发货'), ('16', '13', '后台管理员', '2018-10-16 14:42:17', '2', '完成发货'), ('17', '18', '后台管理员', '2018-10-16 14:42:17', '2', '完成发货'), ('18', '26', '后台管理员', '2018-10-30 14:37:44', '4', '订单关闭:关闭订单'), ('19', '25', '后台管理员', '2018-10-30 15:07:01', '0', '修改收货人信息'), ('20', '25', '后台管理员', '2018-10-30 15:08:13', '0', '修改费用信息'), ('21', '25', '后台管理员', '2018-10-30 15:08:31', '0', '修改备注信息：xxx'), ('22', '25', '后台管理员', '2018-10-30 15:08:39', '4', '订单关闭:2222'), ('23', '72', '后台管理员', '2020-01-05 21:41:50', '4', '订单关闭:退款'), ('24', '82', '后台管理员', '2020-01-06 14:18:17', '4', '订单关闭:订单异常'), ('25', '81', '后台管理员', '2020-01-06 14:18:25', '4', '订单关闭:订单异常'), ('26', '80', '后台管理员', '2020-01-06 14:18:28', '4', '订单关闭:订单异常'), ('27', '83', '后台管理员', '2020-01-06 14:27:44', '4', '订单关闭:退款'), ('28', '84', '后台管理员', '2020-01-06 14:58:07', '4', '订单关闭:退款'), ('29', '88', '后台管理员', '2020-01-13 13:24:29', '2', '完成发货'), ('30', '95', '后台管理员', '2020-01-17 10:29:58', '2', '完成发货'), ('31', '94', '后台管理员', '2020-01-17 15:59:41', '2', '完成发货'), ('32', '93', '后台管理员', '2020-01-17 16:01:37', '2', '完成发货'), ('33', '89', '后台管理员', '2020-01-20 10:58:31', '2', '完成发货'), ('34', '92', '后台管理员', '2020-01-20 11:00:42', '2', '完成发货'), ('35', '106', '后台管理员', '2020-09-01 15:19:38', '4', '订单关闭:订单关闭'), ('36', null, '后台管理员', '2020-09-01 17:14:55', '2', '完成发货'), ('37', null, '后台管理员', '2020-09-01 17:16:36', '2', '完成发货'), ('38', null, '后台管理员', '2020-09-01 17:22:52', '2', '完成发货'), ('39', '105', '后台管理员', '2020-09-01 17:24:32', '2', '完成发货'), ('40', '107', '后台管理员', '2020-09-02 10:40:57', '4', '订单关闭:订单关闭'), ('41', '126', '后台管理员', '2020-10-16 10:41:25', '2', '完成发货'), ('42', '126', '后台管理员', '2020-10-16 10:43:21', '2', '完成发货'), ('43', '148', '后台管理员', '2020-10-19 15:41:04', '2', '完成发货'), ('44', '147', '后台管理员', '2020-10-19 16:01:58', '2', '完成发货');
COMMIT;

-- ----------------------------
--  Table structure for `oms_order_refund`
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_refund`;
CREATE TABLE `oms_order_refund` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL,
  `order_sn` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `member_username` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT '0' COMMENT '0->未退款；1->退款中；2->已退款；3-已取消',
  `handle_time` datetime DEFAULT NULL,
  `reason` varchar(200) DEFAULT NULL,
  `return_amount` decimal(10,2) DEFAULT NULL,
  `handle_man` varchar(64) DEFAULT NULL,
  `handle_id` bigint(20) DEFAULT NULL,
  `refund_sn` varchar(11) DEFAULT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  `refund_mode` int(11) DEFAULT NULL COMMENT '1.线下退款，2平台退款',
  `refund_route` int(11) DEFAULT NULL COMMENT '1.支付宝，2微信',
  `out_refund_no` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='退款订单';

-- ----------------------------
--  Records of `oms_order_refund`
-- ----------------------------
BEGIN;
INSERT INTO `oms_order_refund` VALUES ('1', '143', '20201016000017', '2020-10-20 10:23:47', 'yoooho', '1', null, '测试', '0.01', null, null, null, '10', null, null, null), ('2', '142', '20201016000016', '2020-10-20 11:21:40', 'yoooho', '1', null, 'ces', '0.01', null, null, null, '10', null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `oms_order_return_apply`
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_return_apply`;
CREATE TABLE `oms_order_return_apply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
  `company_address_id` bigint(20) DEFAULT NULL COMMENT '收货地址表id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '退货商品id',
  `order_sn` varchar(64) DEFAULT NULL COMMENT '订单编号',
  `create_time` datetime DEFAULT NULL COMMENT '申请时间',
  `member_username` varchar(64) DEFAULT NULL COMMENT '会员用户名',
  `return_amount` decimal(10,2) DEFAULT NULL COMMENT '退款金额',
  `return_name` varchar(100) DEFAULT NULL COMMENT '退货人姓名',
  `return_phone` varchar(100) DEFAULT NULL COMMENT '退货人电话',
  `status` int(11) DEFAULT NULL COMMENT '申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝',
  `return_pay_status` int(11) DEFAULT '0' COMMENT '退款状态：0未退款，1已退款,2退款中，3退款失败',
  `handle_time` datetime DEFAULT NULL COMMENT '处理时间',
  `product_pic` varchar(500) DEFAULT NULL COMMENT '商品图片',
  `product_name` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `product_brand` varchar(200) DEFAULT NULL COMMENT '商品品牌',
  `product_attr` varchar(500) DEFAULT NULL COMMENT '商品销售属性：颜色：红色；尺码：xl;',
  `product_count` int(11) DEFAULT NULL COMMENT '退货数量',
  `product_price` decimal(10,2) DEFAULT NULL COMMENT '商品单价',
  `product_real_price` decimal(10,2) DEFAULT NULL COMMENT '商品实际支付单价',
  `reason` varchar(200) DEFAULT NULL COMMENT '原因',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `proof_pics` varchar(1000) DEFAULT NULL COMMENT '凭证图片，以逗号隔开',
  `handle_note` varchar(500) DEFAULT NULL COMMENT '处理备注',
  `handle_man` varchar(100) DEFAULT NULL COMMENT '处理人员',
  `receive_man` varchar(100) DEFAULT NULL COMMENT '收货人',
  `receive_time` datetime DEFAULT NULL COMMENT '收货时间',
  `receive_note` varchar(500) DEFAULT NULL COMMENT '收货备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单退货申请';

-- ----------------------------
--  Table structure for `oms_order_return_reason`
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_return_reason`;
CREATE TABLE `oms_order_return_reason` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '退货类型',
  `sort` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '状态：0->不启用；1->启用',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='退货原因表';

-- ----------------------------
--  Records of `oms_order_return_reason`
-- ----------------------------
BEGIN;
INSERT INTO `oms_order_return_reason` VALUES ('1', '质量问题', '1', '0', '2018-10-17 10:00:45'), ('2', '尺码太大', '1', '1', '2018-10-17 10:01:03'), ('3', '颜色不喜欢', '1', '1', '2018-10-17 10:01:13'), ('4', '7天无理由退货', '1', '1', '2018-10-17 10:01:47'), ('5', '价格问题', '1', '0', '2018-10-17 10:01:57'), ('12', '发票问题', '0', '1', '2018-10-19 16:28:36'), ('13', '其他问题', '0', '1', '2018-10-19 16:28:51'), ('14', '物流问题', '0', '1', '2018-10-19 16:29:01'), ('15', '售后问题', '0', '1', '2018-10-19 16:29:11');
COMMIT;

-- ----------------------------
--  Table structure for `oms_order_setting`
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_setting`;
CREATE TABLE `oms_order_setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `flash_order_overtime` int(11) DEFAULT NULL COMMENT '秒杀订单超时关闭时间(分)',
  `normal_order_overtime` int(11) DEFAULT NULL COMMENT '正常订单超时时间(分)',
  `confirm_overtime` int(11) DEFAULT NULL COMMENT '发货后自动确认收货时间（天）',
  `finish_overtime` int(11) DEFAULT NULL COMMENT '自动完成交易时间，不能申请售后（天）',
  `comment_overtime` int(11) DEFAULT NULL COMMENT '订单完成后自动好评时间（天）',
  `pink_order_overtime` int(11) DEFAULT NULL COMMENT '拼团订单超时关闭时间(分)',
  `pink_done_overtime` int(11) DEFAULT NULL COMMENT '拼团订单未完成超时',
  `pink_effect_overtime` int(11) DEFAULT NULL COMMENT '拼团有效时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单设置表';

-- ----------------------------
--  Records of `oms_order_setting`
-- ----------------------------
BEGIN;
INSERT INTO `oms_order_setting` VALUES ('1', '60', '120', '15', '7', '7', '60', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `oms_pink`
-- ----------------------------
DROP TABLE IF EXISTS `oms_pink`;
CREATE TABLE `oms_pink` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cid` bigint(20) DEFAULT NULL COMMENT '拼团产品id',
  `pid` bigint(20) DEFAULT NULL COMMENT '产品id',
  `people` int(11) DEFAULT NULL COMMENT '拼图总人数',
  `price` decimal(10,2) DEFAULT NULL COMMENT '拼团产品单价',
  `add_time` bigint(20) DEFAULT NULL COMMENT '开始时间',
  `stop_time` bigint(20) DEFAULT NULL COMMENT '结束时间',
  `k_id` bigint(20) DEFAULT NULL COMMENT '团长id',
  `status` int(11) DEFAULT NULL COMMENT '状态0未开始，1进行中2已完成3未完成',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='拼团表';

-- ----------------------------
--  Records of `oms_pink`
-- ----------------------------
BEGIN;
INSERT INTO `oms_pink` VALUES ('97', '1', '40', '2', '158.00', '1594883319029', '1594973411000', '10', '2', '97');
COMMIT;

-- ----------------------------
--  Table structure for `oms_pink_buyer`
-- ----------------------------
DROP TABLE IF EXISTS `oms_pink_buyer`;
CREATE TABLE `oms_pink_buyer` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `buyer_id` bigint(20) DEFAULT NULL COMMENT '买家ID',
  `pink_id` bigint(20) DEFAULT NULL COMMENT '团购ID',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单ID',
  `pink_num` int(11) DEFAULT NULL COMMENT '团购数量',
  `pink_price` decimal(12,2) DEFAULT NULL COMMENT '团购价格',
  `pink_amt` decimal(12,2) DEFAULT NULL COMMENT '团购金额',
  `pink_status` tinyint(1) DEFAULT NULL COMMENT '状态(1完成 -0取消)',
  `pink_time` bigint(11) DEFAULT NULL COMMENT '团购时间',
  `is_refund` tinyint(1) DEFAULT NULL COMMENT '是否退款 0未退款 1已退款',
  `is_tpl` tinyint(1) DEFAULT NULL COMMENT '是否发送模板消息0未发送1已发送',
  `buyer_name` varchar(255) DEFAULT NULL COMMENT '买家名字',
  `buyer_icon` varchar(255) DEFAULT '' COMMENT '买家头像',
  `pay_status` int(11) DEFAULT NULL COMMENT '支付状态：0待支付， 1已支付',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='团购买家表';

-- ----------------------------
--  Records of `oms_pink_buyer`
-- ----------------------------
BEGIN;
INSERT INTO `oms_pink_buyer` VALUES ('41', '10', '97', '97', '1', '0.10', '0.10', '1', '1594883324', '0', '0', 'yoooho', '', '1'), ('49', '18', '97', '105', '1', '0.01', '0.01', '1', '1594888130', '0', '0', '17887513081', '', '1');
COMMIT;

-- ----------------------------
--  Table structure for `pms_album`
-- ----------------------------
DROP TABLE IF EXISTS `pms_album`;
CREATE TABLE `pms_album` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `cover_pic` varchar(1000) DEFAULT NULL,
  `pic_count` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='相册表';

-- ----------------------------
--  Table structure for `pms_album_pic`
-- ----------------------------
DROP TABLE IF EXISTS `pms_album_pic`;
CREATE TABLE `pms_album_pic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `album_id` bigint(20) DEFAULT NULL,
  `pic` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='画册图片表';

-- ----------------------------
--  Table structure for `pms_brand`
-- ----------------------------
DROP TABLE IF EXISTS `pms_brand`;
CREATE TABLE `pms_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `first_letter` varchar(8) DEFAULT NULL COMMENT '首字母',
  `sort` int(11) DEFAULT NULL,
  `factory_status` int(11) DEFAULT NULL COMMENT '是否为品牌制造商：0->不是；1->是',
  `show_status` int(11) DEFAULT NULL,
  `product_count` int(11) DEFAULT NULL COMMENT '产品数量',
  `product_comment_count` int(11) DEFAULT NULL COMMENT '产品评论数量',
  `logo` varchar(255) DEFAULT NULL COMMENT '品牌logo',
  `big_pic` varchar(255) DEFAULT NULL COMMENT '专区大图',
  `brand_story` text COMMENT '品牌故事',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='品牌表';

-- ----------------------------
--  Records of `pms_brand`
-- ----------------------------
BEGIN;
INSERT INTO `pms_brand` VALUES ('1', '万和', 'W', '0', '1', '0', '100', '100', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg(5).jpg', '', 'Victoria\'s Secret的故事'), ('2', '三星', 'S', '100', '1', '0', '100', '100', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg (1).jpg', null, '三星的故事'), ('3', '华为', 'H', '100', '1', '0', '100', '100', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/17f2dd9756d9d333bee8e60ce8c03e4c_222_222.jpg', null, 'Victoria\'s Secret的故事'), ('4', '格力', 'G', '30', '1', '0', '100', '100', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/dc794e7e74121272bbe3ce9bc41ec8c3_222_222.jpg', null, 'Victoria\'s Secret的故事'), ('5', '方太', 'F', '20', '1', '0', '100', '100', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg (4).jpg', null, 'Victoria\'s Secret的故事'), ('6', '小米', 'M', '500', '1', '0', '100', '100', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/1e34aef2a409119018a4c6258e39ecfb_222_222.png', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180518/5afd7778Nf7800b75.jpg', '小米手机的故事'), ('21', 'OPPO', 'O', '0', '1', '0', '88', '500', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg(6).jpg', '', 'string'), ('49', '七匹狼', 'S', '200', '1', '0', '77', '400', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/18d8bc3eb13533fab466d702a0d3fd1f40345bcd.jpg', null, 'BOOB的故事'), ('50', '海澜之家', 'H', '200', '1', '0', '66', '300', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/99d3279f1029d32b929343b09d3c72de_222_222.jpg', '', '海澜之家的故事'), ('51', '苹果', 'A', '200', '1', '1', '55', '200', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', null, '苹果的故事'), ('58', 'NIKE', 'N', '0', '1', '1', '33', '100', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/timg (51).jpg', '', 'NIKE的故事'), ('59', '砂糖桔', '砂', '0', '0', '0', null, null, 'http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191223/MTAwMHgw.jpeg', '', ''), ('60', '水果', 'SG', '0', '0', '0', null, null, 'https://yoooho.bkbedu.com/mall/images/20200425/u=2427097497,1425821937&fm=26&gp=0.jpg', '', '');
COMMIT;

-- ----------------------------
--  Table structure for `pms_comment`
-- ----------------------------
DROP TABLE IF EXISTS `pms_comment`;
CREATE TABLE `pms_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `member_nick_name` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `star` int(11) DEFAULT NULL COMMENT '评价星数：0->5',
  `member_ip` varchar(64) DEFAULT NULL COMMENT '评价的ip',
  `create_time` datetime DEFAULT NULL,
  `show_status` int(11) DEFAULT NULL,
  `product_attribute` varchar(255) DEFAULT NULL COMMENT '购买时的商品属性',
  `collect_couont` int(11) DEFAULT NULL,
  `read_count` int(11) DEFAULT NULL,
  `content` text,
  `pics` varchar(1000) DEFAULT NULL COMMENT '上传图片地址，以逗号隔开',
  `member_icon` varchar(255) DEFAULT NULL COMMENT '评论用户头像',
  `replay_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品评价表';

-- ----------------------------
--  Table structure for `pms_comment_replay`
-- ----------------------------
DROP TABLE IF EXISTS `pms_comment_replay`;
CREATE TABLE `pms_comment_replay` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment_id` bigint(20) DEFAULT NULL,
  `member_nick_name` varchar(255) DEFAULT NULL,
  `member_icon` varchar(255) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '评论人员类型；0->会员；1->管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='产品评价回复表';

-- ----------------------------
--  Table structure for `pms_feight_template`
-- ----------------------------
DROP TABLE IF EXISTS `pms_feight_template`;
CREATE TABLE `pms_feight_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `charge_type` int(11) DEFAULT NULL COMMENT '计费类型:0->按重量；1->按件数',
  `first_weight` decimal(10,2) DEFAULT NULL COMMENT '首重kg',
  `first_fee` decimal(10,2) DEFAULT NULL COMMENT '首费（元）',
  `continue_weight` decimal(10,2) DEFAULT NULL,
  `continme_fee` decimal(10,2) DEFAULT NULL,
  `dest` varchar(255) DEFAULT NULL COMMENT '目的地（省、市）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='运费模版';

-- ----------------------------
--  Table structure for `pms_member_price`
-- ----------------------------
DROP TABLE IF EXISTS `pms_member_price`;
CREATE TABLE `pms_member_price` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `member_level_id` bigint(20) DEFAULT NULL,
  `member_price` decimal(10,2) DEFAULT NULL COMMENT '会员价格',
  `member_level_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=372 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品会员价格表';

-- ----------------------------
--  Records of `pms_member_price`
-- ----------------------------
BEGIN;
INSERT INTO `pms_member_price` VALUES ('26', '7', '1', '500.00', null), ('27', '8', '1', '500.00', null), ('28', '9', '1', '500.00', null), ('29', '10', '1', '500.00', null), ('30', '11', '1', '500.00', null), ('31', '12', '1', '500.00', null), ('32', '13', '1', '500.00', null), ('33', '14', '1', '500.00', null), ('37', '18', '1', '500.00', null), ('44', '7', '2', '480.00', null), ('45', '7', '3', '450.00', null), ('52', '22', '1', null, null), ('53', '22', '2', null, null), ('54', '22', '3', null, null), ('58', '24', '1', null, null), ('59', '24', '2', null, null), ('60', '24', '3', null, null), ('112', '23', '1', '88.00', '黄金会员'), ('113', '23', '2', '88.00', '白金会员'), ('114', '23', '3', '66.00', '钻石会员'), ('142', '31', '1', null, '黄金会员'), ('143', '31', '2', null, '白金会员'), ('144', '31', '3', null, '钻石会员'), ('148', '32', '1', null, '黄金会员'), ('149', '32', '2', null, '白金会员'), ('150', '32', '3', null, '钻石会员'), ('154', '33', '1', null, '黄金会员'), ('155', '33', '2', null, '白金会员'), ('156', '33', '3', null, '钻石会员'), ('169', '36', '1', null, '黄金会员'), ('170', '36', '2', null, '白金会员'), ('171', '36', '3', null, '钻石会员'), ('172', '35', '1', null, '黄金会员'), ('173', '35', '2', null, '白金会员'), ('174', '35', '3', null, '钻石会员'), ('175', '34', '1', null, '黄金会员'), ('176', '34', '2', null, '白金会员'), ('177', '34', '3', null, '钻石会员'), ('178', '30', '1', null, '黄金会员'), ('179', '30', '2', null, '白金会员'), ('180', '30', '3', null, '钻石会员'), ('195', '28', '1', null, '黄金会员'), ('196', '28', '2', null, '白金会员'), ('197', '28', '3', null, '钻石会员'), ('198', '29', '1', null, '黄金会员'), ('199', '29', '2', null, '白金会员'), ('200', '29', '3', null, '钻石会员'), ('201', '27', '1', null, '黄金会员'), ('202', '27', '2', null, '白金会员'), ('203', '27', '3', null, '钻石会员'), ('246', '37', '1', null, '黄金会员'), ('247', '37', '2', null, '白金会员'), ('248', '37', '3', null, '钻石会员'), ('249', '38', '1', null, '黄金会员'), ('250', '38', '2', null, '白金会员'), ('251', '38', '3', null, '钻石会员'), ('252', '39', '1', null, '黄金会员'), ('253', '39', '2', null, '白金会员'), ('254', '39', '3', null, '钻石会员'), ('276', '41', '1', null, '黄金会员'), ('277', '41', '2', null, '白金会员'), ('278', '41', '3', null, '钻石会员'), ('279', '42', '1', null, '黄金会员'), ('280', '42', '2', null, '白金会员'), ('281', '42', '3', null, '钻石会员'), ('282', '43', '1', null, '黄金会员'), ('283', '43', '2', null, '白金会员'), ('284', '43', '3', null, '钻石会员'), ('285', '44', '1', null, '黄金会员'), ('286', '44', '2', null, '白金会员'), ('287', '44', '3', null, '钻石会员'), ('288', '45', '1', null, '黄金会员'), ('289', '45', '2', null, '白金会员'), ('290', '45', '3', null, '钻石会员'), ('291', '46', '1', null, '黄金会员'), ('292', '46', '2', null, '白金会员'), ('293', '46', '3', null, '钻石会员'), ('294', '47', '1', null, '黄金会员'), ('295', '47', '2', null, '白金会员'), ('296', '47', '3', null, '钻石会员'), ('297', '48', '1', null, '黄金会员'), ('298', '48', '2', null, '白金会员'), ('299', '48', '3', null, '钻石会员'), ('300', '49', '1', null, '黄金会员'), ('301', '49', '2', null, '白金会员'), ('302', '49', '3', null, '钻石会员'), ('303', '50', '1', null, '黄金会员'), ('304', '50', '2', null, '白金会员'), ('305', '50', '3', null, '钻石会员'), ('306', '51', '1', null, '黄金会员'), ('307', '51', '2', null, '白金会员'), ('308', '51', '3', null, '钻石会员'), ('309', '52', '1', null, '黄金会员'), ('310', '52', '2', null, '白金会员'), ('311', '52', '3', null, '钻石会员'), ('312', '53', '1', null, '黄金会员'), ('313', '53', '2', null, '白金会员'), ('314', '53', '3', null, '钻石会员'), ('315', '54', '1', null, '黄金会员'), ('316', '54', '2', null, '白金会员'), ('317', '54', '3', null, '钻石会员'), ('318', '55', '1', null, '黄金会员'), ('319', '55', '2', null, '白金会员'), ('320', '55', '3', null, '钻石会员'), ('321', '56', '1', null, '黄金会员'), ('322', '56', '2', null, '白金会员'), ('323', '56', '3', null, '钻石会员'), ('324', '57', '1', null, '黄金会员'), ('325', '57', '2', null, '白金会员'), ('326', '57', '3', null, '钻石会员'), ('327', '58', '1', null, '黄金会员'), ('328', '58', '2', null, '白金会员'), ('329', '58', '3', null, '钻石会员'), ('336', '40', '1', null, '黄金会员'), ('337', '40', '2', null, '白金会员'), ('338', '40', '3', null, '钻石会员'), ('339', '59', '1', null, '黄金会员'), ('340', '59', '2', null, '白金会员'), ('341', '59', '3', null, '钻石会员'), ('342', '60', '1', null, '黄金会员'), ('343', '60', '2', null, '白金会员'), ('344', '60', '3', null, '钻石会员'), ('345', '61', '1', null, '黄金会员'), ('346', '61', '2', null, '白金会员'), ('347', '61', '3', null, '钻石会员'), ('348', '62', '1', null, '黄金会员'), ('349', '62', '2', null, '白金会员'), ('350', '62', '3', null, '钻石会员'), ('351', '63', '1', null, '黄金会员'), ('352', '63', '2', null, '白金会员'), ('353', '63', '3', null, '钻石会员'), ('354', '64', '1', null, '黄金会员'), ('355', '64', '2', null, '白金会员'), ('356', '64', '3', null, '钻石会员'), ('357', '65', '1', null, '黄金会员'), ('358', '65', '2', null, '白金会员'), ('359', '65', '3', null, '钻石会员'), ('360', '66', '1', null, '黄金会员'), ('361', '66', '2', null, '白金会员'), ('362', '66', '3', null, '钻石会员'), ('363', '67', '1', null, '黄金会员'), ('364', '67', '2', null, '白金会员'), ('365', '67', '3', null, '钻石会员'), ('369', '26', '1', null, '黄金会员'), ('370', '26', '2', null, '白金会员'), ('371', '26', '3', null, '钻石会员');
COMMIT;

-- ----------------------------
--  Table structure for `pms_product`
-- ----------------------------
DROP TABLE IF EXISTS `pms_product`;
CREATE TABLE `pms_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_id` bigint(20) DEFAULT NULL,
  `product_category_id` bigint(20) DEFAULT NULL,
  `feight_template_id` bigint(20) DEFAULT NULL,
  `product_attribute_category_id` bigint(20) DEFAULT NULL,
  `name` varchar(64) NOT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `product_sn` varchar(64) NOT NULL COMMENT '货号',
  `delete_status` int(11) DEFAULT NULL COMMENT '删除状态：0->未删除；1->已删除',
  `publish_status` int(11) DEFAULT NULL COMMENT '上架状态：0->下架；1->上架',
  `new_status` int(11) DEFAULT NULL COMMENT '新品状态:0->不是新品；1->新品',
  `recommand_status` int(11) DEFAULT NULL COMMENT '推荐状态；0->不推荐；1->推荐',
  `verify_status` int(11) DEFAULT NULL COMMENT '审核状态：0->未审核；1->审核通过',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `sale` int(11) DEFAULT NULL COMMENT '销量',
  `price` decimal(10,2) DEFAULT NULL,
  `promotion_price` decimal(10,2) DEFAULT NULL COMMENT '促销价格',
  `gift_growth` int(11) DEFAULT '0' COMMENT '赠送的成长值',
  `gift_point` int(11) DEFAULT '0' COMMENT '赠送的积分',
  `use_point_limit` int(11) DEFAULT NULL COMMENT '限制使用的积分数',
  `sub_title` varchar(255) DEFAULT NULL COMMENT '副标题',
  `description` text COMMENT '商品描述',
  `original_price` decimal(10,2) DEFAULT NULL COMMENT '市场价',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `low_stock` int(11) DEFAULT NULL COMMENT '库存预警值',
  `unit` varchar(16) DEFAULT NULL COMMENT '单位',
  `weight` decimal(10,2) DEFAULT NULL COMMENT '商品重量，默认为克',
  `preview_status` int(11) DEFAULT NULL COMMENT '是否为预告商品：0->不是；1->是',
  `service_ids` varchar(64) DEFAULT NULL COMMENT '以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮',
  `keywords` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `album_pics` text COMMENT '画册图片，连产品图片限制为5张，以逗号分割',
  `detail_title` varchar(255) DEFAULT NULL,
  `detail_desc` text,
  `detail_html` text COMMENT '产品详情网页内容',
  `detail_mobile_html` text COMMENT '移动端网页详情',
  `promotion_start_time` datetime DEFAULT NULL COMMENT '促销开始时间',
  `promotion_end_time` datetime DEFAULT NULL COMMENT '促销结束时间',
  `promotion_per_limit` int(11) DEFAULT NULL COMMENT '活动限购数量',
  `promotion_type` int(11) DEFAULT NULL COMMENT '促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购',
  `brand_name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `product_category_name` varchar(255) DEFAULT NULL COMMENT '商品分类名称',
  `mer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品信息';

-- ----------------------------
--  Records of `pms_product`
-- ----------------------------
BEGIN;
INSERT INTO `pms_product` VALUES ('1', '49', '7', '0', '0', '银色星芒刺绣网纱底裤', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '1', '1', '1', '1', '100', '0', '100.00', null, '0', '100', null, '111', '111', '120.00', '100', '20', '件', '1000.00', '0', null, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', null, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', null, null, null, '0', '七匹狼', '外套', null), ('2', '49', '7', '0', '0', '银色星芒刺绣网纱底裤2', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86578', '1', '1', '1', '1', '1', '1', '0', '100.00', null, '0', '100', null, '111', '111', '120.00', '100', '20', '件', '1000.00', '0', null, '银色星芒刺绣网纱底裤2', '银色星芒刺绣网纱底裤', null, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '<p>银色星芒刺绣网纱底裤</p>', '<p>银色星芒刺绣网纱底裤</p>', null, null, null, '0', '七匹狼', '外套', null), ('3', '1', '7', '0', '0', '银色星芒刺绣网纱底裤3', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86579', '1', '1', '1', '1', '1', '1', '0', '100.00', null, '0', '100', null, '111', '111', '120.00', '100', '20', '件', '1000.00', '0', null, '银色星芒刺绣网纱底裤3', '银色星芒刺绣网纱底裤', null, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', null, null, null, '0', '万和', '外套', null), ('4', '1', '7', '0', '0', '银色星芒刺绣网纱底裤4', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86580', '1', '1', '1', '1', '1', '1', '0', '100.00', null, '0', '100', null, '111', '111', '120.00', '100', '20', '件', '1000.00', '0', null, '银色星芒刺绣网纱底裤4', '银色星芒刺绣网纱底裤', null, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', null, null, null, '0', '万和', '外套', null), ('5', '1', '7', '0', '0', '银色星芒刺绣网纱底裤5', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86581', '1', '0', '1', '1', '1', '1', '0', '100.00', null, '0', '100', null, '111', '111', '120.00', '100', '20', '件', '1000.00', '0', null, '银色星芒刺绣网纱底裤5', '银色星芒刺绣网纱底裤', null, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', null, null, null, '0', '万和', '外套', null), ('6', '1', '7', '0', '0', '银色星芒刺绣网纱底裤6', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86582', '1', '1', '1', '1', '1', '1', '0', '100.00', null, '0', '100', null, '111', '111', '120.00', '100', '20', '件', '1000.00', '0', null, '银色星芒刺绣网纱底裤6', '银色星芒刺绣网纱底裤', null, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', null, null, null, '0', '万和', '外套', null), ('7', '1', '7', '0', '1', '女式超柔软拉毛运动开衫', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '0', '0', '0', '0', '0', '0', '249.00', '0.00', '0', '100', '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', '299.00', '100', '0', '件', '0.00', '0', 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', '万和', '外套', null), ('8', '1', '7', '0', '1', '女式超柔软拉毛运动开衫1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '0', '0', '0', '0', '0', '0', '249.00', '0.00', '0', '100', '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', '299.00', '100', '0', '件', '0.00', '0', 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', '万和', '外套', null), ('9', '1', '7', '0', '1', '女式超柔软拉毛运动开衫1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '0', '0', '0', '0', '0', '0', '249.00', '0.00', '0', '100', '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', '299.00', '100', '0', '件', '0.00', '0', 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', '万和', '外套', null), ('10', '1', '7', '0', '1', '女式超柔软拉毛运动开衫1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '0', '0', '0', '0', '0', '0', '249.00', '0.00', '0', '100', '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', '299.00', '100', '0', '件', '0.00', '0', 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', '万和', '外套', null), ('11', '1', '7', '0', '1', '女式超柔软拉毛运动开衫1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '1', '0', '1', '0', '0', '0', '249.00', '0.00', '0', '100', '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', '299.00', '100', '0', '件', '0.00', '0', 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', '万和', '外套', null), ('12', '1', '7', '0', '1', '女式超柔软拉毛运动开衫2', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '1', '0', '1', '0', '0', '0', '249.00', '0.00', '0', '100', '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', '299.00', '100', '0', '件', '0.00', '0', 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', '万和', '外套', null), ('13', '1', '7', '0', '1', '女式超柔软拉毛运动开衫3', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '1', '0', '1', '0', '0', '0', '249.00', '0.00', '0', '100', '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', '299.00', '100', '0', '件', '0.00', '0', 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', '万和', '外套', null), ('14', '1', '7', '0', '1', '女式超柔软拉毛运动开衫3', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '0', '0', '1', '0', '0', '0', '249.00', '0.00', '0', '100', '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', '299.00', '100', '0', '件', '0.00', '0', 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', '万和', '外套', null), ('18', '1', '7', '0', '1', '女式超柔软拉毛运动开衫3', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', '1', '0', '0', '1', '0', '0', '0', '249.00', '0.00', '0', '100', '0', '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', '299.00', '100', '0', '件', '0.00', '0', 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', '0', '0', '万和', '外套', null), ('22', '6', '7', '0', '1', 'test', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', '', '1', '1', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', 'test', '', '0.00', '100', '0', '', '0.00', '1', '1,2', '', '', '', '', '', '', '', null, null, '0', '0', '小米', '外套', null), ('23', '6', '19', '0', '1', '毛衫测试', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', 'NO.1098', '1', '1', '1', '1', '0', '0', '0', '99.00', null, '99', '99', '1000', '毛衫测试11', 'xxx', '109.00', '100', '0', '件', '1000.00', '1', '1,2,3', '毛衫测试', '毛衫测试', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg,http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', '毛衫测试', '毛衫测试', '<p><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/155x54.bmp\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/APP登录bg1080.jpg\" width=\"500\" height=\"500\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/APP登录界面.jpg\" width=\"500\" height=\"500\" /></p>', '', null, null, '0', '2', '小米', '手机通讯', null), ('24', '6', '7', '0', null, 'xxx', '', '', '1', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', 'xxx', '', '0.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '小米', '外套', null), ('26', '3', '19', '0', '3', '华为 HUAWEI P20 ', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', '6946605', '0', '1', '0', '1', '0', '100', '0', '3788.00', null, '3788', '3788', '0', 'AI智慧全面屏 6GB +64GB 亮黑色 全网通版 移动联通电信4G手机 双卡双待手机 双卡双待', '', '4288.00', '1000', '0', '件', '0.00', '1', '2,3,1', '', '', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ab46a3cN616bdc41.jpg,http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf5fN2522b9dc.jpg', '', '', '<p><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad44f1cNf51f3bb0.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad44fa8Nfcf71c10.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad44fa9N40e78ee0.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad457f4N1c94bdda.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad457f5Nd30de41d.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5b10fb0eN0eb053fb.jpg\" /></p>', '', null, null, '0', '1', '华为', '手机通讯', null), ('27', '6', '19', '0', '3', '小米8 全面屏游戏智能手机 6GB+64GB 黑色 全网通4G 双卡双待', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', '7437788', '0', '0', '0', '0', '0', '0', '0', '2699.00', null, '2699', '2699', '0', '骁龙845处理器，红外人脸解锁，AI变焦双摄，AI语音助手小米6X低至1299，点击抢购', '小米8 全面屏游戏智能手机 6GB+64GB 黑色 全网通4G 双卡双待', '2699.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '<p><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b2254e8N414e6d3a.jpg\" width=\"500\" /></p>', '', null, null, '0', '3', '小米', '手机通讯', null), ('28', '6', '19', '0', '3', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '7437789', '0', '0', '1', '0', '0', '0', '0', '649.00', null, '649', '649', '0', '8天超长待机，137g轻巧机身，高通骁龙处理器小米6X低至1299，点击抢购', '', '649.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '4', '小米', '手机通讯', null), ('29', '51', '19', '0', '3', 'Apple iPhone 8 Plus 64GB 红色特别版 移动联通电信4G手机', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5acc5248N6a5f81cd.jpg', '7437799', '0', '0', '0', '0', '0', '0', '0', '5499.00', null, '5499', '5499', '0', '【限时限量抢购】Apple产品年中狂欢节，好物尽享，美在智慧！速来 >> 勾选[保障服务][原厂保2年]，获得AppleCare+全方位服务计划，原厂延保售后无忧。', '', '5499.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '苹果', '手机通讯', null), ('30', '50', '8', '0', '1', 'HLA海澜之家简约动物印花短袖T恤', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5ad83a4fN6ff67ecd.jpg!cc_350x449.jpg', 'HNTBJ2E042A', '0', '0', '0', '0', '0', '0', '0', '98.00', null, '0', '0', '0', '2018夏季新品微弹舒适新款短T男生 6月6日-6月20日，满300减30，参与互动赢百元礼券，立即分享赢大奖', '', '98.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '海澜之家', 'T恤', null), ('31', '50', '8', '0', '1', 'HLA海澜之家蓝灰花纹圆领针织布短袖T恤', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5ac98b64N70acd82f.jpg!cc_350x449.jpg', 'HNTBJ2E080A', '0', '0', '0', '0', '0', '0', '0', '98.00', null, '0', '0', '0', '2018夏季新品短袖T恤男HNTBJ2E080A 蓝灰花纹80 175/92A/L80A 蓝灰花纹80 175/92A/L', '', '98.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '海澜之家', 'T恤', null), ('32', '50', '8', '0', null, 'HLA海澜之家短袖T恤男基础款', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a51eb88Na4797877.jpg', 'HNTBJ2E153A', '0', '0', '0', '0', '0', '0', '0', '68.00', null, '0', '0', '0', 'HLA海澜之家短袖T恤男基础款简约圆领HNTBJ2E153A藏青(F3)175/92A(50)', '', '68.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '海澜之家', 'T恤', null), ('33', '6', '35', '0', null, '小米（MI）小米电视4A ', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b02804dN66004d73.jpg', '4609652', '0', '0', '0', '0', '0', '0', '0', '2499.00', null, '0', '0', '0', '小米（MI）小米电视4A 55英寸 L55M5-AZ/L55M5-AD 2GB+8GB HDR 4K超高清 人工智能网络液晶平板电视', '', '2499.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '小米', '手机数码', null), ('34', '6', '35', '0', null, '小米（MI）小米电视4A 65英寸', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b028530N51eee7d4.jpg', '4609660', '0', '0', '0', '0', '0', '0', '0', '3999.00', null, '0', '0', '0', ' L65M5-AZ/L65M5-AD 2GB+8GB HDR 4K超高清 人工智能网络液晶平板电视', '', '3999.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '小米', '手机数码', null), ('35', '58', '29', '0', null, '耐克NIKE 男子 休闲鞋 ROSHE RUN 运动鞋 511881-010黑色41码', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b235bb9Nf606460b.jpg', '6799342', '0', '0', '0', '0', '0', '0', '0', '369.00', null, '0', '0', '0', '耐克NIKE 男子 休闲鞋 ROSHE RUN 运动鞋 511881-010黑色41码', '', '369.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', 'NIKE', '男鞋', null), ('36', '58', '29', '0', null, '耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b19403eN9f0b3cb8.jpg', '6799345', '0', '0', '0', '1', '0', '0', '0', '499.00', null, '0', '0', '0', '耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码', '', '499.00', '100', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', 'NIKE', '男鞋', null), ('37', '59', '55', '0', '11', '正宗广西砂糖桔', 'https://yoooho.bkbedu.com/mall/images/20191224/IMG_3848.JPG', '20191212301', '0', '1', '1', '1', '0', '0', '0', '27.80', null, '0', '0', '0', '新鲜当季水果沙糖桔5斤包邮', '', '0.00', '100000', '0', '件', '5000.00', '1', '3', '砂糖桔', '', 'https://yoooho.bkbedu.com/mall/images/20191224/IMG_3846.JPG,https://yoooho.bkbedu.com/mall/images/20191224/IMG_3847.JPG,https://yoooho.bkbedu.com/mall/images/20191224/IMG_3851.JPG,https://yoooho.bkbedu.com/mall/images/20191224/IMG_3852.JPG', '正宗广西砂糖桔10斤', '正宗广西砂糖桔10斤', '<p><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3853.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3854.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3855.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3856.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3857.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3858.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3859.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3860.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3861.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3862.JPG\" /></p>', '<p><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3853.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3854.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3855.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3856.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3857.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3858.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3859.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3860.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3861.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3862.JPG\" /></p>', null, null, '0', '0', '砂糖桔', '桔子', null), ('38', '51', '54', '0', '13', '新鲜红富士苹果10斤当季整箱', 'https://yoooho.bkbedu.com/mall/images/20191224/IMG_3876.JPG', '2020010801', '0', '1', '1', '1', '0', '0', '0', '44.80', null, '0', '0', '0', '新鲜红富士苹果', '', '0.00', '0', '0', '', '5000.00', '0', '', '', '', 'https://yoooho.bkbedu.com/mall/images/20191224/IMG_3872.JPG,https://yoooho.bkbedu.com/mall/images/20191224/IMG_3873.JPG,https://yoooho.bkbedu.com/mall/images/20191224/IMG_3874.JPG,https://yoooho.bkbedu.com/mall/images/20191224/IMG_3875.JPG', '', '', '<p><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3877.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3883.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3880.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3879.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3878.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3882.JPG\" /></p>', '', null, null, '0', '0', '苹果', '苹果', null), ('39', '6', '53', '0', '11', '测试商品', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '20200109001', '0', '1', '0', '0', '0', '0', '28', '0.01', null, '0', '0', '0', '测试商品', '测试商品', '0.01', '100', '0', '', '0.00', '0', '1,2,3', '', '', 'https://yoooho.bkbedu.com/mall/images/20200109/1024x1024.png', '', '', '', '', null, null, '0', '0', '小米', '水果集市', null), ('40', '60', '61', '0', '14', '', 'https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525553.jpg', '202004251457', '0', '1', '1', '1', '0', '0', '0', '99.00', null, '10', '10', '0', '新鲜车厘子大果', '', '158.00', '100000000', '0', '斤', '10000.00', '0', '3', '孕妇水果，新鲜水果', '', 'https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525552.jpg,https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525551.jpg,https://yoooho.bkbedu.com/mall/images/20200425/微信图片_20200425152555.jpg', '', '', '<p><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_20200425152316.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523161.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523162.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523163.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523164.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_20200425153015.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523165.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523166.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523167.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523168.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523169.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231610.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231611.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231615.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231612.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231613.jpg\" /></p>', '', null, null, '0', '0', '水果', '车厘子/樱桃', null), ('41', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('42', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('43', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('44', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('45', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('46', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('47', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('48', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('49', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('50', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('51', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('52', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('53', null, null, '0', '14', '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('54', null, null, '0', '14', '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('55', null, null, '0', '14', '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('56', null, null, '0', '14', '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('57', null, null, '0', '14', '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('58', null, null, '0', '14', '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('59', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('60', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('61', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('62', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('63', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('64', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('65', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('66', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null), ('67', null, null, '0', null, '', '', '', '0', '0', '0', '0', '0', '0', '0', '0.00', null, '0', '0', '0', '', '', '0.00', '0', '0', '', '0.00', '0', '', '', '', '', '', '', '', '', null, null, '0', '0', '', '', null);
COMMIT;

-- ----------------------------
--  Table structure for `pms_product_attribute`
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attribute`;
CREATE TABLE `pms_product_attribute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_attribute_category_id` bigint(20) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `select_type` int(11) DEFAULT NULL COMMENT '属性选择类型：0->唯一；1->单选；2->多选',
  `input_type` int(11) DEFAULT NULL COMMENT '属性录入方式：0->手工录入；1->从列表中选取',
  `input_list` varchar(255) DEFAULT NULL COMMENT '可选值列表，以逗号隔开',
  `sort` int(11) DEFAULT NULL COMMENT '排序字段：最高的可以单独上传图片',
  `filter_type` int(11) DEFAULT NULL COMMENT '分类筛选样式：1->普通；1->颜色',
  `search_type` int(11) DEFAULT NULL COMMENT '检索类型；0->不需要进行检索；1->关键字检索；2->范围检索',
  `related_status` int(11) DEFAULT NULL COMMENT '相同属性产品是否关联；0->不关联；1->关联',
  `hand_add_status` int(11) DEFAULT NULL COMMENT '是否支持手动新增；0->不支持；1->支持',
  `type` int(11) DEFAULT NULL COMMENT '属性的类型；0->规格；1->参数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品属性参数表';

-- ----------------------------
--  Records of `pms_product_attribute`
-- ----------------------------
BEGIN;
INSERT INTO `pms_product_attribute` VALUES ('1', '1', '尺寸', '2', '1', 'M,X,XL,2XL,3XL,4XL', '0', '0', '0', '0', '0', '0'), ('7', '1', '颜色', '2', '1', '黑色,红色,白色,粉色', '100', '0', '0', '0', '1', '0'), ('13', '0', '上市年份', '1', '1', '2013年,2014年,2015年,2016年,2017年', '0', '0', '0', '0', '0', '1'), ('14', '0', '上市年份1', '1', '1', '2013年,2014年,2015年,2016年,2017年', '0', '0', '0', '0', '0', '1'), ('15', '0', '上市年份2', '1', '1', '2013年,2014年,2015年,2016年,2017年', '0', '0', '0', '0', '0', '1'), ('16', '0', '上市年份3', '1', '1', '2013年,2014年,2015年,2016年,2017年', '0', '0', '0', '0', '0', '1'), ('17', '0', '上市年份4', '1', '1', '2013年,2014年,2015年,2016年,2017年', '0', '0', '0', '0', '0', '1'), ('18', '0', '上市年份5', '1', '1', '2013年,2014年,2015年,2016年,2017年', '0', '0', '0', '0', '0', '1'), ('19', '0', '适用对象', '1', '1', '青年女性,中年女性', '0', '0', '0', '0', '0', '1'), ('20', '0', '适用对象1', '2', '1', '青年女性,中年女性', '0', '0', '0', '0', '0', '1'), ('21', '0', '适用对象3', '2', '1', '青年女性,中年女性', '0', '0', '0', '0', '0', '1'), ('24', '1', '商品编号', '1', '0', '', '0', '0', '0', '0', '0', '1'), ('25', '1', '适用季节', '1', '1', '春季,夏季,秋季,冬季', '0', '0', '0', '0', '0', '1'), ('32', '2', '适用人群', '0', '1', '老年,青年,中年', '0', '0', '0', '0', '0', '1'), ('33', '2', '风格', '0', '1', '嘻哈风格,基础大众,商务正装', '0', '0', '0', '0', '0', '1'), ('35', '2', '颜色', '0', '0', '', '100', '0', '0', '0', '1', '0'), ('37', '1', '适用人群', '1', '1', '儿童,青年,中年,老年', '0', '0', '0', '0', '0', '1'), ('38', '1', '上市时间', '1', '1', '2017年秋,2017年冬,2018年春,2018年夏', '0', '0', '0', '0', '0', '1'), ('39', '1', '袖长', '1', '1', '短袖,长袖,中袖', '0', '0', '0', '0', '0', '1'), ('40', '2', '尺码', '0', '1', '29,30,31,32,33,34', '0', '0', '0', '0', '0', '0'), ('41', '2', '适用场景', '0', '1', '居家,运动,正装', '0', '0', '0', '0', '0', '1'), ('42', '2', '上市时间', '0', '1', '2018年春,2018年夏', '0', '0', '0', '0', '0', '1'), ('43', '3', '颜色', '0', '0', '', '100', '0', '0', '0', '1', '0'), ('44', '3', '容量', '0', '1', '16G,32G,64G,128G', '0', '0', '0', '0', '0', '0'), ('45', '3', '屏幕尺寸', '0', '0', '', '0', '0', '0', '0', '0', '1'), ('46', '3', '网络', '0', '1', '3G,4G', '0', '0', '0', '0', '0', '1'), ('47', '3', '系统', '0', '1', 'Android,IOS', '0', '0', '0', '0', '0', '1'), ('48', '3', '电池容量', '0', '0', '', '0', '0', '0', '0', '0', '1'), ('49', '11', '重量', '0', '0', '3kg,5kg,10kg', '0', '0', '0', '0', '0', '0'), ('53', '11', '重量', '0', '0', '3斤,5斤,10斤', '0', '0', '0', '0', '1', '1'), ('55', '13', '重量(不含箱)', '0', '0', '9斤', '0', '0', '0', '0', '0', '0'), ('56', '13', '苹果直径', '0', '0', '80mm-85mm,85mm-90mm', '0', '0', '0', '0', '0', '0'), ('57', '14', '净重', '0', '0', '500g,1000g,1500g,2500g', '0', '0', '0', '0', '0', '0'), ('58', '14', '单果规格', '0', '0', '4J,jj,5J,J,3J', '0', '0', '0', '0', '0', '0');
COMMIT;

-- ----------------------------
--  Table structure for `pms_product_attribute_category`
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attribute_category`;
CREATE TABLE `pms_product_attribute_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `attribute_count` int(11) DEFAULT '0' COMMENT '属性数量',
  `param_count` int(11) DEFAULT '0' COMMENT '参数数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='产品属性分类表';

-- ----------------------------
--  Records of `pms_product_attribute_category`
-- ----------------------------
BEGIN;
INSERT INTO `pms_product_attribute_category` VALUES ('1', '服装-T恤', '2', '5'), ('2', '服装-裤装', '2', '4'), ('3', '手机数码-手机通讯', '2', '4'), ('4', '配件', '0', '0'), ('5', '居家', '0', '0'), ('6', '洗护', '0', '0'), ('11', '砂糖桔', '1', '1'), ('13', '苹果', '2', '0'), ('14', '车厘子', '2', '0');
COMMIT;

-- ----------------------------
--  Table structure for `pms_product_attribute_value`
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attribute_value`;
CREATE TABLE `pms_product_attribute_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `product_attribute_id` bigint(20) DEFAULT NULL,
  `value` varchar(64) DEFAULT NULL COMMENT '手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=264 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='存储产品参数信息的表';

-- ----------------------------
--  Records of `pms_product_attribute_value`
-- ----------------------------
BEGIN;
INSERT INTO `pms_product_attribute_value` VALUES ('1', '9', '1', 'X'), ('2', '10', '1', 'X'), ('3', '11', '1', 'X'), ('4', '12', '1', 'X'), ('5', '13', '1', 'X'), ('6', '14', '1', 'X'), ('7', '18', '1', 'X'), ('8', '7', '1', 'X'), ('9', '7', '1', 'XL'), ('10', '7', '1', 'XXL'), ('11', '22', '7', 'x,xx'), ('12', '22', '24', 'no110'), ('13', '22', '25', '春季'), ('14', '22', '37', '青年'), ('15', '22', '38', '2018年春'), ('16', '22', '39', '长袖'), ('124', '23', '7', '米白色,浅黄色'), ('125', '23', '24', 'no1098'), ('126', '23', '25', '春季'), ('127', '23', '37', '青年'), ('128', '23', '38', '2018年春'), ('129', '23', '39', '长袖'), ('130', '1', '13', null), ('131', '1', '14', null), ('132', '1', '15', null), ('133', '1', '16', null), ('134', '1', '17', null), ('135', '1', '18', null), ('136', '1', '19', null), ('137', '1', '20', null), ('138', '1', '21', null), ('139', '2', '13', null), ('140', '2', '14', null), ('141', '2', '15', null), ('142', '2', '16', null), ('143', '2', '17', null), ('144', '2', '18', null), ('145', '2', '19', null), ('146', '2', '20', null), ('147', '2', '21', null), ('183', '31', '24', null), ('184', '31', '25', '夏季'), ('185', '31', '37', '青年'), ('186', '31', '38', '2018年夏'), ('187', '31', '39', '短袖'), ('198', '30', '24', null), ('199', '30', '25', '夏季'), ('200', '30', '37', '青年'), ('201', '30', '38', '2018年夏'), ('202', '30', '39', '短袖'), ('218', '28', '43', '金色,银色'), ('219', '28', '45', '5.0'), ('220', '28', '46', '4G'), ('221', '28', '47', 'Android'), ('222', '28', '48', '2800ml'), ('223', '29', '43', '金色,银色'), ('224', '29', '45', '4.7'), ('225', '29', '46', '4G'), ('226', '29', '47', 'IOS'), ('227', '29', '48', '1960ml'), ('228', '27', '43', '黑色,蓝色'), ('229', '27', '45', '5.8'), ('230', '27', '46', '4G'), ('231', '27', '47', 'Android'), ('232', '27', '48', '3000ml'), ('252', '37', '53', ''), ('253', '39', '53', null), ('259', '26', '43', '金色,银色'), ('260', '26', '45', '5.0'), ('261', '26', '46', '4G'), ('262', '26', '47', 'Android'), ('263', '26', '48', '3000');
COMMIT;

-- ----------------------------
--  Table structure for `pms_product_category`
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_category`;
CREATE TABLE `pms_product_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上机分类的编号：0表示一级分类',
  `name` varchar(64) DEFAULT NULL,
  `level` int(11) DEFAULT NULL COMMENT '分类级别：0->1级；1->2级',
  `product_count` int(11) DEFAULT NULL,
  `product_unit` varchar(64) DEFAULT NULL,
  `nav_status` int(11) DEFAULT NULL COMMENT '是否显示在导航栏：0->不显示；1->显示',
  `show_status` int(11) DEFAULT NULL COMMENT '显示状态：0->不显示；1->显示',
  `sort` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `keywords` varchar(255) DEFAULT NULL,
  `description` text COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='产品分类';

-- ----------------------------
--  Records of `pms_product_category`
-- ----------------------------
BEGIN;
INSERT INTO `pms_product_category` VALUES ('1', '0', '服装', '0', '100', '件', '0', '1', '1', null, '服装', '服装分类'), ('2', '0', '手机数码', '0', '100', '件', '0', '1', '1', null, '手机数码', '手机数码'), ('3', '0', '家用电器', '0', '100', '件', '0', '0', '1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/subject_cate_jiadian.png', '家用电器', '家用电器'), ('4', '0', '家具家装', '0', '100', '件', '0', '0', '1', null, '家具家装', '家具家装'), ('5', '0', '汽车用品', '0', '100', '件', '0', '0', '1', null, '汽车用品', '汽车用品'), ('7', '1', '外套', '1', '100', '件', '0', '1', '0', 'https://yoooho.bkbedu.com/mall/images/20191231/cate14.jpg', '外套', '外套'), ('8', '1', 'T恤', '1', '100', '件', '0', '1', '0', 'https://yoooho.bkbedu.com/mall/images/20191231/cate13.jpg', 'T恤', 'T恤'), ('9', '1', '休闲裤', '1', '100', '件', '0', '1', '0', 'https://yoooho.bkbedu.com/mall/images/20191231/a8f3d8202d108541c91e5c61bb9519e1.jpg', '休闲裤', '休闲裤'), ('10', '1', '牛仔裤', '1', '100', '件', '0', '1', '0', 'https://yoooho.bkbedu.com/mall/images/20191231/u=1378932079,2504369177&fm=26&gp=0.jpg', '牛仔裤', '牛仔裤'), ('11', '1', '衬衫', '1', '100', '件', '0', '1', '0', 'https://yoooho.bkbedu.com/mall/images/20191231/9a43ba535061c3e6b12227afa3628716.jpg', '衬衫', '衬衫分类'), ('13', '12', '家电子分类1', '1', '1', 'string', '0', '1', '0', 'string', 'string', 'string'), ('14', '12', '家电子分类2', '1', '1', 'string', '0', '1', '0', 'string', 'string', 'string'), ('19', '2', '手机通讯', '1', '0', '件', '0', '1', '0', 'https://yoooho.bkbedu.com/mall/images/20191231/309882ffaa3ccff54ac204fadd157c41.jpg', '手机通讯', '手机通讯'), ('29', '1', '男鞋', '1', '0', '', '0', '1', '0', 'https://yoooho.bkbedu.com/mall/images/20191231/2e89edd68104574d6c75ae0cb9656c42.jpg', '', ''), ('30', '2', '手机配件', '1', '0', '', '0', '1', '0', 'https://yoooho.bkbedu.com/mall/images/20191231/690aa6392ad3abc69631a9f6762bcf3a.jpg', '手机配件', '手机配件'), ('31', '2', '摄影摄像', '1', '0', '', '0', '1', '0', 'https://yoooho.bkbedu.com/mall/images/20191231/816e1ab5763a718212a61328ba423939.jpg', '', ''), ('32', '2', '影音娱乐', '1', '0', '', '0', '1', '0', 'https://yoooho.bkbedu.com/mall/images/20191231/6e7a5b6fd8d716fb4b626951cb6f5733.jpg', '', ''), ('33', '2', '数码配件', '1', '0', '', '0', '1', '0', 'https://yoooho.bkbedu.com/mall/images/20191231/2546f18c211eaca6c557353b5477c22c.jpg', '', ''), ('34', '2', '智能设备', '1', '0', '', '0', '1', '0', 'https://yoooho.bkbedu.com/mall/images/20191231/7c70fabfb74640149676adbd184c64ba.jpg', '', ''), ('35', '3', '电视', '1', '0', '', '0', '0', '0', '', '', ''), ('36', '3', '空调', '1', '0', '', '0', '0', '0', '', '', ''), ('37', '3', '洗衣机', '1', '0', '', '0', '0', '0', '', '', ''), ('38', '3', '冰箱', '1', '0', '', '0', '0', '0', '', '', ''), ('39', '3', '厨卫大电', '1', '0', '', '0', '0', '0', '', '', ''), ('40', '3', '厨房小电', '1', '0', '', '0', '0', '0', '', '', ''), ('41', '3', '生活电器', '1', '0', '', '0', '0', '0', '', '', ''), ('42', '3', '个护健康', '1', '0', '', '0', '0', '0', '', '', ''), ('43', '4', '厨房卫浴', '1', '0', '', '0', '0', '0', '', '', ''), ('44', '4', '灯饰照明', '1', '0', '', '0', '0', '0', '', '', ''), ('45', '4', '五金工具', '1', '0', '', '0', '0', '0', '', '', ''), ('46', '4', '卧室家具', '1', '0', '', '0', '0', '0', '', '', ''), ('47', '4', '客厅家具', '1', '0', '', '0', '0', '0', '', '', ''), ('48', '5', '全新整车', '1', '0', '', '0', '0', '0', '', '', ''), ('49', '5', '车载电器', '1', '0', '', '0', '0', '0', '', '', ''), ('50', '5', '维修保养', '1', '0', '', '0', '0', '0', '', '', ''), ('51', '5', '汽车装饰', '1', '0', '', '0', '0', '0', '', '', ''), ('52', '0', '食品生鲜', '0', '0', '件', '0', '1', '0', '', '食品生鲜', '食品生鲜分类'), ('53', '52', '水果集市', '1', '0', '件', '1', '1', '0', 'http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191223/330859-1P1031K10568.jpg', '水果', '水果'), ('54', '52', '苹果', '1', '0', '件', '0', '1', '0', 'http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191223/b3bad028db9c00f6d8b9d4783358ddbe.jpg', '苹果', '苹果'), ('55', '52', '桔子', '1', '0', '件', '0', '1', '0', 'http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191223/MTAwMHgw.jpeg', '桔子', '桔子'), ('56', '52', '芒果', '1', '0', '件', '0', '1', '0', 'http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191223/f43912a522ccec4ae8a293de5374012e.jpg', '芒果', '芒果'), ('57', '52', '橙子', '1', '0', '件', '0', '1', '0', 'http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191223/8296b3035a04923270113ddf221bd03a.jpg', '橙子', '橙子'), ('58', '52', '猕猴桃/奇异果', '1', '0', '件', '0', '1', '0', 'http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191223/0b39f94b0fe93bc83c05d7a461d2bb5b.jpg', '猕猴桃/奇异果', '猕猴桃/奇异果'), ('59', '52', '火龙果', '1', '0', '件', '0', '1', '0', 'http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191223/ab95ed16fc2f4f253340459129815684.jpg', '火龙果', '火龙果'), ('60', '52', '草莓', '1', '0', '件', '0', '1', '0', 'http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191223/f14b8fa157328de720f4512d96679dc3.jpg', '草莓', '草莓'), ('61', '52', '车厘子/樱桃', '1', '0', '', '0', '0', '0', 'http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191223/76e02e73ebca3800529d4e089f72f7e6.jpg', '车厘子/樱桃', '车厘子/樱桃'), ('62', '52', '榴莲', '1', '0', '件', '0', '1', '0', 'http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191223/a35a709ed7d11de1062f46e726215e3d.jpg', '榴莲', '榴莲');
COMMIT;

-- ----------------------------
--  Table structure for `pms_product_category_attribute_relation`
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_category_attribute_relation`;
CREATE TABLE `pms_product_category_attribute_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_category_id` bigint(20) DEFAULT NULL,
  `product_attribute_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）';

-- ----------------------------
--  Records of `pms_product_category_attribute_relation`
-- ----------------------------
BEGIN;
INSERT INTO `pms_product_category_attribute_relation` VALUES ('1', '24', '24'), ('5', '26', '24'), ('7', '28', '24'), ('9', '25', '24'), ('10', '25', '25');
COMMIT;

-- ----------------------------
--  Table structure for `pms_product_combination`
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_combination`;
CREATE TABLE `pms_product_combination` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品团购产品表id',
  `product_id` bigint(20) NOT NULL COMMENT '商品id',
  `pic` varchar(255) NOT NULL COMMENT '推荐图',
  `album_pics` varchar(255) NOT NULL COMMENT '轮播图',
  `name` varchar(255) NOT NULL COMMENT '活动标题',
  `people` int(11) NOT NULL COMMENT '参团人数',
  `description` varchar(255) NOT NULL COMMENT '简介',
  `price` decimal(10,2) NOT NULL COMMENT '价格',
  `sort` varchar(255) NOT NULL COMMENT '排序',
  `original_price` decimal(10,2) NOT NULL COMMENT '原价',
  `gift_point` int(11) NOT NULL DEFAULT '0' COMMENT '返多少积分',
  `add_time` varchar(11) NOT NULL COMMENT '添加时间',
  `stock` int(11) NOT NULL COMMENT '库存',
  `sale` int(11) NOT NULL COMMENT '销量',
  `unit_name` varchar(11) NOT NULL COMMENT '单位名',
  `postage` decimal(10,2) NOT NULL COMMENT '邮费',
  `detail_html` text NOT NULL,
  `detail_mobile_html` text NOT NULL,
  `browse` int(11) DEFAULT '0' COMMENT '浏览量',
  `end_time_date` datetime NOT NULL,
  `start_time_date` datetime NOT NULL,
  `delete_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除 0未删除1已删除',
  `start_time` int(11) NOT NULL COMMENT '开始时间',
  `end_time` int(11) NOT NULL COMMENT '结束时间',
  `hot_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '热门推荐',
  `lock_stock` int(11) DEFAULT '0' COMMENT '锁住库存',
  `is_show` tinyint(1) DEFAULT '0' COMMENT '是否显示',
  `effective_time` int(11) DEFAULT NULL,
  `postage_status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品团购产品表';

-- ----------------------------
--  Records of `pms_product_combination`
-- ----------------------------
BEGIN;
INSERT INTO `pms_product_combination` VALUES ('1', '40', 'https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525553.jpg', 'https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525552.jpg,https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525551.jpg,https://yoooho.bkbedu.com/mall/images/20200425/微信图片_20200425152555.jpg', '当季孕妇水果现摘大连车厘子2斤拼团', '2', '新鲜车厘子大果', '0.01', '1', '158.00', '10', '1592992113', '104', '14', '斤', '0.00', '<p><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_20200425152316.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523161.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523162.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523163.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523164.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_20200425153015.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523165.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523166.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523167.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523168.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523169.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231610.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231611.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231615.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231612.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231613.jpg\" /></p>', '', '2', '2029-11-15 00:00:00', '2020-06-24 00:00:00', '0', '1592928000', '1889366400', '1', '97', '1', '24', '1');
COMMIT;

-- ----------------------------
--  Table structure for `pms_product_full_reduction`
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_full_reduction`;
CREATE TABLE `pms_product_full_reduction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `full_price` decimal(10,2) DEFAULT NULL,
  `reduce_price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='产品满减表(只针对同商品)';

-- ----------------------------
--  Records of `pms_product_full_reduction`
-- ----------------------------
BEGIN;
INSERT INTO `pms_product_full_reduction` VALUES ('1', '7', '100.00', '20.00'), ('2', '8', '100.00', '20.00'), ('3', '9', '100.00', '20.00'), ('4', '10', '100.00', '20.00'), ('5', '11', '100.00', '20.00'), ('6', '12', '100.00', '20.00'), ('7', '13', '100.00', '20.00'), ('8', '14', '100.00', '20.00'), ('9', '18', '100.00', '20.00'), ('10', '7', '200.00', '50.00'), ('11', '7', '300.00', '100.00'), ('14', '22', '0.00', '0.00'), ('16', '24', '0.00', '0.00'), ('34', '23', '0.00', '0.00'), ('44', '31', '0.00', '0.00'), ('46', '32', '0.00', '0.00'), ('48', '33', '0.00', '0.00'), ('53', '36', '0.00', '0.00'), ('54', '35', '0.00', '0.00'), ('55', '34', '0.00', '0.00'), ('56', '30', '0.00', '0.00'), ('60', '28', '500.00', '50.00'), ('61', '28', '1000.00', '120.00'), ('62', '29', '0.00', '0.00'), ('63', '27', '0.00', '0.00'), ('78', '37', '0.00', '0.00'), ('79', '38', '0.00', '0.00'), ('80', '39', '0.00', '0.00'), ('88', '41', '0.00', '0.00'), ('89', '42', '0.00', '0.00'), ('90', '43', '0.00', '0.00'), ('91', '44', '0.00', '0.00'), ('92', '45', '0.00', '0.00'), ('93', '46', '0.00', '0.00'), ('94', '47', '0.00', '0.00'), ('95', '48', '0.00', '0.00'), ('96', '49', '0.00', '0.00'), ('97', '50', '0.00', '0.00'), ('98', '51', '0.00', '0.00'), ('99', '52', '0.00', '0.00'), ('100', '53', '0.00', '0.00'), ('101', '54', '0.00', '0.00'), ('102', '55', '0.00', '0.00'), ('103', '56', '0.00', '0.00'), ('104', '57', '0.00', '0.00'), ('105', '58', '0.00', '0.00'), ('108', '40', '0.00', '0.00'), ('109', '59', '0.00', '0.00'), ('110', '60', '0.00', '0.00'), ('111', '61', '0.00', '0.00'), ('112', '62', '0.00', '0.00'), ('113', '63', '0.00', '0.00'), ('114', '64', '0.00', '0.00'), ('115', '65', '0.00', '0.00'), ('116', '66', '0.00', '0.00'), ('117', '67', '0.00', '0.00'), ('119', '26', '0.00', '0.00');
COMMIT;

-- ----------------------------
--  Table structure for `pms_product_ladder`
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_ladder`;
CREATE TABLE `pms_product_ladder` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `count` int(11) DEFAULT NULL COMMENT '满足的商品数量',
  `discount` decimal(10,2) DEFAULT NULL COMMENT '折扣',
  `price` decimal(10,2) DEFAULT NULL COMMENT '折后价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='产品阶梯价格表(只针对同商品)';

-- ----------------------------
--  Records of `pms_product_ladder`
-- ----------------------------
BEGIN;
INSERT INTO `pms_product_ladder` VALUES ('1', '7', '3', '0.70', '0.00'), ('2', '8', '3', '0.70', '0.00'), ('3', '9', '3', '0.70', '0.00'), ('4', '10', '3', '0.70', '0.00'), ('5', '11', '3', '0.70', '0.00'), ('6', '12', '3', '0.70', '0.00'), ('7', '13', '3', '0.70', '0.00'), ('8', '14', '3', '0.70', '0.00'), ('12', '18', '3', '0.70', '0.00'), ('14', '7', '4', '0.60', '0.00'), ('15', '7', '5', '0.50', '0.00'), ('18', '22', '0', '0.00', '0.00'), ('20', '24', '0', '0.00', '0.00'), ('38', '23', '0', '0.00', '0.00'), ('48', '31', '0', '0.00', '0.00'), ('50', '32', '0', '0.00', '0.00'), ('52', '33', '0', '0.00', '0.00'), ('57', '36', '0', '0.00', '0.00'), ('58', '35', '0', '0.00', '0.00'), ('59', '34', '0', '0.00', '0.00'), ('60', '30', '0', '0.00', '0.00'), ('66', '28', '0', '0.00', '0.00'), ('67', '29', '0', '0.00', '0.00'), ('68', '27', '2', '0.80', '0.00'), ('69', '27', '3', '0.75', '0.00'), ('84', '37', '0', '0.00', '0.00'), ('85', '38', '0', '0.00', '0.00'), ('86', '39', '0', '0.00', '0.00'), ('94', '41', '0', '0.00', '0.00'), ('95', '42', '0', '0.00', '0.00'), ('96', '43', '0', '0.00', '0.00'), ('97', '44', '0', '0.00', '0.00'), ('98', '45', '0', '0.00', '0.00'), ('99', '46', '0', '0.00', '0.00'), ('100', '47', '0', '0.00', '0.00'), ('101', '48', '0', '0.00', '0.00'), ('102', '49', '0', '0.00', '0.00'), ('103', '50', '0', '0.00', '0.00'), ('104', '51', '0', '0.00', '0.00'), ('105', '52', '0', '0.00', '0.00'), ('106', '53', '0', '0.00', '0.00'), ('107', '54', '0', '0.00', '0.00'), ('108', '55', '0', '0.00', '0.00'), ('109', '56', '0', '0.00', '0.00'), ('110', '57', '0', '0.00', '0.00'), ('111', '58', '0', '0.00', '0.00'), ('114', '40', '0', '0.00', '0.00'), ('115', '59', '0', '0.00', '0.00'), ('116', '60', '0', '0.00', '0.00'), ('117', '61', '0', '0.00', '0.00'), ('118', '62', '0', '0.00', '0.00'), ('119', '63', '0', '0.00', '0.00'), ('120', '64', '0', '0.00', '0.00'), ('121', '65', '0', '0.00', '0.00'), ('122', '66', '0', '0.00', '0.00'), ('123', '67', '0', '0.00', '0.00'), ('125', '26', '0', '0.00', '0.00');
COMMIT;

-- ----------------------------
--  Table structure for `pms_product_operate_log`
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_operate_log`;
CREATE TABLE `pms_product_operate_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `price_old` decimal(10,2) DEFAULT NULL,
  `price_new` decimal(10,2) DEFAULT NULL,
  `sale_price_old` decimal(10,2) DEFAULT NULL,
  `sale_price_new` decimal(10,2) DEFAULT NULL,
  `gift_point_old` int(11) DEFAULT NULL COMMENT '赠送的积分',
  `gift_point_new` int(11) DEFAULT NULL,
  `use_point_limit_old` int(11) DEFAULT NULL,
  `use_point_limit_new` int(11) DEFAULT NULL,
  `operate_man` varchar(64) DEFAULT NULL COMMENT '操作人',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `pms_product_seckill`
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_seckill`;
CREATE TABLE `pms_product_seckill` (
  `id` bigint(20) unsigned NOT NULL COMMENT '商品秒杀产品表id',
  `product_id` bigint(20) unsigned NOT NULL COMMENT '商品id',
  `pic` varchar(255) NOT NULL DEFAULT '' COMMENT '推荐图',
  `album_pics` varchar(4000) NOT NULL DEFAULT '' COMMENT '轮播图',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '活动标题',
  `description` varchar(255) NOT NULL DEFAULT '' COMMENT '简介',
  `price` decimal(10,2) unsigned NOT NULL COMMENT '价格',
  `original_price` decimal(10,2) unsigned NOT NULL COMMENT '原价',
  `gift_point` int(10) unsigned NOT NULL COMMENT '返多少积分',
  `sort` int(10) unsigned NOT NULL COMMENT '排序',
  `stock` int(10) unsigned NOT NULL COMMENT '库存',
  `sale` int(10) unsigned DEFAULT NULL COMMENT '销量',
  `unit_name` varchar(11) NOT NULL DEFAULT '' COMMENT '单位名',
  `postage` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '邮费',
  `detail_html` text COMMENT '内容',
  `detail_mobile_html` text,
  `start_time` int(11) NOT NULL DEFAULT '0' COMMENT '开始时间',
  `stop_time` int(11) NOT NULL DEFAULT '0' COMMENT '结束时间',
  `add_time` varchar(11) NOT NULL DEFAULT '' COMMENT '添加时间',
  `postage_status` int(11) NOT NULL DEFAULT '0' COMMENT '是否包邮',
  `hot_status` int(11) NOT NULL DEFAULT '0' COMMENT '热门推荐',
  `delete_status` int(11) NOT NULL DEFAULT '0' COMMENT '删除 0未删除1已删除',
  `num` int(11) NOT NULL COMMENT '最多秒杀几个',
  `is_show` int(11) NOT NULL DEFAULT '1' COMMENT '显示',
  `time_id` int(11) DEFAULT '0' COMMENT '时间段id',
  `end_time_date` datetime DEFAULT NULL,
  `start_time_date` datetime DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '1',
  `lock_stock` int(11) DEFAULT '0' COMMENT '锁住库存',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `product_id` (`product_id`) USING BTREE,
  KEY `sort` (`sort`) USING BTREE,
  KEY `start_time` (`start_time`) USING BTREE,
  KEY `stop_time` (`stop_time`) USING BTREE,
  KEY `hot_status` (`hot_status`) USING BTREE,
  KEY `delete_status` (`delete_status`) USING BTREE,
  KEY `is_show` (`is_show`) USING BTREE,
  KEY `add_time` (`add_time`) USING BTREE,
  KEY `postage_status` (`postage_status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品秒杀产品表';

-- ----------------------------
--  Records of `pms_product_seckill`
-- ----------------------------
BEGIN;
INSERT INTO `pms_product_seckill` VALUES ('1', '26', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ab46a3cN616bdc41.jpg,http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf5fN2522b9dc.jpg', '华为 HUAWEI P20 ', 'AI智慧全面屏 6GB +64GB 亮黑色 全网通版 移动联通电信4G手机 双卡双待手机 双卡双待', '0.01', '4288.00', '3788', '2', '100', '11', '件', '2.00', '<p><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad44f1cNf51f3bb0.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad44fa8Nfcf71c10.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad44fa9N40e78ee0.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad457f4N1c94bdda.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad457f5Nd30de41d.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5b10fb0eN0eb053fb.jpg\" /></p>', null, '1590681600', '1623081600', '', '0', '1', '0', '1', '1', '3', '2021-06-08 00:00:00', '2020-05-29 00:00:00', '1', '0'), ('25', '30', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5ad83a4fN6ff67ecd.jpg!cc_350x449.jpg', 'http://localhost:8091/file/pic/微信图片_202004251523168-20200520063636108.jpg,http://localhost:8091/file/pic/微信图片_202004251523169-20200520063636108.jpg,http://localhost:8091/file/pic/微信图片_202004251523165-20200520063636108.jpg', 'HLA海澜之家简约动物印花短袖T恤', '2018夏季新品微弹舒适新款短T男生 6月6日-6月20日，满300减30，参与互动赢百元礼券，立即分享赢大奖', '0.10', '98.00', '0', '2', '100', '0', '', '0.00', '', null, '1599667200', '1601395200', '1591152500', '1', '1', '0', '1', '1', '4', '2020-09-30 00:00:00', '2020-09-10 00:00:00', '1', '0'), ('26', '38', 'https://yoooho.bkbedu.com/mall/images/20191224/IMG_3876.JPG', 'https://yoooho.bkbedu.com/mall/images/20191224/IMG_3872.JPG,https://yoooho.bkbedu.com/mall/images/20191224/IMG_3873.JPG,https://yoooho.bkbedu.com/mall/images/20191224/IMG_3874.JPG,https://yoooho.bkbedu.com/mall/images/20191224/IMG_3875.JPG', '新鲜红富士苹果10斤当季整箱', '新鲜红富士苹果', '0.01', '44.00', '0', '1', '98', '10', '斤', '0.00', '<p><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3877.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3883.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3880.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3879.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3878.JPG\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191224/IMG_3882.JPG\" /></p>', '', '1559664000', '1626278400', '1591421560', '1', '1', '0', '10', '1', '6', '2021-07-15 00:00:00', '2019-06-05 00:00:00', '1', '0'), ('27', '40', 'https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525553.jpg', 'https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525552.jpg,https://yoooho.bkbedu.com/mall/images/20200425/微信图片_202004251525551.jpg,https://yoooho.bkbedu.com/mall/images/20200425/微信图片_20200425152555.jpg', '当季孕妇水果现摘大连车厘子2斤', '新鲜车厘子大果', '0.01', '158.00', '10', '1', '100', '10', '斤', '0.00', '<p><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_20200425152316.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523161.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523162.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523163.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523164.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_20200425153015.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523165.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523166.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523167.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523168.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_202004251523169.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231610.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231611.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231615.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231612.jpg\" /><img class=\"wscnph\" src=\"http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20200425/微信图片_2020042515231613.jpg\" /></p>', '', '1591459200', '1784131200', '1591493719', '1', '1', '0', '1', '1', '3', '2026-07-16 00:00:00', '2020-06-07 00:00:00', '1', '0');
COMMIT;

-- ----------------------------
--  Table structure for `pms_product_vertify_record`
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_vertify_record`;
CREATE TABLE `pms_product_vertify_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `vertify_man` varchar(64) DEFAULT NULL COMMENT '审核人',
  `status` int(11) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL COMMENT '反馈详情',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品审核记录';

-- ----------------------------
--  Records of `pms_product_vertify_record`
-- ----------------------------
BEGIN;
INSERT INTO `pms_product_vertify_record` VALUES ('1', '1', '2018-04-27 16:36:41', 'test', '1', '验证通过'), ('2', '2', '2018-04-27 16:36:41', 'test', '1', '验证通过');
COMMIT;

-- ----------------------------
--  Table structure for `pms_sku_stock`
-- ----------------------------
DROP TABLE IF EXISTS `pms_sku_stock`;
CREATE TABLE `pms_sku_stock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `sku_code` varchar(64) NOT NULL COMMENT 'sku编码',
  `price` decimal(10,2) DEFAULT NULL,
  `stock` int(11) DEFAULT '0' COMMENT '库存',
  `low_stock` int(11) DEFAULT NULL COMMENT '预警库存',
  `sp1` varchar(64) DEFAULT NULL COMMENT '销售属性1',
  `sp2` varchar(64) DEFAULT NULL,
  `sp3` varchar(64) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL COMMENT '展示图片',
  `sale` int(11) DEFAULT NULL COMMENT '销量',
  `promotion_price` decimal(10,2) DEFAULT NULL COMMENT '单品促销价格',
  `lock_stock` int(11) DEFAULT '0' COMMENT '锁定库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=349 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='sku的库存';

-- ----------------------------
--  Records of `pms_sku_stock`
-- ----------------------------
BEGIN;
INSERT INTO `pms_sku_stock` VALUES ('1', '7', 'string', '100.00', '0', '5', 'string', 'string', 'string', 'string', '0', null, '0'), ('2', '8', 'string', '100.00', '0', '5', 'string', 'string', 'string', 'string', '0', null, '0'), ('3', '9', 'string', '100.00', '0', '5', 'string', 'string', 'string', 'string', '0', null, '0'), ('4', '10', 'string', '100.00', '0', '5', 'string', 'string', 'string', 'string', '0', null, '0'), ('5', '11', 'string', '100.00', '0', '5', 'string', 'string', 'string', 'string', '0', null, '0'), ('6', '12', 'string', '100.00', '0', '5', 'string', 'string', 'string', 'string', '0', null, '0'), ('7', '13', 'string', '100.00', '0', '5', 'string', 'string', 'string', 'string', '0', null, '0'), ('8', '14', 'string', '100.00', '0', '5', 'string', 'string', 'string', 'string', '0', null, '0'), ('9', '18', 'string', '100.00', '0', '5', 'string', 'string', 'string', 'string', '0', null, '0'), ('10', '7', 'string', '0.00', '0', '0', 'string', 'string', 'sp3', 'string', '0', null, '0'), ('11', '7', 'string', '0.00', '0', '0', 'string', 'string', 'sp33', 'string', '0', null, '0'), ('12', '22', '111', '99.00', '0', null, 'x', 'M', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', null, null, '0'), ('13', '22', '112', '99.00', '0', null, 'xx', 'M', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/2018032614134591_20180326141345650 (4).png', null, null, '0'), ('78', '23', '201806070023001', '99.00', '0', null, '米白色', 'M', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', null, null, '0'), ('79', '23', '201806070023002', '99.00', '0', null, '米白色', 'X', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', null, null, '0'), ('80', '23', '201806070023003', '99.00', '0', null, '浅黄色', 'M', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/2017091716493787_20170917164937650 (1).png', null, null, '0'), ('81', '23', '201806070023004', '99.00', '0', null, '浅黄色', 'X', null, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/2017091716493787_20170917164937650 (1).png', null, null, '0'), ('102', '28', '201808270028001', '649.00', '99', null, '金色', '16G', null, null, null, null, '-8'), ('103', '28', '201808270028002', '699.00', '99', null, '金色', '32G', null, null, null, null, '-8'), ('104', '28', '201808270028003', '649.00', '100', null, '银色', '16G', null, null, null, null, '0'), ('105', '28', '201808270028004', '699.00', '100', null, '银色', '32G', null, null, null, null, '0'), ('106', '29', '201808270029001', '5499.00', '99', null, '金色', '32G', null, null, null, null, '-8'), ('107', '29', '201808270029002', '6299.00', '100', null, '金色', '64G', null, null, null, null, '0'), ('108', '29', '201808270029003', '5499.00', '100', null, '银色', '32G', null, null, null, null, '0'), ('109', '29', '201808270029004', '6299.00', '100', null, '银色', '64G', null, null, null, null, '0'), ('110', '27', '201808270027001', '2699.00', '62', null, '黑色', '32G', null, null, null, null, '-25'), ('111', '27', '201808270027002', '2999.00', '100', null, '黑色', '64G', null, null, null, null, '0'), ('112', '27', '201808270027003', '2699.00', '100', null, '蓝色', '32G', null, null, null, null, '0'), ('113', '27', '201808270027004', '2999.00', '100', null, '蓝色', '64G', null, null, null, null, '0'), ('153', '37', 'STJ0001', '15.80', '922', '50', '3kg', null, null, 'http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191223/ddf1cf242b988953c2cb6174d1972c70.jpg', null, null, '0'), ('154', '37', 'STJ0002', '23.80', '1000', '50', '5kg', null, null, 'http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191223/ddf1cf242b988953c2cb6174d1972c70.jpg', null, null, '0'), ('155', '37', 'STJ0003', '36.80', '1000', '50', '10kg', null, null, 'http://yoooho.oss-cn-beijing.aliyuncs.com/mall/images/20191223/ddf1cf242b988953c2cb6174d1972c70.jpg', null, null, '0'), ('156', '38', 'FSPG00001', '44.80', '10000', '100', '9斤', '80mm-85mm', null, '', null, null, '0'), ('157', '38', 'FSPG00002', '54.80', '10000', '100', '9斤', '85mm-90mm', null, '', null, null, '0'), ('158', '39', '202001090039001', '0.01', '69', null, '3kg', null, null, null, null, null, '-3'), ('159', '39', '202001090039002', '0.01', '100', null, '5kg', null, null, null, null, null, '0'), ('160', '39', '202001090039003', '0.01', '100', null, '10kg', null, null, null, null, null, '0'), ('323', '40', 'CLZ000001', '118.00', '10000', '10', '500g', '4J', null, null, null, null, '0'), ('324', '40', 'CLZ000002', '113.00', '10000', '10', '500g', '5J', null, null, null, null, '0'), ('325', '40', 'CLZ000002', '99.00', '10000', '10', '500g', '3J', null, null, null, null, '0'), ('326', '40', 'CLZ000004', '193.00', '10000', '10', '1000g', '4J', null, null, null, null, '0'), ('327', '40', 'CLZ000005', '148.00', '10000', '10', '1000g', 'jj', null, null, null, null, '0'), ('328', '40', 'CLZ000006', '240.00', '10000', '10', '1000g', '5J', null, null, null, null, '0'), ('329', '40', 'CLZ000007', '128.00', '10000', '10', '1000g', 'J', null, null, null, null, '0'), ('330', '40', 'CLZ000008', '168.00', '10000', '10', '1000g', '3J', null, null, null, null, '0'), ('331', '40', 'CLZ000009', '264.00', '100000', '10', '1500g', '4J', null, null, null, null, '0'), ('332', '40', 'CLZ000010', '205.00', '10000', '10', '1500g', 'jj', null, null, null, null, '0'), ('333', '40', 'CLZ000011', '323.00', '10000', '10', '1500g', '5J', null, null, null, null, '0'), ('334', '40', 'CLZ000012', '158.00', '10000', '10', '1500g', 'J', null, null, null, null, '0'), ('335', '40', 'CLZ000013', '211.00', '10000', '10', '1500g', '3J', null, null, null, null, '0'), ('336', '40', 'CLZ000014', '401.00', '10000', '10', '2500g', '4J', null, null, null, null, '0'), ('337', '40', 'CLZ000015', '295.00', '10000', '10', '2500g', 'jj', null, null, null, null, '0'), ('338', '40', 'CLZ000016', '451.00', '10000', '10', '2500g', '5J', null, null, null, null, '0'), ('339', '40', 'CLZ000017', '250.00', '10000', '10', '2500g', 'J', null, null, null, null, '0'), ('340', '40', 'CLZ000018', '305.00', '10000', '10', '2500g', '3J', null, null, null, null, '0'), ('345', '26', '201806070026001', '3788.00', '499', null, '金色', '16G', null, null, null, null, '0'), ('346', '26', '201806070026002', '3999.00', '500', null, '金色', '32G', null, null, null, null, '0'), ('347', '26', '201806070026003', '3788.00', '500', null, '银色', '16G', null, null, null, null, '0'), ('348', '26', '201806070026004', '3999.00', '500', null, '银色', '32G', null, null, null, null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `pms_store`
-- ----------------------------
DROP TABLE IF EXISTS `pms_store`;
CREATE TABLE `pms_store` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '门店名称',
  `introduction` varchar(255) NOT NULL COMMENT '简介',
  `phone` varchar(25) NOT NULL COMMENT '手机号码',
  `address` varchar(255) NOT NULL COMMENT '省市区',
  `detailed_address` varchar(255) DEFAULT '' COMMENT '详细地址',
  `image` varchar(521) NOT NULL COMMENT '门店logo',
  `latitude` varchar(25) NOT NULL COMMENT '纬度',
  `longitude` varchar(25) NOT NULL COMMENT '经度',
  `valid_time` varchar(100) NOT NULL COMMENT '核销有效日期',
  `day_time` varchar(100) NOT NULL DEFAULT '' COMMENT '每日营业开关时间',
  `add_time` datetime NOT NULL COMMENT '添加时间',
  `is_show` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否显示',
  `is_del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `day_time_end` datetime DEFAULT NULL,
  `day_time_start` datetime DEFAULT NULL,
  `valid_time_end` datetime DEFAULT NULL,
  `valid_time_start` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='门店自提';

-- ----------------------------
--  Records of `pms_store`
-- ----------------------------
BEGIN;
INSERT INTO `pms_store` VALUES ('2', '北京店', '2', '18125255678', '北京', '', 'http://localhost:8091/file/pic/微信图片_202004251525552-20200621101538650.jpg', '40.22077', '116.23128', '2020-06-26 - 2020-06-26', '14:55:02 - 20:55:02', '2020-06-25 14:56:03', '1', '0', '2020-06-25 20:55:02', '2020-06-25 14:55:02', '2020-06-26 00:00:00', '2020-06-26 00:00:00'), ('3', '上海店', '搜索', '18125255678', '上海', '', 'http://localhost:8091/file/pic/微信图片_202004251525552-20200621101538650.jpg', '31.40527', '121.48941', '2020-06-17 - 2020-06-17', '15:47:09 - 23:47:09', '2020-06-25 15:48:15', '1', '0', '2020-06-25 23:47:09', '2020-06-25 15:47:09', '2020-06-17 00:00:00', '2020-06-17 00:00:00');
COMMIT;

-- ----------------------------
--  Table structure for `pms_store_config`
-- ----------------------------
DROP TABLE IF EXISTS `pms_store_config`;
CREATE TABLE `pms_store_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `map_key` varchar(255) DEFAULT NULL,
  `open_status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='门店配置表';

-- ----------------------------
--  Records of `pms_store_config`
-- ----------------------------
BEGIN;
INSERT INTO `pms_store_config` VALUES ('1', 'OGABZ-Y5OCF-5UWJ5-N7DHH-VFIG7-DHFEB', '1');
COMMIT;

-- ----------------------------
--  Table structure for `pms_store_staff`
-- ----------------------------
DROP TABLE IF EXISTS `pms_store_staff`;
CREATE TABLE `pms_store_staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) NOT NULL COMMENT '微信用户id',
  `nickname` varchar(50) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL COMMENT '店员头像',
  `store_id` bigint(20) NOT NULL COMMENT '门店id',
  `store_name` varchar(50) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL COMMENT '手机号码',
  `staff_name` varchar(64) DEFAULT NULL COMMENT '店员名称',
  `verify_status` tinyint(1) NOT NULL COMMENT '核销开关',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `add_time` datetime NOT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='门店店员表';

-- ----------------------------
--  Records of `pms_store_staff`
-- ----------------------------
BEGIN;
INSERT INTO `pms_store_staff` VALUES ('1', '1', 'windir', null, '2', '北京店', '181825255678', '店员001', '1', null, '2020-06-25 14:57:29');
COMMIT;

-- ----------------------------
--  Table structure for `roles_depts`
-- ----------------------------
DROP TABLE IF EXISTS `roles_depts`;
CREATE TABLE `roles_depts` (
  `role_id` bigint(20) NOT NULL,
  `dept_id` bigint(20) NOT NULL,
  PRIMARY KEY (`dept_id`,`role_id`) USING BTREE,
  KEY `FK7qg6itn5ajdoa9h9o78v9ksur` (`dept_id`) USING BTREE,
  KEY `role_id` (`role_id`) USING BTREE,
  CONSTRAINT `roles_depts_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`),
  CONSTRAINT `roles_depts_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `ums_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色部门关联';

-- ----------------------------
--  Table structure for `roles_menus`
-- ----------------------------
DROP TABLE IF EXISTS `roles_menus`;
CREATE TABLE `roles_menus` (
  `menu_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`menu_id`,`role_id`) USING BTREE,
  KEY `role_id` (`role_id`) USING BTREE,
  CONSTRAINT `roles_menus_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`),
  CONSTRAINT `roles_menus_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `ums_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色菜单表';

-- ----------------------------
--  Records of `roles_menus`
-- ----------------------------
BEGIN;
INSERT INTO `roles_menus` VALUES ('1', '5'), ('2', '5'), ('3', '5'), ('4', '5'), ('5', '5'), ('6', '5'), ('7', '5'), ('8', '5'), ('9', '5'), ('10', '5'), ('11', '5'), ('12', '5'), ('23', '5'), ('24', '5'), ('25', '5'), ('26', '5'), ('27', '5'), ('28', '5'), ('29', '5'), ('30', '5'), ('31', '5'), ('32', '5'), ('33', '5'), ('34', '5'), ('35', '5'), ('36', '5'), ('37', '5'), ('38', '5'), ('39', '5'), ('40', '5'), ('41', '5'), ('42', '5'), ('43', '5'), ('44', '5'), ('45', '5'), ('46', '5'), ('47', '5'), ('48', '5'), ('49', '5'), ('50', '5'), ('51', '5'), ('52', '5'), ('53', '5'), ('54', '5'), ('55', '5'), ('56', '5'), ('57', '5'), ('58', '5'), ('59', '5'), ('60', '5'), ('61', '5'), ('62', '5'), ('63', '5'), ('64', '5'), ('65', '5'), ('66', '5'), ('67', '5'), ('68', '5'), ('69', '5'), ('70', '5'), ('71', '5'), ('72', '5'), ('73', '5'), ('74', '5'), ('75', '5'), ('76', '5'), ('77', '5'), ('78', '5'), ('79', '5'), ('80', '5'), ('81', '5'), ('82', '5'), ('83', '5'), ('84', '5'), ('85', '5'), ('86', '5'), ('87', '5'), ('88', '5'), ('89', '5'), ('90', '5'), ('91', '5'), ('92', '5'), ('93', '5'), ('94', '5'), ('95', '5'), ('96', '5'), ('97', '5'), ('98', '5'), ('99', '5'), ('100', '5'), ('101', '5'), ('102', '5'), ('103', '5'), ('104', '5'), ('105', '5'), ('106', '5'), ('107', '5'), ('108', '5'), ('109', '5'), ('110', '5'), ('111', '5'), ('112', '5'), ('113', '5'), ('115', '5'), ('116', '5'), ('117', '5'), ('119', '5'), ('120', '5'), ('121', '5'), ('122', '5'), ('123', '5'), ('124', '5'), ('125', '5'), ('126', '5'), ('127', '5'), ('128', '5'), ('129', '5'), ('130', '5'), ('131', '5'), ('132', '5'), ('133', '5'), ('134', '5'), ('135', '5'), ('136', '5'), ('137', '5'), ('138', '5'), ('139', '5'), ('140', '5'), ('142', '5'), ('143', '5'), ('144', '5'), ('145', '5'), ('146', '5'), ('147', '5'), ('148', '5'), ('149', '5');
COMMIT;

-- ----------------------------
--  Table structure for `sms_coupon`
-- ----------------------------
DROP TABLE IF EXISTS `sms_coupon`;
CREATE TABLE `sms_coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL COMMENT '优惠卷类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券',
  `name` varchar(100) DEFAULT NULL,
  `platform` int(11) DEFAULT NULL COMMENT '使用平台：0->全部；1->移动；2->PC',
  `count` int(11) DEFAULT NULL COMMENT '数量',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `per_limit` int(11) DEFAULT NULL COMMENT '每人限领张数',
  `min_point` decimal(10,2) DEFAULT NULL COMMENT '使用门槛；0表示无门槛',
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `use_type` int(11) DEFAULT NULL COMMENT '使用类型：0->全场通用；1->指定分类；2->指定商品',
  `note` varchar(200) DEFAULT NULL COMMENT '备注',
  `publish_count` int(11) DEFAULT NULL COMMENT '发行数量',
  `use_count` int(11) DEFAULT NULL COMMENT '已使用数量',
  `receive_count` int(11) DEFAULT NULL COMMENT '领取数量',
  `enable_time` datetime DEFAULT NULL COMMENT '可以领取的日期',
  `code` varchar(64) DEFAULT NULL COMMENT '优惠码',
  `member_level` int(11) DEFAULT NULL COMMENT '可领取的会员类型：0->无限时',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='优惠卷表';

-- ----------------------------
--  Records of `sms_coupon`
-- ----------------------------
BEGIN;
INSERT INTO `sms_coupon` VALUES ('22', '0', '满99减5优惠券', '0', '99999994', '5.00', '100', '99.00', '2019-12-14 00:00:00', '2020-12-14 00:00:00', '0', '分享优惠券', '100000000', '0', '6', '2019-12-14 23:16:40', null, null), ('23', '0', '商品优惠券', '0', '99999983', '20.00', '20', '299.00', '2020-01-08 00:00:00', '2023-01-19 00:00:00', '0', '商品页面优惠券', '100000000', '0', '17', '2020-01-08 15:13:54', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `sms_coupon_history`
-- ----------------------------
DROP TABLE IF EXISTS `sms_coupon_history`;
CREATE TABLE `sms_coupon_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `coupon_id` bigint(20) DEFAULT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  `coupon_code` varchar(64) DEFAULT NULL,
  `member_nickname` varchar(64) DEFAULT NULL COMMENT '领取人昵称',
  `get_type` int(11) DEFAULT NULL COMMENT '获取类型：0->后台赠送；1->主动获取',
  `create_time` datetime DEFAULT NULL,
  `use_status` int(11) DEFAULT NULL COMMENT '使用状态：0->未使用；1->已使用；2->已过期',
  `use_time` datetime DEFAULT NULL COMMENT '使用时间',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单编号',
  `order_sn` varchar(100) DEFAULT NULL COMMENT '订单号码',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_member_id` (`member_id`) USING BTREE,
  KEY `idx_coupon_id` (`coupon_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='优惠券使用、领取历史表';

-- ----------------------------
--  Records of `sms_coupon_history`
-- ----------------------------
BEGIN;
INSERT INTO `sms_coupon_history` VALUES ('2', '2', '1', '4931048380330002', 'windir', '1', '2018-08-29 14:04:12', '0', '2019-03-21 15:03:40', '12', '201809150101000001'), ('3', '3', '1', '4931048380330003', 'windir', '1', '2018-08-29 14:04:29', '0', null, null, null), ('4', '4', '1', '4931048380330004', 'windir', '1', '2018-08-29 14:04:32', '0', null, null, null), ('11', '7', '1', '4931048380330001', 'windir', '1', '2018-09-04 16:21:50', '0', null, null, null), ('12', '2', '4', '0340981248320004', 'zhensan', '1', '2018-11-12 14:16:50', '0', null, null, null), ('13', '3', '4', '0342977234360004', 'zhensan', '1', '2018-11-12 14:17:10', '0', null, null, null), ('14', '4', '4', '0343342928830004', 'zhensan', '1', '2018-11-12 14:17:13', '0', null, null, null), ('15', '2', '5', '0351883832180005', 'lisi', '1', '2018-11-12 14:18:39', '0', null, null, null), ('16', '3', '5', '0352201672680005', 'lisi', '1', '2018-11-12 14:18:42', '0', null, null, null), ('17', '4', '5', '0352505810180005', 'lisi', '1', '2018-11-12 14:18:45', '0', null, null, null), ('18', '2', '6', '0356114588380006', 'wangwu', '1', '2018-11-12 14:19:21', '0', null, null, null), ('19', '3', '6', '0356382856920006', 'wangwu', '1', '2018-11-12 14:19:24', '0', null, null, null), ('20', '4', '6', '0356656798470006', 'wangwu', '1', '2018-11-12 14:19:27', '0', null, null, null), ('21', '2', '3', '0363644984620003', 'windy', '1', '2018-11-12 14:20:36', '0', null, null, null), ('22', '3', '3', '0363932820300003', 'windy', '1', '2018-11-12 14:20:39', '0', null, null, null), ('23', '4', '3', '0364238275840003', 'windy', '1', '2018-11-12 14:20:42', '0', null, null, null), ('24', '2', '7', '0385034833070007', 'lion', '1', '2018-11-12 14:24:10', '0', null, null, null), ('25', '3', '7', '0385350208650007', 'lion', '1', '2018-11-12 14:24:13', '0', null, null, null), ('26', '4', '7', '0385632733900007', 'lion', '1', '2018-11-12 14:24:16', '0', null, null, null), ('27', '2', '8', '0388779132990008', 'shari', '1', '2018-11-12 14:24:48', '0', null, null, null), ('28', '3', '8', '0388943658810008', 'shari', '1', '2018-11-12 14:24:49', '0', null, null, null), ('29', '4', '8', '0389069398320008', 'shari', '1', '2018-11-12 14:24:51', '0', null, null, null), ('30', '2', '9', '0390753935250009', 'aewen', '1', '2018-11-12 14:25:08', '0', null, null, null), ('31', '3', '9', '0390882954470009', 'aewen', '1', '2018-11-12 14:25:09', '0', null, null, null), ('32', '4', '9', '0391025542810009', 'aewen', '1', '2018-11-12 14:25:10', '0', null, null, null), ('33', '22', '10', '3672022152670010', null, '1', '2019-12-14 23:18:29', '0', '2020-07-07 17:58:17', null, null), ('34', '22', '10', '9512035983510010', null, '1', '2019-12-15 15:32:00', '0', '2019-12-24 14:00:00', null, null), ('35', '22', '10', '9520935323300010', null, '1', '2019-12-15 15:33:29', '0', '2019-12-15 17:40:00', null, null), ('36', '22', '10', '9527724159050010', null, '1', '2019-12-15 15:34:37', '0', '2019-12-15 17:40:00', null, null), ('37', '22', '10', '9536472921620010', null, '1', '2019-12-15 15:36:05', '0', '2019-12-15 17:50:00', null, null), ('38', '22', '10', '0408799575510010', null, '1', '2019-12-15 18:01:28', '0', null, null, null), ('39', '23', '10', '7146240447970010', 'yoooho', '1', '2020-01-08 16:17:42', '0', null, null, null), ('40', '23', '10', '7146354093880010', 'yoooho', '1', '2020-01-08 16:17:44', '0', null, null, null), ('41', '23', '10', '7146472543930010', 'yoooho', '1', '2020-01-08 16:17:45', '0', null, null, null), ('42', '23', '10', '7146539990060010', 'yoooho', '1', '2020-01-08 16:17:45', '0', null, null, null), ('43', '23', '10', '7146562546140010', 'yoooho', '1', '2020-01-08 16:17:46', '0', null, null, null), ('44', '23', '10', '7146816300500010', 'yoooho', '1', '2020-01-08 16:17:48', '0', null, null, null), ('45', '23', '10', '7146899052670010', 'yoooho', '1', '2020-01-08 16:17:49', '0', null, null, null), ('46', '23', '10', '7146929739020010', 'yoooho', '1', '2020-01-08 16:17:49', '0', null, null, null), ('47', '23', '10', '7147196327720010', 'yoooho', '1', '2020-01-08 16:17:52', '0', null, null, null), ('48', '23', '10', '7150723468960010', 'yoooho', '1', '2020-01-08 16:18:27', '0', null, null, null), ('49', '23', '10', '7150895824910010', 'yoooho', '1', '2020-01-08 16:18:29', '0', null, null, null), ('50', '23', '10', '7150996034950010', 'yoooho', '1', '2020-01-08 16:18:30', '0', null, null, null), ('51', '23', '10', '7151101682820010', 'yoooho', '1', '2020-01-08 16:18:31', '0', null, null, null), ('52', '23', '10', '7263490593190010', 'yoooho', '1', '2020-01-08 16:37:15', '0', null, null, null), ('53', '23', '10', '7271722315690010', 'yoooho', '1', '2020-01-08 16:38:37', '0', null, null, null), ('54', '23', '10', '7284133907320010', 'yoooho', '1', '2020-01-08 16:40:41', '0', null, null, null), ('55', '23', '10', '0194097364930010', 'yoooho', '1', '2020-04-25 16:05:41', '0', null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `sms_coupon_product_category_relation`
-- ----------------------------
DROP TABLE IF EXISTS `sms_coupon_product_category_relation`;
CREATE TABLE `sms_coupon_product_category_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `coupon_id` bigint(20) DEFAULT NULL,
  `product_category_id` bigint(20) DEFAULT NULL,
  `product_category_name` varchar(200) DEFAULT NULL COMMENT '产品分类名称',
  `parent_category_name` varchar(200) DEFAULT NULL COMMENT '父分类名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='优惠券和产品分类关系表';

-- ----------------------------
--  Table structure for `sms_coupon_product_relation`
-- ----------------------------
DROP TABLE IF EXISTS `sms_coupon_product_relation`;
CREATE TABLE `sms_coupon_product_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `coupon_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `product_name` varchar(500) DEFAULT NULL COMMENT '商品名称',
  `product_sn` varchar(200) DEFAULT NULL COMMENT '商品编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='优惠券和产品的关系表';

-- ----------------------------
--  Table structure for `sms_flash_promotion`
-- ----------------------------
DROP TABLE IF EXISTS `sms_flash_promotion`;
CREATE TABLE `sms_flash_promotion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `start_date` date DEFAULT NULL COMMENT '开始日期',
  `end_date` date DEFAULT NULL COMMENT '结束日期',
  `status` int(11) DEFAULT NULL COMMENT '上下线状态',
  `create_time` datetime DEFAULT NULL COMMENT '秒杀时间段名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='限时购表';

-- ----------------------------
--  Records of `sms_flash_promotion`
-- ----------------------------
BEGIN;
INSERT INTO `sms_flash_promotion` VALUES ('2', '春季家电家具疯狂秒杀1', '2019-01-28', '2019-01-15', '0', '2018-11-16 11:12:13'), ('3', '前端测试专用活动', '2018-11-03', '2019-02-28', '1', '2018-11-16 11:11:31'), ('4', '春季家电家具疯狂秒杀3', '2018-11-24', '2018-11-25', '0', '2018-11-16 11:12:19'), ('5', '春季家电家具疯狂秒杀4', '2018-11-16', '2018-11-16', '0', '2018-11-16 11:12:24'), ('6', '春季家电家具疯狂秒杀5', '2018-11-16', '2018-11-16', '0', '2018-11-16 11:12:31'), ('7', '春季家电家具疯狂秒杀6', '2018-11-16', '2018-11-16', '0', '2018-11-16 11:12:35'), ('8', '春季家电家具疯狂秒杀7', '2018-11-16', '2018-11-16', '0', '2018-11-16 11:12:39'), ('9', '春季家电家具疯狂秒杀8', '2018-11-16', '2018-11-16', '0', '2018-11-16 11:12:42'), ('13', '测试', '2018-11-01', '2018-11-30', '0', '2018-11-19 10:34:24');
COMMIT;

-- ----------------------------
--  Table structure for `sms_flash_promotion_log`
-- ----------------------------
DROP TABLE IF EXISTS `sms_flash_promotion_log`;
CREATE TABLE `sms_flash_promotion_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `member_phone` varchar(64) DEFAULT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `subscribe_time` datetime DEFAULT NULL COMMENT '会员订阅时间',
  `send_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='限时购通知记录';

-- ----------------------------
--  Table structure for `sms_flash_promotion_product_relation`
-- ----------------------------
DROP TABLE IF EXISTS `sms_flash_promotion_product_relation`;
CREATE TABLE `sms_flash_promotion_product_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `flash_promotion_id` bigint(20) DEFAULT NULL,
  `flash_promotion_session_id` bigint(20) DEFAULT NULL COMMENT '编号',
  `product_id` bigint(20) DEFAULT NULL,
  `flash_promotion_price` decimal(10,2) DEFAULT NULL COMMENT '限时购价格',
  `flash_promotion_count` int(11) DEFAULT NULL COMMENT '限时购数量',
  `flash_promotion_limit` int(11) DEFAULT NULL COMMENT '每人限购数量',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品限时购与商品关系表';

-- ----------------------------
--  Records of `sms_flash_promotion_product_relation`
-- ----------------------------
BEGIN;
INSERT INTO `sms_flash_promotion_product_relation` VALUES ('1', '2', '1', '26', '3000.00', '10', '1', '0'), ('2', '2', '1', '27', '2000.00', '10', '1', '20'), ('3', '2', '1', '28', '599.00', '19', '1', '0'), ('4', '2', '1', '29', '4999.00', '10', '1', '100'), ('9', '2', '2', '26', '2999.00', '100', '1', '0'), ('10', '2', '2', '27', null, null, null, null), ('11', '2', '2', '28', null, null, null, null), ('12', '2', '2', '29', null, null, null, null), ('13', '2', '2', '30', null, null, null, null), ('14', '2', '3', '31', null, null, null, null), ('15', '2', '3', '32', null, null, null, null), ('16', '2', '4', '33', null, null, null, null), ('17', '2', '4', '34', null, null, null, null), ('18', '2', '5', '36', null, null, null, null), ('19', '2', '6', '33', null, null, null, null), ('20', '2', '6', '34', null, null, null, null), ('21', '3', '1', '26', '3000.00', '100', '1', null), ('22', '3', '1', '27', '1999.00', '10', '1', null), ('23', '3', '1', '28', '599.00', '10', '1', null), ('24', '3', '1', '29', '4999.00', '10', '1', null), ('25', '3', '2', '31', '90.00', '10', '1', null), ('26', '3', '2', '32', '60.00', '10', '1', null), ('27', '3', '2', '33', '2299.00', '10', '1', null), ('28', '3', '2', '34', '3888.00', '10', '1', null), ('29', '3', '3', '36', null, null, null, null), ('30', '3', '3', '35', null, null, null, null), ('31', '3', '3', '31', null, null, null, null), ('32', '3', '3', '32', null, null, null, null), ('33', '3', '4', '26', null, null, null, null), ('34', '3', '4', '27', null, null, null, null), ('35', '3', '4', '28', null, null, null, null), ('36', '3', '4', '29', null, null, null, null), ('37', '3', '5', '26', '3688.00', '100', '1', null), ('38', '3', '5', '27', '2599.00', '10', '1', null), ('39', '3', '5', '28', '599.00', '10', '1', null), ('40', '3', '5', '29', '4999.00', '10', '1', null), ('41', '3', '6', '26', null, null, null, null), ('42', '3', '6', '27', null, null, null, null), ('43', '3', '6', '28', null, null, null, null), ('44', '3', '6', '29', null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `sms_flash_promotion_session`
-- ----------------------------
DROP TABLE IF EXISTS `sms_flash_promotion_session`;
CREATE TABLE `sms_flash_promotion_session` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(200) DEFAULT NULL COMMENT '场次名称',
  `start_time` time DEFAULT NULL COMMENT '每日开始时间',
  `end_time` time DEFAULT NULL COMMENT '每日结束时间',
  `status` int(11) DEFAULT NULL COMMENT '启用状态：0->不启用；1->启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='限时购场次表';

-- ----------------------------
--  Records of `sms_flash_promotion_session`
-- ----------------------------
BEGIN;
INSERT INTO `sms_flash_promotion_session` VALUES ('1', '8:00', '08:00:00', '10:00:33', '1', '2018-11-16 13:22:17'), ('2', '10:00', '10:00:00', '12:00:00', '1', '2018-11-16 13:22:34'), ('3', '12:00', '12:00:00', '14:00:00', '1', '2018-11-16 13:22:37'), ('4', '14:00', '14:00:00', '16:00:00', '1', '2018-11-16 13:22:41'), ('5', '16:00', '16:00:00', '18:00:00', '1', '2018-11-16 13:22:45'), ('6', '18:00', '18:00:00', '20:00:00', '1', '2018-11-16 13:21:34'), ('7', '20:00', '20:00:33', '21:00:33', '1', '2018-11-16 13:22:55');
COMMIT;

-- ----------------------------
--  Table structure for `sms_home_advertise`
-- ----------------------------
DROP TABLE IF EXISTS `sms_home_advertise`;
CREATE TABLE `sms_home_advertise` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `type` int(11) DEFAULT NULL COMMENT '轮播位置：0->PC首页轮播；1->app首页轮播',
  `pic` varchar(500) DEFAULT NULL COMMENT '图片地址',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `status` int(11) DEFAULT NULL COMMENT '上下线状态：0->下线；1->上线',
  `click_count` int(11) DEFAULT NULL COMMENT '点击数',
  `order_count` int(11) DEFAULT NULL COMMENT '下单数',
  `url` varchar(500) DEFAULT NULL COMMENT '链接地址',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `isouter_link` int(11) DEFAULT NULL COMMENT '0->内部链接;1->外部链接',
  `uniapp_url` varchar(255) DEFAULT NULL COMMENT 'uniapp路由',
  `mp_url` varchar(255) DEFAULT NULL COMMENT '小程序路由',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='首页轮播广告表';

-- ----------------------------
--  Records of `sms_home_advertise`
-- ----------------------------
BEGIN;
INSERT INTO `sms_home_advertise` VALUES ('2', '夏季大热促销', '1', 'https://yoooho.bkbedu.com/mall/images/20200108/IMG_3912.JPG', '2018-11-01 14:01:37', '2018-11-15 14:01:37', '1', '0', '0', '/pages/product/product?id=37', '砂糖桔促销', '0', '0', '/pages/product/product?id=37', '/pages/product/product?id=37'), ('3', '夏季大热促销1', '1', 'https://yoooho.bkbedu.com/mall/images/20200108/timg.jpeg', '2018-11-13 14:01:37', '2018-11-13 14:01:37', '1', '0', '0', '/pages/product/product?id=38', '苹果促销', '0', '0', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `sms_home_brand`
-- ----------------------------
DROP TABLE IF EXISTS `sms_home_brand`;
CREATE TABLE `sms_home_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_id` bigint(20) DEFAULT NULL,
  `brand_name` varchar(64) DEFAULT NULL,
  `recommend_status` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='首页推荐品牌表';

-- ----------------------------
--  Records of `sms_home_brand`
-- ----------------------------
BEGIN;
INSERT INTO `sms_home_brand` VALUES ('1', '1', '万和', '1', '200'), ('2', '2', '三星', '1', '0'), ('6', '6', '小米', '1', '300'), ('8', '5', '方太', '1', '100'), ('32', '50', '海澜之家', '1', '0'), ('33', '51', '苹果', '1', '0'), ('35', '3', '华为', '1', '0'), ('36', '4', '格力', '1', '0'), ('37', '5', '方太', '1', '0'), ('38', '1', '万和', '1', '0'), ('39', '21', 'OPPO', '1', '0');
COMMIT;

-- ----------------------------
--  Table structure for `sms_home_nav`
-- ----------------------------
DROP TABLE IF EXISTS `sms_home_nav`;
CREATE TABLE `sms_home_nav` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `url` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `mp_url` varchar(255) DEFAULT NULL COMMENT '小程序路由',
  `uniapp_url` varchar(255) DEFAULT NULL COMMENT 'uniapp路由',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标地址',
  `status` int(11) DEFAULT NULL COMMENT '是否显示（1显示,0不显示）',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='首页导航表';

-- ----------------------------
--  Records of `sms_home_nav`
-- ----------------------------
BEGIN;
INSERT INTO `sms_home_nav` VALUES ('2', '秒杀专区', '/pages/seckill/seckill', '/pages/seckill/seckill', '/pages/seckill/seckill', 'http://localhost:8091/file/pic/秒杀-20200609083125178.png', '1', '0');
COMMIT;

-- ----------------------------
--  Table structure for `sms_home_new_product`
-- ----------------------------
DROP TABLE IF EXISTS `sms_home_new_product`;
CREATE TABLE `sms_home_new_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `product_name` varchar(64) DEFAULT NULL,
  `recommend_status` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='新鲜好物表';

-- ----------------------------
--  Records of `sms_home_new_product`
-- ----------------------------
BEGIN;
INSERT INTO `sms_home_new_product` VALUES ('2', '27', '小米8 全面屏游戏智能手机 6GB+64GB 黑色 全网通4G 双卡双待', '0', '200'), ('8', '26', '华为 HUAWEI P20 ', '0', '0'), ('9', '27', '小米8 全面屏游戏智能手机 6GB+64GB 黑色 全网通4G 双卡双待', '0', '0'), ('10', '28', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '0', '0'), ('11', '29', 'Apple iPhone 8 Plus 64GB 红色特别版 移动联通电信4G手机', '0', '0'), ('12', '30', 'HLA海澜之家简约动物印花短袖T恤', '0', '0'), ('13', '37', '正宗广西砂糖桔', '1', '0'), ('14', '38', '新鲜红富士苹果10斤当季整箱', '1', '0');
COMMIT;

-- ----------------------------
--  Table structure for `sms_home_recommend_product`
-- ----------------------------
DROP TABLE IF EXISTS `sms_home_recommend_product`;
CREATE TABLE `sms_home_recommend_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `product_name` varchar(64) DEFAULT NULL,
  `recommend_status` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='人气推荐商品表';

-- ----------------------------
--  Records of `sms_home_recommend_product`
-- ----------------------------
BEGIN;
INSERT INTO `sms_home_recommend_product` VALUES ('3', '26', '华为 HUAWEI P20 ', '0', '0'), ('4', '27', '小米8 全面屏游戏智能手机 6GB+64GB 黑色 全网通4G 双卡双待', '0', '0'), ('5', '28', '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', '0', '0'), ('6', '29', 'Apple iPhone 8 Plus 64GB 红色特别版 移动联通电信4G手机', '0', '0'), ('7', '30', 'HLA海澜之家简约动物印花短袖T恤', '0', '100'), ('8', '37', '正宗广西砂糖桔', '1', '0'), ('9', '38', '新鲜红富士苹果10斤当季整箱', '1', '0');
COMMIT;

-- ----------------------------
--  Table structure for `sms_home_recommend_subject`
-- ----------------------------
DROP TABLE IF EXISTS `sms_home_recommend_subject`;
CREATE TABLE `sms_home_recommend_subject` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subject_id` bigint(20) DEFAULT NULL,
  `subject_name` varchar(64) DEFAULT NULL,
  `recommend_status` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='首页推荐专题表';

-- ----------------------------
--  Records of `sms_home_recommend_subject`
-- ----------------------------
BEGIN;
INSERT INTO `sms_home_recommend_subject` VALUES ('14', '1', 'polo衬衫的也时尚', '1', '0'), ('15', '2', '大牌手机低价秒', '1', '0'), ('16', '3', '晓龙845新品上市', '1', '0'), ('17', '4', '夏天应该穿什么', '1', '0'), ('18', '5', '夏季精选', '1', '100'), ('19', '6', '品牌手机降价', '1', '0'), ('20', '1', '轮廓分明，双摄手机映现细腻美照', '1', '0'), ('21', '2', '交通拥挤有妙招，电动车小巧穿行无障碍', '1', '0'), ('22', '3', '无酒不成席，甘香白酒开怀助兴', '1', '0'), ('23', '4', '真规划不盲扫，全域清洁净无尘', '1', '0'), ('24', '5', '抑菌更纯净，直饮净水保家人健康', '1', '0'), ('30', '16', '测试', '1', '101');
COMMIT;

-- ----------------------------
--  Table structure for `sms_shop_config`
-- ----------------------------
DROP TABLE IF EXISTS `sms_shop_config`;
CREATE TABLE `sms_shop_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `homeLandPage_id` bigint(20) DEFAULT NULL COMMENT '落地id',
  `start_using` tinyint(1) DEFAULT NULL COMMENT '是否启用首页落地配置',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `sms_shop_config`
-- ----------------------------
BEGIN;
INSERT INTO `sms_shop_config` VALUES ('1', '3', '1');
COMMIT;

-- ----------------------------
--  Table structure for `ums_admin`
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin`;
CREATE TABLE `ums_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT '头像',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` tinyint(1) DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
  `sex` varchar(2) DEFAULT '0' COMMENT '0代表男，1代表女',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `job_id` bigint(20) DEFAULT NULL,
  `dept_id` bigint(20) DEFAULT NULL,
  `last_password_reset_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `dept_id` (`dept_id`) USING BTREE,
  KEY `job_id` (`job_id`) USING BTREE,
  CONSTRAINT `ums_admin_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`),
  CONSTRAINT `ums_admin_ibfk_2` FOREIGN KEY (`job_id`) REFERENCES `ums_job` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='后台用户表';

-- ----------------------------
--  Records of `ums_admin`
-- ----------------------------
BEGIN;
INSERT INTO `ums_admin` VALUES ('1', 'test', '111', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', '328555416@qq.com', '测试账号', null, '2018-09-29 13:55:30', '2018-09-29 13:55:39', '1', '男', '17887513081', '2', '5', null), ('3', 'admin', '$2a$10$3wdU8OhQE8AJlPNGCSMSde4UM624dyzfQnQszPPO7y3tzM0dGLZ.K', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/170157_yIl3_1767531.jpg', 'mailyzhao@163.com', '系统管理员', '系统管理员', '2018-10-08 13:32:47', '2019-03-20 15:38:50', '1', '男', '18125255678', '1', '5', null);
COMMIT;

-- ----------------------------
--  Table structure for `ums_admin_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_login_log`;
CREATE TABLE `ums_admin_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `user_agent` varchar(100) DEFAULT NULL COMMENT '浏览器登录类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='后台用户登录日志表';

-- ----------------------------
--  Records of `ums_admin_login_log`
-- ----------------------------
BEGIN;
INSERT INTO `ums_admin_login_log` VALUES ('5', '3', '2018-12-06 13:59:12', '0:0:0:0:0:0:0:1', null, null), ('6', '3', '2018-12-17 13:23:20', '0:0:0:0:0:0:0:1', null, null), ('7', '3', '2018-12-18 13:51:42', '0:0:0:0:0:0:0:1', null, null), ('8', '3', '2018-12-18 13:51:51', '0:0:0:0:0:0:0:1', null, null), ('9', '3', '2019-01-28 16:20:41', '0:0:0:0:0:0:0:1', null, null), ('10', '3', '2019-01-29 09:16:25', '0:0:0:0:0:0:0:1', null, null), ('11', '3', '2019-01-29 10:10:51', '0:0:0:0:0:0:0:1', null, null), ('12', '3', '2019-02-18 11:03:06', '0:0:0:0:0:0:0:1', null, null), ('13', '3', '2019-03-12 10:03:55', '0:0:0:0:0:0:0:1', null, null), ('14', '3', '2019-03-12 10:06:19', '0:0:0:0:0:0:0:1', null, null), ('15', '3', '2019-03-12 10:15:22', '0:0:0:0:0:0:0:1', null, null), ('16', '3', '2019-03-20 15:35:33', '0:0:0:0:0:0:0:1', null, null), ('17', '3', '2019-03-20 15:38:50', '0:0:0:0:0:0:0:1', null, null), ('18', '3', '2019-11-09 17:43:12', '0:0:0:0:0:0:0:1', null, null), ('19', '3', '2019-11-23 22:27:18', '0:0:0:0:0:0:0:1', null, null), ('20', '3', '2019-12-14 02:25:47', '221.216.140.178', null, null), ('21', '3', '2019-12-14 22:57:24', '221.216.139.116', null, null), ('22', '3', '2019-12-20 15:23:39', '0:0:0:0:0:0:0:1', null, null), ('23', '3', '2019-12-21 10:10:13', '0:0:0:0:0:0:0:1', null, null), ('24', '3', '2019-12-23 11:15:03', '221.217.179.123', null, null), ('25', '3', '2019-12-23 12:13:00', '221.217.179.123', null, null), ('26', '3', '2019-12-23 14:28:57', '221.217.179.123', null, null), ('27', '3', '2019-12-23 14:30:30', '221.217.179.123', null, null), ('28', '3', '2019-12-23 14:39:57', '221.217.179.123', null, null), ('29', '3', '2019-12-24 10:53:29', '0:0:0:0:0:0:0:1', null, null), ('30', '3', '2019-12-24 14:54:01', '0:0:0:0:0:0:0:1', null, null), ('31', '3', '2019-12-25 10:14:51', '0:0:0:0:0:0:0:1', null, null), ('32', '3', '2019-12-25 15:06:16', '0:0:0:0:0:0:0:1', null, null), ('33', '3', '2019-12-26 11:00:35', '127.0.0.1', null, null), ('34', '3', '2019-12-27 11:22:50', '127.0.0.1', null, null), ('35', '3', '2019-12-27 14:20:20', '127.0.0.1', null, null), ('36', '3', '2019-12-28 09:07:00', '0:0:0:0:0:0:0:1', null, null), ('37', '3', '2019-12-31 16:20:29', '127.0.0.1', null, null), ('38', '3', '2020-01-02 14:48:57', '0:0:0:0:0:0:0:1', null, null), ('39', '3', '2020-01-03 14:20:32', '0:0:0:0:0:0:0:1', null, null), ('40', '3', '2020-01-04 11:07:52', '127.0.0.1', null, null), ('41', '3', '2020-01-05 20:48:42', '0:0:0:0:0:0:0:1', null, null), ('42', '3', '2020-01-06 10:25:19', '127.0.0.1', null, null), ('43', '3', '2020-01-06 12:05:13', '127.0.0.1', null, null), ('44', '3', '2020-01-07 10:13:17', '0:0:0:0:0:0:0:1', null, null), ('45', '3', '2020-01-13 13:23:56', '127.0.0.1', null, null), ('46', '3', '2020-01-13 13:32:06', '127.0.0.1', null, null), ('47', '3', '2020-01-13 16:46:23', '127.0.0.1', null, null), ('48', '3', '2020-01-13 16:50:07', '0:0:0:0:0:0:0:1', null, null), ('49', '3', '2020-01-13 17:18:58', '127.0.0.1', null, null), ('50', '3', '2020-01-16 16:32:42', '127.0.0.1', null, null), ('51', '3', '2020-01-17 14:34:33', '0:0:0:0:0:0:0:1', null, null), ('52', '3', '2020-03-31 22:03:29', '127.0.0.1', null, null), ('53', '3', '2020-03-31 22:28:46', '127.0.0.1', null, null), ('54', '3', '2020-04-25 14:21:54', '127.0.0.1', null, null), ('55', '3', '2020-05-12 14:25:28', '0:0:0:0:0:0:0:1', null, null), ('56', '3', '2020-05-12 17:53:25', '0:0:0:0:0:0:0:1', null, null), ('57', '3', '2020-05-12 18:01:46', '0:0:0:0:0:0:0:1', null, null), ('58', '3', '2020-05-12 22:15:22', '0:0:0:0:0:0:0:1', null, null), ('59', '3', '2020-05-13 15:24:34', '0:0:0:0:0:0:0:1', null, null), ('60', '3', '2020-05-13 15:24:51', '0:0:0:0:0:0:0:1', null, null), ('61', '3', '2020-05-13 15:28:12', '0:0:0:0:0:0:0:1', null, null), ('62', '3', '2020-05-13 15:31:49', '0:0:0:0:0:0:0:1', null, null), ('63', '3', '2020-05-14 19:02:24', '0:0:0:0:0:0:0:1', null, null), ('64', '3', '2020-05-15 19:16:56', '0:0:0:0:0:0:0:1', null, null), ('65', '3', '2020-05-16 10:50:15', '0:0:0:0:0:0:0:1', null, null), ('66', '3', '2020-05-16 15:36:02', '0:0:0:0:0:0:0:1', null, null), ('67', '3', '2020-05-17 09:18:03', '0:0:0:0:0:0:0:1', null, null), ('68', '3', '2020-05-17 15:23:59', '0:0:0:0:0:0:0:1', null, null), ('69', '3', '2020-05-18 22:23:48', '0:0:0:0:0:0:0:1', null, null), ('70', '3', '2020-05-19 10:27:08', '0:0:0:0:0:0:0:1', null, null), ('71', '3', '2020-05-19 10:27:11', '0:0:0:0:0:0:0:1', null, null), ('72', '3', '2020-05-19 10:43:52', '0:0:0:0:0:0:0:1', null, null), ('73', '3', '2020-05-19 10:46:06', '0:0:0:0:0:0:0:1', null, null), ('74', '3', '2020-05-19 10:53:16', '0:0:0:0:0:0:0:1', null, null), ('75', '3', '2020-05-19 10:55:32', '0:0:0:0:0:0:0:1', null, null), ('76', '3', '2020-05-19 10:56:02', '0:0:0:0:0:0:0:1', null, null), ('77', '3', '2020-05-19 11:01:17', '0:0:0:0:0:0:0:1', null, null), ('78', '3', '2020-05-19 11:04:24', '0:0:0:0:0:0:0:1', null, null), ('79', '3', '2020-05-19 11:07:40', '0:0:0:0:0:0:0:1', null, null), ('80', '3', '2020-05-19 20:46:40', '0:0:0:0:0:0:0:1', null, null), ('81', '3', '2020-05-20 09:02:10', '0:0:0:0:0:0:0:1', null, null), ('82', '3', '2020-05-20 12:41:40', '0:0:0:0:0:0:0:1', null, null), ('83', '3', '2020-05-20 13:00:55', '0:0:0:0:0:0:0:1', null, null), ('84', '3', '2020-05-20 17:49:40', '0:0:0:0:0:0:0:1', null, null), ('85', '3', '2020-05-21 19:24:38', '0:0:0:0:0:0:0:1', null, null), ('86', '3', '2020-05-21 19:25:16', '0:0:0:0:0:0:0:1', null, null), ('87', '3', '2020-05-22 09:36:46', '0:0:0:0:0:0:0:1', null, null), ('88', '3', '2020-05-22 13:29:40', '0:0:0:0:0:0:0:1', null, null), ('89', '3', '2020-05-23 09:20:13', '0:0:0:0:0:0:0:1', null, null), ('90', '3', '2020-05-23 15:20:50', '0:0:0:0:0:0:0:1', null, null), ('91', '3', '2020-05-23 16:50:29', '0:0:0:0:0:0:0:1', null, null), ('92', '3', '2020-05-24 09:27:55', '0:0:0:0:0:0:0:1', null, null), ('93', '3', '2020-05-24 15:50:14', '0:0:0:0:0:0:0:1', null, null), ('94', '3', '2020-05-25 12:49:48', '0:0:0:0:0:0:0:1', null, null), ('95', '3', '2020-05-25 14:42:17', '0:0:0:0:0:0:0:1', null, null), ('96', '3', '2020-05-25 19:16:14', '0:0:0:0:0:0:0:1', null, null), ('97', '3', '2020-05-26 09:38:35', '0:0:0:0:0:0:0:1', null, null), ('98', '3', '2020-05-26 22:18:13', '0:0:0:0:0:0:0:1', null, null), ('99', '3', '2020-05-27 10:55:33', '0:0:0:0:0:0:0:1', null, null), ('100', '3', '2020-05-27 11:32:47', '0:0:0:0:0:0:0:1', null, null), ('101', '3', '2020-05-27 12:31:30', '0:0:0:0:0:0:0:1', null, null), ('102', '3', '2020-05-30 07:22:04', '0:0:0:0:0:0:0:1', null, null), ('103', '3', '2020-05-30 07:46:13', '0:0:0:0:0:0:0:1', null, null), ('104', '3', '2020-05-31 16:05:57', '0:0:0:0:0:0:0:1', null, null), ('105', '3', '2020-06-03 10:39:11', '0:0:0:0:0:0:0:1', null, null), ('106', '3', '2020-06-04 10:40:51', '0:0:0:0:0:0:0:1', null, null), ('107', '3', '2020-06-06 11:13:47', '0:0:0:0:0:0:0:1', null, null), ('108', '3', '2020-06-07 09:37:29', '0:0:0:0:0:0:0:1', null, null), ('109', '3', '2020-06-09 18:02:15', '0:0:0:0:0:0:0:1', null, null), ('110', '3', '2020-06-11 14:17:34', '0:0:0:0:0:0:0:1', null, null), ('111', '3', '2020-06-13 14:12:03', '0:0:0:0:0:0:0:1', null, null), ('112', '3', '2020-06-15 17:12:34', '0:0:0:0:0:0:0:1', null, null), ('113', '3', '2020-06-17 17:08:12', '0:0:0:0:0:0:0:1', null, null), ('114', '3', '2020-06-17 19:09:40', '0:0:0:0:0:0:0:1', null, null), ('115', '3', '2020-06-20 20:20:04', '0:0:0:0:0:0:0:1', null, null), ('116', '3', '2020-06-20 20:43:44', '0:0:0:0:0:0:0:1', null, null), ('117', '3', '2020-06-20 20:47:34', '0:0:0:0:0:0:0:1', null, null), ('118', '3', '2020-06-21 13:37:19', '0:0:0:0:0:0:0:1', null, null), ('119', '3', '2020-06-24 16:31:30', '0:0:0:0:0:0:0:1', null, null), ('120', '3', '2020-06-25 10:53:41', '0:0:0:0:0:0:0:1', null, null), ('121', '3', '2020-06-25 15:41:19', '0:0:0:0:0:0:0:1', null, null), ('122', '3', '2020-06-30 19:04:37', '0:0:0:0:0:0:0:1', null, null), ('123', '3', '2020-07-01 09:38:34', '0:0:0:0:0:0:0:1', null, null), ('124', '3', '2020-07-02 19:00:28', '0:0:0:0:0:0:0:1', null, null), ('125', '3', '2020-07-03 09:08:15', '0:0:0:0:0:0:0:1', null, null), ('126', '3', '2020-07-06 19:17:46', '0:0:0:0:0:0:0:1', null, null), ('127', '3', '2020-07-07 08:57:45', '0:0:0:0:0:0:0:1', null, null), ('128', '3', '2020-07-14 09:17:09', '0:0:0:0:0:0:0:1', null, null), ('129', '3', '2020-07-20 09:58:17', '127.0.0.1', null, null), ('130', '3', '2020-07-24 14:11:38', '0:0:0:0:0:0:0:1', null, null), ('131', '3', '2020-07-28 16:48:01', '0:0:0:0:0:0:0:1', null, null), ('132', '3', '2020-07-28 17:00:15', '0:0:0:0:0:0:0:1', null, null), ('133', '3', '2020-08-07 14:28:28', '0:0:0:0:0:0:0:1', null, null), ('134', '3', '2020-08-11 09:54:04', '0:0:0:0:0:0:0:1', null, null), ('135', '3', '2020-08-13 09:25:35', '0:0:0:0:0:0:0:1', null, null), ('136', '3', '2020-08-24 11:01:57', '0:0:0:0:0:0:0:1', null, null), ('137', '3', '2020-08-31 09:39:20', '0:0:0:0:0:0:0:1', null, null), ('138', '3', '2020-09-01 14:29:49', '0:0:0:0:0:0:0:1', null, null), ('139', '3', '2020-09-01 14:35:09', '0:0:0:0:0:0:0:1', null, null), ('140', '3', '2020-09-01 17:16:15', '0:0:0:0:0:0:0:1', null, null), ('141', '3', '2020-09-02 10:16:04', '0:0:0:0:0:0:0:1', null, null), ('142', '3', '2020-09-02 10:18:04', '0:0:0:0:0:0:0:1', null, null), ('143', '3', '2020-09-02 10:20:43', '0:0:0:0:0:0:0:1', null, null), ('144', '3', '2020-09-02 10:23:39', '0:0:0:0:0:0:0:1', null, null), ('145', '3', '2020-09-02 10:29:51', '0:0:0:0:0:0:0:1', null, null), ('146', '3', '2020-09-02 10:36:45', '0:0:0:0:0:0:0:1', null, null), ('147', '3', '2020-09-02 13:35:02', '0:0:0:0:0:0:0:1', null, null), ('148', '3', '2020-09-02 13:35:26', '0:0:0:0:0:0:0:1', null, null), ('149', '3', '2020-09-02 13:36:33', '0:0:0:0:0:0:0:1', null, null), ('150', '3', '2020-09-02 14:28:03', '0:0:0:0:0:0:0:1', null, null), ('151', '3', '2020-09-02 15:15:34', '0:0:0:0:0:0:0:1', null, null), ('152', '3', '2020-09-02 15:17:29', '0:0:0:0:0:0:0:1', null, null), ('153', '3', '2020-09-02 15:18:22', '0:0:0:0:0:0:0:1', null, null), ('154', '3', '2020-09-02 15:19:12', '0:0:0:0:0:0:0:1', null, null), ('155', '3', '2020-09-02 15:20:49', '0:0:0:0:0:0:0:1', null, null), ('156', '3', '2020-09-02 15:22:31', '0:0:0:0:0:0:0:1', null, null), ('157', '3', '2020-09-02 15:23:45', '0:0:0:0:0:0:0:1', null, null), ('158', '3', '2020-09-07 14:29:53', '0:0:0:0:0:0:0:1', null, null), ('159', '3', '2020-09-17 09:38:52', '0:0:0:0:0:0:0:1', null, null), ('160', '3', '2020-09-17 13:59:49', '192.168.1.76', null, null), ('161', '3', '2020-09-27 14:19:23', '0:0:0:0:0:0:0:1', null, null), ('162', '3', '2020-10-14 09:42:11', '127.0.0.1', null, null), ('163', '3', '2020-10-16 10:24:18', '0:0:0:0:0:0:0:1', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `ums_admin_permission_relation`
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_permission_relation`;
CREATE TABLE `ums_admin_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='后台用户和权限关系表(除角色中定义的权限以外的加减权限)';

-- ----------------------------
--  Table structure for `ums_admin_role_relation`
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_role_relation`;
CREATE TABLE `ums_admin_role_relation` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`) USING BTREE,
  KEY `role_id` (`role_id`) USING BTREE,
  CONSTRAINT `ums_admin_role_relation_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `ums_admin` (`id`),
  CONSTRAINT `ums_admin_role_relation_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `ums_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='后台用户和角色关系表';

-- ----------------------------
--  Records of `ums_admin_role_relation`
-- ----------------------------
BEGIN;
INSERT INTO `ums_admin_role_relation` VALUES ('3', '1'), ('3', '5');
COMMIT;

-- ----------------------------
--  Table structure for `ums_admin_setting`
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin_setting`;
CREATE TABLE `ums_admin_setting` (
  `id` int(10) unsigned NOT NULL,
  `notification_form_mail` varchar(100) DEFAULT NULL COMMENT '通知发送邮件地址',
  `notification_to_mail` varchar(100) DEFAULT NULL COMMENT '通知接受邮件地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='管理员设置表';

-- ----------------------------
--  Records of `ums_admin_setting`
-- ----------------------------
BEGIN;
INSERT INTO `ums_admin_setting` VALUES ('1', 'service@bkbedu.com', 'mailyzhao@qq.com');
COMMIT;

-- ----------------------------
--  Table structure for `ums_growth_change_history`
-- ----------------------------
DROP TABLE IF EXISTS `ums_growth_change_history`;
CREATE TABLE `ums_growth_change_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `change_type` int(11) DEFAULT NULL COMMENT '改变类型：0->增加；1->减少',
  `change_count` int(11) DEFAULT NULL COMMENT '积分改变数量',
  `operate_man` varchar(100) DEFAULT NULL COMMENT '操作人员',
  `operate_note` varchar(200) DEFAULT NULL COMMENT '操作备注',
  `source_type` int(11) DEFAULT NULL COMMENT '积分来源：0->购物；1->管理员修改',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='成长值变化历史记录表';

-- ----------------------------
--  Records of `ums_growth_change_history`
-- ----------------------------
BEGIN;
INSERT INTO `ums_growth_change_history` VALUES ('1', '1', '2018-08-29 17:16:35', '0', '1000', 'test', '测试使用', '1');
COMMIT;

-- ----------------------------
--  Table structure for `ums_integration_change_history`
-- ----------------------------
DROP TABLE IF EXISTS `ums_integration_change_history`;
CREATE TABLE `ums_integration_change_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `change_type` int(11) DEFAULT NULL COMMENT '改变类型：0->增加；1->减少',
  `change_count` int(11) DEFAULT NULL COMMENT '积分改变数量',
  `operate_man` varchar(100) DEFAULT NULL COMMENT '操作人员',
  `operate_note` varchar(200) DEFAULT NULL COMMENT '操作备注',
  `source_type` int(11) DEFAULT NULL COMMENT '积分来源：0->购物；1->管理员修改',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='积分变化历史记录表';

-- ----------------------------
--  Table structure for `ums_integration_consume_setting`
-- ----------------------------
DROP TABLE IF EXISTS `ums_integration_consume_setting`;
CREATE TABLE `ums_integration_consume_setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `deduction_per_amount` int(11) DEFAULT NULL COMMENT '每一元需要抵扣的积分数量',
  `max_percent_per_order` int(11) DEFAULT NULL COMMENT '每笔订单最高抵用百分比',
  `use_unit` int(11) DEFAULT NULL COMMENT '每次使用积分最小单位100',
  `coupon_status` int(11) DEFAULT NULL COMMENT '是否可以和优惠券同用；0->不可以；1->可以',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='积分消费设置';

-- ----------------------------
--  Records of `ums_integration_consume_setting`
-- ----------------------------
BEGIN;
INSERT INTO `ums_integration_consume_setting` VALUES ('1', '100', '50', '100', '1');
COMMIT;

-- ----------------------------
--  Table structure for `ums_job`
-- ----------------------------
DROP TABLE IF EXISTS `ums_job`;
CREATE TABLE `ums_job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '岗位名称',
  `enabled` bit(1) NOT NULL COMMENT '岗位状态',
  `sort` bigint(20) NOT NULL COMMENT '岗位排序',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `dept_id` (`dept_id`) USING BTREE,
  CONSTRAINT `ums_job_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='岗位表';

-- ----------------------------
--  Records of `ums_job`
-- ----------------------------
BEGIN;
INSERT INTO `ums_job` VALUES ('1', '前端开发工程', b'1', '999', '5', '2020-05-17 12:25:55'), ('2', 'iOS开发工程师', b'1', '999', '5', '2020-05-17 12:26:35');
COMMIT;

-- ----------------------------
--  Table structure for `ums_member`
-- ----------------------------
DROP TABLE IF EXISTS `ums_member`;
CREATE TABLE `ums_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_level_id` bigint(20) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(64) DEFAULT '新用户' COMMENT '昵称',
  `phone` varchar(64) DEFAULT NULL COMMENT '手机号码',
  `status` int(11) DEFAULT NULL COMMENT '帐号启用状态:0->禁用；1->启用',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  `icon` varchar(500) DEFAULT NULL COMMENT '头像',
  `gender` int(11) DEFAULT NULL COMMENT '性别：0->未知；1->男；2->女',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `city` varchar(64) DEFAULT NULL COMMENT '所做城市',
  `job` varchar(100) DEFAULT NULL COMMENT '职业',
  `personalized_signature` varchar(200) DEFAULT NULL COMMENT '个性签名',
  `source_type` int(11) DEFAULT NULL COMMENT '用户来源',
  `integration` int(11) DEFAULT NULL COMMENT '积分',
  `growth` int(11) DEFAULT NULL COMMENT '成长值',
  `luckey_count` int(11) DEFAULT NULL COMMENT '剩余抽奖次数',
  `history_integration` int(11) DEFAULT NULL COMMENT '历史积分数量',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_username` (`username`) USING BTREE,
  UNIQUE KEY `idx_phone` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='会员表';

-- ----------------------------
--  Records of `ums_member`
-- ----------------------------
BEGIN;
INSERT INTO `ums_member` VALUES ('1', '4', 'test', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'windir', '18061581849', '1', '2018-08-02 10:35:44', null, '1', '2009-06-01', '上海', '学生', 'test', null, '5000', null, null, null), ('3', '4', 'windy', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'windy', '18061581848', '1', '2018-08-03 16:46:38', null, null, null, null, null, null, null, null, null, null, null), ('4', '4', 'zhengsan', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'zhengsan', '18061581847', '1', '2018-11-12 14:12:04', null, null, null, null, null, null, null, null, null, null, null), ('5', '4', 'lisi', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'lisi', '18061581841', '1', '2018-11-12 14:12:38', null, null, null, null, null, null, null, null, null, null, null), ('6', '4', 'wangwu', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'wangwu', '18061581842', '1', '2018-11-12 14:13:09', null, null, null, null, null, null, null, null, null, null, null), ('7', '4', 'lion', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'lion', '18061581845', '1', '2018-11-12 14:21:39', null, null, null, null, null, null, null, null, null, null, null), ('8', '4', 'shari', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'shari', '18061581844', '1', '2018-11-12 14:22:00', null, null, null, null, null, null, null, null, null, null, null), ('9', '4', 'aewen', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'aewen', '18061581843', '1', '2018-11-12 14:22:55', null, null, null, null, null, null, null, null, null, null, null), ('10', '4', '新用户', null, 'yoooho', '18125255678', '1', '2019-11-23 10:49:21', null, '2', '2018-01-01', '北京市市辖区东城区', '开发工程师', null, null, null, null, null, null), ('14', '4', '用户14', null, 'jimmy', '13522136772', '1', '2020-01-09 11:24:07', null, null, null, null, null, null, null, null, null, null, null), ('15', '4', '用户15', null, null, '13199069990', '1', '2020-03-28 15:20:39', null, null, null, null, null, null, null, null, null, null, null), ('16', '4', '用户16', null, '1812525678', '1812525678', '1', '2020-07-16 10:11:52', null, null, null, null, null, null, null, null, null, null, null), ('17', '4', '用户17', null, '18182525678', '18182525678', '1', '2020-07-16 10:43:01', null, null, null, null, null, null, null, null, null, null, null), ('18', '4', '用户18', null, '17887513081', '17887513081', '1', '2020-07-16 15:11:29', null, null, null, null, null, null, null, null, null, null, null), ('19', '4', '用户19', null, '', '', '1', '2020-10-14 14:40:06', null, null, null, null, null, null, null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `ums_member_level`
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_level`;
CREATE TABLE `ums_member_level` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `growth_point` int(11) DEFAULT NULL,
  `default_status` int(11) DEFAULT NULL COMMENT '是否为默认等级：0->不是；1->是',
  `free_freight_point` decimal(10,2) DEFAULT NULL COMMENT '免运费标准',
  `comment_growth_point` int(11) DEFAULT NULL COMMENT '每次评价获取的成长值',
  `priviledge_free_freight` int(11) DEFAULT NULL COMMENT '是否有免邮特权',
  `priviledge_sign_in` int(11) DEFAULT NULL COMMENT '是否有签到特权',
  `priviledge_comment` int(11) DEFAULT NULL COMMENT '是否有评论获奖励特权',
  `priviledge_promotion` int(11) DEFAULT NULL COMMENT '是否有专享活动特权',
  `priviledge_member_price` int(11) DEFAULT NULL COMMENT '是否有会员价格特权',
  `priviledge_birthday` int(11) DEFAULT NULL COMMENT '是否有生日特权',
  `note` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='会员等级表';

-- ----------------------------
--  Records of `ums_member_level`
-- ----------------------------
BEGIN;
INSERT INTO `ums_member_level` VALUES ('1', '黄金会员', '1000', '0', '199.00', '5', '1', '1', '1', '1', '1', '1', null), ('2', '白金会员', '5000', '0', '99.00', '10', '1', '1', '1', '1', '1', '1', null), ('3', '钻石会员', '15000', '0', '69.00', '15', '1', '1', '1', '1', '1', '1', null), ('4', '普通会员', '1', '1', '199.00', '20', '1', '1', '1', '1', '0', '0', null);
COMMIT;

-- ----------------------------
--  Table structure for `ums_member_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_login_log`;
CREATE TABLE `ums_member_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `city` varchar(64) DEFAULT NULL,
  `login_type` int(11) DEFAULT NULL COMMENT '登录类型：0->PC；1->android;2->ios;3->小程序',
  `province` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='会员登录记录';

-- ----------------------------
--  Table structure for `ums_member_member_tag_relation`
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_member_tag_relation`;
CREATE TABLE `ums_member_member_tag_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `tag_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户和标签关系表';

-- ----------------------------
--  Table structure for `ums_member_product_category_relation`
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_product_category_relation`;
CREATE TABLE `ums_member_product_category_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `product_category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='会员与产品分类关系表（用户喜欢的分类）';

-- ----------------------------
--  Table structure for `ums_member_receive_address`
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_receive_address`;
CREATE TABLE `ums_member_receive_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '收货人名称',
  `phone_number` varchar(64) DEFAULT NULL,
  `default_status` int(11) DEFAULT NULL COMMENT '是否为默认',
  `post_code` varchar(100) DEFAULT NULL COMMENT '邮政编码',
  `province` varchar(100) DEFAULT NULL COMMENT '省份/直辖市',
  `city` varchar(100) DEFAULT NULL COMMENT '城市',
  `region` varchar(100) DEFAULT NULL COMMENT '区',
  `detail_address` varchar(128) DEFAULT NULL COMMENT '详细地址(街道)',
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='会员收货地址表';

-- ----------------------------
--  Records of `ums_member_receive_address`
-- ----------------------------
BEGIN;
INSERT INTO `ums_member_receive_address` VALUES ('1', '1', '大梨', '18033441849', '0', '518000', '广东省', '深圳市', '南山区', '科兴科学园', null), ('3', '1', '大梨', '18033441849', '0', '518000', '广东省', '深圳市', '福田区', '清水河街道', null), ('4', '1', '大梨', '18033441849', '1', '518000', '广东省', '深圳市', '福田区', '东晓街道', null), ('5', '10', '赵阳', '18125255678', '1', null, '北京市', '北京市', '东城区', 'CoCo都可(阳光鑫隆店)', '北京市 北京市 东城区'), ('6', '18', 'yoooho', '17887153081', '1', null, '北京市', '北京市', '东城区', '诗的远方', '北京市 北京市 东城区');
COMMIT;

-- ----------------------------
--  Table structure for `ums_member_rule_setting`
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_rule_setting`;
CREATE TABLE `ums_member_rule_setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `continue_sign_day` int(11) DEFAULT NULL COMMENT '连续签到天数',
  `continue_sign_point` int(11) DEFAULT NULL COMMENT '连续签到赠送数量',
  `consume_per_point` decimal(10,2) DEFAULT NULL COMMENT '每消费多少元获取1个点',
  `low_order_amount` decimal(10,2) DEFAULT NULL COMMENT '最低获取点数的订单金额',
  `max_point_per_order` int(11) DEFAULT NULL COMMENT '每笔订单最高获取点数',
  `type` int(11) DEFAULT NULL COMMENT '类型：0->积分规则；1->成长值规则',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='会员积分成长规则表';

-- ----------------------------
--  Table structure for `ums_member_statistics_info`
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_statistics_info`;
CREATE TABLE `ums_member_statistics_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `consume_amount` decimal(10,2) DEFAULT NULL COMMENT '累计消费金额',
  `order_count` int(11) DEFAULT NULL COMMENT '订单数量',
  `coupon_count` int(11) DEFAULT NULL COMMENT '优惠券数量',
  `comment_count` int(11) DEFAULT NULL COMMENT '评价数',
  `return_order_count` int(11) DEFAULT NULL COMMENT '退货数量',
  `login_count` int(11) DEFAULT NULL COMMENT '登录次数',
  `attend_count` int(11) DEFAULT NULL COMMENT '关注数量',
  `fans_count` int(11) DEFAULT NULL COMMENT '粉丝数量',
  `collect_product_count` int(11) DEFAULT NULL,
  `collect_subject_count` int(11) DEFAULT NULL,
  `collect_topic_count` int(11) DEFAULT NULL,
  `collect_comment_count` int(11) DEFAULT NULL,
  `invite_friend_count` int(11) DEFAULT NULL,
  `recent_order_time` datetime DEFAULT NULL COMMENT '最后一次下订单时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='会员统计信息';

-- ----------------------------
--  Table structure for `ums_member_tag`
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_tag`;
CREATE TABLE `ums_member_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `finish_order_count` int(11) DEFAULT NULL COMMENT '自动打标签完成订单数量',
  `finish_order_amount` decimal(10,2) DEFAULT NULL COMMENT '自动打标签完成订单金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户标签表';

-- ----------------------------
--  Table structure for `ums_member_task`
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_task`;
CREATE TABLE `ums_member_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `growth` int(11) DEFAULT NULL COMMENT '赠送成长值',
  `intergration` int(11) DEFAULT NULL COMMENT '赠送积分',
  `type` int(11) DEFAULT NULL COMMENT '任务类型：0->新手任务；1->日常任务',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='会员任务表';

-- ----------------------------
--  Table structure for `ums_member_wxoffice`
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_wxoffice`;
CREATE TABLE `ums_member_wxoffice` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL,
  `open_id` varchar(110) NOT NULL DEFAULT '',
  `union_id` varchar(110) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='绑定微信表';

-- ----------------------------
--  Records of `ums_member_wxoffice`
-- ----------------------------
BEGIN;
INSERT INTO `ums_member_wxoffice` VALUES ('4', '10', 'op1sC0qmKIBhjqhkVQn_0rcy5POo', null, '2020-10-15 16:40:18');
COMMIT;

-- ----------------------------
--  Table structure for `ums_permission`
-- ----------------------------
DROP TABLE IF EXISTS `ums_permission`;
CREATE TABLE `ums_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL COMMENT '父级权限id',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `value` varchar(200) DEFAULT NULL COMMENT '权限值',
  `icon` varchar(500) DEFAULT NULL COMMENT '图标',
  `type` int(11) DEFAULT NULL COMMENT '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
  `uri` varchar(200) DEFAULT NULL COMMENT '前端资源路径',
  `status` int(11) DEFAULT NULL COMMENT '启用状态；0->禁用；1->启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='后台用户权限表';

-- ----------------------------
--  Records of `ums_permission`
-- ----------------------------
BEGIN;
INSERT INTO `ums_permission` VALUES ('1', '0', '商品', null, null, '0', null, '1', '2018-09-29 16:15:14', '0'), ('2', '1', '商品列表', 'pms:product:read', null, '1', '/pms/product/index', '1', '2018-09-29 16:17:01', '0'), ('3', '1', '添加商品', 'pms:product:create', null, '1', '/pms/product/add', '1', '2018-09-29 16:18:51', '0'), ('4', '1', '商品分类', 'pms:productCategory:read', null, '1', '/pms/productCate/index', '1', '2018-09-29 16:23:07', '0'), ('5', '1', '商品类型', 'pms:productAttribute:read', null, '1', '/pms/productAttr/index', '1', '2018-09-29 16:24:43', '0'), ('6', '1', '品牌管理', 'pms:brand:read', null, '1', '/pms/brand/index', '1', '2018-09-29 16:25:45', '0'), ('7', '2', '编辑商品', 'pms:product:update', null, '2', '/pms/product/updateProduct', '1', '2018-09-29 16:34:23', '0'), ('8', '2', '删除商品', 'pms:product:delete', null, '2', '/pms/product/delete', '1', '2018-09-29 16:38:33', '0'), ('9', '4', '添加商品分类', 'pms:productCategory:create', null, '2', '/pms/productCate/create', '1', '2018-09-29 16:43:23', '0'), ('10', '4', '修改商品分类', 'pms:productCategory:update', null, '2', '/pms/productCate/update', '1', '2018-09-29 16:43:55', '0'), ('11', '4', '删除商品分类', 'pms:productCategory:delete', null, '2', '/pms/productAttr/delete', '1', '2018-09-29 16:44:38', '0'), ('12', '5', '添加商品类型', 'pms:productAttribute:create', null, '2', '/pms/productAttr/create', '1', '2018-09-29 16:45:25', '0'), ('13', '5', '修改商品类型', 'pms:productAttribute:update', null, '2', '/pms/productAttr/update', '1', '2018-09-29 16:48:08', '0'), ('14', '5', '删除商品类型', 'pms:productAttribute:delete', null, '2', '/pms/productAttr/delete', '1', '2018-09-29 16:48:44', '0'), ('15', '6', '添加品牌', 'pms:brand:create', null, '2', '/pms/brand/add', '1', '2018-09-29 16:49:34', '0'), ('16', '6', '修改品牌', 'pms:brand:update', null, '2', '/pms/brand/update', '1', '2018-09-29 16:50:55', '0'), ('17', '6', '删除品牌', 'pms:brand:delete', null, '2', '/pms/brand/delete', '1', '2018-09-29 16:50:59', '0'), ('18', '0', '首页', null, null, '0', null, '1', '2018-09-29 16:51:57', '0');
COMMIT;

-- ----------------------------
--  Table structure for `ums_role`
-- ----------------------------
DROP TABLE IF EXISTS `ums_role`;
CREATE TABLE `ums_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `remark` varchar(500) DEFAULT NULL COMMENT '描述',
  `admin_count` int(11) DEFAULT NULL COMMENT '后台用户数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int(11) DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
  `sort` int(11) DEFAULT '0',
  `level` varchar(255) DEFAULT NULL COMMENT '角色级别',
  `data_scope` varchar(255) DEFAULT NULL COMMENT '数据权限',
  `permission` varchar(255) DEFAULT NULL COMMENT '功能权限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='后台用户角色表';

-- ----------------------------
--  Records of `ums_role`
-- ----------------------------
BEGIN;
INSERT INTO `ums_role` VALUES ('1', '商品管理员', '商品管理员', '0', '2018-09-30 15:46:11', '1', '0', '2', null, null), ('2', '商品分类管理员', '商品分类管理员', '0', '2018-09-30 15:53:45', '1', '0', '2', null, null), ('3', '商品类型管理员', '商品类型管理员', '0', '2018-09-30 15:53:56', '1', '0', '2', null, null), ('4', '品牌管理员', '品牌管理员', '0', '2018-09-30 15:54:12', '1', '0', '2', null, null), ('5', '超级管理员', '超级管理员', '1', '2020-05-17 14:35:17', '1', '0', '1', '全部', 'admin');
COMMIT;

-- ----------------------------
--  Table structure for `ums_role_permission_relation`
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_permission_relation`;
CREATE TABLE `ums_role_permission_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='后台用户角色和权限关系表';

-- ----------------------------
--  Records of `ums_role_permission_relation`
-- ----------------------------
BEGIN;
INSERT INTO `ums_role_permission_relation` VALUES ('1', '1', '1'), ('2', '1', '2'), ('3', '1', '3'), ('4', '1', '7'), ('5', '1', '8'), ('6', '2', '4'), ('7', '2', '9'), ('8', '2', '10'), ('9', '2', '11'), ('10', '3', '5'), ('11', '3', '12'), ('12', '3', '13'), ('13', '3', '14'), ('14', '4', '6'), ('15', '4', '15'), ('16', '4', '16'), ('17', '4', '17');
COMMIT;

-- ----------------------------
--  Table structure for `ums_sender_address`
-- ----------------------------
DROP TABLE IF EXISTS `ums_sender_address`;
CREATE TABLE `ums_sender_address` (
  `id` bigint(20) unsigned NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `phone_number` varchar(64) DEFAULT NULL,
  `default_status` int(11) DEFAULT NULL,
  `province` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `region` varchar(100) DEFAULT NULL,
  `detail_address` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='发货地址表';

-- ----------------------------
--  Records of `ums_sender_address`
-- ----------------------------
BEGIN;
INSERT INTO `ums_sender_address` VALUES ('2', '赵阳', '18125255678', '1', '天津市', '市辖区', '和平区', '发的发生的');
COMMIT;

-- ----------------------------
--  Table structure for `verification_code`
-- ----------------------------
DROP TABLE IF EXISTS `verification_code`;
CREATE TABLE `verification_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '验证码',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `type` varchar(255) DEFAULT NULL COMMENT '验证码类型：email或者短信',
  `status` bit(1) DEFAULT NULL COMMENT '状态：1有效、0过期',
  `value` varchar(255) DEFAULT NULL COMMENT '接收邮箱或者手机号码',
  `scenes` varchar(255) DEFAULT NULL COMMENT '业务名称：如重置邮箱、重置密码等',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='验证码校验表';

-- ----------------------------
--  Records of `verification_code`
-- ----------------------------
BEGIN;
INSERT INTO `verification_code` VALUES ('1', '801809', '2020-05-13 14:15:33', 'email', b'1', '11111', '重置邮箱'), ('2', '468948', '2020-05-13 14:15:51', 'email', b'1', '328555416@qq.com', '重置邮箱'), ('3', '358180', '2020-05-13 14:49:52', 'email', b'0', 'mailyzhao@163.com', '重置邮箱'), ('4', '997825', '2020-05-13 15:33:25', 'email', b'0', 'mailyzhao@163.com', '重置邮箱'), ('5', '187173', '2020-05-13 16:19:53', 'email', b'0', 'mailyzhao@163.com', '重置邮箱'), ('6', '648162', '2020-05-13 16:21:26', 'email', b'0', 'mailyzhao@163.com', '重置邮箱');
COMMIT;

-- ----------------------------
--  Table structure for `wechat_article`
-- ----------------------------
DROP TABLE IF EXISTS `wechat_article`;
CREATE TABLE `wechat_article` (
  `id` int(10) unsigned NOT NULL,
  `cid` varchar(255) DEFAULT '1' COMMENT '分类id',
  `title` varchar(255) NOT NULL COMMENT '文章标题',
  `author` varchar(255) DEFAULT NULL COMMENT '文章作者',
  `image_input` varchar(255) NOT NULL COMMENT '文章图片',
  `synopsis` varchar(255) DEFAULT NULL COMMENT '文章简介',
  `content` text,
  `share_title` varchar(255) DEFAULT NULL COMMENT '文章分享标题',
  `share_synopsis` varchar(255) DEFAULT NULL COMMENT '文章分享简介',
  `visit` varchar(255) DEFAULT NULL COMMENT '浏览次数',
  `sort` int(10) unsigned DEFAULT NULL COMMENT '排序',
  `url` varchar(255) DEFAULT NULL COMMENT '原文链接',
  `status` tinyint(3) unsigned DEFAULT NULL COMMENT '状态',
  `add_time` varchar(255) DEFAULT NULL COMMENT '添加时间',
  `hide` varchar(255) DEFAULT NULL COMMENT '是否隐藏',
  `admin_id` int(10) unsigned DEFAULT NULL COMMENT '管理员id',
  `mer_id` int(10) unsigned DEFAULT NULL COMMENT '商户id',
  `product_id` int(11) DEFAULT NULL COMMENT '产品关联id',
  `is_hot` tinyint(3) unsigned DEFAULT NULL COMMENT '是否热门(小程序)',
  `is_banner` tinyint(3) unsigned DEFAULT NULL COMMENT 'tinyint unsigned',
  `media_id` varchar(255) DEFAULT NULL COMMENT '文章管理ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `wechat_article`
-- ----------------------------
BEGIN;
INSERT INTO `wechat_article` VALUES ('1', '', '图文1', '赵阳', 'http://localhost:8091/file/pic/微信图片_202004251523168-20200520063636108.jpg', '测试', '<p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/pcmoren_tian_org.png\" alt=\"[舔屏]\" data-w-e=\"1\"><br></p>', '', '', '', null, null, null, '2020-05-23 13:59', '', null, null, null, null, null, 'npfm19T1I4dB4rq1_WXe5xubwOmnex5uhzTM5rAY9Nw'), ('2', '', '3', '4', 'http://localhost:8091/file/pic/微信图片_2020042515231614-20200520062150726.jpg', '请问', '<p>恶趣味</p>', '', '', '', null, null, null, '2020-05-23 14:03', '', null, null, null, null, null, 'npfm19T1I4dB4rq1_WXe58Jm-kLoxNpnHPAEV6hU0s0'), ('3', '', '3', '4', 'http://localhost:8091/file/pic/微信图片_2020042515231614-20200520062150726.jpg', '请问', '<p>恶趣味</p>', '', '', '', null, null, null, '2020-05-23 14:07', '', null, null, null, null, null, 'npfm19T1I4dB4rq1_WXe5_lIOPW3xpN9N_tjOVVitmI'), ('4', '', '这是一个测试标题', '赵阳', 'http://localhost:8091/file/pic/微信图片_2020042515231614-20200520062150726.jpg', '测试简介', '<p>测试正文</p>', '', '', '', null, 'http://mp.weixin.qq.com/s?__biz=MzIzNDk0Mjk3MQ==&mid=100000017&idx=1&sn=67fd0651a53d0a04707d094343c2f764&chksm=68eff9855f987093df85ab11eaae013374800e482b4d2cafd26bccdfe6689e7e10fb847689f7#rd', null, '2020-05-23 17:46', '', null, null, null, null, null, 'npfm19T1I4dB4rq1_WXe51JnrAge_Ne619yJawGL_bs');
COMMIT;

-- ----------------------------
--  Table structure for `wechat_article_origin`
-- ----------------------------
DROP TABLE IF EXISTS `wechat_article_origin`;
CREATE TABLE `wechat_article_origin` (
  `mid` varchar(255) NOT NULL,
  `thumb_media_id` varchar(255) DEFAULT NULL,
  `thumb_url` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content_source_url` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `digest` varchar(255) DEFAULT NULL,
  `showc_cover_pic` tinyint(1) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `need_open_comment` tinyint(1) DEFAULT NULL,
  `only_fans_can_comment` tinyint(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `wechat_article_origin`
-- ----------------------------
BEGIN;
INSERT INTO `wechat_article_origin` VALUES ('npfm19T1I4dB4rq1_WXe51JnrAge_Ne619yJawGL_bs', 'npfm19T1I4dB4rq1_WXe5xZ9qjgpD57BQvFiR2scPBg', 'http://mmbiz.qpic.cn/mmbiz_jpg/F55rfyiaP79CDvo2fiaVgBwTIc1x7Pjwdzj8TKbOwEXtGSdGkZh8g00v5usqnBrucVwzVhKicKOEBxuoqVuCcsrVw/0?wx_fmt=jpeg', '赵阳', '这是一个测试标题', 'http://mp.weixin.qq.com/s?__biz=MzIzNDk0Mjk3MQ==&mid=100000017&idx=1&sn=67fd0651a53d0a04707d094343c2f764&chksm=68eff9855f987093df85ab11eaae013374800e482b4d2cafd26bccdfe6689e7e10fb847689f7#rd', '<p>测试正文</p>', '测试简介', '1', 'http://mp.weixin.qq.com/s?__biz=MzIzNDk0Mjk3MQ==&mid=100000017&idx=1&sn=67fd0651a53d0a04707d094343c2f764&chksm=68eff9855f987093df85ab11eaae013374800e482b4d2cafd26bccdfe6689e7e10fb847689f7#rd', '0', '0', '2020-05-23 17:46:07', '2020-05-23 17:49:49');
COMMIT;

-- ----------------------------
--  Table structure for `wechat_fans`
-- ----------------------------
DROP TABLE IF EXISTS `wechat_fans`;
CREATE TABLE `wechat_fans` (
  `openid` varchar(50) NOT NULL DEFAULT '' COMMENT '微信openid',
  `phone` char(11) DEFAULT NULL COMMENT '手机号',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `sex` int(11) DEFAULT NULL COMMENT '性别(0-未知、1-男、2-女)',
  `city` varchar(20) DEFAULT NULL COMMENT '城市',
  `province` varchar(20) DEFAULT NULL COMMENT '省份',
  `headimgurl` varchar(255) DEFAULT NULL COMMENT '头像',
  `subscribe_time` datetime DEFAULT NULL COMMENT '订阅时间',
  `unionid` varchar(50) DEFAULT NULL COMMENT 'unionid',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `tagid_list` json DEFAULT NULL,
  `subscribe_scene` varchar(110) DEFAULT NULL,
  `qr_scene_str` varchar(11) DEFAULT NULL,
  `subscribe` int(11) DEFAULT NULL,
  PRIMARY KEY (`openid`) USING BTREE,
  FULLTEXT KEY `unionid` (`unionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `wechat_fans`
-- ----------------------------
BEGIN;
INSERT INTO `wechat_fans` VALUES ('o-0_RwEk5977bwr5sv_kphwatafo', null, '赵小阳', '1', '', '', 'http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLD6vPU2TBhicMsG0icqSDT6lvV3SaDduzzy1UlHGmOv8MibUfThZp1Sib2SJesJmiaLfePiaiaHYySFueQJA/132', '1970-01-19 17:42:10', null, '', '[2, 101, 102]', 'ADD_SCENE_QR_CODE', '', '1');
COMMIT;

-- ----------------------------
--  Table structure for `wechat_menu`
-- ----------------------------
DROP TABLE IF EXISTS `wechat_menu`;
CREATE TABLE `wechat_menu` (
  `name` varchar(255) NOT NULL,
  `result` text,
  `add_time` datetime DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `wechat_msg`
-- ----------------------------
DROP TABLE IF EXISTS `wechat_msg`;
CREATE TABLE `wechat_msg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `openid` varchar(32) NOT NULL DEFAULT '' COMMENT '微信用户ID',
  `in_out` tinyint(3) unsigned DEFAULT NULL COMMENT '消息方向',
  `msg_type` char(25) DEFAULT NULL COMMENT '消息类型',
  `detail` json DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `wechat_msg`
-- ----------------------------
BEGIN;
INSERT INTO `wechat_msg` VALUES ('1', 'o-0_RwEk5977bwr5sv_kphwatafo', '0', 'text', '{\"content\": \"1\"}', '2020-05-26 09:36:15'), ('2', 'o-0_RwEk5977bwr5sv_kphwatafo', '1', 'text', '{\"content\": \"我是测试1\"}', '2020-05-26 09:36:17'), ('3', 'o-0_RwEk5977bwr5sv_kphwatafo', '0', 'text', '{\"content\": \"2\"}', '2020-05-26 09:36:33'), ('4', 'o-0_RwEk5977bwr5sv_kphwatafo', '1', 'text', '{\"content\": \"测试2<a href=\\\"https://www.baidu.com/\\\">百度</a>\"}', '2020-05-26 09:36:34'), ('5', 'o-0_RwEk5977bwr5sv_kphwatafo', '0', 'text', '{\"content\": \"3\"}', '2020-05-26 09:36:40'), ('6', 'o-0_RwEk5977bwr5sv_kphwatafo', '0', 'text', '{\"content\": \"4\"}', '2020-05-26 09:36:49'), ('7', 'o-0_RwEk5977bwr5sv_kphwatafo', '1', 'image', '{\"mediaId\": \"npfm19T1I4dB4rq1_WXe59gM37xkn_3LaHF8MydwSMg\"}', '2020-05-26 09:36:50'), ('8', 'o-0_RwEk5977bwr5sv_kphwatafo', '0', 'text', '{\"content\": \"5\"}', '2020-05-26 09:37:03'), ('9', 'o-0_RwEk5977bwr5sv_kphwatafo', '0', 'text', '{\"content\": \"6\"}', '2020-05-26 09:37:12'), ('10', 'o-0_RwEk5977bwr5sv_kphwatafo', '0', 'text', '{\"content\": \"新闻\"}', '2020-05-26 09:37:18'), ('11', 'o-0_RwEk5977bwr5sv_kphwatafo', '1', 'news', '{\"desc\": \"新闻简介\", \"link\": \"https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Getting_Permanent_Assets.html\", \"image\": \"https://yoooho.bkbedu.com/mall/images/20200425/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_202004251523167.jpg\", \"title\": \"新闻标题\"}', '2020-05-26 09:37:19'), ('12', 'o-0_RwEk5977bwr5sv_kphwatafo', '0', 'text', '{\"content\": \"视频\"}', '2020-05-26 09:37:27'), ('13', 'o-0_RwEk5977bwr5sv_kphwatafo', '0', 'text', '{\"content\": \"图文\"}', '2020-05-26 09:38:22'), ('14', 'o-0_RwEk5977bwr5sv_kphwatafo', '1', 'mpnews', '{\"mediaId\": \"1\"}', '2020-05-26 09:38:23'), ('15', 'o-0_RwEk5977bwr5sv_kphwatafo', '0', 'text', '{\"content\": \"10\"}', '2020-05-26 09:38:44'), ('16', 'o-0_RwEk5977bwr5sv_kphwatafo', '1', 'video', '{\"mediaId\": \"npfm19T1I4dB4rq1_WXe56AyelXxlE6Q6BxUit_SCB8\"}', '2020-05-26 09:38:45'), ('17', 'o-0_RwEk5977bwr5sv_kphwatafo', '1', 'text', '{\"content\": \"1\"}', '2020-05-26 10:54:00'), ('18', 'o-0_RwEk5977bwr5sv_kphwatafo', '0', 'text', '{\"content\": \"客服\"}', '2020-05-26 11:52:02');
COMMIT;

-- ----------------------------
--  Table structure for `wechat_reply`
-- ----------------------------
DROP TABLE IF EXISTS `wechat_reply`;
CREATE TABLE `wechat_reply` (
  `id` bigint(20) unsigned NOT NULL,
  `match_value` varchar(64) NOT NULL DEFAULT '' COMMENT '关键字',
  `reply_type` varchar(32) NOT NULL DEFAULT 'text' COMMENT '回复类型',
  `reply_content` varchar(255) NOT NULL DEFAULT '' COMMENT '回复数据',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '0=不可用  1 =可用',
  `hide` int(11) DEFAULT '0' COMMENT '是否隐藏',
  `rule_name` varchar(20) DEFAULT NULL COMMENT '规则名称',
  `exact_match` int(11) DEFAULT NULL COMMENT '是否精确匹配',
  `desc` varchar(200) DEFAULT NULL COMMENT '备注说明',
  `effect_time_start` time DEFAULT '00:00:00' COMMENT '生效起始时间',
  `effect_time_end` time DEFAULT '23:59:59' COMMENT '生效结束时间',
  `update_time` datetime DEFAULT NULL COMMENT '规则优先级',
  `priority` int(11) DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `wechat_reply`
-- ----------------------------
BEGIN;
INSERT INTO `wechat_reply` VALUES ('1', 'subscribe', 'text', 'test', '1', null, '文本消息', '1', null, null, null, null, null), ('3', '1', 'text', '我是测试1', '1', null, '100', '1', '测试1', '00:00:00', '23:59:59', '2020-05-23 11:28:45', '0'), ('4', '2', 'text', '测试2<a href=\"https://www.baidu.com/\">百度</a>', '1', null, '2', '1', '测试222', '00:00:00', '23:59:59', '2020-05-23 11:58:14', '0'), ('6', '4', 'image', 'npfm19T1I4dB4rq1_WXe59gM37xkn_3LaHF8MydwSMg', '1', null, '4', '0', '测试4', '00:00:00', '23:59:59', '2020-05-23 12:04:53', '0'), ('7', '5', 'news', '', '1', null, '5', '0', '测试5', '00:00:00', '23:59:59', '2020-05-23 12:05:33', null), ('9', '7', 'text', '7', '1', null, '7', '0', '7', '00:00:00', '23:59:59', '2020-05-23 12:07:09', null), ('15', '新闻', 'news', '15', '1', null, '新闻', '0', '', '00:00:00', '23:59:59', '2020-05-24 12:35:27', null), ('16', '10', 'video', 'npfm19T1I4dB4rq1_WXe56AyelXxlE6Q6BxUit_SCB8', '1', null, '10', '0', '', '00:00:00', '23:59:59', '2020-05-24 15:56:16', null), ('17', '图片', 'image', 'http://localhost:8091/file/pic/微信图片_202004251523165-20200520063636108.jpg', '1', null, '图片', '0', '', '00:00:00', '23:59:59', '2020-05-24 20:13:13', null), ('19', '图文', 'mpnews', '1', '1', null, '图文', '0', '', '00:00:00', '23:59:59', '2020-05-24 22:15:27', null);
COMMIT;

-- ----------------------------
--  Table structure for `wechat_reply_content`
-- ----------------------------
DROP TABLE IF EXISTS `wechat_reply_content`;
CREATE TABLE `wechat_reply_content` (
  `wechat_reply_id` bigint(20) NOT NULL,
  `content` text,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `wechat_reply_content`
-- ----------------------------
BEGIN;
INSERT INTO `wechat_reply_content` VALUES ('15', '{\"link\":\"https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Getting_Permanent_Assets.html\",\"title\":\"新闻标题\",\"desc\":\"新闻简介\",\"image\":\"https://yoooho.bkbedu.com/mall/images/20200425/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_202004251523167.jpg\"}', '1'), ('16', '{\"link\":\"https://yoooho.bkbedu.com/mall/images/normal%20video.mp4\",\"title\":\"视频标题\",\"desc\":\"视频简介\"}', '2'), ('17', '\"http://localhost:8091/file/pic/微信图片_202004251523165-20200520063636108.jpg\"', '3'), ('19', '{\"id\":1,\"mediaId\":\"npfm19T1I4dB4rq1_WXe5xubwOmnex5uhzTM5rAY9Nw\",\"cid\":\"\",\"title\":\"图文1\",\"author\":\"赵阳\",\"imageInput\":\"http://localhost:8091/file/pic/微信图片_202004251523168-20200520063636108.jpg\",\"synopsis\":\"测试\",\"content\":\"<p><img src=\\\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/pcmoren_tian_org.png\\\" alt=\\\"[舔屏]\\\" data-w-e=\\\"1\\\"><br></p>\",\"shareTitle\":\"\",\"shareSynopsis\":\"\",\"visit\":\"\",\"sort\":null,\"url\":null,\"status\":null,\"addTime\":\"2020-05-23 13:59\",\"hide\":0,\"adminId\":null,\"merId\":null,\"productId\":null,\"isHot\":null,\"isBanner\":null,\"thumbMediaId\":null}', '8');
COMMIT;

-- ----------------------------
--  Table structure for `wechat_template`
-- ----------------------------
DROP TABLE IF EXISTS `wechat_template`;
CREATE TABLE `wechat_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '模板id',
  `tempkey` varchar(255) NOT NULL COMMENT '模板编号',
  `name` varchar(255) DEFAULT NULL COMMENT '模板名',
  `content` text COMMENT '模板内容',
  `tempid` char(100) DEFAULT NULL COMMENT '模板ID',
  `add_time` varchar(15) DEFAULT NULL COMMENT '添加时间',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `open_url` text,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='微信模板';

-- ----------------------------
--  Records of `wechat_template`
-- ----------------------------
BEGIN;
INSERT INTO `wechat_template` VALUES ('1', 'OPENTM200565259', '订单发货提醒', '{{first.DATA}}\n订单编号：{{keyword1.DATA}}\n物流公司：{{keyword2.DATA}}\n物流单号：{{keyword3.DATA}}\n{{remark.DATA}}', 'xPZFQVZfc3E7a9JeCLLqjvuVcL62sY8TZhhFqYHlwME', '1515052638', '1', 'http://0cdfbb4b67b4.ngrok.io/pages/order/orderDetail'), ('2', 'OPENTM207791277', '订单支付成功通知', '{{first.DATA}}\n订单编号：{{keyword1.DATA}}\n支付金额：{{keyword2.DATA}}\n{{remark.DATA}}', 'IBjNzzn4kMthDDesmveGTdW3cNQZ5RGkMbm8O0A5nd4', '', '1', 'http://0cdfbb4b67b4.ngrok.io/pages/order/orderDetail'), ('3', 'OPENTM40584707', '帐户资金变动提醒', '{{first.DATA}}\n变动类型：{{keyword1.DATA}}\n变动时间：{{keyword2.DATA}}\n变动金额：{{keyword3.DATA}}\n{{remark.DATA}}', 'xPZFQVZfc3E7a9JeCLLqjvuVcL62sY8TZhhFqYHlwME', '', '1', 'https://www.baidu.com'), ('4', 'OPENTM410119152', '退款成功通知', '{{first.DATA}}\n订单编号：{{keyword1.DATA}}\n订单金额：{{keyword2.DATA}}\n下单时间：{{keyword3.DATA}}\n{{remark.DATA}}', 'W9lx716GQB-uQjFlPifIM892znv2fmAiaRNqjv3pDK0', '', '1', 'http://0cdfbb4b67b4.ngrok.io/pages/order/orderDetail');
COMMIT;

-- ----------------------------
--  Table structure for `wx_app_config`
-- ----------------------------
DROP TABLE IF EXISTS `wx_app_config`;
CREATE TABLE `wx_app_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_id` varchar(30) DEFAULT NULL,
  `secret` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


-- ----------------------------
--  Table structure for `wx_official_account_config`
-- ----------------------------
DROP TABLE IF EXISTS `wx_official_account_config`;
CREATE TABLE `wx_official_account_config` (
  `appid` varchar(225) DEFAULT NULL,
  `appsecret` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `encodingaeskey` varchar(255) DEFAULT NULL,
  `api` varchar(255) DEFAULT NULL,
  `share_title` varchar(255) DEFAULT NULL,
  `share_synopsis` text,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `share_img` text,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;



-- ----------------------------
--  Table structure for `wx_pay_config`
-- ----------------------------
DROP TABLE IF EXISTS `wx_pay_config`;
CREATE TABLE `wx_pay_config` (
  `app_id` varchar(32) DEFAULT NULL COMMENT '支付appId',
  `mch_key` varchar(255) DEFAULT NULL COMMENT '商户秘钥',
  `mch_id` varchar(255) DEFAULT NULL COMMENT '商户id',
  `key_path` varchar(500) DEFAULT NULL COMMENT '证书地址',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `notify_url_h5` varchar(500) DEFAULT NULL COMMENT 'h5通知地址',
  `refund_notify_url` varchar(500) DEFAULT NULL,
  `spbill_create_ip` varchar(55) DEFAULT NULL,
  `notify_url_app` varchar(500) DEFAULT NULL COMMENT 'app通知地址',
  `notify_url_sp` varchar(500) DEFAULT NULL COMMENT '小程序通知地址',
  `notify_url_js` varchar(500) DEFAULT NULL COMMENT '微信公众号通知地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;



SET FOREIGN_KEY_CHECKS = 1;
