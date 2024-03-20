create sequence maintenance_engineer_seq start with 1 increment by 1;

create sequence price_seq start with 1 increment by 1;

create sequence producer_seq start with 1 increment by 1;

create sequence product_seq start with 1 increment by 1;

create sequence production_worker_seq start with 1 increment by 1;

create sequence quality_control_engineer_seq start with 1 increment by 1;

create table catalogs
(
    id   bigint not null,
    name varchar(255),
    primary key (id)
);

create table maintenance_engineers
(
    baseSalary  float(53),
    experience  integer,
    id          bigint not null,
    producer_id bigint,
    SEQ_NAME    varchar(255),
    name        varchar(255),
    primary key (id)
);

create table prices
(
    basePrice          float(53),
    percentageDiscount integer,
    totalPrice         float(53),
    id                 bigint not null,
    product_id         bigint unique,
    primary key (id)
);

create table producers
(
    numberOfWorkers integer,
    catalog_id      bigint,
    id              bigint not null,
    contactInfo     varchar(255),
    name            varchar(255),
    primary key (id)
);

create table production_workers
(
    baseSalary  float(53),
    experience  integer,
    rate        float4,
    id          bigint not null,
    producer_id bigint,
    SEQ_NAME    varchar(255),
    name        varchar(255),
    primary key (id)
);

create table products
(
    catalog_id  bigint,
    id          bigint not null,
    producer_id bigint,
    name        varchar(255),
    purpose     varchar(255) check (purpose in ('BEDROOM', 'LIVING_ROOM', 'DINING_ROOM', 'OFFICE', 'OUTDOOR', 'KITCHEN',
                                                'BATHROOM', 'KIDS_ROOM', 'HALLWAY', 'LIBRARY', 'CLOSET', 'UTILITY_ROOM',
                                                'OTHER')),
    type        varchar(255) check (type in ('SOFA', 'ARMCHAIR', 'DRESSER', 'TABLE', 'CHAIR', 'OTTOMAN', 'CABINET',
                                             'LOUNGE_CHAIR', 'BENCH', 'COFFEE_TABLE', 'DINING_TABLE', 'DESK',
                                             'BOOKSHELF', 'OTHER')),
    primary key (id)
);

create table quality_control_engineers
(
    baseSalary  float(53),
    experience  integer,
    id          bigint not null,
    producer_id bigint,
    SEQ_NAME    varchar(255),
    name        varchar(255),
    primary key (id)
);

alter table if exists maintenance_engineers
    add constraint FK9l06bej8tnajgn5ex4jaabqwk
        foreign key (producer_id)
            references producers;

alter table if exists prices
    add constraint FKhpva2t51a39twh6gdkxdcllyf
        foreign key (product_id)
            references products;

alter table if exists producers
    add constraint FKltfc8dn6071ux4f3vopu68lvk
        foreign key (catalog_id)
            references catalogs;

alter table if exists production_workers
    add constraint FKe97vb3wmy79i3s666elfwqngt
        foreign key (producer_id)
            references producers;

alter table if exists products
    add constraint FKr9g72vsfwc9lupwutnut4w7kf
        foreign key (catalog_id)
            references catalogs;

alter table if exists products
    add constraint FKponvuhms7f447e47sn69rs5gf
        foreign key (producer_id)
            references producers;

alter table if exists quality_control_engineers
    add constraint FK5f7wm739d7q60lxwyvu8iocs5
        foreign key (producer_id)
            references producers;