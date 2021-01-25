CREATE TABLE role
(
    role_id   INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    role_name VARCHAR(10)
);

CREATE TABLE user_form
(
    user_id  INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    nickname VARCHAR(30),
    email    VARCHAR(50) UNIQUE,
    password VARCHAR(60),
    role_id  INT REFERENCES role (role_id),
    avatar   VARCHAR(50),
    reg_date TIMESTAMP
);
