-- create parent tables

CREATE TABLE author
(
    author_id       INT PRIMARY KEY,
    author_name     VARCHAR(30),
    author_img_path varchar(50)
);

CREATE TABLE chord
(
    chord_name     VARCHAR(10) PRIMARY KEY,
    chord_img_path VARCHAR(50)
);

CREATE TABLE difficult_level
(
    difficult_level_id   INT PRIMARY KEY,
    difficult_level_name VARCHAR(10)
);

CREATE TABLE genre
(
    genre_id   INT PRIMARY KEY,
    genre_name VARCHAR(15)
);

CREATE TABLE tuning_instrument
(
    tuning VARCHAR(10) PRIMARY KEY
);

CREATE TABLE languages
(
    language_id   INT PRIMARY KEY,
    language_name VARCHAR(15)
);

CREATE TABLE section_type
(
    section_type_id   INT PRIMARY KEY,
    section_type_name VARCHAR(6)
);

CREATE TABLE strumming_pattern
(
    strumming_pattern_id       INT PRIMARY KEY,
    strumming_pattern_name     VARCHAR(20),
    strumming_pattern_img_path VARCHAR(50)
);

-- create main table - song

CREATE TABLE song
(
    song_id            INT PRIMARY KEY,
    song_post_date     TIMESTAMP,
    song_lyrics        TEXT,
    song_name          VARCHAR(20),
    author_id          INT REFERENCES author (author_id),
    difficult_level_id INT REFERENCES difficult_level (difficult_level_id),
    section_type_id    INT REFERENCES section_type (section_type_id),
    tuning             VARCHAR(10) REFERENCES tuning_instrument (tuning)
);

-- create many-to-many tables

CREATE TABLE song_chords
(
    song_id  INT REFERENCES song (song_id),
    chord_name VARCHAR(10) REFERENCES chord (chord_name)
);

CREATE TABLE song_genre
(
    song_id  INT REFERENCES song (song_id),
    genre_id INT REFERENCES genre (genre_id)
);

CREATE TABLE song_language
(
    song_id     INT REFERENCES song (song_id),
    language_id INT REFERENCES languages (language_id)
);

CREATE TABLE song_strumming_pattern
(
    song_id              INT REFERENCES song (song_id),
    strumming_pattern_id INT REFERENCES strumming_pattern (strumming_pattern_id)
);
