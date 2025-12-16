package com.gabeDev.hexagonalAPI.application.dto;

import com.gabeDev.hexagonalAPI.domain.model.PaymentMethod;

import java.util.HashMap;
import java.util.UUID;

public record CreateSaleRequest(HashMap<UUID, Integer> checkoutMap, PaymentMethod paymentMethod) {
}
