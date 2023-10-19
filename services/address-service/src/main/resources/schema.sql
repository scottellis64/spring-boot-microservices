CREATE TABLE address (
 id INT AUTO_INCREMENT PRIMARY KEY,
 city VARCHAR(45),
 state VARCHAR(45),
 employee_id INT,
 FOREIGN KEY (employee_id) REFERENCES employee(id)
);

insert into address (city, state, employee_id) values ('Littleton', 'Massachusetts', 1);
insert into address (city, state, employee_id) values ('Boston', 'Massachusetts', 2);