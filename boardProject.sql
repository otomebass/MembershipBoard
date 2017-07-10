CREATE TABLE board (
  boardNo int(11) NOT NULL AUTO_INCREMENT,
  id varchar(45) DEFAULT NULL,
  title varchar(45) NOT NULL,
  content text NOT NULL,
  readCount int(11) NOT NULL,
  boardDate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  name varchar(45) NOT NULL,
  replyCount int(11) NOT NULL,
  PRIMARY KEY (boardNo),
  KEY id_idx (id),
  CONSTRAINT id FOREIGN KEY (id) REFERENCES user (id) ON DELETE SET NULL);
  
  
  CREATE TABLE reply (
  boardNo int(11) NOT NULL,
  replyNo int(11) NOT NULL,
  content text NOT NULL,
  name varchar(45) NOT NULL,
  pkNo int(11) NOT NULL,
  replyCount int(11) NOT NULL,
  id varchar(45) DEFAULT NULL,
  PRIMARY KEY (pkNo),
  KEY userId_idx (id),
  KEY boardNo_idx (boardNo),
  CONSTRAINT boardNo FOREIGN KEY (boardNo) REFERENCES board (boardNo) ON DELETE CASCADE,
  CONSTRAINT userId FOREIGN KEY (id) REFERENCES user (id) ON DELETE SET NULL);
  
  
  CREATE TABLE user (
  name varchar(45) NOT NULL,
  id varchar(45) NOT NULL,
  pwd varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  addr varchar(45) NOT NULL,
  who varchar(45) NOT NULL,
  PRIMARY KEY (id));
  
  
  CREATE TABLE newuser (
  name varchar(45) NOT NULL,
  id varchar(45) NOT NULL,
  pwd varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  addr varchar(45) NOT NULL,
  who varchar(45) DEFAULT NULL,
  PRIMARY KEY (id));
  
  
  CREATE TABLE reject (
  name varchar(45) NOT NULL,
  id varchar(45) NOT NULL,
  pwd varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  addr varchar(45) NOT NULL,
  who varchar(45) DEFAULT NULL,
  PRIMARY KEY (id));