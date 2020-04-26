DROP ALL OBJECTS;

--DROP TABLE PupilAttempt IF EXISTS;
--DROP TABLE Attempt IF EXISTS;
--DROP TABLE Task IF EXISTS;
--DROP TABLE Teacher IF EXISTS;
--DROP TABLE GROUPS_USER IF EXISTS;
--DROP TABLE PupilMistake IF EXISTS;
--DROP TABLE Mistake IF EXISTS;
--DROP TABLE Rule IF EXISTS;
--DROP TABLE Pupil IF EXISTS;
--DROP TABLE Groups IF EXISTS;
--DROP TABLE User IF EXISTS;
--DROP TABLE Subject IF EXISTS;
--DROP TABLE TaskType IF EXISTS;
--DROP TABLE Role IF EXISTS;


CREATE TABLE Role(
   id SERIAL PRIMARY KEY,
   name VARCHAR(32) NOT NULL
);

CREATE TABLE User(
   id SERIAL PRIMARY KEY,
   role_id INT NOT NULL,
   user_type TINYINT,
   login VARCHAR(32) UNIQUE NOT NULL,
   password VARCHAR(32) NOT NULL,
   name VARCHAR(16) NOT NULL,
   surname VARCHAR(26) NOT NULL,
   patronymic VARCHAR(26),
   FOREIGN KEY (role_id) REFERENCES Role(id)
);

CREATE TABLE Teacher(
    id SERIAL PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES User(id)
);

CREATE TABLE Groups(
   id SERIAL PRIMARY KEY,
   groupNo SMALLINT NOT NULL,
   faculty VARCHAR(8) NOT NULL,
   course SMALLINT NOT NULL
);

CREATE TABLE Pupil(
   pupil_id  SERIAL PRIMARY KEY,
   group_id INT NOT NULL,
   FOREIGN KEY (pupil_id) REFERENCES User(id),
   FOREIGN KEY (group_id) REFERENCES Groups(id)
);

CREATE TABLE GROUPS_USER(
  group_id INT NOT NULL,
  user_id INT NOT NULL,
  FOREIGN KEY (group_id) REFERENCES Groups(id),
  FOREIGN KEY (user_id) REFERENCES User(id)
);

CREATE TABLE Subject(
    id SERIAL PRIMARY KEY,
    name VARCHAR(32) NOT NULL
);

CREATE TABLE TaskType(
     id SERIAL PRIMARY KEY,
     name VARCHAR(128) UNIQUE NOT NULL
);

CREATE TABLE Task(
     id SERIAL PRIMARY KEY,
     teacher_id INT NOT NULL,
     type_id INT NOT NULL,
     subject_id INT NOT NULL,
     name VARCHAR(64) NOT NULL,
     description VARCHAR(128) NOT NULL,
     taskText TEXT,
     FOREIGN KEY (teacher_id) REFERENCES Teacher(id),
     FOREIGN KEY (type_id) REFERENCES TaskType(id),
     FOREIGN KEY (subject_id) REFERENCES Subject(id)
);

CREATE TABLE Attempt(
    id SERIAL PRIMARY KEY,
    task_id INT NOT NULL,
    start BIGINT,
    end BIGINT,
    FOREIGN KEY (task_id) REFERENCES Task(id)
);

CREATE TABLE PupilAttempt(
   id SERIAL PRIMARY KEY,
   pupil_id INT NOT NULL,
   attempt_id INT NOT NULL,
   text TEXT,
   mark SMALLINT,
   FOREIGN KEY (pupil_id) REFERENCES Pupil(pupil_id),
   FOREIGN KEY (attempt_id) REFERENCES Attempt(id)
);

CREATE TABLE Rule(
    id SERIAL PRIMARY KEY,
    name VARCHAR(164) UNIQUE NOT NULL,
    description TEXT NOT NULL,
    note VARCHAR(128)
);

CREATE TABLE Mistake(
    id SERIAL PRIMARY KEY,
    rule_id INT,
    task_id INT,
    wordNo INT NOT NULL,
    symbolNo INT NOT NULL,
    FOREIGN KEY (rule_id) REFERENCES Rule(id),
    FOREIGN KEY (task_id) REFERENCES Task(id)
);

CREATE TABLE Pupil_Mistake(
    id SERIAL PRIMARY KEY,
    pupilAttempt_id INT NOT NULL,
    mistake_id INT,
    wordNo INT NOT NULL,
    symbolNo INT NOT NULL,
    FOREIGN KEY (pupilAttempt_id) REFERENCES PupilAttempt(id),
    FOREIGN KEY (mistake_id) REFERENCES Mistake(id)
);

