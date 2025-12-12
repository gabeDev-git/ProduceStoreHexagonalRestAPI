package com.gabeDev.hexagonalAPI.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CreateProduceRequest(@NotBlank @Size(max = 60) String name,
                                   @NotNull BigDecimal price,
                                   @NotNull int quantity) {
}
