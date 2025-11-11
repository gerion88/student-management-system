CREATE TABLE groups (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  year SMALLINT NOT NULL
);

CREATE TABLE students (
  id BIGSERIAL PRIMARY KEY,
  first_name VARCHAR(64) NOT NULL,
  last_name VARCHAR(64) NOT NULL,
  birth_date DATE,
  email VARCHAR(120) UNIQUE,
  phone VARCHAR(32),
  group_id BIGINT REFERENCES groups(id)
);
