create table if not exists products(
	id int AUTO_INCREMENT unique NOT NULL primary key,
    product varchar(20),
	customer_price float,
    provider_price float,
    stock_amount int,
    amount_sold int
);

create table if not exists purchases(
	 id int AUTO_INCREMENT unique NOT NULL primary key, 
	 purchase_date  date,
     id_product int,
     id_employee int
);


create table if not exists employee(
	id int AUTO_INCREMENT unique NOT NULL primary key,
    last_session date,
    contract_date date
);

alter table purchases add foreign key (id_product) references products (id);
alter table purchases add foreign key (id_employee) references products (id);

insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("water",0.80,0.4,100,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("wine",8.00,6.4,20,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("bread",0.40,0.15,200,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("cereal",2.80,1.4,60,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("corm",0.90,0.45,40,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("oil",1.00,0.5,100,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("milk",1.80,0.9,100,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("coffee",0.80,0.4,100,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("chocolate",1.00,0.4,100,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("Toilet paper",999.999,0.4,1,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("meat",3.80,1.9,28,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("fish",4.80,1.4,39,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("bio bread",5.80,0.4,30,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("bio cereals",3.80,0.4,60,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("black chocolate",1.10,0.9,100,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("white chocolate",0.90,0.4,100,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("salt",0.40,0.05,1000,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("honey",1.8,0.9,100,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("jam",1.1,1.0,75,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("chips",0.80,0.2,100,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("pizza",1.50,0.6,90,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("cheese",1.2,0.7,30,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("pizza",1.50,0.6,90,0);
insert into products(product,customer_price,provider_price,stock_amount,amount_sold) values("detergent",1.25,0.6,90,0);

insert into employee(last_session,contract_date) values("2019-12-29","2010-9-28");
insert into employee(last_session,contract_date) values("2020-1-29","2015-7-18");
insert into employee(last_session,contract_date) values("2020-2-10","2018-2-2");
insert into employee(last_session,contract_date) values("2020-2-15","2012-9-28");
