CREATE TABLE merchants (
    id             UUID         PRIMARY KEY DEFAULT gen_random_uuid(),
    name           VARCHAR(255) NOT NULL,
    email          VARCHAR(255) NOT NULL UNIQUE,
    api_key_prefix VARCHAR(16)  NOT NULL,
    api_key_hash   VARCHAR(64)  NOT NULL UNIQUE,
    active         BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at     TIMESTAMPTZ  NOT NULL DEFAULT now()
);