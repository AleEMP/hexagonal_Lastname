-- ============================================================================
-- V1__CREATE_TABLES.sql
-- Description: Initial database schema - Creates base users table
-- ============================================================================

CREATE TABLE users (
                       id BIGINT NOT NULL AUTO_INCREMENT,
                       name VARCHAR(100) NOT NULL,
                       father_lastname VARCHAR(100) NOT NULL,
                       mother_lastname VARCHAR(100),
                       email VARCHAR(150) NOT NULL UNIQUE,
                       dni VARCHAR(8) UNIQUE,
                       phone VARCHAR(9),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                       version INT DEFAULT 0,
                       age INT,
                       PRIMARY KEY (id)
);

-- Add comment to table
ALTER TABLE users COMMENT = 'User accounts for hexagonal architecture';
