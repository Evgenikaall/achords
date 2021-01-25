CREATE TABLE role
(
    role_id   INT PRIMARY KEY,
    role_name VARCHAR(10)
);

CREATE TABLE user_form
(
    user_id  INT PRIMARY KEY,
    email    VARCHAR(50),
    password VARCHAR(60),
    avatar   VARCHAR(50)
);

CREATE TABLE user_role
(
    user_id INT REFERENCES user_form (user_id),
    role_id INT REFERENCES role (role_id),
    PRIMARY KEY (user_id, role_id)
);
