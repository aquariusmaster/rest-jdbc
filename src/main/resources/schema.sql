DROP TABLE IF EXISTS contacts;
CREATE TABLE contacts (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  phone VARCHAR(100) NOT NULL,
  PRIMARY KEY (id));