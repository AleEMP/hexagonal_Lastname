-- ============================================================================
-- V5__INSERT_DATA.sql
-- Description: Insert initial seed data for development and testing
-- ============================================================================

-- Insert sample users with USER role
INSERT INTO users (name, father_lastname, mother_lastname, email, dni, phone, age, provider, enabled, role_id)
VALUES
    ('David', 'Galvez', 'Rojas', 'david.galvez@example.com', '71234567', '987654321', 35, 'LOCAL', TRUE, 1),
    ('Rocio', 'Chavez', NULL, 'rocio.chavez@example.com', '72345678', '912345678', 33, 'LOCAL', TRUE, 1),
    ('Pedro', 'Acosta', 'Mendoza', 'pedro.acosta@example.com', '73456789', '923456789', 40, 'LOCAL', TRUE, 1),
    ('Marisol', 'Ugarte', 'Flores', 'marisol.ugarte@example.com', '74567890', NULL, 25, 'LOCAL', TRUE, 1),
    ('Juan', 'Diaz', 'Paredes', 'juan.diaz@example.com', '75678901', '945678901', 27, 'LOCAL', FALSE, 1);

-- Insert admin user with hashed password (admin123)
INSERT INTO users (name, father_lastname, email, password, provider, enabled, role_id, created_at)
VALUES (
    'Admin',
    'User',
    'admin@hexagonal-demo.com',
    '$2a$12$gBpsIP1vjx4scbpkKgh8w.LA2n0zOie4S86mSJ6D/ByjKdAInZOG2',
    'LOCAL',
    TRUE,
    2,
    CURRENT_TIMESTAMP
);