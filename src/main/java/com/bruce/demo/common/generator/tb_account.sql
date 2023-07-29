drop table  if exists `tb_account`;

CREATE TABLE if not exists `tb_account` (
                                            `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                                            `user_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '姓名',
    `age` int DEFAULT NULL COMMENT '年龄',
    `birthday` datetime DEFAULT NULL COMMENT '生日',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='账户表';


INSERT INTO test.tb_account
(id, user_name, age, birthday)
VALUES(1, '张三', 18, '2020-01-11 00:00:00');
INSERT INTO test.tb_account
(id, user_name, age, birthday)
VALUES(2, '李四', 19, '2021-03-21 00:00:00');