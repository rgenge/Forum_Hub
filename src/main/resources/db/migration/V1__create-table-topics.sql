CREATE TABLE topics
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    title         VARCHAR(255) NOT NULL,
    message       TEXT         NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    state         VARCHAR(50),
    author        VARCHAR(255) NOT NULL,
    course        VARCHAR(255) NOT NULL
);
