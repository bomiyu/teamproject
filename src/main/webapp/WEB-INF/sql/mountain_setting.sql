-- -----------------------------------------------------
-- Table `MEMBER`
-- -----------------------------------------------------
DROP TABLE MEMBER;

CREATE SEQUENCE seq_member;
CREATE TABLE MEMBER (
  no NUMBER,
  id VARCHAR2(45) UNIQUE NOT NULL,
  email VARCHAR2(45) UNIQUE NOT NULL,
  password VARCHAR2(45) NOT NULL,
  name VARCHAR2(45) NOT NULL,
  nickname VARCHAR2(45) UNIQUE NOT NULL,
  loc VARCHAR2(45) NOT NULL,
  PRIMARY KEY (no)
);

ALTER TABLE member
ADD manager NUMBER(1) DEFAULT 0 NOT NULL
ADD CONSTRAINT member_manager_ck CHECK (manager IN (0, 1));

-- -----------------------------------------------------
-- Table `MOUNTAIN`
-- -----------------------------------------------------
DROP TABLE MOUNTAIN;

CREATE SEQUENCE seq_mountain;
CREATE TABLE MOUNTAIN (
  no NUMBER,
  mName VARCHAR2(45) NOT NULL UNIQUE,
  mLoc VARCHAR2(200) NOT NULL,
  height NUMBER DEFAULT 0 NOT NULL,
  status NUMBER(1) DEFAULT 0 NOT NULL,
  PRIMARY KEY (no),
  CONSTRAINT mountain_status_ck CHECK (status IN (0,1))
);

INSERT INTO mountain (mname, mloc, height, status)
VALUES ('도봉산', '위치', 1300, 2);

-- -----------------------------------------------------
-- Table `FREEBOARD`
-- -----------------------------------------------------
DROP TABLE FREEBOARD;

CREATE SEQUENCE seq_freeboard;
CREATE TABLE FREEBOARD (
  no NUMBER,
  title VARCHAR2(100) NOT NULL,
  content VARCHAR2(4000) NOT NULL,
  regdate DATE DEFAULT sysdate NOT NULL,
  cnt NUMBER DEFAULT 0 NOT NULL,
  member_no NUMBER NOT NULL,
  PRIMARY KEY (no)
);

CREATE INDEX pk_freeboard ON Freeboard(no);


-- -----------------------------------------------------
-- Table `COURSE`
-- -----------------------------------------------------
DROP TABLE COURSE;

CREATE SEQUENCE seq_course;
CREATE TABLE COURSE (
  no NUMBER,
  difficulty VARCHAR2(45) NOT NULL,
  time VARCHAR2(45) NOT NULL, -- form: __H __M
  points VARCHAR2(200) NOT NULL,
  mountain_no NUMBER NOT NULL,
  PRIMARY KEY (no),
  CONSTRAINT course_level_ck CHECK (difficulty IN ('low', 'medium', 'high'))
 );

INSERT INTO course (difficulty, time, points, mountain_no)
VALUES ('low', '1시간', '정상', 1);

-- -----------------------------------------------------
-- Table `WISH`
-- -----------------------------------------------------
DROP TABLE WISH;

CREATE SEQUENCE seq_wish;
CREATE TABLE WISH (
  no NUMBER,
  member_no NUMBER NOT NULL,
  mountain_no NUMBER NOT NULL,
  PRIMARY KEY (no)
 );


-- -----------------------------------------------------
-- Table `NOTICE`
-- -----------------------------------------------------
DROP TABLE NOTICE ;

CREATE SEQUENCE seq_notice;
CREATE TABLE NOTICE (
  no NUMBER,
  title VARCHAR2(100) NOT NULL,
  content VARCHAR2(4000) NOT NULL,
  regdate DATE DEFAULT sysdate NOT NULL,
  cnt NUMBER DEFAULT 0 NOT NULL,
  member_no NUMBER NOT NULL,
  PRIMARY KEY (no)
);

ALTER TABLE notice 
ADD category VHARCHAR2(45) DEFAULT 'notice' NOT NULL
ADD CONSTRAINT notice_category_ck CHECK (category IN ('notice','event'));

CREATE VIEW NoticeInfo 
AS
SELECT n.no, n.category, n.title, n.content, n.regdate, n.cnt, n.member_no, m.nickname
FROM notice n, member m
WHERE n.member_no = m.no;

-- -----------------------------------------------------
-- Table `FREPLY`
-- -----------------------------------------------------
DROP TABLE FREPLY;

CREATE SEQUENCE seq_freply;
CREATE TABLE FREPLY (
  no NUMBER,
  reply VARCHAR2(500) NOT NULL,
  replyer VARCHAR2(45) NOT NULL,
  regdate DATE DEFAULT sysdate NOT NULL,
  board_no NUMBER NOT NULL,
  PRIMARY KEY (no)
);


-- -----------------------------------------------------
-- Table `NREPLY`
-- -----------------------------------------------------
DROP TABLE NREPLY;

CREATE SEQUENCE seq_nreply;
CREATE TABLE NREPLY (
  no NUMBER,
  reply VARCHAR2(500) NOT NULL,
  replyer VARCHAR2(45) NOT NULL,
  regdate DATE DEFAULT sysdate NOT NULL,
  updatedate DATE DEFAULT sysdate NOT NULL,
  notice_no NUMBER NOT NULL,
  PRIMARY KEY (no)
);


-- -----------------------------------------------------
-- Table `FESTIVAL`
-- -----------------------------------------------------
DROP TABLE FESTIVAL;

CREATE SEQUENCE seq_festival;
CREATE TABLE FESTIVAL (
  no NUMBER,
  eName VARCHAR2(45) NOT NULL,
  description VARCHAR2(1000) NOT NULL,
  month NUMBER NOT NULL,
  mountain_no NUMBER NOT NULL,
  PRIMARY KEY (no),
  CONSTRAINT festival_month_ck CHECK (month BETWEEN 1 AND 12)
);

INSERT INTO festival (ename, description, month, mountain_no)
VALUES ('도봉산 축제', '신나는 축제', 13, 1);


-- -----------------------------------------------------
-- Table `RESTAURANT`
-- -----------------------------------------------------
DROP TABLE RESTAURANT;

CREATE SEQUENCE seq_restaurant;
CREATE TABLE RESTAURANT (
  no NUMBER,
  rName VARCHAR2(45) NOT NULL,
  rLoc VARCHAR2(200) NOT NULL,
  contact VARCHAR2(45) NOT NULL,
  menu VARCHAR2(500) NOT NULL,
  description VARCHAR2(1000) NOT NULL,
  mountain_no NUMBER NOT NULL,
  PRIMARY KEY (no)
);


-- -----------------------------------------------------
-- Table `PLACE`
-- -----------------------------------------------------
DROP TABLE PLACE;

CREATE SEQUENCE seq_place;
CREATE TABLE PLACE (
  no NUMBER,
  eName VARCHAR2(45) NOT NULL,
  description VARCHAR2(1000) NOT NULL,
  pLoc VARCHAR2(200) NOT NULL,
  mounain_no NUMBER NOT NULL,
  PRIMARY KEY (no)
);


-- -----------------------------------------------------
-- Table `CONQUEST`
-- -----------------------------------------------------
DROP TABLE CONQUEST;

CREATE SEQUENCE seq_conquest;
CREATE TABLE CONQUEST (
  no NUMBER,
  member_no NUMBER NOT NULL,
  mountain_no NUMBER NOT NULL,
  condate DATE DEFAULT sysdate NOT NULL
);

