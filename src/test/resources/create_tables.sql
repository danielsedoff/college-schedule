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
    values ('John Lennon', 'Most Excellent Order of the British Empire ', 'Husband of Yoko Ono', 1);
INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id) 
    values ('Graham Greene', 'Order of the Companions of Honour', 'He wrote The Journey Without Maps', 2);
INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id) 
    values ('Aram Khachaturian', 'Lenin Prize|Stalin Prize', 'Creator of Gayane Ballet', 3);
INSERT INTO professors(person_name, professor_ranks, professor_notes, course_id) 
    values ('Prabhat Ranjan Sarkar', 'Anandamurti', 'Founder of Ananda Marga', 4);
    
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

INSERT INTO courses(course_name, course_description, professor_id) VALUES ('Maths', 'Mathematics', 2);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('Bio', 'Biology', 2);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('Eng', 'English', 2);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('Hist', 'History', 2);
