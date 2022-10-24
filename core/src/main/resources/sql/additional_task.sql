set search_path to medical;

create view test_view as (
select c.phone_number, c.email, p.last_name, p.first_name
from contact c, person_data p
where c.id = p.contact_id
);

select * from contact
    join address
        ON address.contact_id = contact.id;

with group_contact as (
    select min(id) as id, phone_number, email, profile_link
    from contact
    group by phone_number, email, profile_link
)
delete from contact using group_contact
    where group_contact.phone_number = contact.phone_number
        and group_contact.email = contact.email
        and group_contact.profile_link = contact.profile_link
        and group_contact.id < contact.id;

with count_contact as (
    select id, row_number() over (order by id) as row_num
    from contact
), count_rows as (
    select count(*) / 2 as c
    from contact
)
select contact.id, contact.phone_number, contact.email, contact.profile_link
from count_rows, contact
    join count_contact on contact.id = count_contact.id
where count_contact.row_num <= count_rows.c
order by contact.id;

/*SELECT reltuples::bigint AS estimate
FROM   pg_class
WHERE  oid = 'medical.contact'::regclass;*/

with children as (
    select last_name, first_name, parent_id, med_status
    from person_data
    join medical_card
        on person_data.medical_card_id = medical_card.id
    where medical_card.med_status = 'N'
)
select children.last_name, children.first_name,
       person_data.last_name as parent_last_name,
       person_data.first_name as parent_first_name,
       children.med_status
from person_data
    right join children
        on children.parent_id = person_data.id;
