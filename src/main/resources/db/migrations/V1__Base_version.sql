CREATE TABLE IF NOT EXISTS public.specialtyEntity
(
    specialty_id   BIGSERIAL NOT NULL,
    specialty_name VARCHAR(255),
    status         SMALLINT,
    PRIMARY KEY (specialty_id)
);

CREATE TABLE IF NOT EXISTS public.developers
(
    developer_id BIGSERIAL    NOT NULL PRIMARY KEY,
    first_name   VARCHAR(255) NOT NULL,
    last_name    VARCHAR(255) NOT NULL,
    status       SMALLINT,
    specialty_id BIGINT,
    CONSTRAINT fk_specialty_id FOREIGN KEY (specialty_id) REFERENCES specialtyEntity
);

CREATE TABLE IF NOT EXISTS public.skillEntity
(
    skill_id   BIGSERIAL    NOT NULL,
    skill_name VARCHAR(255) NOT NULL,
    status     SMALLINT,
    PRIMARY KEY (skill_id)
);

CREATE TABLE IF NOT EXISTS public.developers_skills
(
    developers_skills_developer_id BIGINT NOT NULL,
    developers_skills_skill_id     BIGINT NOT NULL,
    CONSTRAINT fk_developers_skills_developer_id FOREIGN KEY (developers_skills_developer_id) REFERENCES developers
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fr_developers_skills_skill_id FOREIGN KEY (developers_skills_skill_id) REFERENCES skillEntity
        ON DELETE CASCADE ON UPDATE CASCADE
);