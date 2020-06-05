CREATE TABLE user (
`u_id` bigint NOT NULL AUTO_INCREMENT COMMENT  '用户ID',
`u_name` varchar(12) NOT NULL COMMENT   '用户昵称',
`u_sex` varchar(1) NOT NULL COMMENT '用户性别',
`u_birthday` DATE  NOT NULL COMMENT '用户出生日期',
`u_signature` varchar(60) NOT NULL  COMMENT '个性签名',
`u_avatar` blob  COMMENT '用户头像二进制版',
PRIMARY KEY (`u_id`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='用户表';
CREATE TABLE `user_auths` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '授权表ID',
  `u_id` bigint NOT NULL COMMENT '用户ID',
  `phone`bigint NOT NULL  COMMENT '用户手机号',
  `password` varchar(20) NOT NULL COMMENT '用户登录密码',
  `salt` varchar(10) NOT NULL ,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`u_id`) REFERENCES user(`u_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='用户密码表';
