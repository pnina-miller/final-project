create database QuickForm
use QuickForm

create table Users(UserId bigint primary key identity(1,1),
	  Email NVARCHAR(30),
	  Password NVARCHAR(30),
	   IdentityNum bigint,
	   FirstName NVARCHAR(30),
	   LastName NVARCHAR(30),
	   BirthDate Date,
	   Gender NVARCHAR(30),
	   Street NVARCHAR(30),
	   HouseNum int,
	   Neighborhood NVARCHAR(30),
	   City NVARCHAR(30),
	   Country NVARCHAR(30),
	   Enterance NVARCHAR(30),
	   AptNum int,
	   Status NVARCHAR(30),
	   CreditNum bigint,
	   Cvc int,
	   Valid Date,
	   PostalCode int,
	   RebuildNeighborhood NVARCHAR(30),
	   ChildrenAmount int,  
	   IpAddress NVARCHAR(20)

);

insert into Users(Password,IdentityNum ,FirstName, LastName)
values('password',123456789 ,'FirstName', 'LastName');


