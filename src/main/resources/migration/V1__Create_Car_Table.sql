CREATE TABLE transaction ( transaction_id VARCHAR(255) PRIMARY KEY, sender_account VARCHAR(50) NOT NULL CHECK (sender_account ~ '^[a-zA-Z0-9]+$'), receiver_account VARCHAR(50) NOT NULL CHECK (receiver_account ~ '^[a-zA-Z0-9]+$'), amount DECIMAL(10,2) NOT NULL CHECK (amount > 0), currency VARCHAR(10) NOT NULL, status VARCHAR(20) NOT NULL CHECK (status IN ('PENDING', 'SUCCESS', 'FAILED')), timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP );