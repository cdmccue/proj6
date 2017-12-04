CREATE DATABASE DogsDB DEFAULT CHARACTER SET 'utf8'
  DEFAULT COLLATE 'utf8_unicode_ci';

USE DogsDB;

CREATE TABLE Discussions (
  discussion_id BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_name VARCHAR(100) NOT NULL,
  town VARCHAR(100) NOT NULL,
  street VARCHAR(100) NOT NULL,
  subj VARCHAR(100) NOT NULL,
  message VARCHAR(1024) NOT NULL,
  created DATE NOT NULL,
  last_updated DATE NOT NULL,
  uri_safe_subject VARCHAR(100) NOT NULL,
  
  INDEX twn (Town)
) ENGINE = InnoDB;

CREATE TABLE Posts (
  post_id BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  discussion_id INT UNSIGNED NOT NULL,
  user_name VARCHAR(100) NOT NULL,
  message VARCHAR(1024) NOT NULL,
  created DATE NOT NULL,
  
  INDEX usr (UserName)
) ENGINE = InnoDB; 