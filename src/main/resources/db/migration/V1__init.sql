create table if not exists doctor
(
id bigint not null unique,
personal_identification_number bigint not null,
speciality varchar(255),
doctors_name varchar(255),
doctors_last_name varchar(255),
patients_checklist_timing varchar(255),
primary key (id)
);

create table if not exists patient
(
id bigint not null unique,
phone_number bigint,
personal_identification_number bigint,
city varchar(255),
address varchar(255),
postal_code varchar(255),
appointment_time_with_doctor varchar(255),
patient_names varchar(255),
affliction varchar(255),
age int4,
primary key (id)
);

create table if not exists prescription_entity
(
id bigint not null unique,
prescription varchar(255),
medication varchar(255),
number_of_medications bigint,
procedure varchar(255),
primary key (id)
);

create table if not exists nurse
(
id bigint not null unique,
first_name varchar(255),
last_name varchar(255),
patient_history_first_names varchar(255),
patient_history_last_names varchar(255),
patient_affliction varchar(255),
patient_appointment_with_doctor varchar(255),
personal_data varchar(255),
history_of_current_diseases varchar(255),
history_of_past_diseases varchar(255),
family_history varchar(255),
medication_usage varchar(255),
medicines varchar(255),
life_style varchar(255),
course_of_treatment varchar(255),
primary key (id)
);