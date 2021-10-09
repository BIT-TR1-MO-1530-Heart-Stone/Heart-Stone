create table administration
(
    ID            int auto_increment
        primary key,
    AdminName     varchar(200) not null,
    AdminPassword varchar(100) not null,
    Email         varchar(255) not null
)
    charset = utf8;

create table user
(
    ID           int auto_increment comment 'ID，主键'
        primary key,
    Password     varchar(50)   not null comment '密码',
    Fullname     varchar(30)   not null,
    Screenname   varchar(30)   not null comment '姓名',
    Gender       int           not null,
    Phone_number varchar(20)   not null comment '电话号码',
    Email        varchar(50)   not null,
    info         varchar(255)  not null,
    Private      int default 0 null
)
    charset = utf8;

create table followerlist
(
    ID          int not null,
    User_id     int null,
    Follower_id int null,
    constraint FL1
        foreign key (User_id) references user (ID),
    constraint dad22
        foreign key (Follower_id) references user (ID)
)
    charset = utf8;

create table post
(
    ID       int auto_increment comment 'ID，主键'
        primary key,
    Category int          not null comment '类别',
    Title    varchar(255) not null comment '景点介绍',
    Info     varchar(255) not null comment '价钱',
    Picture  varchar(255) not null comment '图片',
    Date     datetime     not null comment '开发时间',
    User_id  int          null comment '作者id',
    Visible  int          null,
    constraint post_1
        foreign key (User_id) references user (ID)
)
    charset = utf8;

create table collection
(
    ID              int auto_increment comment 'ID，主键'
        primary key,
    User_id         int      null,
    Post_id         int      null,
    Collection_date datetime not null,
    constraint Collection1
        foreign key (User_id) references user (ID),
    constraint Collection2
        foreign key (Post_id) references post (ID)
)
    charset = utf8;

create table historypost
(
    ID               int auto_increment
        primary key,
    User_id          int      null,
    Historypost_ID   int      null,
    Historypost_date datetime not null,
    constraint Historypost1
        foreign key (User_id) references user (ID),
    constraint Historypost_b2
        foreign key (Historypost_ID) references post (ID)
)
    charset = utf8;

create index Historypost2
    on historypost (User_id);

create table `like`
(
    ID        int auto_increment comment 'ID，主键'
        primary key,
    Like_Time datetime not null comment '喜欢时间',
    User_id   int      null comment '外键',
    Post_id   int      null comment '外键',
    constraint tt_fk_1
        foreign key (User_id) references user (ID),
    constraint tt_fk_2
        foreign key (Post_id) references post (ID)
)
    charset = utf8;

create table response
(
    Post_id       int       not null,
    Response_time datetime  not null,
    Response_body char(255) not null comment '评论',
    Response_ID   char(20)  not null comment '评论编号',
    User_id       int       not null comment '用户ID，外键',
    ID            int auto_increment comment 'ID，主键'
        primary key,
    constraint os_fk_1
        foreign key (User_id) references user (ID),
    constraint os_fk_2
        foreign key (Post_id) references post (ID)
)
    charset = utf8;


