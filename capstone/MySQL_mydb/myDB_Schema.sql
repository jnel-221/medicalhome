USE mydb;


CREATE TABLE user(
id INT NOT NULL AUTO_INCREMENT,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(45) NOT NULL,
email VARCHAR(55) NOT NULL UNIQUE,
img_url VARCHAR(60),
acct_type VARCHAR(15),
specialty VARCHAR(75),
credential VARCHAR(10),
password VARCHAR(150),
create_date TIMESTAMP,
PRIMARY KEY (id)
);

CREATE TABLE conversation (
id INT NOT NULL AUTO_INCREMENT,
subject VARCHAR(75),
create_date TIMESTAMP,
PRIMARY KEY (id)
);

CREATE TABLE message (
id INT NOT NULL AUTO_INCREMENT,
conv_id INT,
user_id INT,
message TEXT,
create_date TIMESTAMP,
PRIMARY KEY (id),
FOREIGN KEY (conv_id) REFERENCES conversation (id),
FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE user_conversation(
user_id INT,
conv_id INT,
create_date TIMESTAMP,
FOREIGN KEY (user_id) REFERENCES user (id),
FOREIGN KEY (conv_id) REFERENCES conversation (id)
);

CREATE TABLE user_roles (
id INT NOT NULL AUTO_INCREMENT,
role_name VARCHAR(30),
user_id INT,
create_date TIMESTAMP,
PRIMARY KEY (id),
FOREIGN KEY (user_id) REFERENCES user (id)
);
