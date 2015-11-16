create table bank_user(
	id int auto_increment primary key ,
	username varchar(20),
	password varchar(30),
	money double
);

select * from bank_user;
drop table bank_user;
delete from bank_user;