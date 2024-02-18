INSERT INTO megasoft.worker (name, birthday, level, salary) VALUES
    ('John Doe', '1990-05-15', 'Trainee', 700),
    ('Jane Smith', '1988-08-22', 'Junior', 22000),
    ('Robert Johnson', '1995-02-10', 'Middle', 55000),
    ('Emily Davis', '1992-11-05', 'Senior', 90000),
    ('Michael Brown', '1987-04-18', 'Trainee', 1500),
    ('Sophia Wilson', '1993-07-30', 'Junior', 15500),
    ('Daniel Taylor', '1989-09-12', 'Middle', 35000),
    ('Olivia Lee', '1998-01-25', 'Senior', 90000),
    ('David Miller', '1991-06-08', 'Trainee', 1000),
    ('Ava Anderson', '1985-12-03', 'Junior', 10800);
INSERT INTO megasoft.client (name) VALUES
	('BMW'),
	('VOLVO'),
	('TOYOTA'),
	('HYUNDAI'),
	('MERCEDES');
INSERT INTO megasoft.project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES
	(3, '2022-11-05', '2023-09-15'),
	(5, '2019-05-14', '2023-12-13'),
	(1, '2020-04-21', '2022-08-16'),
	(2, '2015-02-03', '2018-10-05'),
	(2, '2016-04-18', '2020-09-15'),
	(4, '2010-12-03', '2018-07-29'),
	(5, '2023-02-13', '2023-03-15'),
	(1, '2012-04-16', '2019-07-21'),
	(2, '2014-01-06', '2021-10-07'),
	(3, '2022-08-16', '2023-09-19');
INSERT INTO megasoft.project_worker (PROJECT_ID, WORKER_ID) VALUES
	(5,3),
	(4,4),
	(9,10),
	(5,2),
	(10,8),
	(6,5),
	(4,8),
	(7,5),
	(10,3),
	(9,5),
	(2,1),
	(3,2),
	(1,5),
	(2,9);