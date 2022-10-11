create table products(
ID varchar(10) primary key,
[name] nvarchar(max) Null,
quantity int null,
price money null,
releaseDate date null,
describe nvarchar(max) null,
[image] nvarchar(max) null,
cid int references Categories(ID)
)

insert into products values
(N'ip1',N'iphone 12 series',15,19000.00,cast(0x12430B00 As Date),N'iphone 12 mini la mot su lua chon hoan hao',N'https://i.pinimg.com/originals/7b/71/aa/7b71aa2166ea8c76900231898ef97f50.jpg',3),
(N'ip2',N'iphone 12 series',15,19000.00,cast(0x12430B00 As Date),N'iphone 12 mini la mot su lua chon hoan hao',N'https://i.pinimg.com/originals/7b/71/aa/7b71aa2166ea8c76900231898ef97f50.jpg',3),
(N'ip3',N'iphone 12 series',15,19000.00,cast(0x12430B00 As Date),N'iphone 12 mini la mot su lua chon hoan hao',N'https://i.pinimg.com/originals/7b/71/aa/7b71aa2166ea8c76900231898ef97f50.jpg',3),
(N'ip4',N'iphone 12 series',15,19000.00,cast(0x12430B00 As Date),N'iphone 12 mini la mot su lua chon hoan hao',N'https://i.pinimg.com/originals/7b/71/aa/7b71aa2166ea8c76900231898ef97f50.jpg',3),
(N'ip5',N'iphone 12 series',15,19000.00,cast(0x12430B00 As Date),N'iphone 12 mini la mot su lua chon hoan hao',N'https://i.pinimg.com/originals/7b/71/aa/7b71aa2166ea8c76900231898ef97f50.jpg',3)