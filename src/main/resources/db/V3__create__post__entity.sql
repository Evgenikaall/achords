CREATE TABLE post
(
    post_id INT PRIMARY KEY,
    song_id INT REFERENCES model.song (song_id) UNIQUE,
    user_id INT REFERENCES "user".user_form (user_id) UNIQUE,
    views   INT DEFAULT 0
);

CREATE TABLE comments
(
    comment_id INT PRIMARY KEY,
    comment    TEXT,
    user_id    INT REFERENCES "user".user_form (user_id)
);

CREATE TABLE post_comments
(
    post_id    INT REFERENCES post (post_id),
    comment_id INT REFERENCES comments (comment_id)
);
