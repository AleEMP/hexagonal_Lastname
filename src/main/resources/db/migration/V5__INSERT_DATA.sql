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
INSERT INTO users (name, father_lastname, email, password, enabled, role_id, dni, age, phone)
VALUES (
    'Admin',
    'User',
    'admin@hexagonal-demo.com',
    '$2a$12$gBpsIP1vjx4scbpkKgh8w.LA2n0zOie4S86mSJ6D/ByjKdAInZOG2',
    TRUE,
    2,
    '16516521',
    25,
    '957046510'
),
(
    'Test',
    'User',
    'testuser@example.com',
    -- Contraseña 'user123' encriptada con BCrypt
    '$2a$10$E25m/nF3j6f1zZ5.4I6Qk.iPqf.7Y4T4T6k3R2g8Z2e9T6n3S5m7O',
    true,
    1,
    '98765432',
    25,
    '987654321'
),
(
    'Test',
    'Monitor',
    'monitor@example.com',
    -- Contraseña 'monitor123' encriptada con BCrypt
    '$2a$10$w.M9yA5s0fT8h.Q8fV9v6u8N2c3b5E4D1t7g9k0l2m4n6o8p0q2r',
    true,
    3,
    '87654321',
    35,
    '987654322'
);
