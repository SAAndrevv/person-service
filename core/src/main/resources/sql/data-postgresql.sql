set search_path to medical;

insert into contact (id, phone_number, email, profile_link) values
(1, '533-29-2722', 'sstudart0@ifeng.com', 'biblegateway.com'),
(2, '870-28-1754', 'smignot1@sbwire.com', 'gravatar.com'),
(3, '848-07-9072', 'emilnthorpe2@domainmarket.com', 'sphinn.com')
on conflict do nothing;


insert into address (id, contact_id, country_id, city, index, street, building, flat) values
(1, 1, 1, 'Changchun', '4149', '334 Cambridge Hill', '662', '1'),
(2, 2, 2, 'Delodpeken', '3', '5554 Nova Place', '67978', '2'),
(3, 3, 3, 'Çobansığnaq', '19772', '0299 Grover Trail', '603', '3')
on conflict do nothing;

insert into medical_card (id, client_status, med_status, registry_dt, comment) values
(1, 'F', 'F', '2022-02-13', 'Nazil'),
(2, 'F', 'M', '2022-08-01', 'BrightSpark'),
(3, 'M', 'F', '2022-01-06', 'Methotrexate')
on conflict do nothing;

insert into person_data (id, last_name, first_name, birth_dt, age, sex, contact_id, medical_card_id, parent_id) values
(1, 'Jouandet', 'Stacey', '2022-02-12', 1, 'F', 1, 1, null),
(2, 'Bartholomieu', 'Roselle', '2022-04-07', 2, 'F', 2, 2, null),
(3, 'Yewman', 'Jakob', '2022-08-25', 3, 'M', 3, 3, null)
on conflict do nothing;

insert into illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) values
(1, 1, 1, 'F', '2022-10-10', '2022-03-19'),
(2, 2, 2, 'F', '2022-11-09', '2022-05-07'),
(3, 3, 3, 'F', '2022-05-16', '2022-06-05')
on conflict do nothing;