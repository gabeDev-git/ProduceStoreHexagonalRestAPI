package com.gabeDev.hexagonalAPI.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProduceDetails(UUID id, String name, BigDecimal price, int quantity,
                             LocalDateTime createdAt, LocalDateTime updatedAt) {
}
