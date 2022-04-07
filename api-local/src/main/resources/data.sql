DROP TABLE IF EXISTS employees;
 
CREATE TABLE EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  FIRST_NAME VARCHAR(250) NOT NULL,
  LAST_NAME VARCHAR(250) NOT NULL,
  mail VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
 
INSERT INTO EMPLOYEES (FIRST_NAME, LAST_NAME, mail, password) VALUES
  ('Sophie', 'FONCEK', 'sophiefoncek@mail.com', 'sophie'),
  ('Agathe', 'FEELING', 'agathefeeling@mail.com', 'agathe'),
  ('Laurent', 'GINA', 'laurentgina@mail.com', 'laurent');
  
  