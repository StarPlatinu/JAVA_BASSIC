Create database BankingDB1
Go

Use BankingDB1
Go

Create table Account(
account varchar(20) not null primary key,
[password] varchar(30) not null,
phone varchar(11) not null,
balance bigint
)

Insert Into Account Values
('thanhvp3','a123456','0982203932','3000000'),
('cuongnv1','b123456','1234567890','4000000'),
('longhh','c123456','13456789022','5000000')


Create table TransactionHistory(
transaction_id int not null identity(1,1) primary key,
amount bigint not null,
transaction_note varchar(255),
account_receive varchar(20),
account_transfer varchar(20) foreign key references Account(account)
)


Insert Into TransactionHistory values
('10000','thanh vu truyen tien','cuongnv1','thanhvp3')

