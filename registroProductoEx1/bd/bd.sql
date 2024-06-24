-- borra la bd si existe
DROP DATABASE IF EXISTS tienda;
-- creamos la bd
CREATE DATABASE tienda;
-- activamos la bd
USE tienda;
 
 
create table Producto( 
id_Producto   int auto_increment,
nombre   varchar(50),
stock		  int,
precio		  decimal(10,2) 
primary key (id_Producto) 
);
   
 

insert into Producto values (null,'Leche Gloria 960 ml',15,3.5);
insert into Producto values (null,'Yogurth Laive Fresa',27,6.5);
insert into Producto values (null,'Leche Laive 960 ml',65,2.8);


insert into Producto values (null,'Gaseosa Coca Cola 3L',65,9.50);
insert into Producto values (null,'Gaseosa Inka Cola 3L',19,8.50);
insert into Producto values (null,'Gaseosa Pepsi 3L',15,6.50);

insert into Producto values (null,'Arroz Costenio 1Kg',24,3.50);
insert into Producto values (null,'Arroz Paisana 1Kg',33,3.30);
insert into Producto values (null,'Frejol Canario 1Kg',12,2.20);
 
insert into Producto values (null,'Cerveza Corona SixPack 350 ml',21,29.00);
insert into Producto values (null,'Pisco Acholado Quebranta 750 ml',5,35.00);
insert into Producto values (null,'Cerveza Pilsen Callao 1LT',5,5.60);


  