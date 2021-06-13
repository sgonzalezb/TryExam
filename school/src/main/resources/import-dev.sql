DROP IF EXISTS TABLE school;
DROP IF EXISTS TABLE student;
CREATE TABLE school
(
    id_school BIGINT NOT NULL UNIQUE,
    name VARCHAR(255),
    PRIMARY KEY (id)
) ENGINE = InnoDB;
CREATE TABLE student(
    id_student BIGINT NOT NULL UNIQUE, 
    name varchar(255),
    location varchar(255),
    PRIMARY KEY (name),
    ) ENGINE = InnoDB;

CREATE TABLE enrollment(
    id BIGINT NOT NULL UNIQUE,
    id_school BIGINT NOT NULL,
    id_student BIGINT NOT NULL,
    CONSTRAINT `fk_school_student_enrollment`
        FOREIGN KEY(id_school) REFERENCES school(id_school)
        ON DELETE SET NULL
        ON UPDATE SET NULL
        FOREIGN KEY(id_student) REFERENCES student(id_student)
)ENGINE = InnoDB;

INSERT INTO school (id_school,name) VALUES (1,'Xaloc'),(2,'Borja Moll');
INSERT INTO student (id_student,name,location) VALUES (20,'Sergio','Calvia'),(12,'Marcos','Palma');
INSERT INTO enrollment (id,id_school,id_student) VALUES (1,1,20),(2,2,12);
