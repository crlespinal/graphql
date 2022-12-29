create table product( id serial primary key, label varchar(255) not null , description varchar(255));
create table skus( id serial primary key, number varchar(255) not null , product_id integer);
