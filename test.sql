/*
Navicat MySQL Data Transfer

Source Server         : localMysql
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-18 17:11:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '登录日志id',
  `login_name` varchar(64) NOT NULL COMMENT '登录账号',
  `ip` varchar(64) NOT NULL COMMENT '登录IP',
  `login_status` int(2) NOT NULL COMMENT '登录状态（1：成功，0：失败）',
  `login_time` datetime NOT NULL COMMENT '登录时间',
  `spend_time` bigint(32) NOT NULL COMMENT '登录耗时（单位：ms）',
  `browser_name` varchar(64) DEFAULT NULL COMMENT '浏览器名称',
  `browser_type` varchar(64) DEFAULT NULL COMMENT '浏览器类型',
  `browser_version` varchar(64) DEFAULT NULL,
  `operation_system` varchar(64) DEFAULT NULL COMMENT '操作系统',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES ('2', 'xiaoming', '127.0.0.1', '1', '2018-05-18 17:04:51', '327', 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', null);
INSERT INTO `login_log` VALUES ('3', 'xiaoming', '127.0.0.1', '1', '2018-05-18 17:05:18', '2', 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', null);
INSERT INTO `login_log` VALUES ('4', 'xiaoming', '127.0.0.1', '1', '2018-05-18 17:06:57', '6', 'Chrome', 'Browser', '65.0.3325.181', 'Windows 10', null);

-- ----------------------------
-- Table structure for roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions` (
  `permission_id` int(10) NOT NULL COMMENT '权限id',
  `permission` varchar(64) NOT NULL COMMENT '权限名称',
  `role_name` varchar(64) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles_permissions
-- ----------------------------
INSERT INTO `roles_permissions` VALUES ('1', 'user:add', 'admin');
INSERT INTO `roles_permissions` VALUES ('2', 'user:delete', 'user');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) NOT NULL COMMENT 'user_id',
  `username` varchar(10) NOT NULL COMMENT '用户名称',
  `password` varchar(64) NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'xiaoming', '91eb4a5cd144eb562def5aa14ebcab91');

-- ----------------------------
-- Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `id` int(10) NOT NULL COMMENT '角色id',
  `role_name` varchar(64) NOT NULL COMMENT '角色名称',
  `username` varchar(64) NOT NULL COMMENT '用户名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Records of user_roles
-- ----------------------------
INSERT INTO `user_roles` VALUES ('1', 'admin', 'xiaoming');
INSERT INTO `user_roles` VALUES ('2', 'user', 'xiaoming');
