-- 用户
CREATE TABLE `user_info` (
  `id` varchar(32) NOT NULL,
  `username` varchar(32) DEFAULT '',
  `password` varchar(32) DEFAULT '',
  `openid` varchar(64) DEFAULT '' COMMENT '微信openid',
  `role` tinyint(1) NOT NULL COMMENT '1买家2卖家',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
);

INSERT INTO user_info(id, username, PASSWORD, openid, role, create_time, update_time)
VALUES (1111, 'evan', 123, 'abc', '1',  '2019-02-27 19:38:48', '2019-02-27 19:38:48');

INSERT INTO user_info(id, username, PASSWORD, openid, role, create_time, update_time)
VALUES (2222, 'messi', 123, 'xyz', '2',  '2019-02-27 19:38:58', '2019-02-27 19:38:58')