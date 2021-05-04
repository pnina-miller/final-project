use QuickForm

create table children(
ChildId bigint primary key identity(1,1),
Name nvarchar(30) null ,
IdentityNum nvarchar(20) null,
BirthDate DATE null,
gender bit,
UserId bigint Foreign key  REFERENCES Users(UserId)
);
