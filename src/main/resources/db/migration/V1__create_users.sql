CREATE TABLE users (
    id                BIGSERIAL PRIMARY KEY,
    name              VARCHAR(255),
    password          VARCHAR(255),
    email             VARCHAR(255),
    phone             VARCHAR(255),
    is_platform_admin BOOLEAN NOT NULL DEFAULT FALSE,
    is_active         BOOLEAN NOT NULL DEFAULT TRUE
);
