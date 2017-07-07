create table board(
boardNo int not null,
id varchar(45) not null
title varchar(45) not null,
content text not null,
readCount int not null,
boardDate timestamp not null default now(),
primary key(boardNo),
reference key id (id) references user(id)
);



select * from board;

show columns from board;