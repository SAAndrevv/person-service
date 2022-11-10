CREATE SCHEMA if not exists medical;

create table if not exists medical.medical_card (
    id serial not null primary key,
    client_status char,
    med_status char,
    registry_dt date,
    comment text
);

create table if not exists medical.contact (
    id serial not null primary key,
    phone_number varchar(32),
    email varchar(128),
    profile_link text
);

create table if not exists medical.address (
    id serial not null primary key,
    contact_id bigint references medical.contact (id),
    country_id bigint,
    city varchar(255),
    index integer,
    street varchar(255),
    building varchar(32),
    flat varchar(32)
);

create table if not exists medical.person_data (
    id serial not null primary key,
    last_name varchar(255),
    first_name varchar(255),
    birth_dt date,
    age smallint,
    sex char,
    contact_id bigint references medical.contact (id),
    medical_card_id bigint references medical.medical_card (id),
    parent_id bigint check (parent_id <> person_data.id) references medical.person_data (id)
);

create table if not exists medical.illness (
    id serial not null primary key,
    medical_card_id bigint references medical.medical_card (id),
    type_id bigint,
    heaviness char,
    appearance_dttm timestamp,
    recovery_dt date
);

create table if not exists medical.signal (
    id serial not null primary key,
    person_data_id bigint references medical.person_data (id),
    description varchar(255),
    type varchar(32)
);

