create database session12;
use session12;

create table Student(
    id int primary key auto_increment,
    name varchar(100) not null,
    email varchar(255) not null,
    dob date
);

create table Product (
    id int primary key auto_increment,
    name varchar(100) not null,
    price decimal(10,2),
    quantity int,
    image varchar(255)
);

DELIMITER //
create procedure getAllStudent()
begin
    select * from student;
end //
DELIMITER ;

DELIMITER //
create procedure createStudent(
    name_in varchar(100),
    email_in varchar(255),
    dob_in date
)
begin
    insert into Student (name, email, dob)
        values (name_in,email_in,dob_in);
end //
DELIMITER ;

DELIMITER //
create procedure editStudent(
    id_in int,
    name_in varchar(100),
    email_in varchar(255),
    dob_in date
)
begin
    update Student
        set name = name_in,
            email = email_in,
            dob = dob_in
    where id = id_in;
end //
DELIMITER ;

DELIMITER //
create procedure deleteStudent(id_in int)
begin
    delete from Student where id = id_in;
end //
DELIMITER ;

DELIMITER //
create procedure searchStdById(id_in int)
begin
    select * from  Student where id = id_in;
end //
DELIMITER ;
-- Product
DELIMITER //
create procedure getAllProduct()
begin
    select * from Product;
end //
DELIMITER ;

DELIMITER //
create procedure createProduct(
    name_in varchar(100),
    price_in decimal(10,2),
    quantity_in int,
    image_in varchar(255)
)
begin
    insert into Product (name, price, quantity, image)
    values (name_in, price_in, quantity_in, image_in);
end //
DELIMITER ;

DELIMITER //
create procedure editProduct(
    id_in int,
    name_in varchar(100),
    price_in decimal(10,2),
    quantity_in int,
    image_in varchar(255)
)
begin
    update Product
    set name = name_in,
        price = price_in,
        quantity = quantity_in,
        image = image_in
    where id = id_in;
end //
DELIMITER ;

DELIMITER //
create procedure deleteProduct(id_in int)
begin
    delete from Product where id = id_in;
end //
DELIMITER ;

DELIMITER //
create procedure searchProductById(id_in int)
begin
    select * from Product where id = id_in;
end //
DELIMITER ;
