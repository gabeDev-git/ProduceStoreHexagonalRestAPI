CREATE TABLE produce(
    id BIGSERIAL PRIMARY KEY,
    produce_id UUID NOT NULL UNIQUE,
    name VARCHAR(60) NOT NULL UNIQUE,
    price DECIMAL(10, 2) NOT NULL ,
    quantity INT NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE INDEX idx_produce_domain_id ON produce(produce_id);
CREATE INDEX idx_produce_name ON produce(name);