-- -----------------------------------------------------
-- Table `MEMBER`
-- -----------------------------------------------------
DROP TABLE MEMBER;

CREATE TABLE MEMBER (
  no NUMBER GENERATED AS IDENTITY,
  id VARCHAR2(45) UNIQUE NOT NULL,
  email VARCHAR2(45) UNIQUE NOT NULL,
  password VARCHAR2(45) NOT NULL,
  name VARCHAR2(45) NOT NULL,
  nickname VARCHAR2(45) UNIQUE NOT NULL,
  loc VARCHAR2(45) NOT NULL,
  PRIMARY KEY (no)
);


-- -----------------------------------------------------
-- Table `MOUNTAIN`
-- -----------------------------------------------------
DROP TABLE MOUNTAIN ;

CREATE TABLE MOUNTAIN (
  no NUMBER GENERATED AS IDENTITY,
  mName VARCHAR2(45) NOT NULL,
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

CREATE TABLE FREEBOARD (
  no NUMBER GENERATED AS IDENTITY,
  title VARCHAR2(100) NOT NULL,
  content VARCHAR2(4000) NOT NULL,
  regdate DATE DEFAULT sysdate NOT NULL,
  cnt NUMBER DEFAULT 0 NOT NULL,
  member_no NUMBER NOT NULL,
  PRIMARY KEY (no)
);


-- -----------------------------------------------------
-- Table `COURSE`
-- -----------------------------------------------------
DROP TABLE COURSE;

CREATE TABLE COURSE (
  no NUMBER GENERATED AS IDENTITY,
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

CREATE TABLE WISH (
  no NUMBER GENERATED AS IDENTITY,
  member_no NUMBER NOT NULL,
  mountain_no NUMBER NOT NULL,
  PRIMARY KEY (no)
 );


-- -----------------------------------------------------
-- Table `NOTICE`
-- -----------------------------------------------------
DROP TABLE NOTICE ;

CREATE TABLE NOTICE (
  no NUMBER GENERATED AS IDENTITY,
  title VARCHAR2(100) NOT NULL,
  content VARCHAR2(4000) NOT NULL,
  regdate DATE DEFAULT sysdate NOT NULL,
  cnt NUMBER DEFAULT 0 NOT NULL,
  member_no NUMBER NOT NULL,
  PRIMARY KEY (no)
);


-- -----------------------------------------------------
-- Table `FREPLY`
-- -----------------------------------------------------
DROP TABLE FREPLY;

CREATE TABLE FREPLY (
  no NUMBER GENERATED AS IDENTITY,
  reply VARCHAR2(500) NOT NULL,
  regdate VARCHAR2(45) DEFAULT sysdate NULL,
  board_no NUMBER NOT NULL,
  PRIMARY KEY (no)
);


-- -----------------------------------------------------
-- Table `NREPLY`
-- -----------------------------------------------------
DROP TABLE NREPLY;

CREATE TABLE NREPLY (
  no NUMBER GENERATED AS IDENTITY,
  reply VARCHAR2(500) NOT NULL,
  regdate VARCHAR2(45) DEFAULT sysdate NULL,
  notice_no NUMBER NOT NULL,
  PRIMARY KEY (no)
);


-- -----------------------------------------------------
-- Table `FESTIVAL`
-- -----------------------------------------------------
DROP TABLE FESTIVAL;

CREATE TABLE FESTIVAL (
  no NUMBER GENERATED AS IDENTITY,
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

CREATE TABLE RESTAURANT (
  no NUMBER GENERATED AS IDENTITY,
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

CREATE TABLE PLACE (
  no NUMBER GENERATED AS IDENTITY,
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

CREATE TABLE CONQUEST (
  no NUMBER GENERATED AS IDENTITY,
  member_no NUMBER NOT NULL,
  mountain_no NUMBER NOT NULL,
  condate DATE DEFAULT sysdate NOT NULL
);

