create table if not exists doctor_entity
(
id bigint not null unique,
personal_identification_number bigint not null,
speciality varchar(255),
doctors_name varchar(255),
doctors_last_name varchar(255),
primary key (id)
);

create table if not exists patient_entity
(
id bigint not null unique,
phone_number bigint,
personal_identification_number bigint,
city varchar(255),
address varchar(255),
postal_code varchar(255),
ill varchar(255),
healthy varchar(255),
age int4,
primary key (id)
);

create table if not exists prescription_entity
(
id bigint not null unique,
prescription varchar(255),
medication varchar(255),
number_of_medication bigint,
procedure varchar(255),
primary key (id)
);