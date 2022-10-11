create database Trading2022
go

use Trading2022
go

create table Categories
(
ID [int] primary key,
[name] nvarchar(30),
describe nvarchar(50)
)
go

insert into Categories values
(1,'Nokia','gon nhe, pin lau'),
(2,'Sam sung','dang dep, nhieu chuc nang'),
(3,'Iphone','hien dai, chup anh 20pixel...'),
(4,'Galaxy','hien dai, chup anh 20pixal')

select * from Categories