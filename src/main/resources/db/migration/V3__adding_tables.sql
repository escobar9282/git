create table if not exists doctor_nurse
(
id bigint not null unique,
doctor_id bigint not null unique,
nurse_id bigint not null unique,
primary key (id),
foreign key (doctor_id) references doctor(id),
foreign key (nurse_id) references nurse(id)

);