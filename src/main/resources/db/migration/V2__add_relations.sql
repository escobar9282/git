alter table doctor_entity add column if not exists prescription_entities bigint;
/*alter table doctor_entity add column if not exists relation_from_doctor bigint;
alter table doctor_entity add column if not exists relation_with_nurse bigint;*/

alter table doctor_entity add foreign key (prescription_entities) references prescription_entity(id);
/*alter table doctor_entity add foreign key (relation_from_doctor) references patient_entity(id);
alter table doctor_entity add foreign key (relation_with_nurse) references nurse_entity(id);*/

alter table nurse_entity add column if not exists patient_relation bigint;
alter table nurse_entity add column if not exists patient_relation bigint;
