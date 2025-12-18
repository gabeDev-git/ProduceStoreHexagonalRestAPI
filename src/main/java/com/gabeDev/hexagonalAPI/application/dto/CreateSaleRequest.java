package com.gabeDev.hexagonalAPI.application.dto;

import com.gabeDev.hexagonalAPI.domain.model.PaymentMethod;
import jakarta.validation.constraints.NotNull;

import java.util.HashMap;
import java.util.UUID;

public record CreateSaleRequest(@NotNull HashMap<UUID, Integer> checkoutMap,
                                @NotNull PaymentMethod paymentMethod) {
}
