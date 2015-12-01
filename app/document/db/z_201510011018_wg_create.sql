/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     10/2/2015 10:11:41                           */
/*==============================================================*/


DROP TABLE IF EXISTS APS_BLOG;

DROP TABLE IF EXISTS APS_BOLG_VERSION;

DROP TABLE IF EXISTS APS_USER;

DROP TABLE IF EXISTS APS_USER_LOG;

DROP TABLE IF EXISTS SYS_USER;

DROP TABLE IF EXISTS SYS_USER_LOG;

DROP TABLE IF EXISTS VISIT_USER_LOG;

/*==============================================================*/
/* Table: APS_BLOG                                              */
/*==============================================================*/
CREATE TABLE APS_BLOG
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT,
   CREATE_TIME          TIMESTAMP,
   USER_ID              BIGINT NOT NULL,
   DELFLAG              BOOL NOT NULL DEFAULT 0,
   TITLE                VARCHAR(30) NOT NULL,
   CONTENT              TEXT,
   DEL_TIME             TIMESTAMP,
   LASR_MODIFY_TIME     TIMESTAMP COMMENT '上一次修改的时间',
   VIEW_NUM             INT DEFAULT 0,
   IS_PUBLISH           BOOL COMMENT '是否已经发布,草稿',
   VERSION              VARCHAR(10) COMMENT '笔记版本',
   VERSION_ID           BIGINT,
   PRIMARY KEY (ID)
);

ALTER TABLE APS_BLOG COMMENT '博客主表';

/*==============================================================*/
/* Table: APS_BOLG_VERSION                                      */
/*==============================================================*/
CREATE TABLE APS_BOLG_VERSION
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT,
   USER_ID              BIGINT,
   CONTENT              TEXT,
   PRIMARY KEY (ID)
);

ALTER TABLE APS_BOLG_VERSION COMMENT '博客的日记备份';

/*==============================================================*/
/* Table: APS_USER                                              */
/*==============================================================*/
CREATE TABLE APS_USER
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT,
   CREATE_TIME          TIMESTAMP,
   USER_NAME            VARCHAR(20) NOT NULL,
   PASSWORD             VARCHAR(30) NOT NULL,
   ROLE                 INT NOT NULL DEFAULT 1,
   DELFLAG              BOOL NOT NULL DEFAULT 0,
   DEL_TIME             TIMESTAMP,
   EMAIL                VARCHAR(30) COMMENT '邮箱,用于找回密码之类的',
   MOBILE               VARCHAR(12),
   BIRTHDAY             DATETIME,
   AGE                  SMALLINT,
   CITY_ID              BIGINT,
   CITY_STR             VARCHAR(10),
   PRIMARY KEY (ID)
);

ALTER TABLE APS_USER COMMENT '用户信息表';

/*==============================================================*/
/* Table: APS_USER_LOG                                          */
/*==============================================================*/
CREATE TABLE APS_USER_LOG
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT,
   USER_ID              BIGINT NOT NULL,
   CREATE_TIME          TIMESTAMP,
   IP                   VARCHAR(20),
   LOG_TYPE             VARCHAR(50) COMMENT '日志类型',
   CONTENT              VARCHAR(100),
   PRIMARY KEY (ID)
);

ALTER TABLE APS_USER_LOG COMMENT '用户操作的日志';

/*==============================================================*/
/* Table: SYS_USER                                              */
/*==============================================================*/
CREATE TABLE SYS_USER
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT,
   CREATE_TIME          TIMESTAMP,
   DELFLAG              BOOL,
   USER_NAME            VARCHAR(20),
   PASSWORD             VARCHAR(30),
   ROLE                 INT,
   DEL_TIME             TIMESTAMP,
   EMAIL                VARCHAR(30) COMMENT '邮箱,用于找回密码之类的',
   MOBILE               VARCHAR(12),
   PRIMARY KEY (ID)
);

ALTER TABLE SYS_USER COMMENT ' 后台管理用户表';

/*==============================================================*/
/* Table: SYS_USER_LOG                                          */
/*==============================================================*/
CREATE TABLE SYS_USER_LOG
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT,
   USER_ID              BIGINT NOT NULL,
   CREATE_TIME          TIMESTAMP,
   IP                   VARCHAR(20),
   LOG_TYPE             VARCHAR(50) COMMENT '日志类型',
   CONTENT              VARCHAR(100),
   PRIMARY KEY (ID)
);

ALTER TABLE SYS_USER_LOG COMMENT '用户操作的日志';

/*==============================================================*/
/* Table: VISIT_USER_LOG                                        */
/*==============================================================*/
CREATE TABLE VISIT_USER_LOG
(
   ID                   BIGINT NOT NULL AUTO_INCREMENT,
   USER_ID              BIGINT NOT NULL,
   CREATE_TIME          TIMESTAMP,
   IP                   VARCHAR(20),
   LOG_TYPE             VARCHAR(50) COMMENT '日志类型',
   CONTENT              VARCHAR(100),
   PRIMARY KEY (ID)
);

ALTER TABLE VISIT_USER_LOG COMMENT '访问用户的日志';

