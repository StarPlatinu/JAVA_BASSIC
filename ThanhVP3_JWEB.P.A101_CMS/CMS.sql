Create database CMS2
Go

Use CMS2
Go

create table Member (
	Id INT identity(1,1) not null,
	Firstname VARCHAR(50) not null,
	Lastname VARCHAR(50) not null,
	Username VARCHAR(50) not null,
	Password VARCHAR(50) not null,
	Phone VARCHAR(50),
	Email VARCHAR(50),
	Description VARCHAR(50),
	CretaedDate DATE,
	UpdateTime DATE
);

ALTER TABLE Member
ADD CONSTRAINT PK_Member PRIMARY KEY (Id);

insert into Member ( Firstname, Lastname, Username, Password, Phone, Email, Description, CretaedDate, UpdateTime) values ( 'Alyosha', 'O''Beirne', 'Redhold', '615362147-3', '282-280-8166', 'aobeirne0@networkadvertising.org', 3, '1/12/2022', '6/16/2022');
insert into Member ( Firstname, Lastname, Username, Password, Phone, Email, Description, CretaedDate, UpdateTime) values ( 'Celie', 'Skyram', 'Gembucket', '113430657-1', '162-615-2472', 'cskyram1@adobe.com', 4, '7/13/2022', '12/22/2021');
insert into Member (Firstname, Lastname, Username, Password, Phone, Email, Description, CretaedDate, UpdateTime) values ( 'Pat', 'Di Filippo', 'Span', '841723700-3', '161-535-9564', 'pdifilippo2@fc2.com', 2, '4/4/2022', '2/17/2022');
insert into Member (Firstname, Lastname, Username, Password, Phone, Email, Description, CretaedDate, UpdateTime) values ( 'Sara', 'Crosher', 'Matsoft', '795503730-8', '101-942-3448', 'scrosher3@free.fr', 1, '8/18/2022', '10/24/2022');
insert into Member ( Firstname, Lastname, Username, Password, Phone, Email, Description, CretaedDate, UpdateTime) values ( 'Rica', 'Booty', 'Toughjoyfax', '748957598-2', '954-300-3984', 'rbooty4@gravatar.com', 1, '11/15/2022', '3/22/2022');
insert into Member ( Firstname, Lastname, Username, Password, Phone, Email, Description, CretaedDate, UpdateTime) values ( 'Jillian', 'Huc', 'Stronghold', '561274478-1', '785-881-2805', 'jhuc5@time.com', 2, '12/11/2021', '3/17/2022');
insert into Member ( Firstname, Lastname, Username, Password, Phone, Email, Description, CretaedDate, UpdateTime) values ('Ines', 'Monument', 'Rank', '194880346-1', '117-198-3022', 'imonument6@latimes.com', 3, '4/25/2022', '9/26/2022');
insert into Member ( Firstname, Lastname, Username, Password, Phone, Email, Description, CretaedDate, UpdateTime) values ( 'Mohandis', 'Parker', 'Cardguard', '691124447-1', '605-935-4313', 'mparker7@illinois.edu', 1, '8/6/2022', '11/6/2022');
insert into Member ( Firstname, Lastname, Username, Password, Phone, Email, Description, CretaedDate, UpdateTime) values ( 'Kenneth', 'Hierro', 'Domainer', '183180959-1', '971-243-7421', 'khierro8@ox.ac.uk', 1, '8/3/2022', '7/21/2022');
insert into Member ( Firstname, Lastname, Username, Password, Phone, Email, Description, CretaedDate, UpdateTime) values ('Beatrice', 'Parchment', 'Tin', '247956663-3', '836-271-4626', 'bparchment9@pen.io', 4, '12/25/2021', '3/20/2022');

create table Content (
	Id INT identity(1,1) not null,
	Title VARCHAR(50),
	Brief TEXT,
	Content TEXT,
	CreatedDate DATE,
	UpdateTime DATE,
	Sort INT,
	AuthorId INT
);

ALTER TABLE Content
ADD CONSTRAINT PK_Content PRIMARY KEY (Id);

ALTER TABLE Content
ADD CONSTRAINT FK_Content
FOREIGN KEY (AuthorId) REFERENCES Member(Id);

insert into Content (Title, Brief, Content, CreatedDate, UpdateTime, Sort, AuthorId) values ('Free Willy', 'Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis. Sed ante.', 'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat. In congue. Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus.', '9/5/2022', '5/8/2022', 7, 1);
insert into Content (Title, Brief, Content, CreatedDate, UpdateTime, Sort, AuthorId) values ('Alone for Christmas', 'Pellentesque at nulla. Suspendisse potenti.', 'Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem. Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus. Pellentesque at nulla.', '10/28/2022', '1/25/2022', 7, 2);
insert into Content (Title, Brief, Content, CreatedDate, UpdateTime, Sort, AuthorId) values ('Arrival, The', 'Maecenas pulvinar lobortis est. Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum. Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc.', 'Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt.', '8/26/2022', '3/4/2022', 2, 3);
insert into Content (Title, Brief, Content, CreatedDate, UpdateTime, Sort, AuthorId) values ( 'American Splendor', 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh. In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo.', 'Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.', '12/28/2021', '11/26/2021', 6, 4);
insert into Content (Title, Brief, Content, CreatedDate, UpdateTime, Sort, AuthorId) values ('Ankur (The Seedling)', 'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat. In congue. Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna.', 'Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat.', '9/1/2022', '4/6/2022', 7, 5);
insert into Content (Title, Brief, Content, CreatedDate, UpdateTime, Sort, AuthorId) values ( 'Ranma �: Nihao My Concubine (Ranma �: Kessen T�genky�! Hanayome o torimodose!!)', 'Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo.', 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim.', '2/15/2022', '8/17/2022', 1, 6);
insert into Content (Title, Brief, Content, CreatedDate, UpdateTime, Sort, AuthorId) values ('The Last Outpost', 'Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo.', 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', '11/1/2022', '12/12/2021', 7, 7);
insert into Content (Title, Brief, Content, CreatedDate, UpdateTime, Sort, AuthorId) values ('Girl on the Train, The', 'In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat. Nulla nisl. Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum. In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.', 'Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum. Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.', '9/17/2022', '5/23/2022', 5, 8);
insert into Content ( Title, Brief, Content, CreatedDate, UpdateTime, Sort, AuthorId) values ('Cry Wolf', 'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla.', 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', '11/28/2021', '8/18/2022', 1, 9);
insert into Content (Title, Brief, Content, CreatedDate, UpdateTime, Sort, AuthorId) values ('Just One of the Guys', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat. Nulla nisl. Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum. In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante.', '8/22/2022', '12/14/2021', 3, 10);
