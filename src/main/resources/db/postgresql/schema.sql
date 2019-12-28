CREATE TABLE Role(
	id SERIAL PRIMARY KEY,
	name VARCHAR(32) NOT NULL
);

CREATE TABLE Users(
	id SERIAL PRIMARY KEY,
	role_id INT NOT NULL REFERENCES Role(id),
	login VARCHAR(32) UNIQUE NOT NULL,
	password VARCHAR(32) NOT NULL,
	name VARCHAR(16) NOT NULL,
	surname VARCHAR(26) NOT NULL DEFAULT '',
	patronymic VARCHAR(26) DEFAULT ''
);

CREATE TABLE Groups(
	id SERIAL PRIMARY KEY,
	groupNo SMALLINT NOT NULL,
	faculty VARCHAR(8) NOT NULL DEFAULT '',
	course SMALLINT NOT NULL
);

CREATE TABLE Pupil(
	id SERIAL PRIMARY KEY,
	group_id INT NOT NULL REFERENCES Groups(id)
);

CREATE TABLE Subject(
	id SERIAL PRIMARY KEY,
	name VARCHAR(32) NOT NULL DEFAULT ''
);

CREATE TABLE TaskType(
	id SERIAL PRIMARY KEY,
	name VARCHAR(128) UNIQUE NOT NULL DEFAULT '',
	task_xsd TEXT,
	result_xsd TEXT
);

CREATE TABLE Task(
	id SERIAL PRIMARY KEY,
	teacher_id INT NOT NULL REFERENCES Users(id),
	taskType_id INT  NOT NULL REFERENCES TaskType(id),
	subject_id INT NOT NULL REFERENCES Subject(id),
	name VARCHAR(64) NOT NULL DEFAULT '',
	description VARCHAR(128) NOT NULL DEFAULT '''',
	taskText TEXT
);

CREATE TABLE Attempt(
	id SERIAL PRIMARY KEY,
	task_id INT NOT NULL REFERENCES Task(id),
	attemptStart DATE,
	attemptEnd DATE,
);

CREATE TABLE PupilAttempt(
	id SERIAL PRIMARY KEY,
	pupil_id INT NOT NULL REFERENCES Pupil(id),
	attempt_id INT NOT NULL REFERENCES Attempt(id),
	text TEXT,
	mark SMALLINT
);

CREATE TABLE Rule(
	id SERIAL PRIMARY KEY,
	name VARCHAR(164) UNIQUE NOT NULL DEFAULT '',
	description TEXT NOT NULL,
	note VARCHAR(128)
);

CREATE TABLE Mistake(
	id SERIAL PRIMARY KEY,
	pupilAttempt_id INT NOT NULL REFERENCES PupilAttempt(id),
	rule_id INT NOT NULL REFERENCES Rule(id),
	rowNo INT NOT NULL,
	colNo INT NOT NULL
);