DROP TABLE IF EXISTS students CASCADE;
DROP TABLE IF EXISTS courses CASCADE;
DROP TABLE IF EXISTS professors CASCADE;
DROP TABLE IF EXISTS groupz CASCADE;
DROP TABLE IF EXISTS lessons CASCADE;
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE professors
(
    person_id SERIAL PRIMARY KEY,
    person_name CHARACTER VARYING(30),
    professor_ranks CHARACTER VARYING(512),
    professor_notes CHARACTER VARYING(512),
    course_id INTEGER,
    lesson_id INTEGER
);

CREATE TABLE groupz
(
    group_id SERIAL PRIMARY KEY,
    group_note CHARACTER VARYING(512)
);

CREATE TABLE students
(
    person_id SERIAL PRIMARY KEY,
    group_id INTEGER REFERENCES groupz (group_id),
    student_year INTEGER,
    person_name CHARACTER VARYING(30)
);

CREATE TABLE lessons
(
    lesson_id SERIAL PRIMARY KEY,
    start_time CHARACTER VARYING(30),
    end_time CHARACTER VARYING(30),
    professor_id INTEGER REFERENCES professors(person_id),
    group_id INTEGER REFERENCES groupz (group_id)
);

CREATE TABLE courses
(
    course_id SERIAL PRIMARY KEY,
    course_name CHARACTER VARYING(30),
    course_description CHARACTER VARYING(300),
    professor_id INTEGER REFERENCES professors(person_id)
);

CREATE TABLE users
(
    user_id SERIAL PRIMARY KEY,
    email VARCHAR(255),
    name VARCHAR(50),
    password VARCHAR(255),
    role VARCHAR(20) default 'USER',
    status VARCHAR(20) default 'ACTIVE'
);

INSERT INTO users(user_id, email, name, password, role, status)
    values(1, 'admin@mail.com', 'The Administrator', '$2y$12$klrjwD6ESVN.fhxxnHAYmOrxhOA3gmku3qI1/ddORgvH3ETyKy2Fu', 
    'ADMIN', 'ACTIVE');
INSERT INTO users(user_id, email, name, password, role, status)
	values(2, 'user@mail.com', 'A Normal User', '$2y$12$067H2JVb7oCoWrSWmNjI/e5SVrN.sZN7znrEwXMZBg3eRfzEuwj8S', 
	'USER', 'ACTIVE');

INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id)
values('Maëline', 'Cucurbita mixta Pang.', 'Uniform',16);
INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id) 
values('Lucrèce', 'Pilea richardii Urb.', 'X-ray',14);
INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id) 
values('Mén', 'Acidanthera Hochst.', 'Hotel',10);
INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id) 
values('Maïté', 'Poa arctica R. Br. ssp. arctica', 'Hotel',8);
INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id) 
values('Gérald', 'Pseudognaphalium canescens', 'Lima',4);
INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id) 
values('Lài', 'Cheilanthes leucopoda Link', 'Charlie',6);
INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id) 
values('Loïca', 'Pyrus calleryana Decne.', 'Quebec',9);
INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id) 
values('Amélie', 'Leptochloa P. Beauv.', 'Hotel',2);
INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id) 
values('Esbjörn', 'Trifolium subterraneum L', 'Kilo',3);
INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id) 
values('Håkan', 'Exothea paniculata', 'Uniform',10);
INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id) 
values('Sòng', 'Cyrtandra ×pubens H. ', 'Echo',12);
INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id) 
values('Eliès', 'Lotus scoparius (Nutt.)', 'Delta',6);
INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id) 
values('Renée', 'Festuca earlei Rydb', 'Juliett',5);
INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id) 
values('Anaé', 'Calyptranthes zuzygiu', 'Hotel',16);
INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id) 
values('Athéna', 'Asclepias connivens Baldw', 'Sierra',16);
INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id) 
values('Séverine', 'Smelowskia ovalis', 'Foxtrot',4);
    
INSERT INTO groupz(group_note) VALUES ('Aye group');
INSERT INTO groupz(group_note) VALUES ('Bee Group');
INSERT INTO groupz(group_note) VALUES ('See Group');
INSERT INTO groupz(group_note) VALUES ('Dee Group');
INSERT INTO groupz(group_note) VALUES ('Ear group');
INSERT INTO groupz(group_note) VALUES ('Effe Group');
INSERT INTO groupz(group_note) VALUES ('Gee Group');
INSERT INTO groupz(group_note) VALUES ('Aych Group');
INSERT INTO groupz(group_note) VALUES ('Eye group');
INSERT INTO groupz(group_note) VALUES ('Jay Group');
INSERT INTO groupz(group_note) VALUES ('Kay Group');
INSERT INTO groupz(group_note) VALUES ('Elle Group');
INSERT INTO groupz(group_note) VALUES ('Emme group');
INSERT INTO groupz(group_note) VALUES ('Ann Group');
INSERT INTO groupz(group_note) VALUES ('Augh Group');
INSERT INTO groupz(group_note) VALUES ('Pea Group');


INSERT INTO students(group_id, student_year, person_name) VALUES (1, 1, 'Heber Isidora');
INSERT INTO students(group_id, student_year, person_name) VALUES (2, 2, 'Oliwer Voitto');
INSERT INTO students(group_id, student_year, person_name) VALUES (3, 3, 'Rodina Gertrud');
INSERT INTO students(group_id, student_year, person_name) VALUES (4, 4, 'Agatka Mariyana');
INSERT INTO students(group_id, student_year, person_name) VALUES (1, 1, 'Damocles Leanora');
INSERT INTO students(group_id, student_year, person_name) VALUES (2, 2, 'Gracília Bettie');
INSERT INTO students(group_id, student_year, person_name) VALUES (3, 3, 'Ladislava Silvia');
INSERT INTO students(group_id, student_year, person_name) VALUES (4, 4, 'Aaro Lucille');
INSERT INTO students(group_id, student_year, person_name) VALUES (1, 1, 'Tim Workneh');
INSERT INTO students(group_id, student_year, person_name) VALUES (2, 2, 'Sashenka Deepika');
INSERT INTO students(group_id, student_year, person_name) VALUES (3, 3, 'Mladen Louise');
INSERT INTO students(group_id, student_year, person_name) VALUES (4, 4, 'Ruslan Wotan');
INSERT INTO students(group_id, student_year, person_name) VALUES (1, 1, 'Kalyan Hild');
INSERT INTO students(group_id, student_year, person_name) VALUES (2, 2, 'Robena Callixtus');
INSERT INTO students(group_id, student_year, person_name) VALUES (3, 3, 'Kylli Gayatri');
INSERT INTO students(group_id, student_year, person_name) VALUES (4, 4, 'Nymphodora Devika');

INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-01-02 00:01', '2018-01-02 01:01', 9, 7);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-01-06 00:01', '2018-01-06 01:01', 4, 12);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-01-06 00:01', '2018-01-06 01:01', 4, 3);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-01-07 00:01', '2018-01-07 01:01', 11, 5);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-01-08 00:01', '2018-01-08 01:01', 1, 14);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-01-12 00:01', '2018-01-12 01:01', 11, 1);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-01-12 00:01', '2018-01-12 01:01', 11, 9);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-01-12 00:01', '2018-01-12 01:01', 13, 10);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-01-12 00:01', '2018-01-12 01:01', 6, 10);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-01-18 00:01', '2018-01-18 01:01', 6, 14);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-01-21 00:01', '2018-01-21 01:01', 12, 4);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-01-23 00:01', '2018-01-23 01:01', 4, 12);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-01-27 00:01', '2018-01-27 01:01', 1, 4);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-01-29 00:01', '2018-01-29 01:01', 11, 8);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-02-01 00:01', '2018-02-01 01:01', 5, 4);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-02-03 00:01', '2018-02-03 01:01', 12, 12);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-02-04 00:01', '2018-02-04 01:01', 12, 13);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-02-06 00:01', '2018-02-06 01:01', 11, 13);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-02-10 00:01', '2018-02-10 01:01', 5, 7);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-02-13 00:01', '2018-02-13 01:01', 5, 12);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-02-14 00:01', '2018-02-14 01:01', 12, 4);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-02-15 00:01', '2018-02-15 01:01', 10, 7);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-02-15 00:01', '2018-02-15 01:01', 11, 4);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-02-26 00:01', '2018-02-26 01:01', 3, 9);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-02-28 00:01', '2018-02-28 01:01', 7, 15);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-02-29 00:01', '2018-02-29 01:01', 10, 12);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-03-02 00:01', '2018-03-02 01:01', 3, 10);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-03-02 00:01', '2018-03-02 01:01', 5, 13);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-03-13 00:01', '2018-03-13 01:01', 9, 10);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-03-17 00:01', '2018-03-17 01:01', 2, 11);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-03-17 00:01', '2018-03-17 01:01', 2, 9);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-03-19 00:01', '2018-03-19 01:01', 8, 11);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-03-29 00:01', '2018-03-29 01:01', 15, 7);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-04-03 00:01', '2018-04-03 01:01', 3, 7);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-04-04 00:01', '2018-04-04 01:01', 7, 9);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-04-04 00:01', '2018-04-04 01:01', 8, 10);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-04-05 00:01', '2018-04-05 01:01', 7, 5);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-04-15 00:01', '2018-04-15 01:01', 12, 4);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-04-15 00:01', '2018-04-15 01:01', 9, 2);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-04-16 00:01', '2018-04-16 01:01', 2, 15);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-05-02 00:01', '2018-05-02 01:01', 7, 15);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-05-03 00:01', '2018-05-03 01:01', 11, 14);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-05-05 00:01', '2018-05-05 01:01', 3, 11);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-05-10 00:01', '2018-05-10 01:01', 6, 6);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-05-18 00:01', '2018-05-18 01:01', 15, 11);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-05-26 00:01', '2018-05-26 01:01', 14, 11);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-06-02 00:01', '2018-06-02 01:01', 7, 8);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-06-03 00:01', '2018-06-03 01:01', 11, 13);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-06-05 00:01', '2018-06-05 01:01', 1, 1);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-06-12 00:01', '2018-06-12 01:01', 10, 14);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-06-14 00:01', '2018-06-14 01:01', 10, 15);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-06-15 00:01', '2018-06-15 01:01', 6, 10);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-06-16 00:01', '2018-06-16 01:01', 10, 2);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-06-18 00:01', '2018-06-18 01:01', 4, 11);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-06-18 00:01', '2018-06-18 01:01', 9, 14);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-06-24 00:01', '2018-06-24 01:01', 1, 7);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-06-25 00:01', '2018-06-25 01:01', 11, 14);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-06-27 00:01', '2018-06-27 01:01', 7, 6);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-07-01 00:01', '2018-07-01 01:01', 5, 10);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-07-04 00:01', '2018-07-04 01:01', 15, 4);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-07-06 00:01', '2018-07-06 01:01', 14, 14);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-07-11 00:01', '2018-07-11 01:01', 13, 3);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-07-12 00:01', '2018-07-12 01:01', 15, 12);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-07-14 00:01', '2018-07-14 01:01', 12, 14);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-07-25 00:01', '2018-07-25 01:01', 1, 1);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-07-28 00:01', '2018-07-28 01:01', 1, 2);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-07-28 00:01', '2018-07-28 01:01', 9, 3);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-08-02 00:01', '2018-08-02 01:01', 12, 9);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-08-04 00:01', '2018-08-04 01:01', 13, 2);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-08-06 00:01', '2018-08-06 01:01', 2, 6);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-08-07 00:01', '2018-08-07 01:01', 9, 8);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-08-10 00:01', '2018-08-10 01:01', 7, 10);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-08-13 00:01', '2018-08-13 01:01', 1, 14);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-08-15 00:01', '2018-08-15 01:01', 11, 11);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-08-16 00:01', '2018-08-16 01:01', 13, 8);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-08-21 00:01', '2018-08-21 01:01', 13, 2);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-08-24 00:01', '2018-08-24 01:01', 10, 3);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-09-04 00:01', '2018-09-04 01:01', 1, 15);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-09-07 00:01', '2018-09-07 01:01', 14, 1);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-09-16 00:01', '2018-09-16 01:01', 7, 5);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-09-24 00:01', '2018-09-24 01:01', 15, 13);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-09-28 00:01', '2018-09-28 01:01', 14, 7);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-10-03 00:01', '2018-10-03 01:01', 6, 10);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-10-06 00:01', '2018-10-06 01:01', 15, 5);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-10-06 00:01', '2018-10-06 01:01', 3, 1);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-10-13 00:01', '2018-10-13 01:01', 5, 4);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-10-17 00:01', '2018-10-17 01:01', 14, 6);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-10-23 00:01', '2018-10-23 01:01', 13, 11);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-10-29 00:01', '2018-10-29 01:01', 6, 4);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-11-04 00:01', '2018-11-04 01:01', 2, 7);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-11-05 00:01', '2018-11-05 01:01', 8, 8);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-11-07 00:01', '2018-11-07 01:01', 1, 4);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-11-08 00:01', '2018-11-08 01:01', 3, 15);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-11-09 00:01', '2018-11-09 01:01', 4, 4);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-11-12 00:01', '2018-11-12 01:01', 15, 10);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-11-13 00:01', '2018-11-13 01:01', 1, 6);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-11-16 00:01', '2018-11-16 01:01', 12, 9);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-11-20 00:01', '2018-11-20 01:01', 14, 1);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2018-11-29 00:01', '2018-11-29 01:01', 3, 2);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-01-02 00:01', '2019-01-02 01:01', 4, 6);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-01-02 00:01', '2019-01-02 01:01', 9, 11);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-01-06 00:01', '2019-01-06 01:01', 4, 5);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-01-07 00:01', '2019-01-07 01:01', 13, 6);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-01-12 00:01', '2019-01-12 01:01', 2, 10);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-01-19 00:01', '2019-01-19 01:01', 12, 1);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-02-05 00:01', '2019-02-05 01:01', 3, 15);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-02-09 00:01', '2019-02-09 01:01', 15, 10);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-02-09 00:01', '2019-02-09 01:01', 2, 1);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-02-11 00:01', '2019-02-11 01:01', 8, 3);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-02-14 00:01', '2019-02-14 01:01', 15, 3);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-02-15 00:01', '2019-02-15 01:01', 12, 13);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-02-17 00:01', '2019-02-17 01:01', 3, 4);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-02-18 00:01', '2019-02-18 01:01', 2, 7);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-02-25 00:01', '2019-02-25 01:01', 11, 8);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-03-02 00:01', '2019-03-02 01:01', 14, 15);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-03-05 00:01', '2019-03-05 01:01', 3, 6);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-03-06 00:01', '2019-03-06 01:01', 9, 13);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-03-08 00:01', '2019-03-08 01:01', 9, 5);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-03-13 00:01', '2019-03-13 01:01', 1, 3);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-03-15 00:01', '2019-03-15 01:01', 10, 7);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-03-20 00:01', '2019-03-20 01:01', 15, 2);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-03-21 00:01', '2019-03-21 01:01', 1, 7);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-03-22 00:01', '2019-03-22 01:01', 2, 2);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-03-23 00:01', '2019-03-23 01:01', 5, 4);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-03-28 00:01', '2019-03-28 01:01', 11, 2);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-03-28 00:01', '2019-03-28 01:01', 2, 15);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-04-08 00:01', '2019-04-08 01:01', 11, 5);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-04-09 00:01', '2019-04-09 01:01', 2, 9);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-04-13 00:01', '2019-04-13 01:01', 8, 15);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-04-14 00:01', '2019-04-14 01:01', 10, 3);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-04-15 00:01', '2019-04-15 01:01', 7, 3);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-04-18 00:01', '2019-04-18 01:01', 8, 10);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-04-22 00:01', '2019-04-22 01:01', 10, 10);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-04-28 00:01', '2019-04-28 01:01', 7, 6);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-04-29 00:01', '2019-04-29 01:01', 14, 12);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-05-01 00:01', '2019-05-01 01:01', 3, 4);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-05-06 00:01', '2019-05-06 01:01', 15, 15);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-05-08 00:01', '2019-05-08 01:01', 11, 2);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-05-11 00:01', '2019-05-11 01:01', 1, 8);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-05-11 00:01', '2019-05-11 01:01', 6, 11);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-05-12 00:01', '2019-05-12 01:01', 4, 9);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-05-19 00:01', '2019-05-19 01:01', 10, 6);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-05-19 00:01', '2019-05-19 01:01', 8, 8);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-05-21 00:01', '2019-05-21 01:01', 11, 12);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-05-21 00:01', '2019-05-21 01:01', 12, 5);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-05-23 00:01', '2019-05-23 01:01', 14, 11);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-05-26 00:01', '2019-05-26 01:01', 3, 4);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-06-05 00:01', '2019-06-05 01:01', 10, 9);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-06-06 00:01', '2019-06-06 01:01', 2, 7);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-06-07 00:01', '2019-06-07 01:01', 1, 15);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-06-08 00:01', '2019-06-08 01:01', 3, 12);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-06-09 00:01', '2019-06-09 01:01', 10, 15);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-06-12 00:01', '2019-06-12 01:01', 9, 9);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-06-13 00:01', '2019-06-13 01:01', 10, 12);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-06-13 00:01', '2019-06-13 01:01', 7, 14);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-06-14 00:01', '2019-06-14 01:01', 1, 14);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-06-15 00:01', '2019-06-15 01:01', 8, 8);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-06-17 00:01', '2019-06-17 01:01', 14, 6);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-06-19 00:01', '2019-06-19 01:01', 10, 15);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-06-23 00:01', '2019-06-23 01:01', 6, 13);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-06-27 00:01', '2019-06-27 01:01', 7, 11);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-07-08 00:01', '2019-07-08 01:01', 7, 5);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-07-13 00:01', '2019-07-13 01:01', 8, 6);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-07-14 00:01', '2019-07-14 01:01', 14, 14);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-07-15 00:01', '2019-07-15 01:01', 10, 9);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-07-18 00:01', '2019-07-18 01:01', 5, 5);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-07-23 00:01', '2019-07-23 01:01', 2, 15);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-07-25 00:01', '2019-07-25 01:01', 7, 14);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-07-27 00:01', '2019-07-27 01:01', 10, 7);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-08-02 00:01', '2019-08-02 01:01', 9, 6);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-08-14 00:01', '2019-08-14 01:01', 15, 14);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-08-16 00:01', '2019-08-16 01:01', 12, 13);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-08-17 00:01', '2019-08-17 01:01', 14, 6);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-08-19 00:01', '2019-08-19 01:01', 11, 1);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-08-25 00:01', '2019-08-25 01:01', 10, 12);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-08-29 00:01', '2019-08-29 01:01', 11, 5);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-09-07 00:01', '2019-09-07 01:01', 11, 1);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-09-08 00:01', '2019-09-08 01:01', 5, 7);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-09-11 00:01', '2019-09-11 01:01', 13, 13);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-09-14 00:01', '2019-09-14 01:01', 11, 1);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-09-20 00:01', '2019-09-20 01:01', 1, 7);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-09-21 00:01', '2019-09-21 01:01', 8, 10);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-09-24 00:01', '2019-09-24 01:01', 14, 12);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-10-09 00:01', '2019-10-09 01:01', 1, 9);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-10-10 00:01', '2019-10-10 01:01', 2, 6);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-10-11 00:01', '2019-10-11 01:01', 14, 4);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-10-16 00:01', '2019-10-16 01:01', 3, 6);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-10-26 00:01', '2019-10-26 01:01', 12, 5);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-10-26 00:01', '2019-10-26 01:01', 9, 9);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-10-28 00:01', '2019-10-28 01:01', 4, 14);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-11-01 00:01', '2019-11-01 01:01', 8, 1);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-11-01 00:01', '2019-11-01 01:01', 9, 13);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-11-05 00:01', '2019-11-05 01:01', 14, 2);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-11-09 00:01', '2019-11-09 01:01', 15, 12);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-11-10 00:01', '2019-11-10 01:01', 3, 14);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-11-10 00:01', '2019-11-10 01:01', 8, 9);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-11-26 00:01', '2019-11-26 01:01', 14, 3);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('2019-11-26 00:01', '2019-11-26 01:01', 9, 13);



INSERT INTO courses(course_name, course_description, professor_id) VALUES ('Maths', 'Ylfghglogy', 2);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('Abc', 'Vlgogjlogy', 5);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('Enc', 'Wfdflogy', 6);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('Wgs', 'Hlkjhbdsdlogy', 3);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('Pjioaf', 'Bkgjdfslogy', 7);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('LBG', 'Lvhgflogy', 9);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('Flkha', 'Oghdsflogy', 11);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('hfas', 'Ahgfglogy', 10);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('GG3a', 'Lghdfgslogy', 14);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('agse', 'Cjhdsvgklogy', 13);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('ehbs', 'Pkhgsdfhjlogy', 5);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('BKMMAF', 'Qfdkhdflogy', 4);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('svafrgg', 'Nfdjkklsdjlogy', 8);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('sg4', 'Bgsjkfsjllogy', 9);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('sgr4w', 'Tfkjsjlogy', 2);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('WBK', 'Xlfgjhlogy', 1);
