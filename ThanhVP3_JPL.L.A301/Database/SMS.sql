USE [master]
GO
CREATE DATABASE [SMS] 
GO
ALTER DATABASE [SMS] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [SMS] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [SMS] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [SMS] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [SMS] SET ARITHABORT OFF 
GO
ALTER DATABASE [SMS] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [SMS] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [SMS] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [SMS] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [SMS] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [SMS] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [SMS] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [SMS] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [SMS] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [SMS] SET  ENABLE_BROKER 
GO
ALTER DATABASE [SMS] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [SMS] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [SMS] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [SMS] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [SMS] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [SMS] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [SMS] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [SMS] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [SMS] SET  MULTI_USER 
GO
ALTER DATABASE [SMS] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [SMS] SET DB_CHAINING OFF 
GO
USE [SMS]
GO
/****** Object:  Table [dbo].[Customer]   ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[CustomerId] [int] IDENTITY(1,1) NOT NULL,
	[CustomerName] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CustomerId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employee]   ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee](
	[EmployeeId] [int] IDENTITY(1,1) NOT NULL,
	[EmployeeName] [nvarchar](50) NOT NULL,
	[Salary] [decimal](10, 2) NULL,
	[SupervisorId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[EmployeeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LineItem]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LineItem](
	[OrderId] [int] NOT NULL,
	[ProductId] [int] NOT NULL,
	[Quantity] [int] NULL,
	[Price] [decimal](10, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderId] ASC,
	[ProductId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderId] [int] IDENTITY(1,1) NOT NULL,
	[CustomerId] [int] NULL,
	[EmployeeId] [int] NULL,
	[Total] [decimal](10, 2) NULL,
	[OrderDate] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ProductId] [int] IDENTITY(1,1) NOT NULL,
	[ProductName] [nvarchar](50) NOT NULL,
	[ListPrice] [decimal](10, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Customer] ON 

INSERT [dbo].[Customer] ([CustomerId], [CustomerName]) VALUES (1, N'James')
INSERT [dbo].[Customer] ([CustomerId], [CustomerName]) VALUES (2, N'Mike')
INSERT [dbo].[Customer] ([CustomerId], [CustomerName]) VALUES (3, N'Kyo')
SET IDENTITY_INSERT [dbo].[Customer] OFF
GO
SET IDENTITY_INSERT [dbo].[Employee] ON 

INSERT [dbo].[Employee] ([EmployeeId], [EmployeeName], [Salary], [SupervisorId]) VALUES (1, N'John', CAST(1200.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[Employee] ([EmployeeId], [EmployeeName], [Salary], [SupervisorId]) VALUES (2, N'Deep', CAST(1400.00 AS Decimal(10, 2)), 1)
INSERT [dbo].[Employee] ([EmployeeId], [EmployeeName], [Salary], [SupervisorId]) VALUES (3, N'Susu', CAST(900.00 AS Decimal(10, 2)), 1)
INSERT [dbo].[Employee] ([EmployeeId], [EmployeeName], [Salary], [SupervisorId]) VALUES (4, N'Yuri', CAST(2100.00 AS Decimal(10, 2)), 3)
INSERT [dbo].[Employee] ([EmployeeId], [EmployeeName], [Salary], [SupervisorId]) VALUES (5, N'Violet', CAST(1450.00 AS Decimal(10, 2)), 1)
SET IDENTITY_INSERT [dbo].[Employee] OFF
GO
INSERT [dbo].[LineItem] ([OrderId], [ProductId], [Quantity], [Price]) VALUES (1, 2, 1, CAST(17.00 AS Decimal(10, 2)))
INSERT [dbo].[LineItem] ([OrderId], [ProductId], [Quantity], [Price]) VALUES (2, 1, 3, CAST(45.00 AS Decimal(10, 2)))
INSERT [dbo].[LineItem] ([OrderId], [ProductId], [Quantity], [Price]) VALUES (2, 2, 2, CAST(34.00 AS Decimal(10, 2)))
INSERT [dbo].[LineItem] ([OrderId], [ProductId], [Quantity], [Price]) VALUES (3, 1, 2, CAST(30.00 AS Decimal(10, 2)))
INSERT [dbo].[LineItem] ([OrderId], [ProductId], [Quantity], [Price]) VALUES (3, 2, 5, CAST(85.00 AS Decimal(10, 2)))
GO
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([OrderId], [CustomerId], [EmployeeId], [Total], [OrderDate]) VALUES (1, 1, 1, CAST(17.00 AS Decimal(10, 2)), CAST(N'2022-02-21T00:00:00.000' AS DateTime))
INSERT [dbo].[Orders] ([OrderId], [CustomerId], [EmployeeId], [Total], [OrderDate]) VALUES (2, 2, 3, CAST(79.00 AS Decimal(10, 2)), NULL)
INSERT [dbo].[Orders] ([OrderId], [CustomerId], [EmployeeId], [Total], [OrderDate]) VALUES (3, 2, 4, CAST(115.00 AS Decimal(10, 2)), CAST(N'2022-02-17T00:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[Orders] OFF
GO
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([ProductId], [ProductName], [ListPrice]) VALUES (1, N'Ice Cream', CAST(15.00 AS Decimal(10, 2)))
INSERT [dbo].[Product] ([ProductId], [ProductName], [ListPrice]) VALUES (2, N'Vanila', CAST(17.00 AS Decimal(10, 2)))
SET IDENTITY_INSERT [dbo].[Product] OFF
GO
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD FOREIGN KEY([SupervisorId])
REFERENCES [dbo].[Employee] ([EmployeeId])
GO
ALTER TABLE [dbo].[LineItem]  WITH CHECK ADD FOREIGN KEY([OrderId])
REFERENCES [dbo].[Orders] ([OrderId])
GO
ALTER TABLE [dbo].[LineItem]  WITH CHECK ADD FOREIGN KEY([ProductId])
REFERENCES [dbo].[Product] ([ProductId])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([CustomerId])
REFERENCES [dbo].[Customer] ([CustomerId])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([EmployeeId])
REFERENCES [dbo].[Employee] ([EmployeeId])
GO
/****** Object:  StoredProcedure [dbo].[SP_Customer_DeleteCustomer]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[SP_Customer_DeleteCustomer]
@CustomerId int
AS
BEGIN
DECLARE @OrderId int
SET @OrderId = (SELECT OrderId FROM Orders WHERE CustomerId =  @CustomerId)
DELETE FROM LineItem WHERE OrderId = @OrderId
DELETE FROM Orders WHERE CustomerId = @CustomerId
DELETE FROM Customer WHERE CustomerId = @CustomerId
END
GO
/****** Object:  StoredProcedure [dbo].[SP_Orders_ComputeAllOrders]   ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[SP_Orders_ComputeAllOrders]
AS
SELECT SUM(Total) FROM Orders
GO
/****** Object:  StoredProcedure [dbo].[SP_Orders_UpdateTotal]   ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[SP_Orders_UpdateTotal]
@OrderId int
AS
BEGIN
	UPDATE Orders SET Total = (SELECT SUM(Price) 'Total price' FROM LineItem WHERE OrderId =  @OrderId GROUP BY OrderId)
	WHERE OrderId = @OrderId
END
GO
/****** Object:  Trigger [dbo].[TR_LineItem_ComputePrice]   ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[TR_LineItem_ComputePrice]
ON [dbo].[LineItem]
FOR INSERT, UPDATE
AS
BEGIN
	DECLARE @OrderId int
	DECLARE @ProductId int
	IF(EXISTS(SELECT * FROM inserted))
	BEGIN
		SET @OrderId  =  (SELECT OrderId FROM inserted)
		SET @ProductId = (SELECT ProductId FROM inserted)
		UPDATE LineItem
		SET Price = (SELECT li.Quantity * p.ListPrice FROM LineItem  li JOIN Product p ON li.ProductId = p.ProductId WHERE li.OrderId = @OrderId AND li.ProductId =  @ProductId)
		WHERE OrderId = @OrderId AND ProductId = @ProductId
	END
END
GO
ALTER TABLE [dbo].[LineItem] ENABLE TRIGGER [TR_LineItem_ComputePrice]
GO
USE [master]
GO
ALTER DATABASE [SMS] SET  READ_WRITE 
GO