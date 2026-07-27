package com.example.logistics.dto;
import jakarta.validation.constraints.*; 
import java.math.BigDecimal;
public record InventoryRequest(@NotBlank String itemName,@NotBlank String sku,@NotNull @PositiveOrZero Integer quantity,@NotNull @Positive BigDecimal unitPrice,@NotNull @Positive Long warehouseId) {}
