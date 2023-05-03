alter table doctor add column if not exists prescription_entities bigint;
alter table prescription_entity add column if not exists doctor_id bigint;
alter table patient add column if not exists prescriptions bigint;
alter table prescription_entity add column if not exists patient_id bigint;

alter table doctor add foreign key (prescription_entities) references prescription_entity(id);
alter table prescription_entity add foreign key (doctor_id) references doctor(id);
alter table patient add foreign key (prescriptions) references prescription_entity(id);
alter table prescription_entity add foreign key (patient_id) references patient(id);

/*alter table nurse_entity add column if not exists patient_relation bigint;
alter table nurse_entity add column if not exists patient_relation bigint;*/
