CREATE TABLE s_emp(
	id NUMBER(7) CONSTRAINT s_emp_id_nn NOT NULL, --직원아이디
	name VARCHAR2(25) CONSTRAINT s_emp_name_nn NOT NULL, --직원 이름
	start_date DATE,
	title VARCHAR2(25),
	dept_name VARCHAR2(25),
	salary NUMBER(11,2),
	CONSTRAINT s_emp_id_pk PRIMARY KEY(id)
);

INSERT INTO s_emp VALUES(1,'최민혜','2022-02-14','사원','개발팀',3000);

SELECT * FROM s_emp;