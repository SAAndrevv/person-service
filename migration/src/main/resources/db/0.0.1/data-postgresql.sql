insert into medical.contact (id, phone_number, email, profile_link)
values (1, '99', 'test@tets.com', 'link'),
       (2, '99', 'test@tets.com', 'link'),
       (3, '88', 'test2@tets.com', 'link2'),
       (4, '77', 'test3@tets.com', 'link3'),
       (5, '66', 'test4@tets.com', 'link4')
on conflict do nothing;


insert into medical.medical_card (id,med_status)
values (1, 'N'),
       (2, 'Y'),
       (3, 'N'),
       (4, 'N')
on conflict do nothing;

insert into medical.person_data (id, last_name, first_name, contact_id, medical_card_id, parent_id)
values (1, 'A', 'A', 1, 1, null),
       (2, 'B', 'U', 3, 2, null),
       (3, 'C', 'J', 4, 3, null),
       (4, 'A', 'V', 5, 4, 1)
on conflict do nothing;

insert into medical.address (id, contact_id)
values (1, 1),
       (2, 3),
       (3, 4)
on conflict do nothing;