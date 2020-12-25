DROP TABLE IF EXISTS courses CASCADE;
DROP TABLE IF EXISTS dayschedules CASCADE;
DROP TABLE IF EXISTS groupz CASCADE;
DROP TABLE IF EXISTS lessons CASCADE;
DROP TABLE IF EXISTS professors CASCADE;
DROP TABLE IF EXISTS students CASCADE;
DROP TABLE IF EXISTS yearchedules CASCADE;

CREATE TABLE courses
(
    course_id SERIAL PRIMARY KEY,
    course_name CHARACTER VARYING(30),
    course_description CHARACTER VARYING(300)
);

CREATE TABLE dayschedules
(
    dayschedule_id SERIAL PRIMARY KEY,
    date CHARACTER VARYING(30),
    hasOverlaps INTEGER 
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
    professor_id INTEGER
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
    student_name CHARACTER VARYING(30),
    FOREIGN KEY(group_id) REFERENCES groupz(group_id)
);

CREATE TABLE yearschedules
(
    year_id SERIAL PRIMARY KEY,
    year INTEGER
);

CREATE TABLE course_professor
(
    course_id INTEGER,
    professor_id INTEGER,
    FOREIGN KEY(course_id) REFERENCES courses(course_id),
    FOREIGN KEY(professor_id) REFERENCES professors(professor_id)
);

CREATE TABLE lesson_professor
(
    lesson_id INTEGER,
    professor_id INTEGER,
    FOREIGN KEY(lesson_id) REFERENCES lessons(lesson_id),
    FOREIGN KEY(professor_id) REFERENCES professors(professor_id)
);

CREATE TABLE group_student
(
    group_id INTEGER,
    student_id INTEGER,
    FOREIGN KEY(group_id) REFERENCES groupz(group_id),
    FOREIGN KEY(student_id) REFERENCES student(student_id)
);

CREATE TABLE lesson_group
(
    lesson_id INTEGER,
    group_id INTEGER,
    FOREIGN KEY(lesson_id) REFERENCES lessons(lesson_id),
    FOREIGN KEY(group_id) REFERENCES groupz(group_id)
);

CREATE TABLE lesson_dayschedule
(
    lesson_id INTEGER,
    dayschedule_id INTEGER,
    FOREIGN KEY(lesson_id) REFERENCES lessons(lesson_id),
    FOREIGN KEY(dayschedule_id) REFERENCES dayschedules(dayschedule_id)
);

CREATE TABLE yearschedule_dayschedule
(
    year INTEGER,
    dayschedule_id INTEGER,
    FOREIGN KEY(year) REFERENCES yearschedule(year),
    FOREIGN KEY(dayschedule_id) REFERENCES dayschedules(dayschedule_id)
);
