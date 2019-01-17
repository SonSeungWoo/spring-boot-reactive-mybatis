DROP TABLE IF EXISTS PERSON;

CREATE TABLE PERSON (ID INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR, AGE INT,COUNTRY VARCHAR);

INSERT INTO PERSON (NAME, AGE, COUNTRY) VALUES ('rei', 10, 'US');
INSERT INTO PERSON (NAME, AGE, COUNTRY) VALUES ('東京', 20, 'JP');
INSERT INTO PERSON (NAME, AGE, COUNTRY) VALUES ('max', 25, 'US');
INSERT INTO PERSON (NAME, AGE, COUNTRY) VALUES ('lee', 33, 'KR');
