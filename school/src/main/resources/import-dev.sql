DROP IF EXISTS TABLE school;
DROP IF EXISTS TABLE student;
CREATE TABLE school
(
    school_name VARCHAR(255) NOT NULL UNIQUE,
    location VARCHAR(255),
    PRIMARY KEY (school_name)
) ENGINE = InnoDB;
CREATE TABLE student(
    name VARCHAR(255) NOT NULL UNIQUE, 
    age INT,
    school_name VARCHAR(255),
    PRIMARY KEY (name),
    CONSTRAINT `fk_school_student`
        FOREIGN KEY(school_name) REFERENCES school(school_name)
        ON DELETE SET NULL
        ON UPDATE SET NULL
    ) ENGINE = InnoDB;
INSERT INTO school (school_name,location) VALUES ('BorjaMoll','Palma'),('Xaloc','Paguera');
INSERT INTO student (name,age, school_name) VALUES ('Sergio',20,'Xaloc'),('Toni',15,'BorjaMoll');