-- INSERT для таблицы `subject`
INSERT INTO subject (subject_name) VALUES ('Mathematics'), ('Physics'), ('Biology'), ('Chemistry'), ('History'), ('Literature'),
                                          ('English'), ('Geography'), ('Computer Science'), ('Art'), ('Music'), ('Physical Education'),
                                          ('Economics'), ('Psychology'), ('Philosophy'), ('Sociology'), ('Political Science'),
                                          ('Foreign Language'), ('Business'), ('Statistics'), ('Anthropology'), ('Environmental Science'),
                                          ('Architecture'), ('Engineering'), ('Medicine'), ('Law'), ('Journalism'), ('Film Studies'),
                                          ('Culinary Arts'), ('Marketing'), ('Finance');

-- INSERT для таблицы teacher
INSERT INTO teacher (firstname, lastname, patronymic, age, item_name) VALUES
                                                                          ('John', 'Doe', 'Smith', 40, 'Mathematics'),
                                                                          ('Alice', 'Johnson', 'Brown', 35, 'Physics'),
                                                                          ('Michael', 'Smith', 'Wilson', 32, 'Chemistry'),
                                                                          ('Emma', 'Davis', 'Jones', 28, 'Biology'),
                                                                          ('Daniel', 'Wilson', 'Lee', 41, 'English'),
                                                                          ('Sophia', 'Thomas', 'Taylor', 37, 'History'),
                                                                          ('Liam', 'Anderson', 'White', 29, 'Geography'),
                                                                          ('Olivia', 'Brown', 'King', 33, 'Computer Science'),
                                                                          ('Noah', 'Clark', 'Harris', 35, 'Literature'),
                                                                          ('Ava', 'Martin', 'Thomas', 42, 'Art'),
                                                                          ('James', 'Young', 'Hill', 31, 'Music'),
                                                                          ('Isabella', 'Garcia', 'Scott', 38, 'Physical Education'),
                                                                          ('Benjamin', 'Lewis', 'Walker', 34, 'Economics'),
                                                                          ('Mia', 'Hall', 'Collins', 39, 'Psychology'),
                                                                          ('William', 'Allen', 'Green', 40, 'Philosophy'),
                                                                          ('Charlotte', 'Adams', 'Roberts', 36, 'Sociology'),
                                                                          ('Henry', 'Parker', 'Hernandez', 30, 'Foreign Language'),
                                                                          ('Ella', 'Turner', 'Morris', 27, 'Business'),
                                                                          ('Alexander', 'Cook', 'Davis', 31, 'Statistics'),
                                                                          ('Harper', 'Baker', 'Lopez', 29, 'Environmental Science'),
                                                                          ('Sofia', 'Gonzalez', 'Kelly', 33, 'Engineering'),
                                                                          ('Jackson', 'Ward', 'Ross', 27, 'Medicine'),
                                                                          ('Amelia', 'Cruz', 'Price', 35, 'Law'),
                                                                          ('Owen', 'Mitchell', 'Young', 32, 'Journalism'),
                                                                          ('Emily', 'Perez', 'Simmons', 30, 'Film Studies');

INSERT INTO lesson (lesson_number, week_day, subject_name, group_number, teacher_id) VALUES
                                                                                         (1, 'Monday', 'Mathematics', 1, 1),
                                                                                         (2, 'Monday', 'Physics', 1, 2),
                                                                                         (3, 'Monday', 'Chemistry', 1, 3),
                                                                                         (4, 'Monday', 'Biology', 1, 4),
                                                                                         (1, 'Tuesday', 'Mathematics', 1, 1),
                                                                                         (2, 'Tuesday', 'Physics', 1, 2),
                                                                                         (3, 'Tuesday', 'Chemistry', 1, 3),
                                                                                         (4, 'Tuesday', 'Biology', 1, 4),
                                                                                         (1, 'Thursday', 'Mathematics', 1, 1),
                                                                                         (2, 'Thursday', 'Physics', 1, 2),
                                                                                         (3, 'Thursday', 'Chemistry', 1, 3),
                                                                                         (4, 'Thursday', 'Biology', 1, 4),
                                                                                         (1, 'Wednesday', 'Mathematics', 1, 1),
                                                                                         (2, 'Wednesday', 'Physics', 1, 2),
                                                                                         (3, 'Wednesday', 'Chemistry', 1, 3),
                                                                                         (4, 'Wednesday', 'Biology', 1, 4),
                                                                                         (1, 'Friday', 'Mathematics', 1, 1),
                                                                                         (2, 'Friday', 'Physics', 1, 2),
                                                                                         (3, 'Friday', 'Chemistry', 1, 3),
                                                                                         (4, 'Friday', 'Biology', 1, 4);



INSERT INTO group_ (group_number) VALUES
                                      (1), (2), (3), (4), (5),
                                      (6), (7), (8), (9), (10),
                                      (11), (12), (13), (14), (15),
                                      (16), (17), (18), (19), (20),
                                      (21), (22), (23), (24), (25),
                                      (26), (27), (28), (29), (30);

INSERT INTO student (firstname, lastname, patronymic, age, group_number) VALUES
                                                                             ('John', 'Doe', NULL, 20, 1),
                                                                             ('Jane', 'Smith', NULL, 22, 2),
                                                                             ('Alice', 'Johnson', NULL, 21, 2),
                                                                             ('Bob', 'Brown', NULL, 23, 1),
                                                                             ('Emma', 'Davis', NULL, 24, 3),
                                                                             ('Michael', 'Wilson', NULL, 20, 2),
                                                                             ('Sarah', 'Martinez', NULL, 22, 1),
                                                                             ('David', 'Garcia', NULL, 21, 1),
                                                                             ('Emily', 'Lee', NULL, 23, 1),
                                                                             ('James', 'Lopez', NULL, 24 ,2),
                                                                             ('Olivia','Hernandez' ,NULL ,20 ,1 ),
                                                                             ('William','Young' ,NULL ,22 ,2 ),
                                                                             ('Ethan','King' ,NULL ,21 ,3 ),
                                                                             ('Ava','Adams' ,NULL ,23 ,1 ),
                                                                             ('Sophia','Scott' ,NULL ,24 ,1 ),
                                                                             ('Alexander','Mitchell' ,NULL ,20 ,1 ),
                                                                             ('Mia','Roberts' ,NULL ,22 ,1 ),
                                                                             ('Charlotte','Cook' ,NULL ,21 ,1 ),
                                                                             ('Amelia','Bailey' ,NULL ,23 ,1 ),
                                                                             ('Harper','Murphy' ,NULL ,24 ,2 ),
                                                                             ('Evelyn','Green' ,NULL ,20 ,1 ),
                                                                             ('Elijah','Baker' ,NULL ,22 ,2 ),
                                                                             ('Benjamin','Evans' ,NULL ,21 ,2 ),
                                                                             ('Logan','Rivera' ,NULL ,23 ,2 ),
                                                                             ('Aiden','Ward' ,NULL ,24 ,2 ),
                                                                             ('Lucas','Cruz' ,NULL ,20 ,2 ),
                                                                             ('Mason','Perez' ,NULL ,22 ,2 ),
                                                                             ('Oliver','Reed' ,NULL ,21 ,2 ),
                                                                             ('Ella','Gomez' ,NULL ,23 ,2 ),
                                                                             ('Avery','Sullivan' ,NULL ,24 ,3 );


