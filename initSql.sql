create table orders(
	ordernumber int,
	email text,
	date date,
	orderlist jsonb);

create table products(
    article serial primary key,
    name text,
    available boolean,
    cost int);

insert into products(name, available, cost)
VALUES('potato', true, 50),
       ('milk', true, 60),
       ('vodka', false, 500),
       ('beer', true, 150),
       ('tomato', true, 55),
       ('energy drink', true, 95),
       ('carrot', true, 45),
       ('water melon', true, 165),
       ('pizza', false, 450),
       ('shawarma', true, 160);

insert into orders(ordernumber, email, date, orderlist) VALUES(-12312312,'ximure@mail.ru','1999-04-16','[{"article":10,"name":"shawarma","cost":160, "available":true},{"article":8,"name":"water melon","cost":165, "available":true},{"article":1,"name":"potato","cost":50,"available":true}]'),
(-12872312,'cheburek@mail.ru','2001-12-24','[{"article":2,"name":"milk","cost":60,"available":true},{"article":5,"name":"tomato","cost":55,"available":true},{"article":1,"name":"potato","cost":50,"available":true}]'),
(-21727822,'ex_tmhsv@gmail.com','2007-09-03','[{"article":7, "name":"carrot","cost":45,"available":true},{"article":9,"name":"pizza","cost":450,"available":false},{"article":4,"name":"beer","cost": 150,"available":true}]')
