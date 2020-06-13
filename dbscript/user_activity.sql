create table user_activity(
	id int(11) auto_increment comment '主键id',
	uid int(11) not null comment '用户id',
	account varchar(20)  not null  comment '账号',
	name varchar(45)  comment '姓名',
	create_time TIMESTAMP not null default comment '活跃时间'
)engine=innodb default charset=utf8mb4 comment '用户活跃表';