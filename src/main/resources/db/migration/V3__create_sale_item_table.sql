CREATE TABLE sale_item(
    id BIGSERIAL PRIMARY KEY,

    sale_id BIGINT NOT NULL,
    produce_id UUID NOT NULL,
    name VARCHAR(60) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,

    CONSTRAINT fk
                      FOREIGN KEY (sale_id)
                      REFERENCES sale(id)
                      ON DELETE CASCADE
);

CREATE INDEX idx_sale_created_at ON sale(created_at);
CREATE INDEX idx_sale_item_sale_id ON sale_item(sale_id);
CREATE INDEX idx_sale_item_produce_id ON sale_item(produce_id);