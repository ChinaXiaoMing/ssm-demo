/*
Navicat MySQL Data Transfer

Source Server         : localMysql
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-07 09:11:35
*/

SET FOREIGN_KEY_CHECKS=0;

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
