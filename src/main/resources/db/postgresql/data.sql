INSERT INTO Role(id, name) VALUES
(1, 'ADMIN'),
(2, 'TEACHER'),
(3, 'PUPIL');

INSERT INTO User(id, role_id, login, password, name, surname, patronymic) VALUES
(1, 2, "teacher", "teacher", "Учитель_Имя", "Учитель_Фамилия", "Учитель_Отчество"),
(2, 2, "pupil", "pupil", "Ученик_Имя", "Ученик_Фамилия", "Ученик_Отчество");

INSERT INTO Groups(id, groupNo, faculty, course) VALUES
(1, 15, "ФМиИТ", 1);

INSERT INTO Teacher(id) VALUES
(1);

INSERT INTO Pupil(id, group_id) VALUES
(2, 1);

INSERT INTO Subject(id, name) VALUES
(1, "Русский язык");