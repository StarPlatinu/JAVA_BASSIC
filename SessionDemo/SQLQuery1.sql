Use Trading2022
go
create table [Admin](
Username varchar(20) primary key,
Password varchar(20),
role int
)
go
insert into [Admin] values
('sa','123',1),
('admin','admin',1),
('123','123',2),
('456','456',2)
