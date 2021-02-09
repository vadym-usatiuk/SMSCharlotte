-- Creating Student TABLE
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
	`email` VARCHAR(50) NOT NULL PRIMARY KEY,
	`name`  VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NOT NULL 
) ENGINE = INNODB;

-- Inserting values into Student TABLE
insert into Student (email, name, password) values ('hluckham0@google.ru', 'Hazel Luckham', 'X1uZcoIh0dj');
insert into Student (email, name, password) values ('sbowden1@yellowbook.com', 'Sonnnie Bowden', 'SJc4aWSU');
insert into Student (email, name, password) values ('qllorens2@howstuffworks.com', 'Quillan Llorens', 'W6rJuxd');
insert into Student (email, name, password) values ('cstartin3@flickr.com', 'Clem Startin', 'XYHzJ1S');
insert into Student (email, name, password) values ('tattwool4@biglobe.ne.jp', 'Thornie Attwool', 'Hjt0SoVmuBz');
insert into Student (email, name, password) values ('hguerre5@deviantart.com', 'Harcourt Guerre', 'OzcxzD1PGs');
insert into Student (email, name, password) values ('htaffley6@columbia.edu', 'Holmes Taffley', 'xowtOQ');
insert into Student (email, name, password) values ('aiannitti7@is.gd', 'Alexandra Iannitti', 'TWP4hf5j');
insert into Student (email, name, password) values ('ljiroudek8@sitemeter.com', 'Laryssa Jiroudek', 'bXRoLUP');
insert into Student (email, name, password) values ('cjaulme9@bing.com', 'Cahra Jaulme', 'FnVklVgC6r6');

-- Creating Course TABLE
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
	`id` INT NOT NULL PRIMARY KEY,
	`name`  VARCHAR(50) NOT NULL,
	`instructor` VARCHAR(50) NOT NULL 
) ENGINE = INNODB;

-- Inserting values into Course TABLE
insert into Course (id, name, instructor) values (1, 'English', 'Anderea Scamaden');
insert into Course (id, name, instructor) values (2, 'Mathematics', 'Eustace Niemetz');
insert into Course (id, name, instructor) values (3, 'Anatomy', 'Reynolds Pastor');
insert into Course (id, name, instructor) values (4, 'Organic Chemistry', 'Odessa Belcher');
insert into Course (id, name, instructor) values (5, 'Physics', 'Dani Swallow');
insert into Course (id, name, instructor) values (6, 'Digital Logic', 'Glenden Reilingen');
insert into Course (id, name, instructor) values (7, 'Object Oriented Programming','Giselle Ardy');
insert into Course (id, name, instructor) values (8, 'Data Structures', 'Carolan Stoller');
insert into Course (id, name, instructor) values (9, 'Politics', 'Carmita De Maine');
insert into Course (id, name, instructor) values (10, 'Art', 'Kingsly Doxsey');