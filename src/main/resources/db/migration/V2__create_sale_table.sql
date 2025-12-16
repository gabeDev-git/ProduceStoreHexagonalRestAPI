CREATE TABLE sale(
    id BIGSERIAL PRIMARY KEY,

    sale_id UUID NOT NULL UNIQUE,
    payment_method VARCHAR(10) NOT NULL,
    total DECIMAL(12, 2) NOT NULL CHECK (total >= 0),
    created_at TIMESTAMP NOT NULL

);