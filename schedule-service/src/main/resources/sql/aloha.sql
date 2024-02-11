-- предмет

CREATE TABLE subject (
    subject_name VARCHAR(255) PRIMARY KEY
);

CREATE TABLE teacher (
    id SERIAL PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255),
    age INTEGER,
    item_name VARCHAR(255) REFERENCES subject (subject_name) ON DELETE CASCADE
);

CREATE TABLE group (
    group_number SERIAL PRIMARY KEY
);

CREATE TABLE student (
                         id SERIAL PRIMARY KEY,
                         firstname VARCHAR(255) NOT NULL,
                         lastname VARCHAR(255) NOT NULL,
                         patronymic VARCHAR(255),
                         age INTEGER,
                         group_number INTEGER REFERENCES group (group_number)
);

CREATE TABLE lesson (
                        lesson_number INTEGER not null,
                        week_day VARCHAR(255) not null ,
                        subject_name VARCHAR(255),
                        group_number INTEGER,
                        teacher_id INTEGER,
                        FOREIGN KEY (subject_name) REFERENCES subject (subject_name) ON DELETE CASCADE,
                        FOREIGN KEY (group_number) REFERENCES group (group_number) ON DELETE CASCADE,
                        FOREIGN KEY (teacher_id) REFERENCES teacher (id) ON DELETE CASCADE,
    unique (lesson_number,week_day,subject_name,group_number,teacher_id)

);
