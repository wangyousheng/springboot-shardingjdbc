-- ds0 -- ds1
create table t_user0
(
  id           bigint                              not null
    primary key,
  phone        bigint                              not null
  comment '手机号',
  name         varchar(12)                         null
  comment '姓名',
  age          int                                 null
  comment '年龄',
  gmt_create   timestamp default CURRENT_TIMESTAMP not null,
  gmt_modified timestamp default CURRENT_TIMESTAMP not null
  on update CURRENT_TIMESTAMP,
  address      varchar(64)                         null
  comment '地址',
  constraint t_user0_phone_uindex
  unique (phone)
);

create table t_user1
(
  id           bigint                              not null
    primary key,
  phone        bigint                              not null
  comment '手机号',
  name         varchar(12)                         null
  comment '姓名',
  age          int                                 null
  comment '年龄',
  gmt_create   timestamp default CURRENT_TIMESTAMP not null,
  gmt_modified timestamp default CURRENT_TIMESTAMP not null
  on update CURRENT_TIMESTAMP,
  address      varchar(64)                         null
  comment '地址',
  constraint t_user1_phone_uindex
  unique (phone)
);

create table t_user_order
(
  order_id     bigint         not null
    primary key,
  user_phone   bigint(11)     not null
  comment '用户',
  name         varchar(12)    null
  comment '名称',
  price        decimal(10, 2) null
  comment '价格',
  gmt_create   timestamp default CURRENT_TIMESTAMP not null,
  gmt_modified timestamp default CURRENT_TIMESTAMP not null
  on update CURRENT_TIMESTAMP
);

