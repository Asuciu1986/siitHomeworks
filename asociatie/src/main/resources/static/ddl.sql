create table if not exists tenants_association
(
    id serial not null
        constraint tenants_association_pk
            primary key,
    name varchar,
    phone_number varchar
);

alter table tenants_association owner to alex;

create table if not exists building
(
    id serial not null
        constraint building_pk
            primary key,
    name varchar not null,
    contact varchar,
    association_id integer
        constraint building_tenants_association_id_fk
            references tenants_association
            on update cascade on delete cascade
);

alter table building owner to alex;

create unique index if not exists building_id_uindex
    on building (id);

create table if not exists apartment
(
    id integer not null
        constraint apartment_pk
            primary key,
    floor integer,
    intercom integer,
    owner varchar not null,
    building_id integer not null
        constraint apartment_building_id_fk
            references building
            on update cascade on delete cascade
);

alter table apartment owner to alex;

create table if not exists maintenance
(
    id serial not null
        constraint table_name_pk
            primary key,
    year integer,
    month integer,
    value double precision,
    apartment_id integer
        constraint maintenance_apartment_id_fk
            references apartment
);

alter table maintenance owner to alex;

create table if not exists maintenance_details
(
    id integer not null
        constraint maintenance_details_pk
            primary key,
    rulment_value double precision,
    heating double precision,
    water double precision,
    maintenance_id integer
        constraint maintenance_details_maintenance_id_fk
            references maintenance
);

alter table maintenance_details owner to alex;

create unique index if not exists maintenance_details_maintenance_id_uindex
    on maintenance_details (maintenance_id);

