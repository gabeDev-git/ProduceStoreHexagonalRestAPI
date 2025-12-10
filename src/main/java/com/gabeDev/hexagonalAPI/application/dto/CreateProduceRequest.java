package com.gabeDev.hexagonalAPI.application.dto;

import java.math.BigDecimal;

public record CreateProduceRequest(String name, BigDecimal price, int quantity) {
}
