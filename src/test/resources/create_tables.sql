DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS dayschedules;
DROP TABLE IF EXISTS groupz;
DROP TABLE IF EXISTS lessons;
DROP TABLE IF EXISTS professors;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS yearschedules;
DROP TABLE IF EXISTS yearschedule_dayschedule;
DROP TABLE IF EXISTS lesson_dayschedule;
DROP TABLE IF EXISTS lesson_group;
DROP TABLE IF EXISTS group_student;
DROP TABLE IF EXISTS lesson_professor;
DROP TABLE IF EXISTS course_professor;


CREATE TABLE courses
(
    course_id SERIAL PRIMARY KEY,
    course_name CHARACTER VARYING(30),
    course_description CHARACTER VARYING(300),
    professor_id INTEGER
);

CREATE TABLE dayschedules
(
    dayschedule_id SERIAL PRIMARY KEY,
    date CHARACTER VARYING(30),
    hasOverlaps BOOLEAN 
);

CREATE TABLE groupz
(
    group_id SERIAL PRIMARY KEY,
    group_note CHARACTER VARYING(512),
    department_id INTEGER
);

CREATE TABLE lessons
(
    lesson_id SERIAL PRIMARY KEY,
    start_time CHARACTER VARYING(30),
    end_time CHARACTER VARYING(30),
    professor_id INTEGER,
    group_id INTEGER
);

CREATE TABLE professors
(
    professor_id SERIAL PRIMARY KEY,
    professor_name CHARACTER VARYING(30),
    professor_ranks CHARACTER VARYING(512),
    professor_notes CHARACTER VARYING(512),
    department_id INTEGER    
);

CREATE TABLE students
(
    student_id SERIAL PRIMARY KEY,
    group_id INTEGER,
    student_year INTEGER,
    student_name CHARACTER VARYING(30)
);

CREATE TABLE yearschedules
(
    yearschedule_id SERIAL PRIMARY KEY,
    year INTEGER
);

CREATE TABLE course_professor
(
    course_id INTEGER,
    professor_id INTEGER
);

CREATE TABLE lesson_professor
(
    lesson_id INTEGER,
    professor_id INTEGER
);

CREATE TABLE group_student
(
    group_id INTEGER,
    student_id INTEGER
);

CREATE TABLE lesson_group
(
    lesson_id INTEGER,
    group_id INTEGER
);

CREATE TABLE lesson_dayschedule
(
    lesson_id INTEGER,
    dayschedule_id INTEGER
);

CREATE TABLE yearschedule_dayschedule
(
    yearschedule_id INTEGER,
    dayschedule_id INTEGER
);

INSERT INTO groupz(group_note, department_id) VALUES ('So-so group', 1);
INSERT INTO groupz(group_note, department_id) VALUES ('Worst Group', 1);
INSERT INTO groupz(group_note, department_id) VALUES ('Best Group', 1);
INSERT INTO groupz(group_note, department_id) VALUES ('Nonsense Group', 1);

INSERT INTO courses(course_name, course_description, professor_id) VALUES ('Maths', 'Mathematics', 2);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('Bio', 'Biology', 2);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('Eng', 'English', 2);
INSERT INTO courses(course_name, course_description, professor_id) VALUES ('Hist', 'History', 2);

INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('1970-01-01 00:01', '1970-01-01 01:01', 1, 2);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('1970-02-01 00:01', '1970-02-01 01:01', 2, 2);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('1970-03-01 00:01', '1970-03-01 01:01', 3, 2);
INSERT INTO lessons(start_time, end_time, professor_id, group_id) VALUES ('1970-04-01 00:01', '1970-04-01 01:01', 4, 2);

INSERT INTO dayschedules(date, hasOverlaps) VALUES ('1970-01-01 00:01', FALSE);
INSERT INTO dayschedules(date, hasOverlaps) VALUES ('1970-02-01 00:01', TRUE);
INSERT INTO dayschedules(date, hasOverlaps) VALUES ('1970-03-01 00:01', FALSE);
INSERT INTO dayschedules(date, hasOverlaps) VALUES ('1970-04-01 00:01', TRUE);

INSERT INTO professors(professor_name, professor_ranks, professor_notes, department_id) 
    values ('John Lennon', 'Most Excellent Order of the British Empire ', 'Husband of Yoko Ono', 1);
INSERT INTO professors(professor_name, professor_ranks, professor_notes, department_id) 
    values ('Graham Greene', 'Order of the Companions of Honour', 'He wrote The Journey Without Maps', 1);
INSERT INTO professors(professor_name, professor_ranks, professor_notes, department_id) 
    values ('Aram Khachaturian', 'Lenin Prize|Stalin Prize', 'Creator of Gayane Ballet', 1);
INSERT INTO professors(professor_name, professor_ranks, professor_notes, department_id) 
    values ('Prabhat Ranjan Sarkar', 'Anandamurti', 'Founder of Ananda Marga', 1);

INSERT INTO students(group_id, student_year, student_name) VALUES (1, 1, 'Li Hongzhi');
INSERT INTO students(group_id, student_year, student_name) VALUES (2, 1, 'Jimmy Carter');
INSERT INTO students(group_id, student_year, student_name) VALUES (1, 1, 'Goodluck Jonathan');
INSERT INTO students(group_id, student_year, student_name) VALUES (1, 1, 'Buka S. Dimka');

INSERT INTO yearschedules(year) VALUES (1970);
INSERT INTO yearschedules(year) VALUES (1971);
INSERT INTO yearschedules(year) VALUES (1972);
INSERT INTO yearschedules(year) VALUES (1973);

INSERT INTO course_professor(course_id, professor_id) VALUES (1, 2);
INSERT INTO course_professor(course_id, professor_id) VALUES (2, 3);
INSERT INTO course_professor(course_id, professor_id) VALUES (3, 4);
INSERT INTO course_professor(course_id, professor_id) VALUES (4, 1);

INSERT INTO lesson_professor (lesson_id, professor_id) VALUES(1, 2);
INSERT INTO lesson_professor (lesson_id, professor_id) VALUES(2, 3);
INSERT INTO lesson_professor (lesson_id, professor_id) VALUES(3, 4);
INSERT INTO lesson_professor (lesson_id, professor_id) VALUES(4, 1);

INSERT INTO group_student (group_id, student_id) VALUES(1, 2);
INSERT INTO group_student (group_id, student_id) VALUES(2, 3);
INSERT INTO group_student (group_id, student_id) VALUES(3, 4);
INSERT INTO group_student (group_id, student_id) VALUES(4, 1);

INSERT INTO lesson_group (lesson_id, group_id) VALUES (1, 2);
INSERT INTO lesson_group (lesson_id, group_id) VALUES (2, 3);
INSERT INTO lesson_group (lesson_id, group_id) VALUES (3, 4);
INSERT INTO lesson_group (lesson_id, group_id) VALUES (4, 1);

INSERT INTO lesson_dayschedule (lesson_id, dayschedule_id) VALUES (1, 2);
INSERT INTO lesson_dayschedule (lesson_id, dayschedule_id) VALUES (2, 3);
INSERT INTO lesson_dayschedule (lesson_id, dayschedule_id) VALUES (3, 4);
INSERT INTO lesson_dayschedule (lesson_id, dayschedule_id) VALUES (4, 1);

INSERT INTO yearschedule_dayschedule (yearschedule_id, dayschedule_id) VALUES (1, 1);
INSERT INTO yearschedule_dayschedule (yearschedule_id, dayschedule_id) VALUES (1, 2);
INSERT INTO yearschedule_dayschedule (yearschedule_id, dayschedule_id) VALUES (1, 3);
INSERT INTO yearschedule_dayschedule (yearschedule_id, dayschedule_id) VALUES (1, 4);

