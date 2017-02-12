create database wireframe_dev;

drop table employees;
CREATE TABLE employees (
  id int(6) NOT NULL AUTO_INCREMENT,
  first_name varchar(60) NOT NULL,
  last_name varchar(60) NOT NULL,
  status varchar(10),
  birth_date DATE,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;