create table person
(
person_id bigint auto_increment primary key,
age int,
firstname varchar(20),
lastname varchar(20)
);

create table person_event
(
id bigint auto_increment primary key,
person_id bigint,
event_id bigint,
foreign key (person_id)  REFERENCES  person (person_id),
foreign key (event_id)  REFERENCES  events (event_id),
);

create table person_event
(
person_id bigint,
event_id  bigint,
primary key (person_id,event_id),
foreign key (person_id)  REFERENCES  person (person_id),
foreign key (event_id)  REFERENCES  events (event_id)
);

create table bed
(
id varchar(10) primary key,
bedName varchar(10)
);

create table person_email_addr
(
person_id bigint,
email_addr varchar(20),
primary key (person_id,email_addr),
foreign key (person_id) references person (person_id)
);