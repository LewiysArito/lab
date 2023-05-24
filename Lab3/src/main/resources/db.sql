CREATE TABLE city (
                    id serial primary key not null,
                    locality_name varchar(50),
                    country varchar(50),
                    founding_date varchar(15),
                    population int,
                    natural_increase int,
                    is_administrative_center varchar(3)

);
CREATE TABLE village(
                     id serial primary key not null,
                     locality_name varchar(50),
                     country varchar(50),
                     founding_date varchar(15),
                     population int,
                     involved_ruralization varchar(3),
                     locality_area varchar(50)
);