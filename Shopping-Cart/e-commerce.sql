Create database ecommerce_cart;
go

Use ecommerce_cart;
go


create table orders(
o_id int not null,
p_id int not null,
u_id int not null,
o_quantity int not null,
o_date varchar(450) not null,
primary key (o_id)
)


INSERT INTO orders VALUES (25,3,1,3,'2021-05-15'),(26,2,1,1,'2021-05-15');

create table products(
id int not null,
[name] varchar(450) not null,
category varchar(450) not null,
price float not null,
[image] varchar(450) not null,
primary key (id)
)

INSERT INTO products VALUES (1,'New Arrival Femal Shoes','Female Shoes',120,'https://picsum.photos/200'),
(2,'Ladies Pure PU Shoulder Bag','Ladis Bag',69.99,'https://picsum.photos/200'),
(3,'Stylish Men Office Suits','Men Clothes',169,'https://picsum.photos/200'),
(4,'Jaeger-LeCoultre Men Watch','Men Watch',2500.99,'https://picsum.photos/200'),
(5,'FreeMax e-cigarettes VB-456','E-Cigarattes',310,'https://picsum.photos/200'),
(6,'GeekVapee e-cigarattes MM-632','E-Cigarattes',555.5,'https://picsum.photos/200');

create table [users](
id int not null,
[name] varchar(250) not null,
email varchar(250) not null,
[password] varchar(250) not null,
primary key (id)
)

insert into users VALUES (1,'thanhvu','thanhvu@mail.com','123456');


