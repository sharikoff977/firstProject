INSERT INTO public.school_class(id, letter, "number") VALUES (1,'a', 10);
INSERT INTO public.school_class(id, letter, "number") VALUES (2,'b', 11);
INSERT INTO public.student(id, first_name, last_name, school_class_id) VALUES (5, 'Dima', 'Sharovskiy', 1);
INSERT INTO public.student(id, first_name, last_name, school_class_id) VALUES (6, 'Anna', 'Parkhomenko', 1);
INSERT INTO public.student(id, first_name, last_name, school_class_id) VALUES (7, 'Anton', 'Solyanik', 1);
INSERT INTO public.student(id, first_name, last_name, school_class_id) VALUES (8, 'Olya', 'Hnashuk', 1);
INSERT INTO public.student(id, first_name, last_name, school_class_id) VALUES (9, 'Elona', 'Kanarska', 2);
INSERT INTO public.student(id, first_name, last_name, school_class_id) VALUES (10, 'Oleg', 'Gnashuk', 2);
INSERT INTO public.student(id, first_name, last_name, school_class_id) VALUES (11, 'Dashka', 'Kakashka', 2);
INSERT INTO public.student(id, first_name, last_name, school_class_id) VALUES (12, 'Ren', 'Vsempuzdec', 2);
INSERT INTO public.subject(id, title) VALUES (13, 'maths');
INSERT INTO public.subject(id, title) VALUES (14, 'language');
INSERT INTO public.subject(id, title) VALUES (15, 'reading');
INSERT INTO public.subject(id, title) VALUES (16, 'test');
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (17, '2022-03-01', 12, 5, 13);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (18, '2022-03-05', 9, 5, 13);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (19, '2022-03-02', 11, 6, 13);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (20, '2022-03-03', 10, 7, 13);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (21, '2022-03-04', 9, 8, 13);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (22, '2022-03-01', 11, 5, 14);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (23, '2022-03-05', 10, 5, 14);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (24, '2022-03-02', 9, 6, 14);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (25, '2022-03-03', 12, 7, 14);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (26, '2022-03-04', 11, 8, 14);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (27, '2022-03-01', 10, 5, 15);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (28, '2022-03-05', 9, 5, 15);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (29, '2022-03-02', 12, 6, 15);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (30, '2022-03-03', 11, 7, 15);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (31, '2022-03-04', 10, 8, 15);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (32, '2022-03-01', 9, 5, 16);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (33, '2022-03-05', 12, 5, 16);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (34, '2022-03-02', 11, 6, 16);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (35, '2022-03-03', 10, 7, 16);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (36, '2022-03-04', 9, 8, 16);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (37, '2022-03-01', 12, 9, 13);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (38, '2022-03-05', 9, 9, 13);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (39, '2022-03-02', 11, 10, 13);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (40, '2022-03-03', 10, 11, 13);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (41, '2022-03-04', 9, 12, 13);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (42, '2022-03-01', 11, 9, 14);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (43, '2022-03-05', 10, 9, 14);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (44, '2022-03-02', 9, 10, 14);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (45, '2022-03-03', 12, 11, 14);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (46, '2022-03-04', 11, 12, 14);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (47, '2022-03-01', 10, 9, 15);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (48, '2022-03-05', 9, 9, 15);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (149, '2022-03-02', 12, 10, 15);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (150, '2022-03-03', 11, 11, 15);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (151, '2022-03-04', 10, 12, 15);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (152, '2022-03-01', 9, 9, 16);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (153, '2022-03-05', 12, 9, 16);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (154, '2022-03-02', 11, 10, 16);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (155, '2022-03-03', 10, 11, 16);
INSERT INTO public.grade(id, date_time, value, student_id, subject_id) VALUES (156, '2022-03-04', 9, 12, 16);

INSERT INTO public.teacher(id, name) VALUES (157, 'Anna Parkhomenko');
INSERT INTO public.teacher(id, name) VALUES (158, 'Marina Sharovskaya');
INSERT INTO public.teacher(id, name) VALUES (159, 'Lena Holovach');
INSERT INTO public.teacher(id, name) VALUES (160, 'Shimon Peres');

INSERT INTO public.school_room(id, "number") VALUES (161, 100);
INSERT INTO public.school_room(id, "number") VALUES (162, 200);
INSERT INTO public.school_room(id, "number") VALUES (163, 300);
INSERT INTO public.school_room(id, "number") VALUES (164, 400);

INSERT INTO public.lesson(id, "number", time_of_lesson) VALUES (165, 1, '08:00:00');
INSERT INTO public.lesson(id, "number", time_of_lesson) VALUES (166, 2, '09:00:00');
INSERT INTO public.lesson(id, "number", time_of_lesson) VALUES (167, 3, '10:00:00');
INSERT INTO public.lesson(id, "number", time_of_lesson) VALUES (168, 4, '11:00:00');
INSERT INTO public.lesson(id, "number", time_of_lesson) VALUES (169, 5, '12:00:00');
INSERT INTO public.lesson(id, "number", time_of_lesson) VALUES (170, 6, '13:00:00');

INSERT INTO public.schedule(id, date, school_class_id, subject_id, day_of_week, school_room_id, teacher_id, lesson_id) VALUES (49, '2022-03-01', 1, 13, 'Monday', 161, 157, 165);
INSERT INTO public.schedule(id, date, school_class_id, subject_id, day_of_week, school_room_id, teacher_id, lesson_id) VALUES (50, '2022-03-02', 1, 13, 'Monday', 161, 157, 165);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (50, '2022-03-02', 1, 13);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (51, '2022-03-03', 1, 13);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (52, '2022-03-04', 1, 13);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (53, '2022-03-05', 1, 13);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (54, '2022-03-01', 1, 14);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (55, '2022-03-02', 1, 14);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (56, '2022-03-03', 1, 14);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (57, '2022-03-04', 1, 14);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (58, '2022-03-05', 1, 14);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (59, '2022-03-01', 1, 15);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (60, '2022-03-02', 1, 15);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (61, '2022-03-03', 1, 15);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (62, '2022-03-04', 1, 15);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (63, '2022-03-05', 1, 15);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (64, '2022-03-01', 1, 16);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (65, '2022-03-02', 1, 16);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (66, '2022-03-03', 1, 16);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (67, '2022-03-04', 1, 16);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (68, '2022-03-05', 1, 16);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (69, '2022-03-01', 2, 13);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (70, '2022-03-02', 2, 13);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (71, '2022-03-03', 2, 13);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (72, '2022-03-04', 2, 13);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (73, '2022-03-05', 2, 13);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (74, '2022-03-01', 2, 14);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (75, '2022-03-02', 2, 14);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (76, '2022-03-03', 2, 14);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (77, '2022-03-04', 2, 14);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (78, '2022-03-05', 2, 14);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (79, '2022-03-01', 2, 15);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (80, '2022-03-02', 2, 15);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (81, '2022-03-03', 2, 15);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (82, '2022-03-04', 2, 15);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (83, '2022-03-05', 2, 15);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (84, '2022-03-01', 2, 16);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (85, '2022-03-02', 2, 16);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (86, '2022-03-03', 2, 16);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (87, '2022-03-04', 2, 16);
INSERT INTO public.schedule(id, date, school_class_id, subject_id) VALUES (88, '2022-03-05', 2, 16);
SELECT setval('hibernate_sequence', 1000);
