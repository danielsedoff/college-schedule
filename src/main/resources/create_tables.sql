DROP TABLE IF EXISTS students CASCADE;
DROP TABLE IF EXISTS courses CASCADE;
DROP TABLE IF EXISTS professors CASCADE;
DROP TABLE IF EXISTS dayschedules CASCADE;
DROP TABLE IF EXISTS groupz CASCADE;
DROP TABLE IF EXISTS lessons CASCADE;
DROP TABLE IF EXISTS yearschedules CASCADE;
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

CREATE TABLE yearschedules
(
    yearschedule_id SERIAL PRIMARY KEY,
    year INTEGER
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

CREATE TABLE dayschedules
(
    dayschedule_id SERIAL PRIMARY KEY,
    yearschedule_id INTEGER REFERENCES yearschedules(yearschedule_id),
    the_day CHARACTER VARYING(30),
    hasOverlaps BOOLEAN
);

CREATE TABLE lessons
(
    lesson_id SERIAL PRIMARY KEY,
    start_time CHARACTER VARYING(30),
    end_time CHARACTER VARYING(30),
    professor_id INTEGER REFERENCES professors(person_id),
    group_id INTEGER REFERENCES groupz (group_id),
    dayschedule_id INTEGER REFERENCES dayschedules(dayschedule_id)
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
	values(2, 'user@mail.com', 'A Normal User', '$2y$12$LaT3Er7jiOIf1OhMKHvEx.Muh0a9gl1yKyES4j2kdB6CIHgjfn4t.', 
	'USER', 'BANNED');

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
    
INSERT INTO yearschedules(year) VALUES (2019);
INSERT INTO yearschedules(year) VALUES (1971);
INSERT INTO yearschedules(year) VALUES (1972);
INSERT INTO yearschedules(year) VALUES (1973);

INSERT INTO groupz(group_note) VALUES ('So-so group');
INSERT INTO groupz(group_note) VALUES ('Worst Group');
INSERT INTO groupz(group_note) VALUES ('Best Group');
INSERT INTO groupz(group_note) VALUES ('Nonsense Group');

INSERT INTO students(group_id, student_year, person_name) VALUES (1, 1, 'Li Hongzhi');
INSERT INTO students(group_id, student_year, person_name) VALUES (2, 1, 'Jimmy Carter');
INSERT INTO students(group_id, student_year, person_name) VALUES (1, 1, 'Goodluck Jonathan');
INSERT INTO students(group_id, student_year, person_name) VALUES (1, 1, 'Buka S. Dimka');

INSERT INTO dayschedules(the_day, hasoverlaps) VALUES ('2019-01-01 00:01', FALSE);
INSERT INTO dayschedules(the_day, hasoverlaps) VALUES ('2019-02-01 00:01', TRUE);
INSERT INTO dayschedules(the_day, hasoverlaps) VALUES ('2019-03-01 00:01', FALSE);
INSERT INTO dayschedules(the_day, hasoverlaps) VALUES ('2019-04-01 00:01', TRUE);

INSERT INTO lessons(start_time, end_time, professor_id, group_id, dayschedule_id) VALUES ('2019-01-01 00:01', '2019-01-01 01:01', 1, 2, 1);
INSERT INTO lessons(start_time, end_time, professor_id, group_id, dayschedule_id) VALUES ('2019-02-01 00:01', '2019-02-01 01:01', 2, 2, 1);
INSERT INTO lessons(start_time, end_time, professor_id, group_id, dayschedule_id) VALUES ('2019-03-01 00:01', '2019-03-01 01:01', 3, 2, 1);
INSERT INTO lessons(start_time, end_time, professor_id, group_id, dayschedule_id) VALUES ('2019-04-01 00:01', '2019-04-01 01:01', 4, 2, 1);

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
