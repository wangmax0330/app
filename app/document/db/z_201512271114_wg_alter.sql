ALTER TABLE APS_BLOG_TAG
ADD COLUMN DELFLAG  tinyint(1) ZEROFILL NULL AFTER NUM;

ALTER TABLE APS_BLOG_TAG
MODIFY COLUMN DELFLAG  tinyint(1) UNSIGNED ZEROFILL NOT NULL AFTER NUM;
